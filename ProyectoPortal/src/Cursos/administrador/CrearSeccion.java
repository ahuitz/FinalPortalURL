/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursos.administrador;

import javax.persistence.EntityManagerFactory;
import Tablas.Tseccion;
import Controladores.TseccionJpaController;

/**
 *
 * @author Cristian
 */
public class CrearSeccion implements Consulta{
    
    Tseccion seccion;
    String aula;
    int idcurso;
    int cupo;

    public CrearSeccion(Object seccion, String aula, int idcurso, int cupo) {
        this.seccion = (Tseccion) seccion;
        this.aula = aula;
        this.idcurso = idcurso;
        this.cupo = cupo;
    }
    
    @Override
    public void instruccion(EntityManagerFactory efm) {
        TseccionJpaController controlador_seccion = new TseccionJpaController(efm);
        controlador_seccion.create(seccion);
    }
    
}
