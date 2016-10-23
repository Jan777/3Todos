package items;

import dominio.*;

public class RunaDeMagia extends PersonajeEquipado{
	private Personaje p;
	public RunaDeMagia(Personaje p) {
		super(p);
		this.p = p;
		this.prioridad=2;
		this.nombreItem = "Runa de magia";
	}


	@Override
	public int calcularPuntosDeAtaque() {
		return p.calcularPuntosDeAtaque()+1;
	}

	@Override
	public int calcularPuntosDeDefensa() {
		return p.calcularPuntosDeDefensa()+1;
	}

	@Override
	public int calcularPuntosDeMagia() {
		return p.calcularPuntosDeMagia()+6;
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
