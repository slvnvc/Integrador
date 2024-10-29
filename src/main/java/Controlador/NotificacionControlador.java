/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author Silvana Villanueva
 */
import DAO.NotificacionDAO;
import DAO.OrdenSalidaDAO;
import Modelo.Notificacion;
import java.sql.SQLException;
import java.util.ArrayList;

public class NotificacionControlador {
    private NotificacionDAO notificacionDAO;
    private OrdenSalidaDAO ordenSalidaDAO;


    public NotificacionControlador() {
    this.notificacionDAO = notificacionDAO;
    this.ordenSalidaDAO = ordenSalidaDAO;
}


    public void agregarNotificacion(int idOrdenSalida, String mensajeNotificacion) {
        // Validar existencia de la orden de salida
        if (ordenSalidaDAO.existeOrdenSalida(idOrdenSalida)) {
            // Solo agregar la notificación si la orden de salida existe
            notificacionDAO.agregarNotificacion(idOrdenSalida, mensajeNotificacion);
        } else {
            System.out.println("La orden de salida no existe. No se puede agregar la notificación.");
            // Puedes lanzar una excepción o agregar lógica adicional
        }
    }

    // Método para obtener notificaciones por ID de orden de salida
    public ArrayList<Notificacion> obtenerNotificaciones(int idOrdenSalida) throws SQLException {
        return notificacionDAO.getNotificaciones(idOrdenSalida);
    }

 public void crearNotificacionSalida(int idOrdenSalida, String equipo, String motivo, String fecha) {
        // Verifica si la orden de salida existe antes de crear la notificación
        if (ordenSalidaDAO.existeOrdenSalida(idOrdenSalida)) {
            // Crear el mensaje de notificación
            String mensajeNotificacion = "Se ha registrado la salida del equipo: " + equipo + "\nMotivo: " + motivo;
            notificacionDAO.agregarNotificacion(idOrdenSalida, mensajeNotificacion); // Manejo de excepciones
            System.out.println("Notificación creada con éxito.");
        } else {
            System.out.println("La orden de salida con ID " + idOrdenSalida + " no existe. No se puede crear la notificación.");
        }
    }

}
