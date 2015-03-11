
package Polimorfismo;


public class Animal extends SerVivo {
    
    
    private String especie;
    
    /*
    La implementación de los constructores en un hijo debe ser como mínimo como
    la del padre para que cubra las mismas características aunque también se pueden añadir más.
    */
    //Cubre el primer constructor del padre.
    public Animal(){
        super();
    }
    //CUbre el segundo constructor del padre.
    public Animal(String nombre, int edad){
        super(nombre, edad);
    }
    
    //Cubre la parte general del padre (construye un objeto de tipo Animal y lo especializa)
    public Animal(String nombre, int edad, String especie){
        super(nombre, edad);
        this.especie=especie;
    }
            
    
    @Override
    public void reproducirse(){System.out.println("Me reproduzco sexualmente");}
    
}
