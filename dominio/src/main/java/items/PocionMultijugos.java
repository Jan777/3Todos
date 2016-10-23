package items;

import dominio.*;

public class PocionMultijugos extends PersonajeEquipado{
	
	private Personaje p;
	
	public PocionMultijugos(Personaje p) {
		super(p);
		this.p =p;
		this.prioridad=1;
		this.nombreItem = "Poci�n multijugos";
	}

	
	@Override
	public int calcularPuntosDeAtaque() {
		return p.calcularPuntosDeAtaque();
	}

	@Override
	public int calcularPuntosDeDefensa() {
		return p.calcularPuntosDeDefensa()+3;
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
