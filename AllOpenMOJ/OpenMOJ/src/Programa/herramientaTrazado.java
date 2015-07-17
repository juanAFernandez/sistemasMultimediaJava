package Programa;

import static extras.Imprimir.Imprimir;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Stroke;
import java.awt.event.WindowEvent;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import java.awt.image.RescaleOp;
import java.awt.image.WritableRaster;
import java.util.ArrayList;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JSpinner;
import sm.image.KernelProducer;
import sm.image.LookupTableProducer;
import sm.jaf.graficos.Figura;
import sm.jaf.graficos.Linea;
import sm.jaf.graficos.Rectangulo;
import sm.jaf.graficos.Trazo;

/**
 * Herramienta de ajuste de trazado.
 * Esta clase confeccionará un tipo de trazado para la linea. Pero ojo, el grosor de la linea lo cogerá del actual
 * de la ventana activa.
 * @author Juan A. Fernández Sánchez
 */
public final class herramientaTrazado extends javax.swing.JFrame {

    
    private VentanaPrincipal padre;
    
    private VentanaInterna vis;

   
    Trazo trazo;
    
    ArrayList<JSpinner> spinners;
    

    /**sl
     * Constructor    
     * @param padre //Le pasamos el propio padre que lo crea para acceder forma fácil a métodos de este.     
     */
    @SuppressWarnings("empty-statement")
    public herramientaTrazado(VentanaPrincipal padre) {
        initComponents();
                                    
        //Creamos la referencia al padre
        this.padre=padre;
 
        //Inicializamos la variable trazo
        trazo = new Trazo();
        trazo.setCopiaTrazo(padre.getTrazoDefecto());
        
        //AJuste de los botones
        float [] patronDiscontinuidad2 = trazo.getPatronDiscontinuidad();
                
        for(int i=1; i<8; i++){
            System.out.print(patronDiscontinuidad2[i]);
           // spinners.get(i).setValue((int)patronDiscontinuidad[i]);
        }
        
        //Imprimir(trazo.toString());
                
        //Creamos las variables necesarias para montar las dos muestras:
        
        Point2D a = new Point2D.Double(50, 50);
        Point2D b = new Point2D.Double(250, 50);
        
        Point2D c = new Point2D.Double(300, 30);
        Point2D d = new Point2D.Double(450, 70);
                
        Rectangulo rectangulo = new Rectangulo();
        rectangulo.cambiarPosicion(c, d);
        
        Linea linea = new Linea(a, b);
        
        linea.setTrazo(trazo);
        rectangulo.setTrazo(trazo);
        
        

        //Las añadimos al vector de figuras:
        lienzoPrev.addFigure(linea);
        lienzoPrev.addFigure(rectangulo);
        
        //Repintamos todo el vector de figuras:
        lienzoPrev.repaint();
        
                
        spinners = new ArrayList();
        spinners.add(spinnerPatron0);
        spinners.add(spinnerPatron1);
        spinners.add(spinnerPatron2);
        spinners.add(spinnerPatron3);
        spinners.add(spinnerPatron4);
        spinners.add(spinnerPatron5);
        spinners.add(spinnerPatron6);
        spinners.add(spinnerPatron7);
        
        
               
        //AJuste de los botones
        float [] patronDiscontinuidad = trazo.getPatronDiscontinuidad();
                
        for(int i=0; i<8; i++){
            System.out.print(patronDiscontinuidad[i]);
            spinners.get(i).setValue((int)patronDiscontinuidad[i]);
        }
        
        //Tambien tenemos que cambiar los botones:
        if(trazo.getDecoracionFinalLinea()==BasicStroke.CAP_BUTT)
            this.capButt.setSelected(true);
        if(trazo.getDecoracionFinalLinea()==BasicStroke.CAP_ROUND)
            this.capRound.setSelected(true);
        if(trazo.getDecoracionFinalLinea()==BasicStroke.CAP_SQUARE)
            this.capSquared.setSelected(true);
        if(trazo.getDecoracionUnionLineas()==BasicStroke.JOIN_BEVEL)
            this.joinBEVEL.setSelected(true);
        if(trazo.getDecoracionUnionLineas()==BasicStroke.JOIN_MITER)
            this.joinMITTER.setSelected(true);
        if(trazo.getDecoracionUnionLineas()==BasicStroke.JOIN_ROUND)
            this.joinROUND.setSelected(true);
        
        
        this.addWindowListener(new java.awt.event.WindowAdapter() {
    @Override
    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
        System.out.println("Cerrando ventana");
        
    }
});
        
    }

   
  
    /**
     * Con esta función reseteamos la herramienta y dejamos la imagen como estaba al principio.
     */
    private void resetHerramienta(){
        
        
               
    }
    
   
    
    private void aplicar(){
      
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotonesBorde = new javax.swing.ButtonGroup();
        grupoBotonesEsquinas = new javax.swing.ButtonGroup();
        panelNorte = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        exitButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        textBorde = new javax.swing.JLabel();
        capButt = new javax.swing.JToggleButton();
        capRound = new javax.swing.JToggleButton();
        capSquared = new javax.swing.JToggleButton();
        lienzoPrev = new sm.jaf.iu.Lienzo2D();
        textEsquinas = new javax.swing.JLabel();
        textPrevisualizacion = new javax.swing.JLabel();
        joinBEVEL = new javax.swing.JToggleButton();
        joinROUND = new javax.swing.JToggleButton();
        joinMITTER = new javax.swing.JToggleButton();
        spinnerPatron0 = new javax.swing.JSpinner();
        spinnerPatron1 = new javax.swing.JSpinner();
        spinnerPatron4 = new javax.swing.JSpinner();
        spinnerPatron2 = new javax.swing.JSpinner();
        spinnerPatron3 = new javax.swing.JSpinner();
        spinnerPatron5 = new javax.swing.JSpinner();
        textBorde1 = new javax.swing.JLabel();
        spinnerPatron6 = new javax.swing.JSpinner();
        spinnerRetraso = new javax.swing.JSpinner();
        textBorde3 = new javax.swing.JLabel();
        spinnerPatron7 = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        panelNorte.setBackground(new java.awt.Color(145, 145, 145));

        jLabel1.setFont(new java.awt.Font("Sawasdee", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Ajustes de trazado");

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

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/settings.png"))); // NOI18N

        javax.swing.GroupLayout panelNorteLayout = new javax.swing.GroupLayout(panelNorte);
        panelNorte.setLayout(panelNorteLayout);
        panelNorteLayout.setHorizontalGroup(
            panelNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNorteLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 255, Short.MAX_VALUE)
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
                .addGroup(panelNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)))
            .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(panelNorte, java.awt.BorderLayout.PAGE_START);

        textBorde.setFont(new java.awt.Font("Sawasdee", 1, 14)); // NOI18N
        textBorde.setText("Borde:");

        grupoBotonesBorde.add(capButt);
        capButt.setText("BUTT");
        capButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capButtActionPerformed(evt);
            }
        });

        grupoBotonesBorde.add(capRound);
        capRound.setText("ROUND");
        capRound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capRoundActionPerformed(evt);
            }
        });

        grupoBotonesBorde.add(capSquared);
        capSquared.setText("SQUARED");
        capSquared.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capSquaredActionPerformed(evt);
            }
        });

        lienzoPrev.setBackground(javax.swing.UIManager.getDefaults().getColor("ArrowButton.background"));

        javax.swing.GroupLayout lienzoPrevLayout = new javax.swing.GroupLayout(lienzoPrev);
        lienzoPrev.setLayout(lienzoPrevLayout);
        lienzoPrevLayout.setHorizontalGroup(
            lienzoPrevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 485, Short.MAX_VALUE)
        );
        lienzoPrevLayout.setVerticalGroup(
            lienzoPrevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        textEsquinas.setFont(new java.awt.Font("Sawasdee", 0, 14)); // NOI18N
        textEsquinas.setText("Esquinas:");

        textPrevisualizacion.setFont(new java.awt.Font("Sawasdee", 1, 18)); // NOI18N
        textPrevisualizacion.setText("Previsualización:");

        grupoBotonesEsquinas.add(joinBEVEL);
        joinBEVEL.setText("BEVEL");
        joinBEVEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinBEVELActionPerformed(evt);
            }
        });

        grupoBotonesEsquinas.add(joinROUND);
        joinROUND.setText("ROUND");
        joinROUND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinROUNDActionPerformed(evt);
            }
        });

        grupoBotonesEsquinas.add(joinMITTER);
        joinMITTER.setText("MITTER");
        joinMITTER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinMITTERActionPerformed(evt);
            }
        });

        spinnerPatron0.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerPatron0StateChanged(evt);
            }
        });

        spinnerPatron1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerPatron1StateChanged(evt);
            }
        });

        spinnerPatron4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerPatron4StateChanged(evt);
            }
        });

        spinnerPatron2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerPatron2StateChanged(evt);
            }
        });

        spinnerPatron3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerPatron3StateChanged(evt);
            }
        });

        spinnerPatron5.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerPatron5StateChanged(evt);
            }
        });

        textBorde1.setFont(new java.awt.Font("Sawasdee", 1, 14)); // NOI18N
        textBorde1.setText("Patron:");

        spinnerPatron6.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerPatron6StateChanged(evt);
            }
        });

        textBorde3.setFont(new java.awt.Font("Sawasdee", 1, 14)); // NOI18N
        textBorde3.setText("Retraso:");

        spinnerPatron7.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerPatron7StateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(textBorde, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(capButt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textEsquinas, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textBorde1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textBorde3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(spinnerPatron4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                                                    .addComponent(spinnerPatron0, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(spinnerPatron1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                                    .addComponent(spinnerPatron5)))
                                            .addComponent(spinnerRetraso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(joinBEVEL, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(joinROUND, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(capRound, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(spinnerPatron6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                                    .addComponent(spinnerPatron2, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(spinnerPatron3, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                    .addComponent(spinnerPatron7))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(capSquared, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(joinMITTER, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(142, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lienzoPrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textPrevisualizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(119, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textBorde, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(capButt)
                    .addComponent(capRound)
                    .addComponent(capSquared))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textEsquinas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joinBEVEL)
                    .addComponent(joinROUND)
                    .addComponent(joinMITTER))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerPatron0, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerPatron1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerPatron2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerPatron3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textBorde1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerPatron4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerPatron5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerPatron6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerPatron7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textBorde3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerRetraso, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(textPrevisualizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lienzoPrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    
    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
                               
    }//GEN-LAST:event_resetButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        //Hace exactamente lo mismo que darle al boton cerrar de la esquina superior izquierda, es decir llamar a recuperarImagen.
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_exitButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        
        /**
         * Aplicamos el trazo a la previsualización y a las ventanas activas.
         */
        //padre.getMiniLienzo().setStroke(strokeFinal);
        padre.getMiniLienzo().getFigura(0).setTrazo(trazo);
        padre.getMiniLienzo().repaint();
        
        
        if(padre.getPanelEscritorio().getSelectedFrame()!=null){
            ((VentanaInterna)padre.getPanelEscritorio().getSelectedFrame()).getLienzo().setTrazo(trazo);
            ((VentanaInterna)padre.getPanelEscritorio().getSelectedFrame()).getLienzo().aplicarUltimaFigura();
        }
                
        //Cerramos la ventana
        this.dispose();
                
    }//GEN-LAST:event_saveButtonActionPerformed

    private void capButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capButtActionPerformed
          //Las modificaciones necesarias a las variables:
        
            //Cambiamos el estilo de los extremos de las lineas.
            trazo.setDecoracionFinalLinea(BasicStroke.CAP_BUTT);
        
        //La aplicacion del nuevo estilo creado a las dos figuras de muestra:
        for(int i=0; i<2; i++){
            lienzoPrev.getFigura(i).setTrazo(trazo);
        }
        //Repintamos todas las figuras del vector
        lienzoPrev.repaint();
    }//GEN-LAST:event_capButtActionPerformed

    private void capRoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capRoundActionPerformed
        
        
        //Las modificaciones necesarias a las variables:
        
            //Cambiamos el estilo de los extremos de las lineas.
            trazo.setDecoracionFinalLinea(BasicStroke.CAP_ROUND);
        
        //La aplicacion del nuevo estilo creado a las dos figuras de muestra:
        for(int i=0; i<2; i++){
            lienzoPrev.getFigura(i).setTrazo(trazo);
        }
        //Repintamos todas las figuras del vector
        lienzoPrev.repaint();
            
        
    }//GEN-LAST:event_capRoundActionPerformed

    private void capSquaredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capSquaredActionPerformed
        //Las modificaciones necesarias a las variables:
        
            //Cambiamos el estilo de los extremos de las lineas.
            trazo.setDecoracionFinalLinea(BasicStroke.CAP_SQUARE);
        
        //La aplicacion del nuevo estilo creado a las dos figuras de muestra:
        for(int i=0; i<2; i++){
            lienzoPrev.getFigura(i).setTrazo(trazo);
        }
        //Repintamos todas las figuras del vector
        lienzoPrev.repaint();
    }//GEN-LAST:event_capSquaredActionPerformed

    private void joinBEVELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinBEVELActionPerformed
        //Las modificaciones necesarias a las variables:
        
            //Cambiamos el estilo de los extremos de las lineas.
            trazo.setDecoracionUnionLineas(BasicStroke.JOIN_BEVEL);           
        
        //La aplicacion del nuevo estilo creado a las dos figuras de muestra:
        for(int i=0; i<2; i++){
            lienzoPrev.getFigura(i).setTrazo(trazo);
        }
        //Repintamos todas las figuras del vector
        lienzoPrev.repaint();
    }//GEN-LAST:event_joinBEVELActionPerformed

    private void joinROUNDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinROUNDActionPerformed
        //Las modificaciones necesarias a las variables:
        
            //Cambiamos el estilo de los extremos de las lineas.
            trazo.setDecoracionFinalLinea(BasicStroke.JOIN_ROUND);
        
        //La aplicacion del nuevo estilo creado a las dos figuras de muestra:
        for(int i=0; i<2; i++){
            lienzoPrev.getFigura(i).setTrazo(trazo);
        }
        //Repintamos todas las figuras del vector
        lienzoPrev.repaint();
    }//GEN-LAST:event_joinROUNDActionPerformed

    private void joinMITTERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinMITTERActionPerformed
        //Las modificaciones necesarias a las variables:
        
            //Cambiamos el estilo de los extremos de las lineas.
            trazo.setDecoracionFinalLinea(BasicStroke.JOIN_MITER);
        
        //La aplicacion del nuevo estilo creado a las dos figuras de muestra:
        for(int i=0; i<2; i++){
            lienzoPrev.getFigura(i).setTrazo(trazo);
        }
        //Repintamos todas las figuras del vector
        lienzoPrev.repaint();
    }//GEN-LAST:event_joinMITTERActionPerformed

    private void spinnerPatron0StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerPatron0StateChanged
        
        //Realizamos la modificación en el patrón de discontinuidad:
        
        float [] patronSacado = trazo.getPatronDiscontinuidad();
        patronSacado[0]=(float)(1.0*(int)spinners.get(0).getValue());
        trazo.setPatronDiscontinuidad(patronSacado);
                
        //Lo aplicamos a las dos figuras:
        for(int i=0; i<2; i++)
            lienzoPrev.getFigura(i).setTrazo(trazo);
            
        this.lienzoPrev.repaint();
    }//GEN-LAST:event_spinnerPatron0StateChanged

    private void spinnerPatron1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerPatron1StateChanged
        
        Imprimir("Pulsado boton patron 1");
        
        //Sasamos el patron del objeto trazo
            float [] patronSacado = trazo.getPatronDiscontinuidad();
        
        //Lo imprimimos por pantalla
            Imprimir("patron sacado: ");
            for(int i=0; i<8; i++)
                System.out.print(patronSacado[i]+" ");
        
        //Realizamos la modificación 
            patronSacado[1]=(float)(1.0*(int)spinners.get(1).getValue());
        
        //Volvemos a imprimirlo
            Imprimir("patron modificado: ");
            for(int i=0; i<8; i++)
                System.out.print(patronSacado[i]+" ");
        
        trazo.setPatronDiscontinuidad(patronSacado);
        
        //Lo aplicamos a las dos figuras:
        for(int i=0; i<2; i++)
            lienzoPrev.getFigura(i).setTrazo(trazo);
            
        this.lienzoPrev.repaint();
    }//GEN-LAST:event_spinnerPatron1StateChanged

    private void spinnerPatron2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerPatron2StateChanged
        //Realizamos la modificación en el patrón de discontinuidad:
         float [] patronSacado = trazo.getPatronDiscontinuidad();
        patronSacado[2]=(float)(1.0*(int)spinners.get(2).getValue());
        trazo.setPatronDiscontinuidad(patronSacado);
        
        //Lo aplicamos a las dos figuras:
        for(int i=0; i<2; i++)
            lienzoPrev.getFigura(i).setTrazo(trazo);
            
        this.lienzoPrev.repaint();
    }//GEN-LAST:event_spinnerPatron2StateChanged

    private void spinnerPatron3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerPatron3StateChanged
        //Realizamos la modificación en el patrón de discontinuidad:
         float [] patronSacado = trazo.getPatronDiscontinuidad();
        patronSacado[3]=(float)(1.0*(int)spinners.get(3).getValue());
        trazo.setPatronDiscontinuidad(patronSacado);
        
        //Lo aplicamos a las dos figuras:
        for(int i=0; i<2; i++)
            lienzoPrev.getFigura(i).setTrazo(trazo);
            
        this.lienzoPrev.repaint();
    }//GEN-LAST:event_spinnerPatron3StateChanged

    private void spinnerPatron4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerPatron4StateChanged
        //Realizamos la modificación en el patrón de discontinuidad:
         float [] patronSacado = trazo.getPatronDiscontinuidad();
        patronSacado[4]=(float)(1.0*(int)spinners.get(4).getValue());
        trazo.setPatronDiscontinuidad(patronSacado);
        
        //Lo aplicamos a las dos figuras:
        for(int i=0; i<2; i++)
            lienzoPrev.getFigura(i).setTrazo(trazo);
            
        this.lienzoPrev.repaint();
    }//GEN-LAST:event_spinnerPatron4StateChanged

    private void spinnerPatron5StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerPatron5StateChanged
        //Realizamos la modificación en el patrón de discontinuidad:
         float [] patronSacado = trazo.getPatronDiscontinuidad();
        patronSacado[5]=(float)(1.0*(int)spinners.get(5).getValue());
        trazo.setPatronDiscontinuidad(patronSacado);
        
        //Lo aplicamos a las dos figuras:
        for(int i=0; i<2; i++)
            lienzoPrev.getFigura(i).setTrazo(trazo);
            
        this.lienzoPrev.repaint();
    }//GEN-LAST:event_spinnerPatron5StateChanged

    private void spinnerPatron6StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerPatron6StateChanged
        //Realizamos la modificación en el patrón de discontinuidad:
        float [] patronSacado = trazo.getPatronDiscontinuidad();
        patronSacado[6]=(float)(1.0*(int)spinners.get(6).getValue());
        trazo.setPatronDiscontinuidad(patronSacado);
        
        //Lo aplicamos a las dos figuras:
        for(int i=0; i<2; i++)
            lienzoPrev.getFigura(i).setTrazo(trazo);
            
        this.lienzoPrev.repaint();
    }//GEN-LAST:event_spinnerPatron6StateChanged

    private void spinnerPatron7StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerPatron7StateChanged
        //Realizamos la modificación en el patrón de discontinuidad:
         float [] patronSacado = trazo.getPatronDiscontinuidad();
        patronSacado[7]=(float)(1.0*(int)spinners.get(7).getValue());
        trazo.setPatronDiscontinuidad(patronSacado);
        
        //Lo aplicamos a las dos figuras:
        for(int i=0; i<2; i++)
            lienzoPrev.getFigura(i).setTrazo(trazo);
            
        this.lienzoPrev.repaint();
    }//GEN-LAST:event_spinnerPatron7StateChanged



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton capButt;
    private javax.swing.JToggleButton capRound;
    private javax.swing.JToggleButton capSquared;
    private javax.swing.JButton exitButton;
    private javax.swing.ButtonGroup grupoBotonesBorde;
    private javax.swing.ButtonGroup grupoBotonesEsquinas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton joinBEVEL;
    private javax.swing.JToggleButton joinMITTER;
    private javax.swing.JToggleButton joinROUND;
    private sm.jaf.iu.Lienzo2D lienzoPrev;
    private javax.swing.JPanel panelNorte;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JSpinner spinnerPatron0;
    private javax.swing.JSpinner spinnerPatron1;
    private javax.swing.JSpinner spinnerPatron2;
    private javax.swing.JSpinner spinnerPatron3;
    private javax.swing.JSpinner spinnerPatron4;
    private javax.swing.JSpinner spinnerPatron5;
    private javax.swing.JSpinner spinnerPatron6;
    private javax.swing.JSpinner spinnerPatron7;
    private javax.swing.JSpinner spinnerRetraso;
    private javax.swing.JLabel textBorde;
    private javax.swing.JLabel textBorde1;
    private javax.swing.JLabel textBorde3;
    private javax.swing.JLabel textEsquinas;
    private javax.swing.JLabel textPrevisualizacion;
    // End of variables declaration//GEN-END:variables
}
