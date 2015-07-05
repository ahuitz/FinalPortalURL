/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursos;

import Controladores.TrecursoJpaController;
import Tablas.Trecurso;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pablo López
 */
public abstract class Recurso {

    protected TrecursoJpaController controladorR;
    protected ArrayList<Trecurso> recursos;

    public TrecursoJpaController getControladorR() {
        return controladorR;
    }

    public void setControladorR(TrecursoJpaController controladorR) {
        this.controladorR = controladorR;
    }

    public List getRecursos() {
        return recursos;
    }

    public void setRecursos(ArrayList<Trecurso> recursos) {
        this.recursos = recursos;
    }
    
    public abstract void visualizar();
}
