/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conectar;
import Modelo.Proveedor;
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
public class ProveedorDAO {
     private Connection connection;

    public ProveedorDAO() {
        this.connection = Conectar.getConexion();
    }

    // metodo para agregar un proveedor
    public void agregarProveedor(Proveedor proveedor) throws SQLException {
        String query = "INSERT INTO proveedor (Nombre, Producto, Telefono, Direccion) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, proveedor.getNombre());
            stmt.setString(2, proveedor.getProducto());
            stmt.setString(3, proveedor.getTelefono());
            stmt.setString(4, proveedor.getDireccion());
            stmt.executeUpdate();
        }
    }

    // obtener todos los proveedores
    public List<Proveedor> obtenerTodosLosProveedores() throws SQLException {
        String query = "SELECT * FROM proveedor";
        List<Proveedor> proveedores = new ArrayList<>();
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Proveedor proveedor = new Proveedor(
                        rs.getInt("ID_Proveedor"),
                        rs.getString("Nombre"),
                        rs.getString("Producto"),
                        rs.getString("Telefono"),
                        rs.getString("Direccion"));
                proveedores.add(proveedor);
            }
        }
        return proveedores;
    }

    public String obtenerProductoPorProveedor(int idProveedor) throws SQLException {
    String query = "SELECT Producto FROM proveedor WHERE ID_Proveedor = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setInt(1, idProveedor);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getString("Producto");
        }
    }
    return null; //si no se enuentra devuelvo null
}

//nuevo
    public List<String> obtenerNombresEquiposPorProveedor(int idProveedor) throws SQLException {
    String query = "SELECT equipo.Nombre FROM equipo " +
                   "JOIN proveedor ON equipo.ID_Proveedor = proveedor.ID_Proveedor " +
                   "WHERE equipo.ID_Proveedor = ?";
    List<String> nombresEquipos = new ArrayList<>();

    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setInt(1, idProveedor);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            nombresEquipos.add(rs.getString("Nombre"));
        }
    }
    return nombresEquipos; // devuelve la lista con los nombres de los equipos
}


    // metoddo para obtener el ID del proveedor por nombre
    public int obtenerIdProveedorPorNombre(String nombre) throws SQLException {
        String query = "SELECT ID_Proveedor FROM proveedor WHERE Nombre = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nombre);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("ID_Proveedor");
            }
        }
        return -1; // retorna valor si no se encuentra 
    }

     public int obtenerIdPorNombre(String nombre) throws SQLException {
    String query = "SELECT ID_Proveedor FROM proveedor WHERE Nombre = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setString(1, nombre);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("ID_Proveedor");
        } else {
            throw new SQLException("Proveedor no encontrado.");
        }
    }
}

    public String obtenerNombrePorId(int idProveedor) throws SQLException {
    String query = "SELECT Nombre FROM proveedor WHERE ID_Proveedor = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setInt(1, idProveedor);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getString("Nombre");
        } else {
            throw new SQLException("Proveedor no encontrado.");
        }
    }
}



}
