/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursos.administrador;

import javax.persistence.EntityManagerFactory;
import Controladores.TcursoJpaController;

/**
 *
 * @author RealG4Life
 */
public class BuscarCursos implements Consulta{
    
    

    @Override
    public void instruccion(EntityManagerFactory efm) {
        TcursoJpaController conCurso = new TcursoJpaController(efm);
        conCurso.findTcursoEntities();
    }
    
    
}
