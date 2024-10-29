/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Silvana Villanueva
 */
import Conexion.Conectar;
import Modelo.Notificacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NotificacionDAO {
    private Connection connection;

    public NotificacionDAO() {
        this.connection = Conectar.getConexion();
    }

    // metodo para obtener notificaciones por id de orden de salida
    public static ArrayList<Notificacion> getNotificacionesPorOrdenSalida(int idOrdenSalida) {
        ArrayList<Notificacion> notificaciones = new ArrayList<>();
        Connection con = Conectar.getConexion();
        String sql = """
                     SELECT ID_Notificacion, ID_OrdenSalida, Nombre, Mensaje
                     FROM notificacion
                     WHERE ID_OrdenSalida = ?
                     """;

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, idOrdenSalida);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Notificacion notificacion = new Notificacion(
                    rs.getInt("ID_OrdenSalida"),   
                    rs.getString("Nombre"),        
                    rs.getString("Mensaje")        
                );
                notificacion.setIdNotificacion(rs.getInt("ID_Notificacion")); // establece el id de noti 
                notificaciones.add(notificacion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return notificaciones;
    }

    // metodo para agregar una nueva notificación
    public static void addNotificacion(Notificacion notificacion) {
        Connection con = Conectar.getConexion();
        String sql = "INSERT INTO notificacion (ID_OrdenSalida, Nombre, Mensaje) VALUES (?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, notificacion.getIdOrdenSalida());
            ps.setString(2, notificacion.getNombre());
            ps.setString(3, notificacion.getMensaje());
            ps.executeUpdate();
            System.out.println("Notificación agregada exitosamente.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
