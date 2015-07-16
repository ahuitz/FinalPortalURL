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
    private String carne;
    private String iniciales;
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
        this.carne= cortar(user);
        this.carne=Ciniciales(user);
    }

    public String getUser() {
        return User;
    }

    public String getIniciales() {
        return iniciales;
    }

    
    public String getPass() {
        return Pass;
    }

    public String getCarne() {
        return carne;
    }
    
    

    
    @Override
    public void Close() {
        this.Pass=null;
        this.User=null;
        this.instancia=null;
    }
    
    private String cortar(String us){
     String cortado;
     cortado = us.substring(3);
     return cortado;
    }
     
    private String Ciniciales(String us){
        String cortado;
        cortado=us.substring(0, 2);
        return cortado;
    }
}
