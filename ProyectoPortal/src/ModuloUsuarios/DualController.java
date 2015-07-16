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
import Tablas.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

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
    private String TipoEst;
    private Usuario us;
    public DualController(EntityManagerFactory emf, Config configuracion,String TipoEst) {
        this.emf = emf;
        this.configuracion = configuracion;
        this.mysql = ConexionEstandar.getInstace(configuracion.getUser(), configuracion.getPass());
        this.em=emf.createEntityManager();
        this.controladorpersona=new PersonaJpaController(emf);
        this.controladorusuario= new UsuarioJpaController(emf);
        this.TipoEst=TipoEst;
        switch(TipoEst){
            case "EST":
                us.setRolUsuarioid(1);
                break;
            
            case "ADM":
                us.setRolUsuarioid(2);
                
                break;
            case "CAT":    
            
                us.setRolUsuarioid(3);
                break;
        }
        
    }
    
    
    
    @Override
    public void Create(Persona persona) {

     
        Query id= em.createNativeQuery("Select (Max(id)+1) from persona;");
        System.out.println(id.getSingleResult().toString());
        String num=id.getSingleResult().toString();
        
      
      
        try {
            com.mysql.jdbc.Statement statement;
            statement = (com.mysql.jdbc.Statement) mysql.getBDconexion().createStatement();
            statement.execute("create user '"+TipoEst+num+"15'@'localhost' identified by 'a.2015';"); 
            statement.execute("GRANT ALL PRIVILEGES ON * . * TO '"+num+"15'@'localhost';");
            System.out.println("Datos ingresados correctamente");          
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DualController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        persona.setCarne(num+"15");
        us.setUsuario(TipoEst+num+"15");
        us.setPersonaid(Integer.parseInt(num));
        controladorpersona.create(persona);
        controladorusuario.create(us);
       
    }
    
    
    
}
