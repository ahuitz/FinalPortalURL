/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Tablas.CursoHasCiclo;
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
public class CursoHasCicloJpaController implements Serializable {

    public CursoHasCicloJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CursoHasCiclo cursoHasCiclo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cursoHasCiclo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CursoHasCiclo cursoHasCiclo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cursoHasCiclo = em.merge(cursoHasCiclo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cursoHasCiclo.getId();
                if (findCursoHasCiclo(id) == null) {
                    throw new NonexistentEntityException("The cursoHasCiclo with id " + id + " no longer exists.");
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
            CursoHasCiclo cursoHasCiclo;
            try {
                cursoHasCiclo = em.getReference(CursoHasCiclo.class, id);
                cursoHasCiclo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cursoHasCiclo with id " + id + " no longer exists.", enfe);
            }
            em.remove(cursoHasCiclo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CursoHasCiclo> findCursoHasCicloEntities() {
        return findCursoHasCicloEntities(true, -1, -1);
    }

    public List<CursoHasCiclo> findCursoHasCicloEntities(int maxResults, int firstResult) {
        return findCursoHasCicloEntities(false, maxResults, firstResult);
    }

    private List<CursoHasCiclo> findCursoHasCicloEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CursoHasCiclo.class));
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

    public CursoHasCiclo findCursoHasCiclo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CursoHasCiclo.class, id);
        } finally {
            em.close();
        }
    }

    public int getCursoHasCicloCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CursoHasCiclo> rt = cq.from(CursoHasCiclo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
