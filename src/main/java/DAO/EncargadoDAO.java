/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conectar;
import Modelo.Encargado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Silvana Villanueva
 */
public class EncargadoDAO {
    public static Encargado login(String Correo, String Contra) {
        Connection con = Conectar.getConexion();
        String sql = "SELECT * FROM encargado WHERE Correo = ? AND Contra = ?";
        Encargado encargado = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, Correo);
            ps.setString(2, Contra);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                encargado = new Encargado();
                encargado.setIdEncargado(rs.getInt("ID_Encargado")); // 
                encargado.setNombre(rs.getString("Nombre"));
                encargado.setTelefono(rs.getString("Telefono"));
                encargado.setCorreo(rs.getString("Correo"));
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return encargado;
    }
    
   public static Encargado getEncargado(int id) {
    Encargado encargado = null;
    Connection con = Conectar.getConexion();
    String sql = "SELECT Nombre, Telefono, Correo FROM encargado WHERE ID_Encargado=?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            encargado = new Encargado();
            encargado.setIdEncargado(id); 
            encargado.setNombre(rs.getString("Nombre"));
            encargado.setTelefono(rs.getString("Telefono"));
            encargado.setCorreo(rs.getString("Correo"));
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } return encargado;
    }
    
}
