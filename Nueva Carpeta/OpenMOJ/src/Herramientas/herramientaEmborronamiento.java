package Herramientas;

import Programa.VentanaInterna;
import Programa.VentanaPrincipal;
import static extras.Imprimir.Imprimir;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import java.awt.image.RescaleOp;
import java.awt.image.WritableRaster;
import javax.swing.JOptionPane;
import sm.image.KernelProducer;
import sm.image.LookupTableProducer;

/**
 *
 * @author Juan A. Fernández Sánchez
 */
public final class herramientaEmborronamiento extends javax.swing.JFrame {

    
    private VentanaPrincipal padre;
    
    private VentanaInterna vis;
    
    private Kernel k;
    
    //Operación:
    private ConvolveOp cop;
    
    //Definición de las máscaras 
    public static float[] MASCARA3x3;
    public static float[] MASCARA5x5;
    public static float[] MASCARA7x7;
    public static float[] MASCARA9x9;
    
    private Kernel propio;
    
    
    //Las dos imagenes que gestionamos. Una copia de la original y el resultado de las operaciones.
    private BufferedImage imagenTemporalParaOperaciones;
    private BufferedImage imgTMP;
     
          
    
    public BufferedImage deepCopy(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }
     
    /**sl
     * Constructor    
     * @param padre //Le pasamos el propio padre que lo crea para acceder forma fácil a métodos de este.     
     */
    public herramientaEmborronamiento(VentanaPrincipal padre) {
        initComponents();
                                 
                
        //Creamos la referencia al padre
        this.padre=padre;
        
        //Sacamos la imagen del lienzo
        sacarImagen();
                         
        
        
        
        
        
        this.addWindowListener(new java.awt.event.WindowAdapter() {
    @Override
    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
        System.out.println("Cerrando putita ventana");
        recuperarImagen();
    }
});
        
    }

   
    private void cambiarTipo(){
        
        if(botonTipoMedio.isSelected()){
           
           //Dependiendo del tamaño seleccionado para la máscara creamos uno u otro kernel.
            
           Imprimir("Seleccionado tipo medio:");
            
           if(botonMascara3x3.isSelected()){
               Imprimir("Mascara de 3x3");
                //Máscara por defecto: tam 3x3 con un filtro tipo medio
               MASCARA3x3=new float[9];
               for(int i=0; i<9; i++) 
                   MASCARA3x3[i]=(float)1/9;
               k=new Kernel(3,3,MASCARA3x3);
           } else if(botonMascara5x5.isSelected()){
                Imprimir("Mascara de 5x5");
                //Máscara por defecto: tam 3x3 con un filtro tipo medio
               MASCARA5x5=new float[25];
               for(int i=0; i<25; i++) 
                   MASCARA5x5[i]=(float)1/25;
               k=new Kernel(5,5,MASCARA5x5);
            }else if(botonMascara7x7.isSelected()){
               Imprimir("Mascara de 7x7");
                //Máscara por defecto: tam 3x3 con un filtro tipo medio
               MASCARA7x7=new float[49];
               for(int i=0; i<49; i++) 
                   MASCARA7x7[i]=(float)1/49;
               k=new Kernel(7,7,MASCARA7x7);
            } else if(botonMascara9x9.isSelected()){
                MASCARA9x9=new float[81]; 
                for(int i=0; i<81; i++) 
                    MASCARA9x9[i]=(float)1/89;
                k=new Kernel(9,9,MASCARA9x9);
            }else{
                Imprimir("No se ha seleccionado tipo de matriz");
            }
                                              
        }else if(botonTipoBinomial.isSelected()){
            
             Imprimir("Seleccionado tipo binomial:");
            
             if(botonMascara3x3.isSelected()){
               Imprimir("Mascara de 3x3");
                
               MASCARA3x3=calculaMatrizBinomial(3);
               k=new Kernel(3,3,MASCARA3x3);
                       
           } else if(botonMascara5x5.isSelected()){
                Imprimir("Mascara de 5x5");
                MASCARA5x5=calculaMatrizBinomial(5);
                k=new Kernel(5,5,MASCARA5x5);

            }else if(botonMascara7x7.isSelected()){
               Imprimir("Mascara de 7x7");
               MASCARA7x7=calculaMatrizBinomial(7);
               k=new Kernel(7,7,MASCARA7x7);

            } else if(botonMascara9x9.isSelected()){
                MASCARA9x9=calculaMatrizBinomial(9);
               k=new Kernel(9,9,MASCARA9x9);

            }else{
                Imprimir("No se ha seleccionado tipo de matriz");
            }
            
            
        }else if(botonTipoGaussiano.isSelected()){
            JOptionPane.showMessageDialog(this, "Esta función aún no ha sido implementada.");
        }else{
             Imprimir("No se ha seleccionado tipo de emborronamiento.");
        }
        
        
      //Creación de la operación para aplicar con el kernel construido
           cop= new ConvolveOp(k,ConvolveOp.EDGE_NO_OP,null);  
      //Por ultimo se aplica
           aplicar();
           
            
    }

    /**
     * Con esta función reseteamos la herramienta y dejamos la imagen como estaba al principio.
     */
    private void resetHerramienta(){
        
        
        Imprimir("Reseteando imagen");
        //Enviamos la copia de la imagen que teníamos guadada deshaciendo cualquier operación anterior.
        vis.getLienzo().setImage(imagenTemporalParaOperaciones);
               
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
    
    private void aplicar(){
        
        Imprimir("Aplicando a la imagen");

        if(vis!=null){
            //Se aplica el filtro con la operación definida en la función cambiar tipo.
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
        panelNorte = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        exitButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        botonTipoMedio = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        botonTipoBinomial = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        botonTipoGaussiano = new javax.swing.JToggleButton();
        jLabel6 = new javax.swing.JLabel();
        botonMascara3x3 = new javax.swing.JToggleButton();
        botonMascara7x7 = new javax.swing.JToggleButton();
        botonMascara5x5 = new javax.swing.JToggleButton();
        botonMascara9x9 = new javax.swing.JToggleButton();
        jLabel8 = new javax.swing.JLabel();

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
        jLabel1.setText("Emborronamiento");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/emborronamiento.png"))); // NOI18N

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
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelNorteLayout.setVerticalGroup(
            panelNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(panelNorteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)))
        );

        getContentPane().add(panelNorte, java.awt.BorderLayout.PAGE_START);

        jLabel2.setText("Tipo:");

        grupoBotonesTipo.add(botonTipoMedio);
        botonTipoMedio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/average.png"))); // NOI18N
        botonTipoMedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTipoMedioActionPerformed(evt);
            }
        });

        jLabel4.setText("Medio");

        grupoBotonesTipo.add(botonTipoBinomial);
        botonTipoBinomial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/binomial.png"))); // NOI18N
        botonTipoBinomial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTipoBinomialActionPerformed(evt);
            }
        });

        jLabel5.setText("Binomial");

        grupoBotonesTipo.add(botonTipoGaussiano);
        botonTipoGaussiano.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/gaussian.png"))); // NOI18N
        botonTipoGaussiano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTipoGaussianoActionPerformed(evt);
            }
        });

        jLabel6.setText("Gaussiano");

        grupoBotonesMatriz.add(botonMascara3x3);
        botonMascara3x3.setSelected(true);
        botonMascara3x3.setText("3x3");
        botonMascara3x3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMascara3x3ActionPerformed(evt);
            }
        });

        grupoBotonesMatriz.add(botonMascara7x7);
        botonMascara7x7.setText("7x7");
        botonMascara7x7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMascara7x7ActionPerformed(evt);
            }
        });

        grupoBotonesMatriz.add(botonMascara5x5);
        botonMascara5x5.setText("5x5");
        botonMascara5x5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMascara5x5ActionPerformed(evt);
            }
        });

        grupoBotonesMatriz.add(botonMascara9x9);
        botonMascara9x9.setText("9x9");
        botonMascara9x9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMascara9x9ActionPerformed(evt);
            }
        });

        jLabel8.setText("Mascara:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(botonMascara3x3)
                        .addGap(43, 43, 43)
                        .addComponent(botonMascara5x5)
                        .addGap(44, 44, 44)
                        .addComponent(botonMascara7x7)
                        .addGap(38, 38, 38)
                        .addComponent(botonMascara9x9))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(botonTipoMedio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(botonTipoBinomial, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addGap(21, 21, 21)
                        .addComponent(botonTipoGaussiano, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(26, 26, 26)
                                    .addComponent(jLabel4))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel5)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)))
                        .addGap(10, 10, 10))
                    .addComponent(botonTipoMedio)
                    .addComponent(botonTipoGaussiano)
                    .addComponent(botonTipoBinomial))
                .addGap(21, 21, 21)
                .addComponent(jLabel8)
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonMascara3x3)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonMascara5x5)
                        .addComponent(botonMascara7x7)
                        .addComponent(botonMascara9x9)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Función que recupera la imagen original y también el estado  de los botones
     */
    public void recuperarImagen(){
            
        //Ajustamos los valores de las herramientas:

            
            
            vis.getLienzo().setImage(this.imagenTemporalParaOperaciones);
            vis.getLienzo().repaint();
            
            //Volvemos a realizar la copia para que no guarde los cambios anteriores.
            imgTMP=this.deepCopy(imagenTemporalParaOperaciones);
            /*
            Recordamos que en java no se puede realizar la copia por valor con = si no se 
            trata de tipos primitivos.
            */
            
            
            //Tambien volvemos al estado original los botones:
            recuperarEstado();
    }
    public void recuperarEstado(){
        if(botonTipoMedio.isSelected())
            botonTipoMedio.setSelected(false);
        if(botonTipoBinomial.isSelected())
            botonTipoBinomial.setSelected(false);
        if(botonTipoGaussiano.isSelected())
            botonTipoGaussiano.setSelected(false);
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

    private void botonMascara3x3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMascara3x3ActionPerformed
        cambiarTipo();
    }//GEN-LAST:event_botonMascara3x3ActionPerformed

    private void botonMascara7x7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMascara7x7ActionPerformed
        cambiarTipo();
    }//GEN-LAST:event_botonMascara7x7ActionPerformed

    private void botonMascara5x5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMascara5x5ActionPerformed
        cambiarTipo();
    }//GEN-LAST:event_botonMascara5x5ActionPerformed

    private void botonMascara9x9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMascara9x9ActionPerformed
        cambiarTipo();
    }//GEN-LAST:event_botonMascara9x9ActionPerformed

    private void botonTipoMedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTipoMedioActionPerformed
        Imprimir("Seleccionado botón TIPO MEDIO ");
        cambiarTipo();
    }//GEN-LAST:event_botonTipoMedioActionPerformed

    private void botonTipoBinomialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTipoBinomialActionPerformed
        Imprimir("Seleccionado botón TIPO BINOMIAL ");
        cambiarTipo();
    }//GEN-LAST:event_botonTipoBinomialActionPerformed

    private void botonTipoGaussianoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTipoGaussianoActionPerformed
        Imprimir("Seleccionado botón TIPO GAUSSIANO ");
        cambiarTipo();
    }//GEN-LAST:event_botonTipoGaussianoActionPerformed

     static public int recrPascal(int row, int col){
        int val1, val2, result = 0;
        if (row == 0 || col == 0 || row == col + 1)
        {
            return 1;
        }

        val1 = recrPascal(row - 1, col - 1);
        val2 = recrPascal(row - 1, col);

        return val1 + val2;
    }
     static public float[] PascalRecursion(int maxRows){
         
            float [] resultado = new float[maxRows];
        
            int i =maxRows;
        
            
                for (int j = 0; j < i; j++){               
                    resultado[j]=recrPascal(i,j);
                }
                
                
    //        for(int k=0; k<maxRows; k++)
    //            System.out.print(resultado[k]+" ");
                
            System.out.println();
        
        return resultado;
    }    
     static public float[] calcMatrizCruda(float []filaA, float []filaB){
         
         float [] resultado = new float[filaA.length*filaB.length];
         System.out.println("Creando matriz de "+resultado.length+" elementos.");
         
         int k=0;
         for(int i=0; i<filaA.length; i++)
             for(int j=0; j<filaB.length; j++){
                 resultado[k]=filaA[i]*filaB[j];
                 k++;
             }
         
      //   for(int i=0; i<k; i++)
      //       System.out.print(resultado[i]+" ");
         
         
         return resultado;
     }     
     static public float[] calculaMatrizBinomial(int rango){
         

         
        float [] resultado = calcMatrizCruda(PascalRecursion(rango),PascalRecursion(rango));
                
       // System.out.println("1/"+(int)Math.pow(4, rango-1));
        
        float factor=(float) (1/Math.pow(4, rango-1));
        
       // System.out.println("factor "+factor);
        /*
        int k=0; 
        for(int i=0; i<rango; i++){
            for(int j=0; j<rango; j++){
                System.out.print((int)resultado[k]+" ");
                k++;
            }
            System.out.println("");
        }
        */ 
        //El último paso que nos queda es multiplicar por el factor
        for(int i=0; i<rango*rango; i++)
            resultado[i]=resultado[i]*factor;
        
        
        return resultado;
     }
     
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton botonMascara3x3;
    private javax.swing.JToggleButton botonMascara5x5;
    private javax.swing.JToggleButton botonMascara7x7;
    private javax.swing.JToggleButton botonMascara9x9;
    private javax.swing.JToggleButton botonTipoBinomial;
    private javax.swing.JToggleButton botonTipoGaussiano;
    private javax.swing.JToggleButton botonTipoMedio;
    private javax.swing.JButton exitButton;
    private javax.swing.ButtonGroup grupoBotonesMatriz;
    private javax.swing.ButtonGroup grupoBotonesTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel panelNorte;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
