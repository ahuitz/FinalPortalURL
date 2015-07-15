/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NotasS;

import Conexion.*;
import Controladores.*;
import Tablas.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Query;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Saul
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int UsuaCatId = 4;
        int Cursoid = 2;
        ClaseListSecCurso miClaseLisSecCurso = new ClaseListSecCurso();
        List<ListaSecCurso> miListaSecCurso = miClaseLisSecCurso.cargarDatosListSeccionCurso(UsuaCatId);
        ClaseListaPorCurso miListaPorCurso = new ClaseListaPorCurso();
        miListaPorCurso.encontraPorCurso(miListaSecCurso, Cursoid);
        
        
        ClaseListEstuSeccion miClaseLisEstuSecc = new ClaseListEstuSeccion();
        miClaseLisEstuSecc.cargarListaEstudianteSeccion();
        
        
        ClaseListEntregaActiv miClaseLisEntActiv = new ClaseListEntregaActiv();
        miClaseLisEntActiv.cargarDatosListEntregaActividad();
        
        
        
        
    }
    
}




























