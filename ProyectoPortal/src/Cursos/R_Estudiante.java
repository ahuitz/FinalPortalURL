/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursos;

import Controladores.TrecursoJpaController;
import Tablas.Trecurso;
import java.util.ArrayList;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Pablo López
 */
public class R_Estudiante extends Recurso {

    public R_Estudiante(EntityManagerFactory emf, int idSC) {
        this.controladorR = new TrecursoJpaController(emf);
        this.recursos = (ArrayList<Trecurso>) controladorR.findTrecursoEntities();
        this.idSeccionCurso=idSC;
    }

    @Override
    public void visualizar() {
    }

}
