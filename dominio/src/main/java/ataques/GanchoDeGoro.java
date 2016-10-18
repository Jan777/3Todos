package ataques;

import dominio.Ataque;

public class GanchoDeGoro  extends Ataque {

	public GanchoDeGoro(){
		this.idAtaque = 3;
		this.nombre = "Gancho de Goro";	
	}

	@Override
	public int aplicarAtaque() {
		return 12;
	}
}
