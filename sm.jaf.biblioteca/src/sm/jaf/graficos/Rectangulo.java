/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jaf.graficos;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Juan A. Fernández Sánchez
 */
public class Rectangulo extends Figura{
    
    private boolean relleno;
    
     /**
     * Primer constructor sin parámetros
     */
    public Rectangulo(){
        datosGeometricos=new Rectangle2D.Double();
        relleno = false;
    }
    /**
     * Segundo constructor con parámetros.
     * Este es uno de los casos donde mejoramos el diseño original. En la linea podíamos construir el objeto a partir de dos
     * Point2D pero los constructuroes de Rectangle2D no los permiten por eso igualamos esa forma de construirlos.
     * @param puntoA Extremo A del rectángulo.
     * @param puntoB Extremo B del rectángulo.
     */
    public Rectangulo(Point2D puntoA, Point2D puntoB){        
        datosGeometricos=new Rectangle2D.Double(puntoA.getX(), puntoA.getY(), puntoB.getX(), puntoB.getY());  
        relleno = false;
    }
    
    public void setRelleno(boolean nuevoRelleno){
        relleno=nuevoRelleno;
    }
    public boolean getRelleno(){
        return relleno;
    }
    
    
    //Métodos de implementación específica de cada figura.
    
    /**
     * Para cambiar la posición de un rectángulo.
     * Implementa la funcionalidad particular propia.
     *
     * @param nuevoPuntoA
     * @param nuevoPuntoB 
     */
    @Override
    public void cambiarPosicion(Point2D nuevoPuntoA, Point2D nuevoPuntoB){
        
        /**
         * Aquí encontramos otro problema.
         * Mientras que en Line2D podíamos cambiar la posición de una linea dando la posición de una nueva linea
         * Rectangle2D no ofrece la misma función y tenemos que abstraer el funcionamiento de setFrameFromDiagonal.
         */

        ((Rectangle2D)datosGeometricos).setFrameFromDiagonal(nuevoPuntoA, nuevoPuntoB);
    }
    
        
    @Override
     public void dibujateEn(Graphics2D g2d){
        
        //Establecemos el color
        g2d.setColor(color);
        
        //Establecemos el grosor del trazado
       // Stroke stilo;
       // stilo = new BasicStroke(this.getGrosorTrazo());
        
        //Aplicamos el stilo que acabos de definir
        g2d.setStroke(trazo);
        
        //Hacemos que se dibujen los datos geométricos.
        
        if(relleno)
            g2d.fill(datosGeometricos);
        else        
            g2d.draw(datosGeometricos);
    }
    
     
     @Override
    public boolean contiene(Point2D punto){
        //Sólo una abstracción de nombre
        

            
        return datosGeometricos.contains(punto);
        
    }

    @Override
    public String toString() {
        return "rectangulo";
    }

    @Override
    public void cambiarPosicion2(Point2D pos) {
                     
        ((Rectangle2D)datosGeometricos).setFrame(pos.getX(), pos.getY(), datosGeometricos.getBounds2D().getWidth(), datosGeometricos.getBounds2D().getHeight());

    }
    
}
