/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jaf.graficos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Point2D;

/**
 * Abstracción del objeto Figura que tiene las características que comparten todos los tipos de objetos que heredan de ella.
 * 
 * Haciendo la clas abstract forzamos a que sus herederas implementen cierto metodo de forma que despues podamos aplicar polimorfismo
 * mandando el mismo mensaje a objetos de distinto tipo pero herederos todos para que reaccionen de forma distinta, como en el caso de dibujar.
 * @author Juan A. Fernández Sánchez
 */
public abstract class Figura {
    
    /**
     * Objeto Shape para contener los datos geométricos de la figura.
     */
    protected Shape datosGeometricos;
    
    /**
     * Color de dibujado de la figura.
     */
    protected Color color;
   
    /**
     * Grosor de trazo de la figua.
     */
    protected int grosorTrazo;
    
    protected Stroke trazo;
    
    public Figura(){
        trazo = new BasicStroke(grosorTrazo);
    }
    
    
    public Stroke getTrazo(){
        return trazo;       
    }
    public void setTrazo(Stroke nuevoTrazo){
        trazo=nuevoTrazo;
    }
    
    
    
    public void setContinuidad(int valor){
        
          //Establecemos el grosor del trazado
        Stroke stilo;                                             
        
        float patronDiscontinuidad[] = {15.0f, 15.0f};
        
            stilo = new BasicStroke(10.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 1.0f, patronDiscontinuidad, 0.0f);

            
        this.setTrazo(stilo);
    }
    
    
    
    
    /**
     * Para modificar el color con el que se dibujará la figura.
     * @param nuevoColor El color que queremos que tenga la figura.
     */
    public void setColor(Color nuevoColor){
        color=nuevoColor;        
    }    
    
    /**
     * Para conseguir el color establecido para la figura.
     * @return El color que la figura tiene asignado.
     */
    public Color getColor(){
        return color;
    }
    
    /**
     * Para modificar el grosor del trazo.
     * @param grosor Nivel del grosor de trazo.
     */
    public void setGrosorTrazo(int grosor){
        grosorTrazo=grosor;
        trazo = new BasicStroke(grosorTrazo);
    }
    
    /**
     * Para obtener el grosor del trazo actual.
     * @return Grosor del trazo.
     */
    public int getGrosorTrazo(){
        return grosorTrazo;
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
