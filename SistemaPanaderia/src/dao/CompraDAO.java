package dao;

import clases.Compra;
import conexion.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompraDAO implements DAO<Compra> {

    @Override
    public void create(Compra compra) throws SQLException {
        String sql = "INSERT INTO Compra (nro_compra, tipo_compra, nombre, monto_total, fecha_carga, proveedor, encargado_id, gerente_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, compra.getNroCompra());
            stmt.setString(2, compra.getTipoCompra());
            stmt.setString(3, compra.getNombre());
            stmt.setDouble(4, compra.getMontoTotal());
            stmt.setDate(5, new java.sql.Date(compra.getFechaCarga().getTime()));
            stmt.setString(6, compra.getProveedor());
            stmt.setInt(7, compra.getEncargadoId());
            stmt.setInt(8, compra.getGerenteId());
            stmt.executeUpdate();
        }
    }

    @Override
    public Compra read(int id) throws SQLException {
        String sql = "SELECT * FROM Compra WHERE id = ?";
        Compra compra = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    compra = new Compra(
                        rs.getInt("id"),
                        rs.getInt("nro_compra"),
                        rs.getString("tipo_compra"),
                        rs.getString("nombre"),
                        rs.getDouble("monto_total"),
                        rs.getDate("fecha_carga"),
                        rs.getString("proveedor"),
                        rs.getInt("encargado_id"),
                        rs.getInt("gerente_id")
                    );
                }
            }
        }
        return compra;
    }

    @Override
    public List<Compra> getAll() throws SQLException {
        List<Compra> compras = new ArrayList<>();
        String sql = "SELECT * FROM Compra";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Compra compra = new Compra(
                    rs.getInt("id"),
                    rs.getInt("nro_compra"),
                    rs.getString("tipo_compra"),
                    rs.getString("nombre"),
                    rs.getDouble("monto_total"),
                    rs.getDate("fecha_carga"),
                    rs.getString("proveedor"),
                    rs.getInt("encargado_id"),
                    rs.getInt("gerente_id")
                );
                compras.add(compra);
            }
        }
        return compras;
    }

    @Override
    public void update(Compra compra) throws SQLException {
        String sql = "UPDATE Compra SET nro_compra = ?, tipo_compra = ?, nombre = ?, monto_total = ?, fecha_carga = ?, proveedor = ?, encargado_id = ?, gerente_id = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, compra.getNroCompra());
            stmt.setString(2, compra.getTipoCompra());
            stmt.setString(3, compra.getNombre());
            stmt.setDouble(4, compra.getMontoTotal());
            stmt.setDate(5, new java.sql.Date(compra.getFechaCarga().getTime()));
            stmt.setString(6, compra.getProveedor());
            stmt.setInt(7, compra.getEncargadoId());
            stmt.setInt(8, compra.getGerenteId());
            stmt.setInt(9, compra.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Compra WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}