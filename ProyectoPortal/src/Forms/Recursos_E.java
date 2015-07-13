/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Cursos.ModeloTablaRecurso;
import Cursos.R_Estudiante;
import Tablas.Recurso;
import java.util.ArrayList;

/**
 *
 * @author Pablo López
 */
public class Recursos_E extends Recursos {
    private static Recursos_E re;

    public Recursos_E() {
        //this.botonCrearR.setVisible(false);
        //this.botonModificarR.setVisible(false);
    }
    private Recursos_E(R_Estudiante recursoE) {
        this.botonCrearR.setVisible(false);
        this.botonModificarR.setVisible(false);
        this.r=recursoE;
        this.TablaRecursos.setModel(new ModeloTablaRecurso(r.getRecursos()));
        for(int i=0;i<TablaRecursos.getModel().getColumnCount();i++){
            for(int j=0;j<TablaRecursos.getModel().getRowCount();j++){
                TablaRecursos.getModel().isCellEditable(i, j);                
            }
        }
    }
    
    public static Recursos_E getRecursos_E(R_Estudiante recursoE){
        if(re==null){
            re=new Recursos_E(recursoE);
        }
        return re;
    }   
    
    private void actualizarLista(R_Estudiante recursoE){
        r=recursoE;
        r.setRecursos((ArrayList<Recurso>) r.getControladorR().findRecursoEntities());
        this.TablaRecursos.setModel(new ModeloTablaRecurso(r.getRecursos()));        
    }
    
}
