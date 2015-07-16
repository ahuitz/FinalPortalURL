/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Curso;

import Conexion.ConexionJPA;
import Forms.FormularioUsuarios1;
import Tablas.Seccioncurso;
import Tablas.Usuario;
import java.util.ArrayList;
/**
 *
 * @author Pablo López
 * @author Pablo Garzona
 * @author Miguel Diaz
 */
public class Curso {

    public FabricaTipoUsuario fabrica;
    public CActividad actividad;
    public CRecurso recurso;
    public ArrayList<Usuario> estudiantes;
    public Usuario usuario;
    public int idSeccionCurso;

    public Curso(String rol, Usuario usuario, int idSeccionCurso) {
        this.usuario=usuario;
        switch(rol){
            case "EST":{
                fabrica = new FabricaEstudiante();
                actividad= fabrica.crearActividad(FormularioUsuarios1.conexion.getEmf(), this.usuario.getId());
                recurso=fabrica.crearRecurso(FormularioUsuarios1.conexion.getEmf(), idSeccionCurso);
                break;
            }
            case "CAT":{
                fabrica = new FabricaCatedratico();
                
                break;
            }
            default:
                break;
        }
    }

}
