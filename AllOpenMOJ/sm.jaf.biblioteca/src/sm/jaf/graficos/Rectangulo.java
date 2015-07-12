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
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import sm.jaf.graficos.Relleno.Horientacion;

/**
 * Clase que implementa la figura RECTANGULO.
 * Internamente usa un objeto de tipo Rectantle2D de Java2D abstrayendo su funcionamiento y especificando su
 * comportamiento. Esta figura puede contener relleno y por eso tiene dos variables para controlarlo
 * @see <a href="http://docs.oracle.com/javase/7/docs/api/java/awt/geom/Rectangle2D.html">Clase Rectangle2D</a>
 * @author Juan A. Fernández Sánchez
 */
public class Rectangulo extends Figura{
    
    
    private boolean modoEdicion;
                 //1º: Sacamos los extremos A y B del rectangulo
        
    private Point2D A;          
    private Ellipse2D elipsePuntoControlA;    
    boolean seleccionadoPuntoControlA;
    
    private Point2D B;    
    private Ellipse2D elipsePuntoControlB;    
    boolean seleccionadoPuntoControlB;
    
    boolean moviendo=false;
    double distanciaX=0;
    double distanciaY=0;
    
    
    /**
     * Define si el rectángulo en cuestión tiene relleno o no.
     */
    private boolean relleno;       
    
    /**
     * En caso de que tenga relleno lo almacena aquí.
     */
    public Relleno miRelleno;
       

        

        
        //El A es muy facil de obtener:
       // A.setLocation( ((Rectangle2D)datosGeometricos).getX(), ((Rectangle2D)datosGeometricos).getY() );        
       // B.setLocation(((Rectangle2D)datosGeometricos).getMaxX(),((Rectangle2D)datosGeometricos).getMaxY());        
       // Imprimir("Extremos del rectangulo: A("+A.getX()+","+A.getY()+")"+" B("+B.getX()+","+B.getY()+")");
    
        
        
        
     /**
     * Primer constructor sin parámetros.
     * Inicializa los datos geométricos con el tipo necesario pero sin información y especificando
     * que no tiene relleno.
     */
    public Rectangulo(){
        datosGeometricos=new Rectangle2D.Double();        
        relleno = false;
        modoEdicion=false;
        seleccionadoPuntoControlA=false;
        elipsePuntoControlA = new Ellipse2D.Double();
        elipsePuntoControlB = new Ellipse2D.Double();
        seleccionadoPuntoControlB=false;
        A = new Point2D.Double(); 
        B = new Point2D.Double();
    }
    /**
     * Segundo constructor con parámetros.
     * Este es uno de los casos donde mejoramos el diseño original. En la linea podíamos construir el objeto a partir de dos
     * Point2D pero los constructuroes de Rectangle2D no los permiten por eso igualamos esa forma de construirlos.
     * @param puntoA Extremo A del rectángulo.
     * @param puntoB Extremo B del rectángulo.
     */
    public Rectangulo(Point2D puntoA, Point2D puntoB){  
        //Inicializamos los datos geométricos.
        datosGeometricos=new Rectangle2D.Double(puntoA.getX(), puntoA.getY(), puntoB.getX(), puntoB.getY());  
        relleno = false;
    }
    
    /**
     * Establece si el rectángulo tiene o no relleno.
     * @param nuevoRelleno Si tiene o no relleno.
     */
    public void setRelleno(boolean nuevoRelleno){
        relleno=nuevoRelleno;
    }
    
    /**
     * Intruduce un nuevo relleno.
     * @param nuevoRelleno Relleno por el que sustituir el existente.
     */
    public void setRelleno(Relleno nuevoRelleno){
        Imprimir("Introduciendo nuevo relleno."+nuevoRelleno.toString());        
        miRelleno = nuevoRelleno;     
    }
    
    /**
     * Para conocer si la figura es rellena o no.
     * @return Si está rellena o no.
     */
    public boolean getRelleno(){
        return relleno;
    }
    /**
     * Para obtener el relleno que tiene la figura.
     * @return Objeto de tipo Relleno que la figura está usando en ese momento.
     */
    public Relleno getRellenoComplejo(){
        return miRelleno;
    }
    
    //Métodos de implementación específica de la figura RECTANGULO
    
    /**
     * Para cambiar la posición de un rectángulo.
     * Implementa la funcionalidad particular propia.     
     * @param nuevoPuntoA Un extremo de la diagonal que define el rectángulo
     * @param nuevoPuntoB Otro extremo de la diagonal que define el rectángulo
     */
    @Override
    public void cambiarPosicion(Point2D nuevoPuntoA, Point2D nuevoPuntoB){
        
        /**
         * Aquí encontramos otro problema.
         * Mientras que en Line2D podíamos cambiar la posición de una linea dando la posición de una nueva linea
         * Rectangle2D no ofrece la misma función y tenemos que abstraer el funcionamiento de setFrameFromDiagonal.
         */
        A=nuevoPuntoA;
        B=nuevoPuntoB;
        ((Rectangle2D)datosGeometricos).setFrameFromDiagonal(nuevoPuntoA, nuevoPuntoB);        
    }
    
    /**
     * Construye el objeto de tipo Paint que será el relleno de la figura.
     * Para eso utiliza la variable miRelleno que posee el objeto y con la información de este
     * reconstruye el relleno que define. Es una función que se usará en varios tipos d eobjetos y podría ser 
     * interesante sacarla e implementarla para un uso general en la clase relleno por ejemplo, puede que se haga.
     * @return Relleno de la figura.
     */
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
           

           
           Double maxY=  ((Rectangle2D)datosGeometricos).getMaxY();
           
        //   Imprimir("maxY"+maxY);
           
           relleno = new GradientPaint(new Point2D.Double(0,0), miRelleno.getColorA(), new Point2D.Double(0,maxY), miRelleno.getColorB());
       }else if(miRelleno.getHorientacion()==Horientacion.HORIZONTAL){
           
           
       //    Imprimir("Configurando gradiente para horientacion HORIZONTAL");
            Double maxX=  ((Rectangle2D)datosGeometricos).getMaxX();
           
        //   Imprimir("maxx"+maxX);
           
            //Usamos de punto A el 0,0 y de be el maximo de x con 0 en y para conseguir la arista derecha del rectángulo.
            relleno = new GradientPaint(new Point2D.Double(0,0), miRelleno.getColorA(), new Point2D.Double(maxX,0), miRelleno.getColorB());
       
       }else if(miRelleno.getHorientacion()==Horientacion.DIAGONAL_A){ // TipoA:/
           Double maxY=  ((Rectangle2D)datosGeometricos).getMaxY();
           Double maxX=  ((Rectangle2D)datosGeometricos).getMaxX();
      //     Imprimir("maxY"+maxY);
      //     Imprimir("maxx"+maxX);
           relleno = new GradientPaint(new Point2D.Double(0,maxY), miRelleno.getColorA(), new Point2D.Double(maxX,0), miRelleno.getColorB());
       }else if(miRelleno.getHorientacion()==Horientacion.DIAGONAL_B){ //Tipo B: \
           Double maxY=  ((Rectangle2D)datosGeometricos).getMaxY();
           Double maxX=  ((Rectangle2D)datosGeometricos).getMaxX();
       //    Imprimir("maxY"+maxY);
       //    Imprimir("maxx"+maxX);
           relleno = new GradientPaint(new Point2D.Double(0,0), miRelleno.getColorA(), new Point2D.Double(maxX,maxY), miRelleno.getColorB());
       }
        
        
        return relleno;
    }
    
    /**
     * Cambia el modo de edición.
     * @param modo True para activarlo y false para desactivalrlo.
     */
    public void setModoEdicion(boolean modo){
        modoEdicion=modo;
    }
    
    /**
     * Para dibujar la figura en el entorno pasado.
     * Para dibujarla accedemos a sus distintos elementos y los aplicamos al entorno Graphics2D para dibujar
     * todas las características de la figura.
     * @param g2d Entorno donde dibujar la figura.
     */
    @Override
     public void dibujateEn(Graphics2D g2d){                 
         
        //Establecemos el color
        g2d.setColor(trazo.getColor());
              
        //Aplicamos el stilo que acabos de definir
        g2d.setStroke(trazo.getStroke());
                           
        //Hacemos que se dibujen los datos geométricos.
        
        
        
          AffineTransform move = new AffineTransform();
           move.translate(distanciaX,distanciaY); 
           
           AffineTransform cancelMove = new AffineTransform();
           cancelMove.translate(0,0); 

           if(moviendo){
            g2d.setTransform(move);     
           }
        
        
        if(relleno){
            //Aplicamos el paint construido a partir de los datos del relleno, almacenados en la variable miRelleno.
            g2d.setPaint(getDatosRelleno());
            //Usamos fill para que la figura se dibuje con relleno.
            g2d.fill(datosGeometricos);                        
        }else        
            //Usamos draw cuando la figura no tiene relleno.
            g2d.draw(datosGeometricos);
        
        //Si el modo edición está activado dibujamos también los puntos de control.
        if(modoEdicion){
           
           //Dibujamos uno de los extremos de la diagonal.
           Point2D extremoDiagonalA= new Point2D.Double(  ((Rectangle2D)datosGeometricos).getMinX(), ((Rectangle2D)datosGeometricos).getMinY());
           elipsePuntoControlA= new Ellipse2D.Double(extremoDiagonalA.getX()-5, extremoDiagonalA.getY()-5,10,10);
           g2d.draw(elipsePuntoControlA);
           
           //Dibujamos el otro extremo de la diagonal.
           Point2D extremoDiagonalB= new Point2D.Double(  ((Rectangle2D)datosGeometricos).getMaxX(), ((Rectangle2D)datosGeometricos).getMaxY());
           elipsePuntoControlB= new Ellipse2D.Double(extremoDiagonalB.getX()-5, extremoDiagonalB.getY()-5,10,10);
           g2d.draw(elipsePuntoControlB);
            
           
        }
        
         if(moviendo){
            g2d.setTransform(cancelMove);
        }
        
    }
     
     public void cambiarPuntosControl(Point2D puntoRef, Point2D npc){
         
         
         if(moviendo){
              //EL nuevo punto puede realizar cuantro movimientos básicos respecto al anterior.
            
            //Hacia la derecha
            if(npc.getX()>puntoRef.getX())
                distanciaX=npc.getX()-puntoRef.getX();
            //Hacia la izquierda
            if(npc.getX()<puntoRef.getX())
                distanciaX=npc.getX()-puntoRef.getX();
            
            //Hacia abajo
            if(npc.getY()>puntoRef.getY())
                distanciaY=npc.getY()-puntoRef.getY();
            //Hacia arriba
            if(npc.getY()<puntoRef.getY())
                distanciaY=npc.getY()-puntoRef.getY();
            
                                  
            Imprimir("DistanciaX: "+distanciaX+"distanciaY"+distanciaY);
         }else{
         
 
               if(seleccionadoPuntoControlA){
                    //Queremos modificar el extremo izquierdo de la figura.  
                    A=npc;
                    ((Rectangle2D)datosGeometricos).setFrameFromDiagonal(A.getX(), A.getY(), B.getX(), B.getY());

                }
                if(seleccionadoPuntoControlB){
                    //Queremos modificar el extremo derecho de la figura.
                    B=npc;
                    ((Rectangle2D)datosGeometricos).setFrameFromDiagonal(A.getX(), A.getY(), B.getX(), B.getY());
                }
         }
     
         
     
     }
 
       public void soltarRaton(Point2D ref, Point2D nuevo){
            Imprimir("Soltando el raton");
            
            if(moviendo){
                
                //Cambiamos los puntos: 
                A.setLocation(A.getX()+distanciaX, A.getY()+distanciaY);
                B.setLocation(B.getX()+distanciaX, B.getY()+distanciaY);
                
                //Modificamos la figura:
                 ((Rectangle2D)datosGeometricos).setFrameFromDiagonal(A, B);     
                
              //  elipsePuntoControlA = new Ellipse2D.Double(A.getX()-5, A.getY()-5, 10, 10);
             //   elipsePuntoControlB = new Ellipse2D.Double(B.getX()-5, B.getY()-5, 10, 10);

            }
            moviendo=false;
            
            //Después de soltar el ratón el moviviento de la figura ha cesado y se resetean los valores de las distancias:
            distanciaX=distanciaY=0;
    }
     
     /**
      * Para conocer si un punto está dentro del rectángulo.
      * @param punto Punto a comprobar.
      * @return Si está o no dentro del rectángulo.
      */
     @Override
    public boolean contiene(Point2D punto){
        
        
        seleccionadoPuntoControlA=false;
        seleccionadoPuntoControlB=false;
        
        moviendo=false;
        
        //¿Se ha seleccionado uno de los  puntos de control?//
         if(elipsePuntoControlA.contains(punto)){
             Imprimir("## Punto A del rectangulo ##!");
             this.seleccionadoPuntoControlA=true;                
             return true;
         }                         
         else if(elipsePuntoControlB.contains(punto)){
             Imprimir("## Punto B del rectangulo ##!");
             this.seleccionadoPuntoControlB=true;                
             return true;
         }else{               
                 seleccionadoPuntoControlA=false;
                 seleccionadoPuntoControlB=false;  
                 
                 //Pero si se ha seleccionado otro punto de la figura que no sea un punto de control decimos true
                 if(((Rectangle2D)datosGeometricos).contains(punto)){
                     moviendo=true;
                     return true;
                 }
                 // pero si tampoco, false
                 else
                    return false;
         }
      
    }
    
    
    /**
     * Ofrece información del rectángulo.
     * @return Texto con información geométrica básica.
     */
    @Override
    public String toString() {
        return "rectangulo "+"Origen ("+((Rectangle2D)datosGeometricos).getX()+","+((Rectangle2D)datosGeometricos).getY()+")"+
                             "Alto "+((Rectangle2D)datosGeometricos).getHeight()+
                             "Ancho "+((Rectangle2D)datosGeometricos).getWidth();
    }

    
    /**
     * Para cambiar de posición un rectángulo a partir de un punto de referencia.
     * Como pasaba con la linea al mover la figura con el ratón estamos dando un punto de referencia y es con el 
     * con el que tenemos que mover todo el rectángulo.
     * @param P Punto donde mover el rectángulo
     */
    @Override
    public void cambiarPosicion2(Point2D P) {
                     
      
    }    
    
}
