package dao;

import clases.Dueno;
import conexion.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DuenoDAO implements DAO<Dueno> {

    @Override
    public void create(Dueno dueno) throws SQLException {
        String sql = "INSERT INTO Dueno (nombre) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dueno.getNombre());
            stmt.executeUpdate();
        }
    }

    @Override
    public Dueno read(int id) throws SQLException {
        String sql = "SELECT * FROM Dueno WHERE id = ?";
        Dueno dueno = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    dueno = new Dueno(rs.getInt("id"), rs.getString("nombre"));
                }
            }
        }
        return dueno;
    }

    @Override
    public List<Dueno> getAll() throws SQLException {
        List<Dueno> duenos = new ArrayList<>();
        String sql = "SELECT * FROM Dueno";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Dueno dueno = new Dueno(rs.getInt("id"), rs.getString("nombre"));
                duenos.add(dueno);
            }
        }
        return duenos;
    }

    @Override
    public void update(Dueno dueno) throws SQLException {
        String sql = "UPDATE Dueno SET nombre = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dueno.getNombre());
            stmt.setInt(2, dueno.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Dueno WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}