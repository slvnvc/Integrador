/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ANIBAL
 */
public class Encarga {
    
    private int idEncargado;
    private String Nombre;
    private String Telefono;
    private String Correo;
    private String Contraña;

    public Encarga(int idEncargado, String Nombre, String Telefono, String Correo, String Contraña) {
        this.idEncargado = idEncargado;
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Contraña = Contraña;
    }

    public int getIdEncargado() {
        return idEncargado;
    }

    public void setIdEncargado(int idEncargado) {
        this.idEncargado = idEncargado;
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

    public String getContraña() {
        return Contraña;
    }

    public void setContraña(String Contraña) {
        this.Contraña = Contraña;
    }
    
    
    
    
}
