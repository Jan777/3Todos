package razas;

import dominio.*;

public class Orco extends Personaje{

	public Orco(String username, String password) {
		super(username, password);
		this.setRaza("Orco");
		this.ataque = 12;
		this.defensa = 5;
		this.magia = 3;
	}
	
	public Orco(Personaje p) {
		super(p);
		this.setRaza("Orco");
		this.ataque = 12;
		this.defensa = 5;
		this.magia = 3;
	}
	
	public Orco(Usuario u) {
		super(u);
		this.setRaza("Orco");
		this.ataque = 12;
		this.defensa = 5;
		this.magia = 3;
	}
	
	@Override
	public  boolean puedeAtacar() {
		return this.energia > (10 + this.calcularPuntosDeAtaque());
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

		
	public boolean respuesta()	{
		return false;
	}
	
	@Override
	public String getRaza() {
		return "Orco";
	}

}
