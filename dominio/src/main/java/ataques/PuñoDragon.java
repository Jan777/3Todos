package ataques;

import dominio.Ataque;

public class Pu�oDragon extends Ataque{

	public Pu�oDragon(){
		this.idAtaque = 5;
		this.nombre = "Pu�o Drag�n";
	}

	@Override
	public int aplicarAtaque() {
		return 8;
	}
}
