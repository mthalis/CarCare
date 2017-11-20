/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carcare.controller;

import carcare.controller.exceptions.NonexistentEntityException;
import carcare.model.Billcce;
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
 * @author lenovo
 */
public class BillcceJpaController implements Serializable {

    private static final Logger logger = Logger.getLogger(BillcceJpaController.class);
    
    public BillcceJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public boolean create(Billcce billcce) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            
            Logfile logfile = em.find(Logfile.class, 1);
            int billcceNo = logfile.getCcebillno();
            billcceNo++;
            logfile.setCcebillno(billcceNo);
            
            billcce.setBillNo((double)billcceNo);
            em.persist(billcce);
            
            Query query1 = em.createQuery("Select c.fmilage, c.jdate from Custdata c where c.vno = :vno ");
            query1.setParameter("vno", billcce.getVno());
            List<Object[]> outPut = query1.getResultList();
            
            Query query = em.createQuery("UPDATE Custdata c set c.ldate = :ldate , c.lmilage = :lmilage, c.fmilage = :fmilage, c.jdate = :jadte where c.vno = :vno ");
            query.setParameter("jadte", new Timestamp(System.currentTimeMillis()));
            query.setParameter("fmilage", billcce.getMillage());
            query.setParameter("ldate", outPut.get(0)[1]);
            query.setParameter("lmilage",outPut.get(0)[0] );
            query.setParameter("vno", billcce.getVno());
            query.executeUpdate();
        }catch(Exception e){
            logger.warn("Error occured while create Billcce -> " + e);
            return false;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return true;
    }

    public void edit(Billcce billcce) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            billcce = em.merge(billcce);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = billcce.getId();
                if (findBillcce(id) == null) {
                    throw new NonexistentEntityException("The billcce with id " + id + " no longer exists.");
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
            Billcce billcce;
            try {
                billcce = em.getReference(Billcce.class, id);
                billcce.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The billcce with id " + id + " no longer exists.", enfe);
            }
            em.remove(billcce);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Billcce> findBillcceEntities() {
        return findBillcceEntities(true, -1, -1);
    }

    public List<Billcce> findBillcceEntities(int maxResults, int firstResult) {
        return findBillcceEntities(false, maxResults, firstResult);
    }

    private List<Billcce> findBillcceEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Billcce.class));
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

    public Billcce findBillcce(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Billcce.class, id);
        } finally {
            em.close();
        }
    }

    public int getBillcceCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Billcce> rt = cq.from(Billcce.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Billcce> findBillcceByVno(String Vno) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT c FROM Billcce c WHERE c.vno = :vno order by c.billNo desc", Billcce.class);
            query.setParameter("vno", Vno);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
