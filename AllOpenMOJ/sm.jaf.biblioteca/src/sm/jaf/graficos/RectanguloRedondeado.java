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
import java.awt.geom.RoundRectangle2D;
import sm.jaf.graficos.Relleno.Horientacion;

/**
 * Clase que implementa la figura RECTANGULO REDONDEADO.
 * Internamente usa un objeto de tipo RoundRectantle2D de Java2D abstrayendo su funcionamiento y especificando su
 * comportamiento. Esta figura puede contener relleno y por eso tiene dos variables para controlarlo,la unica diferencia
 * respecto al resctangulo normal es que esta tiene los bordes redondeados.
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/awt/geom/RoundRectangle2D.html">Clase RoundRectangle2D</a>
 * @author Juan A. Fernández Sánchez
 */
public class RectanguloRedondeado extends Figura{
    
    private boolean relleno;
    
    //public Paint rellenoComplejo;
    
    public Relleno miRelleno;
    
    private Point2D A;    
    private Ellipse2D elipsePuntoControlA;    
    boolean seleccionadoPuntoControlA;
    
    private Point2D B;  
    private Ellipse2D elipsePuntoControlB;    
    boolean seleccionadoPuntoControlB;

    
     /**
     * Primer constructor sin parámetros
     */
    public RectanguloRedondeado(){
        datosGeometricos=new RoundRectangle2D.Double();
        relleno = false;
    }
    /**
     * Segundo constructor con parámetros.
     * Adaptación del constructor al constructor de RoundREctangle2D
     * @param puntoA Extremo A del rectángulo.
     * @param puntoB Extremo B del rectángulo.
     */
    public RectanguloRedondeado(Point2D puntoA, Point2D puntoB){        
       // datosGeometricos=new RoundRectangle2D.Double(puntoA.getX(), puntoA.getY(), puntoB.getX(), puntoB.getY());  
        
     //   datosGeometricos=new RoundRectangle2D.Double();
        datosGeometricos=new RoundRectangle2D.Double(puntoA.getX(), puntoA.getY(), 10, 10, 20, 20);
        
        //((RoundRectangle2D)datosGeometricos).setFrameFromDiagonal(puntoA, puntoB);
        
        
        relleno = false;
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
    public Relleno getRellenoComplejo(){return miRelleno;}
    
    //Métodos de implementación específica de cada figura.
    
    /**
     * Para cambiar la posición de un rectángulo.
     * Implementa la funcionalidad particular propia.
     *
     * @param nuevoPuntoA
     * @param nuevoPuntoB 
     */
    @Override
    public void cambiarPosicion(Point2D nuevoPuntoA, Point2D nuevoPuntoB){
        A=nuevoPuntoA;
        B=nuevoPuntoB;
       // ((RoundRectangle2D)datosGeometricos).setFrameFromDiagonal(A, B);
        ((RoundRectangle2D)datosGeometricos).setRoundRect(A.getX(), A.getY(), B.getX()-A.getX(), B.getX()-A.getY(), 50, 50);        
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
           

           
           Double maxY=  ((RoundRectangle2D)datosGeometricos).getMaxY();
           
        //   Imprimir("maxY"+maxY);
           
           relleno = new GradientPaint(new Point2D.Double(0,0), miRelleno.getColorA(), new Point2D.Double(0,maxY), miRelleno.getColorB());
       }else if(miRelleno.getHorientacion()==Horientacion.HORIZONTAL){
           
           
       //    Imprimir("Configurando gradiente para horientacion HORIZONTAL");
            Double maxX=  ((RoundRectangle2D)datosGeometricos).getMaxX();
           
        //   Imprimir("maxx"+maxX);
           
            //Usamos de punto A el 0,0 y de be el maximo de x con 0 en y para conseguir la arista derecha del rectángulo.
            relleno = new GradientPaint(new Point2D.Double(0,0), miRelleno.getColorA(), new Point2D.Double(maxX,0), miRelleno.getColorB());
       
       }else if(miRelleno.getHorientacion()==Horientacion.DIAGONAL_A){ // TipoA:/
           Double maxY=  ((RoundRectangle2D)datosGeometricos).getMaxY();
           Double maxX=  ((RoundRectangle2D)datosGeometricos).getMaxX();
      //     Imprimir("maxY"+maxY);
      //     Imprimir("maxx"+maxX);
           relleno = new GradientPaint(new Point2D.Double(0,maxY), miRelleno.getColorA(), new Point2D.Double(maxX,0), miRelleno.getColorB());
       }else if(miRelleno.getHorientacion()==Horientacion.DIAGONAL_B){ //Tipo B: \
           Double maxY=  ((RoundRectangle2D)datosGeometricos).getMaxY();
           Double maxX=  ((RoundRectangle2D)datosGeometricos).getMaxX();
       //    Imprimir("maxY"+maxY);
       //    Imprimir("maxx"+maxX);
           relleno = new GradientPaint(new Point2D.Double(0,0), miRelleno.getColorA(), new Point2D.Double(maxX,maxY), miRelleno.getColorB());
       }
        
        
        return relleno;
    }
    
        
    /**
     * Cambia el modo de edición.
     * @param modo True para activarlo y false para desactivalrlo.
     */
    public void setModoEdicion(boolean modo){
        modoEdicion=modo;
    }
    
    
    @Override
     public void dibujateEn(Graphics2D g2d){
        
         Imprimir("Dibujando en");
         
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
        
        
        //Hacemos que se dibujen los datos geométricos.
        
        if(relleno){
            //Aplicamos el paint construido a partir de los datos del relleno.
            g2d.setPaint(getDatosRelleno());
            g2d.fill(datosGeometricos);
            
            
        }else        
            g2d.draw(datosGeometricos);
        
         if(modoEdicion){
           
           //Dibujamos uno de los extremos de la diagonal.
           Point2D extremoDiagonalA= new Point2D.Double(  ((RoundRectangle2D)datosGeometricos).getMinX(), ((RoundRectangle2D)datosGeometricos).getMinY());
           elipsePuntoControlA= new Ellipse2D.Double(extremoDiagonalA.getX()-5, extremoDiagonalA.getY()-5,10,10);
           g2d.draw(elipsePuntoControlA);
           
           //Dibujamos el otro extremo de la diagonal.
           Point2D extremoDiagonalB= new Point2D.Double(  ((RoundRectangle2D)datosGeometricos).getMaxX(), ((RoundRectangle2D)datosGeometricos).getMaxY());
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
                    ((RoundRectangle2D)datosGeometricos).setFrameFromDiagonal(A.getX(), A.getY(), B.getX(), B.getY());

                }
                if(seleccionadoPuntoControlB){
                    //Queremos modificar el extremo derecho de la figura.
                    B=npc;
                    ((RoundRectangle2D)datosGeometricos).setFrameFromDiagonal(A.getX(), A.getY(), B.getX(), B.getY());
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
                 ((RoundRectangle2D)datosGeometricos).setFrameFromDiagonal(A, B);     
                
              //  elipsePuntoControlA = new Ellipse2D.Double(A.getX()-5, A.getY()-5, 10, 10);
             //   elipsePuntoControlB = new Ellipse2D.Double(B.getX()-5, B.getY()-5, 10, 10);

            }
            moviendo=false;
            
            //Después de soltar el ratón el moviviento de la figura ha cesado y se resetean los valores de las distancias:
            distanciaX=distanciaY=0;
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
                 if(((RoundRectangle2D)datosGeometricos).contains(punto)){
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
        return "rectanguloRedondeado";
    }


    
}
