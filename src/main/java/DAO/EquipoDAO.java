package dao;

import Modelo.Equipo;
import Conexion.Conectar; 
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipoDAO {
    private Connection connection;

    public EquipoDAO() {
        this.connection = Conectar.getConexion();  
        }
    

    // Método para insertar un equipo
    public void insertarEquipo(Equipo equipo) throws SQLException {
        String query = "INSERT INTO equipo (Nombre, Marca, Categoria, Modelo, NumeroSerie, CodigoInventario, Estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, equipo.getNombre());
            stmt.setString(2, equipo.getMarca());
            stmt.setString(3, equipo.getCategoria());
            stmt.setString(4, equipo.getModelo());
            stmt.setString(5, equipo.getNumeroSerie());
            stmt.setString(6, equipo.getCodigoInventario());
            stmt.setString(7, equipo.getEstado());
            stmt.executeUpdate();
        }
    }

    
    public List<Equipo> obtenerTodosLosEquipos() throws SQLException {
        String query = "SELECT * FROM equipo";
        List<Equipo> equipos = new ArrayList<>();
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Equipo equipo = new Equipo(
                        rs.getInt("IdEquipo"),
                        rs.getString("Nombre"),
                        rs.getString("Marca"),
                        rs.getString("Categoria"),
                        rs.getString("Modelo"),
                        rs.getString("NumeroSerie"),
                        rs.getString("CodigoInventario"),
                        rs.getString("Estado")
                );
                equipos.add(equipo);
            }
        }
        return equipos;
    }

    
    public void eliminarEquipo(int idEquipo) throws SQLException {
        String query = "DELETE FROM equipo WHERE IdEquipo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idEquipo);
            stmt.executeUpdate();
        }
    }

    
    public void actualizarEquipo(Equipo equipo) throws SQLException {
        String query = "UPDATE equipo SET Nombre = ?, Marca = ?, Categoria = ?, Modelo = ?, NumeroSerie = ?, CodigoInventario = ?, Estado = ? WHERE IdEquipo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, equipo.getNombre());
            stmt.setString(2, equipo.getMarca());
            stmt.setString(3, equipo.getCategoria());
            stmt.setString(4, equipo.getModelo());
            stmt.setString(5, equipo.getNumeroSerie());
            stmt.setString(6, equipo.getCodigoInventario());
            stmt.setString(7, equipo.getEstado());
            stmt.setInt(8, equipo.getIdEquipo());
            stmt.executeUpdate();
        }
    }

    // Método para obtener un equipo por su ID
    public Equipo obtenerEquipoPorId(int idEquipo) throws SQLException {
        String query = "SELECT * FROM equipo WHERE IdEquipo = ?";
        Equipo equipo = null;
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idEquipo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    equipo = new Equipo(
                            rs.getInt("IdEquipo"),
                            rs.getString("Nombre"),
                            rs.getString("Marca"),
                            rs.getString("Categoria"),
                            rs.getString("Modelo"),
                            rs.getString("NumeroSerie"),
                            rs.getString("CodigoInventario"),
                            rs.getString("Estado")
                    );
                }
            }
        }
        return equipo;
    }
}
