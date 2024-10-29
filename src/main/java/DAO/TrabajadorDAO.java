/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conectar;
import Modelo.Equipo;
import Modelo.Trabajador;
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
public class TrabajadorDAO {
    private Connection connection;

    public TrabajadorDAO() {
        this.connection = Conectar.getConexion();  
        }
    

    // Metodo para agregar un trabajador
    public void agregarTrabajador(Trabajador trabajador) throws SQLException {
        String query = "INSERT INTO trabajador (Nombre, Telefono, Correo, DNI) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, trabajador.getNombre());
            stmt.setString(2, trabajador.getTelefono());
            stmt.setString(3, trabajador.getCorreo());
            stmt.setString(4, trabajador.getDNI());
            stmt.executeUpdate();
        }
    }

        public List<Trabajador> obtenerTrabajadoresConEquipos() throws SQLException {
    String query = "SELECT t.ID_Trabajador, t.Nombre, t.Telefono, t.Correo, t.DNI, " +
                   "GROUP_CONCAT(e.Nombre SEPARATOR ', ') AS Equipos " +
                   "FROM trabajador t " +
                   "LEFT JOIN ordenasignacion oa ON t.ID_Trabajador = oa.ID_Trabajador " +
                   "LEFT JOIN equipo e ON oa.ID_Equipo = e.ID_Equipo " +
                   "GROUP BY t.ID_Trabajador";
                   
        List<Trabajador> trabajadores = new ArrayList<>();
    
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
        while (rs.next()) {
            Trabajador trabajador = new Trabajador(
                rs.getInt("ID_Trabajador"),
                rs.getString("Nombre"),
                rs.getString("Telefono"),
                rs.getString("Correo"),
                rs.getString("DNI"),
                rs.getString("Equipos") // Nueva columna para equipos concatenados
            );
            trabajadores.add(trabajador);
        }
    }
    return trabajadores;
}

       public List<Trabajador> buscarTrabajadoresPorEquipo(String nombreEquipo) throws SQLException {
    String query = "SELECT t.ID_Trabajador, t.Nombre, t.DNI, t.Telefono, t.Correo, " +
                   "e.Nombre AS Equipo " +
                   "FROM trabajador t " +
                   "JOIN ordenasignacion oa ON t.ID_Trabajador = oa.ID_Trabajador " +
                   "JOIN equipo e ON oa.ID_Equipo = e.ID_Equipo " +
                   "WHERE e.Nombre LIKE ?";
                   
    List<Trabajador> trabajadores = new ArrayList<>();
    
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setString(1, "%" + nombreEquipo + "%"); // Búsqueda parcial del equipo
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Trabajador trabajador = new Trabajador(
                    rs.getInt("ID_Trabajador"),
                    rs.getString("Nombre"),
                    rs.getString("DNI"),
                    rs.getString("Telefono"),
                    rs.getString("Correo"),
                    rs.getString("Equipo") // Nombre del equipo asignado
                );
                trabajadores.add(trabajador);
            }
        }
    }
    return trabajadores;
}

        public int obtenerIdTrabajadorPorNombre(String nombreTrabajador) throws SQLException {
    String query = "SELECT ID_Trabajador FROM trabajador WHERE Nombre = ?";
    int idTrabajador = -1;  // valor por defecto por si no se encuentra

    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setString(1, nombreTrabajador);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                idTrabajador = rs.getInt("ID_Trabajador");
            }
        }
    }
    return idTrabajador;
}

    
    
}
