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
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * Clase que implementa la figura LINEA.
 * Utiliza internamente un objeto de tipo Line2D de la Java2D para los datos geometricos. En esta figura
 * los propios puntos de control son los extremos de la linea.
 * @see <a href="http://docs.oracle.com/javase/7/docs/api/java/awt/geom/Line2D.html">Clase Line2D</a> 
 * @author Juan A. Fernández Sánchez
 */
public class Linea extends Figura {
              
    
    /**
     * Puntos que definen los extremos del segmento de linea.
     */
    private Point2D A; 
    private Point2D B;
    
    /**
     * Variables para el control de primer punto de edicion, que es uno de los extremos de la linea.
     */
    private Ellipse2D elipsePuntoControlA;    
    private boolean seleccionadoPuntoControlA;
    
    /**
     * Variables para el control de primer punto de edicion, que es otro de los extremos de la linea.
     */
    private Ellipse2D elipsePuntoControlB;    
    private boolean seleccionadoPuntoControlB;
    
    /**
     * Para el control de la edición de la figura.
     */
    private boolean modoEdicion;
    
    /**
     * Para el control de movimiento de la figura.
     */
    private boolean moviendo;
    
    /**
     * Variables para el control del movimiento de la figura.
     */
    private double distanciaX;
    private double distanciaY;
    
    
    
    /**
     * Primer constructor sin parámetros.
     * Sólo inicializa los datos geométricos con una Line2D de la Java2D.
     */
    public Linea(){
        A = new Point2D.Double();
        B = new Point2D.Double();
        datosGeometricos=new Line2D.Double();
        distanciaX=0;
        distanciaY=0;
        modoEdicion=false;
        moviendo=false;
        seleccionadoPuntoControlA=false;
        seleccionadoPuntoControlB=false;
    }
    
    /**
     * Segundo constructor con parámetros.
     * Usa otro de los constructuros de Line2D
     * @param puntoA Primer punto de la linea.
     * @param puntoB Segundo punto de la linea.
     */
    public Linea(Point2D puntoA, Point2D puntoB){
        datosGeometricos=new Line2D.Double(puntoA, puntoB);        
    }
    
    
    /**
     * Para calcular la diferencia entre los puntos de control.
     * Si la figura se está moviendo se calcula la diferencia entre el punto de referencia y la nueva posición 
     * para que el movimiento de todos los puntos se hagan de forma correcta.
     * @param puntoRef El punto del plano donde se hace click para coger la figura.
     * @param npc El punto donde la figura se deja tras hacer dragged o la selección de un punto de control.
     */
    public void cambiarPuntosControl(Point2D puntoRef, Point2D npc){
        
        
        Imprimir("ENtrando en CAMBIAR PUNTOS DE CONTROL");
        
        
        if(moviendo){
            Imprimir("Intentando mover figura");
            /* En el caso de querer mover la figura se usa el punto de referencia en el que se pinchó y 
            se calcula cual sería la translación que habría que hacer para llevar la figura al completo
            al punto ncp (nuevo punto control).
            */
            
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
             ((Line2D)datosGeometricos).setLine(A, B);                          
         }
         if(seleccionadoPuntoControlB){
             //Queremos modificar el extremo derecho de la figura.
             B=npc;
             Imprimir("Cambiando punto de control B");
             ((Line2D)datosGeometricos).setLine(A, B);
         }
         if(!seleccionadoPuntoControlA && !seleccionadoPuntoControlB){
             //mueveNueva(puntoRef, npc);
             Imprimir("Moviendo linea");
         }
        }
         
     
    }
    
    /**
     * Especificación del cambio de posición para esta figura.   
     * @param nuevoPuntoA Nuevo extremo de la linea.
     * @param nuevoPuntoB Nuevo extremo de la linea.
     */
    @Override
    public void cambiarPosicion(Point2D nuevoPuntoA, Point2D nuevoPuntoB){
        
        A=nuevoPuntoA;
        B=nuevoPuntoB;
        
        ((Line2D)datosGeometricos).setLine(A, B);        
    }
        
     /**
     * Cambia el modo de edición.
     * @param modo True para activarlo y false para desactivalrlo.
     */
    public void setModoEdicion(boolean modo){
        modoEdicion=modo;
    }
     
    /**
     * Realiza las modificaciones reales sobre todos los puntos que definen la figura.
     * @param ref Referencia 
     * @param nuevo Punto nuevo
     */
    public void soltarRaton(Point2D ref, Point2D nuevo){
            Imprimir("Soltando el raton");
            
            if(moviendo){
                
                //Cambiamos los puntos: 
                A.setLocation(A.getX()+distanciaX, A.getY()+distanciaY);
                B.setLocation(B.getX()+distanciaX, B.getY()+distanciaY);
                
                //Modificamos la figura:
                 ((Line2D)datosGeometricos).setLine(A, B);     
                
             //   elipsePuntoControlA = new Ellipse2D.Double(A.getX()-5, A.getY()-5, 10, 10);
             //   elipsePuntoControlB = new Ellipse2D.Double(B.getX()-5, B.getY()-5, 10, 10);

            }
            moviendo=false;
            
            //Después de soltar el ratón el moviviento de la figura ha cesado y se resetean los valores de las distancias:
            distanciaX=distanciaY=0;
    }
    
    /**
     * Para que la figura se pinte (renderice) en el objeto Graphics2D.
     * @param g2d Entorno donde renderizar la linea.
     */
    @Override
    public void dibujateEn(Graphics2D g2d){
                       
        //Establecemos el color de la figura usando el objeto trazo.
        g2d.setColor(trazo.getColor());        
        
        //Establecemos el estilo de trazo usando el objeto trazo.
        g2d.setStroke(trazo.getStroke());
        
        
        AffineTransform move = new AffineTransform();
           move.translate(distanciaX,distanciaY); 
           
           AffineTransform cancelMove = new AffineTransform();
           cancelMove.translate(0,0); 

           if(moviendo){
            g2d.setTransform(move);     
           }
        
        
        //Hacemos que se dibujen los datos geométricos.
        g2d.draw(datosGeometricos);
        
       
       
        
        //Si el modo edición está activo 
        if(modoEdicion){
            
            //Imprimir("DIbujando puntos de control de linea)");
            
            //Dibujamos también los puntos de control:
            elipsePuntoControlA= new Ellipse2D.Double(A.getX()-5, A.getY()-5,10,10);
            g2d.draw(elipsePuntoControlA);
            
            elipsePuntoControlB= new Ellipse2D.Double(B.getX()-5, B.getY()-5,10,10);
            g2d.draw(elipsePuntoControlB);
        }
        
         if(moviendo){
            g2d.setTransform(cancelMove);
        }
        
        
    }
    
    /**
     * Nos dice si un punto pertenece a la linea.
     * En este caso si el punto está próximo ya que no podemos pinchar exactamente en la linea.
     * @param punto El punto a comprobar si está cerca de la linea.
     * @return Si está cerca o no.
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
                 if(((Line2D)datosGeometricos).ptLineDistSq(punto)<=5.0){
                     moviendo=true;
                     return true;
                 }
                 // pero si tampoco, false
                 else
                    return false;
         }
        
        
        
        
        /*Para el caso de la linea tenemos que hacer modificaciones ya que la función contains no funciona
        por la delgadez de la linea. */        
      //  return ((Line2D)datosGeometricos).ptLineDistSq(punto)<=5.0;
    }

    /**
     * Para conocer información sobre el objeto.
     * @return Información del objeto en un String.
     */
    @Override
    public String toString() {
       //Sólo la principal información geométrica.
       return "linea "+"A("+((Line2D)datosGeometricos).getX1()+","+((Line2D)datosGeometricos).getY1()+")"
                      +"B("+((Line2D)datosGeometricos).getX2()+","+((Line2D)datosGeometricos).getY2()+")";        
    }

    
    /**
     * Para cambiar la posición de la linea a través de un punto dado.
     * Cuando movemos la linea sólo manejamos un punto que es donde la dejamos, la función que cambia la posición de una linea
     * necesita dos puntos, los extremos de la linea. Para eso esta función hace los calculos necesarios para dado un punto
     * en el espacio, mover toda la linea y obtener sus nuevos puntos que la definen (los extremos). Por eso es necesaria
     * esta conversión siempre para mover una linea.
     * @param pos Nuevo punto donde queremos colocar la linea.
     */     
    @Override
    public void cambiarPosicion2(Point2D pos) {
                    
        Imprimir("Cambiando posicion plano");
        
        /*
        Calculamos los puntos extremos que definen la linea que resultarían de moverla y dejarla en el punto 
        que definimos con el ratón y que es el que se le pasa.
        Esta forma tiene un fallo y es que siempre nos pondra el punto donde dejemos el ratón como un extremo de la linea
        y aunque pinchemos en el centro de esta nos la moverá hacia uno de sus extremos. Esto se podría mejorar.
        */
        
        double dx=pos.getX()-((Line2D)datosGeometricos).getX1();
        double dy=pos.getY()-((Line2D)datosGeometricos).getY1();
        Point2D newp2 = new Point2D.Double(((Line2D)datosGeometricos).getX2()+dx,((Line2D)datosGeometricos).getY2()+dy);
        
        //Se llama a "cambiarPosicion" que es quien cambia la posición de los dos puntos de la linea.
        this.cambiarPosicion(pos, newp2);
    }
    
}
