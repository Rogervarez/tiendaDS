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

/**
 *
 * @author Roger
 */
public class ControladorProveedor {
    
    static conection cn = new conection();
    public static void Agregar(Proveedor P) throws ErrorTienda{
        try {
            cn.Conectar();
            iList p = new iList(new ListasTablas("IdProveedor", P.idProveedor));
            p.add(new ListasTablas("Nombre", P.nombre));
            p.add(new ListasTablas("Telefono", P.telefono));
            p.add(new ListasTablas("Direccion", P.direccion));
            p.add(new ListasTablas("NIT", P.nit));
            
            cn.AgregarRegistro("proveedor", p, false);
        } catch (Exception e) {
            throw new ErrorTienda("Class ControladorProducto/Buscar",e.getMessage());
        }
    }
    
    public static void Modificar(Proveedor P) throws ErrorTienda{
        try {
            cn.Conectar();
            iList a = new iList(new ListasTablas("IdProveedor", P.idProveedor));
            iList p = new iList(new ListasTablas("Nombre", P.nombre));
            p.add(new ListasTablas("Telefono", P.telefono));
            p.add(new ListasTablas("Direccion", P.direccion));
            p.add(new ListasTablas("NIT", P.nit));
            cn.ModificarRegistro("proveedor", p, a);
        } catch (Exception e) {
            throw new ErrorTienda("Class ControladorProducto/Buscar",e.getMessage());
        }
    
    }
    public static void Eliminar(Proveedor P) throws ErrorTienda {
        
        try {
            cn.Conectar();
            iList cond = new iList(new ListasTablas("idProveedor", P.idProveedor));
            //Se pueden seguir agregando condiciones para hacer el delete
            //cond.add(new ListasTablas("telefono", P.telefono));
            if (cn.Eliminar("proveedor", cond)) {
                System.out.println("Registro eliminado exitosamente");
            }

        } catch (Exception e) {
            throw new ErrorTienda("Class ControladorProducto/Buscar",e.getMessage());
        }
    }

    //public ArrayList <Proveedor> Buscar(String criterio){
    //}
    
    public static ArrayList<Proveedor> Obtener() throws ErrorTienda{
        String[] cm = new String[]{"idProveedor", "Nombre", "Telefono", "Direccion", "NIT"};
        
        ArrayList <Object> listaProveedores = new ArrayList();
        try {
            cn.Conectar();
            PreparedStatement ps = cn.BuscarTodos("proveedor", cm);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
               
                listaProveedores.add(rs.getString("IdProveedor"));
                listaProveedores.add(rs.getString("Nombre"));
                listaProveedores.add(rs.getString("Telefono"));
                listaProveedores.add(rs.getString("Direccion"));
                listaProveedores.add(rs.getString("NIT"));
                
            }
            cn.Desconectar();
        } catch (Exception e) {
            throw new ErrorTienda("Class ControladorProveedor/Buscar",e.getMessage());
        }
        ArrayList<Proveedor> listaProveedor = (ArrayList) listaProveedores;
        return listaProveedor;
    }
   
    public Integer ObtenerIdProveedor() throws ErrorTienda{
        
       int Id = 0;
       ResultSet rs;
       PreparedStatement ps;
       try {
           
           cn.Conectar();
           ps = cn.BuscarId("proveedor");
           rs = ps.executeQuery();
           while (rs.next()) {
               Id = rs.getInt("count(*)");
           }
           Id = Id+1;
       } catch (Exception e) {
           throw new ErrorTienda("Error al obtener el IdProveedor", e.getMessage());
       }
       return Id;
    }
    
    public ControladorProveedor(){
        
    }
    
}