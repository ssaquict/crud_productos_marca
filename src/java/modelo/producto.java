/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SistemasU
 */
public class producto extends pers_produc{
    private String producto;
    private int idmarca;

    private conexion cn;
    public producto() {}
    public producto(String producto, int idmarca, int idp, int exitencia, String descripcion, String imagen, String fecha_ingreso, float precio_costos, float precio_venta) {
        super(idp, exitencia, descripcion, imagen, fecha_ingreso, precio_costos, precio_venta);
        this.producto = producto;
        this.idmarca = idmarca;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(int idmarca) {
        this.idmarca = idmarca;
    }

 public DefaultTableModel leer(){
    DefaultTableModel tabla = new DefaultTableModel();
    try{
        cn = new conexion();
        cn.abrir_conexion();
            String query = "SELECT p.idproductos AS id,p.producto,p.descripcion,p.imagen,p.precio_costo,p.precio_venta,p.existencia,p.fecha_ingreso,m.marca,m.idmarca FROM productos AS p INNER JOIN marcas AS m ON p.idmarca = m.idmarca;";
            
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            String encabezado[] = {"id","Producto","Descripcion","Imagen","Precio Costo","Precio Venta","Existencia","Fecha Ingreso","Marca","Id Marca"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[] = new String[10];
            while (consulta.next()){
                datos[0] = consulta.getString("id");
                datos[1] = consulta.getString("producto");
                datos[2] = consulta.getString("descripcion");
                datos[3] = consulta.getString("imagen");
                datos[4] = consulta.getString("precio_costo");
                datos[5] = consulta.getString("precio_venta");
                datos[6] = consulta.getString("existencia");
                datos[7] = consulta.getString("fecha_ingreso");
                datos[8] = consulta.getString("marca");
                datos[9] = consulta.getString("idmarca");
                tabla.addRow(datos);
                
            }
        cn.cerrar_conexion();
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    
    return tabla;
    }    

@Override
    public int agregar(){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new conexion();
            
            String query = "INSERT INTO productos (producto,idmarca,descripcion,imagen,precio_costo,precio_venta,existencia,fecha_ingreso) VALUES (?,?,?,?,?,?,?,?);";
            
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1, getProducto());
            parametro.setInt(2, getIdmarca());
            parametro.setString(3, getDescripcion());
            parametro.setString(4, getImagen());
            parametro.setFloat(5, getPrecio_costos());
            parametro.setFloat(6, getPrecio_venta());
            parametro.setInt(7, getExitencia());
            parametro.setString(8, getFecha_ingreso());
            
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
            
        }catch(SQLException ex){    
            System.out.println(ex.getMessage());
            retorno = 0;
    }
        return retorno;
  }   
    
        @Override
    public int modificar(){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new conexion();
            
            String query = "UPDATE productos SET producto=?,idmarca=?,descripcion=?,imagen=?,precio_costo=?,precio_venta=?,existencia=?,fecha_ingreso=? WHERE idproductos=?;";
                        
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
         
            parametro.setString(1, getProducto());
            parametro.setInt(2, getIdmarca());
            parametro.setString(3, getDescripcion());
            parametro.setString(4, getImagen());
            parametro.setFloat(5, getPrecio_costos());
            parametro.setFloat(6, getPrecio_venta());
            parametro.setInt(7, getExitencia());
            parametro.setString(8, getFecha_ingreso());
            parametro.setInt(9, getIdp());
            
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
            
        }catch(SQLException ex){    
            System.out.println(ex.getMessage());
            retorno = 0;
    }
        return retorno;
  }   
    @Override
    public int eliminar(){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new conexion();
            
            String query = "DELETE FROM productos WHERE idproductos=?";
            
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, getIdp());
            
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
            
        }catch(SQLException ex){    
            System.out.println(ex.getMessage());
            retorno = 0;
        }
          return retorno;
  }   
  
}
