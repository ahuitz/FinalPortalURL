/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Curso;

import Forms.FormularioUsuarios1;
import Tablas.Estudianteseccion;
import Tablas.Persona;
import Tablas.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
/**
 *
 * @author Pablo López
 * @author Pablo Garzona
 * @author Miguel Diaz
 */
public class CCurso {

    private FabricaTipoUsuario fabrica;
    private CActividad actividad;
    private CRecurso recurso;
    private ArrayList<Persona> estudiantes;
    private ArrayList<Integer> usuariosID;
    public static Usuario usuario;
    private String rol;
    private int idSeccionCurso;

    public CCurso(String rol, Usuario usuario, int idSeccionCurso) {
        CCurso.usuario=usuario;
        this.idSeccionCurso=idSeccionCurso;
        this.rol=rol;
        obtenerPersonas();
        obtenerUsuariosID();
        switch(rol){
            case "EST":{
                fabrica = new FabricaEstudiante();
                actividad= fabrica.crearActividad(FormularioUsuarios1.conexion.getEmf(), idSeccionCurso);
                recurso=fabrica.crearRecurso(FormularioUsuarios1.conexion.getEmf(), idSeccionCurso);
                break;
            }
            case "CAT":{
                fabrica = new FabricaCatedratico();
                actividad= fabrica.crearActividad(FormularioUsuarios1.conexion.getEmf(), idSeccionCurso);
                recurso=fabrica.crearRecurso(FormularioUsuarios1.conexion.getEmf(), idSeccionCurso);                
                break;
            }
            default:
                break;
        }
    }

    public String getRol() {
        return rol;
    }

    public CActividad getActividad() {
        return actividad;
    }

    public CRecurso getRecurso() {
        return recurso;
    }

    public ArrayList<Persona> getEstudiantes() {
        return estudiantes;
    }

    public ArrayList<Integer> getUsuariosID() {
        return usuariosID;
    }

    public int getIdSeccionCurso() {
        return idSeccionCurso;
    }
    
    private void obtenerUsuariosID(){
        Query q;
        q = FormularioUsuarios1.conexion.getEmf().createEntityManager().createNamedQuery("Estudianteseccion.findBySeccionCursoid");
        q.setParameter("seccionCursoid", 1);
        List<Estudianteseccion> estudiantesSeccion = q.getResultList();
        usuariosID=new ArrayList();
        for (Estudianteseccion iterador : estudiantesSeccion) {
        usuariosID.add(iterador.getUsuarioid());
        }
    }
    
    private void obtenerPersonas(){
        Query q;
        q = FormularioUsuarios1.conexion.getEmf().createEntityManager().createNamedQuery("Estudianteseccion.findBySeccionCursoid");
        q.setParameter("seccionCursoid", 1);
        List<Estudianteseccion> estudiantesSeccion = q.getResultList();
        ArrayList<Usuario> usuarios=new ArrayList();
        estudiantes = new ArrayList();
        for(int i=0;i<estudiantesSeccion.size();i++){
            q = FormularioUsuarios1.conexion.getEmf().createEntityManager().createNamedQuery("Usuario.findById");
            q.setParameter("id", estudiantesSeccion.get(i).getUsuarioid());
            usuarios.add((Usuario) q.getSingleResult());
            q = FormularioUsuarios1.conexion.getEmf().createEntityManager().createNamedQuery("Persona.findById");
            q.setParameter("id", usuarios.get(i).getPersonaid());
            estudiantes.add((Persona) q.getSingleResult());
        }
    }

}
