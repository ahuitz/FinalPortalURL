/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Curso;

import Controladores.EntregaJpaController;
import Tablas.Entrega;
import java.util.ArrayList;

/**
 *
 * @author Miguel Diaz
 */
public class Entregas {

  public int idActividad;
  public ArrayList<Entrega> entregas;
  
  public Entregas(int idActividad, EntregaJpaController controladorE) {
      this.idActividad=idActividad;
      entregas=(ArrayList<Entrega>)controladorE.findEntregaEntities();
      
  }

}