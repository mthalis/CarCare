/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carcare.controller;

import carcare.CarCare;
import carcare.controller.exceptions.NonexistentEntityException;
import carcare.model.Billccc;
import carcare.model.Custdata;
import carcare.model.Logfile;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.log4j.Logger;

/**
 *
 * @author Dinesh
 */
public class BillcccJpaController implements Serializable {

    private static final Logger logger = Logger.getLogger(BillcccJpaController.class);
    
    public BillcccJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public boolean create(Billccc billccc) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            
            Logfile logfile = em.find(Logfile.class, 1);
            
            if(billccc.getRePrint()){
                int billRNo = logfile.getRbillno();
                billRNo++;
                logfile.setRbillno(billRNo);

                billccc.setBillNo((double)billRNo);
            }else{
                int billcccNo = logfile.getCccbillno();
                billcccNo++;
                logfile.setCccbillno(billcccNo);

                billccc.setBillNo((double)billcccNo);
            }
            em.persist(billccc);
            
            Query query1 = em.createQuery("Select c.fmilage, c.jdate from Custdata c where c.vno = :vno ");
            query1.setParameter("vno", billccc.getVno());
            List<Object[]> outPut = query1.getResultList();
            
            if(outPut.size() > 0){           
                if( billccc.getMillage() > Double.parseDouble(outPut.get(0)[0].toString())){
                    Query query = em.createQuery("UPDATE Custdata c set c.ldate = :ldate , c.lmilage = :lmilage, c.fmilage = :fmilage, c.jdate = :jadte where c.vno = :vno ");
                    query.setParameter("jadte", new Timestamp(System.currentTimeMillis()));
                    query.setParameter("fmilage", billccc.getMillage());
                    query.setParameter("ldate", outPut.get(0)[1]);
                    query.setParameter("lmilage",outPut.get(0)[0] );
                    query.setParameter("vno", billccc.getVno());
                    query.executeUpdate();
                }
            }else{
                Custdata custdata= new Custdata(); 
                custdata.setVno(billccc.getVno().trim());
                custdata.setName(billccc.getName());
                custdata.setAddress(billccc.getAddress());                        
                custdata.setFmilage(billccc.getMillage());            
                custdata.setCredit(0.0);
                custdata.setDeDate(new Timestamp(System.currentTimeMillis()));
                custdata.setJdate(billccc.getDate());
                custdata.setLdate(billccc.getDate());
                custdata.setLmilage(billccc.getMillage());
                custdata.setPhone(billccc.getPhone());

                CustdataJpaController custdataJpaController = new CustdataJpaController(CarCare.EMF);
                custdataJpaController.create(custdata);
            }
            
            em.getTransaction().commit();
        }catch(Exception e){
            logger.warn("Error occured while create Billccc -> " + e);
            return false;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return true;
    }

    public void edit(Billccc billccc) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            billccc = em.merge(billccc);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = billccc.getId();
                if (findBillccc(id) == null) {
                    throw new NonexistentEntityException("The billccc with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Billccc billccc;
            try {
                billccc = em.getReference(Billccc.class, id);
                billccc.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The billccc with id " + id + " no longer exists.", enfe);
            }
            em.remove(billccc);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Billccc> findBillcccEntities() {
        return findBillcccEntities(true, -1, -1);
    }

    public List<Billccc> findBillcccEntities(int maxResults, int firstResult) {
        return findBillcccEntities(false, maxResults, firstResult);
    }

    private List<Billccc> findBillcccEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root root = cq.from(Billccc.class);
            cq.select(root);
            cq.where(em.getCriteriaBuilder().equal(root.get("rePrint"), false));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Billccc findBillccc(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Billccc.class, id);
        } finally {
            em.close();
        }
    }

    public int getBillcccCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Billccc> rt = cq.from(Billccc.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Billccc> findBillcccByVno(String vno, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT c FROM Billccc c WHERE c.vno = :vno and c.rePrint = 0 order by c.billNo desc", Billccc.class);
            query.setParameter("vno", vno);
            query.setMaxResults(maxResults);
            query.setFirstResult(firstResult);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    public Object[] getBillCCCAmountMilage(String vno, String date){
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT c.amount, c.millage FROM Billccc c WHERE c.vno = :vno and c.rePrint = false and c.date like CONCAT(:date,'%') order by c.date desc");
            query.setParameter("vno", vno);
            query.setParameter("date", date);
            if(null !=query.getResultList() && !query.getResultList().isEmpty()){
                return (Object[]) query.getResultList().get(0);
            }
        }catch(Exception e){
            logger.warn("Error occured in getBillCCCAmountMilage " + e);
        }finally {
            em.close();
        }
        return null;
    }
    
    public int getBillcccCount(String vno) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT count(c) FROM Billccc c WHERE c.vno = :vno order by c.billNo desc", Billccc.class);
            query.setParameter("vno", vno);
            return ((Long) query.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public int updateCusDetailsBillccc(String billNo, String name, String address, String phone) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("Update Billccc c set c.name = :name, c.address = :address, c.phone = :phone WHERE c.billNo = :billNo ");
            query.setParameter("billNo", Double.parseDouble(billNo));
            query.setParameter("name", name);
            query.setParameter("address", address);
            query.setParameter("phone", phone);
            int outPut = query.executeUpdate();
            em.getTransaction().commit();
            return outPut;
        }catch(Exception e){
            logger.warn("Error occured while updating updateCusDetailsBillccc " + e);
        } finally {
            em.close();
        }
        return 0;
    }
}
