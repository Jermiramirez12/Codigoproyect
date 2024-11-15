package dao;

import clases.EncargadoCompra;
import conexion.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EncargadoCompraDAO implements DAO<EncargadoCompra> {

    @Override
    public void create(EncargadoCompra encargado) throws SQLException {
        String sql = "INSERT INTO Encargado (nombre) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, encargado.getNombre());
            stmt.executeUpdate();
        }
    }

    @Override
    public EncargadoCompra read(int id) throws SQLException {
        String sql = "SELECT * FROM Encargado WHERE id = ?";
        EncargadoCompra encargado = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    encargado = new EncargadoCompra(rs.getInt("id"), rs.getString("nombre"));
                }
            }
        }
        return encargado;
    }

    @Override
    public List<EncargadoCompra> getAll() throws SQLException {
        List<EncargadoCompra> encargados = new ArrayList<>();
        String sql = "SELECT * FROM Encargado";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                EncargadoCompra encargado = new EncargadoCompra(rs.getInt("id"), rs.getString("nombre"));
                encargados.add(encargado);
            }
        }
        return encargados;
    }

    @Override
    public void update(EncargadoCompra encargado) throws SQLException {
        String sql = "UPDATE Encargado SET nombre = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, encargado.getNombre());
            stmt.setInt(2, encargado.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Encargado WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}