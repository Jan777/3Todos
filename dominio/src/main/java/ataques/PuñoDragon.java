package ataques;

import dominio.Ataque;

public class PuñoDragon extends Ataque{

	public PuñoDragon(){
		this.idAtaque = 5;
		this.nombre = "Puño Dragón";
	}

	@Override
	public int aplicarAtaque() {
		return 8;
	}
}
