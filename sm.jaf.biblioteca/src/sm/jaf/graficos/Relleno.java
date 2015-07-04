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

import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Juan A. Fernández Sánchez
 */
public class Relleno {
 
    private Color colorA;
    private Color colorB;
    
    private Point2D puntoA;
    private Point2D puntoB;
    
    private Horientacion horientacion;
    
    public Relleno(){}
    public Relleno(Color a, Color b, Horientacion horientacion){
        colorA = a;
        colorB = b;
        this.horientacion=horientacion;
    }
    
    @Override
    public String toString(){
        return "Color"+colorA.toString()+colorB.toString()+horientacion.toString();
    }
    
    public void setColorA(Color nuevoColorA){ colorA = nuevoColorA;}
    public Color getColorA(){return colorA;}
    public void setColorB(Color nuevoColorB){ colorB = nuevoColorB;}
    public Color getColorB(){return colorB;}
    public void setHorientacion(Horientacion nH){horientacion = nH;}
    public Horientacion getHorientacion(){return horientacion;}
    
  
    
    
    public static enum Horientacion {
        VERTICAL,
        HORIZONTAL,
        DIAGONAL_A,
        DIAGONAL_B
    }
}
