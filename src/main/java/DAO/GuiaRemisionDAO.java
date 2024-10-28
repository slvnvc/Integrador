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
import Modelo.GuiaRemision;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GuiaRemisionDAO {
    private Connection connection;

    public GuiaRemisionDAO() {
        this.connection = Conectar.getConexion(); // Inicializa la conexión
    }

    // Método para insertar una nueva guía de remisión
   public void agregarGuiaRemision(GuiaRemision guia) throws SQLException {
    String query = "INSERT INTO guiaremision (ID_OrdenCompra, ID_Proveedor, FechaRecepcion, Comentarios) VALUES (?, ?, ?, ?)";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setInt(1, guia.getIdOrdenCompra());
        stmt.setInt(2, guia.getIdProveedor()); // Incluye el ID del proveedor
        stmt.setString(3, guia.getFechaRecepcion());
        stmt.setString(4, guia.getComentarios());
        stmt.executeUpdate();
    }
    }

    // Método para obtener todas las guías de remisión con información adicional (JOIN)
    public List<GuiaRemision> obtenerTodasLasGuiasRemision() throws SQLException {
        List<GuiaRemision> guias = new ArrayList<>();
        String query = "SELECT g.ID_Guia, g.ID_OrdenCompra, oc.FechaOrden AS FechaOrdenCompra, p.Nombre AS NombreProveedor, " +
                       "g.FechaRecepcion, g.Comentarios " +
                       "FROM guiaremision g " +
                       "JOIN ordencompra oc ON g.ID_OrdenCompra = oc.ID_OrdenCompra " +
                       "JOIN proveedor p ON oc.ID_Proveedor = p.ID_Proveedor";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                GuiaRemision guia = new GuiaRemision(
                    rs.getInt("ID_Guia"),
                    rs.getInt("ID_OrdenCompra"),
                    rs.getString("FechaOrdenCompra"),
                    rs.getString("NombreProveedor"),
                    rs.getString("FechaRecepcion"),
                    rs.getString("Comentarios")
                );
                guias.add(guia);
            }
        }
        return guias;
    }
}
