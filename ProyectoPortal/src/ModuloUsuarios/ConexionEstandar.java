/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloUsuarios;

import Conexion.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vader33
 */
public class ConexionEstandar implements ConexionBasica{
    private Connection BDconexion;
    private static ConexionEstandar instancia;
    
    private ConexionEstandar(String user,String pass) {
        String servidor = "jdbc:mysql://localhost/pruebaspro";  
        try {
            BDconexion= DriverManager.getConnection(servidor,user,pass);
            System.out.println("conexion realizada");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionEstandar.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public Connection getBDconexion() {
        return BDconexion;
    }
    
     public static  ConexionEstandar getInstace(String user,String pass) {
           if(instancia==null){
            instancia = new ConexionEstandar(user,pass);
        }
            return instancia;   
        } 
    
   
    
    @Override
    public void Close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  
    
}
