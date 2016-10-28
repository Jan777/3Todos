package criterios_aceptacion;

import org.junit.Assert;
import org.junit.Test;

import castas.Guerrero;
import dominio.Personaje;
import habilidades.Destreza;
import habilidades.Evasion;
import habilidades.Fuerza;
import habilidades.Inteligencia;
import habilidades.Valentia;
import habilidades.Velocidad;
import razas.Humano;

// OK


/***
 * 
 * 8)	 Como Personaje, Quiero disponer de habilidades de destreza, fuerza e inteligencia.
 * Motivación: Para afectar a mis puntos de ataque, magia y defensa.
 * 
 ***/

public class Historia08Test {


	/***
	 * 
	 * 1.	Dado un Personaje, cuando agrega a su lista de habilidades ‘Destreza’, entonces aumentará su velocidad y potencia. 
	 * 
	 ***/
	
	@Test
	public void historia08Criterio01_Test() {
		/*
		 * Declaración de objeto Personaje
		 * */
		
		Personaje p1 = new Humano("Humanito","123");
		p1.setCasta(new Guerrero());
		
		/*
		 * Compruebo los valores iniciales de los atributos
		 * */
		
		Assert.assertEquals(10, p1.calcularPuntosDeAtaque());
		Assert.assertEquals(10, p1.calcularPuntosDeDefensa());
		Assert.assertEquals(0, p1.calcularPuntosDeMagia());
		Assert.assertEquals(0, p1.getVelocidad());
		Assert.assertEquals(0, p1.getDestreza());
		Assert.assertEquals(0, p1.getPotencia());
		
		/*
		 * Aumento puntos para evitar gastar lineas de codigo en un combate
		 * */
		
		p1.setPuntos(1);
		Assert.assertEquals(1, p1.getPuntos());
		
		
		/*
		 * Asigno la habilidad "1 - Destreza" al personaje p1
		 * */
		
		p1.getClase().agregarHabilidad(new Destreza());
		Assert.assertEquals(1, p1.getClase().getHabilidades().size());
		
		/*
		 * Afecto al personaje con las cualidades de dicha habilidad
		 * */
		p1.getClase().getHabilidades().get(1).afectar(p1);
	
		/*
		 * Controlo que mi punto de habilidad haya bajado y controlo que mis atributos involucrados se incrementen.
		 * */
		Assert.assertEquals(0, p1.getPuntos());		
		Assert.assertEquals(10, p1.calcularPuntosDeAtaque());
		Assert.assertEquals(10, p1.calcularPuntosDeDefensa());
		Assert.assertEquals(0, p1.calcularPuntosDeMagia());
		Assert.assertEquals(0+1, p1.getVelocidad());
		Assert.assertEquals(0, p1.getDestreza());
		Assert.assertEquals(0+1, p1.getPotencia());
	}
	
	
	/***
	 * 
	 * 2.	Dado un Personaje, cuando agrega a su lista de habilidades ‘Fuerza’, entonces aumentará su ataque y potencia.
	 * 
	 ***/
	
	@Test
	public void historia08Criterio02_Test() {
		/*
		 * Declaración de objeto Personaje
		 * */
		
		Personaje p1 = new Humano("Humanito","123");
		p1.setCasta(new Guerrero());
		
		/*
		 * Compruebo los valores iniciales de los atributos
		 * */
		
		Assert.assertEquals(10, p1.calcularPuntosDeAtaque());
		Assert.assertEquals(10, p1.calcularPuntosDeDefensa());
		Assert.assertEquals(0, p1.calcularPuntosDeMagia());
		Assert.assertEquals(0, p1.getVelocidad());
		Assert.assertEquals(0, p1.getDestreza());
		Assert.assertEquals(0, p1.getPotencia());
		
		/*
		 * Aumento puntos para evitar gastar lineas de codigo en un combate
		 * */
		
		p1.setPuntos(1);
		Assert.assertEquals(1, p1.getPuntos());
		
		
		/*
		 * Asigno la habilidad "3 - Fuerza" al personaje p1
		 * */
		
		p1.getClase().agregarHabilidad(new Fuerza());
		Assert.assertEquals(1, p1.getClase().getHabilidades().size());
		
		/*
		 * Afecto al personaje con las cualidades de dicha habilidad
		 * */
		p1.getClase().getHabilidades().get(3).afectar(p1);
	
		/*
		 * Controlo que mi punto de habilidad haya bajado y controlo que mis atributos involucrados se incrementen.
		 * */
		Assert.assertEquals(0, p1.getPuntos());		
		Assert.assertEquals(10+1, p1.calcularPuntosDeAtaque());
		Assert.assertEquals(10, p1.calcularPuntosDeDefensa());
		Assert.assertEquals(0, p1.calcularPuntosDeMagia());
		Assert.assertEquals(0, p1.getVelocidad());
		Assert.assertEquals(0, p1.getDestreza());
		Assert.assertEquals(0+1, p1.getPotencia());
		
	}
	
	/***
	 * 
	 * 3.	Dado un Personaje, cuando agrega a su lista de habilidades ‘Inteligencia’, entonces aumentará su ataque y potencia.
	 * 
	 ***/
	
	@Test
	public void historia08Criterio03_Test() {
		/*
		 * Declaración de objeto Personaje
		 * */
		
		Personaje p1 = new Humano("Humanito","123");
		p1.setCasta(new Guerrero());
		
		/*
		 * Compruebo los valores iniciales de los atributos
		 * */
		
		Assert.assertEquals(10, p1.calcularPuntosDeAtaque());
		Assert.assertEquals(10, p1.calcularPuntosDeDefensa());
		Assert.assertEquals(0, p1.calcularPuntosDeMagia());
		Assert.assertEquals(0, p1.getVelocidad());
		Assert.assertEquals(0, p1.getDestreza());
		Assert.assertEquals(0, p1.getPotencia());
		
		/*
		 * Aumento puntos para evitar gastar lineas de codigo en un combate
		 * */
		
		p1.setPuntos(1);
		Assert.assertEquals(1, p1.getPuntos());
		
		
		/*
		 * Asigno la habilidad "4 - Inteligencia" al personaje p1
		 * */
		
		p1.getClase().agregarHabilidad(new Inteligencia());
		Assert.assertEquals(1, p1.getClase().getHabilidades().size());
		
		/*
		 * Afecto al personaje con las cualidades de dicha habilidad
		 * */
		p1.getClase().getHabilidades().get(4).afectar(p1);
	
		/*
		 * Controlo que mi punto de habilidad haya bajado y controlo que mis atributos involucrados se incrementen.
		 * */
		Assert.assertEquals(0, p1.getPuntos());		
		Assert.assertEquals(10+1, p1.calcularPuntosDeAtaque());
		Assert.assertEquals(10, p1.calcularPuntosDeDefensa());
		Assert.assertEquals(0, p1.calcularPuntosDeMagia());
		Assert.assertEquals(0, p1.getVelocidad());
		Assert.assertEquals(0, p1.getDestreza());
		Assert.assertEquals(0+1, p1.getPotencia());
		
	}
	
	/***
	 * 
	 * 4.	Dado un Personaje, cuando agrega a su lista de habilidades ‘Velocidad’, entonces aumentará su velocidad y su ataque.
	 * 
	 ***/
	
	@Test
	public void historia08Criterio04_Test() {
		/*
		 * Declaración de objeto Personaje
		 * */
		
		Personaje p1 = new Humano("Humanito","123");
		p1.setCasta(new Guerrero());
		
		/*
		 * Compruebo los valores iniciales de los atributos
		 * */
		
		Assert.assertEquals(10, p1.calcularPuntosDeAtaque());
		Assert.assertEquals(10, p1.calcularPuntosDeDefensa());
		Assert.assertEquals(0, p1.calcularPuntosDeMagia());
		Assert.assertEquals(0, p1.getVelocidad());
		Assert.assertEquals(0, p1.getDestreza());
		Assert.assertEquals(0, p1.getPotencia());
		
		/*
		 * Aumento puntos para evitar gastar lineas de codigo en un combate
		 * */
		
		p1.setPuntos(1);
		Assert.assertEquals(1, p1.getPuntos());
		
		
		/*
		 * Asigno la habilidad "6 - Velocidad" al personaje p1
		 * */
		
		p1.getClase().agregarHabilidad(new Velocidad());
		Assert.assertEquals(1, p1.getClase().getHabilidades().size());
		
		/*
		 * Afecto al personaje con las cualidades de dicha habilidad
		 * */
		p1.getClase().getHabilidades().get(6).afectar(p1);
	
		/*
		 * Controlo que mi punto de habilidad haya bajado y controlo que mis atributos involucrados se incrementen.
		 * */
		Assert.assertEquals(0, p1.getPuntos());		
		Assert.assertEquals(10+1, p1.calcularPuntosDeAtaque());
		Assert.assertEquals(10, p1.calcularPuntosDeDefensa());
		Assert.assertEquals(0, p1.calcularPuntosDeMagia());
		Assert.assertEquals(0+1, p1.getVelocidad());
		Assert.assertEquals(0, p1.getDestreza());
		Assert.assertEquals(0, p1.getPotencia());
		
	}
	
	/***
	 * 
	 * 5.	Dado un Personaje, cuando agrega a su lista de habilidades ‘Evasión’, entonces aumentará su defensa.
	 * 
	 ***/
	
	@Test
	public void historia08Criterio05_Test() {
		/*
		 * Declaración de objeto Personaje
		 * */
		
		Personaje p1 = new Humano("Humanito","123");
		p1.setCasta(new Guerrero());
		
		/*
		 * Compruebo los valores iniciales de los atributos
		 * */
		
		Assert.assertEquals(10, p1.calcularPuntosDeAtaque());
		Assert.assertEquals(10, p1.calcularPuntosDeDefensa());
		Assert.assertEquals(0, p1.calcularPuntosDeMagia());
		Assert.assertEquals(0, p1.getVelocidad());
		Assert.assertEquals(0, p1.getDestreza());
		Assert.assertEquals(0, p1.getPotencia());
		
		/*
		 * Aumento puntos para evitar gastar lineas de codigo en un combate
		 * */
		
		p1.setPuntos(1);
		Assert.assertEquals(1, p1.getPuntos());
		
		
		/*
		 * Asigno la habilidad "2 - Evasion" al personaje p1
		 * */
		
		p1.getClase().agregarHabilidad(new Evasion());
		Assert.assertEquals(1, p1.getClase().getHabilidades().size());
		
		/*
		 * Afecto al personaje con las cualidades de dicha habilidad
		 * */
		p1.getClase().getHabilidades().get(2).afectar(p1);
	
		/*
		 * Controlo que mi punto de habilidad haya bajado y controlo que mis atributos involucrados se incrementen.
		 * */
		Assert.assertEquals(0, p1.getPuntos());		
		Assert.assertEquals(10, p1.calcularPuntosDeAtaque());
		Assert.assertEquals(10+2, p1.calcularPuntosDeDefensa());
		Assert.assertEquals(0, p1.calcularPuntosDeMagia());
		Assert.assertEquals(0, p1.getVelocidad());
		Assert.assertEquals(0, p1.getDestreza());
		Assert.assertEquals(0, p1.getPotencia());
		
	}
	
	/***
	 * 
	 * 6.	Dado un Personaje, cuando agrega a su lista de habilidades ‘Valentía’, entonces aumentará su ataque. 
	 * 
	 ***/
	
	@Test
	public void historia08Criterio06_Test() {
		/*
		 * Declaración de objeto Personaje
		 * */
		
		Personaje p1 = new Humano("Humanito","123");
		p1.setCasta(new Guerrero());
		
		/*
		 * Compruebo los valores iniciales de los atributos
		 * */
		
		Assert.assertEquals(10, p1.calcularPuntosDeAtaque());
		Assert.assertEquals(10, p1.calcularPuntosDeDefensa());
		Assert.assertEquals(0, p1.calcularPuntosDeMagia());
		Assert.assertEquals(0, p1.getVelocidad());
		Assert.assertEquals(0, p1.getDestreza());
		Assert.assertEquals(0, p1.getPotencia());
		
		/*
		 * Aumento puntos para evitar gastar lineas de codigo en un combate
		 * */
		
		p1.setPuntos(1);
		Assert.assertEquals(1, p1.getPuntos());
		
		
		/*
		 * Asigno la habilidad "5 - Valentia" al personaje p1
		 * */
		
		p1.getClase().agregarHabilidad(new Valentia());
		Assert.assertEquals(1, p1.getClase().getHabilidades().size());
		
		/*
		 * Afecto al personaje con las cualidades de dicha habilidad
		 * */
		p1.getClase().getHabilidades().get(5).afectar(p1);
	
		/*
		 * Controlo que mi punto de habilidad haya bajado y controlo que mis atributos involucrados se incrementen.
		 * */
		Assert.assertEquals(0, p1.getPuntos());		
		Assert.assertEquals(10+2, p1.calcularPuntosDeAtaque());
		Assert.assertEquals(10, p1.calcularPuntosDeDefensa());
		Assert.assertEquals(0, p1.calcularPuntosDeMagia());
		Assert.assertEquals(0, p1.getVelocidad());
		Assert.assertEquals(0, p1.getDestreza());
		Assert.assertEquals(0, p1.getPotencia());	
		
	}
}
