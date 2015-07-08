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
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Clase que implementa la figura POLILINEA.
 * Utiliza internamente un objeto de tipo GeneralPath de la Java2D para los datos geometricos.
 * En resumen se trata de una figura compuesta por la union mediante lineas de sus puntos. Estos puntos 
 * los va introduciendo el usuario pudiendo asi formar cualquier tipo de figura como consecuencia de lineas contiguas.
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/awt/geom/GeneralPath.html">Clase GeneralPath</a> 
 * @author Juan A. Fernández Sánchez
 */
public class Polilinea extends Figura {

    
    ArrayList<Point2D>puntos;
    
    
    
    
    public Polilinea(){
        super();
        puntos = new ArrayList();
    }
    
    
    public void addPunto(Point2D nuevoPunto){
        Imprimir("AÑADIENDO NUEVO PUNTO, total:"+puntos.size());
        puntos.add(nuevoPunto);
    }
    
    @Override
    public void dibujateEn(Graphics2D entorno) {
        
        Imprimir(" ############################ Llamando a dibujar POLILINEA");
        
      
        GeneralPath polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, puntos.size());
        
        Imprimir("Construyendo polilinea de "+puntos.size()+" puntos");
       
            polyline.moveTo(puntos.get(0).getX(),puntos.get(0).getY());
            
            for(int i=1; i<puntos.size(); i++)
                polyline.lineTo(puntos.get(i).getX(),puntos.get(i).getY());
        
            entorno.draw(polyline);
   
        
            
        //Además de dibujar la linea dibujamos puntos en las esquinas de la polilinea.
        for(Point2D p: puntos)
            entorno.draw(new Ellipse2D.Double(p.getX()-5, p.getY()-5, 10,10));

          
            
            
            
            
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
        
        boolean contiene=((GeneralPath)datosGeometricos).contains(punto);
        
        
         if( contiene ){
             Imprimir("Contiene");
             return true;
         }else{
             return false;
         }        
    }

    @Override
    public String toString() {
        return "Polilinea de";// "+puntos.size()+" puntos.";
    }
    
}
