/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Curso;

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

    public CActividad actividad;
    public ArrayList<Usuario> estudiantes;
    public FabricaTipoUsuario fabrica;
    public CRecurso recurso;
    public Seccioncurso seccion_Curso;
    public Object conexion;
    public Usuario usuario;
    

    public Curso(Usuario Usuario, Seccioncurso seccion_curso) {
    }

}
