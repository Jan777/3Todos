package criterios_aceptacion;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

import dominio.*;
import razas.*;

/*
 * 4)	 Como Personaje, quiero acumular experiencia. 
 * Motivación: Para poder subir de nivel.
 * */

public class Historia04Test {


	/*1.	Dado un Personaje, cuando acumule la cantidad de experiencia necesaria, entonces se incrementará su nivel. 
	 * */
	@Test
	public void historia04Criterio01_Test() throws FileNotFoundException{
		Personaje p1 = new Humano("CarlosTevez","VeryDificul");
		Personaje p2 = new Humano("Dalessandra","Cabezon");
		Personaje p3 = new Humano("Romagnola","Cabezon");
		
		for (int i = 0; i<9;i++)			
			p1.atacar(p2);
		p1.serEnergizado();
		for (int i = 0; i<6;i++)			
			p1.atacar(p2);
		p1.serEnergizado();
		for (int i = 0; i<6;i++)			
			p1.atacar(p3);
		p1.serEnergizado();
		for (int i = 0; i<6;i++)			
			p1.atacar(p3);
		p1.serEnergizado();
		
		Assert.assertEquals(2, p1.getNivel());
		
	}
	
	

}
