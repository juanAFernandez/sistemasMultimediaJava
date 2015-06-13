/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebafunciones;

/**
 *
 * @author juan
 */
public class PruebaFunciones {

    /**
     * @param args the command line arguments
     */
    
    
    
    
    
    static private boolean comprueba(String introducido, String original){

        /*Esta función comprueba que el verbo introducido corresponda con el original.
        Construimos esta función poque el verbo original puede ser que esté compuesto por dos partes,
        la forma para el singular y para el plural por eso si se da este caso tenemos que separar el contenido
        y comprobar que coincida con uno de los dos.
         */

        String descompuestoA="", descompuestoB="";


        if(original.contains("/")){ //Se trata de un verbo compuesto.
            
            //1º. Se descompone el verbo.
            
            int posBarra = original.indexOf("/");
            descompuestoA=original.substring(0, posBarra);
            System.out.println("PrimeraSeccion: "+descompuestoA);
            descompuestoB=original.substring(posBarra+1, original.length());
            System.out.println("SegundaSeccion: "+descompuestoB);
            
            
            //2º. Se comprueba con cada una de las formas
            
            if(introducido.equals(descompuestoA) || introducido.equals(descompuestoB))
                return true;
            else
                return false;
            
        }else{//No se trata de un verbo compuest
            if(introducido.equals(original))
                return true;
            else
                return false;
        }
        
    }
    
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(comprueba("awoke","awoke/awaked"));
        System.out.println(comprueba("awok","awoke/awaked"));
        System.out.println(comprueba("awaked","awoke/awaked"));
        System.out.println(comprueba("cut","cut"));
        System.out.println(comprueba("cut","cat"));
        
        
    }
    
}
