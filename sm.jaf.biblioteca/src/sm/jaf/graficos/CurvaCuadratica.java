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
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.QuadCurve2D;

/**
 * Segmento de linea con un punto de control para hacerlo  curvo.
 * @author Juan A. Fernández Sánchez
 */
public class CurvaCuadratica extends Figura {
     
    /**
     * Único punto de control de la curva cuadrática.
     */
    private Point2D puntoControl = new Point2D.Double();
    
    private Ellipse2D elipsePuntoControl;    
    private boolean seleccionadoPuntoControl=false;
    
    
    //Variable para la reprensentación espacial del primer punto de la linea.    
    private Ellipse2D elipsePuntoA;
    private boolean seleccionadoPuntoA=false;
    
    //Variable para la reprensentación espacial del segundo punto de la linea.
    
    private Ellipse2D elipsePuntoB;
    private boolean seleccionadoPuntoB=false;
    
    

    
    private boolean modoEdicion=false;
    
    
    /**
     * Primer constructor sin parámetros
     */
    public CurvaCuadratica(){
        datosGeometricos=new QuadCurve2D.Double();
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
     * @see <a href="https://es.wikipedia.org/wiki/Punto_medio">Calculo del punto medio</a>
     */        
    public void puntoControlDefecto(Point2D A, Point2D B){
        
        //Las coordenadas del punto medio de un segmento coinciden con la semisuma de las coordenadas de los puntos extremos.
        //Usando: https://es.wikipedia.org/wiki/Punto_medio
        puntoControl = new Point2D.Double((A.getX()+B.getX())/2, (A.getY()+B.getY())/2);
    }
   
    /**
     * Cambia el punto de control de la curva cuadrática.   
     * @param nvc El nuevo punto de control
     */
    public void cambiarPuntoControl(Point2D nvc){
            
        if(seleccionadoPuntoControl){
            //Se modifica el punto de control
            puntoControl= nvc;
            //Se modifica la linea usando sus mismos datos anteriores y modifcando el punto de control
           ((QuadCurve2D)datosGeometricos).setCurve( ((QuadCurve2D)datosGeometricos).getX1(),((QuadCurve2D)datosGeometricos).getY1(), puntoControl.getX(), puntoControl.getY(), ((QuadCurve2D)datosGeometricos).getX2(),((QuadCurve2D)datosGeometricos).getY2());
        }
        if(seleccionadoPuntoA){
            //Solo cambiamos el punto A con el nuevo punto pasado.
            ((QuadCurve2D)datosGeometricos).setCurve( nvc.getX(),nvc.getY(), puntoControl.getX(), puntoControl.getY(), ((QuadCurve2D)datosGeometricos).getX2(),((QuadCurve2D)datosGeometricos).getY2());
        }
        if(seleccionadoPuntoB){
            //Solo cambiamos el punto A con el nuevo punto pasado.
           ((QuadCurve2D)datosGeometricos).setCurve( ((QuadCurve2D)datosGeometricos).getX1(),((QuadCurve2D)datosGeometricos).getY1(), puntoControl.getX(), puntoControl.getY(), nvc.getX(),nvc.getY());
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
        this.puntoControlDefecto(nuevoPuntoA, nuevoPuntoB);
        ((QuadCurve2D)datosGeometricos).setCurve(nuevoPuntoA.getX(), nuevoPuntoA.getY(), puntoControl.getX(), puntoControl.getY(), nuevoPuntoB.getX(), nuevoPuntoB.getY());
        
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
        
        //Hacemos que se dibujen los datos geométricos.
        g2d.draw(datosGeometricos);
        
        
        //Si la figura está en modo edición TAMBIÉN se verá el punto de control:

        if(modoEdicion){
            //Creamos una elipse que represente el punto de control, que será de nuestros tipos para poder seleccionarla bien.                      
            elipsePuntoControl = new Ellipse2D.Double(puntoControl.getX()-5,puntoControl.getY()-5, 10, 10);                 
            //La dibujamos
            g2d.draw(elipsePuntoControl);
                                   
            elipsePuntoA = new Ellipse2D.Double(((QuadCurve2D)datosGeometricos).getX1()-5, ((QuadCurve2D)datosGeometricos).getY1()-5,10,10 );
            g2d.draw(elipsePuntoA);
            
            elipsePuntoB = new Ellipse2D.Double(((QuadCurve2D)datosGeometricos).getX2()-5, ((QuadCurve2D)datosGeometricos).getY2()-5,10,10 );
            g2d.draw(elipsePuntoB);
            
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
                 
                 seleccionadoPuntoControl=false;
                 seleccionadoPuntoA=false;
                 seleccionadoPuntoB=false;
                 
                 return false;
             } 
                






        //Posiblemente falle como en el caso de la linea:
        
        
        
        /*
        
        if( ((QuadCurve2D)datosGeometricos).contains(punto) )
            return true;
        else
            return false;
        */
                
    }

    /**
     * Devuelve información básica de la figura.
     * @return Una cadena de texto con la información que se disponga.
     */
    @Override
    public String toString() {
        return "CurvaCuadratica - ";
        
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
