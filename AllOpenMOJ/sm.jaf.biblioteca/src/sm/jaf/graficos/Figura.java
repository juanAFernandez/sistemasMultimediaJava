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
import java.awt.Shape;
import java.awt.geom.Point2D;

/**
 * Abstracción del objeto Figura que tiene las características que comparten todos los tipos de objetos que heredan de ella.
 * 
 * Haciendo la clase abstract forzamos a que sus herederas implementen cierto metodo de forma que despues podamos aplicar polimorfismo
 * mandando el mismo mensaje a objetos de distinto tipo pero herederos todos para que reaccionen de forma distinta, como en el caso de dibujar.
 * @author Juan A. Fernández Sánchez
 */
public abstract class Figura {
    
    /**
     * Objeto Shape para contener los datos geométricos de la figura.
     */
    protected Shape datosGeometricos;
    
    /**
     * Trazo. 
     * Contiene todos los datos relativos a como se dibuja, desde color, grosor hasta continuidad y estilos de termianción.
     */
    protected Trazo trazo;
    
    public Figura(){
        trazo = new Trazo();
    }
    
    
    public Trazo getTrazo(){
        return trazo;       
    }
    
    public void setTrazo(Trazo nuevoTrazo){
        Imprimir("APlicando nuevo trazo"+nuevoTrazo.getGrosor());
        trazo = new Trazo();
        trazo.setCopiaTrazo(nuevoTrazo);
        Imprimir("Aplicado trazo "+trazo.getGrosor());
    }
    
    
    
    
   
    /* Métodos abstractos que obligamos a que cada clase que herede los implemente porque cada objeto de tipo 
    * figura debe inmplementarlos aunque esta implementación cambie dependiendo del tipo de objeto.
    */
    
    public abstract void dibujateEn(Graphics2D entorno);
        
    public abstract void cambiarPosicion(Point2D nuevoPuntoA, Point2D nuevoPuntoB);
    
    public abstract void cambiarPosicion2(Point2D nuevaLocalizacion);
  
    public abstract boolean contiene(Point2D punto);
    
    @Override
    public abstract String toString();
    
}
