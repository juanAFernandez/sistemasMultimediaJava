/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programa;

import static extras.Imprimir.Imprimir;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import sm.image.KernelProducer;

/**
 *
 * @author juan
 */
public class herramientaEmborronamiento extends javax.swing.JFrame {

    
    private VentanaPrincipal padre;
    private BufferedImage imagenTemporalParaOperaciones;
    private VentanaInterna vis;
    
    private Kernel k;
    
    private ConvolveOp cop;
    
    //Definición de las máscaras 
    public static float[] MASCARA3x3;
    public static float[] MASCARA5x5;
    public static float[] MASCARA7x7;
    public static float[] MASCARA9x9;
    
    private Kernel propio;
    
    
    /**
     * Constructor    
     * @param padre //Le pasamos el propio padre que lo crea para acceder forma fácil a métodos de este.
     */
    public herramientaEmborronamiento(VentanaPrincipal padre) {
        initComponents();
        //Creamos la referencia al padre
        this.padre=padre;
        
        //Máscara por defecto: tam 3x3 con un filtro tipo medio
        MASCARA3x3=new float[9];
        for(int i=0; i<9; i++) 
            MASCARA3x3[i]=(float)1/9;
        
        
        
        //Creación del kernel con nuestra máscara por defecto:
        propio = new Kernel(3,3,MASCARA3x3);
        //Creación de la operación para aplicar.
        cop= new ConvolveOp(propio,ConvolveOp.EDGE_NO_OP,null);
        
        //Sacamos la imagen del lienzo
        sacarImagen();
        
        //Establecemos el tipo de matriz por defecto.
       //  k= KernelProducer.createKernel(KernelProducer.TYPE_MEDIA_3x3);
      //   cop= new ConvolveOp(k,ConvolveOp.EDGE_NO_OP,null);
        
        //Realizamos el trabajo
        aplicar();
        this.botonMedio.setSelected(true);
    }

    
    private void cambiarTipo(){
        
        if(botonMedio.isSelected()){
            
            if(boton3x3.isSelected()){
                MASCARA3x3=new float[9]; for(int i=0; i<9; i++) MASCARA3x3[i]=1/9;
                k= new Kernel(3,3,MASCARA3x3);                 
            }
            if(boton5x5.isSelected()){
                MASCARA5x5=new float[25]; for(int i=0; i<25; i++) MASCARA5x5[i]=1/25;
                k=new Kernel(5,5,MASCARA5x5);
            }
            if(boton7x7.isSelected()){
                MASCARA7x7=new float[49]; for(int i=0; i<49; i++) MASCARA5x5[i]=1/49;
                k=new Kernel(7,7,MASCARA7x7);
            }
            if(boton9x9.isSelected()){
                MASCARA9x9=new float[81]; for(int i=0; i<81; i++) MASCARA9x9[i]=1/89;
                k=new Kernel(9,9,MASCARA9x9);
            }                                                           
           // k= KernelProducer.createKernel(KernelProducer.TYPE_MEDIA_3x3);            
        }
        
        if(botonBinomial.isSelected())
            
            
            
            
            
            
            
            
            k= KernelProducer.createKernel(KernelProducer.TYPE_BINOMIAL_3x3);
        
        
        //Se configura la operación de convolución con la nueva máscara que siempre será k.
        cop= new ConvolveOp(k,ConvolveOp.EDGE_NO_OP,null);
        
        aplicar();
            
    }
    
    /**
     * Con esta función reseteamos la herramienta y dejamos la imagen como estaba al principio.
     */
    private void resetHerramienta(){
        this.botonMedio.setSelected(false);
        this.botonBinomial.setSelected(false);
        this.botonGaussiano.setSelected(false);
    }
    
    private void sacarImagen(){
        vis= (VentanaInterna) padre.getPanelEscritorio().getSelectedFrame();
        //Sólo cuando se ha seleccionado una ventana interna se puede trabajar.                          
       
        if(vis!=null){
         //Cargamos en nuestra variable privada la imagen que ese lienzo tiene.
            this.imagenTemporalParaOperaciones=vis.getLienzo().getImage();
            
            //Aplicamos el filtro a través de la convolución (operador creado):
            //vis.getLienzo().setImage(cop.filter(imagenTemporalParaOperaciones, null));
            //vis.repaint();
        }{
            Imprimir("Imagen NULL");
            //En otro caso no se puede trabajar y es necesario avisar de que es necesario tener una ventan seleccionada.
        }
    }
    
    private void aplicar(){
        /* 
        Imprimir("Ejecutando emborronamiento con parámetros por defecto.");
         
         //Al abrir esta ventana lo primero que se hace es seleccionar la ventana que el usuario tenía elegida:
         
         //VentanaInterna ventanaInternaSeleccionada= (VentanaInterna) ( (VentanaPrincipal)padre.getPa       )
         //VentanaInterna ventanaInternaSeleccionada = (VentanaInterna) (this.panelEscritorio.getSelectedFrame());
         
        //VentanaInterna ventanaInternaSeleccionada= (VentanaInterna) ((VentanaPrincipal)padre.getPanelEscritorio()).getSelectedFrame());
        VentanaInterna vis= (VentanaInterna) padre.getPanelEscritorio().getSelectedFrame();
        //Sólo cuando se ha seleccionado una ventana interna se puede trabajar.                          
       
        if(vis!=null){
         //Cargamos en nuestra variable privada la imagen que ese lienzo tiene.
            this.imagenTemporalParaOperaciones=vis.getLienzo().getImage();
            
            //Aplicamos el filtro a través de la convolución (operador creado):
            vis.getLienzo().setImage(cop.filter(imagenTemporalParaOperaciones, null));
            vis.repaint();
        }{
            Imprimir("Imagen NULL");
            //En otro caso no se puede trabajar y es necesario avisar de que es necesario tener una ventan seleccionada.
        }
       */
        if(vis!=null){
            vis.getLienzo().setImage(cop.filter(imagenTemporalParaOperaciones, null));
            vis.repaint();
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotonesTipo = new javax.swing.ButtonGroup();
        grupoBotonesMatriz = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        panelNorte = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        butonReset = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        butonReset1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        botonMedio = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        botonBinomial = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        botonGaussiano = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        boton3x3 = new javax.swing.JRadioButton();
        boton5x5 = new javax.swing.JRadioButton();
        boton7x7 = new javax.swing.JRadioButton();
        boton9x9 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        jPanel1.setBackground(new java.awt.Color(255, 0, 51));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 50));
        jPanel1.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        panelNorte.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Sawasdee", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 255));
        jLabel1.setText("Emborronamiento");

        javax.swing.GroupLayout panelNorteLayout = new javax.swing.GroupLayout(panelNorte);
        panelNorte.setLayout(panelNorteLayout);
        panelNorteLayout.setHorizontalGroup(
            panelNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNorteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(684, Short.MAX_VALUE))
        );
        panelNorteLayout.setVerticalGroup(
            panelNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNorteLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelNorte, java.awt.BorderLayout.PAGE_START);

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cancel.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Sawasdee", 1, 14)); // NOI18N
        jLabel6.setText("cancel");

        butonReset.setBackground(new java.awt.Color(0, 102, 102));
        butonReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/save.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Sawasdee", 1, 14)); // NOI18N
        jLabel7.setText("reset");

        butonReset1.setBackground(new java.awt.Color(0, 102, 102));
        butonReset1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reset.png"))); // NOI18N
        butonReset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonReset1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Sawasdee", 1, 14)); // NOI18N
        jLabel8.setText("save");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butonReset1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(butonReset1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butonReset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.LINE_END);

        jLabel2.setFont(new java.awt.Font("Sawasdee", 1, 24)); // NOI18N
        jLabel2.setText("Tipo:");

        botonMedio.setBackground(new java.awt.Color(0, 102, 102));
        grupoBotonesTipo.add(botonMedio);
        botonMedio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/average.png"))); // NOI18N
        botonMedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMedioActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Sawasdee", 1, 24)); // NOI18N
        jLabel3.setText("Medio");

        botonBinomial.setBackground(new java.awt.Color(0, 102, 102));
        grupoBotonesTipo.add(botonBinomial);
        botonBinomial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/binomial.png"))); // NOI18N
        botonBinomial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBinomialActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Sawasdee", 1, 24)); // NOI18N
        jLabel4.setText("Binomial");

        botonGaussiano.setBackground(new java.awt.Color(0, 102, 102));
        grupoBotonesTipo.add(botonGaussiano);
        botonGaussiano.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/gaussian.png"))); // NOI18N
        botonGaussiano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGaussianoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Sawasdee", 1, 24)); // NOI18N
        jLabel5.setText("Gaussiano");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(botonMedio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(botonBinomial, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(botonGaussiano, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(botonMedio))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel3)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonBinomial))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel4)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(botonGaussiano))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel5)))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.LINE_START);

        grupoBotonesMatriz.add(boton3x3);
        boton3x3.setText("3x3");
        boton3x3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton3x3ActionPerformed(evt);
            }
        });

        grupoBotonesMatriz.add(boton5x5);
        boton5x5.setText("5x5");

        grupoBotonesMatriz.add(boton7x7);
        boton7x7.setText("7x7");

        grupoBotonesMatriz.add(boton9x9);
        boton9x9.setText("9x9");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boton3x3)
                    .addComponent(boton5x5)
                    .addComponent(boton7x7)
                    .addComponent(boton9x9))
                .addGap(0, 397, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(boton3x3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boton5x5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boton7x7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boton9x9)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonMedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMedioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonMedioActionPerformed

    private void botonBinomialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBinomialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonBinomialActionPerformed

    private void botonGaussianoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGaussianoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonGaussianoActionPerformed

    private void butonReset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonReset1ActionPerformed
        resetHerramienta();
    }//GEN-LAST:event_butonReset1ActionPerformed

    private void boton3x3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton3x3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton3x3ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(herramientaEmborronamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /*
        /* Create and display the form
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
        new herramientaEmborronamiento(VentanaPrincipal padre).setVisible(true);
        }
        });*/
        
        //</editor-fold>

        /*
        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new herramientaEmborronamiento(VentanaPrincipal padre).setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton boton3x3;
    private javax.swing.JRadioButton boton5x5;
    private javax.swing.JRadioButton boton7x7;
    private javax.swing.JRadioButton boton9x9;
    private javax.swing.JToggleButton botonBinomial;
    private javax.swing.JToggleButton botonGaussiano;
    private javax.swing.JToggleButton botonMedio;
    private javax.swing.JButton butonReset;
    private javax.swing.JButton butonReset1;
    private javax.swing.ButtonGroup grupoBotonesMatriz;
    private javax.swing.ButtonGroup grupoBotonesTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel panelNorte;
    // End of variables declaration//GEN-END:variables
}
