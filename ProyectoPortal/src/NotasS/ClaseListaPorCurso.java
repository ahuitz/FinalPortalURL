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
    
    public List<ListaSecCurso>  encontraPorCurso(List<ListaSecCurso> miListaSecCurso, int CursoId){
        Iterator<ListaSecCurso> iteradorListSecCurso = miListaSecCurso.iterator();
        while (iteradorListSecCurso.hasNext()) {            
            ListaSecCurso listaSecCurso = iteradorListSecCurso.next(); 
            if (listaSecCurso.getCursoId() != CursoId) {
                iteradorListSecCurso.remove();
            }
        }
        return miListaSecCurso;
    }
    
}
