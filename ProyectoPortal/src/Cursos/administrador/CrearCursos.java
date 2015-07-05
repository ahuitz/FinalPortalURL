/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursos.administrador;

import javax.persistence.EntityManagerFactory;
import Tablas.Tcurso;
import Tablas.Tciclo;
import Tablas.TcursoCiclo;
import Controladores.TcursoJpaController;
import Controladores.TcicloJpaController;
import Controladores.TcursoCicloJpaController;

/**
 *
 * @author Cristian
 */
public class CrearCursos implements Consulta{
    
    Tcurso curso;
    int year;
    int idciclo;
    int idcursociclo;

    public CrearCursos(Object curso, int idciclo, int year) {
        this.curso = (Tcurso) curso;
        this.year = year;
    }
    
    @Override
    public void instruccion(EntityManagerFactory efm) {
        TcursoJpaController conCurso = new TcursoJpaController(efm);
        conCurso.create(curso);
        
        TcursoCiclo cursociclo = new TcursoCiclo(idcursociclo, idciclo, curso.getId(), year);
        TcursoCicloJpaController conCursoCiclo = new TcursoCicloJpaController(efm);
        conCursoCiclo.create(cursociclo);
    }
    
}
