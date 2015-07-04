/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Tablas.Tsubmodulo;
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
public class TsubmoduloJpaController implements Serializable {

    public TsubmoduloJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tsubmodulo tsubmodulo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tsubmodulo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tsubmodulo tsubmodulo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tsubmodulo = em.merge(tsubmodulo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tsubmodulo.getId();
                if (findTsubmodulo(id) == null) {
                    throw new NonexistentEntityException("The tsubmodulo with id " + id + " no longer exists.");
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
            Tsubmodulo tsubmodulo;
            try {
                tsubmodulo = em.getReference(Tsubmodulo.class, id);
                tsubmodulo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tsubmodulo with id " + id + " no longer exists.", enfe);
            }
            em.remove(tsubmodulo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tsubmodulo> findTsubmoduloEntities() {
        return findTsubmoduloEntities(true, -1, -1);
    }

    public List<Tsubmodulo> findTsubmoduloEntities(int maxResults, int firstResult) {
        return findTsubmoduloEntities(false, maxResults, firstResult);
    }

    private List<Tsubmodulo> findTsubmoduloEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tsubmodulo.class));
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

    public Tsubmodulo findTsubmodulo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tsubmodulo.class, id);
        } finally {
            em.close();
        }
    }

    public int getTsubmoduloCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tsubmodulo> rt = cq.from(Tsubmodulo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
