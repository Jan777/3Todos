package criterios_aceptacion;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

import castas.*;
import dominio.*;
import habilidades.*;
import razas.*;

// Agregado criterio 4, faltan 1, 2 y 3

/***
 * 
 * 2)	 Como Jugador, Quiero ingresar a un mundo.
 *  Motivación: Para adquirir experiencia, ítems y habilidades nuevas. 
 * 
 ***/
public class Historia02Test {

	/***
	 * 
	 * 1.	Dado un Jugador, cuando quiera ingresar a alguna partida, entonces seleccionará uno de los mundos 
	 * 
	 ***/
	public void historia02Criterio01_Test(){
		
	}
	

	/***
	 * 
	 * 2.	Dado un Jugador, cuando se encuentre en alguna partida o buscando alguna para ingresar, entonces se le mostrará 
	 * aquellas partidas o mundos disponibles a las cuales le sea posible unirse.
	 * 
	 ***/
	public void historia02Criterio02_Test(){
		
	}
	

	/***
	 * 
	 * 3.	Dado un Jugador, cuando su personaje gane una batalla contra otro personaje Jugador o un personaje genérico,
	 * entonces obtendrá experiencia e ítems.
	 * 
	 ***/
	public void historia02Criterio03_Test(){
		
	}
	

	/***
	 * 
	 * 4.	Dado un Jugador, cuando su personaje acumule la experiencia necesaria para aumentar de nivel, entonces podrá agregar 
	 * nuevas habilidades.
	 *
	 * 
	 ***/
	@Test
	public void historia02Criterio04_Test() throws FileNotFoundException{
		/*
		 * Se crean 2 usuarios y dos personajes en base a estos usuarios 
		 * */
		
		Usuario u1 = new Usuario("Usuario 1","asd3");
		Usuario u2 = new Usuario("Usuario 2","asd3");
		
		Personaje p1 = new Orco(u1);
		Personaje p2 = new Elfo(u1);
	
		p1.setClase(new Guerrero());
		p2.setClase(new Guerrero());

		/*
		 * Compruebo mis atributos iniciales
		 * */
		
		Assert.assertEquals(12, p1.calcularPuntosDeAtaque());
		Assert.assertEquals(5, p1.calcularPuntosDeDefensa());
		Assert.assertEquals(3, p1.calcularPuntosDeMagia());
		Assert.assertEquals(0, p1.getVelocidad());
		Assert.assertEquals(0, p1.getDestreza());
		Assert.assertEquals(0, p1.getPotencia());
		
		/*
		 * Ataco para obtener experiencia 
		 * */
		
		while(p2.estaVivo() && p1.getNivel()<=5){
			p1.atacar(p2);
			p1.atacar(p2);
			p1.atacar(p2);
			p1.atacar(p2);
			if(p1.getEnergia()<10+p1.calcularPuntosDeAtaque()){
				p1.serEnergizado();
			}
			
		}
		
		/*
		 * El personaje p1 sube de nivel
		 * */
		Assert.assertEquals(2, p1.getNivel());
		
		
		/*
		 * El personaje p1 acumula 2 puntos por subir de nivel
		 * */
		
		Assert.assertEquals(2, p1.getPuntos());
		
		/*
		 * El personaje agrega una nueva habilidad a su lista. Ésta es ingresada con 1 punto.
		 * */
		p1.getClase().agregarHabilidad(new Inteligencia());
		p1.getClase().getHabilidades().get(4).afectar(p1);
		
		p1.getClase().agregarHabilidad(new Valentia());
		p1.getClase().getHabilidades().get(5).afectar(p1);
		
		/*
		 * Compruebo que mi lista tiene dos habilidades y que las mismas tienen 1 punto cada una.
		 * */
		Assert.assertEquals(2, p1.getClase().getHabilidades().size());
		Assert.assertEquals(1, p1.getClase().getHabilidades().get(4).getPuntos());
		Assert.assertEquals(1, p1.getClase().getHabilidades().get(5).getPuntos());
		
		
		/*
		 * Por ultimo compruebo que mis atributos base han cambiado
		 * */
			
		Assert.assertEquals(12+2+1, p1.calcularPuntosDeAtaque());
		Assert.assertEquals(5, p1.calcularPuntosDeDefensa());
		Assert.assertEquals(3, p1.calcularPuntosDeMagia());
		Assert.assertEquals(0, p1.getVelocidad());
		Assert.assertEquals(0, p1.getDestreza());
		Assert.assertEquals(0+1, p1.getPotencia());
	}

}
