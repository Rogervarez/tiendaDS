/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

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
    public ArrayList<DetalleVenta> articulo;
    
    public Compra(){
        
    }
    
    public void CalcularTotal(){
        
    }
    
    public void AgregarItem( DetalleCompra detalleCompra){
        
    }
}
