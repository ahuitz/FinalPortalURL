/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursos.administrador;

import javax.persistence.EntityManagerFactory;
import Tablas.Tcurso;
import Controladores.TcursoJpaController;

/**
 *
 * @author Cristian
 */
public class CrearCurso implements Consulta{

    Tcurso curso;

    public CrearCurso(Tcurso curso) {
        this.curso = curso;
    }
          
    @Override
    public void instruccion(EntityManagerFactory efm) {
        TcursoJpaController controlador = new TcursoJpaController(efm);
        controlador.create(curso);
    }
    
}
