package items;

import dominio.*;

public class LanzaEnLlamas extends PersonajeEquipado{
	private Personaje p;
	public LanzaEnLlamas(Personaje p) {
		super(p);
		this.p = p;
		this.prioridad=1;
	}

	@Override
	public int calcularPuntosDeAtaque() {
		return p.calcularPuntosDeAtaque()+6;
	}

	@Override
	public int calcularPuntosDeDefensa() {
		return p.calcularPuntosDeDefensa()-2;
	}

	@Override
	public int calcularPuntosDeMagia() {
		return p.calcularPuntosDeMagia();
	}




}
