package items;

import dominio.Peleador;
import dominio.Personaje;
import dominio.PersonajeEquipado;

public class DagaDeDragon extends PersonajeEquipado{

	private Personaje p;
	public DagaDeDragon(Personaje p) {
		super(p);
		this.p = p;		
		super.agregarALista(this);
		this.prioridad=1;
	}

	@Override
	public int calcularPuntosDeAtaque() {
		return p.calcularPuntosDeAtaque()+4;
	}

	@Override
	public int calcularPuntosDeDefensa() {
		return p.calcularPuntosDeDefensa();
	}

	@Override
	public int calcularPuntosDeMagia() {
		return p.calcularPuntosDeMagia();
	}
	
	@Override
	public PersonajeEquipado dejarItem() {
		return (PersonajeEquipado) p;	
	}

	
}
