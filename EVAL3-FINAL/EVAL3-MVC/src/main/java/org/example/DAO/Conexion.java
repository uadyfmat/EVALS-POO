package org.example.DAO;
import java.sql.*;
public class Conexion {
    // Cadena de conexión a la base de datos
    static String user = System.getenv("USER_SECRET");
    static String password = System.getenv("PASS_SECRET");
    private static final String ConnectionString = "jdbc:sqlserver://luismifmat.database.windows.net:1433;"
            + "database=LuisMFmat;"
            + "user="+ user + ";"
            + "password="+ password + ";"
            + "encrypt=true;"
            + "trustServerCertificate=false;"
            + "hostNameInCertificate=*.database.windows.net;"
            + "loginTimeout=30;";
    // Conexión a la base de datos
    private Connection connection;
    // Constructor de la clase
    public Conexion() {
        connection = null;
    }
    // Método para abrir la conexión a la base de datos
    public void abrir() {
        try {
            connection = DriverManager.getConnection(ConnectionString);
            System.out.println("Conexion abierta");
        } catch (SQLException ex) {
            System.out.println("Error al abrir la conexión: " + ex.getMessage());
        }
    }
    // Método para cerrar la conexión a la base de datos
    public void cerrar() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexión: " + ex.getMessage());
        }
    }
    // Método para obtener la conexión a la base de datos
    public Connection getConnection() {
        if (connection == null) {
            abrir();
        }
        return connection;
    }
}