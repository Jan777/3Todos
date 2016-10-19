package items;

import dominio.*;
import razas.*;

public class BujiaHescher extends PersonajeEquipado {
	
	private Personaje p;
	
	public BujiaHescher(Personaje p) {
		super(p);		
		this.p = p;
		this.prioridad=7;
		this.nombreItem = "Buj�a Hescher";
	}

	public BujiaHescher(Humano p) {
		super(p);		
		this.p = p;
		this.prioridad=7;
		this.nombreItem = "Buj�a Hescher";
	}
	
	public BujiaHescher(Elfo p) {
		super(p);		
		this.p = p;
		this.prioridad=7;
		this.nombreItem = "Buj�a Hescher";
	}

	public BujiaHescher(Orco p) {
		super(p);
		this.p = p;
		this.prioridad=7;
		this.nombreItem = "Buj�a Hescher";
	}
	
	@Override
	public int calcularPuntosDeAtaque() {
		return super.calcularPuntosDeAtaque()+1;
	}

	@Override
	public int calcularPuntosDeDefensa() {
		return super.calcularPuntosDeDefensa()+1;
	}

	@Override
	public int calcularPuntosDeMagia() {
		return super.calcularPuntosDeMagia()+1;
	}

	@Override
	public void setPersonajeDecorado(Personaje personajeDecorado) {
		this.personajeDecorado = personajeDecorado;
	}
	
	@Override
	public String getLista() {
		return personajeDecorado.getLista() + " "+getTama�oLista()+"- " +this.nombreItem+ " ";
	}
	
	@Override
	public int getTama�oLista() {
		return personajeDecorado.getTama�oLista()+1;
	}
}
