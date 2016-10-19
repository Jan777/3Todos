package items;

import dominio.*;

public class GuanteDePoder extends PersonajeEquipado{
	private Personaje p;
	
	public GuanteDePoder(Personaje p) {
		super(p);
		this.p = p;		
		this.prioridad=2;
		this.nombreItem = "Guante de Poder";
	}

	@Override
	public int calcularPuntosDeAtaque() {
		return super.calcularPuntosDeAtaque()+2;
	}

	@Override
	public int calcularPuntosDeDefensa() {
		return super.calcularPuntosDeDefensa()+1;
	}

	@Override
	public int calcularPuntosDeMagia() {
		return super.calcularPuntosDeMagia()+3;
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
