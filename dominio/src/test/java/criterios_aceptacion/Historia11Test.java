package criterios_aceptacion;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

import castas.*;
import dominio.*;
import items.*;
import razas.*;


/*
 * @mauroat - 07/11/16
 * El error que tengo en el metodo equipo.repartirItems es que los punteros iniciales de p1, p2, etc
 * No se actualizan al decorator. Solo el equipo actualiza su referencia.
 * 
 * */


/***
 * 
 * 11)	Como Personaje, quiero combatir contra otros jugadores.
 * Motivación: Para obtener sus ítems al derrotarlos.
 * 
 ***/

public class Historia11Test {


	/***
	 * 
	 * 1.	Dado un Personaje que pertenece a una Alianza, cuando éstos resultan ganadores de un combate, entonces 
	 * se reparten los ítems de los perdedores entre los integrantes. 
	 * @throws FileNotFoundException 
	 * @throws CloneNotSupportedException 
	 * 
	 ***/
	
	@Test
	public void historia11Criterio01_Test() throws FileNotFoundException, CloneNotSupportedException {
		Personaje p1 = new Humano("Humano1","1231");
		Personaje p2 = new Orco("Humano2","1231");
		Personaje p3 = new Elfo("Humano3","1231");
		Personaje p4 = new Elfo("Humano4","1231");
		p1.setCasta(new Guerrero());
		p2.setCasta(new Hechicero());
		p3.setCasta(new Chaman());
		p4.setCasta(new Hechicero());
		p1.setUbicacion(new Ubicacion(0,1));
		p2.setUbicacion(new Ubicacion(0,4));
		p3.setUbicacion(new Ubicacion(1,4));
		p4.setUbicacion(new Ubicacion(1,6));
		
		/*
		 * Equipo con items
		 * */
		
		p1 = new ArmaduraDeAzorAhai(p1);
		p2 = new BujiaHescher(p2);
		p3 = new PocionBruta(p3);
		p4 = new PocionSabiduria(p4);
		
		/*
		 * Armo las alianzas: 
		 *  
		 * */
	
		p1.formarAlianzaCon(p2);
		p3.formarAlianzaCon(p4);
		

		
		/*
		 * Se preparan los equipos a pelear
		 * */
		Equipo e1 = new Equipo(p1);
		Equipo e2 = new Equipo(p3);
		
		
		/*
		 * Compruebo que esten todos vivos
		 * */
		Assert.assertEquals(true, e1.quedaAlgunoVivo());
		Assert.assertEquals(true, e2.quedaAlgunoVivo());
		
		/*
		 * Se ataca por turnos. La idea es que cuando un equipo se queda sin peleadores, 
		 * se sumen los niveles de todos sus integrantes y se los multiplique por 10.
		 * Ese numero sera dividido por la cantidad de peleadores del equipo ganador y se le 
		 * sumara a cada uno a su experiencia. 
		 * 
		 * */
		Combate c = new Combate("Super Batalla");
		
		c.combatir(e1, e2);
		
		
		
		Assert.assertEquals(0, p3.getTamañoLista());
		Assert.assertEquals(0, p4.getTamañoLista());
		
	}
	
	
	/***
	 * 
	 * 2.	Dado un Personaje, cuando finaliza el combate contra otro Personaje 
	 * Usuario y resulta ganador, entonces se le entrega el mejor ítem de aquel Personaje Usuario derrotado. 
	 * @throws FileNotFoundException 
	 * @throws CloneNotSupportedException 
	 * 
	 ***/
	
	@Test
	public void historia11Criterio02_Test() throws FileNotFoundException, CloneNotSupportedException {
		Personaje p1 = new Humano("Humano1","1231");
		Personaje p2 = new Orco("Humano2","1231");
		p1.setCasta(new Guerrero());
		p2.setCasta(new Hechicero());
		
		/*
		 * Se preparan los equipos a pelear
		 * */
		Equipo e1 = new Equipo(p1);
		Equipo e2 = new Equipo(p2);
		
		/*
		 * Compruebo que esten todos vivos
		 * */
		Assert.assertEquals(true, e1.quedaAlgunoVivo());
		Assert.assertEquals(true, e2.quedaAlgunoVivo());
		
		/*
		 * Se ataca por turnos. La idea es que cuando un equipo se queda sin peleadores, 
		 * se sumen los niveles de todos sus integrantes y se los multiplique por 10.
		 * Ese numero sera dividido por la cantidad de peleadores del equipo ganador y se le 
		 * sumara a cada uno a su experiencia. 
		 * 
		 * */
		
		Combate c = new Combate("La Gran Batalla");
		
		c.combatir(e1, e2);
		/*
		 * Falta metodo repartirItems combinado con dejarMejorItem y desequipar
		 * 
		 * */
		Assert.assertEquals(1, 2);
		

	}
	
	/***
	 * 
	 * 3.	Dado un Personaje, cuando finaliza el combate contra un Personaje Genérico y resulta ganador, 
	 * entonces se le entrega el mejor ítem del Personaje Genérico.
	 * @throws FileNotFoundException 
	 * @throws CloneNotSupportedException 
	 * 
	 ***/
	
	@Test
	public void historia11Criterio03_Test() throws FileNotFoundException, CloneNotSupportedException {
		Personaje p1 = new Humano("Humano1","1231");
		Personaje p2 = new Orco("Humano2","1231");
		Generico g = new Generico("Terminator");
		p1.setCasta(new Guerrero());
		p2.setCasta(new Hechicero());
		p1.setUbicacion(new Ubicacion(0,1));
		p2.setUbicacion(new Ubicacion(0,4));
		
		/*
		 * Armo la alianza: 
		 *  
		 * */
		p1.formarAlianzaCon(p2);
		
		/*
		 * Se prepara un equipo para pelear
		 * */
		Equipo e1 = new Equipo(p1);
		
		/*
		 * Compruebo que esten todos vivos
		 * */
		Assert.assertEquals(true, e1.quedaAlgunoVivo());
		Assert.assertEquals(true, g.estaVivo());
		
		/*
		 * Se ataca por turnos. La idea es que cuando un equipo se queda sin peleadores, 
		 * se sumen los niveles de todos sus integrantes y se los multiplique por 10.
		 * Ese numero sera dividido por la cantidad de peleadores del equipo ganador y se le 
		 * sumara a cada uno a su experiencia. 
		 * 
		 * */
		
		Combate c = new Combate("La Pelea Final");
		c.combatir(e1, g);
		
	
		
		Assert.assertEquals(1, p1.getTamañoLista());

		
	}
}
