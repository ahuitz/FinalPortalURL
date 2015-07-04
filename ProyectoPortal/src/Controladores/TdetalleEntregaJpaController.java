/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Tablas.TdetalleEntrega;
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
 * @author Rosario
 */
public class TdetalleEntregaJpaController implements Serializable {

    public TdetalleEntregaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TdetalleEntrega tdetalleEntrega) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tdetalleEntrega);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TdetalleEntrega tdetalleEntrega) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tdetalleEntrega = em.merge(tdetalleEntrega);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tdetalleEntrega.getId();
                if (findTdetalleEntrega(id) == null) {
                    throw new NonexistentEntityException("The tdetalleEntrega with id " + id + " no longer exists.");
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
            TdetalleEntrega tdetalleEntrega;
            try {
                tdetalleEntrega = em.getReference(TdetalleEntrega.class, id);
                tdetalleEntrega.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tdetalleEntrega with id " + id + " no longer exists.", enfe);
            }
            em.remove(tdetalleEntrega);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TdetalleEntrega> findTdetalleEntregaEntities() {
        return findTdetalleEntregaEntities(true, -1, -1);
    }

    public List<TdetalleEntrega> findTdetalleEntregaEntities(int maxResults, int firstResult) {
        return findTdetalleEntregaEntities(false, maxResults, firstResult);
    }

    private List<TdetalleEntrega> findTdetalleEntregaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TdetalleEntrega.class));
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

    public TdetalleEntrega findTdetalleEntrega(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TdetalleEntrega.class, id);
        } finally {
            em.close();
        }
    }

    public int getTdetalleEntregaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TdetalleEntrega> rt = cq.from(TdetalleEntrega.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
