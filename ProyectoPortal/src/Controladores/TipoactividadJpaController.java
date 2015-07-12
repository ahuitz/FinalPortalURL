/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Tablas.Tipoactividad;
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
public class TipoactividadJpaController implements Serializable {

    public TipoactividadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tipoactividad tipoactividad) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoactividad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tipoactividad tipoactividad) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipoactividad = em.merge(tipoactividad);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tipoactividad.getId();
                if (findTipoactividad(id) == null) {
                    throw new NonexistentEntityException("The tipoactividad with id " + id + " no longer exists.");
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
            Tipoactividad tipoactividad;
            try {
                tipoactividad = em.getReference(Tipoactividad.class, id);
                tipoactividad.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoactividad with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoactividad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tipoactividad> findTipoactividadEntities() {
        return findTipoactividadEntities(true, -1, -1);
    }

    public List<Tipoactividad> findTipoactividadEntities(int maxResults, int firstResult) {
        return findTipoactividadEntities(false, maxResults, firstResult);
    }

    private List<Tipoactividad> findTipoactividadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tipoactividad.class));
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

    public Tipoactividad findTipoactividad(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tipoactividad.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoactividadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tipoactividad> rt = cq.from(Tipoactividad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
