/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;
import Clases.DetalleCompra;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HAZAEL
 */

public class Compra {
    public int idCompra;
    public Date fecha;
    public Proveedor proveedor;
    public double Total;
    public List<DetalleCompra> Articulos;
    
    public Compra(){
        
        
    }
    
    public void CalcularTotal(){
        double total = 0;
       for (DetalleCompra v : Articulos) {
        total += v.cantidad * v.costoUnitario;
      }
      Total = total;
        }
        
    
    
    public void AgregarItem( DetalleCompra detalleCompra){
      Articulos.add(detalleCompra);
      
          
    }
 
    
}
