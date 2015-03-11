/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Polimorfismo;

/*
Si la clase es abstracta nunca podrá ser instanciada. Representa algo más abstracto
que debe ser definido por algún hijo.
 */
public abstract class SerVivo {
    
    protected String nombre;
    protected int edad;
    
    /*
    Pomedos no construir constructor, entonces podremos crear los objetos con el constructor vacío por defecto
    que Java nos crea, que básicamente no hace nada, pero si decidimos crear un constructor ya no podremos
    usar el constructor vacío al menos que no lo implementos explícitamente nosotros:
    
    public SerVivo(){};
    
    */
    
    public SerVivo(){};
    
    public SerVivo(String nombre, int edad){
        this.nombre=nombre;
        this.edad=edad;
    }
    
    public void comer(){System.out.println("Viajando");}
    public void respirar(){System.out.println("Respirando");}
    public String getNombre(){return this.nombre;}
    
    
    
    /*
    Si hacemos un método abstracto obligamos a que todos los hijos de esta clase implmenten este método, para 
    especializar el comportamiento que obligatoriamente debe de tener cualquier SerVivo pero que es
    específico de cada ser.
    */
    public abstract void reproducirse();
    
    
}
/*
Esta clase SerVivo puede adoptar muchas formas, por eso es polimórfica.
*/