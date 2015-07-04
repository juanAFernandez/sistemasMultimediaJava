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

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.TextAttribute;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Map;

/**
 * Clase que abstrae el concepto de texto. 
 * Como pasaba con el resto de figuras Java no ofrece una clase que englobe todos los aspectos de un 
 * texto como su fuente, su tamaño, color, etc. Por eso creamos una clase propia para poder trabajar
 * bien con textos.
 * @author Juan A. Fernández Sánchez
 */
public class Texto {
    
    /**
     * Fuente del texto.
     */
    Font fuente;
    
    /**
     * Grosor del texto.
     */
    int grosor;
    
    Color color;
    
    /**
     * Variables boleanas de estado.
     */
    boolean negrita;
    boolean cursiva;
    boolean subrayado;
    boolean tachado;
    
    /**
     * Texto propiamente.
     */
    String texto;
    
    /**
     * Nombre de la fuente.
     */
    String nombreFuente;
    /**
     * Posición del texto en el lienzo.
     */
    Point2D posicion;
    
    Graphics2D g2dPadre;
    
    //Constructor de prueba:
    public Texto(){
        
        //Especificamos un tamaño:
    //    grosor=45;
        
        //Especificamos un texto:
    //    texto="prueba";
        
        //Especificamos una posición de prueba:
    //    posicion = new Point2D.Double(20,20);        
        
        //Especificamos la fuente:
       // fuente = new Font("Arial", Font.BOLD | Font.ITALIC, grosor);
    }
    
    
    
    
    public Texto(String texto, int grosor, Color color, Point2D posicion, String fuente){
        this.texto=texto;
        this.grosor=grosor;
        this.color=color;
        this.posicion=posicion;
        this.nombreFuente=fuente;
    }
    
    public void setGrosor(int grosor){
        this.grosor=grosor;
    }
    public int getGrosor(){
        return grosor;
    }
    public void setText(String nuevoTexto){
        texto=nuevoTexto;
    }
    public String getText(){
        return texto;
    }
    public void setPosicion(Point2D pos){
        posicion=pos;
    }
    public void setFuente(String nombre){
        nombreFuente=nombre;
    }    
    public String getFuente(){
        return nombreFuente;
    }
    public void setColor(Color nuevoColor){
        color=nuevoColor;
    }
    public Color getColor(){
        return color;
    }
    public void setNetrita(boolean decision){
        negrita=decision;
    }
    public boolean getNegrita(){
        return negrita;
    }
    public void setCursiva(boolean decision){
        cursiva=decision;
    }
    public boolean getCursiva(){
        return cursiva;
    }
    public void setSubrayado(boolean decision){
        subrayado=decision;       
    }
    public boolean getSubrayado(){
        return subrayado;
    }
    public void setTachado(boolean decision){
        tachado=decision;
    }
    public boolean getTachado(){
        return tachado;            
    }
    
    
    
    /**
     * Para dibujar el texto en un entorno Graphics2D pasado.
     * @param g2d Entorno Graphics2D pasado
     */
    public void dibujateEn(Graphics2D g2d){
                 
        //Tomamos una referencia del Graphics2D padre que nos servirá para conocer si un click contiene el texto.
        g2dPadre=g2d;
        
        if(negrita && !cursiva)
            fuente = new Font(nombreFuente, Font.BOLD, grosor); 
        if(cursiva && !negrita)
            fuente = new Font(nombreFuente, Font.ITALIC, grosor); 
        if(negrita && cursiva)
            fuente = new Font(nombreFuente, Font.BOLD | Font.ITALIC, grosor); 
        if(!negrita && !cursiva)
            fuente = new Font(nombreFuente,Font.PLAIN, grosor);        
          
        
        Map atributosTexto = fuente.getAttributes();
        if(subrayado)                    
            atributosTexto.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        if(tachado)
            atributosTexto.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
        
        g2d.setFont(fuente.deriveFont(atributosTexto));
      
        //Aplicamos la fuente
       // g2d.setFont(fuente);
        
        //Aplicamos el color:
         g2d.setColor(color);
                                
        //Dibujamos el texto con la fuente aplicada antes en una posición específica:
        g2d.drawString(texto, (float)posicion.getX(),(float)posicion.getY());        
        
    }
    public void cambiarPosicion(Point2D nuevaPos){
        posicion.setLocation(nuevaPos);
    }
    
    
    public boolean contiene(Point2D punto){             
            
        //Obtenemos el rectangulo en el que está inscrito el texto.
        Rectangle2D rectanguloContenido = fuente.getStringBounds(texto, g2dPadre.getFontRenderContext());
        //Lo imprimos en terminal
    //    Imprimir("ancho: "+rectanguloContenido.getWidth()+" alto: "+rectanguloContenido.getHeight());
        
        //Si el punto está dentro de ese rectángulo el texto habrá sido seleccionado, si nó, no.
        
   //     Imprimir("PUNTO DE ESCRITURA"+this.posicion.getX()+" "+posicion.getY());
   //     Imprimir("PUNTO CLICADO: "+punto.getX()+" "+punto.getY());
        
        Point2D posicion2= new Point2D.Double(posicion.getX(),posicion.getY()-rectanguloContenido.getHeight());
     
        Rectangle2D prueba = new Rectangle2D.Double(posicion2.getX(), posicion2.getY(), rectanguloContenido.getWidth(), rectanguloContenido.getHeight());
        
        if(prueba.contains(punto.getX(), punto.getY())){
     //       Imprimir("Lo contiene");
            return true;
        }            
        else{
     //       Imprimir("No lo contiene");
            return false;
        }
        
        
        
    }
}
