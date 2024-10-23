/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ANIBAL
 */
public class Encargado {
    
    private int ipEncargado;
    private String Nombre;
    private String Telefono;
    private String Correo;
    private String Contraseña;

    public Encargado(int ipEncargado, String Nombre, String Telefono, String Correo, String Contraseña) {
        this.ipEncargado = ipEncargado;
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Contraseña = Contraseña;
    }

    public int getIpEncargado() {
        return ipEncargado;
    }

    public void setIpEncargado(int ipEncargado) {
        this.ipEncargado = ipEncargado;
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

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }
    
    
           
    
}
