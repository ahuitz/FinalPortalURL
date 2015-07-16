/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Curso;

import Tablas.Persona;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author EST1629311
 */
public class ModeloTablaEstudiante extends AbstractTableModel {
    private ArrayList<Persona> estudiantes;
    private String columnas[] = {"Carnet","Nombre", "Apellido"};

    public ModeloTablaEstudiante(ArrayList<Persona> estudiantes) {
        this.estudiantes=estudiantes;
      
    }
    
    
    @Override
    public int getRowCount() {
        return estudiantes.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Persona est= this.estudiantes.get(rowIndex);
        
        switch(columnIndex){
            case 0: return est.getCarne();
            case 1: return est.getNombre();
            case 2: return est.getApellido();
            
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: estudiantes.get(rowIndex).setCarne((String)aValue);
                break;
            case 1: 
                estudiantes.get(rowIndex).setNombre((String)aValue);
                break;
            case 2: 
                estudiantes.get(rowIndex).setApellido((String)aValue);
                break;
                
            default:
                
                break;
        }
    }
    
}
