/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NotasS;

import Conexion.ConexionJPA;
import Tablas.Actividad;
import Tablas.Entrega;
import Tablas.Persona;
import Tablas.Seccioncurso;
import Tablas.Tipoactividad;
import Tablas.Usuario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Saul
 */
public class ClaseListEntregaActiv {
    
    public List<ListaEntregaActiv> cargarDatosListEntregaActividad(){
        
        System.out.println("");
        System.out.println("");
        Query qEntr = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Entrega.findAll");
        List<Entrega> miListEnt = qEntr.getResultList();
        Iterator<Entrega> iteradorEnt = miListEnt.iterator();
        List<ListaEntregaActiv> miLisEntActiv = new ArrayList<ListaEntregaActiv>();
        while (iteradorEnt.hasNext()) {            
            Entrega miEnt = iteradorEnt.next();
            
            ///////////Actividad
            ///////////
            Query qAct = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Actividad.findById");
            qAct.setParameter("id", miEnt.getActividadid());
            Actividad miActivi = new Actividad();
            miActivi = (Actividad) qAct.getSingleResult();
            
            ///////////Usuario
            ///////////
            Query qTipoAct = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Tipoactividad.findById");
            qTipoAct.setParameter("id", miActivi.getTipoActividadid());
            Tipoactividad miTipAct = new Tipoactividad();
            miTipAct = (Tipoactividad) qTipoAct.getSingleResult();
            
            ///////////Usuario
            ///////////
            
            Query qUsu = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Usuario.findById");
            qUsu.setParameter("id", miEnt.getUsuarioid());
            Usuario miUsu = new Usuario();
            miUsu = (Usuario) qUsu.getSingleResult();
            
            ///////////Persona
            ///////////
            Query qPer = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Persona.findById");
            qPer.setParameter("id", miUsu.getPersonaid());
            Persona miPer = new Persona();
            miPer = (Persona) qPer.getSingleResult();
            
            ///////////SeccionCurso
            ///////////
            Query qSecCur = ConexionJPA.getInstance("usuario", "usuario").getEm().createNamedQuery("Seccioncurso.findById");
            qSecCur.setParameter("id", miActivi.getSeccionCursoid());
            Seccioncurso miSecCur = new Seccioncurso();
            miSecCur = (Seccioncurso) qSecCur.getSingleResult();
            
            System.out.println(miEnt.getId() + "  " + miEnt.getCalificacion() + "  " + miEnt.getNoRealizada() 
                    + " " + miEnt.getRealizada() + " " + miActivi.getId() + "  " + miActivi.getPunteo()
                    + "  " + miActivi.getTitulo() + " " + miTipAct.getId() + " " + miTipAct.getTipoActividad() + " " + miUsu.getId() 
                    + " " + miUsu.getUsuario() + " " + miPer.getId() + " " + miPer.getNombre() + " " + miPer.getApellido()
                    + " " + miSecCur.getId() + " " + miActivi.getFechaEntrega() + " " + miActivi.getFechaPublicacion()
                    + " " + miActivi.getFisica() + " " + miActivi.getVirtual()
            );
            
            ListaEntregaActiv miListEntActiv = new ListaEntregaActiv(miEnt.getId(), miEnt.getCalificacion(), miEnt.getNoRealizada() 
                    ,miEnt.getRealizada(), miActivi.getId(), miActivi.getPunteo()
                    ,miActivi.getTitulo(), miTipAct.getId(), miTipAct.getTipoActividad(), miUsu.getId() 
                    ,miUsu.getUsuario(), miPer.getId(), miPer.getNombre(), miPer.getApellido()
                    ,miSecCur.getId(), miActivi.getFechaEntrega(), miActivi.getFechaPublicacion()
                    ,miActivi.getFisica(), miActivi.getVirtual());
            
            miLisEntActiv.add(miListEntActiv);

        }
        
        System.out.println("4");
        Iterator<ListaEntregaActiv> iteradorListaEntActiv = miLisEntActiv.iterator();
        while (iteradorListaEntActiv.hasNext()) { 
            ListaEntregaActiv ListaEntAct = iteradorListaEntActiv.next();
            System.out.println(ListaEntAct);
        }
        return miLisEntActiv;
    }
    
}
