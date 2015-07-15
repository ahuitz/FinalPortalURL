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
        int Cursoid = 5;
        int SeccionId = 2;
        ClaseListSecCurso miClaseLisSecCurso = new ClaseListSecCurso();
        List<ListaSecCurso> miListaSecCurso = miClaseLisSecCurso.cargarDatosListSeccionCurso(UsuaCatId);
        ClaseListaPorCurso miListaPorCurso = new ClaseListaPorCurso();
        miListaSecCurso = miListaPorCurso.encontraPorCurso(miListaSecCurso, Cursoid, SeccionId);
        
        
        ClaseListEstuSeccion miClaseLisEstuSecc = new ClaseListEstuSeccion();
        List<ListaEstuSeccion> miListaEstuSecc = miClaseLisEstuSecc.cargarListaEstudianteSeccion();
        ClasePorSeccCurso_EstuSecc miClasPorSecCur = new ClasePorSeccCurso_EstuSecc();
        miClasPorSecCur.setMiListSeccionCurso(miListaSecCurso);
        miClasPorSecCur.setMiListEstuSeccion(miListaEstuSecc);
        List<ListaSecCurso_EstuSec> miListaSecCurso_EstuSec = miClasPorSecCur.cargarDatosListasSecCurso_EstuSecc();
        
        
        
        
        ClaseListEntregaActiv miClaseLisEntActiv = new ClaseListEntregaActiv();
        miClaseLisEntActiv.cargarDatosListEntregaActividad();
        
        
        
//        System.out.println("");
//        System.out.println("OTROOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
//        Iterator<ListaSecCurso_EstuSec> iteradorLisSecCur_EstuSec = miListaSecCurso_EstuSec.iterator();
//        while (iteradorLisSecCur_EstuSec.hasNext()) { 
//            ListaSecCurso_EstuSec ListaSecCur_EstSec = iteradorLisSecCur_EstuSec.next();
//            System.out.println(ListaSecCur_EstSec );
//        }
    }
    
}




























