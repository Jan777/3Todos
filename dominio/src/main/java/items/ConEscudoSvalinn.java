package items;

import dominio.Personaje;
import dominio.PersonajeEquipado;

public class ConEscudoSvalinn extends PersonajeEquipado {

	public ConEscudoSvalinn(Personaje personajeDecorado) {
		super(personajeDecorado);
	}

	@Override
	public int calcularPuntosDeDefensa() {
		return super.calcularPuntosDeDefensa()+3;
	}
}
