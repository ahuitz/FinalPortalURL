/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administracion.cursos;

import Controladores.CarreraJpaController;
import Controladores.CicloJpaController;
import Controladores.CiclocursoJpaController;
import Controladores.CursoJpaController;
import Controladores.CursocarreraJpaController;
import Controladores.FacultadJpaController;
import Controladores.SeccionJpaController;
import Controladores.SeccioncursoJpaController;
import Tablas.Curso;
import Tablas.Carrera;
import Tablas.Ciclo;
import Tablas.Ciclocurso;
import Tablas.Cursocarrera;
import Tablas.Facultad;
import Tablas.Seccion;
import Tablas.Seccioncurso;
import javax.persistence.EntityManagerFactory;


/**
 *
 * @author Cristian
 */
public class Administracion {
    
    EntityManagerFactory emf;

    public Administracion(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    /*
    Metodo que crea un nuevo ciclo en la base de datos
    @param nombre define el nombre que se le pondra al ciclo
    */
    
    public void crearCiclo(String nombre){
        CicloJpaController conCiclo = new CicloJpaController(emf);
        Ciclo ciclo = new Ciclo(conCiclo.getMaxId() + 1, nombre);
        conCiclo.create(ciclo);
    }
    
    /*
    Metodo que crea una Nueva Facultad en la base de datos
    @param nombre define el nombre que se le pondra a la nueva Facultad
    */
    
    public void crearFacultad(String nombre){
        FacultadJpaController conFacultad = new FacultadJpaController(emf);
        Facultad facultad = new Facultad(conFacultad.getMaxId() + 1, nombre);
        conFacultad.create(facultad);
    }
    
    /*
    Metodo que crea una Nueva Carrera en la base de datos
    @param nombre define el nombre que se le pondra a la nueva CArrera
    @param facultad define el id de la faculta a la que pertenecera
    */
    
    public void crearCarrera(String nombre, int facultad){
        CarreraJpaController conCarrera = new CarreraJpaController(emf);
        Carrera carrera = new Carrera(conCarrera.getMaxId() + 1, nombre, facultad);
        conCarrera.create(carrera);
    }
    
    
    public void crearCurso(String nombre, int anio, int cicloid){
        CursoJpaController conCurso = new CursoJpaController(emf);
        Curso curso = new Curso(conCurso.getMaxId() + 1, nombre);
        conCurso.create(curso);
        
        CiclocursoJpaController conCiclocurso = new CiclocursoJpaController(emf);
        Ciclocurso ciclocurso = new Ciclocurso(conCiclocurso.getMaxId() + 1, anio, cicloid, curso.getId());
        conCiclocurso.create(ciclocurso);
    }
    
    public void agregarCursoCarrera(int ciclocursoid, int carreraid, String descripcion){
        CursocarreraJpaController conCursocarrera = new CursocarreraJpaController(emf);
        Cursocarrera cursocarrera = new Cursocarrera(conCursocarrera.getMaxId() + 1, descripcion, ciclocursoid, carreraid);
        conCursocarrera.create(cursocarrera);
    }
    
    public void crearSeccion(String descripcion, int cupo, int cursocarreraid, int usuariocatedraticoid){
        SeccionJpaController conSeccion = new SeccionJpaController(emf);
        Seccion seccion = new Seccion(conSeccion.getMaxId() + 1, descripcion);
        conSeccion.create(seccion);
        
        SeccioncursoJpaController conSeccioncurso = new SeccioncursoJpaController(emf);
        Seccioncurso seccioncurso = new Seccioncurso(conSeccioncurso.getMaxId() + 1, cupo, cupo, seccion.getId(), 
                cursocarreraid, usuariocatedraticoid);
        conSeccioncurso.create(seccioncurso);
    }
}
