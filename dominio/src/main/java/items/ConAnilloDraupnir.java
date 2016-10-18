package items;

import dominio.Personaje;
import dominio.PersonajeEquipado;

public class ConAnilloDraupnir extends PersonajeEquipado {

	public ConAnilloDraupnir(Personaje personajeDecorado) {
		super(personajeDecorado);
	}

	@Override
	public int calcularPuntosDeAtaque() {
		return super.calcularPuntosDeAtaque()+5;
	}
	
}
