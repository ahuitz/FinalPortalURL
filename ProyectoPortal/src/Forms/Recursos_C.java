/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Cursos.ModeloTablaRecursos;
import Cursos.R_Catedratico;
import Tablas.Recurso;
import java.util.ArrayList;

/**
 *
 * @author Pablo López
 */
public class Recursos_C extends Recursos {
    private static Recursos_C rc;
    
    private Recursos_C(R_Catedratico recursoC) {
        this.r=recursoC;
        this.TablaRecursos.setModel(new ModeloTablaRecursos(r.getRecursos()));
        for(int i=0;i<TablaRecursos.getModel().getColumnCount();i++){
            for(int j=0;j<TablaRecursos.getModel().getRowCount();j++){
                TablaRecursos.getModel().isCellEditable(i, j);                
            }
        }
    }
    
    public static Recursos_C getRecursos_C(R_Catedratico recursoC){
        if(rc==null){
            rc=new Recursos_C(recursoC);
        }
        return rc;
    }   
    
    public void actualizarLista(){
        r.setRecursos((ArrayList<Recurso>) r.getControladorR().findRecursoEntities());
        this.TablaRecursos.setModel( new ModeloTablaRecursos(r.getRecursos()));        
    }
    
}
