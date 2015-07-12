/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Tablas.Seccioncurso;
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
public class SeccioncursoJpaController implements Serializable {

    public SeccioncursoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Seccioncurso seccioncurso) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(seccioncurso);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Seccioncurso seccioncurso) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            seccioncurso = em.merge(seccioncurso);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = seccioncurso.getId();
                if (findSeccioncurso(id) == null) {
                    throw new NonexistentEntityException("The seccioncurso with id " + id + " no longer exists.");
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
            Seccioncurso seccioncurso;
            try {
                seccioncurso = em.getReference(Seccioncurso.class, id);
                seccioncurso.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The seccioncurso with id " + id + " no longer exists.", enfe);
            }
            em.remove(seccioncurso);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Seccioncurso> findSeccioncursoEntities() {
        return findSeccioncursoEntities(true, -1, -1);
    }

    public List<Seccioncurso> findSeccioncursoEntities(int maxResults, int firstResult) {
        return findSeccioncursoEntities(false, maxResults, firstResult);
    }

    private List<Seccioncurso> findSeccioncursoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Seccioncurso.class));
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

    public Seccioncurso findSeccioncurso(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Seccioncurso.class, id);
        } finally {
            em.close();
        }
    }

    public int getSeccioncursoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Seccioncurso> rt = cq.from(Seccioncurso.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
