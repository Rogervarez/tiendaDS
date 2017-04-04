/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.swing.JOptionPane;

/**
 *
 * @author HAZAEL
 */
public class ErrorTienda extends Exception {
    
    public void New( String mensaje) throws Exception {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
