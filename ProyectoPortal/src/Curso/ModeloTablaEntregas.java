/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Curso;

import Tablas.Entrega;
import Tablas.Persona;
import Tablas.Usuario;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Diaz
 */
public class ModeloTablaEntregas extends AbstractTableModel{
    
    private ArrayList<Entrega> entregas;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Persona> personas;
    
    private String columnas[] = {"Carne","Nombre","Apellido","Entregada", "Punteo"};
                            
    Class[] types = new Class[]{
                            java.lang.String.class,
                            java.lang.String.class,
                            java.lang.String.class,
                            java.lang.Boolean.class,
                            java.lang.Double.class,
                            };

    public ModeloTablaEntregas(ArrayList<Entrega> entregas, ArrayList<Usuario> usuarios, ArrayList<Persona> personas) {
        this.entregas = entregas;
        this.usuarios = usuarios;
        this.personas = personas;
    }

    public ArrayList<Entrega> getEntregas() {
        return entregas;
    }

    public void setEntregas(ArrayList<Entrega> entregas) {
        this.entregas = entregas;
    }
    
    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Entrega arch = this.entregas.get(rowIndex);

        switch (columnIndex) {
            case 0:
                Usuario u = usuarios.get(rowIndex);
                for (Persona p : personas) {
                    if (p.getId() == u.getPersonaid()) {
                        return p.getCarne();
                    }

                }

                return null;
            case 1:
                u = usuarios.get(rowIndex);
                for (Persona p : personas) {
                    if (p.getId() == u.getPersonaid()) {
                        return p.getNombre();
                    }

                }

                return null;
            case 2:
                u = usuarios.get(rowIndex);
                for (Persona p : personas) {
                    if (p.getId() == u.getPersonaid()) {
                        return p.getApellido();
                    }

                }

                return null;
            case 3:
                u = usuarios.get(rowIndex);
                for (Entrega e : entregas) {
                    if (u.getId() == e.getUsuarioid()) {
                        
                        if (e.getNoRealizada()) {
                            return false;

                        }
                        if (e.getRealizada()) {
                            return true;
                        }
                        
                    }
                }

                return null;

            case 4:
                u = usuarios.get(rowIndex);
                for (Entrega e : entregas) {
                    if (u.getId() == e.getUsuarioid()) {
                        return e.getCalificacion();
                    }
                }
                return null;

            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
    @Override
    public Class getColumnClass(int columnIndex) {
        return types[columnIndex];
    }   
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 4:
                entregas.get(rowIndex).setCalificacion((double) aValue);

        }
    }

    
    public Entrega obtenerEntrega(int columnIndex) {

        Usuario u = usuarios.get(columnIndex);
        for (Entrega e : entregas) {
            if (u.getId() == e.getUsuarioid()) {
                return e;
            }
        }
        return null;
    }


}
