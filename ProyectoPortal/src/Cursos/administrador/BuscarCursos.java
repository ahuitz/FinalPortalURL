/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursos.administrador;

import javax.persistence.EntityManagerFactory;
import Controladores.TcursoJpaController;
import Controladores.TcicloJpaController;
import Controladores.TseccionJpaController;
import Controladores.TcursoCicloJpaController;
import javax.persistence.Query;

/**
 *
 * @author RealG4Life
 */
public class BuscarCursos implements Consulta{
    
    Query q;

    @Override
    public void instruccion(EntityManagerFactory efm) {
        q = efm.createEntityManager().createNamedQuery("SELECT ");
        TcursoJpaController conCurso = new TcursoJpaController(efm);
        conCurso.findTcursoEntities();
    }
    
    
}
