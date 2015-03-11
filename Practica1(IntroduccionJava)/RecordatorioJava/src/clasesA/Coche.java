/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesA;

       
    public class Coche{
       
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