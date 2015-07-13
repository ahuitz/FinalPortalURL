/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursos;

import Controladores.ActividadJpaController;
import Controladores.EntregaJpaController;

import java.util.ArrayList;

/**
 *
 * @author Miguel Diaz
 */
public abstract class Actividad {

    protected ArrayList<Tablas.Actividad> actividades;
    
   
    protected ActividadJpaController controladorA;
    protected EntregaJpaController controladorE;
    protected int idSeccionCurso;
    
    public abstract void visualizarActividad();
    
    public Tablas.Actividad obtenerActividad(int i ){
        for(Tablas.Actividad a:actividades){
            if(a.getId()==i){
                return a;
            }
            
        }
        return null;
    }    
    public ArrayList<Tablas.Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(ArrayList<Tablas.Actividad> actividades) {
        this.actividades = actividades;
    }

    public ActividadJpaController getControladorA() {
        return controladorA;
    }

    public void setControladorA(ActividadJpaController controladorA) {
        this.controladorA = controladorA;
    }

    public EntregaJpaController getControladorE() {
        return controladorE;
    }

    public void setControladorE(EntregaJpaController controladorE) {
        this.controladorE = controladorE;
    }

}
