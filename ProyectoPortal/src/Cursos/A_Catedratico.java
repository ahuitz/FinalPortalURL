/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursos;

import Tablas.Tactividad;
import Tablas.Tentrega;
import java.util.ArrayList;

/**
 *
 * @author Miguel Diaz
 */
public class A_Catedratico extends Actividad {
    public Controladores.TdetalleEntregaJpaController controladorDE;
    public ArrayList<Entrega> entregas;

    public A_Catedratico(Controladores.TactividadJpaController controladorA, Controladores.TdetalleEntregaJpaController controladorE) {
        this.controladorA = controladorA;
        this.controladorDE = controladorE;
    }

    public void agregarEntrega(int idActividad, Object controladorE) {
    }

    public void calificarEntrega(Tentrega entrega, Double calificacion) {
    }

    public void modificarActividad(Tactividad actividad) {
    }

    public void publicarActividad(Tactividad actividad) {
    }

    @Override
    public void visualizarActividad() {
    }

}