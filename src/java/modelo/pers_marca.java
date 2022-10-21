/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author SistemasU
 */
abstract class pers_marca {
    private int idmarca;
    private String marca;

    public pers_marca(){}
    public pers_marca(int idmarca, String marca) {
        this.idmarca = idmarca;
        this.marca = marca;
    }
    

    public int getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(int idmarca) {
        this.idmarca = idmarca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public int agregar(){return 0;}
    public int modificar(){return 0;}
    public int eliminar(){return 0;}    
}
