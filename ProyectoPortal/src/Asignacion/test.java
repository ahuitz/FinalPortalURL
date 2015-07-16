/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Asignacion;

import NotasS.ListaSecCurso;
import java.util.List;

/**
 *
 * @author frankzapeta1
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int usuario=2;
        int idciclo=1;
        int carrera=1;
        ListaUsuarioCarreraCursos usucacu= new ListaUsuarioCarreraCursos();
        List<UsuarioCarreraCursos> usua= usucacu.cargarDatos();
    }
    
}
