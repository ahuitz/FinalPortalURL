/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Curso;


import Tablas.Entrega;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel Diaz
 */
public class Entregas {

  private int idActividad;
  private List<Entrega> entregas;
  
  public Entregas(int idActividad, List<Entrega> E) {
      this.idActividad=idActividad;
      this.entregas=E;
      
  }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public List<Entrega> getEntregas() {
        return entregas;
    }

    public void setEntregas(List<Entrega> entregas) {
        this.entregas = entregas;
    }
  

}