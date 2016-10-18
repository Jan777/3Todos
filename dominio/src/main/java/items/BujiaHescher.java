package items;

import dominio.*;

public class BujiaHescher extends PersonajeEquipado {
	
	private Personaje p;
	
	public BujiaHescher(Personaje p) {
		super(p);
		super.agregarALista(this);
		this.prioridad=5;		
	//	this.p = p;	
	}

	@Override
	public int calcularPuntosDeAtaque() {
		return super.calcularPuntosDeAtaque()+1;
	}

	@Override
	public int calcularPuntosDeDefensa() {
		return super.calcularPuntosDeDefensa()+1;
	}

	@Override
	public int calcularPuntosDeMagia() {
		return super.calcularPuntosDeMagia()+1;
	}

	@Override
	public PersonajeEquipado dejarItem() {
		return (PersonajeEquipado) p;	
	}
	
	@Override
	public void getLista() {
		System.out.println("Cantidad de items: "+lista.size());
		for(int i=0; i<lista.size();i++)
			System.out.println(lista.get(i));
	}
}
