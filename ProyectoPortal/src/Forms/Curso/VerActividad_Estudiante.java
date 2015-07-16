/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms.Curso;

import Controladores.ActividadJpaController;
import Curso.A_Estudiante;
import Curso.CCurso;
import Tablas.*;

import Tablas.Actividad;
import java.awt.Color;
import java.util.Calendar;

import java.util.Date;

/**
 *
 * @author Diaz
 */
public class VerActividad_Estudiante extends VerActividad {

    Entrega e;
    public VerActividad_Estudiante(CCurso curso,int idActividad) {
        iniciarComponentes();
        this.curso=curso;
        this.idActividad=idActividad;
        this.curso=curso;
        this.idActividad=idActividad;
        A_Estudiante a=((A_Estudiante)(curso.getActividad()));
        a.obtenerEntrega(idActividad);
        
       
        
    }
    public VerActividad_Estudiante(CCurso curso,Actividad actividad) {
        this.curso=curso;
        this.idActividad=idActividad;
        System.out.println(verDisponiblidad(actividad));
        iniciarComponentes();
        
       
        
    }
    @Override
    public void iniciarComponentes() {
        Boton3.setVisible(false);
        Boton4.setVisible(false);
        
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
        //Actividad actividad= curso.actividad.obtenerActividad(idActividad);
        //Entrega entrega=curso.actividad.obtenerEntrega(idActividad);
        String n=actividad.getTitulo();
        Etiqueta1.setForeground(Color.BLACK);
         Etiqueta1.setText(n);
        AreaTexto.setText(actividad.getDescripcion());
        Etiqueta9.setText(actividad.getFechaEntrega().toString());
        if(e.getRealizada()){
          Etiqueta7.setText("Entregada");  
        }else{
          Etiqueta7.setText("Aun no se entrega");  
            
        }
        
        
        long en= actividad.getFechaEntrega().getTime();
        long horaSistema=Calendar.getInstance().getTime().getTime();
        long extra= actividad.getTiempoextra().getTime();
        long nuevos= en-horaSistema;
        
        
        String formato;
        if(nuevos<0){
            nuevos=nuevos*(-1);
            formato="retrasada por:";
            Etiqueta10.setForeground(Color.red);
        }else{
            formato="faltan: ";
            Etiqueta10.setForeground(Color.BLACK);
        }
        long dias=(((((nuevos)/1000)/60)/60)/24)%365;
        long horas=((((nuevos)/1000)/60)/60)%24;
        long minutos=(((nuevos)/1000)/60)%60;
        if(dias>0){
            formato=formato+dias+" dias ";
        }
        if(horas>0){
            formato=formato+horas+" horas ";
        }
        if(minutos>0){
            formato=formato+minutos+" minutos ";
        } 
        Etiqueta10.setText(formato);
        if((extra-horaSistema)<0){
            Boton1.setVisible(false);
            
            return false;
        }
      
        return true;
        
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
