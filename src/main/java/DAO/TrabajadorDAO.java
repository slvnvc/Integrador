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
    

    // Método para agregar un trabajador
    public void agregarTrabajador(Trabajador trabajador) throws SQLException {
        String query = "INSERT INTO trabajador (Nombre, Telefono, Correo, ID_Equipo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, trabajador.getNombre());
            stmt.setString(2, trabajador.getTelefono());
            stmt.setString(3, trabajador.getCorreo());
            stmt.setInt(4, trabajador.getEquipo());
            stmt.executeUpdate();
        }
    }

//    public List<Equipo> obtenerTodosLosEquipos() throws SQLException {
//        String query = "SELECT * FROM equipo";
//        List<Equipo> equipos = new ArrayList<>();
//        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
//            while (rs.next()) {
//                Equipo equipo = new Equipo(
//                        /*rs.getInt("IdEquipo"),*/
//                        rs.getInt("id_equipo"),
//                        rs.getString("Nombre"),
//                        rs.getString("Marca"),
//                        rs.getString("Categoria"),
//                        rs.getString("Modelo"),
//                        rs.getString("NumeroSerie"),
//                        rs.getString("CodigoInventario"),
//                        rs.getString("Estado")
//                );
//                equipos.add(equipo);
//            }
//        }
//        return equipos;
//    }
        public List<Trabajador> obtenerTodosLosTrabajadores() throws SQLException {
        String query = "SELECT * FROM trabajador";
        List<Trabajador> trabajadores = new ArrayList<>();
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Trabajador trabajador = new Trabajador(
                        /*rs.getInt("IdEquipo"),*/
                        rs.getInt("ID_trabajador"),
                        rs.getString("Nombre"),
                        rs.getString("Telefono"),
                        rs.getString("Correo"),
                        rs.getInt("ID_Equipo"));
                trabajadores.add(trabajador);
            }
        }
        return trabajadores;
    }
}
