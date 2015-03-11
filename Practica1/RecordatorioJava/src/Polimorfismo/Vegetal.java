
package Polimorfismo;

/*
Ya sólo con hacer "public class Vegetal extends SerVivo" netBeans nos advierte que
Vegental no está implementando el metodo abstracto reproducirse y nos obliga a hacerlo.
 */
public class Vegetal extends SerVivo{
    
    public Vegetal(String nombre, int edad){
        super(nombre, edad);
    }

    
    //Debemos implementar el método abstracto del padre para poder conforma esta clase:
    @Override
    public void reproducirse(){System.out.println("Me reproduzco por polinización");}

 
    
}
