/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jaf.graficos;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 *
 * @author Juan A. Fernández Sánchez
 */
public class Elipse extends Figura{

    private boolean relleno;
    
    public Elipse(){
        datosGeometricos = new Ellipse2D.Double();
        relleno = false;
    }
    public Elipse(Point2D puntoA, Point2D puntoB){
       datosGeometricos=new Ellipse2D.Double(puntoA.getX(), puntoA.getY(), puntoB.getX(), puntoB.getY()); 
       relleno=false;
    }
    
    public void setRelleno(boolean nuevoRelleno){
        relleno=nuevoRelleno;
    }
    public boolean getRelleno(){
        return relleno;
    }
    
    @Override
    public void dibujateEn(Graphics2D g2d) {
          
        //Establecemos el color
        g2d.setColor(trazo.getColor());
        

        //Aplicamos el stilo que acabos de definir
        g2d.setStroke(trazo.getStroke());
        
         if(relleno){
            g2d.fill(datosGeometricos);
            System.out.println("Dibujando con relleno");
         }else{        
            g2d.draw(datosGeometricos);
            System.out.println("Dibujando SIN relleno");
         }   
          
    }

    @Override
    public void cambiarPosicion(Point2D nuevoPuntoA, Point2D nuevoPuntoB) {
         ((Ellipse2D)datosGeometricos).setFrameFromDiagonal(nuevoPuntoA, nuevoPuntoB);
    }

    @Override
    public void cambiarPosicion2(Point2D pos) {
       ((Ellipse2D)datosGeometricos).setFrame(pos.getX(), pos.getY(), datosGeometricos.getBounds2D().getWidth(), datosGeometricos.getBounds2D().getHeight());
    }

    @Override
    public boolean contiene(Point2D punto) {
        return datosGeometricos.contains(punto);
    }

    @Override
    public String toString() {
        return "elipse";
    }
    
}
