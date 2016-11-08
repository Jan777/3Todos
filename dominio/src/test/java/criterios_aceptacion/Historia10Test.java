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
 * 10)	 Como Personaje, quiero aliarme con otro personaje.
 * Motivación: Para combatir junto a él y aumentar la experiencia que recolectamos en ese tiempo.
 * 
 ***/

public class Historia10Test {


	/***
	 * 
	 * 1.	Dado un Personaje que pertenece a una Alianza, cuando resulten ganadores de un combate contra otra 
	 * Alianza de Personajes Usuarios, entonces el sistema incrementará la experiencia de todos ellos.
	 * @throws FileNotFoundException 
	 * @throws CloneNotSupportedException 
	 * 
	 ***/
	
	@Test
	public void historia10Criterio01_Test() throws FileNotFoundException, CloneNotSupportedException {
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
		
		p1.setUbicacion(new Ubicacion(0,1));
		p2.setUbicacion(new Ubicacion(0,4));
		p3.setUbicacion(new Ubicacion(1,4));
		p4.setUbicacion(new Ubicacion(1,6));
		
		
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
		
		Combate c = new Combate();
		
		c.combatir(e1,e2);
		
		/*
		 * Todo el equipo 4 esta muerto
		 * */
		Assert.assertEquals(false, p3.estaVivo());
		Assert.assertEquals(false, p4.estaVivo());
		
		/*
		 * p1 obtuvo 88 de experiencia por los ataques realizados 
		 * p2 obtuvo 172 de experiencia por los ataques realizados 
		 * El ultimo peleador vivo del equipo 2 era de nivel 1, por ende la experiencia 
		 * a repartir sera (1)*10 /2 = 5
		 * 
		 * */
		Assert.assertEquals(148+3, p1.getExperiencia());
		Assert.assertEquals(128+7, p2.getExperiencia());
		

	}
	

	
	/***
	 * 
	 * 2.	Dado un Personaje que pertenece a una Alianza, cuando resulten ganadores de un combate contra un 
	 * Personaje Usuario, entonces el sistema incrementará la experiencia de todos ellos. 
	 * @throws FileNotFoundException 
	 * @throws CloneNotSupportedException 
	 * 
	 ***/
	
	@Test
	public void historia10Criterio02_Test() throws FileNotFoundException, CloneNotSupportedException {
		Personaje p1 = new Humano("Humano1","1231");
		Personaje p2 = new Orco("Humano2","1231");
		Personaje p3 = new Elfo("Humano3","1231");
		p1.setCasta(new Guerrero());
		p2.setCasta(new Hechicero());
		p3.setCasta(new Chaman());
		p1.setUbicacion(new Ubicacion(0,1));
		p2.setUbicacion(new Ubicacion(0,4));
		p3.setUbicacion(new Ubicacion(1,4));
		
		
		/*
		 * Armo las alianzas: 
		 *  
		 * */
		p1.formarAlianzaCon(p2);
				
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
		
		Combate c = new Combate("La Batalla de la Muerte");
		
		c.combatir(e1,e2);
		
		/*
		 * Todo el equipo 2 esta muerto
		 * */
		Assert.assertEquals(false, p3.estaVivo());
	
		
		/*
		 * p1 obtuvo 74 de experiencia por los ataques realizados 
		 * p2 obtuvo 64 de experiencia por los ataques realizados 
		 * p3 era de nivel 1, por ende la experiencia 
		 * a repartir sera (1)*10 /2 = 5
		 * 
		 * */
		Assert.assertEquals(74+5, p1.getExperiencia());
		Assert.assertEquals(64+5, p2.getExperiencia());
		
		
	}
	
	/***
	 * 
	 * 3. 	Dado un Personaje que pertenece a una Alianza, cuando resulten ganadores de un combate contra un 
	 * Personaje Genérico, entonces el sistema incrementará la experiencia de todos ellos.
	 * @throws FileNotFoundException 
	 * @throws CloneNotSupportedException 
	 * 
	 ***/
	
	@Test
	public void historia10Criterio03_Test() throws FileNotFoundException, CloneNotSupportedException {
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
		
		Combate c = new Combate();
		
		c.combatir(e1,g);
		
		/*
		 * Personaje generico esta muerto
		 * */
		Assert.assertEquals(false, g.estaVivo());
	
		
		/*
		 * La experiencia no se puede comprobar ya que los genericos se crean con nivel random
		 * */
	
	
		
		
	}
	
}
