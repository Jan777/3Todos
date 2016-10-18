package items;

import dominio.*;

public class EspadaDeJuanNieve extends PersonajeEquipado{

	public EspadaDeJuanNieve(Personaje p) {
		super(p);
		this.prioridad = 6;
		this.agregarALista(this);
	}


	@Override
	public int calcularPuntosDeAtaque() {
		return super.calcularPuntosDeAtaque()+5;
	}

	@Override
	public int calcularPuntosDeDefensa() {
		return super.calcularPuntosDeDefensa();
	}

	@Override
	public int calcularPuntosDeMagia() {
		return super.calcularPuntosDeMagia();
	}
	
	@Override
	public void getLista() {
		System.out.println("Cantidad de items: "+lista.size());
		for(int i=0; i<lista.size();i++)
			System.out.println(lista.get(i));
	}


}
