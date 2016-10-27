package criterios_aceptacion;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

import castas.*;
import dominio.*;
import habilidades.*;
import items.*;
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
	 * alianza de su nuevo compa�ero o formar una nueva. 
	 * 
	 ***/
	
	@Test
	public void historia09Criterio01_Test() throws FileNotFoundException{
		/*
		 * Creacion de objetos
		 * */
		Personaje p1 = new Humano("Fernando De La Rua","123");
		Personaje p2 = new Humano("Chacho Alvarez","123");
		p1.setClase(new Chaman());
		p2.setClase(new Guerrero());
		p1.setUbicacion(new Ubicacion(0, 0));
		p2.setUbicacion(new Ubicacion(3, 0));
		
		/*
		 * Creacion de alianza
		 * */
		Alianza a = new Alianza("Alianza99");
		
		/*
		 * Agrego personajes a la Alianza 
		 * */
		
		a.formarAlianza(p1);
		
		for(Personaje p : a.getIntegrantes())
		{
			/*Verifico que estꮠcerca en un radio = 2*/
			if(p2.seEncuentraCerca(p))
			{
				a.formarAlianza(p2);
				break;
			}
		}
		
		
		Personaje p3 = new Humano("Mauricio Macri","123");
		p3.setClase(new Hechicero());
		/*Seteo ubicacion alejado del resto.*/
		p3.setUbicacion(new Ubicacion(15, 0));
		
		for(Personaje p : a.getIntegrantes())
		{
			/*Verifico que el personaje este cerca en un radio = 2*/
			if(p3.seEncuentraCerca(p))
			{
				a.formarAlianza(p3);
				break;
			}
		}
		/*
		 * Controlo que mi alianza tenga 2 miembros
		 * */
		
		Assert.assertEquals(2, a.cantidadMiembrosAlianza());
		
	}
	
	
	/***
	 * 
	 * 2.	Dado un Personaje, cuando se encuentre cercano a otro e interactuen, entonces este podra combatir 
	 * contra el hasta definir un ganador.
	 * 
	 ***/
	
	@Test
	public void historia09Criterio02_Test() throws FileNotFoundException{
		Alianza pro = crearAlianzaPro();
		Alianza claseMedia = crearAlianzaClaseMedia();
		/*Combatir por turnos.*/
		
	}
	
	private Alianza crearAlianzaPro()
	{
		Personaje p1 = new Humano("Mauricio Macri","123");
		Personaje p2 = new Humano("Eugenia Vidal","123");
		p1.setClase(new Chaman());
		p2.setClase(new Guerrero());
		p1.setUbicacion(new Ubicacion(0, 0));
		p2.setUbicacion(new Ubicacion(3, 0));
		
		/*
		 * Creacion de alianza
		 * */
		Alianza a = new Alianza("Pro");
		
		/*
		 * Agrego personajes a la Alianza 
		 * */
		
		a.formarAlianza(p1);
		
		for(Personaje p : a.getIntegrantes())
		{
			/*Verifico que estꮠcerca en un radio = 2*/
			if(p2.seEncuentraCerca(p))
			{
				a.formarAlianza(p2);
				break;
			}
		}
		return a;
	}
	
	private Alianza crearAlianzaClaseMedia()
	{
		Personaje p1 = new Humano("Carlos Perez","123");
		Personaje p2 = new Humano("Juan Fernandez","123");
		p1.setClase(new Chaman());
		p2.setClase(new Guerrero());
		p1.setUbicacion(new Ubicacion(0, 0));
		p2.setUbicacion(new Ubicacion(3, 0));
		
		/*
		 * Creacion de alianza
		 * */
		Alianza a = new Alianza("ClaseMedia");
		
		/*
		 * Agrego personajes a la Alianza 
		 * */
		
		a.formarAlianza(p1);
		
		for(Personaje p : a.getIntegrantes())
		{
			/*Verifico que estꮠcerca en un radio = 2*/
			if(p2.seEncuentraCerca(p))
			{
				a.formarAlianza(p2);
				break;
			}
		}
		return a;
	}
}
