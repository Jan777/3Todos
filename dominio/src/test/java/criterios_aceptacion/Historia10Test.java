package criterios_aceptacion;

import org.junit.Assert;
import org.junit.Test;

import castas.Chaman;
import castas.Guerrero;
import castas.Hechicero;
import dominio.Alianza;
import dominio.Combate;
import dominio.Equipo;
import dominio.Generico;
import dominio.Personaje;
import razas.Elfo;
import razas.Humano;
import razas.Orco;

// Falta ultimo assert en criterio 1
// Faltan los demas criterios 

/***
 * 
 * 10)	 Como Personaje, quiero aliarme con otro personaje.
 * Motivación: Para combatir junto a él y aumentar la experiencia que recolectamos en ese tiempo.
 * 
 ***/

public class Historia10Test {


	/***
	 * 
	 * 1.	Dado un Personaje que pertenece a una Alianza, cuando resulten ganadores de un combate contra otra 
	 * Alianza de Personajes Usuarios, entonces el sistema incrementará la experiencia de todos ellos.
	 * 
	 ***/
	
	@Test
	public void historia10Criterio01_Test() {
		/*
		 * Creo los objetos personaje
		 * */
		
		Personaje p1 = new Humano("Humano1","1231");
		Personaje p2 = new Orco("Humano2","1231");
		Personaje p3 = new Elfo("Humano3","1231");
		Personaje p4 = new Elfo("Humano4","1231");
		p1.setCasta(new Guerrero());
		p2.setCasta(new Hechicero());
		p3.setCasta(new Chaman());
		p4.setCasta(new Hechicero());
		
		/*
		 * Armo las alianzas: 
		 *  
		 * */
		Alianza a1 = new Alianza();
		p1.setAlianzaActual(a1);
		p2.setAlianzaActual(a1);
		
		
		p1.getAlianzaActual().formarAlianza(p2);
		p2.getAlianzaActual().formarAlianza(p1);
		
		Alianza a2 = new Alianza();
		p1.setAlianzaActual(a2);
		p2.setAlianzaActual(a2);
		
		
		p1.getAlianzaActual().formarAlianza(p2);
		p2.getAlianzaActual().formarAlianza(p1);
		
		/*
		 * Se preparan los equipos a pelear
		 * */
		Equipo e1 = new Equipo(p1);
		e1.agregar(p2);
		Equipo e2 = new Equipo(p3);
		e2.agregar(p4);
		
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
		
		Combate c = new Combate("La Batalla");
		while(e1.quedaAlgunoVivo() && e2.quedaAlgunoVivo() ){
			c.combatir(e1,e2);
		}
		
		if(!e1.quedaAlgunoVivo()){
			e2.repartirExperiencia(e1.calcularExperiencia());
		} else if (!e2.quedaAlgunoVivo()){
			e1.repartirExperiencia(e2.calcularExperiencia());
		}
	}
	
	/*
	 * Faltan los Asserts para comprobar 
	 * */
	
	
	/***
	 * 
	 * 2.	Dado un Personaje que pertenece a una Alianza, cuando resulten ganadores de un combate contra un 
	 * Personaje Usuario, entonces el sistema incrementará la experiencia de todos ellos. 
	 * 
	 ***/
	
	@Test
	public void historia10Criterio02_Test() {
		Personaje p1 = new Humano("Humano1","1231");
		Personaje p2 = new Orco("Humano2","1231");
		Personaje p3 = new Elfo("Humano3","1231");
		p1.setCasta(new Guerrero());
		p2.setCasta(new Hechicero());
		p3.setCasta(new Chaman());
		
		/*
		 * Armo las alianzas: 
		 *  
		 * */
		Alianza a1 = new Alianza();
		p1.setAlianzaActual(a1);
		p2.setAlianzaActual(a1);
		
		
		p1.getAlianzaActual().formarAlianza(p2);
		p2.getAlianzaActual().formarAlianza(p1);
		
		/*
		 * Se preparan los equipos a pelear
		 * */
		Equipo e1 = new Equipo(p1);
		Equipo e2 = new Equipo(p2);
		e2 = new Equipo(p3);
		
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
		
		Combate c = new Combate("La Batalla de la Muerte");
		while(e1.quedaAlgunoVivo() && e2.quedaAlgunoVivo() ){
			c.combatir(e1,e2);
		}
		
		if(!e1.quedaAlgunoVivo()){
			e2.repartirExperiencia(e1.calcularExperiencia());
		} else if (!e2.quedaAlgunoVivo()){
			e1.repartirExperiencia(e2.calcularExperiencia());
		}
		
	}
	
	/***
	 * 
	 * 3. 	Dado un Personaje que pertenece a una Alianza, cuando resulten ganadores de un combate contra un 
	 * Personaje Genérico, entonces el sistema incrementará la experiencia de todos ellos.
	 * 
	 ***/
	
	@Test
	public void historia10Criterio03_Test() {
		Personaje p1 = new Humano("Humano1","1231");
		Personaje p2 = new Orco("Humano2","1231");
		Generico g = new Generico("Terminator");
		p1.setCasta(new Guerrero());
		p2.setCasta(new Hechicero());
		
		/*
		 * Armo la alianza: 
		 *  
		 * */
		Alianza a1 = new Alianza();
		p1.setAlianzaActual(a1);
		p2.setAlianzaActual(a1);
		
		
		p1.getAlianzaActual().formarAlianza(p2);
		p2.getAlianzaActual().formarAlianza(p1);
		
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
		
		Combate c = new Combate("Nueva Batalla");
		while(e1.quedaAlgunoVivo() && g.estaVivo()){
			c.combatir(e1,g);
		}
		
		if(e1.quedaAlgunoVivo()){
			e1.repartirExperiencia(g.getNivel() * 10);
		}
		
	}
	
}
