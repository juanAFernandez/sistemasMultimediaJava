/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jaf.graficos;

import static extras.Imprimir.Imprimir;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;
import sm.jaf.graficos.Relleno.Horientacion;

/**
 *
 * @author Juan A. Fernández Sánchez
 */
public class RectanguloRedondeado extends Figura{
    
    private boolean relleno;
    
    //public Paint rellenoComplejo;
    
    public Relleno miRelleno;
    
     /**
     * Primer constructor sin parámetros
     */
    public RectanguloRedondeado(){
        datosGeometricos=new RoundRectangle2D.Double();
        relleno = false;
    }
    /**
     * Segundo constructor con parámetros.
     * Adaptación del constructor al constructor de RoundREctangle2D
     * @param puntoA Extremo A del rectángulo.
     * @param puntoB Extremo B del rectángulo.
     */
    public RectanguloRedondeado(Point2D puntoA, Point2D puntoB){        
       // datosGeometricos=new RoundRectangle2D.Double(puntoA.getX(), puntoA.getY(), puntoB.getX(), puntoB.getY());  
        
     //   datosGeometricos=new RoundRectangle2D.Double();
        datosGeometricos=new RoundRectangle2D.Double(puntoA.getX(), puntoA.getY(), 10, 10, 20, 20);
        //((RoundRectangle2D)datosGeometricos).setFrameFromDiagonal(puntoA, puntoB);
        
        
        relleno = false;
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
    public Relleno getRellenoComplejo(){return miRelleno;}
    
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
        
        //Primero creamos el nuevo rectángulo a introduciendo los datos de los bordes ya que no tiene un método específico para ello.
        ((RoundRectangle2D)datosGeometricos).setRoundRect(0, 0, 0, 0, 20, 20);        
        //Después especificamos la diagonal con los puntos pasados.
        ((RoundRectangle2D)datosGeometricos).setFrameFromDiagonal(nuevoPuntoA, nuevoPuntoB);  
        //No es una manera elegando de hacerlo pero funciona y suple la falta de métodos específicos de RoundRectangle2D
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
           

           
           Double maxY=  ((RoundRectangle2D)datosGeometricos).getMaxY();
           
        //   Imprimir("maxY"+maxY);
           
           relleno = new GradientPaint(new Point2D.Double(0,0), miRelleno.getColorA(), new Point2D.Double(0,maxY), miRelleno.getColorB());
       }else if(miRelleno.getHorientacion()==Horientacion.HORIZONTAL){
           
           
       //    Imprimir("Configurando gradiente para horientacion HORIZONTAL");
            Double maxX=  ((RoundRectangle2D)datosGeometricos).getMaxX();
           
        //   Imprimir("maxx"+maxX);
           
            //Usamos de punto A el 0,0 y de be el maximo de x con 0 en y para conseguir la arista derecha del rectángulo.
            relleno = new GradientPaint(new Point2D.Double(0,0), miRelleno.getColorA(), new Point2D.Double(maxX,0), miRelleno.getColorB());
       
       }else if(miRelleno.getHorientacion()==Horientacion.DIAGONAL_A){ // TipoA:/
           Double maxY=  ((RoundRectangle2D)datosGeometricos).getMaxY();
           Double maxX=  ((RoundRectangle2D)datosGeometricos).getMaxX();
      //     Imprimir("maxY"+maxY);
      //     Imprimir("maxx"+maxX);
           relleno = new GradientPaint(new Point2D.Double(0,maxY), miRelleno.getColorA(), new Point2D.Double(maxX,0), miRelleno.getColorB());
       }else if(miRelleno.getHorientacion()==Horientacion.DIAGONAL_B){ //Tipo B: \
           Double maxY=  ((RoundRectangle2D)datosGeometricos).getMaxY();
           Double maxX=  ((RoundRectangle2D)datosGeometricos).getMaxX();
       //    Imprimir("maxY"+maxY);
       //    Imprimir("maxx"+maxX);
           relleno = new GradientPaint(new Point2D.Double(0,0), miRelleno.getColorA(), new Point2D.Double(maxX,maxY), miRelleno.getColorB());
       }
        
        
        return relleno;
    }
    
    @Override
     public void dibujateEn(Graphics2D g2d){
        
         Imprimir("Dibujando en");
         
        //Establecemos el color
        g2d.setColor(trazo.getColor());
              
        //Aplicamos el stilo que acabos de definir
        g2d.setStroke(trazo.getStroke());
        
        
        //PRUEBAS
        //APlicamos el relleno a partir de los datos de relleno y la forma de la figura.
        
//        Color a=miRelleno.getColorA();
    //    Color b=miRelleno.getColorB();
        
   
      //Se cancela para meterlo dentro de if(relleno)  
     //   g2d.setPaint(getDatosRelleno());
        
        //ELIMINAME ATRÁS
        
       
        
        //Hacemos que se dibujen los datos geométricos.
        
        if(relleno){
            //Aplicamos el paint construido a partir de los datos del relleno.
            g2d.setPaint(getDatosRelleno());
            g2d.fill(datosGeometricos);
            
            
        }else        
            g2d.draw(datosGeometricos);
    }
    
     
     public void configuraRelleno(Color a, Color b, Horientacion h){
         
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
                     
        ((RoundRectangle2D)datosGeometricos).setFrame(pos.getX(), pos.getY(), datosGeometricos.getBounds2D().getWidth(), datosGeometricos.getBounds2D().getHeight());

    }
    
}
