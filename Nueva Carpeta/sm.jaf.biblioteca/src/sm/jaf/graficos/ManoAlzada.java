/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jaf.graficos;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 *
 * @author Juan A. Fernández Sánchez
 */
public class ManoAlzada extends Figura{

    
    /**
     * Esta figura la componen una serie de puntos que el usuario va introduciendo cuando mueve el ratón.
     */
    ArrayList<Point2D> listaPuntos;
    
    
    public ManoAlzada(){
        //Solo inicializamos el array e introducimos el primer elemento
        listaPuntos = new ArrayList();        
    }
    
    /**
     * Añadimos un nuevo punto a la lista
     * @param nuevoPunto  Punto a añadir en la lista.
     */ 
    public void addPunto(Point2D nuevoPunto){
        listaPuntos.add(nuevoPunto);
        
    }
    
    @Override
    public void dibujateEn(Graphics2D g2d) {
              //Establecemos el color
        g2d.setColor(trazo.getColor());
        

        //Aplicamos el stilo que acabos de definir
        g2d.setStroke(trazo.getStroke());
        
        //Recorremos el vector dibujarndo todos los elementos que contiene:
        for(int i=0; i<listaPuntos.size(); i++){
            if(i==0)
                g2d.draw(new Line2D.Double(listaPuntos.get(i).getX(), listaPuntos.get(i).getY(), listaPuntos.get(i).getX(), listaPuntos.get(i).getY()));
            if(i>0)
                g2d.draw(new Line2D.Double(listaPuntos.get(i).getX(), listaPuntos.get(i).getY(), listaPuntos.get(i-1).getX(), listaPuntos.get(i-1).getY()));
        }
    }

    @Override
    public void cambiarPosicion(Point2D nuevoPuntoA, Point2D nuevoPuntoB) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cambiarPosicion2(Point2D nuevaLocalizacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contiene(Point2D punto) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return false;
    }

    @Override
    public String toString() {
        return "soy una mano alzada";
    }
    
}
