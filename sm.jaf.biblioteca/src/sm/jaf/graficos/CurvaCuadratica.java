/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jaf.graficos;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.QuadCurve2D;

/**
 *
 * @author Juan A. Fernández Sánchez
 */
public class CurvaCuadratica extends Figura {
                    
 
    private Point2D.Double puntoControl;
    
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
     * Metodo para el calculo del punto medio de un segmento.
     * @param A Extremo A del segmento que definen los puntos.
     * @param B Extremo B del segmento que definen los puntos
     */        
    public void puntoControlDefecto(Point2D A, Point2D B){
        //Las coordenadas del punto medio de un segmento coinciden con la semisuma de las coordenadas de los puntos extremos.
        puntoControl = new Point2D.Double((A.getX()+B.getX())/2, (A.getY()+B.getY())/2);
    }
    
    @Override
    public void cambiarPosicion(Point2D nuevoPuntoA, Point2D nuevoPuntoB){
 
        //Cuando cambiamos los puntos de la linea también estamos cambiando el punto de control
        this.puntoControlDefecto(nuevoPuntoA, nuevoPuntoB);
        ((QuadCurve2D)datosGeometricos).setCurve(nuevoPuntoA.getX(), nuevoPuntoA.getY(), puntoControl.getX(), puntoControl.getY(), nuevoPuntoB.getX(), nuevoPuntoB.getY());
        
    }
        
    @Override
    public void dibujateEn(Graphics2D g2d){
                       
        //Establecemos el color de la figura usando el objeto trazo.
        g2d.setColor(trazo.getColor());        
        
        //Establecemos el estilo de trazo usando el objeto trazo.
        g2d.setStroke(trazo.getStroke());
        
        //Hacemos que se dibujen los datos geométricos.
        g2d.draw(datosGeometricos);
        
        
        //Si la figura está en modo edición se verá el punto de control:

        if(modoEdicion){
            //Creamos una elipse que represente el punto de control
            Ellipse2D puntoC = new Ellipse2D.Double(puntoControl.getX()-5,puntoControl.getY()-5, 10, 10);       
            //La dibujamos
            g2d.draw(puntoC);
        }

        
    }
    
    @Override
    public boolean contiene(Point2D punto){
        
        //Posiblemente falle como en el caso de la linea:
        
        if( ((QuadCurve2D)datosGeometricos).contains(punto) )
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
                     
        double dx=pos.getX()-((QuadCurve2D)datosGeometricos).getX1();
        double dy=pos.getY()-((QuadCurve2D)datosGeometricos).getY1();
        Point2D newp2 = new Point2D.Double(((QuadCurve2D)datosGeometricos).getX2()+dx,((QuadCurve2D)datosGeometricos).getY2()+dy);        
        this.cambiarPosicion(pos, newp2);
    }
    
    
}
