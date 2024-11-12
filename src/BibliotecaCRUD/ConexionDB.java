/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BibliotecaCRUD;

/**
 *
 * @author Roberto
 */
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConexionDB {

    Connection con;

    public Connection EstablecerConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/espagueti", "root", "");
            // JOptionPane.showMessageDialog(null, "Se realizó la conexión correctamente"); // NO ACTIVAR
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se encontró un problema en la conexión: " + e.toString());
        }
        return con;
    }
}
