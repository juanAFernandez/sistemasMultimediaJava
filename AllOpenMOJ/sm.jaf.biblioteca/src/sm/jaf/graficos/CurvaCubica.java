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
import java.awt.geom.Point2D;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Line2D;

/**
 * Segmento de linea con dos puntos de control para hacerlo curvo con mayor precisión que la QuadCurve 
 * con sólo un punto de control.
 * @author Juan A. Fernández Sánchez
 */
public class CurvaCubica extends Figura {
     
    
    private Point2D puntoControlA = new Point2D.Double();  
    private Ellipse2D elipsePuntoControlA;    
    boolean seleccionadoPuntoControlA=false;
    
    private Point2D puntoControlB = new Point2D.Double();  
    private Ellipse2D elipsePuntoControlB;    
    boolean seleccionadoPuntoControlB=false;
    
    private Point2D A = new Point2D.Double(); 
    Ellipse2D elipsePuntoA;
    boolean seleccionadoPuntoA=false;
    
    private Point2D B = new Point2D.Double();
    Ellipse2D elipsePuntoB;
    boolean seleccionadoPuntoB=false;
    
    boolean moviendo=false;
    double distanciaX=0;
    double distanciaY=0;

    
    private boolean modoEdicion=false;
    
    
    /**
     * Primer constructor sin parámetros
     */
    public CurvaCubica(){
        datosGeometricos=new CubicCurve2D.Double();
    }
    /**
     * Segundo constructor con parámetros. 
     * @param puntoA Primer punto de la curva cuadratica.
     * @param puntoB Segundo punto de la curva cuadratica.
     * @see <a href="http://docs.oracle.com/javase/7/docs/api/java/awt/geom/CubicCurve2D.Double.html">Más sobre CubicCurve2D, en especial el constructor.</a>
     */
    public CurvaCubica(Point2D puntoA, Point2D puntoB){
        Imprimir("CONSTRUCTOR");
        /*
        El constructor de QuadCurve2D requiere las coordenadas de dos puntos, A y B y las coordenada del punto de contol.
        Por defecto nuestro punto de control sera el punto medio del segmento que definen los puntos que le estamos pasando.
        */
        puntosControlDefecto(puntoA, puntoB);
        /*El constructor de esta clase requiere primero las coordenadas de ambos puntos de control y después
        los dos puntos que definen el segmento.        
        */        
        datosGeometricos=new CubicCurve2D.Double(puntoControlA.getX(), puntoControlA.getY(), 
                                                 puntoControlB.getX(), puntoControlB.getY(),
                                                 puntoA.getX(), puntoA.getY(), 
                                                 puntoB.getX(), puntoB.getY() 
                                                );
        
    }
    
    /**
     * Para el cálculo de los dos puntos de control por defecto que CubirCurve tiene.
     * @param A Extremo A del segmento que definen los puntos.
     * @param B Extremo B del segmento que definen los puntos
     */        
    public void puntosControlDefecto(Point2D A, Point2D B){
        
        /*
        En este caso a diferencia de la CurvaCuadrática no podemos calcular el centro del segemento y colocar ahí el punto,
        tenemos que colocar dos puntos de control y tomamos la decisión de colocarlos a un tercio de la linea cada uno.
        Para eso vamos a dividir el segmento en una relación dada, en nuestro caso 1/3.
        */
        
        //El punto que representa 1/3 del segmento:
        puntoControlA = new Point2D.Double(    ((B.getX()-A.getX())/3)+A.getX(), ((B.getY()-A.getY())/3)+A.getY()      );
        
        //El punto que representa 2/3 del segmento:
        puntoControlB = new Point2D.Double( ( (2*(B.getX()-A.getX())) /3 ) +A.getX(), ( (2*(B.getY()-A.getY())) /3 ) +A.getY() );
                
                
    }
    
    /**
     * 
     * @param puntoRef
     * @param npc 
     */
    public void cambiarPuntosControl(Point2D puntoRef, Point2D npc){
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
            
                                   
            
            
        }else{
            
            /*
             Si no se se está moviendo se está modificando un punto de control que habrá sido previamente
             seleccionado en el contains, por lo que ahora se guarda el punto donde corresponde.
             */
             
            if(seleccionadoPuntoControlA)
                //Se modifica el punto de control
                puntoControlA= npc;

            if(seleccionadoPuntoControlB)
                //Se modifica el punto de control
                puntoControlB= npc;
            
            if(seleccionadoPuntoA)
                //Se modifica uno de los extremos de la linea principal.           
                A=npc;
            
            if(seleccionadoPuntoB)
                //Se modifica el otro de los extremos de la linea principal.
               B=npc;
            
            ((CubicCurve2D)datosGeometricos).setCurve(A, puntoControlA, puntoControlB, B);
            
         }
    }
    
    
          public void soltarRaton(Point2D ref, Point2D nuevo){
            
            /**
             * Si la figura se está moviendo se realiza el cambio de su posición, en caso contrario se estará
             * modificando un punto de control y esta función no hace nada.
             */
            if(moviendo){
                
                //Modificamos los tres puntos que definen la figura aplicando las distancas obtenidas por el movimiento.
                
                //Cambiamos los puntos: 
                A.setLocation(A.getX()+distanciaX, A.getY()+distanciaY);
                B.setLocation(B.getX()+distanciaX, B.getY()+distanciaY);
                
                puntoControlA.setLocation(puntoControlA.getX()+distanciaX, puntoControlA.getY()+distanciaY);
                puntoControlB.setLocation(puntoControlB.getX()+distanciaX, puntoControlB.getY()+distanciaY);
                
                ((CubicCurve2D)datosGeometricos).setCurve(A, puntoControlA, puntoControlB, B);
                
            }
            moviendo=false;
            distanciaX=distanciaY=0;
    }
    
    
    /**
     * Usada para cambiar la posición del segmento.
     * Durante la creación del segemento cuando vamos arrastrando el ratón por la pantalla se va cambiarndo
     * la posición de los puntos de nuestro segmento.
     * @param nuevoPuntoA
     * @param nuevoPuntoB 
     */
    @Override
    public void cambiarPosicion(Point2D nuevoPuntoA, Point2D nuevoPuntoB){
 
        //Cuando cambiamos los puntos de la linea también estamos cambiando el punto de control
        this.puntosControlDefecto(nuevoPuntoA, nuevoPuntoB);
        //Grabamos los puntos en nuestras variables
        A=nuevoPuntoA;
        B=nuevoPuntoB;
        //Seteamos los datos geométricos de nuestra figura.
        ((CubicCurve2D)datosGeometricos).setCurve(A, puntoControlA, puntoControlB, B);

        
    }
        
    public void setModoEdicion(boolean modo){
        modoEdicion=modo;
    }
    
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
        
        
        //Si la figura está en modo edición TAMBIÉN se verá el punto de control:

        if(modoEdicion){
            //Creamos unas elipses que representen los puntos de control:              
            
            elipsePuntoControlA = new Ellipse2D.Double(puntoControlA.getX()-5,puntoControlA.getY()-5, 10, 10);                 
            //La dibujamos
            g2d.draw(elipsePuntoControlA);
            
            elipsePuntoControlB = new Ellipse2D.Double(puntoControlB.getX()-5,puntoControlB.getY()-5, 10, 10);                 
            //La dibujamos
            g2d.draw(elipsePuntoControlB);
           
            
            
            //Dibujamos los puntos de control que representan los extremos del segmento:
            
            elipsePuntoA = new Ellipse2D.Double(((CubicCurve2D)datosGeometricos).getX1()-5, ((CubicCurve2D)datosGeometricos).getY1()-5,10,10 );
            g2d.draw(elipsePuntoA);
            
            elipsePuntoB = new Ellipse2D.Double(((CubicCurve2D)datosGeometricos).getX2()-5, ((CubicCurve2D)datosGeometricos).getY2()-5,10,10 );
            g2d.draw(elipsePuntoB);
            
        }
          if(moviendo){
            g2d.setTransform(cancelMove);
        }

        
    }
    /**
     * Funcion que indica si se ha seleccionado un punto de la figura.
     * En este caso lo que se hace NO ES ver si se ha seleccionado un punto CUALQUIERA de la figura SINO si se ha seleccionado
     * uno de los PUNTOS DE CONTROL para la edición ya que ahora mismo no se puede mover la figura, sólo se puede editar.
     * @param punto
     * @return 
     */
    @Override
    public boolean contiene(Point2D punto){
        
        seleccionadoPuntoControlA=false;
        seleccionadoPuntoControlB=false;
        
        seleccionadoPuntoA=false;
        seleccionadoPuntoB=false;
        
        moviendo=false;
        
         //¿Se ha seleccionado uno de los  puntos de control?//
         if(elipsePuntoControlA.contains(punto)){
             Imprimir("Has dado en el clavo A!");
             this.seleccionadoPuntoControlA=true;
          //   seleccionadoPuntoA=false;             
             return true;
         }else
             if(elipsePuntoControlB.contains(punto)){
             Imprimir("Has dado en el clavo B!");
             this.seleccionadoPuntoControlB=true;
            // seleccionadoPuntoA=false;             
             return true;
             }else
             if(elipsePuntoA.contains(punto)){
                 Imprimir("Has dado en el punto A!");
                 this.seleccionadoPuntoA=true;
                 return true;
             }
             else if(elipsePuntoB.contains(punto)){
                 Imprimir("Has dado en el punto B!");
                 this.seleccionadoPuntoB=true;
                 return true;
             }else{
                 
                 seleccionadoPuntoControlA=false;
                 seleccionadoPuntoControlB=false;
                 seleccionadoPuntoA=false;
                 seleccionadoPuntoB=false;
                 
                 //Construcción de una linea a partir de los puntos de control 
                 Line2D l = new Line2D.Double(A,B);
                 
                if( l.ptLineDistSq(punto)<=5.0 ){
                    Imprimir("Seleccionado otro punto de de la cubic curve");
                    moviendo=true;
                    return true;
                }
                else{    

                 return false;
                }
             } 
                






        //Posiblemente falle como en el caso de la linea:
        
        
        
        /*
        
        if( ((QuadCurve2D)datosGeometricos).contains(punto) )
            return true;
        else
            return false;
        */
                
    }

    @Override
    public String toString() {
        return "Curva Cubica";
        
    }

    @Override
    public void cambiarPosicion2(Point2D pos) {
                     
     //   double dx=pos.getX()-((QuadCurve2D)datosGeometricos).getX1();
     //   double dy=pos.getY()-((QuadCurve2D)datosGeometricos).getY1();
     //   Point2D newp2 = new Point2D.Double(((QuadCurve2D)datosGeometricos).getX2()+dx,((QuadCurve2D)datosGeometricos).getY2()+dy);        
     //   this.cambiarPosicion(pos, newp2);
    }
    
    
}
