/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.OrdenCompraDAO;
import Modelo.OrdenCompra;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author Silvana Villanueva
 */
public class OrdenCompraControlador {
     private OrdenCompraDAO ordenCompraDAO;

    public OrdenCompraControlador() {
        this.ordenCompraDAO = new OrdenCompraDAO();
    }

    // metodo para agregar una orden de compra
    public void agregarOrdenCompra(OrdenCompra ordenCompra) throws SQLException {
        ordenCompraDAO.agregarOrdenCompra(ordenCompra);
    }

    // metodo para obtener todas las órdenes de compra
    public List<OrdenCompra> obtenerTodasLasOrdenes() throws SQLException {
        return ordenCompraDAO.obtenerTodasLasOrdenes();
    }
}
