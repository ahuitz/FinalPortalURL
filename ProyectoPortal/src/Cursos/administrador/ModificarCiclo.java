/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursos.administrador;

import javax.persistence.EntityManagerFactory;
import Tablas.Tciclo;
import Controladores.TcicloJpaController;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Pablito Garzona
 */
public class ModificarCiclo implements Consulta{
    
    Tciclo ciclo;

    public ModificarCiclo(Object ciclo) {
        this.ciclo = (Tciclo) ciclo;
    }

    @Override
    public void instruccion(EntityManagerFactory efm) {
        
          TcicloJpaController conCiclo =  new TcicloJpaController(efm);
        try {
            conCiclo.edit(ciclo);
        } catch (Exception ex) {
            Logger.getLogger(ModificarCiclo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
