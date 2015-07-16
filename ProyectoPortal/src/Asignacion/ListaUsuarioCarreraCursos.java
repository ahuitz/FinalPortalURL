/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Asignacion;

import static java.util.Collections.list;
import java.util.List;
import javax.persistence.Query;
import Conexion.ConexionJPA;
import NotasS.ListaSecCurso;
import Tablas.Carrera;
import Tablas.Carrerausuario;
import Tablas.Ciclo;
import Tablas.Ciclocurso;
import Tablas.Curso;
import Tablas.Cursocarrera;
import Tablas.Usuario;
import java.util.ArrayList;
import java.util.Iterator;
import org.eclipse.persistence.internal.jpa.EntityManagerSetupImpl;

/**
 *
 * @author frankzapeta1
 */
public class ListaUsuarioCarreraCursos {
   
    
    public List<UsuarioCarreraCursos> cargarDatos(){
        Query QcursosCarrera= (Query) ConexionJPA.getInstance("usuario","usuario").getEm().createNamedQuery("Carrerausuario.findAll");
        List<Carrerausuario> CurCar= QcursosCarrera.getResultList();
        Iterator<Carrerausuario> iteradorCurCar= CurCar.iterator();
        List<UsuarioCarreraCursos> ListaUsCarCur= new ArrayList<UsuarioCarreraCursos>();
        while(iteradorCurCar.hasNext()){
            Carrerausuario carus1= iteradorCurCar.next();
            
            
           
                /////Usuario
            Query qUsu = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Usuario.findById");
            qUsu.setParameter("id", carus1.getUsuarioid());
            Usuario miUsu = new Usuario();
            miUsu = (Usuario) qUsu.getSingleResult();
            System.out.println("usuario");
            
            //Carrera
             Query qCarr = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Carrera.findById");
            qCarr.setParameter("id", carus1.getCarreraid());
            Carrera miCarr = new Carrera();
            miCarr =  (Carrera) qCarr.getSingleResult();
            System.out.println("Carrera");
            
            //CursoCarrera
            Query qCurCar = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Cursocarrera.findById");
            qCurCar.setParameter("id", carus1.getCarreraid());
            Cursocarrera curcar = new Cursocarrera();
            curcar =   (Cursocarrera) qCurCar.getSingleResult();
            System.out.println("curso carrera");
            
            //CicloCurso
            Query qCicCur = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Ciclocurso.findById");
            qCicCur.setParameter("id", curcar.getCicloCursoid());
            Ciclocurso mciccur = new Ciclocurso();
            mciccur =   (Ciclocurso) qCicCur.getSingleResult();
            System.out.println("ciclo curso");
            
            //Ciclo
            Query qCicl = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Ciclo.findById");
            qCicl.setParameter("id", mciccur.getCicloid());
            Ciclo mciclo = new Ciclo();
            mciclo =    (Ciclo) qCicl.getSingleResult();
            System.out.println("ciclo");
            
            //Curso
            Query qCurso = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Curso.findById");
            qCurso.setParameter("id", mciccur.getCicloid());
            Curso mcurso = new Curso();
            mcurso = (Curso) qCurso.getSingleResult();
            System.out.println("curso");
            
            UsuarioCarreraCursos consul= new UsuarioCarreraCursos();
            consul.setIdUsuario(miUsu.getId());
            consul.setUsuario(miUsu.getUsuario());
            consul.setRolUsuarioiD(miUsu.getRolUsuarioid());
            consul.setPersonaiD(miUsu.getPersonaid());
            
            consul.setIdCarrera(carus1.getCarreraid());
            consul.setUsuarioiD(carus1.getUsuarioid());
            consul.setCarreraiD(carus1.getCarreraid());
                    
            consul.setCarreraiD(miCarr.getId());
            consul.setCarrera(miCarr.getCarrera());
            consul.setFacultadiD(miCarr.getFacultadid());
            
            consul.setIdCursoCarrera(curcar.getId());
            consul.setDescripsion(curcar.getDescripcion());
            consul.setCursoCarreraiD(Integer.toString(curcar.getCarreraid()));
            consul.setCicloCursoiD(curcar.getCicloCursoid());
            
            
            
            
            
            }
            
            
            
            
        
        //filtrar por carrera
     //    Iterator<UsuarioCarreraCursos> iteradorListaSecCur2 = ListaUsCarCur.iterator();
       // while (iteradorListaSecCur2.hasNext()) { 
        //    UsuarioCarreraCursos ListaSecCur = iteradorListaSecCur2.next();
         //  if(ListaSecCur.getCarreraiD()!=1){
          //     iteradorListaSecCur2.remove();
           //}
            
      //  }
        //filtrar por curso
        Iterator<UsuarioCarreraCursos> iteradorListaSecCur3 = ListaUsCarCur.iterator();
        while (iteradorListaSecCur3.hasNext()) {
            System.out.println("Primer");
            UsuarioCarreraCursos ListaSecCur = iteradorListaSecCur3.next();
           if(ListaSecCur.getCursoiD()!=2){
               System.out.println(ListaSecCur);
               iteradorListaSecCur3.remove();
           }
            
        }
        
        //filtrar por ciclo
         Iterator<UsuarioCarreraCursos> iteradorListaSecCur4 = ListaUsCarCur.iterator();
        while (iteradorListaSecCur4.hasNext()) { 
            System.out.println("Segundo");
            UsuarioCarreraCursos ListaSecCur = iteradorListaSecCur4.next();
           if(ListaSecCur.getCicloiD()!=1){
               iteradorListaSecCur4.remove();
           }
            
        }
        
         Iterator<UsuarioCarreraCursos> iteradorListaSecCur6 = ListaUsCarCur.iterator();
        while (iteradorListaSecCur6.hasNext()) { 
            UsuarioCarreraCursos usuariocarrera = iteradorListaSecCur6.next();
            System.out.println(usuariocarrera);
        }
        
     
        
        return ListaUsCarCur;
    }
    
}
