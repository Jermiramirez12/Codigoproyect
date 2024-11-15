package dao;

import clases.Reporte;
import conexion.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReporteDAO implements DAO<Reporte> {

    @Override
    public void create(Reporte reporte) throws SQLException {
        String sql = "INSERT INTO Reporte (fecha_generacion, monto_total_ventas, monto_total_gastos, rentabilidad, dueno_id, gerente_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(reporte.getFechaGeneracion().getTime()));
            stmt.setDouble(2, reporte.getMontoTotalVentas());
            stmt.setDouble(3, reporte.getMontoTotalGastos());
            stmt.setDouble(4, reporte.getRentabilidad());
            stmt.setInt(5, reporte.getDuenoId());
            stmt.setInt(6, reporte.getGerenteId());
            stmt.executeUpdate();
        }
    }

    @Override
    public Reporte read(int id) throws SQLException {
        String sql = "SELECT * FROM Reporte WHERE id = ?";
        Reporte reporte = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    reporte = new Reporte(
                        rs.getInt("id"),
                        rs.getDate("fecha_generacion"),
                        rs.getDouble("monto_total_ventas"),
                        rs.getDouble("monto_total_gastos"),
                        rs.getDouble("rentabilidad"),
                        rs.getInt("dueno_id"),
                        rs.getInt("gerente_id")
                    );
                }
            }
        }
        return reporte;
    }

    @Override
    public List<Reporte> getAll() throws SQLException {
        List<Reporte> reportes = new ArrayList<>();
        String sql = "SELECT * FROM Reporte";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Reporte reporte = new Reporte(
                    rs.getInt("id"),
                    rs.getDate("fecha_generacion"),
                    rs.getDouble("monto_total_ventas"),
                    rs.getDouble("monto_total_gastos"),
                    rs.getDouble("rentabilidad"),
                    rs.getInt("dueno_id"),
                    rs.getInt("gerente_id")
                );
                reportes.add(reporte);
            }
        }
        return reportes;
    }

    @Override
    public void update(Reporte reporte) throws SQLException {
        String sql = "UPDATE Reporte SET fecha_generacion = ?, monto_total_ventas = ?, monto_total_gastos = ?, rentabilidad = ?, dueno_id = ?, gerente_id = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(reporte.getFechaGeneracion().getTime()));
            stmt.setDouble(2, reporte.getMontoTotalVentas());
            stmt.setDouble(3, reporte.getMontoTotalGastos());
            stmt.setDouble(4, reporte.getRentabilidad());
            stmt.setInt(5, reporte.getDuenoId());
            stmt.setInt(6, reporte.getGerenteId());
            stmt.setInt(7, reporte.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Reporte WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}