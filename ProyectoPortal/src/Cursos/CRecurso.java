/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursos;

import Controladores.RecursoJpaController;
import Tablas.Recurso;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pablo López
 */
public abstract class CRecurso {

    protected RecursoJpaController controladorR;
    protected ArrayList<Recurso> recursos;
    protected int idSeccionCurso;
    
    public RecursoJpaController getControladorR() {
        return controladorR;
    }

    public void setControladorR(RecursoJpaController controladorR) {
        this.controladorR = controladorR;
    }

    public List getRecursos() {
        return recursos;
    }

    public void setRecursos(ArrayList<Recurso> recursos) {
        this.recursos = recursos;
    }

    public int getIdSeccionCurso() {
        return idSeccionCurso;
    }
    
    public abstract void visualizar();
}
