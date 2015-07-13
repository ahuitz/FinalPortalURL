/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

/**
 *
 * @author Vader33
 */
public class Config implements ConexionBasica {
    private String User;
    private String Pass;
    private static Config instancia= null;
    
  
    public static Config getInstance(String User,String Pass){
        if(instancia==null){
            instancia = new Config(User,Pass);
        }
            return instancia;  
        
    }

    public Config(String user,String pass) {
        this.User=user;
        this.Pass=pass;
    }

    public String getUser() {
        return User;
    }

    public String getPass() {
        return Pass;
    }

    
    @Override
    public void Close() {
        this.Pass=null;
        this.User=null;
        this.instancia=null;
    }
    
}
