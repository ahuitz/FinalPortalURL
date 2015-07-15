/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NotasS;

import Conexion.ConexionJPA;
import Tablas.Carrera;
import Tablas.Ciclo;
import Tablas.Ciclocurso;
import Tablas.Curso;
import Tablas.Cursocarrera;
import Tablas.Facultad;
import Tablas.Persona;
import Tablas.Seccion;
import Tablas.Seccioncurso;
import Tablas.Usuario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Saul
 */
public class ClaseListSecCurso {
    
    public void cargarDatosListSeccionCurso(){
        Query qSeccCur = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Seccioncurso.findAll");
        List<Seccioncurso> SeccCur = qSeccCur.getResultList();
        Iterator<Seccioncurso> iteradorSeccCur = SeccCur.iterator();
        List<ListaSecCurso> miLisSecCur = new ArrayList<ListaSecCurso>();
        while (iteradorSeccCur.hasNext()) {  
            System.out.println("");
            Seccioncurso SeccCur1 = iteradorSeccCur.next();
            if (SeccCur1.getUsuarioCatedraticoid() == 3) {
                
                ////////////
                ////////////SECCION
                Query Secc = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Seccion.findById");
                Secc.setParameter("id", SeccCur1.getSeccionid());
                Seccion miSecc = new Seccion();
                miSecc = (Seccion) Secc.getSingleResult();
                ////////////
                ////////////CursoCarrera
                Query CurCarr = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Cursocarrera.findById");
                CurCarr.setParameter("id", SeccCur1.getCursoCarreraid());
                Cursocarrera miCurCarr = new Cursocarrera();
                miCurCarr = (Cursocarrera) CurCarr.getSingleResult();
                ////////////
                ////////////CicloCurso
                Query CicCur = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Ciclocurso.findById");
                CicCur.setParameter("id", miCurCarr.getCicloCursoid());
                Ciclocurso miCicCur = new Ciclocurso();
                miCicCur = (Ciclocurso) CicCur.getSingleResult();
                ////////////
                ////////////Ciclo
                Query ciC = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Ciclo.findById");
                ciC.setParameter("id", miCicCur.getCicloid());
                Ciclo miCiclo = new Ciclo();
                miCiclo = (Ciclo) ciC.getSingleResult();
                ////////////
                ////////////Curso
                Query cuR = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Curso.findById");
                cuR.setParameter("id", miCicCur.getCursoid());
                Curso miCurso = new Curso();
                miCurso = (Curso) cuR.getSingleResult();
                ////////////
                ////////////Carrera
                Query carR = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Carrera.findById");
                carR.setParameter("id", miCurCarr.getCarreraid());
                Carrera miCarR = new Carrera();
                miCarR = (Carrera) carR.getSingleResult();
                ////////////
                ////////////Facultad
                Query facu = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Facultad.findById");
                facu.setParameter("id", miCarR.getFacultadid());
                Facultad miFacu = new Facultad();
                miFacu = (Facultad) facu.getSingleResult();
                ////////////
                ////////////Usuario
                Query qUsu = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Usuario.findById");
                qUsu.setParameter("id", SeccCur1.getUsuarioCatedraticoid());
                Usuario miUsu = new Usuario();
                miUsu = (Usuario) qUsu.getSingleResult();
                ////////////
                ////////////Persona
                Query qPer = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Persona.findById");
                qPer.setParameter("id", miUsu.getPersonaid());
                Persona miPer = new Persona();
                miPer = (Persona) qPer.getSingleResult();
                ////////////
                ////////////
                
                System.out.println( SeccCur1.getId() + " " + SeccCur1.getCursoCarreraid() + " " + SeccCur1.getSeccionid() 
                    + " " + SeccCur1.getUsuarioCatedraticoid() + " " + miSecc.getDescripcion() //+ " " + miCurCarr.getDescripcion()
                    + " " + miCicCur.getAnio() + " " + miCiclo.getCiclo() + " " + miCurso.getNombre() + " " + miCarR.getCarrera()
                    + " " + miCiclo.getId() + " " + miCurso.getId()
                    + " " + miFacu.getFacultad() + " " + miUsu.getUsuario() + " " + miPer.getNombre() + " " + miPer.getApellido()
                    + " " + miPer.getId()
                );
                
                ListaSecCurso listSecCurso = new  ListaSecCurso(SeccCur1.getId(), SeccCur1.getCursoCarreraid(), SeccCur1.getSeccionid(), 
                    SeccCur1.getUsuarioCatedraticoid(), miSecc.getDescripcion(),
                    miCicCur.getAnio(), miCiclo.getCiclo(), miCurso.getNombre(), miCarR.getCarrera(),
                    miCiclo.getId(), miCurso.getId(),
                    miFacu.getFacultad(), miUsu.getUsuario(), miPer.getNombre(), miPer.getApellido(),
                     miPer.getId());
                miLisSecCur.add(listSecCurso);
                
                System.out.println(listSecCurso);
                
            }else{
                iteradorSeccCur.remove();
            }
            
        }
        
        System.out.println("2");
        Iterator<ListaSecCurso> iteradorListaSecCur = miLisSecCur.iterator();
        while (iteradorListaSecCur.hasNext()) { 
            ListaSecCurso ListaSecCur = iteradorListaSecCur.next();
            System.out.println(ListaSecCur);
        }
    }
    
}
