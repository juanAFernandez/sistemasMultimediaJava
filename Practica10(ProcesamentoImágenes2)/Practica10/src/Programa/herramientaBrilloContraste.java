/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programa;

import static extras.Imprimir.Imprimir;
import java.awt.Component;
import java.awt.Container;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import java.awt.image.RescaleOp;
import javax.swing.AbstractButton;
import javax.swing.JRootPane;
import sm.image.KernelProducer;
import sm.image.LookupTableProducer;

/**
 *
 * @author juan
 */
public final class herramientaBrilloContraste extends javax.swing.JFrame {

    
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
    
     private BufferedImage imgTMP;
    /**
     * Constructor    
     * @param padre //Le pasamos el propio padre que lo crea para acceder forma fácil a métodos de este.
     */
    public herramientaBrilloContraste(VentanaPrincipal padre) {
        initComponents();
        
    
        
        
        
        //Creamos la referencia al padre
        this.padre=padre;
        
        //Ponemos el slider del brillo a 0
        textNivelBrillo.setText("0");
      
        
        //Sacamos la imagen del lienzo
        sacarImagen();
        
        //Establecemos el tipo de matriz por defecto.
       //  k= KernelProducer.createKernel(KernelProducer.TYPE_MEDIA_3x3);
      //   cop= new ConvolveOp(k,ConvolveOp.EDGE_NO_OP,null);
        
        //Realizamos el trabajo
       // aplicar();
        
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
        
        
        
        //Escribimos 0 en el text del nivel de brillo
        textNivelBrillo.setText("0");  
                
        //Ponemos a 0 el slider del brillo
        sliderBrillo.setValue(0);        
        
        //Enviamos la copia de la imagen que teníamos guadada deshaciendo cualquier operación anterior.
        vis.getLienzo().setImage(imagenTemporalParaOperaciones);
               
    }
    
    private void sacarImagen(){
        
        //De esta función dependen todas las demás operaciones pués es la que refencia a la ventana para poder usar su lienzo
        //dEBEN SER BIEN GESTIONADOS LOS EVENTOS
        
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
        jLayeredPane1 = new javax.swing.JLayeredPane();
        panelPrivado = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        butonReset1 = new javax.swing.JButton();
        butonReset = new javax.swing.JButton();
        panelNorte = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        butonReset2 = new javax.swing.JButton();
        butonReset3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        sliderBrillo = new javax.swing.JSlider();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textNivelBrillo = new javax.swing.JLabel();
        contrasteOscurecimiento = new javax.swing.JButton();
        contrasteIluminacion = new javax.swing.JButton();
        textContrasteNormal = new javax.swing.JLabel();
        textContrasteOscurecimiento = new javax.swing.JLabel();
        contrasteOscurecimiento1 = new javax.swing.JButton();
        textContrasteIluminacion = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

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

        panelPrivado.setBackground(new java.awt.Color(101, 81, 101));
        panelPrivado.setMinimumSize(new java.awt.Dimension(0, 50));

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cancel.png"))); // NOI18N

        butonReset1.setBackground(new java.awt.Color(0, 102, 102));
        butonReset1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reset.png"))); // NOI18N
        butonReset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonReset1ActionPerformed(evt);
            }
        });

        butonReset.setBackground(new java.awt.Color(0, 102, 102));
        butonReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/save.png"))); // NOI18N
        butonReset.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout panelPrivadoLayout = new javax.swing.GroupLayout(panelPrivado);
        panelPrivado.setLayout(panelPrivadoLayout);
        panelPrivadoLayout.setHorizontalGroup(
            panelPrivadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrivadoLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jButton1)
                .addGap(61, 61, 61)
                .addComponent(butonReset1)
                .addGap(55, 55, 55)
                .addComponent(butonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPrivadoLayout.setVerticalGroup(
            panelPrivadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrivadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrivadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(butonReset1)
                    .addComponent(butonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(panelPrivado, java.awt.BorderLayout.PAGE_END);

        panelNorte.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Sawasdee", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 255));
        jLabel1.setText("Brillo y Contraste");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/brilloContrasteMini.png"))); // NOI18N

        jButton2.setText("oh!");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelNorteLayout = new javax.swing.GroupLayout(panelNorte);
        panelNorte.setLayout(panelNorteLayout);
        panelNorteLayout.setHorizontalGroup(
            panelNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNorteLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        panelNorteLayout.setVerticalGroup(
            panelNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNorteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jButton2))
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelNorte, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(101, 81, 101));
        jPanel2.setMinimumSize(new java.awt.Dimension(0, 50));

        jButton3.setBackground(new java.awt.Color(0, 102, 102));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cancel.png"))); // NOI18N

        butonReset2.setBackground(new java.awt.Color(0, 102, 102));
        butonReset2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reset.png"))); // NOI18N
        butonReset2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonReset2ActionPerformed(evt);
            }
        });

        butonReset3.setBackground(new java.awt.Color(0, 102, 102));
        butonReset3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/save.png"))); // NOI18N
        butonReset3.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jButton3)
                .addGap(61, 61, 61)
                .addComponent(butonReset2)
                .addGap(55, 55, 55)
                .addComponent(butonReset3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3)
                    .addComponent(butonReset2)
                    .addComponent(butonReset3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        sliderBrillo.setMaximum(255);
        sliderBrillo.setMinimum(-255);
        sliderBrillo.setValue(0);
        sliderBrillo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderBrilloStateChanged(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Sawasdee", 1, 14)); // NOI18N
        jLabel9.setText("Contraste:");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/contrasteMini.png"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/brilloMini.png"))); // NOI18N

        textNivelBrillo.setFont(new java.awt.Font("Sawasdee", 0, 18)); // NOI18N
        textNivelBrillo.setText("0");

        contrasteOscurecimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contrasteOscurecimientoActionPerformed(evt);
            }
        });

        contrasteIluminacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contrasteIluminacionActionPerformed(evt);
            }
        });

        textContrasteNormal.setFont(new java.awt.Font("Sawasdee", 0, 14)); // NOI18N
        textContrasteNormal.setText("Normal");

        textContrasteOscurecimiento.setFont(new java.awt.Font("Sawasdee", 0, 14)); // NOI18N
        textContrasteOscurecimiento.setText("Oscurecimiento");
        textContrasteOscurecimiento.setToolTipText("");

        contrasteOscurecimiento1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contrasteOscurecimiento1ActionPerformed(evt);
            }
        });

        textContrasteIluminacion.setFont(new java.awt.Font("Sawasdee", 0, 14)); // NOI18N
        textContrasteIluminacion.setText("Iluminación");

        jLabel2.setFont(new java.awt.Font("Sawasdee", 1, 14)); // NOI18N
        jLabel2.setText("Brillo:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(contrasteOscurecimiento)
                        .addGap(18, 18, 18)
                        .addComponent(textContrasteNormal)
                        .addGap(18, 18, 18)
                        .addComponent(contrasteIluminacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textContrasteIluminacion)
                        .addGap(29, 29, 29)
                        .addComponent(contrasteOscurecimiento1)
                        .addGap(18, 18, 18)
                        .addComponent(textContrasteOscurecimiento))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(sliderBrillo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(textNivelBrillo))
                            .addComponent(jLabel2))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sliderBrillo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNivelBrillo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contrasteOscurecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textContrasteNormal)
                            .addComponent(textContrasteIluminacion))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(contrasteOscurecimiento1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(3, 3, 3)))
                    .addComponent(contrasteIluminacion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textContrasteOscurecimiento))
                .addContainerGap())
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butonReset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonReset1ActionPerformed
        resetHerramienta();
    }//GEN-LAST:event_butonReset1ActionPerformed

    private void sliderBrilloStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderBrilloStateChanged
        //Log por terminal
        Imprimir("Cambio de estado del slider de brillo");
        //Cambiamos el texto junto al slider preguntandole el valor al slider
        textNivelBrillo.setText(Integer.toString(sliderBrillo.getValue()));
        
        RescaleOp rop = new RescaleOp(1.0F, (float)this.sliderBrillo.getValue(), null);
        
        
        
        //Aplicamos la operación a la copia de la imagen
        if(this.imagenTemporalParaOperaciones!=null){
            //Aplicamos la operación sobre la imagen temporal
            //a: origen b: destino
            //this.imagenTemporalParaOperaciones = rop.filter(imagenTemporalParaOperaciones, imagenTemporalParaOperaciones);
            
            /*Lo que hacemos será aplicar la operación sobre la imagen temporal y su resultado lo llevamos a la imagen del 
            lienzo así siempre tendremos una referencia del original.
                    
            */
            vis.getLienzo().setImage(rop.filter(imagenTemporalParaOperaciones, null));
            
            
            
            //Hacemos que se repinte para ver el resultado mientras movemos el slider
            vis.getLienzo().repaint();
        }
        
        
        
        
    }//GEN-LAST:event_sliderBrilloStateChanged

    private void contrasteOscurecimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contrasteOscurecimientoActionPerformed
       
        Imprimir("Aplicando contraste normal");
        
        try{
      
            int type = LookupTableProducer.TYPE_SFUNCION;
            LookupTable lt = LookupTableProducer.createLookupTable(type);
            LookupOp lop = new LookupOp(lt, null);

            /*
            Atención:
            El no pasarle como destino una imagen a filter pese a que la función ya nos devuelve el resultado hará que
            provoque un error en los canales de la imagen que produzca haciendo que los canales B y R se intercambien
            produciendo un efecto no deseado.            
            
            Entonces usaríamos la imagen temporal tanto en source como en destino, el problema ahora entonces es que perdemos la 
            copia de la imagen original y no podremos volver al estado original, por eso para esta y sólo para esta operación 
            crearemos otra copia de la imagen.
            */
            imgTMP=imagenTemporalParaOperaciones;
            
            //Aplico el filtro y guardo el resultado en el lienzo.
            
            vis.getLienzo().setImage(lop.filter(imgTMP,imgTMP));
            
            /*
            Así será imgTMP la que sufra los cambios conservando siempre nosotros una copia de la original.
            */
            
            vis.getLienzo().repaint();
        
        } catch(Exception e){
          System.err.println(e.getLocalizedMessage());
        }
        
        
        
        
    }//GEN-LAST:event_contrasteOscurecimientoActionPerformed

    private void contrasteIluminacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contrasteIluminacionActionPerformed
         Imprimir("Aplicando contraste normal");
        
        try{
      
            int type = LookupTableProducer.TYPE_LOGARITHM;
            LookupTable lt = LookupTableProducer.createLookupTable(type);
            LookupOp lop = new LookupOp(lt, null);

            /*
            Atención:
            El no pasarle como destino una imagen a filter pese a que la función ya nos devuelve el resultado hará que
            provoque un error en los canales de la imagen que produzca haciendo que los canales B y R se intercambien
            produciendo un efecto no deseado.            
            
            Entonces usaríamos la imagen temporal tanto en source como en destino, el problema ahora entonces es que perdemos la 
            copia de la imagen original y no podremos volver al estado original, por eso para esta y sólo para esta operación 
            crearemos otra copia de la imagen.
            */
            imgTMP=imagenTemporalParaOperaciones;
            
            //Aplico el filtro y guardo el resultado en el lienzo.
            
            vis.getLienzo().setImage(lop.filter(imgTMP,imgTMP));
            
            /*
            Así será imgTMP la que sufra los cambios conservando siempre nosotros una copia de la original.
            */
            
            vis.getLienzo().repaint();
        
        } catch(Exception e){
          System.err.println(e.getLocalizedMessage());
        }
    }//GEN-LAST:event_contrasteIluminacionActionPerformed

    private void contrasteOscurecimiento1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contrasteOscurecimiento1ActionPerformed
         Imprimir("Aplicando contraste normal");
        
        try{
      
            int type = LookupTableProducer.TYPE_POWER;
            LookupTable lt = LookupTableProducer.createLookupTable(type);
            LookupOp lop = new LookupOp(lt, null);
           
            imgTMP=imagenTemporalParaOperaciones;
            
            //Aplico el filtro y guardo el resultado en el lienzo.
            
            vis.getLienzo().setImage(lop.filter(imgTMP,imgTMP));
            
 
            vis.getLienzo().repaint();
        
        } catch(Exception e){
          System.err.println(e.getLocalizedMessage());
        }
    }//GEN-LAST:event_contrasteOscurecimiento1ActionPerformed

    private void butonReset2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonReset2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_butonReset2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        panelPrivado.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JButton butonReset2;
    private javax.swing.JButton butonReset3;
    private javax.swing.JButton contrasteIluminacion;
    private javax.swing.JButton contrasteOscurecimiento;
    private javax.swing.JButton contrasteOscurecimiento1;
    private javax.swing.ButtonGroup grupoBotonesMatriz;
    private javax.swing.ButtonGroup grupoBotonesTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel panelNorte;
    private javax.swing.JPanel panelPrivado;
    private javax.swing.JSlider sliderBrillo;
    private javax.swing.JLabel textContrasteIluminacion;
    private javax.swing.JLabel textContrasteNormal;
    private javax.swing.JLabel textContrasteOscurecimiento;
    private javax.swing.JLabel textNivelBrillo;
    // End of variables declaration//GEN-END:variables
}
