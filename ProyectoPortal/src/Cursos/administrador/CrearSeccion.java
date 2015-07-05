/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursos.administrador;

import javax.persistence.EntityManagerFactory;
import Tablas.Tseccion;
import Tablas.TseccionCursos;
import Controladores.TseccionJpaController;
import Controladores.TseccionCursosJpaController;

/**
 *
 * @author Cristian
 */
public class CrearSeccion implements Consulta{
    
    Tseccion seccion;
    String aula;
    int idcurso;
    int cupo;
    int seccioncursoid;

    public CrearSeccion(Object seccion, String aula, int idcurso, int cupo) {
        this.seccion = (Tseccion) seccion;
        this.aula = aula;
        this.idcurso = idcurso;
        this.cupo = cupo;
    }
    
    @Override
    public void instruccion(EntityManagerFactory efm) {
        TseccionJpaController conSeccion = new TseccionJpaController(efm);
        conSeccion.create(seccion);
        
        TseccionCursos seccionCursos = new TseccionCursos(seccioncursoid, cupo, seccion.getId(), 0, idcurso);
        TseccionCursosJpaController conSeccionCurso = new TseccionCursosJpaController(efm);
        conSeccionCurso.create(seccionCursos);
    }
    
}
