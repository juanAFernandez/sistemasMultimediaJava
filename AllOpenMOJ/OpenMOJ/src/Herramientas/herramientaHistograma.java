/*
        This program is free software: you can redistribute it and/or modify
        it under the terms of the GNU General Public License as published by
        the Free Software Foundation, either version 3 of the License, or
        (at your option) any later version.
        This program is distributed in the hope that it will be useful,
        but WITHOUT ANY WARRANTY; without even the implied warranty of
        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
        GNU General Public License for more details.
        You should have received a copy of the GNU General Public License
        along with this program. If not, see <http://www.gnu.org/licenses/>.
      
        Copyright 2015 Juan A. Fernández Sánchez
*/
package Herramientas;

import Programa.VentanaInterna;
import Programa.VentanaPrincipal;
import static extras.Imprimir.Imprimir;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;

/**
 * Herramienta que permite visualizar los histogramas de las tres componentes de color basicas de la imagen que
 * tengamos activa en el lienzo, haciendo uso de la libreria JFreeChart
 * @see <a href="http://www.jfree.org/jfreechart/">JfreeChart</a>
 * @see <a href="http://www.fotolinux.org/programacion/java/histograma-de-una-foto-con-java/">Tutorial de muestra</a> 
 * @author Juan A. Fernández Sánchez
 */
public final class herramientaHistograma extends javax.swing.JFrame {

    /**
     * Referencia al padre.
     */
    private VentanaPrincipal padre;
    
    /**
     * Referencia a la ventana interna dentro del escritorio del padre.
     */
    private VentanaInterna vis;
           
    /**
     * La imagen que gestionamos.
     */
    private BufferedImage imagen;    
           
    /**
     * Constructor    
     * @param padre //Le pasamos el propio padre que lo crea para acceder forma fácil a métodos de este.     
     */
    public herramientaHistograma(VentanaPrincipal padre) {
        
        //Inicializamos los componentes
        initComponents();
                                      
        //Creamos la referencia al padre
        this.padre=padre;        
        
        //Sacamos la imagen del lienzo
        sacarImagen();
        
        //Dibujamos el histograma sobre los paneles creados.
        dibujarHistograma();

        
        //Listener para los eventos disparados por la ventana.
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.out.println("Cerrando ventana");        
            }
        });
        
    }
       
    /**
     * Función para obtener la imagen desde el escritorio.
     */
    private void sacarImagen(){
        
        //De esta función dependen todas las demás operaciones pués es la que refencia a la ventana para poder usar su lienzo
        //dEBEN SER BIEN GESTIONADOS LOS EVENTOS
        
        vis= (VentanaInterna) padre.getPanelEscritorio().getSelectedFrame();
        //Sólo cuando se ha seleccionado una ventana interna se puede trabajar.                          
       
        if(vis!=null){
         //Cargamos en nuestras variables privada la imagen que ese lienzo tiene.
            this.imagen=vis.getLienzo().getImage();

        }else{
            //Mostramos el mensaje de error
            JOptionPane.showMessageDialog(this, "Debes seleccionar una imagen antes de usar esta herramienta.", "Error", JOptionPane.WARNING_MESSAGE);
            padre.ventanaHerramientaBrilloContraste.setVisible(false);
            padre.ventanaHerramientaBrilloContraste=null;
            //En otro caso no se puede trabajar y es necesario avisar de que es necesario tener una ventan seleccionada.
        }
    }
    
    /**
     * Realiza realmente el dibujado de los historgramas en los paneles de la herramienta.
     */
    private void dibujarHistograma(){
        // Creamos el histograma
        try {

            // utilizamos la clase histograma
            Histograma ObjHistograma=new Histograma();
            int[][] histograma=ObjHistograma.histograma((BufferedImage)imagen);
            
            Imprimir("histograma size"+histograma.length);
            
            // utilizamos la clase creadora de histogramas
            HistogramCreator ObjDibujaHisto=new HistogramCreator();
            for (int i = 0; i < 3; i++) {
                //extraemos un canal del histograma 
                int[] histogramaCanal=new int[256];
                System.arraycopy(histograma[i], 0, histogramaCanal, 0, histograma[i].length);
                //Dibujamos en el panel
                switch(i){
                    case 0:
                        ObjDibujaHisto.crearHistograma(histogramaCanal, this.jPanelRed, Color.red);
                        break;
                    case 1:
                        ObjDibujaHisto.crearHistograma(histogramaCanal, this.jPanelGreen, Color.green);
                        break;
                    case 2:
                        ObjDibujaHisto.crearHistograma(histogramaCanal, this.jPanelBlue, Color.blue);
                        break;
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, JOptionPane.ERROR_MESSAGE, "Error controlado en excepción", JOptionPane.ERROR_MESSAGE);
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
        jLayeredPane1 = new javax.swing.JLayeredPane();
        panelNorte = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        exitButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanelRed = new javax.swing.JPanel();
        jPanelGreen = new javax.swing.JPanel();
        jPanelBlue = new javax.swing.JPanel();

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
        jLabel1.setText("Histograma");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/negative.png"))); // NOI18N

        exitButton.setBackground(new java.awt.Color(255, 135, 135));
        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cancel.png"))); // NOI18N
        exitButton.setPreferredSize(new java.awt.Dimension(40, 40));
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelNorteLayout = new javax.swing.GroupLayout(panelNorte);
        panelNorte.setLayout(panelNorteLayout);
        panelNorteLayout.setHorizontalGroup(
            panelNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNorteLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 606, Short.MAX_VALUE)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelNorteLayout.setVerticalGroup(
            panelNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNorteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)))
            .addComponent(exitButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(panelNorte, java.awt.BorderLayout.PAGE_START);

        jPanel4.setLayout(new java.awt.GridLayout());

        javax.swing.GroupLayout jPanelRedLayout = new javax.swing.GroupLayout(jPanelRed);
        jPanelRed.setLayout(jPanelRedLayout);
        jPanelRedLayout.setHorizontalGroup(
            jPanelRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 263, Short.MAX_VALUE)
        );
        jPanelRedLayout.setVerticalGroup(
            jPanelRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 323, Short.MAX_VALUE)
        );

        jPanel4.add(jPanelRed);

        javax.swing.GroupLayout jPanelGreenLayout = new javax.swing.GroupLayout(jPanelGreen);
        jPanelGreen.setLayout(jPanelGreenLayout);
        jPanelGreenLayout.setHorizontalGroup(
            jPanelGreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 263, Short.MAX_VALUE)
        );
        jPanelGreenLayout.setVerticalGroup(
            jPanelGreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 323, Short.MAX_VALUE)
        );

        jPanel4.add(jPanelGreen);

        javax.swing.GroupLayout jPanelBlueLayout = new javax.swing.GroupLayout(jPanelBlue);
        jPanelBlue.setLayout(jPanelBlueLayout);
        jPanelBlueLayout.setHorizontalGroup(
            jPanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 263, Short.MAX_VALUE)
        );
        jPanelBlueLayout.setVerticalGroup(
            jPanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 323, Short.MAX_VALUE)
        );

        jPanel4.add(jPanelBlue);

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Programación del evento de cierre de la ventana.
     * @param evt Evento que se captura.
     */
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        //Hace exactamente lo mismo que darle al boton cerrar de la esquina superior izquierda, es decir llamar a recuperarImagen.
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_exitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(herramientaHistograma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton exitButton;
    private javax.swing.ButtonGroup grupoBotonesMatriz;
    private javax.swing.ButtonGroup grupoBotonesTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelBlue;
    private javax.swing.JPanel jPanelGreen;
    private javax.swing.JPanel jPanelRed;
    private javax.swing.JPanel panelNorte;
    // End of variables declaration//GEN-END:variables
}
