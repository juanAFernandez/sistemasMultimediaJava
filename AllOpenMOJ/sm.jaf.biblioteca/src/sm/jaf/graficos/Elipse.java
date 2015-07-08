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
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import sm.jaf.graficos.Relleno.Horientacion;

/**
 *
 * @author Juan A. Fernández Sánchez
 */
public class Elipse extends Figura{

    private boolean relleno;
    
    public Relleno miRelleno;
    
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
    public void setRelleno(Relleno nuevoRelleno){
        Imprimir("INtroduciendo nuevo relleno");
        miRelleno = nuevoRelleno;     
//        Imprimir(miRelleno.toString());
    }
    public boolean getRelleno(){
        return relleno;
    }
    
     public Paint getDatosRelleno(){
        
        /**
            * Configuración de puntos.
            * Para realizar el degradado correctamente no podemos escoger puntos de forma arbitraria. Tenemos
            * que conocer las dimensiones de la figura y configurar el detradado con estas. En el caso del rectángulo
            * tenemos que conseguir un punto de su arista superior y otro de su aristas inferior y con esos construiremos
            * el degradado vertical. Para conseguir esto nos ayudaremos de algunas funciones de las clases herederas de Shape.          
        */
        
        
        //Puntos temporales para creación del relleno de gradiente.
        Point2D tmpA, tmpB;
        
        
        //POR DEFECTO
       Paint relleno = new GradientPaint(new Point2D.Double(0,0), Color.BLACK, new Point2D.Double(100,100), Color.CYAN);

        /**
         * Proceso de construcción del objeto Paint que será el relleno de la figura.
         * Este depende del tamaño de la figura por eso se tienen que recalcular los puntos.
         */
        
        
       if(miRelleno.getHorientacion()==Horientacion.VERTICAL){
        //   Imprimir("Configurando gradiente para horientacion VERTICAL");
           

           
           Double maxY=  ((Ellipse2D)datosGeometricos).getMaxY();
           
        //   Imprimir("maxY"+maxY);
           
           relleno = new GradientPaint(new Point2D.Double(0,0), miRelleno.getColorA(), new Point2D.Double(0,maxY), miRelleno.getColorB());
       }else if(miRelleno.getHorientacion()==Horientacion.HORIZONTAL){
           
           
       //    Imprimir("Configurando gradiente para horientacion HORIZONTAL");
            Double maxX=  ((Ellipse2D)datosGeometricos).getMaxX();
           
        //   Imprimir("maxx"+maxX);
           
            //Usamos de punto A el 0,0 y de be el maximo de x con 0 en y para conseguir la arista derecha del rectángulo.
            relleno = new GradientPaint(new Point2D.Double(0,0), miRelleno.getColorA(), new Point2D.Double(maxX,0), miRelleno.getColorB());
       
       }else if(miRelleno.getHorientacion()==Horientacion.DIAGONAL_A){ // TipoA:/
           Double maxY=  ((Ellipse2D)datosGeometricos).getMaxY();
           Double maxX=  ((Ellipse2D)datosGeometricos).getMaxX();
      //     Imprimir("maxY"+maxY);
      //     Imprimir("maxx"+maxX);
           relleno = new GradientPaint(new Point2D.Double(0,maxY), miRelleno.getColorA(), new Point2D.Double(maxX,0), miRelleno.getColorB());
       }else if(miRelleno.getHorientacion()==Horientacion.DIAGONAL_B){ //Tipo B: \
           Double maxY=  ((Ellipse2D)datosGeometricos).getMaxY();
           Double maxX=  ((Ellipse2D)datosGeometricos).getMaxX();
       //    Imprimir("maxY"+maxY);
       //    Imprimir("maxx"+maxX);
           relleno = new GradientPaint(new Point2D.Double(0,0), miRelleno.getColorA(), new Point2D.Double(maxX,maxY), miRelleno.getColorB());
       }
        
        
        return relleno;
    }
    
    @Override
    public void dibujateEn(Graphics2D g2d) {
          
        //Establecemos el color
        g2d.setColor(trazo.getColor());
        

        //Aplicamos el stilo que acabos de definir
        g2d.setStroke(trazo.getStroke());
        
         if(relleno){
            g2d.setPaint(getDatosRelleno());
            g2d.fill(datosGeometricos);
            System.out.println("Dibujando con relleno");
         }else{        
            g2d.draw(datosGeometricos);
            System.out.println("Dibujando SIN relleno");
         }   
          
    }

    /**
     * Para cambiar las coordenadas de los datos geométricos de la figura.
     * Usandos dos puntos cambia el objeto a partir de la diagonal principal del mismo, que se modifica,
     * por eso sirve tanto para cambiarla de tamaño como para moverla por completo en el plano.
     * @param nuevoPuntoA Extremo de la diagonal
     * @param nuevoPuntoB Otro extremo de la diagonal
     */
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
