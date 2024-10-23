/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Vista;

import Conexion.Conectar;
import java.sql.Connection;

/**
 *
 * @author Silvana Villanueva
 */
public class Main {

    /**
     * @param args the command line arguments
     */
      public static void main(String[] args) {
        Connection connection = Conectar.getConexion();
        if (connection != null) {
            System.out.println("Se obtuvo la conexión.");
        } else {
            System.out.println("No se pudo obtener la conexión.");
        }
    }

    
}
