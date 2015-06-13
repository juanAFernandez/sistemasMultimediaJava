/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programa;

import java.awt.Component;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.CannotRealizeException;
import javax.media.CaptureDeviceInfo;
import javax.media.CaptureDeviceManager;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.format.YUVFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author juan
 */
public class VentanaInternaCamara extends javax.swing.JInternalFrame {

    private Player player = null;
    

    
    //Sacamos el primer elemento de la lista de dispositivos:       
    
    /**
     * Creates new form VentanaInternaCamara
     */
    public VentanaInternaCamara() {
        initComponents();
        
        
            //Objeto de tipo información de dispositivo:
    CaptureDeviceInfo deviceInfo;
    
    //Creamos una lista de dispositivos que el equipo tiene:
    List<CaptureDeviceInfo> deviceList;
        deviceList = CaptureDeviceManager.getDeviceList(new YUVFormat());
        if(deviceList.isEmpty()){
            System.out.println(deviceList.size());
            JOptionPane.showMessageDialog(this, "No se ha encontrado ningún dispositivo de video.", "Error",
    JOptionPane.WARNING_MESSAGE);
        }
        
        //Extraemos el primer elemento de la lista de dispositivos:
        deviceInfo = deviceList.get(0);
        MediaLocator ml= deviceInfo.getLocator();
        try {
            
            player = Manager.createRealizedPlayer(ml);
            Component areaVisual = player.getVisualComponent();
            if(areaVisual!=null)
                this.add(areaVisual);
            Component panelControl = player.getControlPanelComponent();
            if(panelControl!=null)
                this.add(panelControl);
            player.start();
                
            
            this.pack();
                
            
            
            
        } catch (Exception ex){ 
            Logger.getLogger(VentanaInternaCamara.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
   public static VentanaInternaCamara getInstance(){
        VentanaInternaCamara vi = new VentanaInternaCamara();
        if(vi.player!=null)
            return vi;
        else
            return null;
    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
