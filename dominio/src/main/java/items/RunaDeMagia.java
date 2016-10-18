package items;

import dominio.*;

public class RunaDeMagia extends PersonajeEquipado{
	private Personaje p;
	public RunaDeMagia(Personaje p) {
		super(p);
		this.p = p;
		this.prioridad=2;
	}


	@Override
	public int calcularPuntosDeAtaque() {
		return p.calcularPuntosDeAtaque()+1;
	}

	@Override
	public int calcularPuntosDeDefensa() {
		return p.calcularPuntosDeDefensa()+1;
	}

	@Override
	public int calcularPuntosDeMagia() {
		return p.calcularPuntosDeMagia()+6;
	}


}
