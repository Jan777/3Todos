package items;

import dominio.*;

public class GuanteDePoder extends PersonajeEquipado{
	private Personaje p;
	
	public GuanteDePoder(Personaje p) {
		super(p);
		this.p = p;
		this.prioridad=2;
	}

	@Override
	public int calcularPuntosDeAtaque() {
		return p.calcularPuntosDeAtaque()+2;
	}

	@Override
	public int calcularPuntosDeDefensa() {
		return p.calcularPuntosDeDefensa()+1;
	}

	@Override
	public int calcularPuntosDeMagia() {
		return p.calcularPuntosDeMagia()+3;
	}




}
