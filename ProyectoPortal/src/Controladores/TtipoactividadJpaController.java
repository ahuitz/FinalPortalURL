/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Tablas.Ttipoactividad;
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
public class TtipoactividadJpaController implements Serializable {

    public TtipoactividadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ttipoactividad ttipoactividad) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ttipoactividad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ttipoactividad ttipoactividad) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ttipoactividad = em.merge(ttipoactividad);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ttipoactividad.getId();
                if (findTtipoactividad(id) == null) {
                    throw new NonexistentEntityException("The ttipoactividad with id " + id + " no longer exists.");
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
            Ttipoactividad ttipoactividad;
            try {
                ttipoactividad = em.getReference(Ttipoactividad.class, id);
                ttipoactividad.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ttipoactividad with id " + id + " no longer exists.", enfe);
            }
            em.remove(ttipoactividad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ttipoactividad> findTtipoactividadEntities() {
        return findTtipoactividadEntities(true, -1, -1);
    }

    public List<Ttipoactividad> findTtipoactividadEntities(int maxResults, int firstResult) {
        return findTtipoactividadEntities(false, maxResults, firstResult);
    }

    private List<Ttipoactividad> findTtipoactividadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ttipoactividad.class));
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

    public Ttipoactividad findTtipoactividad(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ttipoactividad.class, id);
        } finally {
            em.close();
        }
    }

    public int getTtipoactividadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ttipoactividad> rt = cq.from(Ttipoactividad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
