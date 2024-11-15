package dao;

import clases.Inflacion;
import conexion.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InflacionDAO implements DAO<Inflacion> {

    @Override
    public void create(Inflacion inflacion) throws SQLException {
        String sql = "INSERT INTO Inflacion (indice, fecha, gerente_id) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, inflacion.getIndice());
            stmt.setDate(2, new java.sql.Date(inflacion.getFecha().getTime()));
            stmt.setInt(3, inflacion.getGerenteId());
            stmt.executeUpdate();
        }
    }

    @Override
    public Inflacion read(int id) throws SQLException {
        String sql = "SELECT * FROM Inflacion WHERE id = ?";
        Inflacion inflacion = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    inflacion = new Inflacion(
                        rs.getInt("id"),
                        rs.getDouble("indice"),
                        rs.getDate("fecha"),
                        rs.getInt("gerente_id")
                    );
                }
            }
        }
        return inflacion;
    }

    @Override
    public List<Inflacion> getAll() throws SQLException {
        List<Inflacion> inflaciones = new ArrayList<>();
        String sql = "SELECT * FROM Inflacion";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Inflacion inflacion = new Inflacion(
                    rs.getInt("id"),
                    rs.getDouble("indice"),
                    rs.getDate("fecha"),
                    rs.getInt("gerente_id")
                );
                inflaciones.add(inflacion);
            }
        }
        return inflaciones;
    }

    @Override
    public void update(Inflacion inflacion) throws SQLException {
        String sql = "UPDATE Inflacion SET indice = ?, fecha = ?, gerente_id = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, inflacion.getIndice());
            stmt.setDate(2, new java.sql.Date(inflacion.getFecha().getTime()));
            stmt.setInt(3, inflacion.getGerenteId());
            stmt.setInt(4, inflacion.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Inflacion WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}