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

//    // metodo para agregar una nueva orden de salida
//    public void agregarOrdenSalida(OrdenSalida ordenSalida) throws SQLException {
//        String query = "INSERT INTO ordensalida (ID_Equipo, FechaSalida, Motivo) VALUES (?, ?, ?)";
//        
//        try (PreparedStatement stmt = connection.prepareStatement(query)) {
//            stmt.setInt(1, ordenSalida.getIdEquipo()); 
//            stmt.setString(2, ordenSalida.getFechaSalida());  
//            stmt.setString(3, ordenSalida.getMotivo());  
//            stmt.executeUpdate();  
//        }
//    }
    public int agregarOrdenSalida(OrdenSalida ordenSalida) {
        String sql = "INSERT INTO ordensalida (ID_Equipo, FechaSalida, Motivo) VALUES (?, ?, ?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, ordenSalida.getIdEquipo());
            stmt.setString(2, ordenSalida.getFechaSalida());
            stmt.setString(3, ordenSalida.getMotivo());
            stmt.executeUpdate();

            // Obtener el ID generado
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int idOrdenSalida = rs.getInt(1);
                ordenSalida.setIdOrdenSalida(idOrdenSalida); // Establecer el ID en el objeto OrdenSalida
                return idOrdenSalida; // Retorna el ID generado
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return 0; // Retornar 0 si no se generó correctamente
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

    public boolean existeOrdenSalida(int idOrdenSalida) {
        String sql = "SELECT COUNT(*) FROM ordensalida WHERE ID_OrdenSalida = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idOrdenSalida);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;  // Retorna true si existe la orden de salida
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Manejo de errores
        }
        return false;  // Retorna false si no existe
    }

}
