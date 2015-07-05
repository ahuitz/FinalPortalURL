/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursos;

import Controladores.TactividadJpaController;
import Controladores.TdetalleEntregaJpaController;
import Controladores.TentregaJpaController;
import Controladores.TrecursoJpaController;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Pablo López
 */
public class FabricaCatedratico implements FabricaTipoUsuario {

    public FabricaCatedratico() {
    }
    
    @Override
    public Actividad crearActividad(EntityManagerFactory emf, int idSC) {
        return new A_Catedratico(new TactividadJpaController(emf), new TdetalleEntregaJpaController(emf), idSC);
    }
    
    @Override
    public Recurso crearRecurso(EntityManagerFactory emf, int idSC) {
        return new R_Catedratico(emf, idSC);
    }

}
