/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Tablas.Entrega;
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
public class EntregaJpaController implements Serializable {

    public EntregaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Entrega entrega) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(entrega);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Entrega entrega) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            entrega = em.merge(entrega);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = entrega.getId();
                if (findEntrega(id) == null) {
                    throw new NonexistentEntityException("The entrega with id " + id + " no longer exists.");
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
            Entrega entrega;
            try {
                entrega = em.getReference(Entrega.class, id);
                entrega.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The entrega with id " + id + " no longer exists.", enfe);
            }
            em.remove(entrega);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Entrega> findEntregaEntities() {
        return findEntregaEntities(true, -1, -1);
    }

    public List<Entrega> findEntregaEntities(int maxResults, int firstResult) {
        return findEntregaEntities(false, maxResults, firstResult);
    }

    private List<Entrega> findEntregaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Entrega.class));
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

    public Entrega findEntrega(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Entrega.class, id);
        } finally {
            em.close();
        }
    }

    public int getEntregaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Entrega> rt = cq.from(Entrega.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
