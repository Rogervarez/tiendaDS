/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor
 */
package Clases;

/**
 *
 * @author HAZAEL
 */
public class Proveedor {
    private int idProveedor;
    private String nombre;
    private String telefono;
    private String direccion;
    private String nit;
    
    // Contructo sin argumentos para instaciar
    public Proveedor(){
    
    }
    
    // Contrucrtor con argumentos para instaciar 
    public Proveedor( int idProveedor, String nombre, String telefono, String direccion, String nit ){
        
        setTelefono(telefono);
        setNIT(nit);
        
        this.idProveedor = idProveedor; 
        this.nombre = nombre;
        this.telefono = getTelefono();
        this.direccion = direccion;
        this.nit = getNIT();
    }
    
    // metodos establecer y obtener 
    // metodo establecer telefono para dejar la variable en un estado conciente
    public void setTelefono( String telefono ){
        
        int numTelefono = 0;
        numTelefono = Integer.parseInt( telefono );
        
        if( numTelefono <= 99999999 && numTelefono >= 10000000 ){
            telefono = Integer.toString(numTelefono);
            this.telefono = telefono;
        }else {
            this.telefono = "";
        }
    }
    
    // metodo optener telefono
    public String getTelefono(){
        return telefono;
    }
    
    // metodo para establecer nit del proveedor
    public void setNIT( String nit ){
       
        int numNIT = 0;
        numNIT = Integer.parseInt( nit );
        
        if( numNIT <= 99999999 && numNIT >= 10000000 ){
            nit = Integer.toString(numNIT);
            this.nit = nit;
        }else {
            this.nit = "";
        }
    }
    
    // metodo para obtener nit del proveedor
    public String getNIT(){
        return nit;
    }
    
}