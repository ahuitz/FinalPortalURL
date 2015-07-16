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
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JRadioButton;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Diaz
 */
public class ModeloTablaEntregas extends AbstractTableModel{
    
    private List<Entrega> entregas;
    private List<Integer> usuarios;
    private List<Persona> personas;
    private CCurso curso;
    
    private String columnas[] = {"Carne","Nombre","Apellido","Entregada", "Punteo"};
                            
    Class[] types = new Class[]{
                            java.lang.String.class,
                            java.lang.String.class,
                            java.lang.String.class,
                            java.lang.Boolean.class,
                            java.lang.Double.class,
                            };

    public ModeloTablaEntregas(List<Entrega> entregas, List<Integer> usuarios, List<Persona> personas,CCurso curso) {
        this.entregas = entregas;
        this.usuarios = usuarios;
        this.personas = personas;
        this.curso=curso;
    }

    public List<Entrega> getEntregas() {
        return entregas;
    }

    public void setEntregas(ArrayList<Entrega> entregas) {
        this.entregas = entregas;
    }
    
    @Override
    public int getRowCount() {
        return entregas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }
    private Usuario BuscarUsuario(int id){
        Query q;
        EntityManager em=curso.getActividad().getEmf().createEntityManager();
        q=em.createNamedQuery("Usuario.findById");
        q.setParameter("id", id);
        return (Usuario) q.getSingleResult();
        
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        
        switch (columnIndex) {
            case 0:
                for(Entrega e: entregas){
                    for (Integer i: usuarios){
                        if(e.getUsuarioid()==i){
                            for(Persona p: personas){
                                if(p.getId()== (BuscarUsuario(i)).getPersonaid()){
                                 return p.getCarne();
                                }
                            }
                        }
                    }
                }

                return null;
            case 1:
                for(Entrega e: entregas){
                    for (Integer i: usuarios){
                        if(e.getUsuarioid()==i){
                            for(Persona p: personas){
                                if(p.getId()== (BuscarUsuario(i)).getPersonaid()){
                                 return p.getNombre();
                                }
                            }
                        }
                    }
                }

                return null;
            case 2:
                for(Entrega e: entregas){
                    for (Integer i: usuarios){
                        if(e.getUsuarioid()==i){
                            for(Persona p: personas){
                                if(p.getId()== (BuscarUsuario(i)).getPersonaid()){
                                 return p.getApellido();
                                }
                            }
                        }
                    }
                }

                return null;
            case 3:
               Integer u = usuarios.get(rowIndex);
                for (Entrega e : entregas) {
                    if (u == e.getUsuarioid()) {
                        
                        if (e.getNoRealizada()) {
                            return true;

                        }else{
                            return false;
                        }
                        
                    }
                }

                return null;

            case 4:
                u = usuarios.get(rowIndex);
                for (Entrega e : entregas) {
                    if (u == e.getUsuarioid()) {
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
        switch(columnIndex){
            case 2: entregas.get(rowIndex);
                break;
            case 3: 
                entregas.get(rowIndex).setNoRealizada((boolean) aValue);
                break;
            case 4: 
                entregas.get(rowIndex).setCalificacion((double) aValue);
                break;
                
            default:
                
                break;
        }
    }
    
    public Entrega obtenerEntrega(int columnIndex) {

        Integer u = usuarios.get(columnIndex);
        for (Entrega e : entregas) {
            if (u == e.getUsuarioid()) {
                return e;
            }
        }
        return null;
    }


}
