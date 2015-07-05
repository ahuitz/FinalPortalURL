/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursos;

import Controladores.TactividadJpaController;
import Controladores.TentregaJpaController;
import Tablas.Tactividad;
import java.util.ArrayList;

/**
 *
 * @author Miguel Diaz
 */
public abstract class Actividad {

    protected ArrayList<Tactividad> actividades;
    protected Controladores.TactividadJpaController controladorA;
    protected Controladores.TentregaJpaController controladorE;

    public abstract void visualizarActividad();

    public ArrayList<Tactividad> getActividades() {
        return actividades;
    }

    public void setActividades(ArrayList<Tactividad> actividades) {
        this.actividades = actividades;
    }

    public TactividadJpaController getControladorA() {
        return controladorA;
    }

    public void setControladorA(TactividadJpaController controladorA) {
        this.controladorA = controladorA;
    }

    public TentregaJpaController getControladorE() {
        return controladorE;
    }

    public void setControladorE(TentregaJpaController controladorE) {
        this.controladorE = controladorE;
    }

}
