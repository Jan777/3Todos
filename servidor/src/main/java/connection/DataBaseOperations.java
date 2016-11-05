package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entities.Usuario;
import utilities.Loggin;

public class DataBaseOperations {

	private Connection conn;

	public DataBaseOperations() {
		try {
			conn = SQLConnection.getConnection();
		} catch (Exception e) {
			Loggin.getInstance().error("Error estableciendo conexion a la base " + e.getMessage());
		}
	}

	public int agregarUsuario(String nombre, String contrasena) {
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.getConnection();
			pstmt = conn.prepareStatement("INSERT INTO USUARIO(NOMBRE,CONTRASENA) VALUES(?,?)");
			pstmt.setString(1, nombre.toUpperCase());
			pstmt.setString(2, contrasena);
			pstmt.executeUpdate();

		} catch (Exception e) {
			Loggin.getInstance().error("Log error al agregar usuario " + e.getMessage());
			return 0;
		}
		return 1;
	}

	public void actualizarUsuario(int idUsuario, String nombre, String contrasena) {
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.getConnection();
			pstmt = conn.prepareStatement("UPDATE USUARIO SET NOMBRE=?,CONTRASENA=? WHERE ID_USUARIO=?");
			pstmt.setString(1, nombre.toUpperCase());
			pstmt.setString(2, contrasena);
			pstmt.setInt(3, idUsuario);
			pstmt.executeUpdate();

		} catch (Exception e) {
			Loggin.getInstance().error("Error actualizarUsuario: " + e.getMessage());
		}
	}

	public Usuario obtenerUsuario(int idUsuario) {
		Usuario u = null;
		PreparedStatement pstmt = null;
		String nombre = "";
		String contrasena = "";
		String query = "SELECT NOMBRE,CONTRASENA FROM USUARIO WHERE ID_USUARIO=?";
		try {
			conn = SQLConnection.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idUsuario);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				nombre = rs.getString("NOMBRE");
				contrasena = rs.getString("CONTRASENA");
			}
			u = new Usuario(nombre, contrasena);
		} catch (Exception e) {
			Loggin.getInstance().error("Error obtenerUsuario " + e.getMessage());
		}
		return u;
	}

	public boolean verificarCredencia(String nombre, String pas) {
		PreparedStatement pstmt = null;
		String contrasena = "";
		String query = "SELECT CONTRASENA FROM USUARIO WHERE NOMBRE=?";
		try {
			conn = SQLConnection.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, nombre.toUpperCase());

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				contrasena = rs.getString("CONTRASENA");
			}
			return pas.equals(contrasena);
		} catch (Exception e) {
			Loggin.getInstance().error("Error al agregar usuario" + e.getMessage());
		}
		return false;
	}

	public boolean existeUsuario(String userName) {
		PreparedStatement pstmt = null;
		String nombre="";
		String query = "SELECT NOMBRE FROM USUARIO WHERE NOMBRE=?";
		try {
			conn = SQLConnection.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userName.toUpperCase());

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				nombre = rs.getString("NOMBRE");
			}
			if (nombre.equals(userName.toUpperCase()))
				return true;
		} catch (Exception e) {
			Loggin.getInstance().error("Error existeUsuario " + e.getMessage());
		}
		return false;
	}
}