/*
 *d To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programa;

import static extras.Imprimir.Imprimir;
import extras.Herramienta;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import sm.jaf.graficos.Relleno;
import sm.jaf.iu.Lienzo2DImagen;

/**
 *
 * @author juan
 */
public class VentanaInterna extends javax.swing.JInternalFrame {

       //Variable de clase para contar el número de instancias que se tienen:
       static int contadorVentanas = 0;
       
       private VentanaPrincipal parent;
       
    //   private String nombreVentana;
    
    /**
     * Creates new form VI
     */
    public VentanaInterna(VentanaPrincipal v) {        
        super("Sin título " + (++contadorVentanas),true,true,true,true);
        this.parent=v;
      //  nombreVentana="Sin título "+contadorVentanas;
        initComponents();      
        //Solo las ventanas internas tendrán habilitada la zona de cliping para que de la sensación de estar
        //dibujando en un lienzo fintio. Para eso le decimos que este es el centra y con una variable booelana
        //al redibujar se mostrará la zona de cliping.
        this.miLienzo2D.setCentral(true);
    }
    
   
    /*
    Método que devuelve el objeto miLienzo2D desde donde es llamado para poder trabar con el y poder usar directamente
    sus métodos.
    */
    public Lienzo2DImagen getLienzo(){        
        return this.miLienzo2D;
    }
    public String getNombreVentana(){
        //return nombreVentana;
        return this.getTitle();
    }
    public void setNombreVentana(String nuevoNombre){
        this.setTitle(nuevoNombre);
    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelScroll = new javax.swing.JScrollPane();
        miLienzo2D = new sm.jaf.iu.Lienzo2DImagen();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        miLienzo2D.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                miLienzo2DMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout miLienzo2DLayout = new javax.swing.GroupLayout(miLienzo2D);
        miLienzo2D.setLayout(miLienzo2DLayout);
        miLienzo2DLayout.setHorizontalGroup(
            miLienzo2DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );
        miLienzo2DLayout.setVerticalGroup(
            miLienzo2DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );

        panelScroll.setViewportView(miLienzo2D);

        getContentPane().add(panelScroll, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    /**
     * Programaicón de las tareas a realizar al pulsar sobre una ventana interna.
     * @param evt 
     */
    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        
        /*
        Cuando seleccionamos una ventana interna tenemos que mandar los mensajes necesarios para que las herramientas
        se cambien según estén configuradas dentro de cada una de ellas.
        */
                        
        //Mensaje de depuración por terminal:
        Imprimir("Seleccionada ventana "+this.getNombreVentana());
        
        Imprimir("Relleno en ventana:"+this.getLienzo().getRellenoBoolean());
        
        //Le enviamos al padre el trazo del lienzo para que ajuste las herrmientas de seleccion.
        parent.setTrazoDefecto(this.getLienzo().getTrazo());
        
        //Le enviamos al padre el relleno del lienzo para que ajuste la herramienta
        if(this.miLienzo2D.getRellenoBoolean()){
            Imprimir("Tiene seleccionado el relleno");
            
            parent.setRellenoDefecto(this.getLienzo().getRelleno());
        }else{
            parent.desactivaRelleno();
        }
        
        
        //Cuatro variables booleanas checkbox
        
        
    }//GEN-LAST:event_formInternalFrameActivated

    private void miLienzo2DMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miLienzo2DMouseMoved
       parent.setCoordenadas(evt.getPoint());
    }//GEN-LAST:event_miLienzo2DMouseMoved

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private sm.jaf.iu.Lienzo2DImagen miLienzo2D;
    private javax.swing.JScrollPane panelScroll;
    // End of variables declaration//GEN-END:variables
}
