/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carcare.controller;

import carcare.controller.exceptions.NonexistentEntityException;
import carcare.controller.exceptions.PreexistingEntityException;
import carcare.model.Logfile;
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
public class LogfileJpaController implements Serializable {

    public LogfileJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Logfile logfile) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(logfile);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLogfile(logfile.getId()) != null) {
                throw new PreexistingEntityException("Logfile " + logfile + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Logfile logfile) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            logfile = em.merge(logfile);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = logfile.getId();
                if (findLogfile(id) == null) {
                    throw new NonexistentEntityException("The logfile with id " + id + " no longer exists.");
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
            Logfile logfile;
            try {
                logfile = em.getReference(Logfile.class, id);
                logfile.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The logfile with id " + id + " no longer exists.", enfe);
            }
            em.remove(logfile);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Logfile> findLogfileEntities() {
        return findLogfileEntities(true, -1, -1);
    }

    public List<Logfile> findLogfileEntities(int maxResults, int firstResult) {
        return findLogfileEntities(false, maxResults, firstResult);
    }

    private List<Logfile> findLogfileEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Logfile.class));
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

    public Logfile findLogfile(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Logfile.class, id);
        } finally {
            em.close();
        }
    }

    public int getLogfileCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Logfile> rt = cq.from(Logfile.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
