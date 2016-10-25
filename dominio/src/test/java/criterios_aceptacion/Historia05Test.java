package criterios_aceptacion;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

import castas.*;
import dominio.*;
import habilidades.*;
import items.*;
import razas.*;

// Falta el criterio 4

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
		
		p1.setClase(new Guerrero());
		p2.setClase(new Guerrero());
		p3.setClase(new Guerrero());
		
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
		
		
		/*
		 * Ataco para subir de nivel
		 * */
		
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
		
		p1.getClase().getHabilidades().get(1).afectar(p1);
		
		/*
		 * El personaje p1 queda con un punto disponible
		 */
		Assert.assertEquals(1, p1.getPuntos());
		
		/*
		 * El personaje p1 tiene la habilidad Destreza con 2 puntos
		 */
		Assert.assertEquals(1, p1.getClase().getHabilidades().get(1).getPuntos());
		
		
		/*
		 * El personaje p1 mejoró sus atributos gracias a su nueva habilidad
		 * */
		Assert.assertEquals(10, p1.calcularPuntosDeAtaque());
		Assert.assertEquals(10, p1.calcularPuntosDeDefensa());
		Assert.assertEquals(0, p1.calcularPuntosDeMagia());
		Assert.assertEquals(0+1, p1.getVelocidad());
		Assert.assertEquals(0, p1.getDestreza());
		Assert.assertEquals(0+1, p1.getPotencia());
	}

	
	
	/***
	 * 
	 *3.	Dado un Personaje equipado con items, cuando éste aumente su nivel podrá asignar puntos adicionales a sus habilidades, 
	 * entonces podrá mejorar sus atributos para el manejo de ciertos items.
	 * 
	 ***/

	
	@Test
	public void historia05Criterio03_Test() throws FileNotFoundException{
		Personaje p1 = new Humano("JRR10","VeryDificul");
		Personaje p2 = new Humano("Yepes","Cabezon");
		
		p1.setClase(new Guerrero());
		p1 = new PocionBruta(p1);
		
		p1.getClase().agregarHabilidad(new Inteligencia());
		
		
		/*
		 * Controlo que el personaje p1 tenga una habilidad
		 * */
		Assert.assertEquals(1, p1.getClase().getHabilidades().size());
		
		
		/*
		 * Ataco para subir de nivel
		 * */
		
		while(p2.estaVivo() && p1.getNivel()<=3){
			p1.atacar(p2);
			p1.atacar(p2);
			p1.atacar(p2);
			p1.atacar(p2);
			if(p1.getEnergia() < 10 + p1.calcularPuntosDeAtaque()){
				p1.serEnergizado();
			}			
		}
		
		
		/*
		 * El personaje p1 sube de nivel
		 * */
		Assert.assertEquals(4, p1.getNivel());		
		
		/*
		 * El personaje p1 acumula 6 puntos por subir de nivel
		 */
		
		Assert.assertEquals(6, p1.getPuntos());
		
		/*
		 * El personaje p1 asigna estos puntos a sus habilidades
		 */
		
		p1.getClase().getHabilidades().get(4).afectar(p1);
		
		/*
		 * El personaje p1 queda con un punto disponible
		 */
		Assert.assertEquals(5, p1.getPuntos());
		
		/*
		 * El personaje p1 tiene la habilidad Destreza con 2 puntos
		 */
		Assert.assertEquals(1, p1.getClase().getHabilidades().get(4).getPuntos());
		
		
		/*
		 * El personaje p1 mejoró sus atributos gracias a su nueva habilidad
		 * */
		Assert.assertEquals(10-2+1, p1.calcularPuntosDeAtaque());
		Assert.assertEquals(10+4, p1.calcularPuntosDeDefensa());
		Assert.assertEquals(0+2, p1.calcularPuntosDeMagia());
		Assert.assertEquals(0, p1.getVelocidad());
		Assert.assertEquals(0, p1.getDestreza());
		Assert.assertEquals(0+1, p1.getPotencia());	
		
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
