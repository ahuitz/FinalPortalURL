/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursos;

import Controladores.RecursoJpaController;
import Tablas.Recurso;
import java.util.ArrayList;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Pablo López
 */
public class R_Estudiante extends CRecurso {

    public R_Estudiante(EntityManagerFactory emf, int idSC) {
        this.controladorR = new RecursoJpaController(emf);
        this.recursos = (ArrayList<Recurso>) controladorR.findRecursoEntities();
        this.idSeccionCurso=idSC;
    }

    @Override
    public void visualizar() {
    }

}
