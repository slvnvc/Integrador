package Conexion;

import java.sql.*;

public class Conectar {
    private static Connection CON = null;
    
    public static Connection getConexion() {
        if (CON == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/techtrackpro";
                String usr = "root";
                String psw = "";
                CON = DriverManager.getConnection(url, usr, psw);
                System.out.println("Conexion exitosa.");
            } 
            catch (ClassNotFoundException ex) {
                System.out.println("No hay Driver.");
            } 
            catch (SQLException ex) {
                System.out.println("Error en la base de datos.");
            }
        }
        
        return CON;
    }
}
