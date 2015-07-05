/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Tablas.Tdetalleasignacionvip;
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
 * @author Cliente
 */
public class TdetalleasignacionvipJpaController implements Serializable {

    public TdetalleasignacionvipJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tdetalleasignacionvip tdetalleasignacionvip) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tdetalleasignacionvip);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tdetalleasignacionvip tdetalleasignacionvip) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tdetalleasignacionvip = em.merge(tdetalleasignacionvip);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tdetalleasignacionvip.getId();
                if (findTdetalleasignacionvip(id) == null) {
                    throw new NonexistentEntityException("The tdetalleasignacionvip with id " + id + " no longer exists.");
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
            Tdetalleasignacionvip tdetalleasignacionvip;
            try {
                tdetalleasignacionvip = em.getReference(Tdetalleasignacionvip.class, id);
                tdetalleasignacionvip.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tdetalleasignacionvip with id " + id + " no longer exists.", enfe);
            }
            em.remove(tdetalleasignacionvip);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tdetalleasignacionvip> findTdetalleasignacionvipEntities() {
        return findTdetalleasignacionvipEntities(true, -1, -1);
    }

    public List<Tdetalleasignacionvip> findTdetalleasignacionvipEntities(int maxResults, int firstResult) {
        return findTdetalleasignacionvipEntities(false, maxResults, firstResult);
    }

    private List<Tdetalleasignacionvip> findTdetalleasignacionvipEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tdetalleasignacionvip.class));
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

    public Tdetalleasignacionvip findTdetalleasignacionvip(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tdetalleasignacionvip.class, id);
        } finally {
            em.close();
        }
    }

    public int getTdetalleasignacionvipCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tdetalleasignacionvip> rt = cq.from(Tdetalleasignacionvip.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
