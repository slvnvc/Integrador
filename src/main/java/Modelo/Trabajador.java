/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Silvana Villanueva
 */
    public class Trabajador {
    private int idTrabajador;
    private String Nombre;
    private String Telefono;
    private String Correo;
    private String DNI;
    private String equipos;

    public Trabajador(int idTrabajador, String Nombre, String Telefono, String Correo, String DNI) {
        this.idTrabajador = idTrabajador;
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.DNI = DNI;
    }

    public Trabajador(int idTrabajador, String Nombre, String Telefono, String Correo, String DNI, String equipos) {
        this.idTrabajador = idTrabajador;
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.DNI = DNI;
        this.equipos = equipos;
    }

    public String getEquipos() {
        return equipos;
    }

    public void setEquipos(String equipos) {
        this.equipos = equipos;
    }
    
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }


    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    
    
}
