package criterios_aceptacion;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

import castas.*;
import dominio.*;
import habilidades.*;
import items.*;
import razas.*;

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
	public void historia10Criterio01_Test() throws FileNotFoundException{
		/*
		 * Creo los objetos personaje
		 * */
		
		Personaje p1 = new Humano("Humano1","1231");
		Personaje p2 = new Orco("Humano2","1231");
		Personaje p3 = new Elfo("Humano3","1231");
		p1.setClase(new Guerrero());
		p2.setClase(new Hechicero());
		p3.setClase(new Chaman());
		
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
		
		while(e1.quedaAlgunoVivo() && e2.quedaAlgunoVivo() ){
			p1.atacar(p3);
			p2.atacar(p3);
			p3.atacar(p1);
			p1.serEnergizado();
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
	public void historia10Criterio02_Test() throws FileNotFoundException{
		/*
		 * @mauroat - 24/10/16:
		 * Creo odavía no puede probarse
		 * */
		
	}
	
	/***
	 * 
	 * 3. 	Dado un Personaje que pertenece a una Alianza, cuando resulten ganadores de un combate contra un 
	 * Personaje Genérico, entonces el sistema incrementará la experiencia de todos ellos.
	 * 
	 ***/
	
	@Test
	public void historia10Criterio03_Test() throws FileNotFoundException{
		/*
		 * @mauroat - 24/10/16:
		 * Creo odavía no puede probarse
		 * */
		
	}
	
}
