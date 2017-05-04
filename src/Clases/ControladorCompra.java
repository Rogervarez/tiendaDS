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
       int cantidadActual=0;
       try {
           cn.Conectar();
           ResultSet cantidad;
           String[] campos = new String[] {"Cantidad"};
           iList condiciones = new iList(new ListasTablas("CodBarra", compra.articulo.get(0).producto.CodBarra));
           cantidad = cn.BuscarRegistro("producto", campos, condiciones).executeQuery();
           while (cantidad.next()) {
               cantidadActual = cantidad.getInt(0);
           }
           iList nuevosCampos = new iList(new ListasTablas("Cantidad", (cantidadActual+compra.articulo.get(0).cantidad)));
           cn.ModificarRegistro("producto", nuevosCampos, condiciones);
           
       } catch (Exception e) {
           throw new ErrorTienda("Error al actualizar ", e.getMessage());
       }
   
   }
   public static void ActualizarPrecioPromedioProducto(ArrayList<DetalleCompra> detalleCompra) throws ErrorTienda{
       int cantidad=0;
       double costo=0, nuevoCosto=0;
       String nombreTabla;
       String[] campoCantidad = new String[] {"Cantidad"};
       String[] campoCosto = new String[] {"Costo"};
       try {
           cn.Conectar();
           
           ResultSet rsCantidad, rsPrecio;
           iList condiciones = new iList(new ListasTablas("CodBarra", detalleCompra.get(0).producto.CodBarra));
           rsCantidad = cn.BuscarRegistro("producto", campoCantidad, condiciones).executeQuery();
           while (rsCantidad.next()) {
               cantidad = rsCantidad.getInt(0);
           }
           
           rsPrecio = cn.BuscarRegistro("producto", campoCosto, condiciones).executeQuery();
           while (rsPrecio.next()) {
               costo = rsPrecio.getDouble(0);
           }
           nuevoCosto = (cantidad*costo)+(detalleCompra.get(0).cantidad*detalleCompra.get(0).costoUnitario);
           iList nuevosCampos = new iList(new ListasTablas("producto", nuevoCosto));
           cn.ModificarRegistro("producto", nuevosCampos, condiciones);
       } catch (Exception e) {
           throw new ErrorTienda("Error al Actualizar precio promedio", e.getMessage());
       }
       
   
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

