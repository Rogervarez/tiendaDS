/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HAZAEL
 */
public class Parametro {
    private String idParametro;
    private String nombre;
    private String valor;
    
    public Parametro(){
        
    }
    
    public static List Obtener(){
        List Proveedor = new ArrayList();
        int i = 0;
        try {
  
        } catch (Exception ex) {
            Logger.getLogger(Parametro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Proveedor;
    }
    
    public void ObtenerUtilidad( Parametro parametro ){
        
    }
}
