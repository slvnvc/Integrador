    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conectar;
import Modelo.OrdenSalida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Silvana Villanueva
 */
public class OrdenSalidaDAO {
    private Connection connection;

    public OrdenSalidaDAO() {
        this.connection = Conectar.getConexion(); // Obtiene la conexión desde la clase Conectar
    }

    // metodo para agregar una nueva orden de salida
    public void agregarOrdenSalida(OrdenSalida ordenSalida) throws SQLException {
        String query = "INSERT INTO ordensalida (ID_Equipo, FechaSalida, Motivo) VALUES (?, ?, ?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, ordenSalida.getIdEquipo());  // Establece el ID del equipo
            stmt.setString(2, ordenSalida.getFechaSalida());  // Establece la fecha de salida
            stmt.setString(3, ordenSalida.getMotivo());  // Establece el motivo de la salida
            stmt.executeUpdate();  // Ejecuta la inserción en la base de datos
        }
    }

//    // Método para obtener todas las órdenes de salida
//    public List<OrdenSalida> obtenerTodasLasOrdenesSalida() throws SQLException {
//        List<OrdenSalida> ordenesSalida = new ArrayList<>();
//        String query = "SELECT * FROM ordensalida";
//
//        try (PreparedStatement stmt = connection.prepareStatement(query);
//             ResultSet rs = stmt.executeQuery()) {
//
//            while (rs.next()) {
//                OrdenSalida ordenSalida = new OrdenSalida(
//                    rs.getInt("ID_OrdenSalida"),  // ID de la orden de salida
//                    rs.getInt("ID_Equipo"),  // ID del equipo relacionado
//                    rs.getString("FechaSalida"),  // Fecha de salida
//                    rs.getString("Motivo")  // Motivo de la salida
//                );
//                ordenesSalida.add(ordenSalida); // Añade la orden de salida a la lista
//            }
//        }
//        return ordenesSalida;
//    }
    public List<OrdenSalida> obtenerTodasLasOrdenesSalida() throws SQLException {
    List<OrdenSalida> ordenesSalida = new ArrayList<>();
    String query = "SELECT os.ID_OrdenSalida, os.ID_Equipo, e.Nombre AS NombreEquipo, p.Nombre AS NombreProveedor, " +
                   "os.FechaSalida, os.Motivo " +
                   "FROM ordensalida os " +
                   "JOIN equipo e ON os.ID_Equipo = e.ID_Equipo " +
                   "JOIN proveedor p ON e.ID_Proveedor = p.ID_Proveedor";

    try (PreparedStatement stmt = connection.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            OrdenSalida ordenSalida = new OrdenSalida(
                rs.getInt("ID_OrdenSalida"),
                rs.getInt("ID_Equipo"),
                rs.getString("NombreEquipo"),     // Llenar el nombre del equipo
                rs.getString("NombreProveedor"),  // Llenar el nombre del proveedor
                rs.getString("FechaSalida"),
                rs.getString("Motivo")
            );
            ordenesSalida.add(ordenSalida);
        }
    }
    return ordenesSalida;
}

}
