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
}
