/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Tablas.Detalleasignacionvip;
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
public class DetalleasignacionvipJpaController implements Serializable {

    public DetalleasignacionvipJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Detalleasignacionvip detalleasignacionvip) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(detalleasignacionvip);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Detalleasignacionvip detalleasignacionvip) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            detalleasignacionvip = em.merge(detalleasignacionvip);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = detalleasignacionvip.getId();
                if (findDetalleasignacionvip(id) == null) {
                    throw new NonexistentEntityException("The detalleasignacionvip with id " + id + " no longer exists.");
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
            Detalleasignacionvip detalleasignacionvip;
            try {
                detalleasignacionvip = em.getReference(Detalleasignacionvip.class, id);
                detalleasignacionvip.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detalleasignacionvip with id " + id + " no longer exists.", enfe);
            }
            em.remove(detalleasignacionvip);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Detalleasignacionvip> findDetalleasignacionvipEntities() {
        return findDetalleasignacionvipEntities(true, -1, -1);
    }

    public List<Detalleasignacionvip> findDetalleasignacionvipEntities(int maxResults, int firstResult) {
        return findDetalleasignacionvipEntities(false, maxResults, firstResult);
    }

    private List<Detalleasignacionvip> findDetalleasignacionvipEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Detalleasignacionvip.class));
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

    public Detalleasignacionvip findDetalleasignacionvip(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Detalleasignacionvip.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetalleasignacionvipCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Detalleasignacionvip> rt = cq.from(Detalleasignacionvip.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
