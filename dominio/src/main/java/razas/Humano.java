package razas;

import dominio.*;

public class Humano extends Personaje {
	
	public Humano(String nombre, String password){
		super(nombre,password);
		this.setRaza("Humano");
		this.ataque = 10;
		this.defensa = 10;
		this.magia = 0;
	}
	
	public Humano(Personaje p){
		super(p);
		this.setRaza("Humano");
		this.ataque = 10;
		this.defensa = 10;
		this.magia = 0;
	}
	
	public Humano(Usuario u){
		super(u);
		this.setRaza("Humano");
		this.ataque = 10;
		this.defensa = 10;
		this.magia = 0;
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
		return this.magia*0;
	}



	@Override
	public String getRaza() {
		return "Humano";
	}

	public boolean respuesta()	{
		return false;
	}
	
}

