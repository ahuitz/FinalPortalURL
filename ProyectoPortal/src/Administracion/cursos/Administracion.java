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
import Controladores.PersonaJpaController;
import Controladores.SeccionJpaController;
import Controladores.SeccioncursoJpaController;
import Controladores.UsuarioJpaController;
import Tablas.Curso;
import Tablas.Carrera;
import Tablas.Ciclo;
import Tablas.Ciclocurso;
import Tablas.Cursocarrera;
import Tablas.Facultad;
import Tablas.Persona;
import Tablas.Seccion;
import Tablas.Seccioncurso;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import Conexion.ConexionJPA;


/**
 *
 * @author Cristian
 */
public class Administracion {
    
    EntityManagerFactory emf;

    public Administracion() {
        emf = getEntityManagerFactory();
    }
    
    /*
    Metodo que crea un nuevo ciclo en la base de datos
    @param nombre define el nombre que se le pondra al ciclo
    */
    
    private EntityManagerFactory getEntityManagerFactory(){
        ConexionJPA cn = ConexionJPA.getInstance("root", "root");
        return cn.getEmf();
    } 
    
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
    
    public void crearCarrera(String nombre, String facultad){
        FacultadJpaController conFacultad = new FacultadJpaController(emf);
        int facultadid = conFacultad.getId(facultad);
        
        CarreraJpaController conCarrera = new CarreraJpaController(emf);
        Carrera carrera = new Carrera(conCarrera.getMaxId() + 1, nombre, facultadid);
        conCarrera.create(carrera);
    }
    
    /*
    */
    
    public void agregarCurso(String curso, String ciclo, String carrera, int anio, String descripcion){
        CicloJpaController conCiclo = new CicloJpaController(emf);
        int cicloid = conCiclo.getId(ciclo);
        
        CursoJpaController conCurso = new CursoJpaController(emf);
        int cursoid = conCurso.getId(curso);
        
        CarreraJpaController conCarrera = new CarreraJpaController(emf);
        int carreraid = conCarrera.getId(carrera);
        
        CiclocursoJpaController conCiclocurso = new CiclocursoJpaController(emf);
        Ciclocurso ciclocurso = new Ciclocurso(conCiclocurso.getMaxId() + 1, anio, cicloid, cursoid);
        conCiclocurso.create(ciclocurso);
        
        CursocarreraJpaController conCursocarrera = new CursocarreraJpaController(emf);
        Cursocarrera cursocarrera = new Cursocarrera(conCursocarrera.getMaxId() + 1, 
                descripcion, carreraid, ciclocurso.getId());
        conCursocarrera.create(cursocarrera);
    }
    
    public void crearCurso(String nombre){
        CursoJpaController conCurso = new CursoJpaController(emf);
        Curso curso = new Curso(conCurso.getMaxId() + 1, nombre);
        conCurso.create(curso);
    }
    
    /*
    */
    
    public void agregarCursoCarrera(int ciclocursoid, int carreraid, String descripcion){
        CursocarreraJpaController conCursocarrera = new CursocarreraJpaController(emf);
        Cursocarrera cursocarrera = new Cursocarrera(conCursocarrera.getMaxId() + 1, descripcion, ciclocursoid, carreraid);
        conCursocarrera.create(cursocarrera);
    }
    
    /*
    
    */
    
    public void crearSeccion(String descripcion, int cupo, String curso, String carrera, String nombrecatedratico, 
            String apellidocatedratico, String ciclo, int anio){
        
        SeccionJpaController conSeccion = new SeccionJpaController(emf);
        Seccion seccion = new Seccion(conSeccion.getMaxId() + 1, descripcion);
        conSeccion.create(seccion);
        
        CursoJpaController conCurso = new CursoJpaController(emf);
        int idciclo = conCurso.getId(ciclo);
        CiclocursoJpaController conCiclocurso = new CiclocursoJpaController(emf);
        int idciclocurso = conCiclocurso.getId(idciclo, anio);
        CarreraJpaController conCarrera = new CarreraJpaController(emf);
        int idcarrera = conCarrera.getId(carrera);
        CursocarreraJpaController conCursocarrera = new CursocarreraJpaController(emf);
        int idcursocarrera = conCursocarrera.getId(idcarrera, idciclocurso);
        PersonaJpaController conPersona = new PersonaJpaController(emf);
        int idpersona = conPersona.getId(nombrecatedratico, apellidocatedratico);
        UsuarioJpaController conUsuario = new UsuarioJpaController(emf);
        int idusuario = conUsuario.getId(idpersona);
        
        SeccioncursoJpaController conSeccioncurso = new SeccioncursoJpaController(emf);
        Seccioncurso seccioncurso = new Seccioncurso(conSeccioncurso.getMaxId(), cupo, cupo, seccion.getId(), idcursocarrera,
            idusuario);
        conSeccioncurso.create(seccioncurso);
    }
    
    public List<String> getFacultad(){
        FacultadJpaController conFacultad = new FacultadJpaController(emf);
        List<Facultad> listafacultad = conFacultad.findFacultadEntities();
        List<String> listanombres = new ArrayList<String>();
        for (Facultad facultad : listafacultad)
            listanombres.add(facultad.getFacultad());
        return listanombres;
    }
    
    public List<String> getCarrera(){
        CarreraJpaController conCarrera = new CarreraJpaController(emf);
        List<Carrera> listacarrera = conCarrera.findCarreraEntities();
        List<String> listanombres = new ArrayList<String>();
        for (Carrera carrera : listacarrera)
            listanombres.add(carrera.getCarrera());
        return listanombres;
    }
    
    public List<String> getCurso(){
        CursoJpaController conCurso = new CursoJpaController(emf);
        List<Curso> listacurso = conCurso.findCursoEntities();
        List<String> listanombres = new ArrayList<String>();
        for (Curso curso : listacurso)
            listanombres.add(curso.getNombre());
        return listanombres;
    }
    
    public List<String> getCiclo(){
        CicloJpaController conCiclo = new CicloJpaController(emf);
        List<Ciclo> listaciclo = conCiclo.findCicloEntities();
        List<String> listanombres = new ArrayList<String>();
        for (Ciclo ciclo : listaciclo)
            listanombres.add(ciclo.getCiclo());
        return listanombres;
    }
    
    public List<String> getNombrepersona(){
        PersonaJpaController conPersona = new PersonaJpaController(emf);
        List<Persona> listapersona = conPersona.findPersonaEntities();
        List<String> listanombres = new ArrayList<String>();
        for(Persona persona : listapersona)
            listanombres.add(persona.getApellido() + "-" + persona.getNombre());
        return listanombres;
    }
}
