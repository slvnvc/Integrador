/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.GuiaRemisionDAO;
import Modelo.GuiaRemision;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author Silvana Villanueva
 */
public class GuiaRemisionControlador {
    
     private GuiaRemisionDAO guiaRemisionDAO;

    public GuiaRemisionControlador() {
        this.guiaRemisionDAO = new GuiaRemisionDAO();
    }

    // Método para agregar una nueva guía de remisión
    public void agregarGuiaRemision(GuiaRemision guia) throws SQLException {
        guiaRemisionDAO.agregarGuiaRemision(guia);
    }

    // Método para obtener todas las guías de remisión con detalles adicionales
    public List<GuiaRemision> obtenerTodasLasGuiasRemision() throws SQLException {
        return guiaRemisionDAO.obtenerTodasLasGuiasRemision();
    }
}
