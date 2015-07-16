/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Curso;

import Controladores.RecursoJpaController;
import Tablas.Recurso;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Pablo López
 */
public class R_Estudiante extends CRecurso {

    public R_Estudiante(EntityManagerFactory emf, int idSC) {
        this.emf=emf;
        this.controladorR = new RecursoJpaController(this.emf);
        this.idSeccionCurso=idSC;
        this.recursos = obtenerRecursos();
    }
    
    @Override
    public List<Recurso> visualizar() {
        return recursos;
    }

}
