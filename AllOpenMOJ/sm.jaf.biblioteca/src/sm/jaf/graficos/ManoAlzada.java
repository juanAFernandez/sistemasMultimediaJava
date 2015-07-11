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
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
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
    ArrayList<puntoManoAlzada> listaPuntos;
    
    boolean moviendo=false;
    double distanciaX=0;
    double distanciaY=0;
    
    
    public ManoAlzada(){
        //Solo inicializamos el array e introducimos el primer elemento
        listaPuntos = new ArrayList();        
    }
    
    /**
     * Añadimos un nuevo punto a la lista
     * @param nuevoPunto  Punto a añadir en la lista.
     */ 
    public void addPunto(Point2D nuevoPunto){
        listaPuntos.add(new puntoManoAlzada(nuevoPunto));
        
    }
    
    @Override
    public void dibujateEn(Graphics2D g2d) {
              //Establecemos el color
        g2d.setColor(trazo.getColor());
        

        //Aplicamos el stilo que acabos de definir
        g2d.setStroke(trazo.getStroke());
        
           AffineTransform move = new AffineTransform();
           move.translate(distanciaX,distanciaY); 
           
           AffineTransform cancelMove = new AffineTransform();
           cancelMove.translate(0,0); 

           if(moviendo){
            g2d.setTransform(move);     
           }
        
        //Recorremos el vector dibujarndo todos los elementos que contiene:
        for(int i=0; i<listaPuntos.size(); i++){

            if(i==0)
                g2d.draw(new Line2D.Double(listaPuntos.get(i).punto.getX(), listaPuntos.get(i).punto.getY(), listaPuntos.get(i).punto.getX(), listaPuntos.get(i).punto.getY()));
            if(i>0)
                g2d.draw(new Line2D.Double(listaPuntos.get(i).punto.getX(), listaPuntos.get(i).punto.getY(), listaPuntos.get(i-1).punto.getX(), listaPuntos.get(i-1).punto.getY()));
            
        }
        
        //Cancelamos la transformación afin para que no afecte al resto de figuras.
        if(moviendo){
            g2d.setTransform(cancelMove);
        }
    }
    public void soltarRaton(Point2D ref, Point2D nuevo){
            Imprimir("Soltando el raton");
            
            if(moviendo){
                
                //Cambiamos TODOS LOS PUNTOS DE LA FIGURA:
                
                for(puntoManoAlzada p: listaPuntos){
                    p.punto.setLocation(p.punto.getX()+distanciaX, p.punto.getY()+distanciaY);
                    p.puntoControl = new Ellipse2D.Double(p.punto.getX()-5, p.punto.getY()-5, 10,10);            
                }

            }
            moviendo=false;
            
            //Después de soltar el ratón el moviviento de la figura ha cesado y se resetean los valores de las distancias:
            distanciaX=distanciaY=0;
    }
    
    @Override
    public void cambiarPosicion(Point2D nuevoPuntoA, Point2D nuevoPuntoB) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cambiarPosicion2(Point2D nuevaLocalizacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    public void cambiarPuntosControl(Point2D puntoRef, Point2D npc){

            Imprimir("Intentando mover figura MANO ALZADA");
            /* En el caso de querer mover la figura se usa el punto de referencia en el que se pinchó y 
            se calcula cual sería la translación que habría que hacer para llevar la figura al completo
            al punto ncp (nuevo punto control).
            */
            
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
            

    }
    
    @Override
    public boolean contiene(Point2D punto) {
                Imprimir("LLAMANDO A CONTIENE ");
        /*
        La mano alzada se compone de muchas lineas unidas entre puntos, parecida a la polilinea. Entonces si queremos
        saber si está siendo seleccionada recorreremos las lineas que definen esos puntos para ver en cual está.
        
        Como no podemos hacer 
        
        */
        
        //Al no tener puntos de control típicos para cambiar la figura, sino ques sólo la movemos, en cuanto tocamos uno la estamos moviendo.
                
        for(puntoManoAlzada p: listaPuntos)
            if(p.puntoControl.contains(punto)){
                moviendo=true;
                return true;
                
            }
            
            
        
        
        
        moviendo=false;
        return false;
    }

    @Override
    public String toString() {
        return "soy una mano alzada";
    }
    
    /**
     * Montamos una clase propia para implementar los puntos de fomra que tenga  una ellipse de control donde poder
     * ver si un punto está contenido o no.
     */
    private class puntoManoAlzada{
        public Point2D punto;
        public Ellipse2D puntoControl;
        
        public puntoManoAlzada(Point2D pasado){
            punto= new Point2D.Double(pasado.getX(), pasado.getY());
            puntoControl = new Ellipse2D.Double(pasado.getX()-5, pasado.getY()-5, 10,10);            
        }
    }
    
}
