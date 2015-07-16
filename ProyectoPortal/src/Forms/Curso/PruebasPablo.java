/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms.Curso;

import Conexion.ConexionJPA;
import Forms.FormularioUsuarios1;
import Tablas.Carrera;
import Tablas.Ciclo;
import Tablas.Ciclocurso;
import Tablas.Curso;
import Tablas.Cursocarrera;
import Tablas.Estudianteseccion;
import Tablas.Seccion;
import Tablas.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Pablo
 */
public class PruebasPablo extends javax.swing.JFrame {

    /**
     * Creates new form PruebasPablo
     */
    public PruebasPablo() {
        initComponents();
        FormularioUsuarios1.conexion=ConexionJPA.getInstance("root", "root");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 649, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        jMenuItem1.setText("Matematicas I");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Introduccion a la programacion");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Probar algoritmo");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        FormularioUsuarios1.conexion=ConexionJPA.getInstance("root", "root");
        Usuario pablo = new Usuario(1, "EST1629311", 1, 1);
        PrincipalCurso pc = new PrincipalCurso("EST",pablo, 1);
//        Usuario mike = new Usuario(3, "CAT1522712", 2, 3);
//        PrincipalCurso pc = new PrincipalCurso("CAT", mike, 1);
        jDesktopPane1.add(pc);
        pc.toFront();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        FormularioUsuarios1.conexion=ConexionJPA.getInstance("root", "root");
//        Usuario pablo = new Usuario(1, "EST1629311", 1, 1);
//        PrincipalCurso pc = new PrincipalCurso("EST",pablo, 1);
        Usuario mike = new Usuario(3, "CAT1522712", 2, 3);
        PrincipalCurso pc = new PrincipalCurso("CAT", mike, 2);
        jDesktopPane1.add(pc);
        pc.toFront();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        getCursosEstudiante(1);
    }//GEN-LAST:event_jMenuItem3ActionPerformed
              

    public void getCursosEstudiante(int idUsuarioE){
         Query q;
            q = FormularioUsuarios1.conexion.getEmf().createEntityManager().createNamedQuery("Estudianteseccion.findByUsuarioid");
            q.setParameter("usuarioid",idUsuarioE);
            List<Estudianteseccion> es = q.getResultList();
            ArrayList<Curso> cursos = new ArrayList<>();
            for(int i=0;i<es.size();i++){
                q = FormularioUsuarios1.conexion.getEmf().createEntityManager().createNamedQuery("Seccion.findById");
                q.setParameter("id", es.get(i).getId());
                Seccion seccion = (Seccion) q.getSingleResult();
                q = FormularioUsuarios1.conexion.getEmf().createEntityManager().createNamedQuery("Cursocarrera.findById");
                q.setParameter("id", es.get(i).getId());
                Cursocarrera cc = (Cursocarrera) q.getSingleResult();
                q = FormularioUsuarios1.conexion.getEmf().createEntityManager().createNamedQuery("Carrera.findById");
                q.setParameter("id", cc.getCarreraid());
                Carrera c = (Carrera) q.getSingleResult();
                q = FormularioUsuarios1.conexion.getEmf().createEntityManager().createNamedQuery("Ciclocurso.findById");
                q.setParameter("id", cc.getCicloCursoid());
                Ciclocurso cic = (Ciclocurso) q.getSingleResult();
                q = FormularioUsuarios1.conexion.getEmf().createEntityManager().createNamedQuery("Curso.findById");
                q.setParameter("id", cic.getCursoid());
                Curso cur = (Curso) q.getSingleResult();
                q = FormularioUsuarios1.conexion.getEmf().createEntityManager().createNamedQuery("Ciclo.findById");
                q.setParameter("id", cic.getCicloid());
                Ciclo ciclo = (Ciclo) q.getSingleResult();
                cursos.add(cur);
                JOptionPane.showMessageDialog(this, "Curso: "+cursos.get(i).getNombre()+"  Seccion: "+seccion.getDescripcion());
            }   
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PruebasPablo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PruebasPablo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PruebasPablo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PruebasPablo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PruebasPablo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    // End of variables declaration//GEN-END:variables
}