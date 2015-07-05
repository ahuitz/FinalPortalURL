/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Tablas.TcursoCiclo;
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
public class TcursoCicloJpaController implements Serializable {

    public TcursoCicloJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TcursoCiclo tcursoCiclo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tcursoCiclo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TcursoCiclo tcursoCiclo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tcursoCiclo = em.merge(tcursoCiclo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tcursoCiclo.getId();
                if (findTcursoCiclo(id) == null) {
                    throw new NonexistentEntityException("The tcursoCiclo with id " + id + " no longer exists.");
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
            TcursoCiclo tcursoCiclo;
            try {
                tcursoCiclo = em.getReference(TcursoCiclo.class, id);
                tcursoCiclo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tcursoCiclo with id " + id + " no longer exists.", enfe);
            }
            em.remove(tcursoCiclo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TcursoCiclo> findTcursoCicloEntities() {
        return findTcursoCicloEntities(true, -1, -1);
    }

    public List<TcursoCiclo> findTcursoCicloEntities(int maxResults, int firstResult) {
        return findTcursoCicloEntities(false, maxResults, firstResult);
    }

    private List<TcursoCiclo> findTcursoCicloEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TcursoCiclo.class));
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

    public TcursoCiclo findTcursoCiclo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TcursoCiclo.class, id);
        } finally {
            em.close();
        }
    }

    public int getTcursoCicloCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TcursoCiclo> rt = cq.from(TcursoCiclo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
