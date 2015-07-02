/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jaf.imagen;

import java.awt.image.BufferedImage;
import sm.image.BinaryOp;

/**
 *
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