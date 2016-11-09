package entities;

import connection.DataBaseOperations;

public class MensajePersonaje {

	private int idUsuario;
	private String username;
	private String raza;
	private String casta;

	public MensajePersonaje(int id,String name,String raza,String casta){
		this.idUsuario=id;
		this.username=name;
		this.raza=raza;
		this.casta=casta;
	}

	public MensajePersonaje() {

	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getCasta() {
		return casta;
	}

	public void setCasta(String casta) {
		this.casta = casta;
	}

	public MensajePersonaje getPersonaje() {
		DataBaseOperations op = new DataBaseOperations();
		return op.getPersonaje(this.username);
	}

	public boolean guardarPersonaje() {
		DataBaseOperations op = new DataBaseOperations();
		return op.guardarPersonaje(this.idUsuario,this.username,this.raza,this.casta);
	}
}
