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
	public void despuesDeAtacar() {
		// TODO Auto-generated method stub
		
	}

	// Cuando llega acá compara con la energia del personajeDecorado que siempre es 100.
	@Override
	protected  boolean puedeAtacar() {
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public PersonajeEquipado dejarItem() {
		return null;		
	}
	
	@Override
	public String getRaza() {
		return "Orco";
	}
}
