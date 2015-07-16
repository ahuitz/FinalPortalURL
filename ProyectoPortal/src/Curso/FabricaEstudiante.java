/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Curso;

import Controladores.ActividadJpaController;
import Controladores.EntregaJpaController;
import Controladores.RecursoJpaController;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Miguel Diaz
 */
public class FabricaEstudiante implements FabricaTipoUsuario {

    public FabricaEstudiante() {

    }

    @Override
    public CActividad crearActividad(EntityManagerFactory emf, int idSC) {
        return new A_Estudiante(emf, idSC);
    }

    @Override
    public CRecurso crearRecurso(EntityManagerFactory emf, int idSC) {
        return new R_Estudiante(emf, idSC);
    }

}
