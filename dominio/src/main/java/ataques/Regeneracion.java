package ataques;

import dominio.Ataque;

public class Regeneracion  extends Ataque{

	public Regeneracion(){
		this.idAtaque = 6;
		this.nombre = "Regeneraci�n";
	}

	@Override
	public int aplicarAtaque() {
		return -7;
	}
	
	
}
