/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SistemasU
 */
public class marca{
    private int idmarca;
    private String marca;

    private conexion cn;
    public marca(){}
    public marca(int idmarca, String marca) {
        this.idmarca = idmarca;
        this.marca = marca;
    }
    
    //@Override
    public int getIdmarca() {
        return idmarca;
    }

    //@Override
    public void setIdmarca(int idmarca) {
        this.idmarca = idmarca;
    }

    //@Override
    public String getMarca() {
        return marca;
    }

    //@Override
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public HashMap drop_marcas(){
        HashMap<String,String> drop = new HashMap();
        try{
            cn = new conexion();
            String query = "SELECT idmarca as id,marca FROM marcas;";
            cn.abrir_conexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            while (consulta.next()){
                drop.put(consulta.getString("id"), consulta.getString("marca"));
            }
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return drop;
    }
    
    public DefaultTableModel leer(){
    DefaultTableModel tabla = new DefaultTableModel();
    try{
        cn = new conexion();
        cn.abrir_conexion();
            String query = "SELECT * FROM marcas;";
            
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            String encabezado[] = {"id","Marca"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[] = new String[2];
            while (consulta.next()){
                datos[0] = consulta.getString("idmarca");
                datos[1] = consulta.getString("marca");
                tabla.addRow(datos);
                
            }
        cn.cerrar_conexion();
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    
    return tabla;
    }    
//@Override
    public int agregar(){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new conexion();
            
            String query = "INSERT INTO marcas (marca) VALUES (?);";
            
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1, getMarca());
            
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
            
        }catch(SQLException ex){    
            System.out.println(ex.getMessage());
            retorno = 0;
    }
        return retorno;
  }   
    
  //  @Override
    public int modificar(){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new conexion();
            
            String query = "UPDATE marcas SET marca=? WHERE idmarca=?;";
            //String query = "UPDATE estudiantes SET carne=?,nombres=?,apellidos=?,direccion=?,telefono=?,correo_electronico=?,fecha_nacimiento=?,id_tipo_sangre=? where id_estudiante=?";
            
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
         
            parametro.setString(1, getMarca());
            parametro.setInt(2, getIdmarca());
            
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
            
        }catch(SQLException ex){    
            System.out.println(ex.getMessage());
            retorno = 0;
    }
        return retorno;
  }   
    
    //@Override
    public int eliminar(){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new conexion();
            
            String query = "DELETE FROM marcas WHERE idmarca=?;";
            
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, getIdmarca());
            
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
            
        }catch(SQLException ex){    
            System.out.println(ex.getMessage());
            retorno = 0;
        }
          return retorno;
  }   
}
