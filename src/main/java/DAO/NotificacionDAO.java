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

    public void agregarNotificacion(int idOrdenSalida, String mensajeNotificacion) {
        String sql = "INSERT INTO notificacion (ID_OrdenSalida, Mensaje) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idOrdenSalida);
            stmt.setString(2, mensajeNotificacion);
            stmt.executeUpdate();
            System.out.println("Notificación agregada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Notificacion> getNotificaciones(int idOrdenSalida) throws SQLException {
        ArrayList<Notificacion> notificaciones = new ArrayList<>();
        String sql = "SELECT * FROM notificacion WHERE ID_OrdenSalida = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idOrdenSalida);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Notificacion notificacion = new Notificacion(
                    rs.getInt("ID_OrdenSalida"),
                    rs.getString("Mensaje"),
                    rs.getString("Fecha")
                );
                notificaciones.add(notificacion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return notificaciones;
    }
}
