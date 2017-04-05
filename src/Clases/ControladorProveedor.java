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
    //public void Agregar(Proveedor proveedor){
    //}
    //public void Modificar(Proveedor proveedor){
    //}
    public void Eliminar(Proveedor P) {
        conection cn = new conection();
        try {
            cn.Conectar();
            iList cond = new iList(new ListasTablas("idProveedor", P.idProveedor));
            //Se pueden seguir agregando condiciones para hacer el delete
            //cond.add(new ListasTablas("telefono", P.telefono));
            if (cn.Eliminar("proveedor", cond)) {
                System.out.println("Registro eliminado exitosamente");
            }

        } catch (Exception ex) {
            System.out.println("No se pudo eliminar el registro" + ex);
        }
    }

    //public ArrayList <Proveedor> Buscar(String criterio){
    //}
    
    public ArrayList <Proveedor> Obtener(){
        String[] cm = new String[]{"idProveedor", "Nombre", "Telefono", "Direccion", "NIT"};
        conection cn = new conection();
        ArrayList <Proveedor> listaProveedores = new ArrayList();
        try {
            cn.Conectar();
            PreparedStatement ps = cn.BuscarTodos("proveedor", cm);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                //T.model.addElement(rs.getString("idespecialidadMD") + " --- " + rs.getString("nombreEspecialidadMD"));
                Proveedor proveedor = new Proveedor();
                proveedor.idProveedor = rs.getInt("idProveedor");
                proveedor.nombre = rs.getString("Nombre");
                proveedor.telefono = rs.getString("Telefono");
                proveedor.direccion = rs.getString("Direccion");
                proveedor.nit = rs.getString("NIT");
                listaProveedores.add(proveedor);
            }
            System.out.println(listaProveedores.toString());
            cn.Desconectar();
        } catch (Exception ex) {
            try {
                //print.mensaje("Algo ha impedido la lectura de datos: " + ex.getMessage() + "\n" + "Aparentemente el usuario buscado no exixte." + "\n" + "Busque nuevamente con otro ID", "Error ML.guardarConsulta");
                cn.Desconectar();
            } catch (Exception o) {
                System.out.println("No se ha podido desconectar");
                //print.mensaje("Un grabe error se ha dado mientra usted intentaba buscar paciente: El servidor podría estar apagado, enciéndalo. Intentelo de nuevo y si el error persiste llame a su proveedor" + o.getMessage(), "Error ML.buscarPaciente");
            }
        }
        return listaProveedores;
    }
   
    public Integer ObtenerIdProveedor(){
        int elId = 0;
        String[] cm = new String[]{"idProveedor"};
        conection cn = new conection();
        ArrayList <Integer> listaIds = new ArrayList();
        try {
            cn.Conectar();
            PreparedStatement ps = cn.BuscarTodos("proveedor", cm);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("idProveedor");
                listaIds.add(id);
            }
            cn.Desconectar();
            System.out.println(listaIds.toString());
            elId = listaIds.get(listaIds.size() - 1);
            System.out.println("EL ID: " + elId);
            
        } catch (Exception ex) {
            try {
                //print.mensaje("Algo ha impedido la lectura de datos: " + ex.getMessage() + "\n" + "Aparentemente el usuario buscado no exixte." + "\n" + "Busque nuevamente con otro ID", "Error ML.guardarConsulta");
                cn.Desconectar();
            } catch (Exception o) {
                System.out.println("No se ha podido desconectar");
                //print.mensaje("Un grabe error se ha dado mientra usted intentaba buscar paciente: El servidor podría estar apagado, enciéndalo. Intentelo de nuevo y si el error persiste llame a su proveedor" + o.getMessage(), "Error ML.buscarPaciente");
            }
        }
        return elId;
    }
    
    public ControladorProveedor(){
        
    }
    
}
