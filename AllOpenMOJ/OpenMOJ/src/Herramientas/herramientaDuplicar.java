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
package Herramientas;

import Programa.VentanaInterna;
import Programa.VentanaPrincipal;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;


/**
 * Herramienta de copia de imágenes.
 * Permite realizar duplicados de imágenes para cualquier función poserior. Estas copias son abiertas
 * como nuevas ventanas dentro del escritorio principal, por lo que también se crean todas las variables
 * necesarias al rspecto.
 * @author Juan A. Fernández Sánchez
 */
public final class herramientaDuplicar extends javax.swing.JFrame {

    /**
     * Referencia a la ventana principal del programa para poder acceder a sus elementos.
     */
    private VentanaPrincipal padre;
    
    /**
     * Referencia a la ventana interna del escritorio de VentanaPrincipal donde se encuentra
     * la imagen que con la que hay que trabajar.
     */
    private VentanaInterna viA;
        

    /**
     * Objeto copia de la imagen que gestionamos.
     */
    private BufferedImage imagenA;
     
      
    /**
     * Constructor    
     * @param padre //Le pasamos el propio padre que lo crea para acceder forma fácil a métodos de este.     
     */
    public herramientaDuplicar(VentanaPrincipal padre) {
        initComponents();

        
        //Creamos la referencia al padre
        this.padre=padre;
        
        titleImgA.setText("todavia nada");
             
       this.addWindowListener(new java.awt.event.WindowAdapter() {
    @Override
    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
        System.out.println("Cerrando ventana");        
    }
});
        
    }

    
    /**
     * Extrae una imagen desde el lienzo que se selecciona.
     */
    private void sacarImagenA(){
        viA= (VentanaInterna) padre.getPanelEscritorio().getSelectedFrame();
                            
        if(viA!=null){
                
            //Sacamos el nombre del linezo
                titleImgA.setText(viA.getTitle());
            //Cargamos en nuestras variables privada la imagen que ese lienzo tiene:
                imagenA=viA.getLienzo().getImage();
            //Grabamos el nombre de la copia por defecto:
                //Si el nombre contiene .jpg el dos lo tenemos que poner antes de jpg.
                if(titleImgA.getText().contains(".jpg"))
                    campoNombreImagen.setText("2"+titleImgA.getText());
                else
                    campoNombreImagen.setText(titleImgA.getText()+"2");

        }else{
            //Mostramos el mensaje de error
            JOptionPane.showMessageDialog(this, "Debes seleccionar una imagen antes de usar esta herramienta.", "Error", JOptionPane.WARNING_MESSAGE);
            padre.ventanaHerramientaBrilloContraste.setVisible(false);
            padre.ventanaHerramientaBrilloContraste=null;
            //En otro caso no se puede trabajar y es necesario avisar de que es necesario tener una ventan seleccionada.
        }
                
    }

    /**
     * Crea un nuevo linezo y añade la imagen obtenida del otro.
     */
    private void duplicarLienzo(){
        
        //1º Creamos una ventana interna

            VentanaInterna ventanaInterna = new VentanaInterna(this.padre);
            //Establecemos la herramienta por defecto.
            ventanaInterna.getLienzo().setTipoHerramienta(padre.herramienta);

            //Establecemos un estilo de trazo por defecto al lienzo para que cree las figuras nuevas con esos parámetros:
            ventanaInterna.getLienzo().setTrazo(padre.getTrazoDefecto());
            ventanaInterna.getLienzo().setRelleno(padre.rellenoActivo);
            ventanaInterna.getLienzo().setRelleno(padre.getRellenoDefecto());
            //Activamos la mejora de alisamiento de dibujo
            ventanaInterna.getLienzo().setMejoraRenderizacion(true);
            //Le damos el nombre del campo de texto:
            ventanaInterna.setTitle(campoNombreImagen.getText());
            
        //2ºLe añadimos la imagen
            
            if(imagenA!=null)
                ventanaInterna.getLienzo().setImage(imagenA);
            else
                JOptionPane.showMessageDialog(this,"Debes de seleccionar una imagen antes.", "Error", JOptionPane.WARNING_MESSAGE);
         
        //3º La añadimos al escritorio y la hacemos visible.

                    //Añadimos la ventana a la variable escritorio.
                    padre.getPanelEscritorio().add(ventanaInterna);        
                    //Hacemos visible la ventana interna dentro del escritorio.
                    ventanaInterna.setVisible(true);
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
        textDuplicar = new javax.swing.JLabel();
        iconoDuplicar = new javax.swing.JLabel();
        exitButton = new javax.swing.JButton();
        panelIzquierdo = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        titleImgA = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoNombreImagen = new javax.swing.JTextField();
        capturaImagenA = new javax.swing.JButton();
        botonDuplicar = new javax.swing.JButton();

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

        textDuplicar.setFont(new java.awt.Font("Sawasdee", 1, 18)); // NOI18N
        textDuplicar.setForeground(new java.awt.Color(51, 51, 51));
        textDuplicar.setText("Duplicar");

        iconoDuplicar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/duplicate.png"))); // NOI18N

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
                .addComponent(iconoDuplicar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textDuplicar, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                .addGap(110, 110, 110)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelNorteLayout.setVerticalGroup(
            panelNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNorteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textDuplicar)
                    .addComponent(iconoDuplicar)))
            .addComponent(exitButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel6.setFont(new java.awt.Font("Sawasdee", 1, 14)); // NOI18N
        jLabel6.setText("Selecione un lienzo del escritorio");

        jLabel2.setText("Imagen capturada:");

        titleImgA.setText("jLabel4");

        jLabel7.setFont(new java.awt.Font("Sawasdee", 1, 14)); // NOI18N
        jLabel7.setText("Pulse la ventana que la contiene y capture.");

        jLabel4.setText("Nuevo nombre:");

        campoNombreImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombreImagenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelIzquierdoLayout = new javax.swing.GroupLayout(panelIzquierdo);
        panelIzquierdo.setLayout(panelIzquierdoLayout);
        panelIzquierdoLayout.setHorizontalGroup(
            panelIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIzquierdoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIzquierdoLayout.createSequentialGroup()
                .addGap(0, 66, Short.MAX_VALUE)
                .addGroup(panelIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelIzquierdoLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(66, 66, 66)
                        .addComponent(campoNombreImagen)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIzquierdoLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(61, 61, 61)
                        .addComponent(titleImgA)
                        .addGap(65, 65, 65))))
        );
        panelIzquierdoLayout.setVerticalGroup(
            panelIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIzquierdoLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(titleImgA))
                .addGap(18, 18, 18)
                .addGroup(panelIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoNombreImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        capturaImagenA.setText("Capturar");
        capturaImagenA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capturaImagenAActionPerformed(evt);
            }
        });

        botonDuplicar.setText("Duplicar");
        botonDuplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDuplicarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelNorte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(capturaImagenA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonDuplicar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelNorte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(capturaImagenA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonDuplicar)
                        .addGap(22, 22, 22))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        //Hace exactamente lo mismo que darle al boton cerrar de la esquina superior izquierda, es decir llamar a recuperarImagen.
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_exitButtonActionPerformed

    private void capturaImagenAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capturaImagenAActionPerformed
        this.sacarImagenA();
    }//GEN-LAST:event_capturaImagenAActionPerformed

    private void campoNombreImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreImagenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNombreImagenActionPerformed

    private void botonDuplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDuplicarActionPerformed
        duplicarLienzo();
    }//GEN-LAST:event_botonDuplicarActionPerformed

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
            java.util.logging.Logger.getLogger(herramientaDuplicar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton botonDuplicar;
    private javax.swing.JTextField campoNombreImagen;
    private javax.swing.JButton capturaImagenA;
    private javax.swing.JButton exitButton;
    private javax.swing.ButtonGroup grupoBotonesMatriz;
    private javax.swing.ButtonGroup grupoBotonesTipo;
    private javax.swing.JLabel iconoDuplicar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel panelIzquierdo;
    private javax.swing.JPanel panelNorte;
    private javax.swing.JLabel textDuplicar;
    private javax.swing.JLabel titleImgA;
    // End of variables declaration//GEN-END:variables


}
