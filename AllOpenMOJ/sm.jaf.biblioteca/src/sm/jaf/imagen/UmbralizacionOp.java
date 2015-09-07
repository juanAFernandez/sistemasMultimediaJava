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
 * Operación propia para el procesamiento de iḿagenes que permite la umbralización a partir de 
 * un valor umbral.
 * Dado un valor umbral ofrecido a través de un slider se modifica los píxeles y todos aquellos
 * que superen dicho umbral son llevados a blanco.
 * @author Juan A. Fernández Sánchez
 */
public class UmbralizacionOp extends BufferedImageOpAdapter {

    private int umbral;
    
    public UmbralizacionOp(int umbral){
        this.umbral=umbral;
    }
    
    /**
     * Función que realmente aplica el filtro:
     * @param src
     * @param dest
     * @return 
     */
    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest) {
        
        Imprimir("Intentando aplicar filtro");
        
        if(dest==null){
            Imprimir("Creando imagen destino por falta");
            dest=createCompatibleDestImage(src,null);
            
        }
        
        WritableRaster srcRaster = src.getRaster();
        WritableRaster destRaster = dest.getRaster();
                                               
        //Código de umbralización:
        
            //Para recorrer la imagen vamos a usar un iterador pixel a pixel:
            int numPixel=0;
            BufferedImagePixelIterator.PixelData pixel;
            int media=0;
            int numBandas;
            
            for(BufferedImagePixelIterator it = new BufferedImagePixelIterator(src); it.hasNext();){
                //Extraemos un pixel de la imagen original
                pixel=it.next();
                                
                numBandas=pixel.numSamples;
                for(int i=0; i<numBandas; i++)
                    media+=pixel.sample[i];
                media=media/numBandas;
                               
                
                
                
                if(media>=umbral){                    
                    for(int i=0; i<numBandas; i++) pixel.sample[i]=255; // 255 es BLANCO         
                }else if (media<umbral){
                    for(int i=0; i<numBandas; i++) pixel.sample[i]=0; // 0 es NEGRO
                }
                
                //Guardamos el pixel modificado en la imagen destino
                destRaster.setPixel(pixel.col, pixel.row, pixel.sample);
                
                numPixel++;        
            }
            System.out.println(numPixel+" píxeles");
        
        
        return dest;
        
    }
    
}
