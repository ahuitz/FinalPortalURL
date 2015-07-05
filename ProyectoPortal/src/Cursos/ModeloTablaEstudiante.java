/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos;

import Tablas.Tpersona;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author EST1629311
 */
public class ModeloTablaEstudiante extends AbstractTableModel {
    private ArrayList<Tpersona> estudiantes;
    private String columnas[] = {"Nombre", "Apellido", "Edad"};

    public ModeloTablaEstudiante(ArrayList<Tpersona> estudiantes) {
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
        Tpersona est= this.estudiantes.get(rowIndex);
        
        switch(columnIndex){
            case 0: return est.getCarne();
            case 1: return est.getNombre();
            case 2: return est.getApellido();
            case 3: return est.getEstado();
            
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
            case 0: estudiantes.get(rowIndex).setCarne((String)aValue);
                break;
            case 1: 
                estudiantes.get(rowIndex).setNombre((String)aValue);
                break;
            case 2: 
                estudiantes.get(rowIndex).setApellido((String)aValue);
                break;
             case 3: 
                estudiantes.get(rowIndex).setEstado((Boolean)aValue);
                break;   
                
                
            default:
                
                break;
                
                
        }
    }
    
}
