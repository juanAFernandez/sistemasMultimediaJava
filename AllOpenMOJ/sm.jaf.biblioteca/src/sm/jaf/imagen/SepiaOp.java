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
package sm.jaf.imagen;

import static extras.Imprimir.Imprimir;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;
import sm.image.BufferedImagePixelIterator;

/**
 * Es posible definir nuevas operaciones para el procesamiento de imágenes, para ellos se crea una clase
 * y se implementa el interfaz BufferedimageOpAdapter y en este caso se implementa la operación 
 * que hace que la imagen se vuelva a escala de grises.
 * @author Juan A. Fernández Sánchez
 */
public class SepiaOp extends BufferedImageOpAdapter {
    
    /**
     * Variable de control sobre la profundidad del filtro sepia.
     */
    final private int profundidad;
    /**
     * Variable de control sobre la intensificación del efecto sepia sobre la imagen.
     */
    final private int intensidad;
    
    /**
     * Constructor de la clase con los los parámetros para el filtro.
     * @param profundidad Control 
     * @param intensidad 
     */
    public SepiaOp(int profundidad, int intensidad){
        this.profundidad=profundidad;
        this.intensidad=intensidad;
    }

    
    /**
     * Función que realmente define y aplica el filtro:
     * @param src Imgen de origen
     * @param dest Imagen de destino
     * @return Devuelve la imagen con el filtro aplicado.
     */
    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest) {
                    
        Imprimir("Intentando aplicar filtro");
        
        if(dest==null){
            Imprimir("Creando imagen destino por falta");
            //creamos una imagen compatible.
            dest=createCompatibleDestImage(src,null);            
        }
        
        WritableRaster srcRaster = src.getRaster();
        WritableRaster destRaster = dest.getRaster();
                                               
        
        
            //Para recorrer la imagen vamos a usar un iterador pixel a pixel:

            BufferedImagePixelIterator.PixelData pixel;
           
            //Iterador sobre la imagen pixel a pixel.
            for(BufferedImagePixelIterator it = new BufferedImagePixelIterator(src); it.hasNext();){
                //Extraemos un pixel de la imagen original
                pixel=it.next();
                                
                int r = pixel.sample[0];
                int g = pixel.sample[1];
                int b = pixel.sample[2];

                int gry = (r + g + b) / 3;
                
                r = g = b = gry;
                r = r + (profundidad * 2);
                g = g + profundidad;

                //Normalizamos si nos hubiéramos pasado
                if (r > 255) r = 255;                
                if (g > 255) g = 255;                
                if (b > 255) b = 255;
                
                //Oscurecemos el color azul para intensificar el efecto del filtro sepa
                b -= intensidad;

                // Normalizamos si nos hubieramos pasado
                if (b < 0) b = 0;
                
                if (b > 255) b = 255;
                
                //Guardamos los resultados en el pixel.
                pixel.sample[0]=r;
                pixel.sample[1]=g;
                pixel.sample[2]=b;

                //Guardamos el pixel modificado en la imagen destino
                destRaster.setPixel(pixel.col, pixel.row, pixel.sample);
            
                            
            }
            

        return dest;
        
    }
    
}
