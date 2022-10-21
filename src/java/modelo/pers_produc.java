/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author SistemasU
 */
abstract class pers_produc {
    private int idp,exitencia;
    private String descripcion,imagen,fecha_ingreso;
    private float precio_costos,precio_venta;

    public pers_produc(){}
    public pers_produc(int idp, int exitencia, String descripcion, String imagen, String fecha_ingreso, float precio_costos, float precio_venta) {
        this.idp = idp;
        this.exitencia = exitencia;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.fecha_ingreso = fecha_ingreso;
        this.precio_costos = precio_costos;
        this.precio_venta = precio_venta;
    }
    
    

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public int getExitencia() {
        return exitencia;
    }

    public void setExitencia(int exitencia) {
        this.exitencia = exitencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public float getPrecio_costos() {
        return precio_costos;
    }

    public void setPrecio_costos(float precio_costos) {
        this.precio_costos = precio_costos;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }
     
    public int agregar(){return 0;}
    public int modificar(){return 0;}
    public int eliminar(){return 0;}

    
}
