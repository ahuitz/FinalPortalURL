/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursos;

import javax.swing.table.AbstractTableModel;
import Tablas.Trecurso;
import java.util.List;

/**
 *
 * @author Pablo López
 */
public class ModeloTablaRecursos extends AbstractTableModel {
    private final List<Trecurso> recursos;
    private final String columnas[] = {"Fecha publicación", "Titulo"};

    public ModeloTablaRecursos(List<Trecurso> recursos) {
        this.recursos = recursos;
    }
    
    
    @Override
    public int getRowCount() {
        return recursos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Trecurso rcs = this.recursos.get(rowIndex);
        switch(columnIndex){
            case 0: return rcs.getFechaPublicacion();
            case 1: return rcs.getTitulo();
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
            case 0: recursos.get(rowIndex).setFechaPublicacion((String)aValue);
                break;
            case 1: 
                recursos.get(rowIndex).setTitulo((String)aValue);
                break;
            default:
                break;
                
                
        }
    }
    
}
