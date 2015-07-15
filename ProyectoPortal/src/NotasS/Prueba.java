/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NotasS;

import Conexion.*;
import Controladores.*;
import Tablas.*;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Query;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Saul
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        String jpql = "Persona.findAll";
//        Query q = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery(jpql);
//        
//        List<Persona> pers = q.getResultList();
//        for (Persona p : pers) {
//            Query q2 = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Tiposangre.findById");
//            q2.setParameter("id", p.getTipoSangreid());
//            Tiposangre miTipSan = new Tiposangre();
//            miTipSan = (Tiposangre) q2.getSingleResult();
//            System.out.println(p.getApellido() + " " + miTipSan.getTipo());
//        }
        
        Query qSeccCur = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Seccioncurso.findAll");
        List<Seccioncurso> SeccCur = qSeccCur.getResultList();
        Iterator<Seccioncurso> iteradorSeccCur = SeccCur.iterator();
        while (iteradorSeccCur.hasNext()) {            
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
                    + " " + SeccCur1.getUsuarioCatedraticoid() + " " + miSecc.getDescripcion() + " " + miCurCarr.getDescripcion()
                    + " " + miCicCur.getAnio() + " " + miCiclo.getCiclo() + " " + miCurso.getNombre() + " " + miCarR.getCarrera()
                    + " " + miFacu.getFacultad() + " " + miUsu.getUsuario() + " " + miPer.getNombre() + " " + miPer.getApellido()
                );
            }else{
                iteradorSeccCur.remove();
            }
            
        }
        
        Query EstSecc = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Estudianteseccion.findAll");
        List<Estudianteseccion> miEstSecc = EstSecc.getResultList();
        Iterator<Estudianteseccion> iteradorEstSecc = miEstSecc.iterator();
        while (iteradorEstSecc.hasNext()) {            
            Estudianteseccion EstSecc1 = iteradorEstSecc.next();
            
            
            ////////////
            ////////////Usuario
            Query qUsu = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Usuario.findById");
            qUsu.setParameter("id", EstSecc1.getUsuarioid());
            Usuario miUsu = new Usuario();
            miUsu = (Usuario) qUsu.getSingleResult();
            ////////////
            ////////////
            Query qPer = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Persona.findById");
            qPer.setParameter("id", miUsu.getPersonaid());
            Persona miPer = new Persona();
            miPer = (Persona) qPer.getSingleResult();
            ////////////
            ////////////
            
            System.out.println(EstSecc1.getId() + " " + EstSecc1.getSeccionCursoid() + " " + EstSecc1.getUsuarioid()
                    + " " + miUsu.getUsuario() + " " + miPer.getNombre() + " " + miPer.getApellido()
            );
        }
        
        Query qActiv = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Actividad.findAll");
        List<Actividad> miLisAct = qActiv.getResultList();
        Iterator<Actividad> iteradorAct = miLisAct.iterator();
        while (iteradorAct.hasNext()) {            
            Actividad miActi = iteradorAct.next();
            
            ///////////Entrega
            ///////////
            Query qTipAct = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Tipoactividad.findById");
            qTipAct.setParameter("id", miActi.getTipoActividadid());
            Tipoactividad miActad = new Tipoactividad();
            miActad = (Tipoactividad) qTipAct.getSingleResult();
            
            
            System.out.println(miActi.getId() + " " + miActi.getSeccionCursoid() + " " + miActad.getId() 
                    + " " + miActad.getTipoActividad());
        }
        
        
//        for (Seccioncurso SeccCur1 : SeccCur) {
//            if (SeccCur1.getUsuarioCatedraticoid() == 3) {
//                System.out.println( SeccCur1.getId() + " " + SeccCur1.getCupo() + " " + SeccCur1.getDisponibles() + " "
//                    + SeccCur1.getCursoCarreraid() + " " + SeccCur1.getSeccionid() + " " + SeccCur1.getUsuarioCatedraticoid());
//            }
//            
//        }
        
    }
    
}




























