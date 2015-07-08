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
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;


/**
 * Clase que implementa el "trazo" para poder cambiar cosas particulares del stroke que le falta a la interfaz de esta clase de Java2D.
 * Para esto se hace uso de BasicStroke de Java2D.
 * @see <a href="http://docs.oracle.com/javase/7/docs/api/java/awt/BasicStroke.html">BasicStroke</a>
 * @author Juan A. Fernández Sánchez
 */
public class Trazo {
    
    /**
     * La decoración de los finales de linea.
     */
    private int cap;
    
    /**
     * La decoración en la unión de segementos.
     */
    private int join;
    
    
    /**
     * El patrón de discontinuidad.
     */
    private float[] patronDiscontinuidad;

    
    /**
     * Para el color.
     */
    private Color color;
    
    /**
     * El grosor de la linea.
     */
    private int grosorLinea;
    
    /**
     * Necesario para poder aplicar todos los anteriores excepto el color.
     */
    private Stroke trazo;
    
    
    /**
     * El trazo por defecto.
     */
    public Trazo(){
        
        //El color es negro:
        color = Color.BLACK;
        
        //El grosor de la linea:
        grosorLinea=1;
        
        //El final de las lineas es el primero:
        cap = BasicStroke.CAP_BUTT;
    
        //La unión de esquinas es la más simple:
        join = BasicStroke.JOIN_BEVEL;
        
        //El patron de discontinuidad es simple (linea continua) 
        patronDiscontinuidad = new float[8];
        patronDiscontinuidad[0]=1f;
        for(int i=1; i<8; i++) patronDiscontinuidad[i]=0f;
        
        //Donde se comprime todod en el Stroke para aplicarlo de golpe.
        trazo = new BasicStroke(grosorLinea, cap, join, 1.0f, patronDiscontinuidad, 0.0f);       
     
    };
    
    /**
     * Cambia el grosor del trazo.
     * @param nuevoGrosor Nuevo valor para el grosor.
     */
    public void setGrosor(int nuevoGrosor){
        //Imprimir("Cambiando el grosor a "+nuevoGrosor);
        grosorLinea=nuevoGrosor;
        trazo = new BasicStroke(grosorLinea, cap, join, 1.0f, patronDiscontinuidad, 0.0f);  
    }
    
    /**
     * Para conocer el grosor del trazo.
     * @return El tamaño del grosor del trazado actual
     */
    public int getGrosor(){
        return grosorLinea;
    }
    /**
     * Para cambiar el color del trazado.     
     * @param nuevoColor Objeto de tipo Color para ajustar color en el trazo.
     */
    public void setColor(Color nuevoColor){
        //Imprimir("Cambiando el color a "+nuevoColor.toString());
        color=nuevoColor;
        trazo = new BasicStroke(grosorLinea, cap, join, 1.0f, patronDiscontinuidad, 0.0f);  
    }
    /**
     * Devuelve el color usado en el trazo.
     * @return El color usado en el trazo.
     */    
    public Color getColor(){
        return color;
    }
    /**
     * Ajusta el tipo de decoración del trazo.
     * @param decoracion Tipo de decoración
     */
    public void setDecoracionFinalLinea(int decoracion){
        cap=decoracion;
        trazo = new BasicStroke(grosorLinea, cap, join, 1.0f, patronDiscontinuidad, 0.0f);  
    }                
    /**
     * Devuelve el tipo de decoración usado al final de la linea. 
     * @return Entero con el tipo de decoración.
     */
    public int getDecoracionFinalLinea(){
        return cap;
    }
    /**
     * Ajusta el tipo de decoración en la unión de las lineas. 
     * @param decoracion Entero que especifica el tipo de decoración.
     */
    public void setDecoracionUnionLineas(int decoracion){
        join=decoracion;
        trazo = new BasicStroke(grosorLinea, cap, join, 1.0f, patronDiscontinuidad, 0.0f);  
    }
    /**
     * Devuelve el tipo de decoración en la unión de las lineas.
     * @return Devuelve el entero que especifica el tipo de decoración para la unión de lineas.
     */
    public int getDecoracionUnionLineas(){
        return join;
    }
    
    /**
     * Ajusta el partron de discontinuidad del trazado.
     * @param patron Vector de float que especifica el tipo de patrón.
     */
    public void setPatronDiscontinuidad(float[] patron){
    
        //Si el patrón no tiene 8 elementos no debería dejar que lo intentase copiar.
        patronDiscontinuidad = new float [patron.length];
        for(int i=0; i<patron.length; i++)
            patronDiscontinuidad[i]=patron[i];
        // TB: System.arraycopy(patron, 0, patronDiscontinuidad, 0, patron.length);
        
        //Imprimir("\n\nAQUI patron aplicado: ");
        //for(int i=0; i<8; i++)
          //  System.out.print(patronDiscontinuidad[i]+" "); 
        
        trazo = new BasicStroke(grosorLinea, cap, join, 1.0f, patronDiscontinuidad, 0.0f); 
        
    }
    
    /**
     * Devuelve el tipo de patron de discontinuidad del trazado.
     * @return Vector de float con el patrón de discontinuidad.
     */
    public float[] getPatronDiscontinuidad(){
        return patronDiscontinuidad;
    }
    
    /**
     * ##### CONSTRUCTOR DE COPIAS ######
     * @param nuevoTrazoCompleto Objeto a copiar
     */
    public void setCopiaTrazo(Trazo nuevoTrazoCompleto){
        this.setColor(nuevoTrazoCompleto.getColor());
        this.setGrosor(nuevoTrazoCompleto.getGrosor());
        this.setDecoracionFinalLinea(nuevoTrazoCompleto.getDecoracionFinalLinea());
        this.setDecoracionUnionLineas(nuevoTrazoCompleto.getDecoracionUnionLineas());                        
        this.setPatronDiscontinuidad(nuevoTrazoCompleto.getPatronDiscontinuidad());
    }
    
    /**
     * Devuelve el tipo de trazo.
     * @return Objeto de tipo Stroke.
     */
    public Stroke getStroke(){
        return trazo;
    }
    
    /**
     * Devuelve una cadena de texto con información sobre el objeto Trazo.
     * @return Cadena de texto.
     */
    @Override
    public String toString(){
        return "Info de trazo: "
                +color.toString()
                +"linea "+grosorLinea
                +"discontinuidad"+
                this.patronDiscontinuidad.toString();
    }
    
}
