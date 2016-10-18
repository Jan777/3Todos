package ataques;

import dominio.Ataque;

public class FuriaSangrienta  extends Ataque{

	public FuriaSangrienta(){
		this.idAtaque = 2;
		this.nombre = "Furia sangrienta";
	}

	@Override
	public int aplicarAtaque() {
		return 9;
	}
}
