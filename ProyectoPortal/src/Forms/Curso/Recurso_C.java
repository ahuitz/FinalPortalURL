/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms.Curso;

import Curso.ModeloTablaRecurso;
import Curso.R_Catedratico;
import Tablas.Recurso;
import java.util.ArrayList;

/**
 *
 * @author Pablo López
 */
public class Recurso_C extends PrincipalRecurso {
    private static Recurso_C rc;
    
    private Recurso_C(R_Catedratico recursoC) {
        this.r=recursoC;
        this.TablaRecursos.setModel(new ModeloTablaRecurso(r.getRecursos()));
        for(int i=0;i<TablaRecursos.getModel().getColumnCount();i++){
            for(int j=0;j<TablaRecursos.getModel().getRowCount();j++){
                TablaRecursos.getModel().isCellEditable(i, j);                
            }
        }
    }
    
    public static Recurso_C getRecursos_C(R_Catedratico recursoC){
        if(rc==null){
            rc=new Recurso_C(recursoC);
        }
        return rc;
    }   
    
    public void actualizarLista(){
        r.setRecursos((ArrayList<Recurso>) r.getControladorR().findRecursoEntities());
        this.TablaRecursos.setModel(new ModeloTablaRecurso(r.getRecursos()));        
    }
    
}
