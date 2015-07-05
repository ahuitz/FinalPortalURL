package Cursos;

import javax.persistence.EntityManagerFactory;

public interface FabricaTipoUsuario {

      
  public Actividad crearActividad(EntityManagerFactory emf);

  public Recurso crearRecurso(EntityManagerFactory emf);

}