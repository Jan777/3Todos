package items;

import dominio.*;

public class EspadaDeJuanNieve extends PersonajeEquipado{
	private Personaje p;
	public EspadaDeJuanNieve(Personaje p) {
		super(p);
		this.p = p;
		super.agregarALista(this);
		this.prioridad=7;
	}


	@Override
	public int calcularPuntosDeAtaque() {
		return p.calcularPuntosDeAtaque()+5;
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
	public void getLista() {
		System.out.println("Cantidad de items: "+lista.size());
		for(int i=0; i<lista.size();i++)
			System.out.println(lista.get(i));
	}


}
