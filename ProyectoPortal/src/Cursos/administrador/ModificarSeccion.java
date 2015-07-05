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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablito Garzona
 */
public class ModificarSeccion implements Consulta {
     Tseccion seccion;
    String aula;
    int idcurso;
    int cupo;
    int seccioncursoid;
    
     public ModificarSeccion(Object seccion) {
        this.seccion = (Tseccion) seccion;
        
    }

    @Override
    public void instruccion(EntityManagerFactory efm) {
        
         TseccionJpaController conSeccion = new TseccionJpaController(efm);
         try {
             conSeccion.edit(seccion);
         } catch (Exception ex) {
             Logger.getLogger(ModificarSeccion.class.getName()).log(Level.SEVERE, null, ex);
         }
        
              
    }
}
