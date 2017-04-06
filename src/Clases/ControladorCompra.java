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
import javax.swing.JOptionPane;

/**
 *
 * @author HAZAEL
 */
public class ControladorCompra {
    conection cn = new conection();
   public void Agregar(Compra compra) throws Exception{
       
     
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
   public void ActualizarInventario(Compra compra){
       try {
           cn.Conectar();
           iList a = new iList(new ListasTablas("IdCompra", compra.idCompra));
           iList p = new iList(new ListasTablas("Fecha", compra.fecha));
           p.add(new ListasTablas("Cantidad", compra.articulo.get(1).cantidad));
           p.add(new ListasTablas("IdProveedor", compra.proveedor.idProveedor));
           p.add(new ListasTablas("Total", compra.total));
           cn.ModificarRegistro("Compra", p, a);
       } catch (Exception e) {
       }
   
   }
   public void ActualizarPrecioPromedioProducto(ArrayList<DetalleCompra> detalleCompra){
       
   
   }
   
   public void ObtenerIdCompra(int id){
   }
   
   public ControladorCompra(){
        
    }
}

