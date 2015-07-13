/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Vader33
 */
public class ConexionJPA implements ConexionBasica{
    
    private EntityManager em;
    private EntityManagerFactory emf;
    private static ConexionJPA instancia;
    private Map prop = new HashMap();
    
    public static ConexionJPA getInstance(String user,String pass){
         if(instancia==null){
            instancia = new ConexionJPA(user,pass);
        }
            return instancia;   
    }

    public ConexionJPA(String user,String pass) {
        prop.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/permisosus");
        prop.put("javax.persistence.jdbc.password", pass);
        prop.put("javax.persistence.jdbc.user", user);
        
       emf= Persistence.createEntityManagerFactory("ModuloUsuarioPU",prop);
       em = emf.createEntityManager();
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public EntityManager getEm() {
        return em;
    }
    
    
    
    
    @Override
    public void Close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
