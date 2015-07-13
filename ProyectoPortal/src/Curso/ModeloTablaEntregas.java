/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Curso;

import Tablas.Entrega;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Diaz
 */
public class ModeloTablaEntregas extends AbstractTableModel{
    private ArrayList<Entrega> entregas;
    private String columnas[] = {"Nombre","Extension", "Tamano"};

    public ModeloTablaEntregas(ArrayList<Entrega> Entregas) {
      this.entregas= Entregas; 
      
    }
    
    
    @Override
    public int getRowCount() {
        return entregas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Entrega arch= this.entregas.get(rowIndex);
        
        switch(columnIndex){
            case 0: return arch.getCalificacion();
            
            
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch(columnIndex){
            
                
                
        }
    }
    
}


