package items;

import dominio.*;

public class EscudoDeLeon extends PersonajeEquipado{
	
	public EscudoDeLeon(Personaje p) {
		super(p);
		super.agregarALista(this);
		super.prioridad=5;		
	}


	@Override
	public int calcularPuntosDeAtaque() {
		return super.calcularPuntosDeAtaque();
	}

	@Override
	public int calcularPuntosDeDefensa() {
		return super.calcularPuntosDeDefensa()+4;
	}

	@Override
	public int calcularPuntosDeMagia() {
		return super.calcularPuntosDeMagia();
	}

	
}
