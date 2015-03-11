 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

/**
 *
 * @author juan
 */
public class Practica2 {

    //Nos hemos traido el main de VentanaPRincipal.java
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
        que para este proyecto es la principal.
        */
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            //El run está asociado a que se ejecute en una hebra.
            public void run() {
                //Sólo con esto funcionaría pero se mete dentro de este Runnable para que se ejecute en un entorno de hebras.
                new VentanaPrincipal().setVisible(true);
            }
            //Este méotod no lo vamos a tocar en los cuatro meses excepto que queramos hacer algo muy concreto que sea global
            //a la aplicación.
        });
    }
    
}
