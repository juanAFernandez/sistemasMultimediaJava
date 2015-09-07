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
import java.awt.Shape;
import java.awt.geom.Point2D;

/**
 * Clase principal, Abstracción del objeto Figura que tiene las características que comparten todos los tipos de objetos que heredan de ella.
 * 
 * Haciendo la clase abstract forzamos a que sus herederas implementen cierto metodo de forma que despues podamos aplicar polimorfismo
 * mandando el mismo mensaje a objetos de distinto tipo pero herederos todos para que reaccionen de forma distinta, como en el caso de dibujar.
 * 
 * Sólo contiene dos variables, los datos geométricos de la propia figura y el trazo, una clase propia
 * que define todos sus atributos.
 * 
 * @author Juan A. Fernández Sánchez
 */
public abstract class Figura {
    
    /**
     * Objeto Shape para contener los datos geométricos de la figura.
     * Todos los objetos que hereden de esta haran uso de las figuras que JAVA2D tiene heredando de esta,
     * asi podremos recorrer vectores de figuras tipo Shape y gracias al polimorfismo trabajar con todos.
     */
    protected Shape datosGeometricos;
    
    /**
     * Trazo. 
     * Contiene todos los datos relativos a como se dibuja, desde color, grosor hasta continuidad y estilos de terminación.
     */
    protected Trazo trazo;
    
    /**
     * Para el control de la edición de la figura.
     */
    protected boolean modoEdicion;
    
    /**
     * Para el control de movimiento de la figura.
     */
    protected boolean moviendo;
    
    /**
     * Variable necesaria para el posicionamiento de la figura respectro al plano X y para operaciones con el.
     */
    protected double distanciaX=0;
    /**
     * Variable necesaria para el posicionamiento de la figura respectro al plano Y y para operaciones con el.
     */    
    protected double distanciaY=0;
    
   
    
     /**
      * Constructor sin parámetros.
      * Sólo inicializa el trazo de la figura.
      */
    public Figura(){
        trazo = new Trazo();
    }
    
    
    /**
     * Devuelve el trazo de la figura.
     * Dentro del trazo va todo lo relacionado con el aspecto de la figura.
     * @return Un objeto de tipo Trazo 
     */
    public Trazo getTrazo(){
        return trazo;       
    } 
    /**
     * Para modificar el trazo de la figura.
     * Dentro del trazo va todo lo relacionado con el aspecto de la figura.     
     * @param nuevoTrazo El nuevo trazo por el que se va a sustituir el anterior.
     */
    public void setTrazo(Trazo nuevoTrazo){
     //   Imprimir("APlicando nuevo trazo"+nuevoTrazo.getGrosor());
        trazo = new Trazo();
        trazo.setCopiaTrazo(nuevoTrazo);
      //  Imprimir("Aplicado trazo "+trazo.getGrosor());
    }
    

    /* Métodos ## ABSTRACTOS ## que obligamos a que cada clase que herede los implemente ya que cada objeto de tipo 
    * figura los implementará de una forma u otra, dependiendo de sus características. */
    
    /**
     * Para dibujar la figura en un Graphics2D concreto.
     * @param entorno Objeto entorno donde se dibujará la figura.
     */
    public abstract void dibujateEn(Graphics2D entorno);
        
    /**
     * Cambia la posición de un objeto en el lienzo.
     * Todos los objetos que son figuras pueden definirse con dos puntos básicos, independientemente
     * de que luego tengan más o menos.
     * @param nuevoPuntoA Punto extremo de la figura.
     * @param nuevoPuntoB Punto extremo opuesto de la figura.
     */
    public abstract void cambiarPosicion(Point2D nuevoPuntoA, Point2D nuevoPuntoB);
    
   
  
    /**
     * Para conocer si un punto pasado pertenece o no a la figura.
     * Usado para poder conocer si al hacer click sobre un punto del lienzo se ha clicado sobre una figura o parte de
     * ella, ya sea para moverla o para editarla de algúna manera. 
     * @param punto Punto de referencia
     * @return Si el punto pertenece a la figura o no.
     */
    public abstract boolean contiene(Point2D punto);
    
    /**
     * Para concer información de la figura que ayude a identificarla por terminal.
     * @return Texto que identifica la figura que puede incluir información tanto geométrica como del trazo.
     */
    @Override
    public abstract String toString();
    
}
