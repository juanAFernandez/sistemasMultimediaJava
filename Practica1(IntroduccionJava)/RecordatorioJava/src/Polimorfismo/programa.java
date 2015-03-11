
package Polimorfismo;

import java.util.ArrayList;

/*
Polimorfismo-> muchas formas. Podemos enviar mensajes iguales a objetos de tipos distintos.
*/

public class programa {
    public static void main(String arg[]){
        System.out.println("Programa para trabajar el polimorfismo");
        
        /*
        NO podremos instanciar un objeto de una clase abstracta, netBeans nos adevertirá que no podemos.
        SerVivo serVivo = new SerVivo();
        */
        
        Animal animalMediano = new Animal();
        Animal animalPequeño = new Animal("raton",2);
        Animal extraño = new Animal("gato",3,"Azul Ruso");
        
        
        
        /*
        La gracia del polimorfismo reside en que un objeto puede tomar varias formas. Podemos tener una colección de 
        seres vivos a lo que pasarle los mismos mensajes pero dependiendo de tipo de ser que sea se comportará de
        una forma u otra, es decir, tenemos objetos que tienen distintas formas.
        */
        
         ArrayList<SerVivo>seresVivos;
         seresVivos=new ArrayList<SerVivo>();
         
         /*
         Creamos cuatro objetos que son seresVivos pero que adpotan distintas formas
         */
         
         Animal animal1 = new Animal("perrete",2,"chihuahua");
         Animal animal2 = new Animal("gatete",3);
         Vegetal vegetal1 = new Vegetal("aloeVera",5);
         Vegetal vegetal2 = new Vegetal("pino",15);

         //Añadimos los seres a la colección
         seresVivos.add(animal1); seresVivos.add(animal2); seresVivos.add(vegetal1); seresVivos.add(vegetal2);
         

         for (SerVivo ser : seresVivos) {
             ser.reproducirse();
         }
         /*Los objetos ejecutan el métodos reproducirse de formas distintas.
         Con esto vemos que podemos enviar el mismo tipo de mensajes a obtenos distintos: polimorfismo
         El polimorfismo es un concepto un poco más avanzado que la herencia y puede ser muy util a la hora de 
         jerarquizar y querer dar un patrón de comportamiento común a una serie de objetos que heredan de la misma 
         clase*/
        
        
    }
}
