/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms.Curso;

import Controladores.ArchivoJpaController;
import Controladores.DetalleentregaJpaController;
import Controladores.EntregaJpaController;
import Controladores.exceptions.NonexistentEntityException;
import Curso.CCurso;
import Curso.ModeloTablaArchivos;
import Forms.NewJFrame;
import Tablas.Archivo;
import Tablas.Detalleentrega;
import Tablas.Entrega;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author modm12
 */
public class R_Entregas extends javax.swing.JInternalFrame {

    /**
     * Creates new form NewJInternalFrame
     */
    public R_Entregas(CCurso curso, int idActividad) {
        initComponents();
        this.curso= curso;
        archivos= new ArrayList<>();
        this.id= idActividad;
        
        entrega=curso.getActividad().obtenerEntrega(idActividad);
        
        if(entrega.getRealizada()){
            obtenerArchivos();
        }
        
        
    }
    public R_Entregas() {
        initComponents();
        archivos= new ArrayList<>();
        
    }
    List<Archivo> archivos;
    List<Detalleentrega> detalle;
    ModeloTablaArchivos modelo;
    DetalleentregaJpaController controldetalles;
    ArchivoJpaController controlarchivo;
    EntregaJpaController controladorentrega;
    
    CCurso curso;
    Entrega entrega;
    int id;
    
    public void obtenerArchivos(){
        detalle=new ArrayList<>();
        Query q;
        EntityManager em=curso.getActividad().getEmf().createEntityManager();
        q=em.createNamedQuery("Detalleentrega.findByEntregaid");
        q.setParameter("entregaid", entrega.getId());
        detalle= q.getResultList();
        
        for(Detalleentrega d:detalle){
            q=em.createNamedQuery("Archivo.findById");
            q.setParameter("id", d.getArchivoid());
            archivos.add((Archivo) q.getSingleResult());
        }
        modelo= new ModeloTablaArchivos(archivos);
        jTable1.setModel(modelo);
        
    }
    
    public void eliminar(Archivo arch,int idRow){
        if(arch.getId()>0){
            for(Detalleentrega d:detalle){
                if(d.getArchivoid()==arch.getId()){
                    try {
                        controldetalles.destroy(d.getId());
                    } catch (NonexistentEntityException ex) {
                        Logger.getLogger(R_Entregas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                }
            }
            obtenerArchivos();
            modelo= new ModeloTablaArchivos(archivos);
            jTable1.setModel(modelo);
            
        }else{
            archivos.remove(idRow);
            modelo= new ModeloTablaArchivos(archivos);
            jTable1.setModel(modelo);
            
        }
        
        
        
        
    }
    public void Finalizar(){
        try {
            controlarchivo= new ArchivoJpaController(curso.getActividad().getEmf());
            controldetalles= new DetalleentregaJpaController(curso.getActividad().getEmf());
            controladorentrega= new EntregaJpaController(curso.getActividad().getEmf());
            for(Archivo a :archivos){
                if(a.getId()!=null){
                    try {
                        controlarchivo.edit(a);
                    } catch (Exception ex) {
                        Logger.getLogger(R_Entregas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }else{
                    
                    int arcS= maxArchivosId();
                    a.setId(arcS);
                     controlarchivo.create(a);
                    int arc= maxArchivosId();
           
                  
                    System.out.println("correlativo "+a.getId());
                   Detalleentrega nuevo= new Detalleentrega(1, new Date(), arc, entrega.getId());
                   nuevo.setEntregaid(entrega.getId());
                   nuevo.setArchivoid(arc);
                   nuevo.setFechaModificacion(new Date());
                   nuevo.setId(0);
                   controldetalles= new DetalleentregaJpaController(curso.getActividad().getEmf());
                    controldetalles.create(nuevo);
                    
                }
            }
            entrega.setRealizada(true);
            controladorentrega.edit(entrega);
        } catch (Exception ex) {
            Logger.getLogger(R_Entregas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private int maxDetalleentregaadId(){
        Query q;
        EntityManager em=curso.getActividad().getEmf().createEntityManager();
        q=em.createNamedQuery("Detalleentrega.findMaxId");;
        return q.getFirstResult() ;
    }
    private int maxArchivosId(){
        Query q;
        EntityManager em=curso.getActividad().getEmf().createEntityManager();
        q=em.createNamedQuery("Archivo.findMaxId");;
        return q.getFirstResult();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jMenuItem1.setText("Eliminiar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setClosable(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Agregar Archivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Finalizar entrega");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        int opcion = fc.showOpenDialog(this);
        if(opcion==JFileChooser.APPROVE_OPTION){
            Archivo arch= new Archivo();
            File file=fc.getSelectedFile();
            String [] st= file.getName().split("\\.");
            
            arch.setNombre(st[0]);
            arch.setTamanio(file.length());
            arch.setExtension(st[1]);
            arch.setUrl("sin url");
            
            archivos.add(arch);
            modelo= new ModeloTablaArchivos(archivos);
            jTable1.setModel(modelo);
            }
        else{
            
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ningun archivo.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Finalizar();
        JOptionPane.showMessageDialog(this, "<html><FONT SIZE=4>Se finalizo correctamente.</font></html>");
        dispose();
        
    };//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        if (row >= 0) {
            eliminar(modelo.getArchivos().get(row), row);

        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
