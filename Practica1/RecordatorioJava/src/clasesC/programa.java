/*
Para ejecutar el main de esta clase tenemos que hacer mayúsculas+F6 ya que por defecto para
NetBeans la clase que contiene el programa es la primera que se usó.

En este caso para usar cualquiera de las clases definidas en otros paquetes habría que importarlas, 
podemos importar la clase de un paquete o el paquete completo.

 */
package clasesC;
//Se importan todas las clases de paquete clasesA
import clasesA.*;
//Se importa sólo una clase:
import clasesB.Bicicleta;

/**
 *
 * @author juan
 */
public class programa {
    
    public static void main(String[] args){
        System.out.println("Ejecutando programa del paquete clasesC");
        
        Coche molon =  new Coche("captur");
        Moto molona = new Moto("electrica");
        Bicicleta economica = new Bicicleta("barata");
        
        Vehiculo dron = new Vehiculo();
        //pasadaDeCarro hereda de Vehículo por lo que tiene sus mismos métodos
        Todoterreno pasadaDeCarro = new Todoterreno("audi","p34");
        System.out.println(pasadaDeCarro.getModelo());
        
    }
    
}
