package practica2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juan
 */

//Java siempre pone el apellido delando del paquete que viene, javax.swing.JFrame,
//con esto se ahorra tener que añadir los paquetes con import.
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     * El constructor de la ventana princiapal llama a un método declarado más abajo: initComponets(), 
     * hablaremos de el.
     */
    public VentanaPrincipal() {
        initComponents();
        /*
        Cuando nos vamos a la sección de diseño podemos añadir botones, menús, etc...
        cada vez que incorporo algo implica que se está generando código. initcomponets() tiene el código
        que se está generando al hacer ese diseño. Por eso debemos de fijarnos siempre en initComponets para ver
        que hace netBeans (que código añade siguiendo nuestro diseño)
        Esto no es algo que yo haya escrito sino que se ha generado sólo y por eso está prohibido tocarle y netBeans
        lo tiene protegido, esto es una faena porque a veces queremos editar cosas y no queda más remedio que
        coger un editor externo.
        */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments.
     * Tamibén nos genera un método main. Esto es raro porque tenemos dos main dentro
     * del mismo proyecto. Si ejecutamos se ejecuta el otro main porque en propiedades del proyecto
     * la clase principal está establecida Practica2.java. Pero nosotros queremos que se abra la ventana al ejecutar,
     * para eso tenemos el código implementado por netBeans dentro de este main.
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        /*
        Tenemos dos opciones, o borrar el de la clase principal y decirle al proyecto que esta es la clase principal
        o borrar el código de aquí y llevárselo a la apliación principal. Esta segunda es la reocomendable porque
        se recomienda tener una clase principal que represente al programa.
        Entonces lo que vamos a hacer es cortar de aquí y llevarnos el código al main de la clase Practica2.java
        que para este proyecto es la principal. Lo vamos a dejar, pero todo el método lo borraríamos.
        */
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
