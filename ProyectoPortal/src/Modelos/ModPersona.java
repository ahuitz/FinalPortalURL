/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Tablas.Persona;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Cliente
 */
public class ModPersona extends AbstractTableModel{

    private List<Persona> persona;
    private String atributos[] = {"Carné","Nombre","Apellido","Dirección","Télefono","Celular","DPI","Fecha Nacimiento","Genero","Tipo sangre","Estado"};
    
    public ModPersona(List<Persona> persona){
        this.persona = persona;
    }
    @Override
    
    public int getRowCount() {
        return persona.size();
    }

    @Override
    public int getColumnCount() {
        return atributos.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Persona per = this.persona.get(i);
        switch(i1){
            case 0:
                return per.getCarne();
            case 1:
                return per.getNombre();
            case 2: 
                return per.getApellido();
            case 3:
                return per.getDireccion();
            case 4:
                return per.getTelefono();
            case 5:
                return per.getCelular();
            case 6:
                return per.getDpi();
            case 7:
                return per.getFechaNac();
            case 8:
                return per.getGenero();
            case 9:
                return per.getTipoSangreid();
            case 10:
                return per.getEstado();
        }
        return null;
    }
    
    
    
    
}
