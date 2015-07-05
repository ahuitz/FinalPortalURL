/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursos;

/**
 *
 * @author Miguel Diaz
 * @author Pablo López
 */

import javax.persistence.EntityManagerFactory;

public interface FabricaTipoUsuario {

    public abstract Actividad crearActividad(EntityManagerFactory emf);

    public abstract Recurso crearRecurso(EntityManagerFactory emf);

}
