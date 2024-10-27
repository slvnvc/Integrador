/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Silvana Villanueva
 */
public class OrdenAsignacion {
    private int idOrdenAsignacion;
    private int idEquipo;  // fk
    private int idTrabajador;  //fk
    private String fechaAsignacion;
    private String area;
    private String nombreTrabajador; 
    private String nombreEquipo;      

    public OrdenAsignacion(int idOrdenAsignacion, int idEquipo, int idTrabajador, String fechaAsignacion, String area, String nombreTrabajador, String nombreEquipo) {
        this.idOrdenAsignacion = idOrdenAsignacion;
        this.idEquipo = idEquipo;
        this.idTrabajador = idTrabajador;
        this.fechaAsignacion = fechaAsignacion;
        this.area = area;
        this.nombreTrabajador = nombreTrabajador; 
        this.nombreEquipo = nombreEquipo;       
    }

    // constructor sin id 
    public OrdenAsignacion(int idEquipo, int idTrabajador, String fechaAsignacion, String area) {
        this.idEquipo = idEquipo;
        this.idTrabajador = idTrabajador;
        this.fechaAsignacion = fechaAsignacion;
        this.area = area;
    }

    public String getNombreTrabajador() {
        return nombreTrabajador;
    }

    public String getNombreEquipo() {
        return nombreEquipo; // para obtener el nombre del equipo
    }

    public int getIdOrdenAsignacion() {
        return idOrdenAsignacion;
    }

    public void setIdOrdenAsignacion(int idOrdenAsignacion) {
        this.idOrdenAsignacion = idOrdenAsignacion;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(String fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
