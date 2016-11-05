package entities;

import connection.DataBaseOperations;

public class Usuario {

	private int idUsuario;
	private String username;
	private String password;

	public Usuario(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Usuario() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int guardarUsuario() {
		return 1;
	}

	public boolean validarIngreso() {
		return new DataBaseOperations().verificarCredencia(this.getUsername(), this.getPassword());
	}

	public boolean equals(Usuario obj) {
		if (this.idUsuario == obj.idUsuario && this.username == obj.username)
			return true;

		return false;
	}

	public int agregarUsuario(String username, String password) {
		return new DataBaseOperations().agregarUsuario(username, password);
	}

	public boolean validarNombre(String nombre) {
		return new DataBaseOperations().existeUsuario(nombre);
	}
}