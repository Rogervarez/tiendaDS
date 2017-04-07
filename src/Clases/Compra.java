/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;
import Clases.DetalleCompra;
import java.util.ArrayList;

/**
 *
 * @author HAZAEL
 */

public class Compra {
    public int idCompra;
    public Date fecha;
    public Proveedor proveedor;
    public double total;
    public DetalleCompra[] articulos;
    
    public Compra(){
        
        
    }
    
    public void CalcularTotal(){
        double t;
        for(int i=0; i<=articulos.length; i++){
            t= ((articulos[i].cantidad)*(articulos[i].costoUnitario));
            total= total + t;
        
                }
        }
        
    
    
    public void AgregarItem( DetalleCompra detalleCompra){
       int n=(articulos.length);
       if(n==0){
           articulos[n+1]=detalleCompra;
       }else{
           for(int i=0; i<=n; i++){
               if(i==n){
                   articulos[(i+1)]= detalleCompra;
               }
           }
       }
 
      
          
    }
 
    
}
