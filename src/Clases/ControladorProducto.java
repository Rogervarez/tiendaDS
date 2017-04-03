/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import connections.ListasTablas;
import connections.conection;
import connections.iList;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author HAZAEL
 */
public class ControladorProducto {
    
            conection cn = new conection();
    public void Agregar(Producto producto) throws Exception{
        
     
        try {
      
            cn.Conectar();
            iList p = new iList(new ListasTablas("CodBarra", producto.CodBarra));
            p.add(new ListasTablas("Inventario", producto.inventario));
            p.add(new ListasTablas("Costo", producto.costo));
            p.add(new ListasTablas("nombre", producto.nombre));
          
            cn.AgregarRegistro("productos", p, false);
            
           
            
        } catch (Exception ex) {
            cn.Desconectar();
            JOptionPane.showMessageDialog(null, ex.getMessage() + " mensaje: " + ex.getLocalizedMessage());
           
        }
    }
    public void Modificar(Producto producto) throws Exception{
            try {
      
            cn.Conectar();
            iList a = new iList(new ListasTablas("CodBarra", producto.CodBarra));
            iList p= new iList(new ListasTablas("Inventario", producto.inventario));
            p.add(new ListasTablas("Costo", producto.costo));
            p.add(new ListasTablas("nombre", producto.nombre));
          
            cn.ModificarRegistro("productos", p, a);
            
           
            
        } catch (Exception ex) {
            cn.Desconectar();
            JOptionPane.showMessageDialog(null, ex.getMessage() + " mensaje: " + ex.getLocalizedMessage());
           
        }
    }
    public void Eliminar(Producto producto){
           try {
            cn.Conectar();
            iList p = new iList(new ListasTablas("CodBarra", producto.CodBarra));
            
            cn.Eliminar("producto", p);
         

        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage() + " mensaje: " + ex.getLocalizedMessage());
        }
        
    }   
    public void Buscar( Producto[] producto ){
        
        
    }
    
    public  Producto Obtener(String CodigoBarra ) throws Exception{
        Producto producto = new Producto();
        String[] bs = new String[]{"CodBarra", "Invenario", "Costo", "nombre"};
        try{
            cn.Conectar();
            iList p = new iList(new ListasTablas("CodBarra", CodigoBarra));
            ResultSet rs = cn.BuscarRegistro("producto", bs, p).executeQuery();
            rs.first();
            producto.CodBarra = rs.getString(1);
            producto.nombre = rs.getString(2);
            producto.inventario = Integer.parseInt(rs.getString(3));
            producto.costo = Double.parseDouble(rs.getString(4));
            
        }
        catch(Exception ex){
            cn.Desconectar();
            JOptionPane.showMessageDialog(null, ex.getMessage() + " mensaje: " + ex.getLocalizedMessage());
        }
      return producto;
    }
   
        public ControladorProducto(){
        
    }
}
