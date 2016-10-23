package razas;

import dominio.*;

public class Orco extends Personaje{

	public Orco(String username, String password) {
		super(username, password);
		this.setRaza("Orco");
	}
	
	public Orco(Personaje p) {
		super(p);
		this.setRaza("Orco");
	}
	

	@Override
	public  boolean puedeAtacar() {
		return this.energia > (10 + this.calcularPuntosDeAtaque());
	}
	
	
	@Override
	public int calcularPuntosDeAtaque() {
		return 12;
	}

	@Override
	public int calcularPuntosDeDefensa() {
		return 5;
	}

	@Override
	public int calcularPuntosDeMagia() {
		return 3;
	}

	@Override
	public void atacar(Peleador victima) {
		// Nada	
	}
	
	public boolean respuesta()	{
		return false;
	}
	
	@Override
	public String getRaza() {
		return "Orco";
	}
}
