package items;

import dominio.Personaje;
import dominio.PersonajeEquipado;

public class ConEspadaSkofnung extends PersonajeEquipado {

	public ConEspadaSkofnung(Personaje personajeDecorado) {
		super(personajeDecorado);
	}
	
	@Override
	public int calcularPuntosDeAtaque() {
		return super.calcularPuntosDeAtaque()+4;
	}

}
