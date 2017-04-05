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
public class Parametro {
    public String idParametro;
    public String nombre;
    public String valor;
    
    public Parametro(){
        
    }
    
    public void Obtener(){
        String[] cm = new String[]{"idParametro", "Nombre", "Valor"};
        conection cn = new conection();
        try {
            cn.Conectar();
            PreparedStatement ps = cn.BuscarTodos("parametro", cm);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                T.model.addElement(rs.getString("idespecialidadMD") + " --- " + rs.getString("nombreEspecialidadMD"));
            }
            T.lst_esp1.setModel(T.model);
            cn.Desconectar();
        } catch (Exception ex) {
            try {
                print.mensaje("Algo ha impedido la lectura de datos: " + ex.getMessage() + "\n" + "Aparentemente el usuario buscado no exixte." + "\n" + "Busque nuevamente con otro ID", "Error ML.guardarConsulta");
                cn.Desconectar();
            } catch (Exception o) {
                print.mensaje("Un grabe error se ha dado mientra usted intentaba buscar paciente: El servidor podría estar apagado, enciéndalo. Intentelo de nuevo y si el error persiste llame a su proveedor" + o.getMessage(), "Error ML.buscarPaciente");
            }
        }
    }
    
    public void ObtenerUtilidad( Parametro parametro ){
        
    }
}
