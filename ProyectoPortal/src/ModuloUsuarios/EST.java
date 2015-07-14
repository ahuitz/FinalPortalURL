/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloUsuarios;

import Tablas.Persona;

/**
 *
 * @author Vader33
 */
public class EST implements TipoPersona{
    private String siglas="EST";
    private DualController controlador;
    private Persona Persona;
    @Override
    public void crear() {
        controlador.Create(Persona);
    }
    
}
