/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author HAZAEL
 */
public class Venta {
    
    public int idVenta;
    public Date fecha;
    public String cliente;
    public double Total;
    public ArrayList<DetalleVenta> articulo;
    DecimalFormat decimal = new DecimalFormat("0.00");
    public Venta(){
        
    }
    
    public void AgregarItem( DetalleVenta detalleVenta){
        articulo = new ArrayList<DetalleVenta>();
        articulo.add(detalleVenta);
    }
    
    public double CalcularTotal() throws ErrorTienda{
        double total=0;
        try{
            for(DetalleVenta v: this.articulo){
            total=total+((v.PrecioUnitario)*(v.cantidad));
        }
        this.Total=total;
        decimal.setRoundingMode(RoundingMode.CEILING);
        return Double.parseDouble(decimal.format(total));
        }catch(ArithmeticException ex){
            throw new ErrorTienda("Error CalcularTotal", ex.getMessage());
}        
    }
}
