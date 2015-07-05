/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursos;

import Controladores.TarchivosJpaController;
import Controladores.TrecursoJpaController;
import Tablas.Trecurso;
import java.util.ArrayList;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Pablo López
 */
public class R_Catedratico extends Recurso {
    
    private TarchivosJpaController controladorA;
    
    public R_Catedratico(EntityManagerFactory emf, int idSC) {
        this.controladorR = new TrecursoJpaController(emf);
        this.controladorA = new TarchivosJpaController(emf);
        this.recursos = (ArrayList<Trecurso>) controladorR.findTrecursoEntities();
        this.idSeccionCurso=idSC;
    }

    public TarchivosJpaController getControladorA() {
        return controladorA;
    }

    public void setControladorA(TarchivosJpaController controladorA) {
        this.controladorA = controladorA;
    }
    
    public void modificarRecurso(Trecurso recurso) throws Exception {
        controladorR.edit(recurso);
    }
    
    public void publicarRecurso(Trecurso recurso) {
        controladorR.create(recurso);
    }
    
    @Override
    public void visualizar() {
        
    }
    
}
