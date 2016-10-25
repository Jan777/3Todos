package criterios_aceptacion;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

import castas.*;
import dominio.*;
import habilidades.*;
import items.*;
import razas.*;

// Falta todo


/***
 * 
 * 9)	Como Personaje, quiero encontrarme con otros personajes en el mismo mundo.
 * Motivación: Para aliarme con ellos o combatir contra ellos.
 * 
 ***/

public class Historia09Test {


	/***
	 * 
	 * 1.	Dado un Personaje, cuando se encuentre cercano a otro e interactúen, entonces éste podrá unirse a la 
	 * alianza de su nuevo compañero o formar una nueva. 
	 * 
	 ***/
	
	@Test
	public void historia09Criterio01_Test() throws FileNotFoundException{
		/*
		 * Creación de objetos
		 * */
		Personaje p1 = new Humano("Fernando De La Rua","123");
		Personaje p2 = new Humano("Chacho Álvarez","123");
		p1.setClase(new Chaman());
		p2.setClase(new Guerrero());
		
		/*
		 * Creación de alianza
		 * */
		Alianza a = new Alianza("Alianza99");
		
		/*
		 * Agrego personajes a la Alianza 
		 * */
		
		a.formarAlianza(p1);
		a.formarAlianza(p2);
		
		/*
		 * Controlo que mi alianza tenga 2 miembros
		 * */
		
		Assert.assertEquals(2, a.cantidadMiembrosAlianza());
		
	}
	
	
	/***
	 * 
	 * 2.	Dado un Personaje, cuando se encuentre cercano a otro e interactúen, entonces éste podrá combatir 
	 * contra él hasta definir un ganador.
	 * 
	 ***/
	
	@Test
	public void historia09Criterio02_Test() throws FileNotFoundException{
		/*
		 * @mauroat - 24/10/16:
		 * Creo odavía no puede probarse
		 * */
		
	}
	
	
}
