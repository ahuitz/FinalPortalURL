/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Curso;


import Tablas.Archivo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author EST1629311
 */
public class ModeloTablaArchivos extends AbstractTableModel {
    private List<Archivo> archivos;
    private String columnas[] = {"Nombre","Extension", "Tamano"};

    public ModeloTablaArchivos(List<Archivo> archivos) {
      this.archivos= archivos; 
      
    }

    public List<Archivo> getArchivos() {
        return archivos;
    }
    
    
    @Override
    public int getRowCount() {
        return archivos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Archivo arch= this.archivos.get(rowIndex);
        
        switch(columnIndex){
            case 0: return arch.getNombre();
            case 1: return arch.getExtension();
            case 2: return arch.getTamanio();
            
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
            case 0: archivos.get(rowIndex).setNombre((String)aValue);
                break;
            case 1: 
                archivos.get(rowIndex).setExtension((String)aValue);
                break;
            case 2: 
                archivos.get(rowIndex).setTamanio((double)aValue);
                break;
             
                
                
            default:
                
                break;
                
                
        }
    }
    
}
