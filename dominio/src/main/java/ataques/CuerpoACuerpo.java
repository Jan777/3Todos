package ataques;

import dominio.*;

public class CuerpoACuerpo  extends Ataque {

	public CuerpoACuerpo(){
		this.idAtaque = 1;
		this.nombre = "Cuerpo a cuerpo";
	}

	@Override
	public int aplicarAtaque() {
		return 5;
	}
	
	
	
}
