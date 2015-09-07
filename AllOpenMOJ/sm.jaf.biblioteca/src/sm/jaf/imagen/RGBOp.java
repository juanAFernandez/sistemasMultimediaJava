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
 * Operación propia para el procesamiento de iḿagenes que permite la modicación de cualquiera de las tres
 * componentes de color en todos los píxeles de la imagen.
 * Esta herramiente ofrece tres slider con los que poder modificar el valor de cualquire componente
 * en todos los píxeles de la imagen ofreciendo una forma de realizar retorques artísticos.
 * Esta operación como el resto también se hace recorriendo la imagen y aplicando los cambios pixel a pixel.
 * @author Juan A. Fernández Sánchez
 */
public class RGBOp extends BufferedImageOpAdapter {
    
    /**
     * Valor de variación a aplicar sobre la componente roja de cada pixel.
     */
    int variacionRojo;
    /**
     * Valor de variación a aplicar sobre la componente verde de cada pixel.
     */
    int variacionVerde;
    /**
     * Valor de variación a aplicar sobre la componente azul de cada pixel.
     */
    int variacionAzul;
    
    
    /**
     * Constructor de la clase con los parámetros del filtro.
     * @param variacionRojo Valor de variación del nivel de rojo de cada pixel.
     * @param variacionVerde VAlor de variación del nivel de verde de cada pixel.
     * @param variacionAzul VAlor de variación del nivel de azul de cada pixe.
     */
    public RGBOp(int variacionRojo, int variacionVerde, int variacionAzul){
        this.variacionRojo=variacionRojo;
        this.variacionVerde=variacionVerde;
        this.variacionAzul=variacionAzul;        
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
                
        WritableRaster destRaster = dest.getRaster();
                                                             
            //Para recorrer la imagen vamos a usar un iterador pixel a pixel:

            BufferedImagePixelIterator.PixelData pixel;
           
            //Iterador sobre la imagen pixel a pixel.
            for(BufferedImagePixelIterator it = new BufferedImagePixelIterator(src); it.hasNext();){
                //Extraemos un pixel de la imagen original
                pixel=it.next();
                          
                //Extraemos el valor de las tres componentes de cada pixel.
                int rojo = pixel.sample[0];
                int verde = pixel.sample[1];
                int azul = pixel.sample[2];

                //Aplicamos las variaciones:
                rojo+=variacionRojo;
                verde+=variacionVerde;
                azul+=variacionAzul;
               
                //Normalizamos si nos hubiéramos pasado por cualquiera de los dos extremos
                if (rojo > 255) rojo = 255; if (rojo < 0) rojo = 0;         
                if (verde > 255) verde = 255; if (verde < 0) verde = 0;               
                if (azul > 255) azul = 255; if (azul < 0) azul = 0;
                              
                
                //Guardamos los resultados en el pixel.
                pixel.sample[0]=rojo;
                pixel.sample[1]=verde;
                pixel.sample[2]=azul;

                //Guardamos el pixel modificado en la imagen destino
                destRaster.setPixel(pixel.col, pixel.row, pixel.sample);
            
                            
            }
            

        return dest;
        
    }
    
}
