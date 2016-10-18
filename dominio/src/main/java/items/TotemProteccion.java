package items;

import dominio.*;

public class TotemProteccion extends PersonajeEquipado {
	private Personaje p;
	public TotemProteccion(Personaje p) {
		super(p);
		this.p = p;
		this.prioridad=3;
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


}
