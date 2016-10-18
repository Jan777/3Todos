package items;

import dominio.*;

public class PocionSabiduria extends PersonajeEquipado{
	private Personaje p;
	public PocionSabiduria(Personaje p) {
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
		return p.calcularPuntosDeDefensa()+2;
	}

	@Override
	public int calcularPuntosDeMagia() {
		return p.calcularPuntosDeMagia()+3;
	}



}
