/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursos;

import Tablas.TseccionCursos;
import Tablas.Tusuarios;
import java.util.ArrayList;

/**
 *
 * @author Pablo López
 */
public class Curso {

    public Actividad actividad;
    public ArrayList<Tusuarios> estudiantes;
    public FabricaTipoUsuario fabrica;
    public Recurso recurso;
    public TseccionCursos seccion_Curso;
    public Object conexion;
    public Tusuarios usuario;
    

    public Curso(Tusuarios Usuario, TseccionCursos seccion_curso) {
    }

}
