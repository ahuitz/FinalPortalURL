/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Curso;

import Controladores.ActividadJpaController;
import Controladores.EntregaJpaController;
import Forms.Curso.Entrega;

import java.util.ArrayList;

/**
 *
 * @author Miguel Diaz
 */
public class A_Catedratico extends Actividad {
   
    public ArrayList<Entregas> entregas;
    
    public A_Catedratico(ActividadJpaController controladorA, EntregaJpaController controladorE,int ISC) {
        this.controladorA = controladorA;
        this.controladorE= controladorE;
        this.idSeccionCurso=ISC;
    }
    public void calificarEntrega(Entrega entrega, Double calificacion) {
    }

    public void modificarActividad(Tablas.Actividad actividad) throws Exception {
        controladorA.edit(actividad);
    }

    public void publicarActividad(Tablas.Actividad actividad) {
        actividad.setId(controladorA.getActividadCount());
        controladorA.create(actividad);
        
    }
    

    @Override
    public void visualizarActividad() {
    }

}