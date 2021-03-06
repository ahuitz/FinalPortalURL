/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Curso;

import Controladores.ActividadJpaController;
import Controladores.EntregaJpaController;
import Tablas.Actividad;
import Tablas.Entrega;
import Tablas.Usuario;

import java.util.ArrayList;

/**
 *
 * @author Miguel Diaz
 */
public abstract class CActividad_1 {

    protected ArrayList<Actividad> actividades;
    protected ActividadJpaController controladorA;
    protected EntregaJpaController controladorE;
    protected int idSeccionCurso;
    
    
    //metodos Estudiantes
    public abstract void modificarEntrega(Entrega entrega)throws Exception;
    public abstract Entrega obtenerEntrega(int idActividad);
    
    //metodos Catedraticos
    public abstract ArrayList<Entrega> obtenerEntregas(int idActividad);
    public abstract void calificarEntrega(ArrayList<Entrega> entrega )throws Exception;
    public abstract void modificarActividad(Actividad actividad)throws Exception;
    public abstract void publicarActividad(Tablas.Actividad actividad,ArrayList<Usuario> usuarios);
    
    
    //metodos en comun
    public abstract void visualizarActividad(CCurso curso,int idActividad);
    public abstract void cargarEntregas();
    
    public  void cargarActividades(){
        
    }
    
    public Actividad obtenerActividad(int i ){
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
