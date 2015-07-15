/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms.Curso;

import Controladores.ActividadJpaController;
import Tablas.Actividad;
import Curso.Curso;
import java.awt.Color;

/**
 *
 * @author Diaz
 */
public class VerActividad_Catedratico extends VerActividad{
    
    
    
    
    public VerActividad_Catedratico(Curso curso,int idActividad){
        this.curso=curso;
        this.idActividad=idActividad;
    }
    
    public VerActividad_Catedratico(Curso curso, Actividad a){
        this.curso=curso;
        this.idActividad=idActividad;
        this.actividad=a;
        iniciarComponentes();
        verDisponiblidad(a);
    }
    @Override
    public void iniciarComponentes() {
        Boton3.setVisible(true);
        Boton1.setVisible(false);
        
    }
    
    @Override
    public void modificarActividad() {
     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      
    }

    @Override
    public void modificarEntrega() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verDisponiblidad(Actividad actividad) {
        String n=actividad.getTitulo();
        Etiqueta1.setForeground(Color.BLACK);
         Etiqueta1.setText(n);
        AreaTexto.setText(actividad.getDescripcion());
        Etiqueta9.setText(actividad.getFechaEntrega().toString());
        Etiqueta7.setText("----------");
        Etiqueta8.setText("----------");
        Etiqueta10.setText("----------");
        return true;
    }

    @Override
    public void agregarEntrega() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void calificar() {
        
    }
   

    
}
