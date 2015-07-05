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

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * Clase que implementa la figura LINEA.
 * Utiliza internamente un objeto de tipo Line2D de la Java2D para los datos geometricos.
 * @see <a href="http://docs.oracle.com/javase/7/docs/api/java/awt/geom/Line2D.html">Clase Line2D</a> 
 * @author Juan A. Fernández Sánchez
 */
public class Linea extends Figura {
              
    /**
     * Primer constructor sin parámetros.
     * Sólo inicializa los datos geométricos con una Line2D de la Java2D.
     */
    public Linea(){
        datosGeometricos=new Line2D.Double();
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
     * Especificación del cambio de posición para esta figura.   
     * @param nuevoPuntoA Nuevo extremo de la linea.
     * @param nuevoPuntoB Nuevo extremo de la linea.
     */
    @Override
    public void cambiarPosicion(Point2D nuevoPuntoA, Point2D nuevoPuntoB){
        ((Line2D)datosGeometricos).setLine(nuevoPuntoA, nuevoPuntoB);        
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
        
        //Hacemos que se dibujen los datos geométricos.
        g2d.draw(datosGeometricos);
    }
    
    /**
     * Nos dice si un punto pertenece a la linea.
     * En este caso si el punto está próximo ya que no podemos pinchar exactamente en la linea.
     * @param punto El punto a comprobar si está cerca de la linea.
     * @return Si está cerca o no.
     */
    @Override
    public boolean contiene(Point2D punto){        
        /*Para el caso de la linea tenemos que hacer modificaciones ya que la función contains no funciona
        por la delgadez de la linea. */        
        return ((Line2D)datosGeometricos).ptLineDistSq(punto)<=5.0;
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
