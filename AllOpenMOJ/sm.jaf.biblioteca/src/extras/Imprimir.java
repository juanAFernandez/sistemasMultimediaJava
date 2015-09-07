package extras;


/**
 * Pequeña utilidad que evita el uso del System.out.println
 * @author Juan A. Fernández Sánchez
 */
public class Imprimir {
        
    /**
     * Imprime un String.
     * @param texto String a imprimir.
     */
        public static void Imprimir(String texto){
        System.out.println(texto);
    }
    
    /**
     * Imprimie un entero.
     * @param numero int a imprimir.
     */
    public static void Imprimir(int numero){
        System.out.println(Integer.toString(numero));
    }
   
    
    /**
     * Imprime un decimal.
     * @param numeroDecimal  float a imprimir.
     */
    public static void Imprimir(float numeroDecimal){
        System.out.println(Float.toString(numeroDecimal));
    }
   
}
