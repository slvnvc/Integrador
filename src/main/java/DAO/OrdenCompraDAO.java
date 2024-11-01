/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conectar;
import Modelo.OrdenCompra;
import Modelo.ProductoOrden;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Silvana Villanueva
 */
public class OrdenCompraDAO {
     private Connection connection;

    public OrdenCompraDAO() {
        this.connection = Conectar.getConexion();
    }

  public void agregarOrdenCompra(OrdenCompra ordenCompra) throws SQLException {
    // Insertar la orden de compra
    String sqlOrden = "INSERT INTO ordencompra (FechaOrden, ID_Proveedor) VALUES (?, ?)";
    try (PreparedStatement pstmtOrden = connection.prepareStatement(sqlOrden, Statement.RETURN_GENERATED_KEYS)) {
        pstmtOrden.setString(1, ordenCompra.getFechaOrden());
        pstmtOrden.setInt(2, ordenCompra.getIdProveedor());
        pstmtOrden.executeUpdate();

        // Obtener el ID generado de la orden
        ResultSet generatedKeys = pstmtOrden.getGeneratedKeys();
        if (generatedKeys.next()) {
            int idOrdenGenerado = generatedKeys.getInt(1);

            // Insertar los productos de esta orden
            String sqlProducto = "INSERT INTO productosorden (ID_OrdenCompra, Producto, Cantidad) VALUES (?, ?, ?)";
            try (PreparedStatement pstmtProducto = connection.prepareStatement(sqlProducto)) {
                for (ProductoOrden producto : ordenCompra.getProductos()) {
                    pstmtProducto.setInt(1, idOrdenGenerado); // ID de la orden generada
                    pstmtProducto.setString(2, producto.getNombreProducto());
                    pstmtProducto.setInt(3, producto.getCantidad());
                    pstmtProducto.executeUpdate();
                }
            }
        }
    }
}

    
//    // metodo para obtener todas las órdenes de compra
//    public List<OrdenCompra> obtenerTodasLasOrdenes() throws SQLException {
//        String query = "SELECT * FROM ordencompra";
//        List<OrdenCompra> ordenes = new ArrayList<>();
//        try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
//            while (rs.next()) {
//                OrdenCompra orden = new OrdenCompra(
//                        rs.getInt("ID_OrdenCompra"),
//                        rs.getInt("ID_Proveedor"),
//                        rs.getString("FechaOrden"),
//                        rs.getDouble("MontoTotal"),
//                        rs.getString("Producto")
//                );
//                ordenes.add(orden);
//            }
//        }
//        return ordenes;
//    }
//  public List<OrdenCompra> obtenerTodasLasOrdenes() throws SQLException {
//    String query = "SELECT o.ID_OrdenCompra, o.ID_Proveedor, o.FechaOrden, p.Producto, p.Cantidad " +
//                   "FROM ordencompra o " +
//                   "JOIN productosorden p ON o.ID_OrdenCompra = p.ID_OrdenCompra";
//    
//    List<OrdenCompra> ordenes = new ArrayList<>();
//    
//    try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
//        while (rs.next()) {
//            OrdenCompra orden = new OrdenCompra(
//                    rs.getInt("ID_OrdenCompra"),
//                    rs.getInt("ID_Proveedor"),
//                    rs.getString("FechaOrden"),
//                    rs.getString("Producto"),
//                    rs.getInt("Cantidad")
//            );
//            ordenes.add(orden);
//        }
//    }
//    
//    return ordenes;
//}
public List<OrdenCompra> obtenerTodasLasOrdenes() throws SQLException {
    String query = "SELECT o.ID_OrdenCompra, o.FechaOrden, o.ID_Proveedor, p.Producto, p.Cantidad " +
                   "FROM ordencompra o " +
                   "JOIN productosorden p ON o.ID_OrdenCompra = p.ID_OrdenCompra";
    
    List<OrdenCompra> ordenes = new ArrayList<>();
    Map<Integer, OrdenCompra> ordenMap = new HashMap<>();
    
    try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            int idOrdenCompra = rs.getInt("ID_OrdenCompra");

            // Si la orden aún no está en el mapa, crear una nueva
            OrdenCompra orden = ordenMap.get(idOrdenCompra);
            if (orden == null) {
                orden = new OrdenCompra(
                    idOrdenCompra,
                    rs.getString("FechaOrden"),
                    rs.getInt("ID_Proveedor")
                );
                ordenMap.put(idOrdenCompra, orden);
                ordenes.add(orden);
            }

            // Agregar el producto a la orden
            ProductoOrden producto = new ProductoOrden(
                rs.getString("Producto"),
                rs.getInt("Cantidad")
            );
            orden.agregarProducto(producto); // Usa el método agregarProducto para añadir a la lista
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
//
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

 public List<ProductoOrden> obtenerProductosPorOrden(int idOrdenCompra) throws SQLException {
    List<ProductoOrden> productos = new ArrayList<>();
    String query = "SELECT po.Producto, po.Cantidad " +
                   "FROM productosorden po " +
                   "WHERE po.ID_OrdenCompra = ?"; // Cambia esto por el nombre real de tu tabla

    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setInt(1, idOrdenCompra);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String producto = rs.getString("Producto");
            int cantidad = rs.getInt("Cantidad");
            productos.add(new ProductoOrden(producto, cantidad)); // Asegúrate de que ProductoOrden acepte estos parámetros
        }
    }
    return productos;
}
 

}


    

