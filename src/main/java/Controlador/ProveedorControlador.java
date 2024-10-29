/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.ProveedorDAO;
import Modelo.Proveedor;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Silvana Villanueva
 */
public class ProveedorControlador {
    
    private ProveedorDAO proveedorDAO;

    public ProveedorControlador() {
        proveedorDAO = new ProveedorDAO();
    }

    // agregar un proveedor
    public void agregarProveedor(Proveedor proveedor) throws SQLException {
        proveedorDAO.agregarProveedor(proveedor);
    }

    // metodo para obtener todos los proveedores
    public List<Proveedor> obtenerTodosLosProveedores() throws SQLException {
        return proveedorDAO.obtenerTodosLosProveedores();
    }
    
    // metodo para obtener el producto asociado a un proveedor
    public String obtenerProductosPorProveedor(int idProveedor) throws SQLException {
        return proveedorDAO.obtenerProductoPorProveedor(idProveedor);
    }

     public int obtenerIdProveedorPorNombre(String nombreProveedor) throws SQLException {
    return proveedorDAO.obtenerIdPorNombre(nombreProveedor);
}

    public String obtenerProveedorPorId(int idProveedor) throws SQLException {
    return proveedorDAO.obtenerNombrePorId(idProveedor);
    }

     public List<String> obtenerNombresEquiposPorProveedor(int idProveedor) throws SQLException {
        return proveedorDAO.obtenerNombresEquiposPorProveedor(idProveedor);
    }

    public String obtenerNombreProveedorPorEquipo(int idEquipo)throws SQLException {
    return proveedorDAO.obtenerNombreProveedorPorEquipo(idEquipo);
    }
    // categoria 
    // Método para obtener las categorías únicas (productos)
    public List<String> obtenerCategorias() throws SQLException {
        return proveedorDAO.obtenerCategorias();
    }

    // Método para obtener el nombre del proveedor por categoría
    public String obtenerProveedorPorCategoria(String categoria) throws SQLException {
        return proveedorDAO.obtenerProveedorPorCategoria(categoria);
    }

    // Método para obtener el ID del proveedor por categoría
    public int obtenerIdProveedorPorCategoria(String categoria) throws SQLException {
        return proveedorDAO.obtenerIdProveedorPorCategoria(categoria);
    }
}
