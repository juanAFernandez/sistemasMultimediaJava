/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jaf.imagen;

import static extras.Imprimir.Imprimir;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;
import sm.image.BufferedImagePixelIterator;

/**
 *
 * @author juan
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
