package Cursos;
import Cursos.Actividad;
import java.util.Vector;
import Controladores.TactividadJpaController;
import Controladores.TentregaJpaController;
import javax.persistence.EntityManagerFactory;

public class FabricaEstudiante implements FabricaTipoUsuario {

  public FabricaEstudiante() {
  
  }

  public Actividad crearActividad(EntityManagerFactory emf) {
  Actividad actividad = new A_Estudiante( new TactividadJpaController(emf),new TentregaJpaController(emf) );
  return actividad;       
  }

  public Recurso crearRecurso(Object emf) {
  return null;
  }

    @Override
    public Recurso crearRecurso(EntityManagerFactory emf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}