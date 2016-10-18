package items;

import dominio.*;


public class BastonDeSaruman extends PersonajeEquipado{

	private Personaje p;
	
	public BastonDeSaruman(Personaje p) {
		super(p);
		this.p = p;
		this.prioridad=5;
	}


	@Override
	public int calcularPuntosDeAtaque() {
		return p.calcularPuntosDeAtaque()+1;
	}

	@Override
	public int calcularPuntosDeDefensa() {
		return p.calcularPuntosDeDefensa();
	}

	@Override
	public int calcularPuntosDeMagia() {
		return p.calcularPuntosDeMagia()+4;
	}

	@Override
	public PersonajeEquipado dejarItem() {
		return (PersonajeEquipado) p;	
	}

}
