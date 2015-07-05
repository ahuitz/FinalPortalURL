/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursos.administrador;

import javax.persistence.EntityManagerFactory;
import Tablas.Tciclo;
import Controladores.TcicloJpaController;

/**
 *
 * @author RealG4Life
 */
public class CrearCiclo implements Consulta{
    
    Tciclo ciclo;

    public CrearCiclo(Object ciclo) {
        this.ciclo = (Tciclo) ciclo;
    }
    
    

    @Override
    public void instruccion(EntityManagerFactory efm) {
        TcicloJpaController conCiclo =  new TcicloJpaController(efm);
        conCiclo.create(ciclo);
    }
    
}
