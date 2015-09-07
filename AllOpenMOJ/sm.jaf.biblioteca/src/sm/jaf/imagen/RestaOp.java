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

import java.awt.image.BufferedImage;
import sm.image.BinaryOp;

/**
 * Operación binaria  para un tipo especial de procesamiento de imágenes.
 * En el caso de las operaciones binarias sólo tenemos que definir una función que es 
 * binaryOp donde definimos la operación que tiene que realizarse, en este caso, śolo
 * restar.
 * @author Juan A. Fernández Sánchez
 */
public class RestaOp extends BinaryOp {
    
    
    public RestaOp(BufferedImage img) {
        super(img);        
    }
    
    @Override
    public int binaryOp(int v1, int v2){
        return Math.abs(v1-v2);
    }

}