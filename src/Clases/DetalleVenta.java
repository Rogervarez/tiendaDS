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

public class DetalleVenta {
    
  private Producto producto;
  private String cantidad;
  private double PrecioUnitario;
  
  public DetalleVenta(){
      
  }
  

  
  public void calcularPrecio( double cantidadProducto){
      double precio = 0;
      
      precio = cantidadProducto*PrecioUnitario;
      
  }
  public void New(String codBarra, int cantidad){
      
    try {
        Conexion cn = new  Conexion();
        Connection conexion = cn.getConexion();
        PreparedStatement st = conexion.prepareStatement("INSERT INTO detalleventa VALUES ("+codBarra+", "+cantidad+", "+this.PrecioUnitario+")");
        ResultSet rs = st.executeQuery();
                    
    } catch (Exception e) {
    }
  }
}
