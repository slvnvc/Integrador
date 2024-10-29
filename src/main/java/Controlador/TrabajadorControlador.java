/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.TrabajadorDAO;
import Modelo.Trabajador;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Silvana Villanueva
 */
public class TrabajadorControlador {
    
    private TrabajadorDAO trabajadorDAO;

    public TrabajadorControlador() {
        trabajadorDAO = new TrabajadorDAO();
    }

    public void agregarTrabajador(Trabajador trabajador) throws SQLException {
        trabajadorDAO.agregarTrabajador(trabajador);
    }

    public List<Trabajador> obtenerTrabajadores() throws SQLException {  
        return trabajadorDAO.obtenerTrabajadoresConEquipos();
    }
    
    public List<Trabajador> buscarTrabajadoresPorEquipo(String nombreEquipo) throws SQLException {
        return trabajadorDAO.buscarTrabajadoresPorEquipo(nombreEquipo);
}


     public int obtenerIdTrabajadorPorNombre(String nombreTrabajador) throws SQLException {
        return trabajadorDAO.obtenerIdTrabajadorPorNombre(nombreTrabajador);  
    }
    
}
