package dao;

import clases.Gerente;
import conexion.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GerenteDAO implements DAO<Gerente> {
    
    @Override
    public void create(Gerente gerente) throws SQLException {
        String sql = "INSERT INTO Gerente (nombre) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, gerente.getNombre());
            stmt.executeUpdate();
        }
    }

    @Override
    public Gerente read(int id) throws SQLException {
        String sql = "SELECT * FROM Gerente WHERE id = ?";
        Gerente gerente = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    gerente = new Gerente(rs.getInt("id"), rs.getString("nombre"));
                }
            }
        }
        return gerente;
    }

    @Override
    public List<Gerente> getAll() throws SQLException {
        List<Gerente> gerentes = new ArrayList<>();
        String sql = "SELECT * FROM Gerente";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Gerente gerente = new Gerente(rs.getInt("id"), rs.getString("nombre"));
                gerentes.add(gerente);
            }
        }
        return gerentes;
    }

    @Override
    public void update(Gerente gerente) throws SQLException {
        String sql = "UPDATE Gerente SET nombre = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, gerente.getNombre());
            stmt.setInt(2, gerente.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Gerente WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}