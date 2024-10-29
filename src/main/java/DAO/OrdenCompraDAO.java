/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conectar;
import Modelo.OrdenCompra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Silvana Villanueva
 */
public class OrdenCompraDAO {
     private Connection connection;

    public OrdenCompraDAO() {
        this.connection = Conectar.getConexion();
    }

    // metodo para insertar una orden de compra
    public void agregarOrdenCompra(OrdenCompra ordenCompra) throws SQLException {
        String query = "INSERT INTO ordencompra (ID_Proveedor, FechaOrden, MontoTotal, Producto) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, ordenCompra.getIdProveedor());
            stmt.setString(2, ordenCompra.getFechaOrden());
            stmt.setDouble(3, ordenCompra.getMontoTotal());
            stmt.setString(4, ordenCompra.getProducto());
            stmt.executeUpdate();
        }
    }

    // metodo para obtener todas las órdenes de compra
    public List<OrdenCompra> obtenerTodasLasOrdenes() throws SQLException {
        String query = "SELECT * FROM ordencompra";
        List<OrdenCompra> ordenes = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                OrdenCompra orden = new OrdenCompra(
                        rs.getInt("ID_OrdenCompra"),
                        rs.getInt("ID_Proveedor"),
                        rs.getString("FechaOrden"),
                        rs.getDouble("MontoTotal"),
                        rs.getString("Producto")
                );
                ordenes.add(orden);
            }
        }
        return ordenes;
    }

    public List<OrdenCompra> obtenerOrdenesCompraBasicas() throws SQLException {
    List<OrdenCompra> ordenes = new ArrayList<>();
    String query = "SELECT ID_OrdenCompra, ID_Proveedor, FechaOrden FROM ordencompra";

    try (PreparedStatement stmt = connection.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            OrdenCompra orden = new OrdenCompra(
                rs.getInt("ID_OrdenCompra"),   
                rs.getString("FechaOrden"),    
                rs.getInt("ID_Proveedor")      
            );
            ordenes.add(orden);
        }
    }
    return ordenes;
}

    public OrdenCompra obtenerDetallesOrdenCompra(int idOrdenCompra) throws SQLException {
    String query = "SELECT ID_OrdenCompra, FechaOrden, ID_Proveedor FROM ordencompra WHERE ID_OrdenCompra = ?";
    
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setInt(1, idOrdenCompra);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            int idProveedor = rs.getInt("ID_Proveedor");
            String fechaOrden = rs.getString("FechaOrden");
            
            return new OrdenCompra(idOrdenCompra, fechaOrden, idProveedor);
        }
    }
    return null; // retorna null si no se encuentra la orden
    }

    public int obtenerIdProveedorPorOrden(int idOrdenCompra) throws SQLException {
    String query = "SELECT ID_Proveedor FROM ordencompra WHERE ID_OrdenCompra = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setInt(1, idOrdenCompra);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("ID_Proveedor");
        } else {
            throw new SQLException("Proveedor no encontrado para la orden de compra seleccionada.");
        }
    }
}


    
}
