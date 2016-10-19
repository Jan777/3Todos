package items;

import dominio.*;

public class PocionBruta extends PersonajeEquipado{
	
	private Personaje p;
	
	public PocionBruta(Personaje p) {
		super(p);
		this.p = p;
		this.prioridad=2;
		this.nombreItem = "Poción bruta";
	}

	
	@Override
	public int calcularPuntosDeAtaque() {
		return p.calcularPuntosDeAtaque()-2;
	}

	@Override
	public int calcularPuntosDeDefensa() {
		return p.calcularPuntosDeDefensa()+4;
	}

	@Override
	public int calcularPuntosDeMagia() {
		return p.calcularPuntosDeMagia()+2;
	}

	@Override
	public void setPersonajeDecorado(Personaje personajeDecorado) {
		this.personajeDecorado = personajeDecorado;
	}
	
	@Override
	public String getLista() {
		return personajeDecorado.getLista() + " "+getTamañoLista()+"- " +this.nombreItem+ " ";
	}
	
	@Override
	public int getTamañoLista() {
		return personajeDecorado.getTamañoLista()+1;
	}
}
