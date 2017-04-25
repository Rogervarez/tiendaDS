/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import connections.conection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author HAZAEL
 */
public class ControladorVenta {
    
    conection cn = new conection();
    public void Agregar( Ventas venta ){
        
    }
    
    public int ObtenerIdVenta( int obtenerIdVenta ) throws  ErrorTienda{
        
       int Id = 0;
       ResultSet rs;
       PreparedStatement ps;
       try {
           
           cn.Conectar();
           ps = cn.BuscarId("compra");
           rs = ps.executeQuery();
           while (rs.next()) {
               Id = rs.getInt("count(*)");
           }
           Id = Id+1;
       } catch (Exception e) {
           throw new ErrorTienda("Error al obtener el IdCompra", e.getMessage());
       }
       return Id;
    }
    
    public void ActualizarInventario( DetalleVenta[] actualizarInventario ){
        
    }
}
