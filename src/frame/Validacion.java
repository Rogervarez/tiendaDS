/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import java.awt.event.KeyEvent;

/**
 *
 * @author sergi
 */
public class Validacion {
    Character s;
    public void SoloLetras(KeyEvent evt){
        s = evt.getKeyChar();
        if (!Character.isLetter(s) && s != KeyEvent.VK_SPACE) {
            evt.consume();
        }
    }
    
    public void Numeros(KeyEvent evt){
        s = evt.getKeyChar();
        if (!Character.isDigit(s) && s != KeyEvent.VK_MINUS) {
            evt.consume();
        }
    
    }
    
    public void SoloNumeros(KeyEvent evt){
        s= evt.getKeyChar();
        if (!Character.isDigit(s)) {
            evt.consume();
        }
        
    }
    
    public void Decimales(KeyEvent evt){
        s = evt.getKeyChar();
        if(!Character.isDigit(s) && s != KeyEvent.VK_PERIOD){
            evt.consume();
        }
    
    }
}
