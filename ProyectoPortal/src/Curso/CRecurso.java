/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Curso;

import Controladores.RecursoJpaController;
import Tablas.Recurso;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author Pablo López
 */
public abstract class CRecurso {
    protected EntityManagerFactory emf;
    protected RecursoJpaController controladorR;
    protected List<Recurso> recursos;
    protected int idSeccionCurso;
    
    public RecursoJpaController getControladorR() {
        return controladorR;
    }

    public void setControladorR(RecursoJpaController controladorR) {
        this.controladorR = controladorR;
    }

    public List getRecursos() {
        return obtenerRecursos();
    }

    public void setRecursos(List<Recurso> recursos) {
        this.recursos = recursos;
    }

    public int getIdSeccionCurso() {
        return idSeccionCurso;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public List<Recurso> obtenerRecursos(){
        Query q;
        q = emf.createEntityManager().createNamedQuery("Recurso.findBySeccionCursoid");
        q.setParameter("seccionCursoid", idSeccionCurso);
        return q.getResultList();
    }
    public abstract List<Recurso> visualizar();
}
