/*
 * Copyright (C) 2015 Juan A. Fernández Sánchez
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package accesorios;

import Programa.VentanaPrincipal;
import java.awt.Color;
import javax.swing.JColorChooser;

/**
 *
 * @author Juan A. Fernández Sánchez
 */
public class Ajustes extends javax.swing.JFrame {

    VentanaPrincipal padre;
    
    /**
     * Creates new form Ajustes
     * @param padre
     */
    public Ajustes(VentanaPrincipal padre) {
        initComponents();
        botonColor.setBackground(Color.BLUE);
        //botonColor.setBackground(padre.getColorLiezoDefecto());
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSecciones = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        panelDetalles = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botonColor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ajustes");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/NuevoBoceto.GIF"))); // NOI18N
        jLabel1.setText("Lienzo");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout panelSeccionesLayout = new javax.swing.GroupLayout(panelSecciones);
        panelSecciones.setLayout(panelSeccionesLayout);
        panelSeccionesLayout.setHorizontalGroup(
            panelSeccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeccionesLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panelSeccionesLayout.setVerticalGroup(
            panelSeccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeccionesLayout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(panelSeccionesLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelSecciones, java.awt.BorderLayout.LINE_START);

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel2.setText("Lienzo");

        jLabel3.setText("Color por defecto:");

        botonColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonColorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDetallesLayout = new javax.swing.GroupLayout(panelDetalles);
        panelDetalles.setLayout(panelDetallesLayout);
        panelDetallesLayout.setHorizontalGroup(
            panelDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetallesLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelDetallesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonColor)
                .addContainerGap(121, Short.MAX_VALUE))
        );
        panelDetallesLayout.setVerticalGroup(
            panelDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetallesLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(panelDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonColor, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(228, Short.MAX_VALUE))
        );

        getContentPane().add(panelDetalles, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonColorActionPerformed
        JColorChooser ventanaDeColores=new JColorChooser();
        Color color=ventanaDeColores.showDialog(null, "Seleccione un Color", Color.WHITE);
        botonColor.setBackground(color);
        padre.setColorDefecto(color);
        
    }//GEN-LAST:event_botonColorActionPerformed

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
            java.util.logging.Logger.getLogger(Ajustes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ajustes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ajustes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ajustes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonColor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelDetalles;
    private javax.swing.JPanel panelSecciones;
    // End of variables declaration//GEN-END:variables
}
