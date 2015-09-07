/*
        This program is free software: you can redistribute it and/or modify
        it under the terms of the GNU General Public License as published by
        the Free Software Foundation, either version 3 of the License, or
        (at your option) any later version.
        This program is distributed in the hope that it will be useful,
        but WITHOUT ANY WARRANTY; without even the implied warranty of
        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
        GNU General Public License for more details.
        You should have received a copy of the GNU General Public License
        along with this program. If not, see <http://www.gnu.org/licenses/>.
      
        Copyright 2015 Juan A. Fernández Sánchez
*/
package sm.jaf.graficos;

import static extras.Imprimir.Imprimir;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import sm.jaf.graficos.Relleno.Horientacion;

/**
 * Clase que implementa la figura Elipse.
 * Basada en Ellipse2D, implementa la figura elipse, un circulo que no tiene por qué ser de radio constante,
 * que usa un par de puntos de control para permitir al usuario modificar su tamaño.
 * 
 * @see <a href="@see <a href="https://docs.oracle.com/javase/8/docs/api/java/awt/geom/Ellipse2D.html">Clase Ellipse2D</a>">Clase Ellipse2D</a>
 * @author Juan A. Fernández Sánchez
 */
public class Elipse extends Figura{

    private boolean relleno;
    
    public Relleno miRelleno;
    

        
    private Point2D A;          
    private Ellipse2D elipsePuntoControlA;    
    boolean seleccionadoPuntoControlA;
    
    private Point2D B;    
    private Ellipse2D elipsePuntoControlB;    
    boolean seleccionadoPuntoControlB;

    
    
    
    public Elipse(){
        datosGeometricos = new Ellipse2D.Double();
        relleno = false;
        modoEdicion=false;
        seleccionadoPuntoControlA=false;
        seleccionadoPuntoControlB=false;
        A = new Point2D.Double(); 
        B = new Point2D.Double();
    }
    public Elipse(Point2D puntoA, Point2D puntoB){
       datosGeometricos=new Ellipse2D.Double(puntoA.getX(), puntoA.getY(), puntoB.getX(), puntoB.getY()); 
       relleno=false;
    }
    
    public void setRelleno(boolean nuevoRelleno){
        relleno=nuevoRelleno;
    }
    public void setRelleno(Relleno nuevoRelleno){
        Imprimir("INtroduciendo nuevo relleno");
        miRelleno = nuevoRelleno;     
//        Imprimir(miRelleno.toString());
    }
    public boolean getRelleno(){
        return relleno;
    }
    
     public Paint getDatosRelleno(){
        
        /**
            * Configuración de puntos.
            * Para realizar el degradado correctamente no podemos escoger puntos de forma arbitraria. Tenemos
            * que conocer las dimensiones de la figura y configurar el detradado con estas. En el caso del rectángulo
            * tenemos que conseguir un punto de su arista superior y otro de su aristas inferior y con esos construiremos
            * el degradado vertical. Para conseguir esto nos ayudaremos de algunas funciones de las clases herederas de Shape.          
        */
        
        
        //Puntos temporales para creación del relleno de gradiente.
        Point2D tmpA, tmpB;
        
        
        //POR DEFECTO
       Paint relleno = new GradientPaint(new Point2D.Double(0,0), Color.BLACK, new Point2D.Double(100,100), Color.CYAN);

        /**
         * Proceso de construcción del objeto Paint que será el relleno de la figura.
         * Este depende del tamaño de la figura por eso se tienen que recalcular los puntos.
         */
        
        
       if(miRelleno.getHorientacion()==Horientacion.VERTICAL){
        //   Imprimir("Configurando gradiente para horientacion VERTICAL");
           

           
           Double maxY=  ((Ellipse2D)datosGeometricos).getMaxY();
           
        //   Imprimir("maxY"+maxY);
           
           relleno = new GradientPaint(new Point2D.Double(0,0), miRelleno.getColorA(), new Point2D.Double(0,maxY), miRelleno.getColorB());
       }else if(miRelleno.getHorientacion()==Horientacion.HORIZONTAL){
           
           
       //    Imprimir("Configurando gradiente para horientacion HORIZONTAL");
            Double maxX=  ((Ellipse2D)datosGeometricos).getMaxX();
           
        //   Imprimir("maxx"+maxX);
           
            //Usamos de punto A el 0,0 y de be el maximo de x con 0 en y para conseguir la arista derecha del rectángulo.
            relleno = new GradientPaint(new Point2D.Double(0,0), miRelleno.getColorA(), new Point2D.Double(maxX,0), miRelleno.getColorB());
       
       }else if(miRelleno.getHorientacion()==Horientacion.DIAGONAL_A){ // TipoA:/
           Double maxY=  ((Ellipse2D)datosGeometricos).getMaxY();
           Double maxX=  ((Ellipse2D)datosGeometricos).getMaxX();
      //     Imprimir("maxY"+maxY);
      //     Imprimir("maxx"+maxX);
           relleno = new GradientPaint(new Point2D.Double(0,maxY), miRelleno.getColorA(), new Point2D.Double(maxX,0), miRelleno.getColorB());
       }else if(miRelleno.getHorientacion()==Horientacion.DIAGONAL_B){ //Tipo B: \
           Double maxY=  ((Ellipse2D)datosGeometricos).getMaxY();
           Double maxX=  ((Ellipse2D)datosGeometricos).getMaxX();
       //    Imprimir("maxY"+maxY);
       //    Imprimir("maxx"+maxX);
           relleno = new GradientPaint(new Point2D.Double(0,0), miRelleno.getColorA(), new Point2D.Double(maxX,maxY), miRelleno.getColorB());
       }
        
        
        return relleno;
    }
    
    @Override
    public void dibujateEn(Graphics2D g2d) {
          
        //Establecemos el color
        g2d.setColor(trazo.getColor());
        

        //Aplicamos el stilo que acabos de definir
        g2d.setStroke(trazo.getStroke());
        
        
        
               
          AffineTransform move = new AffineTransform();
           move.translate(distanciaX,distanciaY); 
           
           AffineTransform cancelMove = new AffineTransform();
           cancelMove.translate(0,0); 

           if(moviendo){
            g2d.setTransform(move);     
           }
        
        
         if(relleno){
            g2d.setPaint(getDatosRelleno());
            g2d.fill(datosGeometricos);
            System.out.println("Dibujando con relleno");
         }else{        
            g2d.draw(datosGeometricos);
            System.out.println("Dibujando SIN relleno");
         }   
       
         
           //Si el modo edición está activado dibujamos también los puntos de control.
        if(modoEdicion){
           
           //Dibujamos uno de los extremos de la diagonal.
           Point2D extremoDiagonalA= new Point2D.Double(  ((Ellipse2D)datosGeometricos).getMinX(), ((Ellipse2D)datosGeometricos).getMinY());
           elipsePuntoControlA= new Ellipse2D.Double(extremoDiagonalA.getX()-5, extremoDiagonalA.getY()-5,10,10);
           g2d.draw(elipsePuntoControlA);
           
           //Dibujamos el otro extremo de la diagonal.
           Point2D extremoDiagonalB= new Point2D.Double(  ((Ellipse2D)datosGeometricos).getMaxX(), ((Ellipse2D)datosGeometricos).getMaxY());
           elipsePuntoControlB= new Ellipse2D.Double(extremoDiagonalB.getX()-5, extremoDiagonalB.getY()-5,10,10);
           g2d.draw(elipsePuntoControlB);
            
           
        }
         
         
           if(moviendo){
            g2d.setTransform(cancelMove);
        }
         
    }
    
    
     public void cambiarPuntosControl(Point2D puntoRef, Point2D npc){
         
         
         if(moviendo){
              //EL nuevo punto puede realizar cuantro movimientos básicos respecto al anterior.
            
            //Hacia la derecha
            if(npc.getX()>puntoRef.getX())
                distanciaX=npc.getX()-puntoRef.getX();
            //Hacia la izquierda
            if(npc.getX()<puntoRef.getX())
                distanciaX=npc.getX()-puntoRef.getX();
            
            //Hacia abajo
            if(npc.getY()>puntoRef.getY())
                distanciaY=npc.getY()-puntoRef.getY();
            //Hacia arriba
            if(npc.getY()<puntoRef.getY())
                distanciaY=npc.getY()-puntoRef.getY();
            
                                  
            Imprimir("DistanciaX: "+distanciaX+"distanciaY"+distanciaY);
         }else{
         
 
               if(seleccionadoPuntoControlA){
                    //Queremos modificar el extremo izquierdo de la figura.  
                    A=npc;
                    ((Ellipse2D)datosGeometricos).setFrameFromDiagonal(A.getX(), A.getY(), B.getX(), B.getY());

                }
                if(seleccionadoPuntoControlB){
                    //Queremos modificar el extremo derecho de la figura.
                    B=npc;
                    ((Ellipse2D)datosGeometricos).setFrameFromDiagonal(A.getX(), A.getY(), B.getX(), B.getY());
                }
         }
     
         
     
     }
 
       public void soltarRaton(Point2D ref, Point2D nuevo){
            Imprimir("Soltando el raton");
            
            if(moviendo){
                
                //Cambiamos los puntos: 
                A.setLocation(A.getX()+distanciaX, A.getY()+distanciaY);
                B.setLocation(B.getX()+distanciaX, B.getY()+distanciaY);
                
                //Modificamos la figura:
                 ((Ellipse2D)datosGeometricos).setFrameFromDiagonal(A, B);                  
                
              //  elipsePuntoControlA = new Ellipse2D.Double(A.getX()-5, A.getY()-5, 10, 10);
             //   elipsePuntoControlB = new Ellipse2D.Double(B.getX()-5, B.getY()-5, 10, 10);

            }
            moviendo=false;
            
            //Después de soltar el ratón el moviviento de la figura ha cesado y se resetean los valores de las distancias:
            distanciaX=distanciaY=0;
    }
    
    

    /**
     * Para cambiar las coordenadas de los datos geométricos de la figura.
     * Usandos dos puntos cambia el objeto a partir de la diagonal principal del mismo, que se modifica,
     * por eso sirve tanto para cambiarla de tamaño como para moverla por completo en el plano.
     * @param nuevoPuntoA Extremo de la diagonal
     * @param nuevoPuntoB Otro extremo de la diagonal
     */
    @Override
    public void cambiarPosicion(Point2D nuevoPuntoA, Point2D nuevoPuntoB) {
        A=nuevoPuntoA;
        B=nuevoPuntoB;
         ((Ellipse2D)datosGeometricos).setFrameFromDiagonal(nuevoPuntoA, nuevoPuntoB);
    }

    /**
     * Cambia el modo de edición.
     * @param modo True para activarlo y false para desactivalrlo.
     */
    public void setModoEdicion(boolean modo){
        modoEdicion=modo;
    }
     /**
      * Para conocer si un punto está dentro del rectángulo.
      * @param punto Punto a comprobar.
      * @return Si está o no dentro del rectángulo.
      */
     @Override
    public boolean contiene(Point2D punto){
        
        
        seleccionadoPuntoControlA=false;
        seleccionadoPuntoControlB=false;
        
        moviendo=false;
        
        //¿Se ha seleccionado uno de los  puntos de control?//
         if(elipsePuntoControlA.contains(punto)){
             Imprimir("## Punto A del rectangulo ##!");
             this.seleccionadoPuntoControlA=true;                
             return true;
         }                         
         else if(elipsePuntoControlB.contains(punto)){
             Imprimir("## Punto B del rectangulo ##!");
             this.seleccionadoPuntoControlB=true;                
             return true;
         }else{               
                 seleccionadoPuntoControlA=false;
                 seleccionadoPuntoControlB=false;  
                 
                 //Pero si se ha seleccionado otro punto de la figura que no sea un punto de control decimos true
                 if(((Ellipse2D)datosGeometricos).contains(punto)){
                     moviendo=true;
                     return true;
                 }
                 // pero si tampoco, false
                 else
                    return false;
         }
      
    }
    

    @Override
    public String toString() {
        return "elipse";
    }
    
}
