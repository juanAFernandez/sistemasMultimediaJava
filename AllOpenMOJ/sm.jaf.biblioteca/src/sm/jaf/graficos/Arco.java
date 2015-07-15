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
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 * Clase que implementa la figura ARCO.
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/awt/geom/Arc2D.html">Clase Arc2D</a>
 * @author Juan A. Fernández Sánchez
 */
public class Arco extends Figura {

    
    /**
     * Para la selección del modo edición.
     */
    private boolean modoEdicion;
    
    /**
     * Variables del primer punto de control.
     */
    private Point2D puntoControlA;
    private Ellipse2D elipsePuntoControlA;    
    boolean seleccionadoPuntoControlA;
    
    /**
     * Variables para el segundo punto de control.
     */
    private Point2D puntoControlB;  
    private Ellipse2D elipsePuntoControlB;    
    boolean seleccionadoPuntoControlB;
    
    /**
     * Variables para el tercer punto de control.
     */
    private Point2D puntoControlC;  
    private Ellipse2D elipsePuntoControlC;    
    boolean seleccionadoPuntoControlC;
    
    
    /**
     * Radio de la circunferencia donde se inscribe el arco.
     */
    private double radio;
    /**
     * Ángulo que define el inicio del arco.
     */
    private double gradosInicio;
    /**
     * Ángulo que define el fin del arco.
     */
    private double gradosFin;
    /**
     * Punto que define el centro del circulo der arco.
     */
    private Point2D centro;
    
    
    
    
    
     /**
     * Primer constructor sin parámetros.
     * Sólo inicializa los datos geométricos con una Line2D de la Java2D.
     */
    public Arco(){
        
        //Inicializamos los datos geométricos
        datosGeometricos=new Arc2D.Double(50, 50,
                         50,
                         50,
                         0, 360,
                         Arc2D.OPEN);
        
        //Las variables de las instancias:
        puntoControlA = new Point2D.Double();       
        seleccionadoPuntoControlA=false;    
        puntoControlB = new Point2D.Double();        
        seleccionadoPuntoControlB=false;        
        puntoControlC = new Point2D.Double();        
        seleccionadoPuntoControlC=false;
       
        modoEdicion=false;
        
        
    }
    
    /**
     * Para cambiar cualquiera de los puntos de control de la figura.
     * @param npc  Nuevo punto para cambiar por cualquier punto de control.
     */
    public void cambiarPuntosControl(Point2D npc){
        /**
         * En la función "public boolean contiene(Point2D punto)" se comprueba si el punto
         * pasado desde el lienzo pertenece a uno de los puntos de control de la figura. 
         * En caso de que sea así se comprueba de cual se trata de los dos que hay disponibles y se guarda en una variable.
         * Ahora se va a modificar un punto de control y se modificará aqué que nos diga su variable que se puede modificar que 
         * esta función dijo.         
         */
        
        /**
         * Almacenamos los grados en un vector para hacer el código más compacto.
         */
        double grados[] = {gradosInicio, gradosFin};        
        int mod=0; // Para que grados[mod] sea los grados que cualquiera de los dos puntos modificado, para ambos es el mismo cálculo
        //aunque su pos en la función final cambie.
        
        //Para los dos tipos de operaciones que podemos hacer:
        boolean cambiarAngulos =false, cambiarTamaño = false;
        
        
        //Elegimos el tipo de modificación a realizar dependiendo del punto de control seleccionado.
        
            //Modificación del punto de control A: grados del fin del arco.
            if(seleccionadoPuntoControlA){ mod=1; cambiarAngulos=true; }
            //Modificación de los grados de inicio del arco.
            if(seleccionadoPuntoControlB){ mod=0; cambiarAngulos=true; }           
            //Modificación del tamaño del círculo a través de su radio.
            if(seleccionadoPuntoControlC){cambiarTamaño=true;}
        
            /**
             * Importante.
             * Si no ha seleccionado ningún punto de control pero si un punto de la figura lo que se está indicando
             * es que se quiere mover por lo que mandamos un mensaje a otra función específica para eso.
             */
            if(!seleccionadoPuntoControlA && !seleccionadoPuntoControlB && !seleccionadoPuntoControlC )
                cambiarPosicion2(npc);
        
        if(cambiarAngulos){
            
            /**Proceso.
             * Si modificamos el punto de control A o B estamos modificando el ángulo de fin o inicio de la figura, por lo tanto
            tenemos que convertir esa posición 2D en un angulo respecto al eje X para modificar los datos geom de la fig.
            */
         
            //1º Calculamos la distancia entre el centro de la circunferencia y la nueva posición para tener una hipotenusa
            //con la que usar trigonometría.
                double h=Math.sqrt(   Math.pow(centro.getX()-npc.getX(),2)  +  Math.pow(centro.getY()-npc.getY(),2)    );
                Imprimir("Hipotenusa: "+h);
            
            //2º Calculamos el catetoY
          
                double catetoY;
                if(centro.getY()>npc.getY()){
                    catetoY=centro.getY()-npc.getY();
                }else{
                    catetoY=npc.getY()-centro.getY();
                }
                
                Imprimir("Cateto: "+catetoY);
                
            //3º Calculamos los grados del angulo correspondiente
                grados[mod]=Math.toDegrees(Math.asin(catetoY/h));
                
            
            //4º Detección del cuadrante del círculo
                int cuadrante=0;
                if(npc.getX()>=centro.getX() && npc.getY()<=centro.getY())
                    cuadrante=1;
                if(npc.getX()>=centro.getX() && npc.getY()>=centro.getY())
                    cuadrante=4;
                if(npc.getX()<=centro.getX() && npc.getY()<=centro.getY())
                    cuadrante=2;
                if(npc.getX()<=centro.getX() && npc.getY()>=centro.getY())
                    cuadrante=3;                                
                
                Imprimir("Cuadrante: "+cuadrante);
                                                               
            //5º Según el cuadrante realizaremos el cálculo del ángulo de una u otra forma.
                //Para el cuadrante 1 no es necesaria ninguna modificación.
                if(cuadrante==2){
                    //Le sumamos a 90 la diferencia de 90 - el angulo calculado.
                    grados[mod]=90+(90-grados[mod]);
                }
                if(cuadrante==3){    
                    //Sumamos 180 grados
                    grados[mod]+=180;
                }
                if(cuadrante==4){                  
                    //Sumamos a 260 (inicio del cuarto cuadrante) 90 - el ángulo calulado)
                    grados[mod]=270+(90-grados[mod]);                    
                }

            //6º Realizamos finalmente la modificación de la figura.
                     
                ((Arc2D)datosGeometricos).setArcByCenter(centro.getX(), centro.getY(), radio, grados[0], grados[1]-grados[0], Arc2D.OPEN);
       
            //7º Almacenamos los calculos en los valores de la figura.
                
                gradosInicio=grados[0];
                gradosFin=grados[1];
                
                Imprimir("Grados inicio: "+grados[0]+" Grados fin: "+grados[1]);
        } 
        
        //SI lo que se está haciendo es cambar el tamaño de la figura
        if(cambiarTamaño){            
            //Calculamos el nuevo radio con el centro y el punto que modificamos.
            double newRadio=Math.sqrt(   Math.pow(centro.getX()-npc.getX(),2)  +  Math.pow(centro.getY()-npc.getY(),2)    );
            this.radio=newRadio;
            //Aplicamos los cambios.
            ((Arc2D)datosGeometricos).setArcByCenter(centro.getX(), centro.getY(), radio, grados[0], grados[1]-grados[0], Arc2D.OPEN);
            
        }

        
    }
    
    /**
     * Para dibujar la figura en un objeto Graphics2D.
     * @param entorno Entorno donde dibujar la figura, objeto de tipo Graphics2D.
     * @see <a href="http://docs.oracle.com/javase/7/docs/api/java/awt/Graphics2D.html">Clase Graphics2D</a>
     */
    @Override
    public void dibujateEn(Graphics2D entorno) {
        
        //Establecemos el color
        entorno.setColor(trazo.getColor());
        
        //Aplicamos el stilo que acabos de definir
        entorno.setStroke(trazo.getStroke());
        
         //Hacemos que se dibujen los datos geométricos.
        entorno.draw(datosGeometricos);
        
        
        //Si se está en modo edición se dibujan algunos detalles más que ayuden a la edición de la figura Arco.
        if(modoEdicion){
            
            
            /**
             * ## ¡Atencion! ##.
             * Esta forma de calcular los puntos que servirán para la edición del usuario sólo nos sirven cuando 
             * la "elipse" en la que se basa el arco es un circulo. Ya que al calcular el radio como la diferencia
             * entre los puntos en X (diametro) dividido entre dos : radio=(((Arc2D)datosGeometricos).getMaxX()-((Arc2D)datosGeometricos).getMinX())/2;
             * estamos asumiendo que se trata de una circunferencia perfecta, en cuanto estemos trazando una elipse donde el radio 
             * no es uniforme esto deja de funcionar. 
             * Se podría complicar el calculo del radio para que esto no le afectase pero esto quedará así para esta primera 
             * versión del editor de la figura Arco.             
             */
            
            
            
            //Dibujamos el eje central.
            entorno.draw(new Ellipse2D.Double(((Arc2D)datosGeometricos).getCenterX()-5,((Arc2D)datosGeometricos).getCenterY()-5,10,10));
            
           double radio=(((Arc2D)datosGeometricos).getMaxX()-((Arc2D)datosGeometricos).getMinX())/2;
           //Para que el cálculo funcione cogemos los grados como si siempre empezaran desde el origen, por eso los sumamos.
           double angulo=(((Arc2D)datosGeometricos).getAngleExtent()+((Arc2D)datosGeometricos).getAngleStart());
           
        //   Imprimir("Radio: "+radio+"\n Ángulo respecto a X: "+angulo+"grados");
        //   Imprimir("centro: "+((Arc2D)datosGeometricos).getCenterX()+" "+((Arc2D)datosGeometricos).getCenterY());
        //   Imprimir("Coseno del angulo: "+Math.cos(angulo));
        //   Imprimir("Seno del angulo: "+Math.sin(angulo));
           //radio=hipotenusa
           Point2D A = new Point2D.Double(((Arc2D)datosGeometricos).getCenterX()+(radio*Math.cos(Math.toRadians(angulo))), ((Arc2D)datosGeometricos).getCenterY()-(radio*Math.sin(Math.toRadians(angulo))));
           
        //   Imprimir("PuntoA("+A.getX()+","+A.getY()+")");
           
           //Con toda la información creamos la Ellipse2D que forma el punto del angulo inicial:
           this.elipsePuntoControlA = new Ellipse2D.Double(A.getX()-5,A.getY()-5,10,10);
           
          // old:  entorno.draw(new Ellipse2D.Double(A.getX()-5,A.getY()-5,10,10));
           
           entorno.draw(elipsePuntoControlA);
           
            
           angulo = ((Arc2D)datosGeometricos).getAngleStart();
           Point2D B = new Point2D.Double(((Arc2D)datosGeometricos).getCenterX()+(radio*Math.cos(Math.toRadians(angulo))), ((Arc2D)datosGeometricos).getCenterY()-(radio*Math.sin(Math.toRadians(angulo))));
           
           elipsePuntoControlB= new Ellipse2D.Double(B.getX()-5,B.getY()-5,10,10);
           
           entorno.draw(elipsePuntoControlB);
           
           
           //Dibujamos también el punto de control para el tamaño.
           angulo=(gradosFin+gradosInicio)/2;
           Point2D C = new Point2D.Double(((Arc2D)datosGeometricos).getCenterX()+(radio*Math.cos(Math.toRadians(angulo))), ((Arc2D)datosGeometricos).getCenterY()-(radio*Math.sin(Math.toRadians(angulo))));
           elipsePuntoControlC= new Ellipse2D.Double(C.getX()-5,C.getY()-5,10,10);
           
           entorno.draw(elipsePuntoControlC);
           
        }
        
    }

    /**
     * Cambia la posición de la figura a través de la modificación de la diagonal principal que define a la elipse
     * que segmenta el arco.
     * Así puede tanto cambiarse de tamaño como de posición en el plano.
     * @param A Centro del circulo inscrito del arco.
     * @param B Distancia respecto al punto A que conforma el radio del circulo inscrito al arco.
     */
    @Override
    public void cambiarPosicion(Point2D A, Point2D B) {        
        Imprimir("Cambiando tamaño de arco");
      
        /**
         * Problema! || Forzamos la creación de un circulo, no nos sirve que se trate de una elipse, explicación: 
         * .
         * Para la vista de edición de esta figura queremos añadir dos puntos donde los angulos cortan la elipse con 
         * la que se crea el arco, se explica en la función dibujateEn mejor, y por simplicidad de los cálculos necesitamos
         * que no se pueda crear una elipse, sino que siempre sea un circulo y para ello vamos a usar otra función 
         * a las típicas:
         *  ((Arc2D)datosGeometricos).setFrameFromDiagonal(nuevoPuntoA, nuevoPuntoB);  //El radio no es el mismo siempre.
         *  ((Arc2D)datosGeometricos).setFrameFromCenter(nuevoPuntoA, nuevoPuntoB);    //El radio no es el mismo siempre.   
         * 
         * Vamos a usar setArcByCenter que requiere un punto central y un radio y ese radio lo obtenemos
         * como la distancia entre los puntos que nos pasan, que pueden ser dos puntos cualesquiera en el plano.
        */
        
        //Distancia para nosotros será radio.
        double distancia=Math.sqrt(   Math.pow(B.getX()-A.getX(),2)  +  Math.pow(B.getY()-A.getY(),2)    );
        radio=distancia;
         gradosInicio=45;
         gradosFin=90;
         centro=A;
        
        ((Arc2D)datosGeometricos).setArcByCenter(A.getX(), A.getY(), distancia, gradosInicio, gradosFin-gradosInicio, Arc2D.OPEN);
        
    }
    
    /**
     * Cambia el modo de edición.
     * @param modo True para activarlo y false para desactivalrlo.
     */
    public void setModoEdicion(boolean modo){
        modoEdicion=modo;
    }
    
    /**
     * Para cambiar la posición completa de la figura a partir de un nuevo punto proporcionado.
     * @param nuevaLocalizacion 
     */
    @Override
    public void cambiarPosicion2(Point2D nuevaLocalizacion) {
        //((Arc2D)datosGeometricos).setFrame(nuevaLocalizacion.getX(), nuevaLocalizacion.getY(), datosGeometricos.getBounds2D().getWidth(), datosGeometricos.getBounds2D().getHeight());
        centro=nuevaLocalizacion;
        ((Arc2D)datosGeometricos).setArcByCenter(centro.getX(), centro.getY(), radio, gradosInicio, gradosFin-gradosInicio, Arc2D.OPEN);
    }

    /**
     * Para conocer si un punto pasado pertenece a la figura, sea conteniendolo o perteneciendo a un punto de control.
     * @param punto Punto con el que comparar las partes de las figuras.
     * @return True si el punto coincide con la figura o con alguno de sus puntos de control.
     */
    @Override
    public boolean contiene(Point2D punto) {
        
        //Inicializamos a false
        seleccionadoPuntoControlA=false;
        seleccionadoPuntoControlB=false;
        seleccionadoPuntoControlC=false;
                
         //¿Se ha seleccionado uno de los  puntos de control?//
         if(elipsePuntoControlA.contains(punto)){
             Imprimir("## Punto A del ARCO ##!");
             this.seleccionadoPuntoControlA=true;                
             return true;
         }                         
         else if(elipsePuntoControlB.contains(punto)){
             Imprimir("## Punto B del ARCO ##!");
             this.seleccionadoPuntoControlB=true;                
             return true;
         }
         else if(elipsePuntoControlC.contains(punto)){
             Imprimir("## Punto C del ARCO ##!");
             this.seleccionadoPuntoControlC=true;
             return true;
         }         
         else{               
                 seleccionadoPuntoControlA=false;
                 seleccionadoPuntoControlB=false;  
                 seleccionadoPuntoControlC=false;
                 //Pero si se ha seleccionado otro punto de la figura que no sea un punto de control decimos true
                 if(((Arc2D)datosGeometricos).contains(punto))
                     return true;
                 // pero si tampoco, false
                 else
                    return false;
         }
         
         
         
         
    }

    /**
     * Ofrece informacion sobre los datos geometricos de la figura.
     * @return Una cadena de texto con la informacion.
     */
    @Override
    public String toString() {
        String mensaje="";
    
        mensaje+="Arco: \n";
        mensaje+="\t Centro: ("+centro.getX()+","+centro.getY()+") \n";
        mensaje+="\t Radio: "+radio+"\n";
        mensaje+="\t Grados Inicio: "+gradosInicio+" Grados Final: "+gradosFin+"\n";
        
        return mensaje;
    }
    
}
