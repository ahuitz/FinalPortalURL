package Cursos;

import Tablas.Tactividad;
import Tablas.Tentrega;
import java.util.ArrayList;
import Controladores.TactividadJpaController;
import Controladores.TentregaJpaController;

public class A_Estudiante extends Actividad {

    public ArrayList<Tactividad> actividades;

    public TactividadJpaController controladorA;

    public TentregaJpaController controladorE;

    public ArrayList<Tentrega> entregas;

    public A_Estudiante(TactividadJpaController controladorA, TentregaJpaController controladorE) {
        this.controladorA = controladorA;
        this.controladorE = controladorE;
    }

    public void modificarEntrega(Tentrega entrega) {
    }

    public void realizarEntrega(Tentrega entrega) {
    }
    @Override
    public void visualizarActividad() {
    }

}
