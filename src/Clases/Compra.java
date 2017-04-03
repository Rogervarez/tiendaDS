/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author HAZAEL
 */
public class Compra {
    public int idCompra;
    public Date fecha;
    public Proveedor proveedor;
    public double total;
    public DetalleCompra articulo;
    
    public Compra(){
        
    }
    
    public double CalcularTotal(){
        total=0;
        for (int i = 0; articulo.cantidad > i; i++) {
            total = articulo.costoUnitario +total;
        }
        return total;
    }
    
    public void AgregarItem( DetalleCompra detalleCompra){
        //DetalleCompra DC = detalleCompra;
        try {
            Conexion cn = new  Conexion();
            Connection conexion = cn.getConexion();
            PreparedStatement st = conexion.prepareStatement("INSERT INTO detallecompra VALUES ("+detalleCompra.producto.CodBarra
                    +", "+idCompra+", "+detalleCompra.cantidad+", "+detalleCompra.costoUnitario+")");
            
            ResultSet rs = st.executeQuery();

        } catch (Exception e) {
        }
    }
}
