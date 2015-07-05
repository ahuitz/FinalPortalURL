/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursos.administrador;

import javax.persistence.EntityManagerFactory;
import Tablas.Tcurso;
import Controladores.TcursoJpaController;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RealG4Life
 */
public class ModificarCurso implements Consulta{

    Tcurso curso;

    public ModificarCurso(Object curso) {
        this.curso = (Tcurso) curso;
    }
    
    @Override
    public void instruccion(EntityManagerFactory efm) {
        TcursoJpaController conCurso = new TcursoJpaController(efm);
        try {
            conCurso.edit(curso);
        } catch (Exception ex) {
            Logger.getLogger(ModificarCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
