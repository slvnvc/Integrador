/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Silvana Villanueva
 */
public class OrdenSalida {
    private int idOrdenSalida;
    private int idEquipo;
    private String nombreEquipo;     
    private String nombreProveedor;   
    private String fechaSalida;
    private String motivo;

    // Constructor completo con nombre de equipo y proveedor
    public OrdenSalida(int idOrdenSalida, int idEquipo, String nombreEquipo, String nombreProveedor, String fechaSalida, String motivo) {
        this.idOrdenSalida = idOrdenSalida;
        this.idEquipo = idEquipo;
        this.nombreEquipo = nombreEquipo;
        this.nombreProveedor = nombreProveedor;
        this.fechaSalida = fechaSalida;
        this.motivo = motivo;
    }
    public OrdenSalida(int idOrdenSalida, int idEquipo, String fechaSalida, String motivo) {
        this.idOrdenSalida = idOrdenSalida;
        this.idEquipo = idEquipo;
        this.fechaSalida = fechaSalida;
        this.motivo = motivo;
    }
    public OrdenSalida(int idEquipo, String fechaSalida, String motivo) {
        this.idEquipo = idEquipo;
        this.fechaSalida = fechaSalida;
        this.motivo = motivo;
    }
    // Getters y setters para los atributos
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public String getMotivo() {
        return motivo;
    }
    public int getIdOrdenSalida() {
        return idOrdenSalida;
    }

    public void setIdOrdenSalida(int idOrdenSalida) {
        this.idOrdenSalida = idOrdenSalida;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }
}

