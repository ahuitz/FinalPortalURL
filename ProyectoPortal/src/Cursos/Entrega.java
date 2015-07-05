/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursos;

import Controladores.TentregaJpaController;
import Tablas.Tentrega;
import java.util.ArrayList;

/**
 *
 * @author Miguel Diaz
 */
public class Entrega {

  public int idActividad;
  public ArrayList<Tentrega> entregas;
  
  public Entrega(int idActividad, TentregaJpaController controladorE) {
      this.idActividad=idActividad;
      entregas=(ArrayList<Tentrega>) controladorE.findTentregaEntities();
      
  }

}