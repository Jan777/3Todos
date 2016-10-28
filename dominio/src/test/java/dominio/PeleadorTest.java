package dominio;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

import castas.*;
import dominio.*;
import razas.*;
import items.*;


public class PeleadorTest {

	
	/*	@mauroat - 18-10-16:
	 *  Este test verifica que cuando un personaje ataca agote su energ�a, disminuya la vida del atacado y 
	 *  en caso de matarlo sume experiencia.
	 *  El personaje podr� atacar siempre cuando su energ�a sea >= a sus puntos de ataque y el atacado est� vivo. 
	 * */
	
	@Test
	public void peleadorTest() {
		Personaje orco = new Orco("Orcazo","123");
		Personaje elfo = new Elfo("Elfazo","123");
		
		
		/* Con el Orco ataca 15 veces al humano. Deber�a dejar de atacar cuando el Orco se quede sin energia */		
		for (int i = 0; i<15;i++)
			orco.atacar(elfo);
		
		
		Assert.assertEquals(51, elfo.getVida());		

		
		/* Ahora energizo al Orco y termino de rematar al humano. Deberia aumentar la experiencia del Orco*/
		orco.serEnergizado();
		for (int i = 0; i<6;i++){
			orco.atacar(elfo);
		}
			
		orco.serEnergizado();
		
		Assert.assertEquals(104, orco.getExperiencia());
		Assert.assertEquals(9, elfo.getVida());

	}
	
	/*	@mauroat - 18-10-16:
	 *  Este test verifica que cuando un personaje mate varios enemigos aumente experiencia y suba de nivel. 
	 *  La experiencia necesaria para pasar al nivel 2 es 220.
	 * */
	
	@Test
	public void peleadorTestSubirNivel() {
		Personaje orco = new Orco("Orcazo","123");
		Personaje humano1 = new Humano("Humanazo","123");
		Personaje elfo1 = new Elfo("Elfazo","123");
		Personaje elfo2 = new Elfo("Elfazito","123");
			
		for (int i = 0; i<9;i++)			
			orco.atacar(humano1);
		orco.serEnergizado();
		for (int i = 0; i<6;i++)			
			orco.atacar(elfo1);
		orco.serEnergizado();
		for (int i = 0; i<6;i++)			
			orco.atacar(elfo2);
		orco.serEnergizado();
		for (int i = 0; i<6;i++)			
			orco.atacar(elfo2);
		orco.serEnergizado();
		for (int i = 0; i<6;i++)			
			orco.atacar(elfo2);
		
		
		Assert.assertEquals(226, orco.getExperiencia());
		Assert.assertEquals(3, orco.getNivel());
		Assert.assertEquals(4, orco.getPuntos());
	}
	
	/*	@mauroat - 18-10-16:
	 *  Este test verifica que un personaje aumente la lista de items a medida que se va equipando 
	 */
	
	@Test
	public void peleadorDejarMejorItem() {
	
		/* @mauroat - 18/10/16
		 * ERROR: Los items se equipan, sin embargo la lista siempre es reemplazada por el �ltimo item y no son agregados.
		 * @mauroat - 19/10/16
		 * Solucionado.
		 * */
				
		// Sin items
		Personaje humano = new Humano("Indio Solari","123");
		Personaje item;

		Assert.assertEquals(0, humano.getTama�oLista());
		
		// 1 item
		humano = new BastonDeSaruman(humano);
		Assert.assertEquals(1, humano.getTama�oLista());		
		// 2 items
		humano = new BujiaHescher(humano);		
		Assert.assertEquals(2, humano.getTama�oLista());		
		// 3 items
		humano = new ArmaduraDeAzorAhai(humano);
		Assert.assertEquals(3, humano.getTama�oLista());	
		
		// Obtengo mejor item del peleador: Bujia Hescher
		Assert.assertEquals("Buj�a Hescher", humano.dejarMejorItem().getNombreItem());
				
	}

	@Test
	public void peleadorDejarMejorItemDistintasPosiciones() {
				
		// El mejor al comienzo
		Personaje humano = new Humano("Indio Solari","123");

		humano = new BujiaHescher(humano);	
		humano = new BastonDeSaruman(humano);
		humano = new BujiaHescher(humano);		
		humano = new ArmaduraDeAzorAhai(humano);

		Assert.assertEquals("Buj�a Hescher", humano.dejarMejorItem().getNombreItem());
		
		// El mejor al comienzo
		Personaje orco = new Orco("Indio Solari","123");
		
		orco = new BastonDeSaruman(orco);
		orco = new BujiaHescher(orco);		
		orco = new ArmaduraDeAzorAhai(orco);

		Assert.assertEquals("Buj�a Hescher", orco.dejarMejorItem().getNombreItem());
		
		// El mejor al final
		Personaje elfo = new Elfo("Indio Solari","123");
				
		elfo = new BastonDeSaruman(elfo);
		elfo = new BujiaHescher(elfo);		
		elfo = new ArmaduraDeAzorAhai(elfo);

		Assert.assertEquals("Buj�a Hescher", elfo.dejarMejorItem().getNombreItem());
	}
	
	
	@Test
	public void peleadorDejarMejorItemSiEstaRepetido() {
			
		// Sin items
		Personaje humano = new Humano("Indio Solari","123");
		Personaje item;
		
		Assert.assertEquals(0, humano.getTama�oLista());
		
		// 1 item
		humano = new BastonDeSaruman(humano);
		Assert.assertEquals(1, humano.getTama�oLista());		
		// 2 items
		humano = new BujiaHescher(humano);		
		Assert.assertEquals(2, humano.getTama�oLista());		
		// 3 items
		humano = new BujiaHescher(humano);
		Assert.assertEquals(3, humano.getTama�oLista());
		
		// Obtengo mejor item del peleador: Bujia Hescher
		Assert.assertEquals("Buj�a Hescher", humano.dejarMejorItem().getNombreItem());
			
	}
	
	
	@Test
	public void peleadorSeDesequipaConMejorItem() {
		
		// El mas importante al final de la lista
		Personaje humano = new Humano("Indio Solari","123");
		
		humano = new BastonDeSaruman(humano);
		humano = new ArmaduraDeAzorAhai(humano);
		humano = new BujiaHescher(humano);	
		humano = humano.desequipar((PersonajeEquipado)humano.dejarMejorItem());
		//Assert.assertEquals("Humano equipado con: 1- Bast�n de Saruman  2- Armadura de Azor Ahai ", humano.getLista());
		
		// El mas importante al principio de la lista
		Personaje orco = new Orco("Skay Beilinson","123");
		orco = new BujiaHescher(orco);	
		orco = new BastonDeSaruman(orco);
		orco = new ArmaduraDeAzorAhai(orco);

		orco = (orco.desequipar((PersonajeEquipado) orco.dejarMejorItem()));
		
		Assert.assertEquals(2, orco.getTama�oLista());
		Assert.assertEquals("Orco equipado con: 1- Bast�n de Saruman  2- Armadura de Azor Ahai ", orco.getLista());
	}

	
	@Test
	public void peleadorSeDesequipaConMejorItemYOtroSeEquipa() {
		
		
		Personaje humano = new Humano("Indio Solari","123");
		humano.setCasta(new Guerrero());
		
		/*
		 * El item de mayor prioridad es BujiaHescher
		 * */
		
		humano = new BastonDeSaruman(humano);
		humano = new ArmaduraDeAzorAhai(humano);
		humano = new BujiaHescher(humano);	
		
		humano = (humano.desequipar((PersonajeEquipado)humano.dejarMejorItem()));
		
		Assert.assertEquals(2, humano.getTama�oLista());

		
		
		// El mas importante al principio de la lista
		Personaje orco = new Orco("Skay Beilinson","123");
		orco.setCasta(new Hechicero());
		
		orco = new BujiaHescher(orco);	
		orco = new BastonDeSaruman(orco);
		orco = new ArmaduraDeAzorAhai(orco);
		
		
		
		orco = (orco.desequipar((PersonajeEquipado) orco.dejarMejorItem()));
		
		Assert.assertEquals(2, orco.getTama�oLista());
		
		//Assert.assertEquals("Humano equipado con: 1- Bast�n de Saruman  2- Armadura de Azor Ahai ", humano.getLista());
		
		
	}
}
