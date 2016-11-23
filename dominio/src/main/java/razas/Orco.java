package razas;

import dominio.*;

public class Orco extends Personaje{

	public Orco(String username) {
		super(username);
		this.setRaza("ORCO");
		this.idRaza = 2;
		this.ataque = 12;
		this.defensa = 5;
		this.magia = 3;
	}
	
	public Orco(Personaje p) {
		super(p);
		this.setRaza("ORCO");
	}
	
	@Override
	public  boolean puedeAtacar() {
		return this.energia > (10 + this.calcularPuntosDeAtaque());
	}
	
		
	@Override
	protected Personaje clone() throws CloneNotSupportedException {
		Personaje aux = new Orco(this);
		return aux;
	}
	
	@Override
	public String getRaza() {
		return raza;
	}

}
