/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Tablas.Ttipoasignacion;
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
public class TtipoasignacionJpaController implements Serializable {

    public TtipoasignacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ttipoasignacion ttipoasignacion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ttipoasignacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ttipoasignacion ttipoasignacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ttipoasignacion = em.merge(ttipoasignacion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ttipoasignacion.getId();
                if (findTtipoasignacion(id) == null) {
                    throw new NonexistentEntityException("The ttipoasignacion with id " + id + " no longer exists.");
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
            Ttipoasignacion ttipoasignacion;
            try {
                ttipoasignacion = em.getReference(Ttipoasignacion.class, id);
                ttipoasignacion.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ttipoasignacion with id " + id + " no longer exists.", enfe);
            }
            em.remove(ttipoasignacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ttipoasignacion> findTtipoasignacionEntities() {
        return findTtipoasignacionEntities(true, -1, -1);
    }

    public List<Ttipoasignacion> findTtipoasignacionEntities(int maxResults, int firstResult) {
        return findTtipoasignacionEntities(false, maxResults, firstResult);
    }

    private List<Ttipoasignacion> findTtipoasignacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ttipoasignacion.class));
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

    public Ttipoasignacion findTtipoasignacion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ttipoasignacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getTtipoasignacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ttipoasignacion> rt = cq.from(Ttipoasignacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
