package items;

import dominio.*;
import razas.*;


public class BastonDeSaruman extends PersonajeEquipado{

	private Personaje p;
	
	public BastonDeSaruman(Personaje p) {
		super(p);		
		this.p = p;		
		this.prioridad=5;
		this.nombreItem = "Bast�n de Saruman";
	}

	public BastonDeSaruman(Humano p) {
		super(p);		
		this.p = p;
		this.prioridad=5;
		this.nombreItem = "Bast�n de Saruman";
	}
	
	public BastonDeSaruman(Elfo p) {
		super(p);		
		this.p = p;
		this.prioridad=5;
		this.nombreItem = "Bast�n de Saruman";
	}

	public BastonDeSaruman(Orco p) {
		super(p);
		this.p = p;
		this.prioridad=5;
		this.nombreItem = "Bast�n de Saruman";
	}
	
	@Override
	public int calcularPuntosDeAtaque() {
		return p.calcularPuntosDeAtaque()+1;
	}

	@Override
	public int calcularPuntosDeDefensa() {
		return p.calcularPuntosDeDefensa();
	}

	@Override
	public int calcularPuntosDeMagia() {
		return p.calcularPuntosDeMagia()+4;
	}

	@Override
	public void setPersonajeDecorado(Personaje personajeDecorado) {
		this.p = personajeDecorado;
	}

	@Override
	public String getLista() {
		return p.getLista() + " "+getTama�oLista()+"- " +this.nombreItem+ " ";
	}
	
	@Override
	public int getTama�oLista() {
		return p.getTama�oLista()+1;
	}
}
