package criterios_aceptacion;

import org.junit.Assert;
import org.junit.Test;

import castas.Chaman;
import castas.Guerrero;
import castas.Hechicero;
import dominio.Generico;
import dominio.Personaje;
import dominio.PersonajeEquipado;
import dominio.Usuario;
import habilidades.Inteligencia;
import habilidades.Valentia;
import items.PocionSabiduria;
import items.RunaDeMagia;
import razas.Elfo;
import razas.Humano;
import razas.Orco;

// Agregado criterio 3 y 4, faltan 1 y 2
// criterio 3 parecido al criterio 1 de historia de usuario 7

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
	 * @ 
	 * @throws CloneNotSupportedException 
	 * 
	 ***/
	public void historia02Criterio03_Test() throws CloneNotSupportedException{
		/**
		 * 2.3.1.	Personaje contra Personaje
		*/
		
		/*
		 * Creo los personajes en base a los usuarios
		 * */
		Usuario u1 = new Usuario ("Skay","Paez");
		Usuario u2 = new Usuario ("Semilla","Charpentier");
		
		Personaje p1 = new Humano(u1);
		Personaje p2 = new Elfo(u2);
		
		p1.setCasta(new Hechicero());
		p2.setCasta(new Chaman());
		
		
		/*
		 * Equipo al p2 con 2 items: el mas prioritario es Pocion Sabiduria
		 * */
		
		p2 = new RunaDeMagia(p2);
		p2 = new PocionSabiduria(p2);
		
		/*
		 * Como recien está creado, su experiencia es 0
		 * */
		Assert.assertEquals(0, p1.getExperiencia());
		
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
		
		/*
		 * La lista de items del personaje p1 ahora es 1 ya que obtuvo el mejor item del eliminado
		 * */
		
		Assert.assertEquals(1, p1.getTamañoLista());
		Assert.assertEquals("Poción sabiduría", p1.getNombreItem());
		
		/*
		 * Luego de atacar, su experiencia ya no es 0
		 * */
		Assert.assertNotEquals(0, p1.getExperiencia());
		
		/**
		 * 2.3.2.	Personaje contra Generico
		*/
		
		Usuario u3 = new Usuario ("Dawi","Paez");
		Personaje p3 = new Humano(u3);
		p3.setCasta(new Hechicero());
		
		Generico g1 = new Generico();
		
		/*
		 * Ataco al generico hasta matarlo
		 * */
		
		while(g1.estaVivo()){
			p3.atacar(g1);
			p3.atacar(g1);
			p3.atacar(g1);
			p3.serEnergizado();			
		}
		
		/*
		 * Si está muerto, me equipo con su item
		 * */
		
		if(!g1.estaVivo()){			
			p3 = p3.equipar(g1.getItem());
		}
		
		/*
		 * Controlo que la lista de p3 tenga un item
		 * */
		
		Assert.assertEquals(1, p3.getTamañoLista());
		
	}
	

	/***
	 * 
	 * 4.	Dado un Jugador, cuando su personaje acumule la experiencia necesaria para aumentar de nivel, entonces podrá agregar 
	 * nuevas habilidades.
	 * 
	 ***/
	@Test
	public void historia02Criterio04_Test() {
		/*
		 * Se crean 2 usuarios y dos personajes en base a estos usuarios 
		 * */
		
		Usuario u1 = new Usuario("Usuario 1","asd3");
		Usuario u2 = new Usuario("Usuario 2","asd3");
		
		Personaje p1 = new Orco(u1);
		Personaje p2 = new Elfo(u1);
	
		p1.setCasta(new Guerrero());
		p2.setCasta(new Guerrero());

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
