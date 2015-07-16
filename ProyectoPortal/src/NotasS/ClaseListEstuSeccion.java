/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NotasS;

import Conexion.ConexionJPA;
import Tablas.Estudianteseccion;
import Tablas.Persona;
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
public class ClaseListEstuSeccion {
    
    public List<ListaEstuSeccion> cargarListaEstudianteSeccion(){
        
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("ESTUDIANE SECCION ////////////////////////////////////////////////////////////////");
        Query EstSecc = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Estudianteseccion.findAll");
        List<Estudianteseccion> miEstSecc = EstSecc.getResultList();
        Iterator<Estudianteseccion> iteradorEstSecc = miEstSecc.iterator();
        List<ListaEstuSeccion> miLisEstSecc = new ArrayList<ListaEstuSeccion>();
        while (iteradorEstSecc.hasNext()) {            
            Estudianteseccion EstSecc1 = iteradorEstSecc.next();
            
            
            ////////////
            ////////////Usuario
            Query qUsu = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Usuario.findById");
            qUsu.setParameter("id", EstSecc1.getUsuarioid());
            Usuario miUsu = new Usuario();
            miUsu = (Usuario) qUsu.getSingleResult();
            ////////////
            ////////////Persona
            Query qPer = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Persona.findById");
            qPer.setParameter("id", miUsu.getPersonaid());
            Persona miPer = new Persona();
            miPer = (Persona) qPer.getSingleResult();
            ////////////
            ////////////SeccionCurso
            Query qSecCur = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Seccioncurso.findById");
            qSecCur.setParameter("id", EstSecc1.getSeccionCursoid());
            Seccioncurso miSecCur = new Seccioncurso();
            miSecCur = (Seccioncurso) qSecCur.getSingleResult();
            
//            System.out.println(EstSecc1.getId() + " " + EstSecc1.getSeccionCursoid() + " " + EstSecc1.getUsuarioid()
//                    + " " + miUsu.getUsuario() + " " + miPer.getNombre() + " " + miPer.getApellido()
//                    + " " + miPer.getId()
//            );
            
            ListaEstuSeccion miListEstuSecc = new ListaEstuSeccion(EstSecc1.getId(), EstSecc1.getSeccionCursoid(), EstSecc1.getUsuarioid(),
                    miUsu.getUsuario(), miPer.getNombre(), miPer.getApellido(),
                    miPer.getId());
            miLisEstSecc.add(miListEstuSecc);
            
        }
        
//        System.out.println("3");
        Iterator<ListaEstuSeccion> iteradorListaEstSecc = miLisEstSecc.iterator();
        while (iteradorListaEstSecc.hasNext()) { 
            ListaEstuSeccion ListaEstSecc = iteradorListaEstSecc.next();
            System.out.println(ListaEstSecc);
        }
        return miLisEstSecc;
    }
    
}
