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
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import java.awt.image.RescaleOp;
import java.awt.image.WritableRaster;
import javax.swing.JOptionPane;
import sm.image.LookupTableProducer;

/**
 * Herramienta brillo y contraste.
 * Herramienta que permite modificar el brillo y el contraste de una imagen a través de 
 * dos sliders en la GUI haciendo uso de RescaleOP de JAVA
 * @see <a href="http://docs.oracle.com/javase/7/docs/api/java/awt/image/RescaleOp.html">API de uso</a> 
 * @see <a href="http://www.programcreek.com/java-api-examples/index.php?api=java.awt.image.RescaleOp">Ejemplo de Uso</a>
 * @author Juan A. Fernández Sánchez
 */
public final class herramientaBrilloContraste extends javax.swing.JFrame {

    /**
     * Referencia al padre.
     * Para poder enviarle mensajes.
     */
    private VentanaPrincipal padre;
    
    /**
     * Ventana inter
     */
    private VentanaInterna vis;
    
        
    
    /**Las dos imagenes que gestionamos.
     *  Una copia de la original y el resultado de las operaciones.
     */
    private BufferedImage imagenTemporalParaOperaciones;
    private BufferedImage imgTMP;
     
    
    //Variables de control de número de aplicaciones:
    private int nVecesNormal, nVecesIluminacion, nVecesOscurecimiento;
    
    
    /**
     * Para realizar copias de las imágenes a bajo nivel.
     * AL no ser tipos primitivos no pueden realizarse copias con el operador =.
     * @param original Imagen original a copiar.
     * @return Una copia de la imagen BufferedImage pasada.
     */
    public BufferedImage deepCopy(BufferedImage original) {
        ColorModel cm = original.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = original.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }
     
    /**
     * Constructor    
     * @param padre Le pasamos el propio padre que lo crea para acceder forma fácil a métodos de este.     
     */
    public herramientaBrilloContraste(VentanaPrincipal padre) {
        initComponents();
                          
        nVecesNormal=nVecesIluminacion=nVecesOscurecimiento=0;
        
        
        //Creamos la referencia al padre
        this.padre=padre;
        
        //Ponemos el slider del brillo a 0
        textNivelBrillo.setText("0");
      
        
        //Sacamos la imagen del lienzo
        sacarImagen();
                      
        
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.out.println("Cerrando  ventana");
                recuperarImagen();
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
            this.imagenTemporalParaOperaciones=vis.getLienzo().getImage();
            
            imgTMP=this.deepCopy(imagenTemporalParaOperaciones);
            //this.imgTMP=vis.getLienzo().getImage();

        }else{
            //Mostramos el mensaje de error
            JOptionPane.showMessageDialog(this, "Debes seleccionar una imagen antes de usar esta herramienta.", "Error", JOptionPane.WARNING_MESSAGE);
            padre.ventanaHerramientaBrilloContraste.setVisible(false);
            padre.ventanaHerramientaBrilloContraste=null;
            //En otro caso no se puede trabajar y es necesario avisar de que es necesario tener una ventan seleccionada.
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
        textBrilloContraste = new javax.swing.JLabel();
        iconoBrilloContraste = new javax.swing.JLabel();
        exitButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        sliderBrillo = new javax.swing.JSlider();
        textoContraste = new javax.swing.JLabel();
        iconoContraste = new javax.swing.JLabel();
        iconoBrillo = new javax.swing.JLabel();
        textNivelBrillo = new javax.swing.JLabel();
        botonContrasteNormal = new javax.swing.JButton();
        botonContrasteIluminacion = new javax.swing.JButton();
        textContrasteNormal = new javax.swing.JLabel();
        textContrasteOscurecimiento = new javax.swing.JLabel();
        botonContrasteOscurecimiento = new javax.swing.JButton();
        textContrasteIluminacion = new javax.swing.JLabel();
        textoBrillo = new javax.swing.JLabel();

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

        textBrilloContraste.setFont(new java.awt.Font("Sawasdee", 1, 18)); // NOI18N
        textBrilloContraste.setForeground(new java.awt.Color(51, 51, 51));
        textBrilloContraste.setText("Brillo y Contraste");

        iconoBrilloContraste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/brilloContrasteMini.png"))); // NOI18N

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
                .addComponent(iconoBrilloContraste)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textBrilloContraste)
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
                    .addComponent(textBrilloContraste)
                    .addComponent(iconoBrilloContraste)))
            .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(panelNorte, java.awt.BorderLayout.PAGE_START);

        sliderBrillo.setMaximum(255);
        sliderBrillo.setMinimum(-255);
        sliderBrillo.setValue(0);
        sliderBrillo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderBrilloStateChanged(evt);
            }
        });

        textoContraste.setFont(new java.awt.Font("Sawasdee", 1, 14)); // NOI18N
        textoContraste.setText("Contraste:");

        iconoContraste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/contrasteMini.png"))); // NOI18N

        iconoBrillo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/brilloMini.png"))); // NOI18N

        textNivelBrillo.setFont(new java.awt.Font("Sawasdee", 0, 18)); // NOI18N
        textNivelBrillo.setText("0");

        botonContrasteNormal.setText("0");
        botonContrasteNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonContrasteNormalActionPerformed(evt);
            }
        });

        botonContrasteIluminacion.setText("0");
        botonContrasteIluminacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonContrasteIluminacionActionPerformed(evt);
            }
        });

        textContrasteNormal.setFont(new java.awt.Font("Sawasdee", 0, 14)); // NOI18N
        textContrasteNormal.setText("Normal");

        textContrasteOscurecimiento.setFont(new java.awt.Font("Sawasdee", 0, 14)); // NOI18N
        textContrasteOscurecimiento.setText("Oscurecimiento");
        textContrasteOscurecimiento.setToolTipText("");

        botonContrasteOscurecimiento.setText("0");
        botonContrasteOscurecimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonContrasteOscurecimientoActionPerformed(evt);
            }
        });

        textContrasteIluminacion.setFont(new java.awt.Font("Sawasdee", 0, 14)); // NOI18N
        textContrasteIluminacion.setText("Iluminación");

        textoBrillo.setFont(new java.awt.Font("Sawasdee", 1, 14)); // NOI18N
        textoBrillo.setText("Brillo:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(iconoContraste)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoContraste))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(botonContrasteNormal)
                        .addGap(18, 18, 18)
                        .addComponent(textContrasteNormal)
                        .addGap(24, 24, 24)
                        .addComponent(botonContrasteIluminacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textContrasteIluminacion)
                        .addGap(29, 29, 29)
                        .addComponent(botonContrasteOscurecimiento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textContrasteOscurecimiento))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(iconoBrillo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(sliderBrillo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(textNivelBrillo))
                            .addComponent(textoBrillo))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoBrillo)
                    .addComponent(iconoBrillo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sliderBrillo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNivelBrillo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoContraste)
                    .addComponent(iconoContraste))
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(botonContrasteNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textContrasteNormal)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textContrasteIluminacion)
                            .addComponent(botonContrasteIluminacion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textContrasteOscurecimiento)
                            .addComponent(botonContrasteOscurecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)))
                .addContainerGap())
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Función que responde ante un cambio de estado en el slider del brillo.
     * @param evt Evento capturado.
     */
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
           // imgTMP=rop.filter(imgTMP, null);
            vis.getLienzo().setImage(rop.filter(imgTMP, null));
            
            
            
            //Hacemos que se repinte para ver el resultado mientras movemos el slider
            vis.getLienzo().repaint();
        }
        
        
        
        
    }//GEN-LAST:event_sliderBrilloStateChanged
    /**
     * Función que programa la respuesta a evento presionar el botón de contraste normal.
     * @param evt Evento capturado.
     */
    private void botonContrasteNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonContrasteNormalActionPerformed
       
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
            
            //imgTMP=imagenTemporalParaOperaciones;
                                           
            //Aplico el filtro y guardo el resultado en el lienzo.            
            vis.getLienzo().setImage(lop.filter(imgTMP,imgTMP));
            
            /*
            Así será imgTMP la que sufra los cambios conservando siempre nosotros una copia de la original en imgTemportalParaOperaciones
            */
            
            vis.getLienzo().repaint();
        
        } catch(Exception e){
          System.err.println(e.getLocalizedMessage());
        }
        
        
        nVecesNormal++;
        botonContrasteNormal.setText(Integer.toString(nVecesNormal));
        sliderBrillo.setValue(0);
            textNivelBrillo.setText("0");

        
    }//GEN-LAST:event_botonContrasteNormalActionPerformed

    /**
     * Función que programa la respuesta a evento presionar el botón de contraste Iluminacion.
     * @param evt Evento capturado.
     */
    private void botonContrasteIluminacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonContrasteIluminacionActionPerformed
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
            //imgTMP=imagenTemporalParaOperaciones;
            
            //Aplico el filtro y guardo el resultado en el lienzo.
            
            vis.getLienzo().setImage(lop.filter(imgTMP,imgTMP));
            
            /*
            Así será imgTMP la que sufra los cambios conservando siempre nosotros una copia de la original.
            */
            
            vis.getLienzo().repaint();
        
        } catch(Exception e){
          System.err.println(e.getLocalizedMessage());
        }
        
        nVecesIluminacion++;
        botonContrasteIluminacion.setText(Integer.toString(nVecesIluminacion));
                sliderBrillo.setValue(0);
            textNivelBrillo.setText("0");
        
    }//GEN-LAST:event_botonContrasteIluminacionActionPerformed

    /**
     * Función que programa la respuesta a evento presionar el botón de contraste de oscurecimiento.
     * @param evt Evento capturado.
     */
    private void botonContrasteOscurecimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonContrasteOscurecimientoActionPerformed
         Imprimir("Aplicando contraste normal");
        
        try{
      
            int type = LookupTableProducer.TYPE_POWER;
            LookupTable lt = LookupTableProducer.createLookupTable(type);
            LookupOp lop = new LookupOp(lt, null);
           
          //  imgTMP=imagenTemporalParaOperaciones;
            
            //Aplico el filtro y guardo el resultado en el lienzo.
            
            vis.getLienzo().setImage(lop.filter(imgTMP,imgTMP));
            
 
            vis.getLienzo().repaint();
        
        } catch(Exception e){
          System.err.println(e.getLocalizedMessage());
        }
        
        nVecesOscurecimiento++;
        botonContrasteOscurecimiento.setText(Integer.toString(nVecesOscurecimiento));
        sliderBrillo.setValue(0);
            textNivelBrillo.setText("0");
    }//GEN-LAST:event_botonContrasteOscurecimientoActionPerformed

    /**
     * Función que recupera la imagen original y también el estado  de los botones.
     */
    public void recuperarImagen(){
            
            //Ajustamos los valores de las herramientas:
            sliderBrillo.setValue(0);
            textNivelBrillo.setText("0");
            nVecesIluminacion=nVecesNormal=nVecesOscurecimiento=0;
            botonContrasteIluminacion.setText("0");
            botonContrasteNormal.setText("0");
            botonContrasteOscurecimiento.setText("0");
            
            
            
            vis.getLienzo().setImage(this.imagenTemporalParaOperaciones);
            vis.getLienzo().repaint();
            
            //Volvemos a realizar la copia para que no guarde los cambios anteriores.
            imgTMP=this.deepCopy(imagenTemporalParaOperaciones);
            /*
            Recordamos que en java no se puede realizar la copia por valor con = si no se 
            trata de tipos primitivos.
            */
            
            
            
    }
    /**
     * Función que responde al evento producido por presionar el botón reset.
     * @param evt Evento capturado.
     */
    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
            //Llamamos a recuperar imagen para que (ya que estamos reiniciando) se carge la original.
            recuperarImagen();                    
    }//GEN-LAST:event_resetButtonActionPerformed

    /**
     * Funcion que responde al evento producido al presionar el botón exit.
     * @param evt Evento capturado.
     */
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        //Hace exactamente lo mismo que darle al boton cerrar de la esquina superior izquierda, es decir llamar a recuperarImagen.
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_exitButtonActionPerformed

    /**
     * Funcion que responde al evento producido al presionar el botón save.
     * @param evt Evento capturado.
     */
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        //Cerramos la ventana
        this.dispose();
    }//GEN-LAST:event_saveButtonActionPerformed

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
    private javax.swing.JButton botonContrasteIluminacion;
    private javax.swing.JButton botonContrasteNormal;
    private javax.swing.JButton botonContrasteOscurecimiento;
    private javax.swing.JButton exitButton;
    private javax.swing.ButtonGroup grupoBotonesMatriz;
    private javax.swing.ButtonGroup grupoBotonesTipo;
    private javax.swing.JLabel iconoBrillo;
    private javax.swing.JLabel iconoBrilloContraste;
    private javax.swing.JLabel iconoContraste;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel panelNorte;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JSlider sliderBrillo;
    private javax.swing.JLabel textBrilloContraste;
    private javax.swing.JLabel textContrasteIluminacion;
    private javax.swing.JLabel textContrasteNormal;
    private javax.swing.JLabel textContrasteOscurecimiento;
    private javax.swing.JLabel textNivelBrillo;
    private javax.swing.JLabel textoBrillo;
    private javax.swing.JLabel textoContraste;
    // End of variables declaration//GEN-END:variables
}
