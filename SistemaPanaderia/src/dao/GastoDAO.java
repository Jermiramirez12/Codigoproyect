package dao;

import clases.Gasto;
import conexion.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GastoDAO implements DAO<Gasto> {
    @Override
    public void create(Gasto gasto) throws SQLException {
        String sql = "INSERT INTO Gasto (tipo_gasto, monto, fecha, detalle, tipo_pago) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, gasto.getTipoGasto());
            stmt.setDouble(2, gasto.getMonto());
            stmt.setDate(3, new java.sql.Date(gasto.getFecha().getTime()));
            stmt.setString(4, gasto.getDetalle());
            stmt.setString(5, gasto.getTipoPago());
            stmt.executeUpdate();
        }
    }

    @Override
    public Gasto read(int id) throws SQLException {
        String sql = "SELECT * FROM Gasto WHERE id = ?";
        Gasto gasto = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    gasto = new Gasto(
                        rs.getInt("id"),
                        rs.getString("tipo_gasto"),
                        rs.getDouble("monto"),
                        rs.getDate("fecha"),
                        rs.getString("detalle"),
                        rs.getString("tipo_pago")
                    );
                }
            }
        }
        return gasto;
    }

    @Override
    public List<Gasto> getAll() throws SQLException {
        List<Gasto> gastos = new ArrayList<>();
        String sql = "SELECT * FROM Gasto";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Gasto gasto = new Gasto(
                    rs.getInt("id"),
                    rs.getString("tipo_gasto"),
                    rs.getDouble("monto"),
                    rs.getDate("fecha"),
                    rs.getString("detalle"),
                    rs.getString("tipo_pago")
                );
                gastos.add(gasto);
            }
        }
        return gastos;
    }

    @Override
    public void update(Gasto gasto) throws SQLException {
        String sql = "UPDATE Gasto SET tipo_gasto = ?, monto = ?, fecha = ?, detalle = ?, tipo_pago = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, gasto.getTipoGasto());
            stmt.setDouble(2, gasto.getMonto());
            stmt.setDate(3, new java.sql.Date(gasto.getFecha().getTime()));
            stmt.setString(4, gasto.getDetalle());
            stmt.setString(5, gasto.getTipoPago());
            stmt.setInt(6, gasto.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Gasto WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}