/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carcare.controller;

import carcare.controller.exceptions.NonexistentEntityException;
import carcare.model.User;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author lenovo
 */
public class UserJpaController implements Serializable {

    private static final Logger logger = Logger.getLogger(UserJpaController.class);
    
    public UserJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(User user) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(User user) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            user = em.merge(user);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = user.getId();
                if (findUser(id) == null) {
                    throw new NonexistentEntityException("The user with id " + id + " no longer exists.");
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
            User user;
            try {
                user = em.getReference(User.class, id);
                user.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The user with id " + id + " no longer exists.", enfe);
            }
            em.remove(user);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<User> findUserEntities() {
        return findUserEntities(true, -1, -1);
    }

    public List<User> findUserEntities(int maxResults, int firstResult) {
        return findUserEntities(false, maxResults, firstResult);
    }

    private List<User> findUserEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(User.class));
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

    public User findUser(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(User.class, id);
        } finally {
            em.close();
        }
    }

    public int getUserCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<User> rt = cq.from(User.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public boolean userAvailable(String userName){
        boolean isUserAvailable = false;
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT u FROM User u WHERE u.username = :username ");
            query.setParameter("username", userName);
            int customerSize =  query.getResultList().size();
            if(customerSize > 0){
                isUserAvailable = true;
            }
            em.getTransaction().commit();
            logger.debug("userAvailable -> " + isUserAvailable);
       }catch(Exception e){
            logger.fatal("Error Occured while checking userAvailable -> " + e);
       }
       return isUserAvailable;
    }
    
    public void resetPwd(String userName){
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            String pw = DigestUtils.sha256Hex("123456");
            Query query = em.createQuery("UPDATE User u set u.password = :password WHERE u.username = :username ");
            query.setParameter("username", userName);
            query.setParameter("password", pw);
            query.executeUpdate();
            em.getTransaction().commit();
       }catch(Exception e){
            logger.fatal("Error Occured while updating resetPwd -> " + e);
       }
    }
    
    public boolean authenticateUser(String userName, String pwd){
        boolean authenticated = false;
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            Query query = em.createQuery("select u.id from User u where u.username = :userName and u.password = :pwd and u.active = :status");
            query.setParameter("userName", userName);
            query.setParameter("pwd", pwd);
            query.setParameter("status", (short)1);
            int log = query.getResultList().size();
            em.getTransaction().commit();
            if(log > 0){
               authenticated = true;
            }
           logger.debug("authenticated -> " + authenticated);
       }catch(Exception e){
           logger.fatal("Error Occured while authenticateUser -> " + e);
       }
       return authenticated;
    }
    
    public int updateUser(User user){
        EntityManager em = getEntityManager();
        int outPut = 0;
        try{
            em.getTransaction().begin();
            Query query = em.createQuery("Update User set username= :username, "
                    + "password= :passwd");
            query.setParameter("username", user.getUsername());
            query.setParameter("passwd", user.getPassword());            
            outPut = query.executeUpdate();
            em.getTransaction().commit();
        }catch(Exception e){
            logger.fatal("Error Occured while Updating User -> " + e);
        }
        return outPut;
    }
    
}
