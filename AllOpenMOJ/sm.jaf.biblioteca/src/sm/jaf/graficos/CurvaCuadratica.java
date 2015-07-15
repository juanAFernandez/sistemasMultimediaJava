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
import java.awt.geom.QuadCurve2D;

/**
 * Segmento de linea con un punto de control para hacerlo  curvo.
 * @author Juan A. Fernández Sánchez
 */
public class CurvaCuadratica extends Figura {
     
    /**
     * Variables para el primer punto de control.
     */
    private Point2D puntoControl;    
    private Ellipse2D elipsePuntoControl;    
    private boolean seleccionadoPuntoControl;
    
    
    /**
     * Puntos que definen los extremos del segmento de linea.
     */
    private Point2D A;     
    private Ellipse2D elipsePuntoA;
    private boolean seleccionadoPuntoA;        
    
    private Ellipse2D elipsePuntoB;
    private boolean seleccionadoPuntoB;       
    private Point2D B;
    
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
     * Primer constructor sin parámetros
     */
    public CurvaCuadratica(){
        datosGeometricos=new QuadCurve2D.Double();
        distanciaX=0;
        distanciaY=0;
        modoEdicion=false;
        moviendo=false;
        seleccionadoPuntoControl=false;
        puntoControl = new Point2D.Double();
        A = new Point2D.Double();
        seleccionadoPuntoA=false;
        B = new Point2D.Double();
        seleccionadoPuntoB=false;
        
    }
    /**
     * Segundo constructor con parámetros. 
     * @param puntoA Primer punto de la curva cuadratica.
     * @param puntoB Segundo punto de la curva cuadratica.
     */
    public CurvaCuadratica(Point2D puntoA, Point2D puntoB){
        
        /*
        El constructor de QuadCurve2D requiere las coordenadas de dos puntos, A y B y las coordenada del punto de contol.
        Por defecto nuestro punto de control sera el punto medio del segmento que definen los puntos que le estamos pasando.
        */
        puntoControlDefecto(puntoA, puntoB);
        datosGeometricos=new QuadCurve2D.Double(puntoA.getX(), puntoA.getY(), puntoControl.getX(), puntoControl.getY(), puntoB.getX(), puntoB.getY());
    }
    
    /**
     * Metodo generador del punto medio de un segmento.
     * El segmento que creemos debe tener un punto de control que a falta de dárselo al principio, se crea
     * justo en el centro del segemento para que después el usuario lo use.     
     * @param A Extremo A del segmento que definen los puntos.
     * @param B Extremo B del segmento que definen los puntos
     * @return El punto de control construido en el centro de la linea.
     * @see <a href="https://es.wikipedia.org/wiki/Punto_medio">Calculo del punto medio</a>
     */        
    public Point2D puntoControlDefecto(Point2D A, Point2D B){
        
        //Las coordenadas del punto medio de un segmento coinciden con la semisuma de las coordenadas de los puntos extremos.
        //Usando: https://es.wikipedia.org/wiki/Punto_medio
        return new Point2D.Double((A.getX()+B.getX())/2, (A.getY()+B.getY())/2);
    }
   
    /**
     * Para calcular la diferencia entre los puntos de control.
     * Si la figura se está moviendo se calcula la diferencia entre el punto de referencia y la nueva posición 
     * para que el movimiento de todos los puntos se hagan de forma correcta.
     * @param puntoRef El punto del plano donde se hace click para coger la figura.
     * @param npc El punto donde la figura se deja tras hacer dragged o la selección de un punto de control.
     */   
    public void cambiarPuntoControl(Point2D puntoRef, Point2D npc){
            
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
                //Si se ha seleccionado el punto de control se modifica ese con el nuevo punto pasado
                if(seleccionadoPuntoControl) puntoControl= npc;
                if(seleccionadoPuntoA) A=npc;
                if(seleccionadoPuntoB) B=npc;                   
                //Se modifican los datos geometricos de la figura.
                ((QuadCurve2D)datosGeometricos).setCurve(A, puntoControl, B);
        
        }
    }
    /**
     * Cambia la posición completa de la curva.
     * Usando dos puntos nuevos y el punto de control que ya tenía ella.
     * @param nuevoPuntoA Nuevo extremo del segmento
     * @param nuevoPuntoB Nuevo extremo del segmento
     */
    @Override
    public void cambiarPosicion(Point2D nuevoPuntoA, Point2D nuevoPuntoB){
 
        //Cuando cambiamos los puntos de la linea también estamos cambiando el punto de control
        puntoControl = puntoControlDefecto(nuevoPuntoA, nuevoPuntoB);
        A=nuevoPuntoA;
        B=nuevoPuntoB;
        ((QuadCurve2D)datosGeometricos).setCurve(A, puntoControl, B);
        
    }
    
    /**
     * Notifica el modo de edición para que se vean los puntos de control al dibujar la figura.
     * @param modo Para indicar su activación o desactivación.
     */
    public void setModoEdicion(boolean modo){
        modoEdicion=modo;
    }
    
    /**
     * Pibujarse dentro de un objeto Graphics2D
     * @param g2d Entorno de dibujo donde debe dibujarse
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
        
        
        //Si la figura está en modo edición TAMBIÉN se verá el punto de control:

        if(modoEdicion){
            //Creamos una elipse que represente el punto de control, que será de nuestros tipos para poder seleccionarla bien.                      
            elipsePuntoControl = new Ellipse2D.Double(puntoControl.getX()-5,puntoControl.getY()-5, 10, 10);                 
            //La dibujamos
            g2d.draw(elipsePuntoControl);
                                   
            elipsePuntoA = new Ellipse2D.Double(A.getX()-5, A.getY()-5,10,10 );
            g2d.draw(elipsePuntoA);
            
            elipsePuntoB = new Ellipse2D.Double(B.getX()-5, B.getY()-5,10,10 );
            g2d.draw(elipsePuntoB);
            
        }
  if(moviendo){
            g2d.setTransform(cancelMove);
        }
        
        
    }
    
    /**
     * Para saber si un punto está contenido dentro de la figura, en este caso, próximo.
     * @param punto El punto a contrastar si está dentro de la figura
     * @return Si el punto se encuentra o no dentro de la figura o próximo.
     */
    @Override
    public boolean contiene(Point2D punto){
        
        seleccionadoPuntoControl=false;
        seleccionadoPuntoA=false;
        seleccionadoPuntoB=false;
        moviendo=false;
        
        
         //¿Se ha seleccionado el punto de control?//
         if(elipsePuntoControl.contains(punto)){
             Imprimir("Has dado en el clavo!");
             this.seleccionadoPuntoControl=true;
             seleccionadoPuntoA=false;             
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
                 
            //Como no ha sido seleccionado ninguno de los extremos ni el punto de control ponemos las variables a false.
                 seleccionadoPuntoControl=false;
                 seleccionadoPuntoA=false;
                 seleccionadoPuntoB=false;
                 moviendo=false;
            
                 
                 
                //Construcción de una linea a partir de los puntos de control 
                 Line2D l = new Line2D.Double(A,B);
                                  
                 
                //Nos queda comprobar si se ha seleccionado otro punto de la figura
                 //Cuando ocurre esto es que queremos mover la figura, no editar un punto de control
                if( l.ptLineDistSq(punto)<=5.0 ){
                    Imprimir("Seleccionado otro punto de de la cuad curve");
                    moviendo=true;
                    return true;
                }
                else{    

                 return false;
                }
             } 

    }
    
     /**
     * Realiza las modificaciones reales sobre todos los puntos que definen la figura.
     * @param ref Referencia 
     * @param nuevo Punto nuevo
     */
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
                
                puntoControl.setLocation(puntoControl.getX()+distanciaX,puntoControl.getY()+distanciaY);
                
                ((QuadCurve2D)datosGeometricos).setCurve(A, puntoControl, B);
                
            }
            moviendo=false;
            distanciaX=distanciaY=0;
    }
    
    /**
     * Para conocer información sobre el objeto.
     * @return Información del objeto en un String.
     */
    @Override
    public String toString() {
        String mensaje="";
    
        mensaje+="Curva Cubica: \n";
        mensaje+="\t Extremos: A("+A.getX()+","+A.getY()+")  B("+B.getX()+","+B.getY()+")\n";
        mensaje+="\t Punto de control  ("+puntoControl.getX()+","+puntoControl.getY()+")\n";                     
        
        return mensaje;
        
    }

    /**
     * Metodo alternativo para cambiar de posición.
     * @param pos 
     */
    @Override
    public void cambiarPosicion2(Point2D pos) {
                     
        double dx=pos.getX()-((QuadCurve2D)datosGeometricos).getX1();
        double dy=pos.getY()-((QuadCurve2D)datosGeometricos).getY1();
        Point2D newp2 = new Point2D.Double(((QuadCurve2D)datosGeometricos).getX2()+dx,((QuadCurve2D)datosGeometricos).getY2()+dy);        
        this.cambiarPosicion(pos, newp2);
    }
    
    
}
