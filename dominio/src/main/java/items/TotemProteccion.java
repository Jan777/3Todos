package items;

import dominio.*;

public class TotemProteccion extends PersonajeEquipado {
	private Personaje p;
	public TotemProteccion(Personaje p) {
		super(p);
		this.p = p;
		this.prioridad=3;
		this.nombreItem = "Tótem de protección";
	}

	@Override
	public int calcularPuntosDeAtaque() {
		return p.calcularPuntosDeAtaque();
	}

	@Override
	public int calcularPuntosDeDefensa() {
		return p.calcularPuntosDeDefensa()+6;
	}

	@Override
	public int calcularPuntosDeMagia() {
		return p.calcularPuntosDeMagia()+1;
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
