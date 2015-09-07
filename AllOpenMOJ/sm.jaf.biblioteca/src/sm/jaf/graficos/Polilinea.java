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
     * Vector de puntos que define la polilinea.
     */
    private ArrayList<puntoPolilinea>puntos;
    private int puntoControlSeleccionado;
    

     
    public Polilinea(){
        super();
        puntos = new ArrayList();
        moviendo=false;
        distanciaX=0;
        distanciaY=0;
        
        modoEdicion=false;
        
        //Creamos el objeto polilinea, con el tamaño de puntos que tengamos.
        datosGeometricos = new GeneralPath(GeneralPath.WIND_EVEN_ODD, puntos.size());                
        
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
    
    /**
     * Para calcular la diferencia entre los puntos de control.
     * Si la figura se está moviendo se calcula la diferencia entre el punto de referencia y la nueva posición 
     * para que el movimiento de todos los puntos se hagan de forma correcta.
     * @param puntoRef El punto del plano donde se hace click para coger la figura.
     * @param npc El punto donde la figura se deja tras hacer dragged o la selección de un punto de control.
     */
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
    
    /**
     * Realiza las modificaciones reales sobre todos los puntos que definen la figura.
     * @param ref Referencia 
     * @param nuevo Punto nuevo
     */
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
    
    /**
     * Para cerrar el objeto polilinea.
     */
    public void cierraPolilinea(){
        
        puntos.remove(puntos.size()-1);
        ((GeneralPath)datosGeometricos).closePath();
        
    }
    
     /**
     * Para que la figura se pinte (renderice) en el objeto Graphics2D.
     * @param entorno Entorno donde renderizar la linea.
     */
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
        throw new UnsupportedOperationException("NNO ES NECESARIA"); //To change body of generated methods, choose Tools | Templates.
    }


    /**
     * Nos dice si un punto pertenece a la Polilinea.
     * En este caso si el punto coincide con alguno de los puntos de la polilinea
     * o cualquiera otra posición que diga contains de los datos geometricos.
     * @param punto El punto a comprobar si está cerca de la linea.
     * @return True si coincide con alguno y false si no.
     */
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
                                
                if(seleccionadoOtroPunto){
                    Imprimir("Seleccionado otro punto");
                    moviendo=true;
                }
                
                //Devolvemos la respuesta.
                return seleccionadoOtroPunto;
                
            }

    }
    
    /**
     * Para conocer información sobre el objeto.
     * @return Información del objeto en un String.
     */
    @Override
    public String toString() {
        String mensaje="";
    
        mensaje+="Polilinea: \n";
        mensaje+="\t ## "+puntos.size()+" PUNTOS##\n";
        
        for(puntoPolilinea p: puntos)
            mensaje+=puntos.indexOf(p)+" ("+p.punto.getX()+","+p.punto.getY()+")\n";
        
        return mensaje;
    }
    
   
    /**
     * Clase que abstrae los puntos que forman la polilinea.
     */
    private class puntoPolilinea{
              
        //Publicos para que puedan se accedidos desde fuera con facilidad
        
        /**
         * Coordenadas del punto.
         */
        public Point2D punto;
        /**
         * Elipse que representa el punto para el modo de edicion.
         */
        public Ellipse2D puntoControl;
        /**
         * Variable de control para controlar si el punto esta en edicion.
         */
        public boolean seleccion;
        
        
        public puntoPolilinea(Point2D nuevoPunto, boolean seleccionada){
            punto=nuevoPunto;
            //Construimos el punto de control con el punto pasado, creando un elipse.
            puntoControl=new Ellipse2D.Double(nuevoPunto.getX()-5, nuevoPunto.getY()-5,10,10);
            seleccion=seleccionada;
        }
  
        /**
         * Cambia la posición del punto y asocia su punto de control. 
         * @param nuevaPosicion Punto con el que modificar el existente.
         */
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
