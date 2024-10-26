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
}
