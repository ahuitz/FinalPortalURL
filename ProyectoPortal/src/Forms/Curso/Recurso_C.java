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
    
    public Recurso_C(R_Catedratico recursoC) {
        setIconifiable(Boolean.TRUE);
        setVisible(Boolean.TRUE);
        setClosable(Boolean.TRUE);
        //setResizable(Boolean.TRUE);
        this.r=recursoC;
        this.TablaRecursos.setModel(new ModeloTablaRecurso(r.getRecursos()));
        for(int i=0;i<TablaRecursos.getModel().getColumnCount();i++){
            for(int j=0;j<TablaRecursos.getModel().getRowCount();j++){
                TablaRecursos.getModel().isCellEditable(i, j);                
            }
        }
    }
    
    public void actualizarLista(){
        r.setRecursos((ArrayList<Recurso>) r.getControladorR().findRecursoEntities());
        this.TablaRecursos.setModel(new ModeloTablaRecurso(r.getRecursos()));        
    }
    
}
