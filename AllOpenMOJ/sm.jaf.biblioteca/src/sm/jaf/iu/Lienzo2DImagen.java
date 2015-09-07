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
package sm.jaf.iu;

import static extras.Imprimir.Imprimir;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import sm.jaf.graficos.Figura;

/**
 * Lienzo2DImagen extiende de Lienzo2D porque debe tener todas las caracteríticas propias del Lienzo2D además de las 
 * que esta clase añada. 
 * Por eso una instancia de esta podrá hacer todo lo que hacía el padre, tendrá todos sus métodos 
 * y serán accesibles todas sus variables siempre a través de los métodos set/get. Así esta nueva imagen se centrará a todo lo relativo 
 * a la imagen.
 * @author Juan A. Fernández Sánchez
 */
public class Lienzo2DImagen extends Lienzo2D {

    //Variable que almacernará los datos de la imagen.
    private BufferedImage imagen;
    
    
    
    
    /**
     * Creates new form Lienzo2DImagen
     */
    public Lienzo2DImagen() {
        initComponents();        
    }

    
    public void setImage(BufferedImage img){
        Imprimir("INTRODUCIENDO IMAGEN EN LIENZO2diMAGEN");
        this.imagen= img;
        
        //Ajustamos el tamaño del lienzo al tamaño de la imagen que abrimos.
        if(img!=null){
            setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
            //Ajustamos el tamaño del cliping al tamño de la imagen:
            altoLienzo=img.getHeight();
            anchoLienzo=img.getWidth();
        }
            
    }

    public BufferedImage getImage(boolean drawVector){
        if(drawVector){
            return getImage();
        }
        else
            return getImage();
    }
            
    /**
     * Devuelve todo lo que haya en el lienzo grabado sobre una imagen.
     * @return Imagen en formato BufferedImagen
     */
    public BufferedImage getImage(){
        Imprimir("Llamando a getImage en Lienzo2DImagen");
       
        //Si el vector de figuras no está vacío:
        if(!vShape.isEmpty()){
            return dibujarFiguras();
        }
        
        return imagen;          
    }
    
    public BufferedImage dibujarFiguras(){                
        
        //Si no existe imagen previa (una foto, por ejemplo)
        if(imagen==null){
            Imprimir("Aun no hay una imgaen donde guardar!");
            imagen = imagen = new BufferedImage(anchoLienzo, altoLienzo, BufferedImage.TYPE_INT_RGB);
            
            paint(imagen.createGraphics());
            return imagen;
            
        //Si existe imagen previa (una foto, por ejemplo)
        }else{
            Imprimir("La imagen ya tiene contenido");
        
          
            BufferedImage mImagen;
            mImagen = new BufferedImage(anchoLienzo, altoLienzo, BufferedImage.TYPE_INT_RGB);

            Graphics2D gOculta = mImagen.createGraphics();


            gOculta.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            gOculta.drawImage(imagen, 0, 0, this);


            if(!vShape.isEmpty())
                for(Figura fig:vShape)
                    fig.dibujateEn(gOculta);

            return mImagen;
        }
       
    }

    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(imagen!=null)
            g.drawImage(imagen, 0, 0, this);
    }
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    
}
