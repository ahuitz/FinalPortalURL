/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms.Curso;

import Curso.ModeloTablaRecurso;
import Curso.R_Estudiante;
import Tablas.Recurso;
import java.util.ArrayList;

/**
 *
 * @author Pablo López
 */
public class Recurso_E extends PrincipalRecurso {
    
    public Recurso_E(R_Estudiante recursoE) {
        setIconifiable(Boolean.TRUE);
        setVisible(Boolean.TRUE);
        setClosable(Boolean.TRUE);
        //setResizable(Boolean.TRUE);
        this.botonCrearR.setVisible(false);
        this.jMenuItemModificar.setVisible(false);
        this.r=recursoE;
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
