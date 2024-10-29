/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Silvana Villanueva
 */
public class Notificacion {
    private int idNotificacion; // ID de la notificación
    private int idOrdenSalida; // ID de la orden de salida relacionada
    private String mensaje; // Mensaje de la notificación
    private String fecha; // Fecha de creación de la notificación

    // Constructor
    public Notificacion(int idOrdenSalida, String mensaje, String fecha) {
        this.idOrdenSalida = idOrdenSalida;
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    // Getters y Setters
    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public int getIdOrdenSalida() {
        return idOrdenSalida;
    }

    public void setIdOrdenSalida(int idOrdenSalida) {
        this.idOrdenSalida = idOrdenSalida;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}


