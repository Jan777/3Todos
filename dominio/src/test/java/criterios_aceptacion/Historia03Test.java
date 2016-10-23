package criterios_aceptacion;


import dominio.*;
import habilidades.*;
import items.*;

import razas.*;
import castas.*;
import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;



/*
 * 3)	 Atacar personajes.
 * Motivación: Para aumentar mi experiencia.  
 * */

public class Historia03Test {


	/*1.	Dado un Orco, cuando gane alguna batalla contra otro Personaje Jugador o Personaje Genérico, entonces el Orco aumentará su 
	 * experiencia acorde al nivel del derrotado.
	 * */
	@Test
	public void historia03Criterio01_Test() throws FileNotFoundException{
		
		/****************************************************
		 * 3.1.2 - Orco contra otro personaje
		 * ****************************************************/
		
		// Creación de personajes
		Personaje o1 = new Orco ("Orquito1","123");
		Personaje o2 = new Orco ("Orquito2","123");
		o1.setClase(new Guerrero());
		o2.setClase(new Guerrero());
		o1 = new EspadaDeJuanNieve(o1);
		o1 = new DagaDeDragon(o1);
		
		// Verifico mi experiencia inicial
		Assert.assertEquals(0, o1.getExperiencia());
		Assert.assertEquals(12+4+5, o1.calcularPuntosDeAtaque());
		// Verifico el nivel del Orco 2
		Assert.assertEquals(1, o2.getNivel());
		
		// Orco 1 ataca a Orco 2 hasta matarlo
		o1.atacar(o2);
		o1.atacar(o2);
		o1.atacar(o2);
		o1.atacar(o2);
		o1.serEnergizado();
		o1.atacar(o2);
		o1.atacar(o2);
		o1.atacar(o2);
		
		/*
		 * El Orco 2 muere
		 * */
		
		Assert.assertEquals(false, o2.estaVivo());
		
		/*
		 * El atacante debe ganar 8 puntos de experiencia por cada ataque realizado y 10*Nivel del oponente en caso de matar 
		 * al oponente.
		 * */ 
		Assert.assertEquals(6*8 + 10, o1.getExperiencia());
		
		
		/****************************************************
		 * 3.1.2 - Orco contra Genérico
		 * ****************************************************/
		
		// Creación de personajes
		Personaje o3 = new Orco ("Orquito3","123");
		Generico g1 = new Generico ("Generico 1");
		o3.setClase(new Hechicero());
		
		o3 = new EspadaDeJuanNieve(o3);
		o3 = new DagaDeDragon(o3);
		
		// Verifico mi experiencia inicial
		Assert.assertEquals(0, o3.getExperiencia());
		
		/*
		 * Verifico los puntos de ataque del orco: 12 + 5 + 4
		 * */
		
		Assert.assertEquals(12+4+5, o3.calcularPuntosDeAtaque());
		
		// Orco 3 ataca a Genérico 1 hasta matarlo
		o3.atacar(g1);
		o3.atacar(o1);
		o3.atacar(g1);
		o3.atacar(g1);
		o3.atacar(g1);
		o3.serEnergizado();
		o3.atacar(g1);
		o3.atacar(g1);
		o3.atacar(g1);
		o3.atacar(g1);
		o3.atacar(g1);
		
		/*
		 * Chequeo que el Orco 2 esté muerto 
		 * */
		g1.verEstado();
		Assert.assertEquals(false, g1.estaVivo());
		
		/*
		 * El atacante debe ganar 8 puntos de experiencia por cada ataque realizado y 10*Nivel del oponente en caso de matar 
		 * al oponente.
		 * */ 
		Assert.assertEquals(6*8 + 10, o1.getExperiencia());
		
	}
	
	
	/*2.	Dado un Humano, cuando gane alguna batalla contra otro Personaje Jugador o Personaje Genérico, entonces el Humano 
	 * aumentará su experiencia acorde al nivel del derrotado.
	 * */
	public void historia03Criterio02_Test(){
		
	}
	
	/*3.	Dado un Elfo, cuando gane alguna batalla contra otro Personaje Jugador o Personaje Genérico, entonces el Elfo aumentará su 
	 * experiencia acorde al nivel del derrotado..
	 * */
	public void historia03Criterio03_Test(){
		
	}
	

}
