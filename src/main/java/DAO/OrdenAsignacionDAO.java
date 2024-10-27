/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conectar;
import Modelo.OrdenAsignacion;
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
public class OrdenAsignacionDAO {
    private Connection connection;

    public OrdenAsignacionDAO() {
        this.connection = Conectar.getConexion();
    }

    // metodo para insertar una nueva oa
    public void agregarOrdenAsignacion(OrdenAsignacion ordenAsignacion) throws SQLException {
        String query = "INSERT INTO ordenasignacion (ID_Equipo, ID_Trabajador, FechaAsignacion, Area) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, ordenAsignacion.getIdEquipo());  
            stmt.setInt(2, ordenAsignacion.getIdTrabajador());  
            stmt.setString(3, ordenAsignacion.getFechaAsignacion());  
            stmt.setString(4, ordenAsignacion.getArea());  
            stmt.executeUpdate();  
        }
    }

    // metodo para obtener todas las oa
    public List<OrdenAsignacion> obtenerTodasLasOrdenesA() throws SQLException {
    String query = "SELECT oa.*, t.Nombre AS nombreTrabajador, e.Nombre AS nombreEquipo " + 
                   "FROM ordenasignacion oa " +
                   "JOIN trabajador t ON oa.ID_Trabajador = t.ID_Trabajador " +
                   "JOIN equipo e ON oa.ID_Equipo = e.ID_Equipo"; // uniendo tabla trabjador con equipo 
    
    List<OrdenAsignacion> listaOrdenes = new ArrayList<>();
    
    try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
        while (rs.next()) {
            OrdenAsignacion orden = new OrdenAsignacion(
                rs.getInt("ID_OrdenAsignacion"),
                rs.getInt("ID_Equipo"),
                rs.getInt("ID_Trabajador"),
                rs.getString("FechaAsignacion"),
                rs.getString("Area"),
                rs.getString("nombreTrabajador"), //obtener el nombre del trabajador
                rs.getString("nombreEquipo")      //obtener el nombre del equipo
            );
            listaOrdenes.add(orden);
        }
    }
    return listaOrdenes;
}
}
