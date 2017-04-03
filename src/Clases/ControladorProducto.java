/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author HAZAEL
 */
public class ControladorProducto {
    public void Agregar(Producto producto){  
      try {
          Conexion cn = new  Conexion();
            Connection conexion = cn.getConexion();
            PreparedStatement st = conexion.prepareStatement("INSERT INTO producto VALUES ("+producto.CodBarra+", "+producto.inventario+
                    ", "+producto.costo+",'"+producto.nombre+"')");
            ResultSet rs = st.executeQuery();
            
      } catch (Exception e) {
      }

    }
    public void Modificar(Producto producto){
    
    }
    public void Eliminar(Producto producto){
    
    }   
    public void Buscar( Producto[] producto ){
        
    }
    
    public void Obtener(String CodigoBarra ){
        
    }
   
        public ControladorProducto(){
        
    }
}
