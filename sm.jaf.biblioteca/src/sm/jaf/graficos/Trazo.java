/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jaf.graficos;


import static extras.Imprimir.Imprimir;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;


/**
 * Clase que implementa el "trazo" para poder cambiar cosas particulares del stroke
 * que le falta a la interfaz de esta clase de Java2D.
 * 
 * Por ahora es solo una prueba.
 * 
 *
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
    
    public void setGrosor(int nuevoGrosor){
        Imprimir("Cambiando el grosor a "+nuevoGrosor);
        grosorLinea=nuevoGrosor;
        trazo = new BasicStroke(grosorLinea, cap, join, 1.0f, patronDiscontinuidad, 0.0f);  
    }
    public int getGrosor(){
        return grosorLinea;
    }
    public void setColor(Color nuevoColor){
        Imprimir("Cambiando el color a "+nuevoColor.toString());
        color=nuevoColor;
        trazo = new BasicStroke(grosorLinea, cap, join, 1.0f, patronDiscontinuidad, 0.0f);  
    }
    public Color getColor(){
        return color;
    }
    public void setDecoracionFinalLinea(int decoracion){
        cap=decoracion;
        trazo = new BasicStroke(grosorLinea, cap, join, 1.0f, patronDiscontinuidad, 0.0f);  
    }
    public int getDecoracionFinalLinea(){
        return cap;
    }
    public void setDecoracionUnionLineas(int decoracion){
        join=decoracion;
        trazo = new BasicStroke(grosorLinea, cap, join, 1.0f, patronDiscontinuidad, 0.0f);  
    }
    public int getDecoracionUnionLineas(){
        return join;
    }
    
    
    public void setPatronDiscontinuidad(float[] patron){
    
        //Si el patrón no tiene 8 elementos no debería dejar que lo intentase copiar.
        patronDiscontinuidad = new float [patron.length];
        for(int i=0; i<patron.length; i++)
            patronDiscontinuidad[i]=patron[i];
        // TB: System.arraycopy(patron, 0, patronDiscontinuidad, 0, patron.length);
        
        Imprimir("\n\nAQUI patron aplicado: ");
        for(int i=0; i<8; i++)
            System.out.print(patronDiscontinuidad[i]+" ");        
        trazo = new BasicStroke(grosorLinea, cap, join, 1.0f, patronDiscontinuidad, 0.0f); 
        
    }
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
    
    public Stroke getStroke(){
        return trazo;
    }
    
    @Override
    public String toString(){
        return "Info de trazo: "
                +color.toString()
                +"linea "+grosorLinea
                +"discontinuidad"+
                this.patronDiscontinuidad.toString();
    }
    
}
