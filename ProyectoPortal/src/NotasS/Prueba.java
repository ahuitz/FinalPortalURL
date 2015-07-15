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


        ClaseListSecCurso miClaseLisSecCurso = new ClaseListSecCurso();
        miClaseLisSecCurso.cargarDatosListSeccionCurso();
        
        ClaseListEstuSeccion miClaseLisEstuSecc = new ClaseListEstuSeccion();
        miClaseLisEstuSecc.cargarListaEstudianteSeccion();
        
        
        ClaseListEntregaActiv miClaseLisEntActiv = new ClaseListEntregaActiv();
        miClaseLisEntActiv.cargarDatosListEntregaActividad();
        
        
        
        
    }
    
}




























