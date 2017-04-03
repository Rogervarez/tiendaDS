/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;

/**
 *
 * @author HAZAEL
 */
public class Compra {
    private int idCompra;
    private Date fecha;
    private Proveedor proveedor;
    private double total;
    private DetalleCompra[] articulo;
    
    public Compra(){
        
    }
    
    public Compra( int idCompra, Date fecha, Proveedor proveedor, double total, DetalleCompra[] articulo){
        this.idCompra = idCompra;
        this.fecha = fecha;
        this.proveedor = proveedor;
        this.total = total;
        this.articulo = articulo;
    }
    
    public void CalcularTotal(){
        // variable para calcular el total de los productos
        double total = 0.0;
        String Salida = "Nombre Producto\tPrecio Del Producto";
        
        for ( DetalleCompra articulo1 : articulo ) {
            Salida += articulo1.toString() + "\n";
            total += articulo1.getCostoUnitario();
        }   
    }
    
    public void AgregarItem( DetalleCompra detalleCompra ){
        
    }
}
