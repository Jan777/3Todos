package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entities.Usuario;

public class DataBaseOperations {

	private Connection conn;

	public DataBaseOperations() {
		try {
			conn = SQLConnection.getConnection();
		} catch (Exception e) {
			// Log "Error estableciendo conexion a la base
		}
	}

	public void agregarUsuario(int idUsuario, String nombre, String contrasena) {
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.getConnection();
			pstmt = conn.prepareStatement("INSERT INTO USUARIO(ID_USUARIO,NOMBRE,CONTRASENA) VALUES(?,?,?)");
			pstmt.setInt(1, idUsuario);
			pstmt.setString(2, nombre);
			pstmt.setString(3, contrasena);
			pstmt.executeUpdate();

		} catch (Exception e) {
			// Log error al agregar usuario
		}
	}

	public void actualizarUsuario(int idUsuario, String nombre, String contrasena) {
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.getConnection();
			pstmt = conn.prepareStatement("UPDATE USUARIO SET NOMBRE=?,CONTRASENA=? WHERE ID_USUARIO=?");
			pstmt.setString(1, nombre);
			pstmt.setString(2, contrasena);
			pstmt.setInt(3, idUsuario);
			pstmt.executeUpdate();

		} catch (Exception e) {
			// Log error al agregar usuario
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
			// Log error al agregar usuario
		}
		return u;
	}
}