package GUI;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import static extras.Imprimir.Imprimir;
import java.awt.geom.Rectangle2D;


public class Linea2D extends Line2D {
    
    /*
    * Metodo para saber si el punto pasado está cerca de la linea.
    */
    public boolean isNear(Point2D p){
        Imprimir("Hola");
        return this.ptLineDist(p)<=2.0;
    }
    
    @Override
    public boolean contains(Point2D p){
        Imprimir("contains");
        return isNear(p);
    }

    public void prueba(){
        Imprimir("prueba");
    }

    @Override
    public double getX1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getY1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Point2D getP1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getX2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getY2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Point2D getP2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLine(double x1, double y1, double x2, double y2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rectangle2D getBounds2D() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
