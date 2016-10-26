package razas;

import dominio.*;
public class Elfo extends Personaje{

	public Elfo(String username, String password) {
		super(username, password);
		this.setRaza("Elfo");
		this.ataque = 5;
		this.defensa = 5;
		this.magia = 10;
	}
	
	public Elfo(Personaje p) {
		super(p);
		this.setRaza("Elfo");
	}
	
	public Elfo(Usuario u) {
		super(u);
		this.setRaza("Elfo");
		this.ataque = 5;
		this.defensa = 5;
		this.magia = 10;
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
	public int calcularPuntosDeAtaque() {
		return this.ataque;
	}

	@Override
	public int calcularPuntosDeDefensa() {
		return this.defensa;
	}

	@Override
	public int calcularPuntosDeMagia() {
		return this.magia;
	}

	@Override
	public String getRaza() {
		return "Elfo";
	}


	
	
	
}
