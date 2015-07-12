/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Tablas.Detalleentrega;
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
public class DetalleentregaJpaController implements Serializable {

    public DetalleentregaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Detalleentrega detalleentrega) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(detalleentrega);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Detalleentrega detalleentrega) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            detalleentrega = em.merge(detalleentrega);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = detalleentrega.getId();
                if (findDetalleentrega(id) == null) {
                    throw new NonexistentEntityException("The detalleentrega with id " + id + " no longer exists.");
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
            Detalleentrega detalleentrega;
            try {
                detalleentrega = em.getReference(Detalleentrega.class, id);
                detalleentrega.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detalleentrega with id " + id + " no longer exists.", enfe);
            }
            em.remove(detalleentrega);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Detalleentrega> findDetalleentregaEntities() {
        return findDetalleentregaEntities(true, -1, -1);
    }

    public List<Detalleentrega> findDetalleentregaEntities(int maxResults, int firstResult) {
        return findDetalleentregaEntities(false, maxResults, firstResult);
    }

    private List<Detalleentrega> findDetalleentregaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Detalleentrega.class));
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

    public Detalleentrega findDetalleentrega(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Detalleentrega.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetalleentregaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Detalleentrega> rt = cq.from(Detalleentrega.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
