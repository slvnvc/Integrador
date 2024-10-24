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
    private int Equipo;//la fk

    public Trabajador(int idTrabajador, String Nombre, String Telefono, String Correo, int Equipo) {
        this.idTrabajador = idTrabajador;
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Equipo = Equipo;
    }
//--
    public int getEquipo() {
        return Equipo;
    }

    public void setEquipo(int Equipo) {
        this.Equipo = Equipo;
    }
//---
    

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
