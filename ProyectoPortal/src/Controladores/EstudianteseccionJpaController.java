/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Tablas.Estudianteseccion;
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
public class EstudianteseccionJpaController implements Serializable {

    public EstudianteseccionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Estudianteseccion estudianteseccion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(estudianteseccion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Estudianteseccion estudianteseccion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            estudianteseccion = em.merge(estudianteseccion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = estudianteseccion.getId();
                if (findEstudianteseccion(id) == null) {
                    throw new NonexistentEntityException("The estudianteseccion with id " + id + " no longer exists.");
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
            Estudianteseccion estudianteseccion;
            try {
                estudianteseccion = em.getReference(Estudianteseccion.class, id);
                estudianteseccion.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estudianteseccion with id " + id + " no longer exists.", enfe);
            }
            em.remove(estudianteseccion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Estudianteseccion> findEstudianteseccionEntities() {
        return findEstudianteseccionEntities(true, -1, -1);
    }

    public List<Estudianteseccion> findEstudianteseccionEntities(int maxResults, int firstResult) {
        return findEstudianteseccionEntities(false, maxResults, firstResult);
    }

    private List<Estudianteseccion> findEstudianteseccionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Estudianteseccion.class));
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

    public Estudianteseccion findEstudianteseccion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Estudianteseccion.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstudianteseccionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Estudianteseccion> rt = cq.from(Estudianteseccion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
