package items;

import dominio.*;

public class EspadaDeJuanNieve extends PersonajeEquipado{

	private Personaje p ;
	
	public EspadaDeJuanNieve(Personaje p) {
		super(p);
		this.p = p;		
		this.prioridad = 6;
		this.nombreItem = "Espada de Juan Nieve";
	}


	@Override
	public int calcularPuntosDeAtaque() {
		return super.calcularPuntosDeAtaque()+5;
	}

	@Override
	public int calcularPuntosDeDefensa() {
		return super.calcularPuntosDeDefensa();
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
