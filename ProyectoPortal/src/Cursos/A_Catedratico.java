
package Cursos;

import Tablas.Tactividad;
import Tablas.Tentrega;
import java.util.ArrayList;
import java.util.Vector;

public class A_Catedratico extends Actividad {

    public ArrayList<Tactividad> actividades;
    public Controladores.TactividadJpaController controladorA;
    public Controladores.TdetalleEntregaJpaController controladorE;
    public ArrayList<Entrega> entregas;

    public A_Catedratico(Controladores.TactividadJpaController controladorA, Controladores.TdetalleEntregaJpaController controladorE) {
        this.controladorA = controladorA;
        this.controladorE = controladorE;
    }

    public void agregarEntrega(int idActividad, Object controladorE) {
    }

    public void calificarEntrega(Tentrega entrega, Double calificacion) {
    }

    public void modificarActividad(Tactividad actividad) {
    }

    public void publicarActividad(Tactividad actividad) {
    }

    @Override
    public void visualizarActividad() {
    }

}