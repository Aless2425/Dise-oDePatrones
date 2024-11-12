/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BibliotecaCRUD;

/**
 *
 * @author Roberto
 */
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import BibliotecaCRUD.ConexionDB;

public class BibliotecaCRUD extends JFrame {

    private JTextField tituloField, autorField, anioField, generoField, isbnField;
    private JTextArea listaLibrosArea;
    private JButton agregarBtn, listarBtn;
    private ConexionDB conexionDB = new ConexionDB();

    public BibliotecaCRUD() {
        setTitle("Sistema de Biblioteca - CRUD sin patrones");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Componentes de entrada
        tituloField = new JTextField();
        tituloField.setBounds(100, 10, 200, 25);
        autorField = new JTextField();
        autorField.setBounds(100, 40, 200, 25);
        anioField = new JTextField();
        anioField.setBounds(100, 70, 200, 25);
        generoField = new JTextField();
        generoField.setBounds(100, 100, 200, 25);
        isbnField = new JTextField();
        isbnField.setBounds(100, 130, 200, 25);

        add(new JLabel("Titulo:")).setBounds(10, 10, 80, 25);
        add(new JLabel("Autor:")).setBounds(10, 40, 80, 25);
        add(new JLabel("Año:")).setBounds(10, 70, 80, 25);
        add(new JLabel("Género:")).setBounds(10, 100, 80, 25);
        add(new JLabel("ISBN:")).setBounds(10, 130, 80, 25);

        add(tituloField);
        add(autorField);
        add(anioField);
        add(generoField);
        add(isbnField);

        agregarBtn = new JButton("Agregar Libro");
        agregarBtn.setBounds(100, 160, 200, 25);
        agregarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarLibro();
            }
        });
        add(agregarBtn);

        listarBtn = new JButton("Listar Libros");
        listarBtn.setBounds(100, 190, 200, 25);
        listarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarLibros();
            }
        });
        add(listarBtn);

        listaLibrosArea = new JTextArea();
        listaLibrosArea.setBounds(10, 220, 360, 120);
        add(listaLibrosArea);
    }

    private void agregarLibro() {
        String titulo = tituloField.getText();
        String autor = autorField.getText();
        int anio = Integer.parseInt(anioField.getText());
        String genero = generoField.getText();
        String isbn = isbnField.getText();

        Connection conn = conexionDB.EstablecerConexion();
        if (conn != null) {
            try (Statement stmt = conn.createStatement()) {
                String query = "INSERT INTO libro (titulo, autor, ano, genero, isbn) VALUES ('"
                        + titulo + "', '" + autor + "', " + anio + ", '" + genero + "', '" + isbn + "')";
                stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(this, "Libro agregado exitosamente");

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al agregar el libro");
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void listarLibros() {
        listaLibrosArea.setText("");
        Connection conn = conexionDB.EstablecerConexion();

        if (conn != null) {
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM libro")) {

                while (rs.next()) {
                    String libroInfo = "ID: " + rs.getInt("id") + ", Título: " + rs.getString("titulo")
                            + ", Autor: " + rs.getString("autor") + ", Año: " + rs.getInt("ano")
                            + ", Género: " + rs.getString("genero") + ", ISBN: " + rs.getString("isbn") + "\n";
                    listaLibrosArea.append(libroInfo);
                }

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al listar los libros");
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BibliotecaCRUD().setVisible(true));
    }
}
