/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursos;

import Tablas.Tentrega;
import java.util.ArrayList;
import Controladores.TactividadJpaController;
import Controladores.TentregaJpaController;

/**
 *
 * @author Miguel Diaz
 */
public class A_Estudiante extends Actividad {

    private ArrayList<Tentrega> entregas;
    

    public A_Estudiante(TactividadJpaController controladorA, TentregaJpaController controladorE,int ISC) {
        this.controladorA = controladorA;
        this.controladorE = controladorE;
        this.idSeccionCurso= ISC;
    }

    public void modificarEntrega(Tentrega entrega) throws Exception {
        controladorE.edit(entrega);
    }

    public void realizarEntrega(Tentrega entrega) {
    }
    @Override
    public void visualizarActividad() {
    }

}
