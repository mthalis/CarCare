/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carcare.controller;

import carcare.exceptions.NonexistentEntityException;
import carcare.model.Chksht;
import java.io.Serializable;
import java.util.Date;
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
public class ChkshtJpaController implements Serializable {

    public ChkshtJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Chksht chksht) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(chksht);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Chksht chksht) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            chksht = em.merge(chksht);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = chksht.getId();
                if (findChksht(id) == null) {
                    throw new NonexistentEntityException("The chksht with id " + id + " no longer exists.");
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
            Chksht chksht;
            try {
                chksht = em.getReference(Chksht.class, id);
                chksht.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The chksht with id " + id + " no longer exists.", enfe);
            }
            em.remove(chksht);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Chksht> findChkshtEntities() {
        return findChkshtEntities(true, -1, -1);
    }

    public List<Chksht> findChkshtEntities(int maxResults, int firstResult) {
        return findChkshtEntities(false, maxResults, firstResult);
    }

    private List<Chksht> findChkshtEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Chksht.class));
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

    public Chksht findChksht(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Chksht.class, id);
        } finally {
            em.close();
        }
    }

    public int getChkshtCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Chksht> rt = cq.from(Chksht.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Object[]> getChkshtList(int maxResults, int firstResult){
        EntityManager em = getEntityManager();
        try {
            Query query = em.createNativeQuery("SELECT a.VNO, b.name, b.ADDRESS,a.date FROM chksht a JOIN custdata b ON a.VNO = b.VNO");
            query.setMaxResults(maxResults);
            query.setFirstResult(firstResult);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Object[]> getChkshtListByVNo(String vNo) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createNativeQuery("SELECT a.VNO, b.name, b.ADDRESS,a.date FROM chksht a JOIN custdata b ON a.VNO = b.VNO where a.VNO = ? ");
            query.setParameter(1, vNo);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    public List<Chksht> getChkshtListByVnoDate(String vNo, Date date){
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT c FROM Chksht c where c.vno = :vno and c.date = :date", Chksht.class);
            query.setParameter("vno", vNo);
            query.setParameter("date", date);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
