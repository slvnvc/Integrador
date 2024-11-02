/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author Silvana Villanueva
 */
import DAO.OrdenSalidaDAO;
import Modelo.OrdenSalida;
import java.sql.SQLException;
import java.util.List;

public class OrdenSalidaControlador {
    
    private OrdenSalidaDAO ordenSalidaDAO;

    public OrdenSalidaControlador() {
        this.ordenSalidaDAO = new OrdenSalidaDAO();
    }

    //metodo para agregar una nueva orden de salida
    public void agregarOrdenSalida(OrdenSalida ordenSalida) throws SQLException {
        ordenSalidaDAO.agregarOrdenSalida(ordenSalida);
    }

    // metodo para obtener todas las órdenes de salida
    public List<OrdenSalida> obtenerTodasLasOrdenesSalida() throws SQLException {
        return ordenSalidaDAO.obtenerTodasLasOrdenesSalida();
    }

    
}

