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
 * Operación propia para el procesamiento de iḿagenes que convierte la imagen de color a escala de grises.
 * Mediante la definición de una nueva operación mediante la implmentación de la interfaz
 * BufferedImageOpAdapter implementamos la conversión a escala de grises de culquier imagen en la 
 * funcion filter donde se recorre dicha imagen pixel a pixel analizando sus tres componentes de 
 * color y calculando, normalizando, el valor medio y para luego grabarlo.
 * @author Juan A. Fernández Sánchez
 */
public class EscalaGrisesOp extends BufferedImageOpAdapter {

        
    public EscalaGrisesOp(){

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
            int numPixel=0;
            BufferedImagePixelIterator.PixelData pixel;
            int media=0;
            int numBandas;
            
            //Iterador sobre la imagen pixel a pixel.
            for(BufferedImagePixelIterator it = new BufferedImagePixelIterator(src); it.hasNext();){
                //Extraemos un pixel de la imagen original
                pixel=it.next();
                                
                //Extraemos el valor de sus tres componentes
                int r = pixel.sample[0];
                int g = pixel.sample[1];
                int b = pixel.sample[2];

                //Calculamos la media
                int gris = (r + g + b) / 3;
                               
                
                pixel.sample[0]=gris;
                pixel.sample[1]=gris;
                pixel.sample[2]=gris;

                
                //Guardamos el pixel modificado en la imagen destino
                destRaster.setPixel(pixel.col, pixel.row, pixel.sample);
                
                numPixel++;        
            }
            System.out.println(numPixel+" píxeles");
        
        
        return dest;
        
    }
    
}
