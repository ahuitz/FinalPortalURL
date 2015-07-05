/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursos;

import Controladores.TrecursoJpaController;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Pablo López
 */
public class FabricaCatedratico implements FabricaTipoUsuario {

  public FabricaCatedratico() {
  }

  public Actividad crearActividad(Object emf) {
      return null;
  }

  public Recurso crearRecurso(EntityManagerFactory emf) {
      return new R_Catedratico(new TrecursoJpaController(emf));
  }

    @Override
    public Actividad crearActividad(EntityManagerFactory emf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}