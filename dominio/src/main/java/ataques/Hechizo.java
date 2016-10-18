package ataques;

import dominio.Ataque;

public class Hechizo  extends Ataque{

	public Hechizo(){
		this.idAtaque = 4;
		this.nombre = "Hechizo";
	}

	@Override
	public int aplicarAtaque() {
		return 6;
	}
}
