/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursos.administrador;

import javax.persistence.EntityManagerFactory;
/**
 *
 * @author Cristian
 */
public interface Consulta {
    
    public void instruccion(EntityManagerFactory efm);
    
}
