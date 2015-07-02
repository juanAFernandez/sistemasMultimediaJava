/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jaf.graficos;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Juan A. Fernández Sánchez
 */
public class Relleno {
 
    private Color colorA;
    private Color colorB;
    
    private Point2D puntoA;
    private Point2D puntoB;
    
    private Horientacion horientacion;
    
    public Relleno(){}
    public Relleno(Color a, Color b, Horientacion horientacion){
        colorA = a;
        colorB = b;
        this.horientacion=horientacion;
    }
    
    @Override
    public String toString(){
        return "Color"+colorA.toString()+colorB.toString()+horientacion.toString();
    }
    
    public void setColorA(Color nuevoColorA){ colorA = nuevoColorA;}
    public Color getColorA(){return colorA;}
    public void setColorB(Color nuevoColorB){ colorB = nuevoColorB;}
    public Color getColorB(){return colorB;}
    public void setHorientacion(Horientacion nH){horientacion = nH;}
    public Horientacion getHorientacion(){return horientacion;}
    
  
    
    
    public static enum Horientacion {
        VERTICAL,
        HORIZONTAL,
        DIAGONAL_A,
        DIAGONAL_B
    }
}
