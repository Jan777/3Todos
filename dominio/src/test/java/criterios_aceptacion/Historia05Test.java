package criterios_aceptacion;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

import castas.*;
import dominio.*;
import habilidades.*;
import items.*;
import razas.*;

/***
 * 
 * 5)	 Como Personaje, quiero subir de nivel.  
 * Motivación: Para poder asignar puntos adicionales a mis habilidades.
 * 
 ***/

public class Historia05Test {


	/***
	 * 
	 * 1.	Dado un Personaje, cuando éste aumente su nivel, entonces se le otorgarán puntos adicionales para poder agregar a 
	 * sus habilidades.
	 * 
	 ***/
	
	@Test
	public void historia05Criterio01_Test() throws FileNotFoundException{
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
		
		
		/*
		 * El personaje p1 sube de nivel
		 * */
		Assert.assertEquals(2, p1.getNivel());
		
		
		/*
		 * El personaje p1 acumula 2 puntos por subir de nivel
		 * */
		
		Assert.assertEquals(2, p1.getPuntos());
		
	}
	
	/***
	 *
	 * 2.	Dado un Personaje, cuando éste aumente su nivel y acumule puntos de habilidades, entonces se le permitirá mejorar 
	 * las habilidades existentes asignándoles puntos especiales.
	 * 
	 ***/
	
	@Test
	public void historia05Criterio02_Test() throws FileNotFoundException{
		Personaje p1 = new Humano("CarlosTevez","VeryDificul");
		Personaje p2 = new Humano("Dalessandra","Cabezon");
		Personaje p3 = new Humano("Romagnola","Cabezon");
		
		p1.setClase(new Guerrero());
		p1.getClase().agregarHabilidad(new Destreza());
		
		/*
		 * Controlo que el personaje p1 tenga una habilidad
		 * */
		Assert.assertEquals(1, p1.getClase().getHabilidades().size());
		
		
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
		
		
		/*
		 * El personaje p1 sube de nivel
		 * */
		Assert.assertEquals(2, p1.getNivel());
		
		
		/*
		 * El personaje p1 acumula 2 puntos por subir de nivel
		 */
		
		Assert.assertEquals(2, p1.getPuntos());
		
		/*
		 * El personaje p1 asigna estos puntos a sus habilidades
		 */
		
		// Aquí tenemos que definir como afectan las habilidades en los personajes.
		
		/*
		 * El personaje p1 no tiene más puntos disponibles
		 */
		Assert.assertEquals(0, p1.getPuntos());
	}

	
	
	/***
	 * 
	 *3.	Dado un Personaje equipado con items, cuando éste aumente su nivel podrá asignar puntos adicionales a sus habilidades, 
	 * entonces podrá mejorar sus atributos para el manejo de ciertos items.
	 * 
	 ***/
	/*
	 *  @mauroat - 23/10/16
	 *  Hay que ver como "mejora el manejo de ciertos items"
	 * */
	
	@Test
	public void historia05Criterio03_Test() throws FileNotFoundException{
		
		
	}
	
	
	/***
	 * 
	 * 4.	Dado un Personaje, cuando éste aumente su nivel y alcance uno determinado, entonces podrá agregar una nueva habilidad 
	 * que afecte sus atributos. 
	 * 
	 ***/
	
	@Test
	public void historia05Criterio04_Test() throws FileNotFoundException{
		
		
	}
	
}
