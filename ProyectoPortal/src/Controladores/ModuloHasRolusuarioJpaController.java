/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Tablas.ModuloHasRolusuario;
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
public class ModuloHasRolusuarioJpaController implements Serializable {

    public ModuloHasRolusuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ModuloHasRolusuario moduloHasRolusuario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(moduloHasRolusuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ModuloHasRolusuario moduloHasRolusuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            moduloHasRolusuario = em.merge(moduloHasRolusuario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = moduloHasRolusuario.getId();
                if (findModuloHasRolusuario(id) == null) {
                    throw new NonexistentEntityException("The moduloHasRolusuario with id " + id + " no longer exists.");
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
            ModuloHasRolusuario moduloHasRolusuario;
            try {
                moduloHasRolusuario = em.getReference(ModuloHasRolusuario.class, id);
                moduloHasRolusuario.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The moduloHasRolusuario with id " + id + " no longer exists.", enfe);
            }
            em.remove(moduloHasRolusuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ModuloHasRolusuario> findModuloHasRolusuarioEntities() {
        return findModuloHasRolusuarioEntities(true, -1, -1);
    }

    public List<ModuloHasRolusuario> findModuloHasRolusuarioEntities(int maxResults, int firstResult) {
        return findModuloHasRolusuarioEntities(false, maxResults, firstResult);
    }

    private List<ModuloHasRolusuario> findModuloHasRolusuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ModuloHasRolusuario.class));
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

    public ModuloHasRolusuario findModuloHasRolusuario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ModuloHasRolusuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getModuloHasRolusuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ModuloHasRolusuario> rt = cq.from(ModuloHasRolusuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
