package items;

import dominio.*;

public class PocionMultijugos extends PersonajeEquipado{
	private Personaje p;
	public PocionMultijugos(Personaje p) {
		super(p);
		this.p =p;
		this.prioridad=1;
	}

	
	@Override
	public int calcularPuntosDeAtaque() {
		return p.calcularPuntosDeAtaque();
	}

	@Override
	public int calcularPuntosDeDefensa() {
		return p.calcularPuntosDeDefensa()+3;
	}

	@Override
	public int calcularPuntosDeMagia() {
		return p.calcularPuntosDeMagia()+3;
	}

}
