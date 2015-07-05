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
public class Administracion {
    
    private EntityManagerFactory emf;

    public Administracion(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public void crearCurso(Tcurso curso){
        TcursoJpaController controlador = new TcursoJpaController(emf);
        controlador.create(curso);
    }
    
    
}
