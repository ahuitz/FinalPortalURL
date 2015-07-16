/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NotasS;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Saul
 */
public class ClaseListaPorCurso {
    public List<ListaSecCurso>  encontraPorCurso(List<ListaSecCurso> miListaSecCurso, int CursoId, int SeccionId){
        
        
//        System.out.println("");
//        System.out.println("PRIMERA LISTA POR CARRERA");
//        System.out.println("LISTA POR CURSO");
        Iterator<ListaSecCurso> iteradorListSecCurso = miListaSecCurso.iterator();
        while (iteradorListSecCurso.hasNext()) {            
            ListaSecCurso listaSecCurso = iteradorListSecCurso.next(); 
            if (listaSecCurso.getCursoId() != CursoId) {
                iteradorListSecCurso.remove();
            }
//            System.out.println(listaSecCurso);
        }
        
        Iterator<ListaSecCurso> iteradorListSecCurso3 = miListaSecCurso.iterator();
        while (iteradorListSecCurso3.hasNext()) {            
            ListaSecCurso listaSecCurso = iteradorListSecCurso3.next(); 
            if (listaSecCurso.getSeccionCursoId() != SeccionId) {
                iteradorListSecCurso3.remove();
            }
//            System.out.println(listaSecCurso);
        }
        
        System.out.println("");
        System.out.println("");
        System.out.println("LISTA POR CURSO");
        Iterator<ListaSecCurso> iteradorListSecCurso2 = miListaSecCurso.iterator();
        while (iteradorListSecCurso2.hasNext()) {            
            ListaSecCurso listaSecCurso = iteradorListSecCurso2.next(); 
            System.out.println(listaSecCurso);
        }
        
        
        return miListaSecCurso;
    }
    
}
