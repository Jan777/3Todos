package items;

import dominio.*;

public class EscudoDeLeon extends PersonajeEquipado{
	
	private Personaje p;
	
	public EscudoDeLeon(Personaje p) {
		super(p);
		this.p = p;		
		super.prioridad=5;
		this.nombreItem = "Escudo de León";
	}


	@Override
	public int calcularPuntosDeAtaque() {
		return super.calcularPuntosDeAtaque();
	}

	@Override
	public int calcularPuntosDeDefensa() {
		return super.calcularPuntosDeDefensa()+4;
	}

	@Override
	public int calcularPuntosDeMagia() {
		return super.calcularPuntosDeMagia();
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
