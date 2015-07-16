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
        List<ListaEntregaActiv> miListaEntAct = miClaseLisEntActiv.cargarDatosListEntregaActividad();
        ClaseSecCurso_EstSecc_EntAct miClaseSecCur_EstuSec_EntrActi = new ClaseSecCurso_EstSecc_EntAct();
        miClaseSecCur_EstuSec_EntrActi.setMiListEntAct(miListaEntAct);
        miClaseSecCur_EstuSec_EntrActi.setMiListSecCur_EstuSecc(miListaSecCurso_EstuSec);
        List<ListaSecCurso_EstuSec_EntAct> miListaSecCurs_EstuSec_EntrActi = miClaseSecCur_EstuSec_EntrActi.cargarDatosSecCur_EstuSuc_EntAct();
        
        
        
//        System.out.println("");
//        System.out.println("OTROOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
//        Iterator<ListaSecCurso_EstuSec_EntAct> iteradorLisSecCur_EstuSec_EntAct = miListaSecCurs_EstuSec_EntrActi.iterator();
//        while (iteradorLisSecCur_EstuSec_EntAct.hasNext()) { 
//            ListaSecCurso_EstuSec_EntAct ListaSecCur_EstSec_EntAct = iteradorLisSecCur_EstuSec_EntAct.next();
//            System.out.println(ListaSecCur_EstSec_EntAct);
//        }
    }
    
}




























