/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author HAZAEL
 */

public class DetalleVenta {
    
  public Producto producto;
  public int cantidad;
  public double PrecioUnitario;
  
  public DetalleVenta(Producto producto, int cantidad, double PrecioUnitario){
      this.PrecioUnitario = PrecioUnitario;
      this.cantidad = cantidad;
      this.producto = producto;
  }
  
  public void New(String codBarra, int cantidad){
      
  }
  
  public void calcularPrecio( double cantidadPrecio ){
      
  }
  
}
