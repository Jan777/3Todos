package criterios_aceptacion;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

import castas.*;
import dominio.*;
import habilidades.*;
import items.*;
import razas.*;

// Agregado criterio 3.
// Falta 1 y 2

/***
 * 
 * 7) Como Personaje, Quiero equipar Items. 
 * Motivacion: Para poder potenciar mis habilidades.
 * 
 ***/

public class Historia07Test {


	/***
	 * 
	 * 1.	Dado un Personaje, cuando éste mata a otro Personaje Jugador o Personaje Genérico, entonces éste se equipará con 
	 * el mejor item de su enemigo.
	 * 
	 ***/
	
	@Test
	public void historia07Criterio01_Test() throws FileNotFoundException{
		
		
	}
	
	
	/***
	 * 
	 * 2.	Dado un Personaje, cuando encuentre un ítem al recorrer el mundo donde se encuentra, entonces podrá equiparse con 
	 * el mismo o agregarlo a su inventario.
	 * 
	 ***/
	
	@Test
	public void historia07Criterio02_Test() throws FileNotFoundException{
		/*
		 * @mauroat - 24/10/16:
		 * Creo odavía no puede probarse
		 * */
		
	}
	
	/***
	 * 
	 * 3.	Dado un Personaje, cuando selecciona el ítem nuevo para equiparse, entonces éste será más fuerte con la combinación 
	 * de ítem y habilidad.	
	 * 
	 ***/
	
	@Test
	public void historia07Criterio03_Test() throws FileNotFoundException{
		/*
		 * Creo un objeto personaje estandar
		 * */
		Personaje p1 = new Humano("Pepito","Pepote");
		p1.setClase(new Guerrero());
		
		/*
		 * Verifico el valor de los atributos:
		 * Ataque : 10
		 * Defensa: 10
		 * Magia :  0
		 * Velocidad: 0
		 * Destreza: 0
		 * Potencia: 0
		 * */
		
		Assert.assertEquals(10, p1.calcularPuntosDeAtaque());
		Assert.assertEquals(10, p1.calcularPuntosDeDefensa());
		Assert.assertEquals(0, p1.calcularPuntosDeMagia());
		Assert.assertEquals(0, p1.getVelocidad());
		Assert.assertEquals(0, p1.getDestreza());
		Assert.assertEquals(0, p1.getPotencia());
		
		/*
		 * Equipo al p1 con un item
		 * */
		
		p1 = new PocionSabiduria(p1);
		
		/*
		 * Verifico el nuevo valor de sus atributos:
		 * Ataque : 10
		 * Defensa: 10+2
		 * Magia :  0+3
		 * Velocidad: 0
		 * Destreza: 0
		 * Potencia: 0
		 * */
		
		Assert.assertEquals(10, p1.calcularPuntosDeAtaque());
		Assert.assertEquals(10+2, p1.calcularPuntosDeDefensa());
		Assert.assertEquals(0+3, p1.calcularPuntosDeMagia());
		Assert.assertEquals(0, p1.getVelocidad());
		Assert.assertEquals(0, p1.getDestreza());
		Assert.assertEquals(0, p1.getPotencia());
		
		/*
		 * Agrego una habilidad al personaje
		 * */
		p1.setPuntos(1);
		p1.getClase().agregarHabilidad(new Valentia());		
		p1.getClase().getHabilidades().get(5).afectar(p1);
		
		/*
		 * Verifico el nuevo valor de sus atributos:
		 * Ataque : 10+2
		 * Defensa: 10+2
		 * Magia :  0+3
		 * Velocidad: 0
		 * Destreza: 0
		 * Potencia: 0
		 * */
		
		Assert.assertEquals(10+2, p1.calcularPuntosDeAtaque());
		Assert.assertEquals(10+2, p1.calcularPuntosDeDefensa());
		Assert.assertEquals(0+3, p1.calcularPuntosDeMagia());
		Assert.assertEquals(0, p1.getVelocidad());
		Assert.assertEquals(0, p1.getDestreza());
		Assert.assertEquals(0, p1.getPotencia());
		
		
	}
}
