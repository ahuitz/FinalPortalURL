/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursos;

import Controladores.ActividadJpaController;
import Controladores.EntregaJpaController;
import java.util.ArrayList;
import Tablas.Entrega;

/**
 *
 * @author Miguel Diaz
 */
public class A_Estudiante extends Actividad {

    private ArrayList<Entrega> entregas;
    

    public A_Estudiante(ActividadJpaController controladorA, EntregaJpaController controladorE,int ISC) {
        this.controladorA = controladorA;
        this.controladorE = controladorE;
        this.idSeccionCurso= ISC;
    }

    public void modificarEntrega(Entrega entrega) throws Exception {
        controladorE.edit(entrega);
    }

    public void realizarEntrega(Entrega entrega) {
    }
    @Override
    public void visualizarActividad() {
    }

}
