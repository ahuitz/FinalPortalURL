package ModuloUsuarios;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Tablas.Persona;
import Tablas.Tiposangre;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Rosario
 */
public class AccionesUsuario {
    
    public Persona buscarUsCarne(String carne,EntityManager em){        
        Query q=em.createNamedQuery("Persona.findByCarne");
        q.setParameter("carne", carne);
        Persona persona=(Persona) q.getSingleResult();
        return persona;
        //System.out.println(persona.getApellido());
    }
}
