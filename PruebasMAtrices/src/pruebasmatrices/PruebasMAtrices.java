/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasmatrices;

/**
 *
 * @author Juan A. Fernández Sánchez
 */
public class PruebasMAtrices {

    
     static public int recrPascal(int row, int col){
        int val1, val2, result = 0;
        if (row == 0 || col == 0 || row == col + 1)
        {
            return 1;
        }

        val1 = recrPascal(row - 1, col - 1);
        val2 = recrPascal(row - 1, col);

        return val1 + val2;
    }
     static public float[] PascalRecursion(int maxRows){
         
            float [] resultado = new float[maxRows];
        
            int i =maxRows;
        
            
                for (int j = 0; j < i; j++){               
                    resultado[j]=recrPascal(i,j);
                }
                
                
    //        for(int k=0; k<maxRows; k++)
    //            System.out.print(resultado[k]+" ");
                
            System.out.println();
        
        return resultado;
    }    
     static public float[] calcMatrizCruda(float []filaA, float []filaB){
         
         float [] resultado = new float[filaA.length*filaB.length];
         System.out.println("Creando matriz de "+resultado.length+" elementos.");
         
         int k=0;
         for(int i=0; i<filaA.length; i++)
             for(int j=0; j<filaB.length; j++){
                 resultado[k]=filaA[i]*filaB[j];
                 k++;
             }
         
      //   for(int i=0; i<k; i++)
      //       System.out.print(resultado[i]+" ");
         
         
         return resultado;
     }     
     static public float[] calculaMatriz(int rango){
         

         
        float [] resultado = calcMatrizCruda(PascalRecursion(rango),PascalRecursion(rango));
                
       // System.out.println("1/"+(int)Math.pow(4, rango-1));
        
        float factor=(float) (1/Math.pow(4, rango-1));
        
       // System.out.println("factor "+factor);
        /*
        int k=0; 
        for(int i=0; i<rango; i++){
            for(int j=0; j<rango; j++){
                System.out.print((int)resultado[k]+" ");
                k++;
            }
            System.out.println("");
        }
        */ 
        //El último paso que nos queda es multiplicar por el factor
        for(int i=0; i<rango*rango; i++)
            resultado[i]=resultado[i]*factor;
        
        
        return resultado;
     }
     
    public static void main(String[] args) {        
      //  float [] fila = PascalRecursion(3);
      //  float [] resultado = calcMatrizEmborronamiento(fila, fila);
        
        int rango =5;
        float [] resultado = calculaMatriz(rango);
        
          
        int k=0; 
        for(int i=0; i<rango; i++){
            for(int j=0; j<rango; j++){
                System.out.print(resultado[k]+" ");
                k++;
            }
            System.out.println("");
        }
        
    }
    
}
