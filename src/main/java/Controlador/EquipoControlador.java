package controlador;

import dao.EquipoDAO;  
import Modelo.Equipo;   
import java.sql.SQLException;
import java.util.List;

public class EquipoControlador {

    private EquipoDAO equipoDAO;

    // Constructor
    public EquipoControlador() {
        equipoDAO = new EquipoDAO();
    }

    
    public void agregarEquipo(Equipo equipo) throws SQLException {
        equipoDAO.insertarEquipo(equipo);
    }

    
    public List<Equipo> obtenerEquipos() throws SQLException {  
        return equipoDAO.obtenerTodosLosEquipos();
    }

    public List<Equipo> obtenerEquiposDispo() throws SQLException {  
        return equipoDAO.obtenerEquiposDisponibles();
    }
    
    public int obtenerIdEquipoPorNombre(String nombreEquipo) throws SQLException {
        return equipoDAO.obtenerIdEquipoPorNombre(nombreEquipo);
    }
    
    public void actualizarEstadoEquipo(int idEquipo, String nuevoEstado) throws SQLException {
        equipoDAO.actualizarEstadoE(idEquipo, nuevoEstado);
    }
    
    public void eliminarEquipo(int idEquipo) throws SQLException {  
        equipoDAO.eliminarEquipo(idEquipo);
    }

    
    public void actualizarEquipo(Equipo equipo) throws SQLException {  
        equipoDAO.actualizarEquipo(equipo);
    }

    
    public Equipo obtenerEquipoPorId(int idEquipo) throws SQLException {  
        return equipoDAO.obtenerEquipoPorId(idEquipo);
    }

    public List<Equipo> obtenerEquiposDefectuosos() throws SQLException {
        return equipoDAO.obtenerEquiposDefectuosos();    
    }
    public List<Equipo> obtenerEquiposConProveedor() throws SQLException {
    return equipoDAO.obtenerEquiposConProveedor();
}
    

}
