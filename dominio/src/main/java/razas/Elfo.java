package razas;

import dominio.*;
public class Elfo extends Personaje{

	public Elfo(String username, String password) {
		super(username, password);
		this.setRaza("Elfo");
	}
	
	public Elfo(Usuario u) {
		super(u.getUsername(),u.getPassword());
		this.setRaza("Elfo");
	}

	@Override
	public PersonajeEquipado dejarItem() {
		return null;
	}

	@Override
	public void despuesDeAtacar() {
		// TODO Auto-generated method stub		
	}

	@Override
	public boolean puedeAtacar() {
		return energia > (10 + this.calcularPuntosDeAtaque());
	}

	@Override
	public void atacar(Peleador victima) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int calcularPuntosDeAtaque() {
		return 5;
	}

	@Override
	public int calcularPuntosDeDefensa() {
		return 5;
	}

	@Override
	public int calcularPuntosDeMagia() {
		return 10;
	}

	@Override
	public String getRaza() {
		return "Elfo";
	}

}
