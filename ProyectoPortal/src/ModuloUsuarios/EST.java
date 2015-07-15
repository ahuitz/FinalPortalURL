/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloUsuarios;

import Conexion.Config;
import Tablas.Persona;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Vader33
 */
public class EST implements TipoPersona{
    private String siglas="EST";
    private DualController controlador;
    private Persona Persona;
    private EntityManagerFactory emf;
    private Config configuracion;

    public EST(Persona Persona, EntityManagerFactory emf, Config configuracion) {
        this.Persona = Persona;
        this.emf = emf;
        this.configuracion = configuracion;
        this.controlador= new DualController(emf, configuracion, siglas);
    }
    
    
    @Override
    public void crear() {
        controlador.Create(Persona);
    }
    
}
