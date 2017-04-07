/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *
 * @author HAZAEL
 */

public class DetalleVenta {
    
  public Producto producto;
  public int cantidad;
  public double PrecioUnitario;
<<<<<<< HEAD
  DecimalFormat decimal = new DecimalFormat("0.00");
=======
>>>>>>> sergio/master
  
  public DetalleVenta(Producto producto, int cantidad, double PrecioUnitario){
      this.PrecioUnitario = PrecioUnitario;
      this.cantidad = cantidad;
      this.producto = producto;
  }
  
  public void New(String codBarra, int cantidad){
  
        this.cantidad = cantidad;
        Producto p=new Producto();
        p.setCodBarra(codBarra);
        }
  public double calcularPrecio() throws ErrorTienda{
     Parametro p=new Parametro();
        try{
           decimal.setRoundingMode(RoundingMode.CEILING); 
        return Double.parseDouble(decimal.format(producto.getCosto()/(1-(Double.parseDouble(p.ObtenerUtilidad().getValor())/100))));
        }catch(ArithmeticException ex){
            throw new ErrorTienda("Error de Calculo", ex.getMessage());

   }
/*  public void calcularPrecio( double cantidadPrecio ){
  
}*/
  
  } 
 
}
