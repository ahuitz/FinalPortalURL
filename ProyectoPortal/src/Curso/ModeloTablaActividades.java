/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Curso;


import Controladores.TipoactividadJpaController;
import Tablas.Actividad;
import Tablas.Archivo;
import Tablas.Tipoactividad;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author EST1629311
 */
public class ModeloTablaActividades extends AbstractTableModel {
    private List<Actividad> actividades;
    private List<Tipoactividad>listaActividad;
    private String columnas[] = {"Titulo","FechaEntrega", "Tipo de Actividad"};

    public ModeloTablaActividades(List<Actividad> act,String rol) {
        if (act != null) {
            List<Actividad> n = new ArrayList<>();
            for (Actividad a : act) {
                if (rol.compareTo("CAT") == 0) {
                    n.add(a);
                } else {
                    if (a.getVirtual()) {
                        n.add(a);
                    }

                }
            }
            this.actividades = n;
        }

      TipoactividadJpaController controlador = new TipoactividadJpaController(Forms.FormularioUsuarios1.conexion.getEmf());
        listaActividad=controlador.findTipoactividadEntities();
      
    }

    public List<Actividad> getActividades() {
        return actividades;
    }
    
    
    @Override
    public int getRowCount() {
        return actividades.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Actividad a= this.actividades.get(rowIndex);
        
        switch(columnIndex){
            case 0: return a.getTitulo();
            case 1: return a.getFechaEntrega();
            case 2: 
                for(Tipoactividad t:listaActividad){
                    if(a.getTipoActividadid()==t.getId())return t.getTipoActividad();
                }
                
                
            
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
        
    }
    
}
