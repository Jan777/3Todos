package items;

import dominio.Peleador;
import dominio.Personaje;
import dominio.PersonajeEquipado;

public class DagaDeDragon extends PersonajeEquipado{

	private Personaje p;
	public DagaDeDragon(Personaje p) {
		super(p);
		this.p = p;		
		this.prioridad=1;
		this.nombreItem = "Daga de Drag�n";
	}

	@Override
	public int calcularPuntosDeAtaque() {
		return p.calcularPuntosDeAtaque()+4;
	}

	@Override
	public int calcularPuntosDeDefensa() {
		return p.calcularPuntosDeDefensa();
	}

	@Override
	public int calcularPuntosDeMagia() {
		return p.calcularPuntosDeMagia();
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
