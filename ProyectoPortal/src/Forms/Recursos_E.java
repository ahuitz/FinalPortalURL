/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Cursos.ModeloTablaRecursos;
import Cursos.R_Estudiante;
import Tablas.Trecurso;
import java.util.ArrayList;

/**
 *
 * @author Pablo López
 */
public class Recursos_E extends Recursos {
    private static Recursos_E re;

    private Recursos_E(R_Estudiante recursoE) {
        this.botonCrearR.setVisible(false);
        this.botonModificarR.setVisible(false);
        this.r=recursoE;
        this.TablaRecursos.setModel(new ModeloTablaRecursos(r.getRecursos()));
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
    
    public void actualizarLista(){
        r.setRecursos((ArrayList<Trecurso>) r.getControladorR().findTrecursoEntities());
        this.TablaRecursos.setModel( new ModeloTablaRecursos(r.getRecursos()));        
    }
    
}
