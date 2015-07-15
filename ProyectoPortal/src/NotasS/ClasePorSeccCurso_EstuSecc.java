/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NotasS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Saul
 */
public class ClasePorSeccCurso_EstuSecc {
    
    public List<ListaSecCurso> miListSeccionCurso;
    public List<ListaEstuSeccion> miListEstuSeccion;
    public List<ListaSecCurso_EstuSec> miListSecCur_EstuSecc;

    public List<ListaSecCurso> getMiListSeccionCurso() {
        return miListSeccionCurso;
    }

    public void setMiListSeccionCurso(List<ListaSecCurso> miListSeccionCurso) {
        this.miListSeccionCurso = miListSeccionCurso;
    }

    public List<ListaEstuSeccion> getMiListEstuSeccion() {
        return miListEstuSeccion;
    }

    public void setMiListEstuSeccion(List<ListaEstuSeccion> miListEstuSeccion) {
        this.miListEstuSeccion = miListEstuSeccion;
    }
    
    
    public List<ListaSecCurso_EstuSec> cargarDatosListasSecCurso_EstuSecc(){
        
        System.out.println("");
        System.out.println("CLASE POR SECCION CURSO & ESTUDIANTE SECCION /////////////////////////////////////////////");
        
        miListSecCur_EstuSecc = new ArrayList<ListaSecCurso_EstuSec>();
        if (miListEstuSeccion.size() >= miListSeccionCurso.size()) {
            Iterator<ListaEstuSeccion> iteradorListaEstSecc = miListEstuSeccion.iterator();
            while (iteradorListaEstSecc.hasNext()) { 
                ListaEstuSeccion ListaEstSecc = iteradorListaEstSecc.next();
                Iterator<ListaSecCurso> iteradorListaSeccCurso = miListSeccionCurso.iterator();
                while (iteradorListaSeccCurso.hasNext()) {                    
                    ListaSecCurso SeccCur1 = iteradorListaSeccCurso.next();
                    if (ListaEstSecc.getSeccionCursoId() != SeccCur1.getSeccionCursoId()) {
//                        System.out.println("3");
                        iteradorListaEstSecc.remove();
                    }else{
//                        System.out.println("4");
                        ListaSecCurso_EstuSec listaSecCur_EstuSec = new ListaSecCurso_EstuSec(SeccCur1.getSeccionCursoId(), SeccCur1.getCursoCarreraId(), SeccCur1.getSeccionId(), SeccCur1.getUsuarioCatId(), SeccCur1.getSeccionDescrip(), SeccCur1.getCicloCursoAnio(), SeccCur1.getCiclo(), SeccCur1.getCurso(), SeccCur1.getCarrera(), SeccCur1.getCicloId(), SeccCur1.getCursoId(), SeccCur1.getFacultad(), SeccCur1.getUsuarioCat(), SeccCur1.getNombreCat(), SeccCur1.getApellidoCat(), SeccCur1.getPersonaCatId(), ListaEstSecc.getEstudianteSeccionId(), ListaEstSecc.getUsuarioEstId(), ListaEstSecc.getUsuarioEst(), ListaEstSecc.getNombreEst(), ListaEstSecc.getApellidoEst(), ListaEstSecc.getPersonaEstId());
                        miListSecCur_EstuSecc.add(listaSecCur_EstuSec);
                        System.out.println(listaSecCur_EstuSec);
                    }
                }
            }
            
        } else {
            Iterator<ListaSecCurso> iteradorListaSeccCurso = miListSeccionCurso.iterator();
            while (iteradorListaSeccCurso.hasNext()) { 
                ListaSecCurso SeccCur1 = iteradorListaSeccCurso.next();
                Iterator<ListaEstuSeccion> iteradorListaEstSecc = miListEstuSeccion.iterator();
                while (iteradorListaEstSecc.hasNext()) {
                    ListaEstuSeccion ListaEstSecc = iteradorListaEstSecc.next();
                    if (ListaEstSecc.getSeccionCursoId() != SeccCur1.getSeccionCursoId()) {
//                        System.out.println("3");
                        iteradorListaEstSecc.remove();
                    }else{
//                        System.out.println("4");
                        ListaSecCurso_EstuSec listaSecCur_EstuSec = new ListaSecCurso_EstuSec(SeccCur1.getSeccionCursoId(), SeccCur1.getCursoCarreraId(), SeccCur1.getSeccionId(), SeccCur1.getUsuarioCatId(), SeccCur1.getSeccionDescrip(), SeccCur1.getCicloCursoAnio(), SeccCur1.getCiclo(), SeccCur1.getCurso(), SeccCur1.getCarrera(), SeccCur1.getCicloId(), SeccCur1.getCursoId(), SeccCur1.getFacultad(), SeccCur1.getUsuarioCat(), SeccCur1.getNombreCat(), SeccCur1.getApellidoCat(), SeccCur1.getPersonaCatId(), ListaEstSecc.getEstudianteSeccionId(), ListaEstSecc.getUsuarioEstId(), ListaEstSecc.getUsuarioEst(), ListaEstSecc.getNombreEst(), ListaEstSecc.getApellidoEst(), ListaEstSecc.getPersonaEstId());
                        miListSecCur_EstuSecc.add(listaSecCur_EstuSec);
                        System.out.println(listaSecCur_EstuSec);
                    }
                }
            }
        }
        return miListSecCur_EstuSecc;
    }
    
    
    
}
