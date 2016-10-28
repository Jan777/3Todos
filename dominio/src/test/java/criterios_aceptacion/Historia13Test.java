package criterios_aceptacion;

import org.junit.Assert;
import org.junit.Test;

import castas.Chaman;
import castas.Guerrero;
import dominio.Personaje;
import items.DagaDeDragon;
import items.EspadaDeJuanNieve;
import razas.Humano;
import razas.Orco;

// OK

/***
 * 
 * 13)	 Como Personaje, puedo morir en combate.
 *  Motivación: Reaparecer en una zona segura.
 * 
 ***/
public class Historia13Test {

	
	
	/***
	 * 
	 * 1.	Dado un Personaje, cuando éste es derrotado en combate, entonces reaparece en el lugar seguro designado en el mundo 
	 * donde se encuentra. 
	 * 
	 ***/
	
	@Test
	public void historia13Criterio01_Test() {
		
		/*
		 * Creo los personajes
		 * */
		
		Personaje p1 = new Orco("gato","loco");
		Personaje p2 = new Humano("perro","loco");
		p1.setCasta(new Guerrero());
		p2.setCasta(new Chaman());
		p1 = new DagaDeDragon(p1);
		p1 = new EspadaDeJuanNieve(p1);
		
		/*
		 * Verifico experiencia y nivel
		 * */
		
		Assert.assertEquals(0, p1.getExperiencia());
		Assert.assertEquals(1, p1.getNivel());
		
		/*
		 * Ataco repetidamente para ganar experiencia y subir de nivel
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
		 * Verifico que el personaje p2 esté muerto
		 * */
		Assert.assertEquals(false, p2.estaVivo());
		
		/*
		 * El personaje debe ser revivido y debe reaparecer en otra posición del mapa.
		 * */
		
		p2.serCurado();
		
		// Método a definir e implementar
		p2.reubicar();
		
		Assert.assertEquals(100, p2.getVida());
	}
}
