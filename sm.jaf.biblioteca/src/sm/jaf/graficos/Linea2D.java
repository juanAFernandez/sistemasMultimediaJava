/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jaf.graficos;

import static extras.Imprimir.Imprimir;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 *
 * @author juan
 */
public  class Linea2D extends Line2D.Double{
        
        public Linea2D( ){
		super( 0, 0, 0, 0 );
                System.out.println("Constructor de Linea2D NUEVA");
	}

	public Linea2D( Line2D linea ){
		super( linea.getX1( ), linea.getY1( ), linea.getX2( ), linea.getY2( ) );
	}

	public Linea2D( double x1, double y1, double x2, double y2 ){
		super( x1, y1, x2, y2 );
	}
        
        public Linea2D(Point2D pA, Point2D pB){
            this.x1=pA.getX();
            this.x2=pB.getX();
            this.y1=pA.getY();
            this.y2=pB.getY();                    
        }

        private boolean isNear(Point2D p){            
            return this.ptLineDist(p)<=5.0;
        }
        
        //Sobrecarga del método contains:
        @Override
        public boolean contains(Point2D p){
            Imprimir("Buscando coincidencia en linea"+isNear(p));
            return isNear(p);
        }
        
        public void setLocation(Point2D pos){
            double dx=pos.getX()-this.getX1();
            double dy=pos.getY()-this.getY1();
            Point2D newp2 = new Point2D.Double(this.getX2()+dx,this.getY2()+dy);
            this.setLine(pos,newp2);
        }
        
        
    
}
