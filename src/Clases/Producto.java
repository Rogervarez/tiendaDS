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
<<<<<<< HEAD

    public String getCodBarra() {
        return CodBarra;
    }

    public void setCodBarra(String CodBarra) {
        this.CodBarra = CodBarra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
=======
>>>>>>> sergio/master
    public String CodBarra;
    public String nombre;
    public int inventario;
    public double costo;
    
    public Producto(String CodBarra, String nombre, int inventario, double costo ){
        this.CodBarra = CodBarra;
        this.nombre = nombre;
        this.inventario = inventario;
        this.costo = costo;
    }
    
    public Producto(){}
}
