package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
	private static Connection conn;

	private SQLConnection() {

	}

	public static Connection getConnection() {
		try {
			if (conn == null) {
				String driver = "org.sqlite.JDBC";
				String url = "jdbc:sqlite:src/main/resources/BloodyWars.db";
				Class.forName(driver);
				conn = DriverManager.getConnection(url);
			}
		} catch (ClassNotFoundException cnfe) {
			// util.logWarning("No se encuentra el Driver.");
		} catch (SQLException sqle) {
			// util.logWarning("Error al intentar la conexion.");
		}
		return conn;
	}

	public static void close() {
		try {
			if (conn != null) {
				conn.close();
				// util.logWarning("Desconexion de la BD exitosa.");
			}
		} catch (SQLException sqle) {
			// util.logWarning("Error al cerrar la conexion.");
		}
	}
}