/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursos;

import Controladores.TactividadJpaController;
import Controladores.TentregaJpaController;
import Controladores.TrecursoJpaController;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Miguel Diaz
 */
public class FabricaEstudiante implements FabricaTipoUsuario {

    public FabricaEstudiante() {

    }

    @Override
    public Actividad crearActividad(EntityManagerFactory emf) {
        return new A_Estudiante(new TactividadJpaController(emf), new TentregaJpaController(emf));
    }

    @Override
    public Recurso crearRecurso(EntityManagerFactory emf) {
        return new R_Estudiante(new TrecursoJpaController(emf));
    }

}
