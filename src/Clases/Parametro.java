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
import java.util.Arrays;

/**
 *
 * @author Roger
 */
public class Parametro {
    private String idParametro;
    private String nombre;
    private String valor;
    
    public Parametro(){
        //this.idParametro = id;
        //this.nombre = nombreParametro;
        //this.valor = valorParametro;
    }
    
    public ArrayList <Parametro> Obtener(){
        String[] cm = new String[]{"idParametro", "Nombre", "Valor"};
        conection cn = new conection();
        ArrayList <Parametro> listaParametros = new ArrayList();
        try {
            cn.Conectar();
            PreparedStatement ps = cn.BuscarTodos("parametros", cm);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Parametro parametro = new Parametro();
                parametro.idParametro = rs.getString("idParametro");
                parametro.nombre = rs.getString("Nombre");
                parametro.valor = rs.getString("Valor");
                listaParametros.add(parametro);
            }
//            System.out.println(listaParametros.toString());
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
        return listaParametros;
    }
    
    public Parametro ObtenerUtilidad(){
        Parametro parametro = new Parametro();
        try{
            String nombreParametro = "Utilidad";
            iList p = new iList(new ListasTablas("Nombre",nombreParametro));
            conection cn = new conection();
            cn.Conectar();
            String cm[] = new String[]{"Valor"};
            PreparedStatement ps = cn.BuscarRegistro("parametros", cm, p);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("La utilidad es: " + rs.getString("Valor"));
                parametro.idParametro = rs.getString("idParametro");
                parametro.nombre = rs.getString("Nombre");
                parametro.valor = rs.getString("Valor");
            }
        } catch(Exception ex){
        }
        
        return parametro;
    }

    /**
     * @return the idParametro
     */
    public String getIdParametro() {
        return idParametro;
    }

    /**
     * @param idParametro the idParametro to set
     */
    public void setIdParametro(String idParametro) {
        this.idParametro = idParametro;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }
}
