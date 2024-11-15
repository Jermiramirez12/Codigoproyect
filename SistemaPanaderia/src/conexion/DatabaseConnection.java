package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/bd_sistemadecalculo";  // Cambia el nombre de la base de datos si es diferente
    private static final String USER = "root";  // Usuario que configuraste durante la instalación de MySQL
    private static final String PASSWORD = "MySql!2024Pass.";  // Cambia esto por la contraseña que configuraste para el usuario root

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
