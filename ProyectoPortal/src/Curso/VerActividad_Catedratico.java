/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Curso;

import Controladores.ActividadJpaController;
import Tablas.Actividad;
import Cursos.Curso;

/**
 *
 * @author Diaz
 */
public class VerActividad_Catedratico extends VerActividad{
    
    
    
    
    public VerActividad_Catedratico(Curso curso,ActividadJpaController controladorActividad,int idActividad){
        this.curso=curso;
        this.controladorActividad=controladorActividad;
        this.idActividad=idActividad;
    }

    @Override
    public void iniciarComponentes() {
        Boton3.setVisible(true);
        Boton2.setVisible(false);
        Boton1.setVisible(false);
        
    }
    
    @Override
    public void modificarActividad() {
       NuevaActividad actividad = new NuevaActividad(curso.actividad.obtenerActividad(idActividad));
    }

    @Override
    public void modificarEntrega() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verDisponiblidad() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarEntrega() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void calificar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   

    
}
