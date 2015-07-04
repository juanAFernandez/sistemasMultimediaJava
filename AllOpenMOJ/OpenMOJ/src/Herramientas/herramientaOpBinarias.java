package Herramientas;

import Programa.VentanaInterna;
import Programa.VentanaPrincipal;
import static extras.Imprimir.Imprimir;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ByteLookupTable;
import java.awt.image.ColorModel;
import java.awt.image.LookupOp;
import java.awt.image.WritableRaster;
import javax.swing.JOptionPane;
import sm.jaf.imagen.RestaOp;
import sm.jaf.imagen.UmbralizacionOp;
import sm.jaf.imagen.SumaOp;


/**
 *
 * @author Juan A. Fernández Sánchez
 */
public final class herramientaOpBinarias extends javax.swing.JFrame {

    
    private VentanaPrincipal padre;
    
    private VentanaInterna viA;
    private VentanaInterna viB;
        
    private int umbral;
    //Las dos imagenes que gestionamos. Una copia de la original y el resultado de las operaciones.
    private BufferedImage imagenA, imagenB;
     
      
    /**
     * Constructor    
     * @param padre //Le pasamos el propio padre que lo crea para acceder forma fácil a métodos de este.     
     */
    public herramientaOpBinarias(VentanaPrincipal padre) {
        initComponents();
                          
    
        
        //Creamos la referencia al padre
        this.padre=padre;
        
       titleImgA.setText("todavia nada");
       titleImgB.setText("todavia nada");
        
        //Sacamos la imagen del lienzo
       // sacarImagen();
        

        
        
    //    aplicar();
        
        
        this.addWindowListener(new java.awt.event.WindowAdapter() {
    @Override
    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
        System.out.println("Cerrando ventana");
        recuperarImagen();
    }
});
        
    }

   
    
    /**
     * Con esta función reseteamos la herramienta y dejamos la imagen como estaba al principio.
     */
    private void resetHerramienta(){
                
        Imprimir("Reseteando imagen");
        //Enviamos la copia de la imagen que teníamos guadada deshaciendo cualquier operación anterior.
     //   viA.getLienzo().setImage(imagenTemporalParaOperaciones);
               
    }
    
    
    private void sacarImagenA(){
        viA= (VentanaInterna) padre.getPanelEscritorio().getSelectedFrame();
                            
        if(viA!=null){
                
            //Le cambiamos el nombre a la ventana:
                titleImgA.setText(viA.getTitle());
            //Cargamos en nuestras variables privada la imagen que ese lienzo tiene:
                this.imagenA=viA.getLienzo().getImage();

        }else{
            //Mostramos el mensaje de error
            JOptionPane.showMessageDialog(this, "Debes seleccionar una imagen antes de usar esta herramienta.", "Error", JOptionPane.WARNING_MESSAGE);
            padre.ventanaHerramientaBrilloContraste.setVisible(false);
            padre.ventanaHerramientaBrilloContraste=null;
            //En otro caso no se puede trabajar y es necesario avisar de que es necesario tener una ventan seleccionada.
        }
                
    }
    
    private void sacarImagenB(){
         viB= (VentanaInterna) padre.getPanelEscritorio().getSelectedFrame();
                            
        if(viB!=null){
                
            //Le cambiamos el nombre a la ventana:
                titleImgB.setText(viB.getTitle());
            //Cargamos en nuestras variables privada la imagen que ese lienzo tiene:
                this.imagenB=viB.getLienzo().getImage();

        }else{
            //Mostramos el mensaje de error
            JOptionPane.showMessageDialog(this, "Debes seleccionar una imagen antes de usar esta herramienta.", "Error", JOptionPane.WARNING_MESSAGE);
            padre.ventanaHerramientaBrilloContraste.setVisible(false);
            padre.ventanaHerramientaBrilloContraste=null;
            //En otro caso no se puede trabajar y es necesario avisar de que es necesario tener una ventan seleccionada.
        }
    }
    
    /**
     * Función para obtener la imagen desde el escritorio.
     */
    private void sacarImagen(){
        
        //De esta función dependen todas las demás operaciones pués es la que refencia a la ventana para poder usar su lienzo
        //dEBEN SER BIEN GESTIONADOS LOS EVENTOS
        
    //    vis= (VentanaInterna) padre.getPanelEscritorio().getSelectedFrame();
        
        
         //Sólo cuando se ha seleccionado una ventana interna se puede trabajar.                          
       
    //    if(vis!=null){
         //Cargamos en nuestras variables privada la imagen que ese lienzo tiene.
//            this.imagenTemporalParaOperaciones=vis.getLienzo().getImage();
            
            //Cargamos el título de la ventana en el panel de la herramienta:
     //       titleImgA.setText(vis.getTitle());
            

     //   }else{
            //Mostramos el mensaje de error
            JOptionPane.showMessageDialog(this, "Debes seleccionar una imagen antes de usar esta herramienta.", "Error", JOptionPane.WARNING_MESSAGE);
            padre.ventanaHerramientaBrilloContraste.setVisible(false);
            padre.ventanaHerramientaBrilloContraste=null;
            //En otro caso no se puede trabajar y es necesario avisar de que es necesario tener una ventan seleccionada.
     //   }
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
        jLayeredPane1 = new javax.swing.JLayeredPane();
        panelNorte = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        exitButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        titleImgA = new javax.swing.JLabel();
        capturaImagenA = new javax.swing.JButton();
        capturaImagenB = new javax.swing.JButton();
        titleImgB = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        botonSUMA = new javax.swing.JButton();
        botonRESTA = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        panelNorte.setBackground(new java.awt.Color(145, 145, 145));

        jLabel1.setFont(new java.awt.Font("Sawasdee", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Operaciones binarias");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/plus_subtraction.png"))); // NOI18N

        exitButton.setBackground(new java.awt.Color(255, 135, 135));
        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cancel.png"))); // NOI18N
        exitButton.setPreferredSize(new java.awt.Dimension(40, 40));
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        resetButton.setBackground(new java.awt.Color(255, 219, 147));
        resetButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reset.png"))); // NOI18N
        resetButton.setPreferredSize(new java.awt.Dimension(40, 40));
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        saveButton.setBackground(new java.awt.Color(168, 255, 168));
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/save.png"))); // NOI18N
        saveButton.setPreferredSize(new java.awt.Dimension(40, 40));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelNorteLayout = new javax.swing.GroupLayout(panelNorte);
        panelNorte.setLayout(panelNorteLayout);
        panelNorteLayout.setHorizontalGroup(
            panelNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNorteLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelNorteLayout.setVerticalGroup(
            panelNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNorteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)))
            .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(panelNorte, java.awt.BorderLayout.PAGE_START);

        jLabel6.setFont(new java.awt.Font("Sawasdee", 1, 14)); // NOI18N
        jLabel6.setText("Primero debe seleccionar dos imégenes.");

        jLabel2.setText("Imagen A:");

        titleImgA.setText("jLabel4");

        capturaImagenA.setText("CapturaA");
        capturaImagenA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capturaImagenAActionPerformed(evt);
            }
        });

        capturaImagenB.setText("CapturaB");
        capturaImagenB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capturaImagenBActionPerformed(evt);
            }
        });

        titleImgB.setText("jLabel4");

        jLabel4.setText("Imagen B:");

        jLabel7.setFont(new java.awt.Font("Sawasdee", 1, 14)); // NOI18N
        jLabel7.setText("Pulse la ventana que la contiene y capture.");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleImgA)
                            .addComponent(titleImgB))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(capturaImagenB)
                            .addComponent(capturaImagenA)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(titleImgA)
                    .addComponent(capturaImagenA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(capturaImagenB)
                    .addComponent(titleImgB)
                    .addComponent(jLabel4))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.LINE_START);

        botonSUMA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/plus.png"))); // NOI18N
        botonSUMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSUMAActionPerformed(evt);
            }
        });

        botonRESTA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/substraction.png"))); // NOI18N
        botonRESTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRESTAActionPerformed(evt);
            }
        });

        jLabel5.setText("Aplicar operación:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(botonSUMA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(botonRESTA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel5)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonSUMA)
                    .addComponent(botonRESTA))
                .addGap(31, 31, 31))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Función que recupera la imagen original y también el estado  de los botones
     */
    public void recuperarImagen(){
                                                      
     //       vis.getLienzo().setImage(this.imagenTemporalParaOperaciones);
     //       vis.getLienzo().repaint();                     
    }
    
    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
            //Llamamos a recuperar imagen para que (ya que estamos reiniciando) se carge la original.
            recuperarImagen();                    
    }//GEN-LAST:event_resetButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        //Hace exactamente lo mismo que darle al boton cerrar de la esquina superior izquierda, es decir llamar a recuperarImagen.
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_exitButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        //Cerramos la ventana
        this.dispose();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void capturaImagenBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capturaImagenBActionPerformed
        this.sacarImagenB();
    }//GEN-LAST:event_capturaImagenBActionPerformed

    private void capturaImagenAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capturaImagenAActionPerformed
        this.sacarImagenA();
    }//GEN-LAST:event_capturaImagenAActionPerformed

    private void botonSUMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSUMAActionPerformed
        
        //Creamos un objeto de tipo VentanaInterna:
            VentanaInterna vi = new VentanaInterna(padre);
            
            
            SumaOp op =new SumaOp(imagenB);
            
        //Grabamos en el lienzo de esta ventana la imagen que resulta de aplicar el filtro de la op.
            
            vi.getLienzo().setImage(op.filter(imagenA,null));
                

                
        //Añadimos la ventanaInterna al escritorio del padre.
            padre.getEscritorio().add(vi);
        //Le ponemos un título a la ventana
            vi.setTitle(viA.getTitle()+"+"+viB.getTitle());
        //La hacemos visible
            vi.setVisible(true);
    }//GEN-LAST:event_botonSUMAActionPerformed

    private void botonRESTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRESTAActionPerformed
        //Creamos un objeto de tipo VentanaInterna:
            VentanaInterna vi = new VentanaInterna(padre);
            
            
            RestaOp op =new RestaOp(imagenB);
            
        //Grabamos en el lienzo de esta ventana la imagen que resulta de aplicar el filtro de la op.
            
            vi.getLienzo().setImage(op.filter(imagenA,null));
                

                
        //Añadimos la ventanaInterna al escritorio del padre.
            padre.getEscritorio().add(vi);
        //Le ponemos un título a la ventana
            vi.setTitle(viA.getTitle()+"-"+viB.getTitle());
        //La hacemos visible
            vi.setVisible(true);
    }//GEN-LAST:event_botonRESTAActionPerformed

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
            java.util.logging.Logger.getLogger(herramientaOpBinarias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton botonRESTA;
    private javax.swing.JButton botonSUMA;
    private javax.swing.JButton capturaImagenA;
    private javax.swing.JButton capturaImagenB;
    private javax.swing.JButton exitButton;
    private javax.swing.ButtonGroup grupoBotonesMatriz;
    private javax.swing.ButtonGroup grupoBotonesTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel panelNorte;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel titleImgA;
    private javax.swing.JLabel titleImgB;
    // End of variables declaration//GEN-END:variables


}
