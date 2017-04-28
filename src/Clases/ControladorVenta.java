/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import com.mysql.jdbc.exceptions.DeadlockTimeoutRollbackMarker;
import connections.ListasTablas;
import connections.conection;
import connections.iList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HAZAEL
 */
public class ControladorVenta {
    
    static conection cn = new conection();
    public static void Agregar( Venta venta ) throws ErrorTienda, SQLException, Exception{
        try {
            cn.Conectar();
            iList p = new iList(new ListasTablas("IdVenta", venta.idVenta));
            p.add(new ListasTablas("Fecha", venta.fecha));
            p.add(new ListasTablas("Cliente", venta.cliente));
            p.add(new ListasTablas("Total", venta.Total));
            
            cn.AgregarRegistro("venta", p, false);
            
        } catch (SQLException e) {
            throw new ErrorTienda("Class ControladorVenta/Agregar", e.getMessage());
        }
    }
    
    public static int ObtenerIdVenta( int obtenerIdVenta ) throws  ErrorTienda{
        
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
    
    public void ActualizarInventario( ArrayList<DetalleVenta> actualizarInventario ) throws ErrorTienda{
        String[] camposAMostrar = new String[] {"Cantidad"};
        iList condiciones = new iList(new ListasTablas("CodBarra", actualizarInventario.get(0).toString()));
        int cantidad=0;
        ResultSet rs;
        try {
             rs = cn.BuscarRegistro("productos", camposAMostrar, condiciones).executeQuery();
            while (rs.next()) {
                cantidad = rs.getInt("Cantidad");
            }
            
            
         }catch (Exception ex){
            throw new ErrorTienda("Class ControladorVenta/ActualizarInventario", ex.getMessage());
         }
        
        
        try {
            int restar = Integer.parseInt(actualizarInventario.get(1).toString());
            int CantidadNueva = cantidad - restar;
            iList p = new iList(new ListasTablas("inventario", CantidadNueva));
            cn.ModificarRegistro("producto", condiciones, p);
        } catch (Exception ex) {
            throw new ErrorTienda("Class ControladorVenta/ActualizarInventario", ex.getMessage());

        }
    }
}
