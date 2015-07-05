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
    
    public void crearCurso(Object curso, int idciclo, int year){
        CrearCursos cc = new CrearCursos(curso, idciclo, year);
        cc.instruccion(emf);
    }
    
    public void modificarCurso(Object curso){
        ModificarCurso mc = new ModificarCurso(curso);
        mc.instruccion(emf);
    }
    
    public void buscarCursos(){
        
    }
    
    ///////////////////////// Modulo SEccion //////////////////
    
    
    
    public void crearSeccion(Object seccion, int idcurso, String aula, int cupo){
        CrearSeccion cs = new CrearSeccion(seccion, aula, idcurso, cupo);
        cs.instruccion(emf);
    }
    
 
    public void modificarSeccion(Object seccion){
        ModificarSeccion ms = new ModificarSeccion(seccion);
        ms.instruccion(emf);
        
    
    }
    
    //////////////// modulo de ciclo //////////////////////////////
    
    public void crearCiclo(Object ciclo){
        CrearCiclo crearciclo = new CrearCiclo(ciclo);
        crearciclo.instruccion(emf);
    }
    public void modificarCiclo(Object ciclo){
        ModificarCiclo mci= new ModificarCiclo(ciclo);
        mci.instruccion(emf);
        
        
        
    }
}
