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
 *
 * @author Juan A. Fernández Sánchez
 */
public class Linea extends Figura {
    
    
    
    
    
    /**
     * Primer constructor sin parámetros
     */
    public Linea(){
        datosGeometricos=new Line2D.Double();
    }
    /**
     * Segundo constructor con parámetros.
     * @param puntoA Primer punto de la linea.
     * @param puntoB Segundo punto de la linea.
     */
    public Linea(Point2D puntoA, Point2D puntoB){
        datosGeometricos=new Line2D.Double(puntoA, puntoB);        
    }
    
    //Métodos de implementación específica de cada figura.
    
    @Override
    public void cambiarPosicion(Point2D nuevoPuntoA, Point2D nuevoPuntoB){
        /*
            double dx=pos.getX()-this.getX1();
            double dy=pos.getY()-this.getY1();
            Point2D newp2 = new Point2D.Double(this.getX2()+dx,this.getY2()+dy);
            this.setLine(pos,newp2);
        */

        ((Line2D)datosGeometricos).setLine(nuevoPuntoA, nuevoPuntoB);
        
        
    }
        
    @Override
    public void dibujateEn(Graphics2D g2d){
                       
        //Establecemos el color de la figura usando el objeto trazo.
        g2d.setColor(trazo.getColor());        
        
        //Establecemos el estilo de trazo usando el objeto trazo.
        g2d.setStroke(trazo.getStroke());
        
        //Hacemos que se dibujen los datos geométricos.
        g2d.draw(datosGeometricos);
    }
    
    @Override
    public boolean contiene(Point2D punto){
        
        //Para el caso de la linea tenemos que hacer modificaciones ya que la función contains no funciona
        //por la delgadez de la linea.
        
        
        if( ((Line2D)datosGeometricos).ptLineDistSq(punto)<=5.0 )
            return true;
        else
            return false;

    }

    @Override
    public String toString() {
        return "linea";
        
    }

    @Override
    public void cambiarPosicion2(Point2D pos) {
                     
        double dx=pos.getX()-((Line2D)datosGeometricos).getX1();
        double dy=pos.getY()-((Line2D)datosGeometricos).getY1();
        Point2D newp2 = new Point2D.Double(((Line2D)datosGeometricos).getX2()+dx,((Line2D)datosGeometricos).getY2()+dy);        
        this.cambiarPosicion(pos, newp2);
    }
    
    
}
