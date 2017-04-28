/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import connections.conection;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author HAZAEL
 */
public class Compra {
    public int idCompra;
    public Date fecha;
    public Proveedor proveedor;
    public double total;
    public ArrayList<DetalleCompra> articulo;
    
    public Compra(){
        
    }
    
    public double CalcularTotal() throws ErrorTienda{
         double total1=0;
          try{
              for(DetalleCompra dc: this.articulo){
                  total1=total1+(dc.cantidad*dc.costoUnitario);
              }
              this.total = Math.round(total1*100.0)/100.0;
          }catch(ArithmeticException ex){
           throw new ErrorTienda("Class Compra/CalcularTotal", ex.getMessage());  
          }
          return this.total;
    }
    
    public void AgregarItem( DetalleCompra detalleCompra) throws ErrorTienda{
        
        try {
            this.articulo.add(detalleCompra);
            this.CalcularTotal();
           
        }catch(Exception ex) {
            throw new ErrorTienda("Class Compra/AgregarItem", ex.getMessage());
        }
    }
}
