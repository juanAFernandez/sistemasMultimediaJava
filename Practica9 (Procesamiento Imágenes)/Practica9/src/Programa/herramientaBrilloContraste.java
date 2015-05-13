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
public class herramientaBrilloContraste extends javax.swing.JFrame {

    
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
    public herramientaBrilloContraste(VentanaPrincipal padre) {
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
        
    }

    
    private void cambiarTipo(){
        
 
            
            
            
            
            
            
            
            k= KernelProducer.createKernel(KernelProducer.TYPE_BINOMIAL_3x3);
        
        
        //Se configura la operación de convolución con la nueva máscara que siempre será k.
        cop= new ConvolveOp(k,ConvolveOp.EDGE_NO_OP,null);
        
        aplicar();
            
    }
    
    /**
     * Con esta función reseteamos la herramienta y dejamos la imagen como estaba al principio.
     */
    private void resetHerramienta(){
       
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
        jSlider1 = new javax.swing.JSlider();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        jPanel1.setBackground(new java.awt.Color(255, 0, 51));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 50));
        jPanel1.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        panelNorte.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Sawasdee", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 255));
        jLabel1.setText("Brillo y Contraste");

        javax.swing.GroupLayout panelNorteLayout = new javax.swing.GroupLayout(panelNorte);
        panelNorte.setLayout(panelNorteLayout);
        panelNorteLayout.setHorizontalGroup(
            panelNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNorteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(686, Short.MAX_VALUE))
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
                .addContainerGap(56, Short.MAX_VALUE)
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
                .addComponent(jLabel8))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.LINE_END);

        jLabel2.setFont(new java.awt.Font("Sawasdee", 1, 24)); // NOI18N
        jLabel2.setText("Brillo:");

        jLabel9.setFont(new java.awt.Font("Sawasdee", 1, 24)); // NOI18N
        jLabel9.setText("Contraste:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 81, Short.MAX_VALUE)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel9)
                .addContainerGap(164, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butonReset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonReset1ActionPerformed
        resetHerramienta();
    }//GEN-LAST:event_butonReset1ActionPerformed

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
            java.util.logging.Logger.getLogger(herramientaBrilloContraste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton butonReset;
    private javax.swing.JButton butonReset1;
    private javax.swing.ButtonGroup grupoBotonesMatriz;
    private javax.swing.ButtonGroup grupoBotonesTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JPanel panelNorte;
    // End of variables declaration//GEN-END:variables
}
