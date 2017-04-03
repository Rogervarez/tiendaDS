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
public class DetalleCompra {
    
    private Producto producto;
    private int cantidad;
    protected double costoUnitario;
    
    // Primer Constructor Instanciable si parametro 
    public DetalleCompra(){
        // llamada implicita
    }
    
    // Segundo Constructor Instanciable Con Parametros
    public DetalleCompra( Producto producto, int cantidad, double costoUnitario ){
        
        setCantidad(cantidad);
        setCostoUnitario(costoUnitario);
        
        this.producto = producto;
        this.cantidad = getCantidad();
        this.costoUnitario = getCostoUnitario();
    }
    
    
    // Declaracion de los metos establecer y obtener
    public void setCantidad( int valCantidad ){
        if( valCantidad > 0 ){
            cantidad = valCantidad;
        }
        else {
            cantidad = 0;
        }
    }
    
    public int getCantidad(){
        return cantidad;
    }
    
    public void setCostoUnitario( double valCostoUnitario ){
        if( valCostoUnitario > 0.0 ){
            costoUnitario = valCostoUnitario;
        }
        else {
            costoUnitario = 0.0;
        }
    }
    
    public double getCostoUnitario(){
        return costoUnitario;
    }
    public String toString(){
        return "El producto es " + producto.toString() + "\t" + "Su Costo por unidad es" + costoUnitario;
    }
}
