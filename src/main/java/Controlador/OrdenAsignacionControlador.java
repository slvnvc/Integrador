/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.OrdenAsignacionDAO;
import Modelo.OrdenAsignacion;
import java.sql.SQLException;
import java.util.List;

public class OrdenAsignacionControlador {
    
    private OrdenAsignacionDAO ordenAsignacionDAO;

    public OrdenAsignacionControlador() {
        this.ordenAsignacionDAO = new OrdenAsignacionDAO();
    }

    // obtener nueva oa
    public void agregarOrdenAsignacion(OrdenAsignacion ordenAsignacion) throws SQLException {
        ordenAsignacionDAO.agregarOrdenAsignacion(ordenAsignacion);
    }

    // obtener todas las oa
    public List<OrdenAsignacion> obtenerTodasLasOrdenes() throws SQLException {
        return ordenAsignacionDAO.obtenerTodasLasOrdenesA();
    }
}

