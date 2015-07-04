package extras;

public class Imprimir {
    
    //Cuando sea texto:
    public static void Imprimir(String texto){
        System.out.println(texto);
    }
    
    //Cuando sea un entero:
    public static void Imprimir(int numero){
        System.out.println(Integer.toString(numero));
    }
   
    //Cuando sea un decimal:
    public static void Imprimir(float numeroDecimal){
        System.out.println(Float.toString(numeroDecimal));
    }
   
}
