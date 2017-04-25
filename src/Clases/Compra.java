/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import connections.ListasTablas;
import connections.conection;
import connections.iList;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author HAZAEL
 */
public class Compra {
    conection cn = new conection();
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
        
        try {
      
            cn.Conectar();
            iList p = new iList(new ListasTablas("CodBarra", producto.CodBarra));
            p.add(new ListasTablas("Inventario", producto.inventario));
            p.add(new ListasTablas("Costo", producto.costo));
            p.add(new ListasTablas("nombre", producto.nombre));
          
            cn.AgregarRegistro("productos", p, false);
            
           
            
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage() + " mensaje: " + ex.getLocalizedMessage());
           
        }
    }
}
