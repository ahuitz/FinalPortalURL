/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Curso;

import Conexion.ConexionJPA;
import Controladores.ActividadJpaController;
import Controladores.EntregaJpaController;
import Forms.Curso.VerActividad_Catedratico;
import Tablas.Actividad;
import Tablas.Entrega;
import Tablas.Usuario;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;


/**
 *
 * @author Miguel Diaz
 */
public class A_Catedratico extends CActividad {
   
    public ArrayList<Entregas> entregas;
    EntityManagerFactory emf;
    
    public A_Catedratico(EntityManagerFactory emf,int ISC) {
        this.controladorA = new ActividadJpaController(emf);
        this.controladorE= new EntregaJpaController(emf);
        this.emf=emf;
        this.idSeccionCurso=ISC;
        this.entregas  = new ArrayList<>();
        cargarActividades(emf,ISC);
        cargarEntregas();
    }
    
    public List<Entrega> obtenerEntregas(int idActividad){
        for(Entregas e:entregas){
            if(e.getIdActividad()==idActividad){
                return e.getEntregas();
            }
        }
        return null;
        
    }
    
    /**
     *
     * @param entrega
     * @throws Exception
     */
    @Override
    public void calificarEntrega(List<Entrega> entrega ) throws Exception {
        for(Entrega e:entrega){
         controladorE.edit(e);   
        }
        
    }
    
    @Override
    public void modificarActividad(Actividad actividad) throws Exception {
        controladorA.edit(actividad);
    }

    /**
     *
     * @param actividad
     * @param usuarios
     */
    @Override
    public void publicarActividad(Tablas.Actividad actividad,List<Usuario> usuarios) {
        actividad.setId(maxActividadId());
        actividad.setSeccionCursoid(idSeccionCurso);
        controladorA.create(actividad);
        crearEntregas(idSeccionCurso, usuarios);
        
    }
    private int maxActividadId(){
        Query q;
        EntityManager em=emf.createEntityManager();
        q=em.createNamedQuery("Actividad.findMaxId");;
        return q.getFirstResult();
    }
    private int maxEntregaId(){
        Query q;
        EntityManager em=emf.createEntityManager();
        q=em.createNamedQuery("Entrega.findMaxId");;
        return q.getFirstResult();
    }
    
    private void crearEntregas(int idActividad,List<Usuario> usuarios){
        
        for(Usuario u: usuarios){
            controladorE.create(new Entrega(maxEntregaId(),0, false, true, idActividad, u.getId()));
        }
        cargarEntregas();
       
    }
    
    private List<Entrega> buscarEntregas(int idActividad){
        Query q;
        EntityManager em=emf.createEntityManager();
        q=em.createNamedQuery("Entrega.findByActividadid");
        q.setParameter("actividadid", idActividad);
        return q.getResultList();
        
    }
    
    
    @Override
    public void visualizarActividad(CCurso curso,int idActividad) {
       
        
    }

    
    @Override
    public void cargarEntregas() {
        ArrayList e= new ArrayList<>();

        for (Actividad a : actividades) {
            e.add(new Entregas(a.getId(), buscarEntregas(a.getId())));
        }
        this.entregas=e;
    }
    
    
    //metodos que no se utilizaran
    
    @Override
    public Entrega obtenerEntrega(int idActividad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarEntrega(Entrega entrega) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}