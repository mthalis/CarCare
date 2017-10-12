/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carcare.controller;

import carcare.controller.exceptions.NonexistentEntityException;
import carcare.model.Custdata;
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
public class CustdataJpaController implements Serializable {

    public CustdataJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Custdata custdata) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(custdata);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Custdata custdata) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            custdata = em.merge(custdata);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = custdata.getId();
                if (findCustdata(id) == null) {
                    throw new NonexistentEntityException("The custdata with id " + id + " no longer exists.");
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
            Custdata custdata;
            try {
                custdata = em.getReference(Custdata.class, id);
                custdata.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The custdata with id " + id + " no longer exists.", enfe);
            }
            em.remove(custdata);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Custdata> findCustdataEntities() {
        return findCustdataEntities(true, -1, -1);
    }

    public List<Custdata> findCustdataEntities(int maxResults, int firstResult) {
        return findCustdataEntities(false, maxResults, firstResult);
    }

    private List<Custdata> findCustdataEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Custdata.class));
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

    public Custdata findCustdata(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Custdata.class, id);
        } finally {
            em.close();
        }
    }

    public int getCustdataCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Custdata> rt = cq.from(Custdata.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Custdata> findCustdataByVno(String Vno) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT c FROM Custdata c WHERE c.vno = :vno", Custdata.class);
            query.setParameter("vno", Vno);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
}
