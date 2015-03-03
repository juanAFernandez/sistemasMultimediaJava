
package clasesA;
import clasesB.Bicicleta;

//En java TODO son objetos, incluso el propio programa es un objeto que sólo se instancia una vez.
public class RecordatorioJava {


    /*Una clase puede declararse dentro del mismo .java donde escribimos el programa principal o fuera y usarla
    desde fuera. Si se declara aquí dentro, dentro de un objeto debe de anteponerse el modificador de visibilidad static
    para que puedan ser instanciados objetos desde esta propia clase. Si la clase se define fuera como moto no es necesario
    static public class Coche{
       
        //Atributo privado:
        private int kilometros;
        private String marca;
        
        
        public Coche(String marca){
            this.marca=marca;            
        }
        
        public int getKilometros(){
            return kilometros;
        }
        public String getMarca(){
            return marca;
        }
        
        public void encender(){
            System.out.println("Arrancando");
        }
        
        public void apagar(){
            System.out.println("Apagando");
        }
    }
    */
    
    public static void main(String[] args) {
        
        /*Para hacer uso de objetos de las clases no es necesario hacer ningún import ya que la implementación
        se encuentra dentro del mismo paquete clasesA y no es necesario hacer nada más.*/
        
        //Creamos una variable de tipo Coche
        Coche citroen = new Coche("citroen");
        //Llamo a uno de sus métodos:
        System.out.println("Marca: "+citroen.getMarca());
        
        //Hacemos lo mismo con moto
        Moto yamaha = new Moto("yamaha");
        System.out.println("Marca: "+yamaha.getMarca());
     
        
        /*La clase Bicicleta está implementada en otro paquete, por tanto hay que importar el paquete para poder usarla.
        Esto lo hemos hecho al principio con import clasesB.Bicicleta
        */
        Bicicleta orbea = new Bicicleta("Orbea");
        
    }
    
}
