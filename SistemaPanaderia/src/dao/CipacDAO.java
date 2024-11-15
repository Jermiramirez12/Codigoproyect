package dao;

import clases.Cipac;
import conexion.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CipacDAO implements DAO<Cipac> {

    @Override
    public void create1(Cipac cipac) throws SQLException {
        String sql = "INSERT INTO CIPAC (porcentaje_aumento, fecha_aumento, gerente_id) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, cipac.getPorcentajeAumento());
            stmt.setDate(2, new java.sql.Date(cipac.getFechaAumento().getTime()));
            stmt.setInt(3, cipac.getGerenteId());
            stmt.executeUpdate();
        }
    }

    @Override
    public Cipac read(int id) throws SQLException {
        String sql = "SELECT * FROM CIPAC WHERE id = ?";
        CIPAC cipac = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    cipac = new Cipac(
                        rs.getInt("id"),
                        rs.getDouble("porcentaje_aumento"),
                        rs.getDate("fecha_aumento"),
                        rs.getInt("gerente_id")
                    );
                }
            }
        }
        return cipac;
    }

    @Override
    public List<Cipac> getAll() throws SQLException {
        List<Cipac> cipacs = new ArrayList<>();
        String sql = "SELECT * FROM Cipac";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                CIPAC cipac = new Cipac(
                    rs.getInt("id"),
                    rs.getDouble("porcentaje_aumento"),
                    rs.getDate("fecha_aumento"),
                    rs.getInt("gerente_id")
                );
                cipacs.add(cipac);
            }
        }
        return cipacs;
    }

    @Override
    public void update(Cipac cipac) throws SQLException {
        String sql = "UPDATE CIPAC SET porcentaje_aumento = ?, fecha_aumento = ?, gerente_id = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, cipac.getPorcentajeAumento());
            stmt.setDate(2, new java.sql.Date(cipac.getFechaAumento().getTime()));
            stmt.setInt(3, cipac.getGerenteId());
            stmt.setInt(4, cipac.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Cipac WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

	@Override
	public void create(Cipac t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Cipac t) {
		// TODO Auto-generated method stub
		
	}
}