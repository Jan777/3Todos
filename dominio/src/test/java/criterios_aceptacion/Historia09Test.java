package criterios_aceptacion;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

import castas.*;
import dominio.*;
import razas.*;


// OK


/***
 * 
 * 9)	Como Personaje, quiero encontrarme con otros personajes en el mismo mundo.
 * Motivacion: Para aliarme con ellos o combatir contra ellos.
 * 
 ***/

public class Historia09Test {


	/***
	 * 
	 * 1.	Dado un Personaje, cuando se encuentre cercano a otro e interactuen, entonces este podra unirse a la 
	 * alianza de su nuevo companero o formar una nueva. 
	 * 
	 ***/
	
	@Test
	public void historia09Criterio01_Test() {
		/*
		 * Creacion de objetos
		 * */
		Personaje p1 = new Humano("Fernando De La Rua","123");
		Personaje p2 = new Humano("Chacho Alvarez","123");
		p1.setCasta(new Chaman());
		p2.setCasta(new Guerrero());
		p1.setUbicacion(new Ubicacion(0, 0));
		p2.setUbicacion(new Ubicacion(3, 0));
		

		/*
		 * Agrego personajes a la Alianza 
		 * */

		if(p2.seEncuentraCerca(p1))		
			p2.formarAlianzaCon(p1);
		
		Assert.assertEquals(2, p1.getAlianzaActual().cantidadMiembrosAlianza());

		///////////		
		
		Personaje p3 = new Humano("Mauricio Macri","123");
		p3.setCasta(new Hechicero());
		
		
		/*Seteo ubicacion alejado del resto.*/
		p3.setUbicacion(new Ubicacion(15, 0));
		
		if(p3.seEncuentraCerca(p1))		
			p3.formarAlianzaCon(p1);
		
		/*
		 * Controlo que la alianza principal tenga 2 miembros
		 * */
		
		Assert.assertEquals(2, p1.getAlianzaActual().cantidadMiembrosAlianza());
		
	}
	
	
	/***
	 * 
	 * 2.	Dado un Personaje, cuando se encuentre cercano a otro e interactuen, entonces este podra combatir 
	 * contra el hasta definir un ganador.
	 * @throws FileNotFoundException 
	 * @throws CloneNotSupportedException 
	 * 
	 ***/
	
	@Test
	public void historia09Criterio02_Test() throws FileNotFoundException, CloneNotSupportedException {
		/*
		 * Creacion de personajes y alianzas
		 * */
		Personaje p1 = new Humano("Mauricio Macri","123");
		Personaje p2 = new Humano("Eugenia Vidal","123");
		p1.setCasta(new Chaman());
		p2.setCasta(new Guerrero());
		p1.setUbicacion(new Ubicacion(0, 0));
		p2.setUbicacion(new Ubicacion(3, 0));
		
		
		Personaje p3 = new Elfo("Carlos Perez","123");
		Personaje p4 = new Elfo("Juan Fernandez","123");
		p3.setCasta(new Chaman());
		p4.setCasta(new Chaman());
		p3.setUbicacion(new Ubicacion(1, 4));
		p4.setUbicacion(new Ubicacion(100, 500));
		
		p1.formarAlianzaCon(p2);
		p3.formarAlianzaCon(p4);
		
		/*
		 * Creacion de equipos
		 * */
		Equipo e1 = new Equipo(p1);
		Equipo e2 = new Equipo(p3);
		
		/*
		 * Arranca el combate
		 * */
		
		Combate c = new Combate();
		
		c.combatir(e1, e2);
		
		Assert.assertEquals(2, e1.getListaPeleadores().size());
		Assert.assertEquals(0, e2.getListaPeleadores().size());
		
		//Assert.assertEquals(1, c.declararGanador(e1, e2));
		
		
		
		
	}
	
	
}
