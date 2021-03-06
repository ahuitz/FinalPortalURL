/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Curso;

import Controladores.ArchivoJpaController;
import Controladores.RecursoJpaController;
import Tablas.Recurso;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Pablo López
 */
public class R_Catedratico extends CRecurso {
    
    private ArchivoJpaController controladorA;
    
    public R_Catedratico(EntityManagerFactory emf, int idSC) {
        this.emf=emf;
        this.controladorR = new RecursoJpaController(this.emf);
        this.controladorA = new ArchivoJpaController(this.emf);
        this.idSeccionCurso=idSC;
        this.recursos = obtenerRecursos();
    }

    public ArchivoJpaController getControladorA() {
        return controladorA;
    }

    public void setControladorA(ArchivoJpaController controladorA) {
        this.controladorA = controladorA;
    }
    
    public void modificarRecurso(Recurso recurso) throws Exception {
        controladorR.edit(recurso);
    }
    
    public void publicarRecurso(Recurso recurso) {
        controladorR.create(recurso);
    }
    
    @Override
    public List<Recurso> visualizar() {
        return recursos;
    }
    
}
