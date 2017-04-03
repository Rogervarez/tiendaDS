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
public class Producto {
    private String CodBarra;
    private String nombre;
    private int inventario;
    private double costo;
    
    // Contructo sin argumentos para instaciar
    public Producto(){
        
    }
    
    // Contrucrtor con argumentos para instaciar 
    public Producto(String codBarra, String nombre, int inventario, double costo){
        this.CodBarra = codBarra;
        this.nombre = nombre;
        this.inventario = inventario;
        this.costo = costo;
    }
    
    public String toString(){
        return nombre;
    }
    
}
