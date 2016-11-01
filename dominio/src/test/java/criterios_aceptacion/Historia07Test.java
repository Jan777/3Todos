package criterios_aceptacion;

import org.junit.Assert;
import org.junit.Test;

import castas.*;
import dominio.*;
import habilidades.*;
import items.*;
import razas.*;


// Agregado criterio 1 y 3.
// Falta 2

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
	 * @throws CloneNotSupportedException 
	 * 
	 ***/
	
	@Test
	public void historia07Criterio01_Test() throws CloneNotSupportedException{
	
		/**
		 * 7.1.1.	Personaje con otro personaje
		 * */
		Personaje p1 = new Humano("Fito","Paez");
		Personaje p2 = new Elfo("Chano","Charpentier");
		p1.setCasta(new Hechicero());
		p1.setCasta(new Chaman());
		
		
		/*
		 * Equipo al p2 con 2 items: el mas prioritario es Pocion Sabiduria
		 * */
		
		p2 = new RunaDeMagia(p2);
		p2 = new PocionSabiduria(p2);
		
		/*
		 * Combate entre p1 y p2 
		 */
		
		while(p2.estaVivo()){
			p1.atacar(p2);
			p1.atacar(p2);
			p1.atacar(p2);
			p1.serEnergizado();			
		}
		
		if(!p2.estaVivo()){
			PersonajeEquipado mejorItem = (PersonajeEquipado) p2.dejarMejorItem();
			p2 = p2.desequipar((PersonajeEquipado)p2.dejarMejorItem());
			p1 = p1.equipar(mejorItem);
	
		}
		
		Assert.assertEquals(1, p1.getTamañoLista());
		Assert.assertEquals("Poción sabiduría", p1.getNombreItem());
		
		/**
		 * 7.1.2.	Personaje con genérico
		 * */
		Personaje p3 = new Humano("Fito","Paez");
		p3.setCasta(new Hechicero());
		p3.setCasta(new Chaman());
		p3 = new EspadaDeJuanNieve(p3);
		Generico g1 = new Generico();
		
	
		/*
		 * Los genericos se generan con un item aleatorio por defecto
		 * */
		Assert.assertNotEquals(null, g1.getItem());
				
		/*
		 * Combate entre p1 y p2 
		 */
		
		while(g1.estaVivo()){
			p3.atacar(g1);
			p3.atacar(g1);
			p3.atacar(g1);
			p3.serEnergizado();			
		}
		
		if(!g1.estaVivo()){			
			p1 = p1.equipar(g1.getItem());
		}
		
		Assert.assertEquals(2, p1.getTamañoLista());
		
	}
	
	
	/***
	 * 
	 * 2.	Dado un Personaje, cuando encuentre un ítem al recorrer el mundo donde se encuentra, entonces podrá equiparse con 
	 * el mismo o agregarlo a su inventario.
	 * 
	 ***/
	
	@Test
	public void historia07Criterio02_Test() {
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
	public void historia07Criterio03_Test() {
		
		
		/*
		 * Creo un objeto personaje estandar
		 * */
		Personaje p1 = new Humano("Pepito","Pepote");
		p1.setCasta(new Guerrero());
		
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
