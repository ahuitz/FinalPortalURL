/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloUsuarios;

import Conexion.Config;
import Controladores.PersonaJpaController;
import Controladores.UsuarioJpaController;
import Tablas.Persona;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Vader33
 */
public class DualController implements Controlador{

    private PersonaJpaController controladorpersona;
    private UsuarioJpaController controladorusuario;
    private EntityManager em;
    private EntityManagerFactory emf;
    private Config configuracion;
    private ConexionEstandar mysql;

    public DualController(EntityManagerFactory emf, Config configuracion, ConexionEstandar mysql) {
        this.emf = emf;
        this.configuracion = configuracion;
        this.mysql = mysql;
        this.em=emf.createEntityManager();
        this.controladorpersona=new PersonaJpaController(emf);
        this.controladorusuario= new UsuarioJpaController(emf);
    }
    
    
    
    @Override
    public void Create(Persona persona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
