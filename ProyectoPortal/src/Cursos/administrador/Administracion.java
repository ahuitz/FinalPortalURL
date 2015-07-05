/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursos.administrador;

import javax.persistence.EntityManagerFactory;
/**
 *
 * @author Cristian
 */
public class Administracion {
    
    private EntityManagerFactory emf;

    public Administracion(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    //////////// Modulo curso ///////////////////////////////////////
    
    public void crearCurso(Object curso, Object ciclo, int year){
        CrearCursos cc = new CrearCursos(curso, ciclo, year);
        cc.instruccion(emf);
    }
    
    public void modificarCurso(int idSeccionCurso, int cupo){
    
    }
    
    
    public void buscarCurso(){
        
    }
    
    public void eliminarCurso(){
    
    }
    
    ///////////////////////// Modulo SEccion //////////////////
    
    
    
    public void crearSeccion(Object seccion, int idcurso, String aula, int cupo){
        CrearSeccion cs = new CrearSeccion(seccion, aula, idcurso, cupo);
        cs.instruccion(emf);
    }
    
    public void buscarSeccion(){
    
    }
    
    public void eliminarSeccion(){
    }
    
    public void modificarSeccion(){
    
    }
    
    //////////////// modulo de ciclo //////////////////////////////
    
    public void crearCiclo(){
    }
    
    public void buscarCiclo(){
    
    }
    
    public void eliminarCiclo(){
    
    }
    public void modificarCiclo(){
    
    }
}
