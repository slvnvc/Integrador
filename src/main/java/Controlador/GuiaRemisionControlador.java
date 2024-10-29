/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.GuiaRemisionDAO;
import Modelo.GuiaRemision;
import java.sql.SQLException;
import java.util.List;

public class GuiaRemisionControlador {
    
    private GuiaRemisionDAO guiaRemisionDAO;

    public GuiaRemisionControlador() {
        this.guiaRemisionDAO = new GuiaRemisionDAO();
    }

    // para agregar una nueva guia
    public void agregarGuiaRemision(GuiaRemision guia) throws SQLException {
        guiaRemisionDAO.agregarGuiaRemision(guia);
    }

    // metodo para obtener todas las guias con detalles adicionales
    public List<GuiaRemision> obtenerTodasLasGuiasRemision() throws SQLException {
        return guiaRemisionDAO.obtenerTodasLasGuiasRemision();
    }
}
