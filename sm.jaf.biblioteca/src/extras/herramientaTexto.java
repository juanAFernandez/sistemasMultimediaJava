package extras;

import static extras.Imprimir.Imprimir;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.geom.Point2D;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JColorChooser;
import sm.jaf.graficos.Texto;
import sm.jaf.iu.Lienzo2D;

/**
 *
 * @author Juan A. Fernández Sánchez
 */
public final class herramientaTexto extends javax.swing.JFrame {

    
    /**
     * Variable de referencia al padre de esta ventana.
     */
    private Lienzo2D padre;
    
    /**
     * Punto de escritura exacto en el lienzo padre.
     */
    private Point2D puntoEscritura;


    /**
     * Vector de fuentes del sistema.
     */     
    private String[] fuentesSistema;
    
    
    /**
     * Variable texto temporal.    
     */
    private Texto texto;
    
    /**
     * Texto contenido dentro del campo de texto al inicio.
     */
    String textoInicio;
    
    
    /**
     * Constructor    
     * @param padre //Le pasamos el propio padre que lo crea para acceder forma fácil a métodos de este.     
     * @param puntoLienzo     
     */
    public herramientaTexto(Lienzo2D padre, Point2D puntoLienzo) {
        initComponents();
     
       
        
        //Cargamos las fuentes del sistema:
        GraphicsEnvironment ge;
        ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        fuentesSistema = ge.getAvailableFontFamilyNames();
        
        //Las pasamos al comboBoxFuentesSistema:
        comboBoxFuentesSistema.setModel(new DefaultComboBoxModel(fuentesSistema));
                
        
        
        //Creamos la referencia al padre.
        this.padre=padre;
        
        //Referenciamos al punto exacto donde se marcó en el lienzo el padre.
        puntoEscritura=puntoLienzo;
      
        
        //Seteamos el grosor en la herramienta por defecto:
        spinnerGrosor.setValue(40);
        //El texto de la caja de texto:
        textoInicio="Escriba aquí!";
         //EL botón de selección de color a negro:
        buttonColor.setBackground(Color.BLACK);
        
        
        //Seteamos el texto por defecto:

        texto = new Texto();
        
        texto.setGrosor((int)spinnerGrosor.getValue());
        texto.setColor(buttonColor.getBackground());
        texto.setPosicion(puntoEscritura);
        texto.setFuente("Arial");
        texto.setText(textoInicio);
        texto.setNetrita(false);
        texto.setCursiva(false);
        
        
        padre.setTexto(texto);
        
        
        
        
        
        this.addWindowListener(new java.awt.event.WindowAdapter() {
    @Override
    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
        System.out.println("Cerrando  ventana");

    }
});
        
    }

    /**
     * Segundo constructored la clase usado cuando se edita un texto que ya ha sido creado.    
     * @param padre
     * @param textoAModificar 
     */
    public herramientaTexto(Lienzo2D padre, Texto textoAModificar){
        
        Imprimir("CONSTRUCTOR 2: "+textoAModificar.getText());
        
        //Inicializamos los componentes gráficos de la herramienta.
        initComponents();
        
        //Cargamos las fuentes del sistema:
        GraphicsEnvironment ge;
        ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        fuentesSistema = ge.getAvailableFontFamilyNames();
        
        //Las pasamos al comboBoxFuentesSistema:
        comboBoxFuentesSistema.setModel(new DefaultComboBoxModel(fuentesSistema));
                
        //Hacemos que se cargue la fuente que se está usando en el combo box.
        
       // comboBoxFuentesSistema.
        //String fuente=(String)comboBoxFuentesSistema.getSelectedItem();
       // comboBoxFuentesSistema.setSelectedItem(textoAModificar.getFuente());
    //    comboBoxFuentesSistema.getModel().setSelectedItem(textoAModificar.getFuente());
       // comboBoxFuentesSistema.setSelectedIndex(2);
        
        //Creamos la referencia al padre.
        this.padre=padre;
        
        //Creamos la referencia al padre.
        this.padre=padre;
        //Inicializamos nuestra variable privada
        texto = new Texto();
        
        texto=textoAModificar;
        
        //Introducimos en el campo de texto el string del texto que nos viene por el constructor.
        campoTexto.setText(texto.getText());
        
        //Modificamos el spinner del tamaño del texto al tamaño que tenga el que nos pasan:
        spinnerGrosor.setValue(texto.getGrosor());
        
        //Ajustamos el color del botón "cambio de color" al color del texto que vamos a editar:
        buttonColor.setBackground(textoAModificar.getColor());
        
        //Ajustamos el botón de negrita según esté o no el texto en negrita.
        if(textoAModificar.getNegrita())
            toggleButtonNegrita.setSelected(true);
        else
            toggleButtonNegrita.setSelected(false);
        
        
        //Ajustamos el botón de cursiva según esté o no el texto en cursiva.
        if(textoAModificar.getCursiva())
            toggleButtonCursiva.setSelected(true);
        else
            toggleButtonCursiva.setSelected(false);
        
        
        //Ajustamos el botón de subrayado según o no esté el texto que nos pasan.
        if(textoAModificar.getSubrayado())
            toggleButtonSubrayado.setSelected(true);
        else
            toggleButtonSubrayado.setSelected(false);
        
        
        //Ajustamos el botón de tachado según o no esté el texto que nos pasan.
        if(textoAModificar.getTachado())
            toggleButtonTachado.setSelected(true);
        else
            toggleButtonTachado.setSelected(false);
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel4 = new javax.swing.JPanel();
        labelFuente = new javax.swing.JLabel();
        comboBoxFuentesSistema = new javax.swing.JComboBox();
        labelGrosor = new javax.swing.JLabel();
        spinnerGrosor = new javax.swing.JSpinner();
        campoTexto = new javax.swing.JTextField();
        labelColor = new javax.swing.JLabel();
        buttonColor = new javax.swing.JButton();
        toggleButtonNegrita = new javax.swing.JToggleButton();
        toggleButtonCursiva = new javax.swing.JToggleButton();
        toggleButtonSubrayado = new javax.swing.JToggleButton();
        toggleButtonTachado = new javax.swing.JToggleButton();

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
        setTitle("Edición de texto");
        setAlwaysOnTop(true);

        labelFuente.setText("Fuente");

        comboBoxFuentesSistema.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxFuentesSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxFuentesSistemaActionPerformed(evt);
            }
        });

        labelGrosor.setText("Grosor");

        spinnerGrosor.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerGrosorStateChanged(evt);
            }
        });

        campoTexto.setText("Escriba aqui");
        campoTexto.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                campoTextoCaretUpdate(evt);
            }
        });
        campoTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoActionPerformed(evt);
            }
        });

        labelColor.setText("Color");

        buttonColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonColorActionPerformed(evt);
            }
        });

        toggleButtonNegrita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/extras/bold.png"))); // NOI18N
        toggleButtonNegrita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleButtonNegritaActionPerformed(evt);
            }
        });

        toggleButtonCursiva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/extras/italic.png"))); // NOI18N
        toggleButtonCursiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleButtonCursivaActionPerformed(evt);
            }
        });

        toggleButtonSubrayado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/extras/underline.png"))); // NOI18N
        toggleButtonSubrayado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleButtonSubrayadoActionPerformed(evt);
            }
        });

        toggleButtonTachado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/extras/strikethrough.png"))); // NOI18N
        toggleButtonTachado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleButtonTachadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoTexto)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(labelFuente)
                        .addGap(18, 18, 18)
                        .addComponent(comboBoxFuentesSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelGrosor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnerGrosor, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelColor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonColor)
                        .addGap(18, 18, 18)
                        .addComponent(toggleButtonNegrita, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toggleButtonCursiva, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toggleButtonSubrayado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toggleButtonTachado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(16, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonColor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelFuente)
                        .addComponent(comboBoxFuentesSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelGrosor)
                        .addComponent(spinnerGrosor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelColor))
                    .addComponent(toggleButtonCursiva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toggleButtonNegrita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toggleButtonTachado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toggleButtonSubrayado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(campoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void spinnerGrosorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerGrosorStateChanged
        Imprimir("Cambiand estado spinner: "+spinnerGrosor.getValue().toString());
        if((int)spinnerGrosor.getValue()==0)
            spinnerGrosor.setValue(1);
            
        //Sacamos el texto del padre y le cambiamos el grosor:
        if(!padre.isEmptyTextos()){
            padre.getText(padre.getTextoSeleccionado()).setGrosor((int)spinnerGrosor.getValue());
            padre.repaint();
        }
        
        
    }//GEN-LAST:event_spinnerGrosorStateChanged

    private void campoTextoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_campoTextoCaretUpdate
      Imprimir("Contendio del campo de texto: "+campoTexto.getText());
      textoInicio=campoTexto.getText();
       if(!padre.isEmptyTextos()){
            padre.getText(padre.getTextoSeleccionado()).setText(textoInicio);
            padre.repaint();
        }
    }//GEN-LAST:event_campoTextoCaretUpdate

    private void comboBoxFuentesSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxFuentesSistemaActionPerformed
        String fuente=(String)comboBoxFuentesSistema.getSelectedItem();
        if(!padre.isEmptyTextos()){
            padre.getText(padre.getTextoSeleccionado()).setFuente(fuente);
            padre.repaint();
        }
       
    }//GEN-LAST:event_comboBoxFuentesSistemaActionPerformed

    private void buttonColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonColorActionPerformed
        JColorChooser ventanaDeColores=new JColorChooser();
        Color color=ventanaDeColores.showDialog(null, "Seleccione un Color", Color.BLACK);
        buttonColor.setBackground(color);
        if(!padre.isEmptyTextos()){
            padre.getText(padre.getTextoSeleccionado()).setColor(buttonColor.getBackground());
            padre.repaint();
        }
    }//GEN-LAST:event_buttonColorActionPerformed

    private void toggleButtonNegritaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleButtonNegritaActionPerformed
        //Sacamos el texto del padre y le cambiamos el valor negrita

        
        if(!padre.isEmptyTextos()){    
            
            if(toggleButtonNegrita.isSelected())
                padre.getText(padre.getTextoSeleccionado()).setNetrita(true);
            else
                padre.getText(padre.getTextoSeleccionado()).setNetrita(false);
            
            padre.repaint();
        }
    }//GEN-LAST:event_toggleButtonNegritaActionPerformed

    private void toggleButtonCursivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleButtonCursivaActionPerformed
        //Sacamos el texto del padre y le cambiamos el valor cursiva
        if(!padre.isEmptyTextos()){
             if(toggleButtonCursiva.isSelected())
                padre.getText(padre.getTextoSeleccionado()).setCursiva(true);
            else
                padre.getText(padre.getTextoSeleccionado()).setCursiva(false);
            padre.repaint();
        }
    }//GEN-LAST:event_toggleButtonCursivaActionPerformed

    private void toggleButtonSubrayadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleButtonSubrayadoActionPerformed
        //Sacamos el texto del padre y le cambiamos el valor cursiva
        if(!padre.isEmptyTextos()){
             if(toggleButtonSubrayado.isSelected())
                padre.getText(padre.getTextoSeleccionado()).setSubrayado(true);
            else
                padre.getText(padre.getTextoSeleccionado()).setSubrayado(false);
            padre.repaint();
        }
    }//GEN-LAST:event_toggleButtonSubrayadoActionPerformed

    private void toggleButtonTachadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleButtonTachadoActionPerformed
        //Sacamos el texto del padre y le cambiamos el valor cursiva
        if(!padre.isEmptyTextos()){
             if(toggleButtonTachado.isSelected())
                padre.getText(padre.getTextoSeleccionado()).setTachado(true);
            else
                padre.getText(padre.getTextoSeleccionado()).setTachado(false);
            padre.repaint();
        }
    }//GEN-LAST:event_toggleButtonTachadoActionPerformed

    private void campoTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTextoActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonColor;
    private javax.swing.JTextField campoTexto;
    private javax.swing.JComboBox comboBoxFuentesSistema;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel labelColor;
    private javax.swing.JLabel labelFuente;
    private javax.swing.JLabel labelGrosor;
    private javax.swing.JSpinner spinnerGrosor;
    private javax.swing.JToggleButton toggleButtonCursiva;
    private javax.swing.JToggleButton toggleButtonNegrita;
    private javax.swing.JToggleButton toggleButtonSubrayado;
    private javax.swing.JToggleButton toggleButtonTachado;
    // End of variables declaration//GEN-END:variables
}
