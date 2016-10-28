package criterios_aceptacion;
import org.junit.Assert;
import org.junit.Test;

import ataques.CuerpoACuerpo;
import castas.Chaman;
import castas.Guerrero;
import dominio.Personaje;
import items.DagaDeDragon;
import items.EspadaDeJuanNieve;
import razas.Elfo;

// OK

/***
 * 
 * 14)	  Como Personaje, quiero agregar ataques.
 * Motivaci�n: Para poder hacer m�s da�o.
 * 
 ***/
public class Historia14Test {

	
	
	/***
	 * 
	 * 1.	Dado un Personaje, cuando luego de acumular experiencia alcanza un determinado nivel, entonces se le otorgar� un nuevo ataque. 
	 * 
	 ***/
	
	@Test
	public void historia14Criterio01_Test() {
		
		/*
		 * Creo los personajes
		 * */
		
		Personaje p1 = new Elfo("gato","loco");
		Personaje p2 = new Elfo("perro","loco");
		p1.setCasta(new Guerrero());
		p2.setCasta(new Chaman());
		p1 = new DagaDeDragon(p1);
		p1 = new EspadaDeJuanNieve(p1);
		/*
		 * Verifico experiencia, nivel y cantidad de ataques que puede agregar
		 * */
		Assert.assertEquals(0, p1.getExperiencia());
		Assert.assertEquals(1, p1.getNivel());
		Assert.assertEquals(0, p1.getPuedeAgregarAtaque());
		
		/*
		 * Ataco repetidamente para ganar experiencia y subir de nivel
		 * */
		while(p2.estaVivo() && p1.getNivel()<=5){
			p1.atacar(p2);
			p1.atacar(p2);
			p1.atacar(p2);
			p1.atacar(p2);
			if(p1.getEnergia()<10+p1.calcularPuntosDeAtaque()){
				p1.serEnergizado();
			}
			
			if(!p2.estaVivo()){			
				p2.serCurado();
			}
		}
		p1.atacar(p2);
		p1.atacar(p2);
		
		
		/*
		 * Verifico que el personaje p2 est� muerto, que el personaje p1 aumente de nivel y que este puede agregar un ataque.
		 * */
		Assert.assertEquals(false, p2.estaVivo());
		Assert.assertEquals(6, p1.getNivel());
		Assert.assertEquals(1, p1.getPuedeAgregarAtaque());
		
		/*
		 * El personaje p1 agrega un ataque
		 * */
		
		p1.agregarAtaque(new CuerpoACuerpo());
		
		/*
		 * Verifico cuantos ataques tiene en su lista y que ya no pueda agregar ataques hasta que suba de nivel.
		 * */
		

		Assert.assertEquals(1, p1.getCantidadAtaques());		
		Assert.assertEquals(0, p1.getPuedeAgregarAtaque());
		
		
	}
}
