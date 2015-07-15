/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Curso;

/**
 *
 * @author Miguel Diaz
 * @author Pablo López
 */

import javax.persistence.EntityManagerFactory;

public interface FabricaTipoUsuario {

    public abstract CActividad crearActividad(EntityManagerFactory emf, int idSC);

    public abstract CRecurso crearRecurso(EntityManagerFactory emf, int idSC);

}
