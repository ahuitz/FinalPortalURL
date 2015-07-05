/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursos;

import Controladores.TdetalleEntregaJpaController;
import Tablas.Tactividad;
import Tablas.Tentrega;
import java.util.ArrayList;

/**
 *
 * @author Miguel Diaz
 */
public class A_Catedratico extends Actividad {
   

    public A_Catedratico(Controladores.TactividadJpaController controladorA, Controladores.TentregaJpaController controladorE,int ISC) {
        this.controladorA = controladorA;
        this.controladorE= controladorE;
        this.idSeccionCurso=ISC;
    }
    public void calificarEntrega(Tentrega entrega, Double calificacion) {
    }

    public void modificarActividad(Tactividad actividad) throws Exception {
        controladorA.edit(actividad);
    }

    public void publicarActividad(Tactividad actividad) {
        actividad.setId(controladorA.getTactividadCount());
        controladorA.create(actividad);
        
    }

    @Override
    public void visualizarActividad() {
    }

}