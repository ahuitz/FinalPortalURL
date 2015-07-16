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
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author Miguel Diaz
 */
public abstract class CActividad {

    public List<Actividad> actividades;
    protected ActividadJpaController controladorA;
    protected EntregaJpaController controladorE;
    protected int idSeccionCurso;
    protected EntityManagerFactory emf;
    
    //metodos Estudiantes
    public abstract void modificarEntrega(Entrega entrega)throws Exception;
    public abstract Entrega obtenerEntrega(int idActividad);
    
    //metodos Catedraticos
    public abstract List<Entrega> obtenerEntregas(int idActividad);
    public abstract void calificarEntrega(List<Entrega> entrega )throws Exception;
    public abstract void modificarActividad(Actividad actividad)throws Exception;
    public abstract void publicarActividad(Tablas.Actividad actividad,List<Usuario> usuarios);
    
    
    //metodos en comun
    public abstract void visualizarActividad(CCurso curso,int idActividad);
    public abstract void cargarEntregas();
    
    public EntityManagerFactory getEmf() {
        return emf;
    }
    
    public  void cargarActividades(EntityManagerFactory emf,int i){
        Query q;
        EntityManager em=emf.createEntityManager();
        q=em.createNamedQuery("Actividad.findBySeccionCursoid");
        //'nombre' es el parametro que esta en la clase usuario ':nombre'
        q.setParameter("seccionCursoid", i);
        actividades=q.getResultList();
        System.out.println(actividades.size());
        
    }
    
    public Actividad obtenerActividad(int i ){
        for(Tablas.Actividad a:actividades){
            if(a.getId()==i){
                return a;
            }
            
        }
        return null;
    } 
    
    
    public List<Actividad> getActividades() {
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
