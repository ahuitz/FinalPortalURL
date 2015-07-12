/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Tablas.Carrerausuario;
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
public class CarrerausuarioJpaController implements Serializable {

    public CarrerausuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Carrerausuario carrerausuario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(carrerausuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Carrerausuario carrerausuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            carrerausuario = em.merge(carrerausuario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = carrerausuario.getId();
                if (findCarrerausuario(id) == null) {
                    throw new NonexistentEntityException("The carrerausuario with id " + id + " no longer exists.");
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
            Carrerausuario carrerausuario;
            try {
                carrerausuario = em.getReference(Carrerausuario.class, id);
                carrerausuario.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The carrerausuario with id " + id + " no longer exists.", enfe);
            }
            em.remove(carrerausuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Carrerausuario> findCarrerausuarioEntities() {
        return findCarrerausuarioEntities(true, -1, -1);
    }

    public List<Carrerausuario> findCarrerausuarioEntities(int maxResults, int firstResult) {
        return findCarrerausuarioEntities(false, maxResults, firstResult);
    }

    private List<Carrerausuario> findCarrerausuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Carrerausuario.class));
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

    public Carrerausuario findCarrerausuario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Carrerausuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getCarrerausuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Carrerausuario> rt = cq.from(Carrerausuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
