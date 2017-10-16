/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carcare.controller;

import carcare.controller.exceptions.NonexistentEntityException;
import carcare.model.Billccc;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Dinesh
 */
public class BillcccJpaController implements Serializable {

    public BillcccJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Billccc billccc) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(billccc);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
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
            cq.select(cq.from(Billccc.class));
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
    
    public List<Billccc> findBillcccByVno(String Vno) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT c FROM Billccc c WHERE c.vno = :vno order by c.billNo desc", Billccc.class);
            query.setParameter("vno", Vno);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
}
