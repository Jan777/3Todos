package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import utilities.Loggin;

public class SQLConnection {
	private static Connection conn;

	private SQLConnection() {

	}

	public static Connection getConnection() {
		try {
			if (conn == null) {
				String driver = "org.sqlite.JDBC";
				String url = "jdbc:sqlite:src/main/resources/BaseDeDatos/BloodyWars.db";
				Class.forName(driver);
				conn = DriverManager.getConnection(url);
			}
		} catch (ClassNotFoundException cnfe) {
			Loggin.getInstance().error("No se encuentra el Driver.");
		} catch (SQLException sqle) {
			Loggin.getInstance().error("Error al intentar la conexion.");
		}
		return conn;
	}

	public static void close() {
		try {
			if (conn != null) {
				conn.close();
				Loggin.getInstance().info("Desconexion de la BD exitosa.");
			}
		} catch (SQLException sqle) {
			Loggin.getInstance().error("Error al cerrar la conexion.");
		}
	}
}