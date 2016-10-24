package habilidades;

import dominio.*;

public class Destreza extends Habilidad{
	
	public Destreza(){
		this.idHabilidad = 1;
		this.nombre = "Destreza";
		this.puntos = 0;
	}
	
	public void aumentarDestreza(){
		this.velocidad++;
		this.potencia++;
	}
	
	
}
