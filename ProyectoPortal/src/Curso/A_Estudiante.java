/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Curso;

import Controladores.ActividadJpaController;
import Controladores.EntregaJpaController;
import Tablas.Actividad;
import java.util.ArrayList;
import Tablas.Entrega;
import Tablas.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author Miguel Diaz
 */
public class A_Estudiante extends CActividad {

    private List<Entrega> entregas;
    

    public A_Estudiante(EntityManagerFactory emf,int ISC) {
        this.emf=emf;
        this.controladorA = new ActividadJpaController(emf);
        this.controladorE = new EntregaJpaController(emf);
        this.idSeccionCurso= ISC;
        cargarActividades(emf,ISC);
        entregas= new ArrayList<>();
        cargarEntregas();
    }
     public  void cargarE(EntityManagerFactory emf,int i){
        Query q;
        EntityManager em=emf.createEntityManager();
        q=em.createNamedQuery("Entrega.findByActividadid");
        //'nombre' es el parametro que esta en la clase usuario ':nombre'
        q.setParameter("seccionCursoid", i);
        actividades=q.getResultList();
        System.out.println(actividades.size());
        
    }

    /**
     *
     * @param entrega
     * @throws Exception
     */
    @Override
    public void modificarEntrega(Entrega entrega) throws Exception {
        controladorE.edit(entrega);
    }
    @Override
    public Entrega obtenerEntrega(int idActividad){
        for(Entrega e:entregas){
            if(e.getActividadid()==idActividad){
                return e;
            }
        }
        
        return null;
    }

    

    
    @Override
    public void visualizarActividad(CCurso curso,int idActividad) {
    }

    @Override
    public void cargarEntregas() {

        
        for (Actividad a : actividades) {
            entregs(a.getId());
            
          
        }

    }

    public void entregs(int id) {
        Query q;
        EntityManager em = emf.createEntityManager();

        q = em.createNamedQuery("Entrega.findByActividadid");
        q.setParameter("actividadid", id);
        Entrega E = (Entrega) q.getResultList().get(0);
        entregas.add(E);

    }
    //metodos que no se utilizaran
    @Override
    public List<Entrega> obtenerEntregas(int idActividad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public void modificarActividad(Actividad actividad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void publicarActividad(Actividad actividad, List<Integer> usuarios) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void calificarEntrega(List<Entrega> entrega) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
