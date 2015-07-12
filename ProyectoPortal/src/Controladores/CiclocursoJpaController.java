/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Tablas.Ciclocurso;
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
public class CiclocursoJpaController implements Serializable {

    public CiclocursoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ciclocurso ciclocurso) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ciclocurso);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ciclocurso ciclocurso) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ciclocurso = em.merge(ciclocurso);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ciclocurso.getId();
                if (findCiclocurso(id) == null) {
                    throw new NonexistentEntityException("The ciclocurso with id " + id + " no longer exists.");
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
            Ciclocurso ciclocurso;
            try {
                ciclocurso = em.getReference(Ciclocurso.class, id);
                ciclocurso.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ciclocurso with id " + id + " no longer exists.", enfe);
            }
            em.remove(ciclocurso);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ciclocurso> findCiclocursoEntities() {
        return findCiclocursoEntities(true, -1, -1);
    }

    public List<Ciclocurso> findCiclocursoEntities(int maxResults, int firstResult) {
        return findCiclocursoEntities(false, maxResults, firstResult);
    }

    private List<Ciclocurso> findCiclocursoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ciclocurso.class));
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

    public Ciclocurso findCiclocurso(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ciclocurso.class, id);
        } finally {
            em.close();
        }
    }

    public int getCiclocursoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ciclocurso> rt = cq.from(Ciclocurso.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
