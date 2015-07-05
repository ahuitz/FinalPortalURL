/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Tablas.TseccionCursos;
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
public class TseccionCursosJpaController implements Serializable {

    public TseccionCursosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TseccionCursos tseccionCursos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tseccionCursos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TseccionCursos tseccionCursos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tseccionCursos = em.merge(tseccionCursos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tseccionCursos.getId();
                if (findTseccionCursos(id) == null) {
                    throw new NonexistentEntityException("The tseccionCursos with id " + id + " no longer exists.");
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
            TseccionCursos tseccionCursos;
            try {
                tseccionCursos = em.getReference(TseccionCursos.class, id);
                tseccionCursos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tseccionCursos with id " + id + " no longer exists.", enfe);
            }
            em.remove(tseccionCursos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TseccionCursos> findTseccionCursosEntities() {
        return findTseccionCursosEntities(true, -1, -1);
    }

    public List<TseccionCursos> findTseccionCursosEntities(int maxResults, int firstResult) {
        return findTseccionCursosEntities(false, maxResults, firstResult);
    }

    private List<TseccionCursos> findTseccionCursosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TseccionCursos.class));
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

    public TseccionCursos findTseccionCursos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TseccionCursos.class, id);
        } finally {
            em.close();
        }
    }

    public int getTseccionCursosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TseccionCursos> rt = cq.from(TseccionCursos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
