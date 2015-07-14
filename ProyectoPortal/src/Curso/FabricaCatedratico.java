/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Curso;

import Controladores.ActividadJpaController;
import Controladores.DetalleentregaJpaController;
import Controladores.EntregaJpaController;
import Controladores.RecursoJpaController;
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
        return new A_Catedratico(new ActividadJpaController(emf), new EntregaJpaController(emf), idSC);
    }
    
    @Override
    public CRecurso crearRecurso(EntityManagerFactory emf, int idSC) {
        return new R_Catedratico(emf, idSC);
    }

}
