package razas;

import dominio.*;

public class Humano extends Personaje {
	
	public Humano(String nombre, String password){
		super(nombre,password);
		this.setRaza("Humano");
	}
	
	public Humano(Personaje p){
		super(p);
		this.setRaza("Humano");
	}
	
	@Override
	public int calcularPuntosDeAtaque() {
		return 10;
	}

	@Override
	protected boolean puedeAtacar() {
		return energia >= 10;
	}

	@Override
	public int calcularPuntosDeDefensa() {
		return 10;
	}

	@Override
	public int calcularPuntosDeMagia() {
		return this.magia*0;
	}


	@Override
	public void atacar(Peleador victima) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String getRaza() {
		return "Humano";
	}

	@Override
	public PersonajeEquipado dejarItem() {
		return null;
	}

	
	
}

