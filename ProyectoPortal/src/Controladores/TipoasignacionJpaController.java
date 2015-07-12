/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Tablas.Tipoasignacion;
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
public class TipoasignacionJpaController implements Serializable {

    public TipoasignacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tipoasignacion tipoasignacion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoasignacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tipoasignacion tipoasignacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipoasignacion = em.merge(tipoasignacion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tipoasignacion.getId();
                if (findTipoasignacion(id) == null) {
                    throw new NonexistentEntityException("The tipoasignacion with id " + id + " no longer exists.");
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
            Tipoasignacion tipoasignacion;
            try {
                tipoasignacion = em.getReference(Tipoasignacion.class, id);
                tipoasignacion.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoasignacion with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoasignacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tipoasignacion> findTipoasignacionEntities() {
        return findTipoasignacionEntities(true, -1, -1);
    }

    public List<Tipoasignacion> findTipoasignacionEntities(int maxResults, int firstResult) {
        return findTipoasignacionEntities(false, maxResults, firstResult);
    }

    private List<Tipoasignacion> findTipoasignacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tipoasignacion.class));
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

    public Tipoasignacion findTipoasignacion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tipoasignacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoasignacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tipoasignacion> rt = cq.from(Tipoasignacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
