/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;


import connections.ListasTablas;
import connections.conection;
import connections.iList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author HAZAEL
 */
public class ControladorCompra {
    static conection cn = new conection();
   public static void Agregar(Compra compra) throws Exception{
       
     
        try {
      
            cn.Conectar();
            iList p = new iList(new ListasTablas("IdCompra", compra.idCompra));
            p.add(new ListasTablas("Fecha", compra.fecha));
            p.add(new ListasTablas("Cantidad", compra.articulo.get(1).cantidad));
            p.add(new ListasTablas("IdProveedor", compra.proveedor.idProveedor));
            p.add(new ListasTablas("Total", compra.total));
          
            cn.AgregarRegistro("compra", p, false);
            
           
            
        } catch (Exception ex) {
            cn.Desconectar();
            JOptionPane.showMessageDialog(null, ex.getMessage() + " mensaje: " + ex.getLocalizedMessage());
           
        }
   }
   public static void ActualizarInventario(Compra compra) throws ErrorTienda{
       try {
           cn.Conectar();
           iList a = new iList(new ListasTablas("IdCompra", compra.idCompra));
           iList p = new iList(new ListasTablas("Fecha", compra.fecha));
           p.add(new ListasTablas("Cantidad", compra.articulo.get(1).cantidad));
           p.add(new ListasTablas("IdProveedor", compra.proveedor.idProveedor));
           p.add(new ListasTablas("Total", compra.total));
           cn.ModificarRegistro("Compra", p, a);
       } catch (Exception e) {
           throw new ErrorTienda("Error al actualizar ", e.getMessage());
       }
   
   }
   public static void ActualizarPrecioPromedioProducto(ArrayList<DetalleCompra> detalleCompra){
       
   
   }
   
   public static int ObtenerIdCompra() throws ErrorTienda{
       
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
   
   public ControladorCompra(){
        
    }
}

