/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Tablas.Carreraasignacion;
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
public class CarreraasignacionJpaController implements Serializable {

    public CarreraasignacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Carreraasignacion carreraasignacion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(carreraasignacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Carreraasignacion carreraasignacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            carreraasignacion = em.merge(carreraasignacion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = carreraasignacion.getId();
                if (findCarreraasignacion(id) == null) {
                    throw new NonexistentEntityException("The carreraasignacion with id " + id + " no longer exists.");
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
            Carreraasignacion carreraasignacion;
            try {
                carreraasignacion = em.getReference(Carreraasignacion.class, id);
                carreraasignacion.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The carreraasignacion with id " + id + " no longer exists.", enfe);
            }
            em.remove(carreraasignacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Carreraasignacion> findCarreraasignacionEntities() {
        return findCarreraasignacionEntities(true, -1, -1);
    }

    public List<Carreraasignacion> findCarreraasignacionEntities(int maxResults, int firstResult) {
        return findCarreraasignacionEntities(false, maxResults, firstResult);
    }

    private List<Carreraasignacion> findCarreraasignacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Carreraasignacion.class));
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

    public Carreraasignacion findCarreraasignacion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Carreraasignacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getCarreraasignacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Carreraasignacion> rt = cq.from(Carreraasignacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
