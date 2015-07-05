/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursos;

import Controladores.TrecursoJpaController;
import Tablas.Trecurso;
import java.util.ArrayList;

/**
 *
 * @author Pablo López
 */
public class R_Catedratico extends Recurso {
    
    public R_Catedratico(TrecursoJpaController controladorR) {
        this.controladorR = controladorR;
        this.recursos = (ArrayList<Trecurso>) controladorR.findTrecursoEntities();
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
