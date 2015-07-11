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

    
    /**
     * Los puntos que definen la polilinea.
     */
    private ArrayList<puntoPolilinea>puntos;
    private int puntoControlSeleccionado;
    
    boolean moviendo=false;
    double distanciaX=0;
    double distanciaY=0;
    
    
    
    
    
    private boolean modoEdicion=false;
    
    
    public Polilinea(){
        super();
        puntos = new ArrayList();
        
        //Creamos el objeto polilinea, con el tamaño de puntos que tengamos.
        datosGeometricos = new GeneralPath(GeneralPath.WIND_EVEN_ODD, puntos.size());
        
        //Inicializamos los datos geométricos:
        
    }
    
    /**
     * Añade un punto nuevo a la polilinea.
     * @param nuevoPunto 
     */
    public void addPunto(Point2D nuevoPunto){
      
        Imprimir("AÑADIENDO NUEVO PUNTO, total:"+puntos.size());
               
        /*Camos a comprobar si el punto que añadimos cierra la figura. */
        puntos.add(new puntoPolilinea(nuevoPunto, false ));
        
    }
    
     /**
     * Cambia el modo de edición.
     * @param modo True para activarlo y false para desactivalrlo.
     */
    public void setModoEdicion(boolean modo){
        modoEdicion=modo;
    }
    
    public void cambiarPuntosControl(Point2D puntoRef, Point2D npc){
        if(moviendo){
            Imprimir("Intentando mover figura");
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
            
                                   
            
            
        }else{                    
            puntos.get(puntoControlSeleccionado).cambiar(npc);
        }
    }
    
    public void soltarRaton(Point2D ref, Point2D nuevo){
            
            /**
             * Si la figura se está moviendo se realiza el cambio de su posición, en caso contrario se estará
             * modificando un punto de control y esta función no hace nada.
             */
            if(moviendo){
                //Pruebas: una vez calculadas las distancias se las aplicamos a todos los puntos de la polilinea, incluidos los puntos de control
                for(puntoPolilinea p: puntos){
                    p.punto.setLocation(p.punto.getX()+distanciaX, p.punto.getY()+distanciaY);
                    p.puntoControl=new Ellipse2D.Double(p.punto.getX()-5, p.punto.getY()-5, 10, 10);
                }
            }
            moviendo=false;
            
    }
    public void cierraPolilinea(){
        
        puntos.remove(puntos.size()-1);
        ((GeneralPath)datosGeometricos).closePath();
        
    }
    
    @Override
    public void dibujateEn(Graphics2D entorno) {
        
        Imprimir(" ############################ Llamando a dibujar POLILINEA");
        
        
        
        Imprimir("Construyendo polilinea de "+puntos.size()+" puntos");
       
        datosGeometricos = new GeneralPath(GeneralPath.WIND_EVEN_ODD, puntos.size());
        
        //Iniciamos la polilinea con el primer punto
        ((GeneralPath)datosGeometricos).moveTo(puntos.get(0).punto.getX(), puntos.get(0).punto.getY());
            
        
        for(int i=1; i<puntos.size(); i++)
            ((GeneralPath)datosGeometricos).lineTo(puntos.get(i).punto.getX(),puntos.get(i).punto.getY());            
            

        if(moviendo){
          
           AffineTransform move = new AffineTransform();
           move.translate(distanciaX,distanciaY);                   
           entorno.setTransform(move);
          
        }
           
        //Dibujamos la polilinea    
        entorno.draw(datosGeometricos);
   
        //Si el modo de edición está activo
         if(modoEdicion){
                
            //Además de dibujar la linea dibujamos puntos en las esquinas de la polilinea.
            for(puntoPolilinea p: puntos)
                entorno.draw(p.puntoControl);

          
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
        
        
        moviendo=false;
        
        //1º Comprobamos si ha sido seleccionado 
            boolean haSidoSeleccionadoAlguno=false;
            //Recorremos el vector de puntos a ver si alguno ha sido seleccionado:
            for(puntoPolilinea p: puntos)
                if(p.puntoControl.contains(punto)){
                    Imprimir("Seleccionado punto "+puntos.indexOf(p)+" ");
                    haSidoSeleccionadoAlguno=true;
                    moviendo=false;
                    puntoControlSeleccionado=puntos.indexOf(p);
                }
        
        //2º Si ha sido seleccionado alguno devolvemos true:
            if(haSidoSeleccionadoAlguno)
                return true;
            
        //3º Si no, comprobamos si ha sido seleccionado algún otro punto de la polilinea
            else{
                
                //Vemos si ha sido o no seleccionado
                
                
                boolean seleccionadoOtroPunto=((GeneralPath)datosGeometricos).contains(punto);
                
                
                
                    /**
                     * 
                     * IMPORTANTE:.
                     * Hay que solucional la selección de la polilinea. Si no se ha cerrado el path , cosa que
                     * podremos hacer si el utlimo punto contiene ela rimera ellipse. Tendremos que ir formardo lineas
                     * entre entre los puntos y usar el contanis de linea que hicimos nosotros para comprobar si se ha seleecionado
                     * y poder moverla.
                     * No supone demasiada complicación sólo un poco de trabajo.
   
                     * 
                     */
                
                
                
                
                if(seleccionadoOtroPunto){
                    Imprimir("Seleccionado otro punto");
                    moviendo=true;
                }
                
                //Devolvemos la respuesta.
                return seleccionadoOtroPunto;
                
            }

    }

    @Override
    public String toString() {
        return "Polilinea de";// "+puntos.size()+" puntos.";
    }
    
    
    /**
     * Clase que abstrae los puntos que forman la polilinea.
     */
    private class puntoPolilinea{
              
        //Publicos para que puedan se accedidos desde fuera con facilidad.
        
        public Point2D punto;
        public Ellipse2D puntoControl;
        public boolean seleccion;
        
        
        public puntoPolilinea(Point2D nuevoPunto, boolean seleccionada){
            punto=nuevoPunto;
            //Construimos el punto de control con el punto pasado, creando un elipse.
            puntoControl=new Ellipse2D.Double(nuevoPunto.getX()-5, nuevoPunto.getY()-5,10,10);
            seleccion=seleccionada;
        }
  
        public void cambiar(Point2D nuevaPosicion){
            //Cambiamos el punto
            punto= new Point2D.Double(nuevaPosicion.getX(), nuevaPosicion.getY());
            //Construimos un nuevo punto de control
            puntoControl=new Ellipse2D.Double(nuevaPosicion.getX()-5, nuevaPosicion.getY()-5, 10, 10);
            //Especificamos que no está seleccionado
            seleccion=false;
        }
        
    }
    
}
