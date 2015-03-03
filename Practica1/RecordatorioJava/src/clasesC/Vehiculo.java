
package clasesC;


public class Vehiculo {
    
    private String marca;
    private String modelo;
    private int precio;
    
    //Constructor vacío:
    public Vehiculo(){}
    
    //Para construir conociendo la marca:
    public Vehiculo(String marca){this.marca=marca;}
    
    //Para construir conociendo marca y modelo:
    public Vehiculo(String marca, String modelo){this.marca=marca; this.modelo=modelo;}

    //Métodos get y set para variables privadas (para protegerlas más):
    public void setMarca(String marca){this.marca=marca;}
    public String getMarca(){return marca;}
    public void setModelo(String modelo){this.modelo=modelo;}
    public String getModelo(){return modelo;}
    public void setPrecio(int precio){this.precio=precio;}
    public int getPrecio(){return precio;}
    
    
}