package items;

import dominio.*;

public class PocionSabiduria extends PersonajeEquipado{
	private Personaje p;
	public PocionSabiduria(Personaje p) {
		super(p);
		this.p = p;
		this.prioridad=3;
		this.nombreItem = "Poci�n sabidur�a";
	}

	@Override
	public int calcularPuntosDeAtaque() {
		return p.calcularPuntosDeAtaque();
	}

	@Override
	public int calcularPuntosDeDefensa() {
		return p.calcularPuntosDeDefensa()+2;
	}

	@Override
	public int calcularPuntosDeMagia() {
		return p.calcularPuntosDeMagia()+3;
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
