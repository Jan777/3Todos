package dominio;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;
import dominio.*;
import razas.*;
import items.*;


public class PeleadorTest {

	
	/*	@mauroat - 18-10-16:
	 *  Este test verifica que cuando un personaje ataca agote su energía, disminuya la vida del atacado y 
	 *  en caso de matarlo sume experiencia.
	 *  El personaje podrá atacar siempre cuando su energía sea >= a sus puntos de ataque y el atacado esté vivo. 
	 * */
	
	@Test
	public void peleadorTest() throws FileNotFoundException{
		Personaje orco = new Orco("Orcazo","123");
		Personaje elfo = new Elfo("Elfazo","123");
		
		
		/* Con el Orco ataca 15 veces al humano. Debería dejar de atacar cuando el Orco se quede sin energia */		
		for (int i = 0; i<15;i++)
			orco.atacar(elfo);
		
		
		Assert.assertEquals(51, elfo.getVida());		
		//orco.verEstado();
		
		/* Ahora energizo al Orco y termino de rematar al humano. Deberia aumentar la experiencia del Orco*/
		orco.serEnergizado();
		for (int i = 0; i<6;i++){
			orco.atacar(elfo);
		}
			
		orco.serEnergizado();
		
		Assert.assertEquals(104, orco.getExperiencia());
		Assert.assertEquals(9, elfo.getVida());
		//orco.verEstado();
	}
	
	/*	@mauroat - 18-10-16:
	 *  Este test verifica que cuando un personaje mate varios enemigos aumente experiencia y suba de nivel. 
	 *  La experiencia necesaria para pasar al nivel 2 es 220.
	 * */
	
	@Test
	public void peleadorTestSubirNivel() throws FileNotFoundException{
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
		Assert.assertEquals(2, orco.getNivel());
		//orco.verEstado();
	}
	
	/*	@mauroat - 18-10-16:
	 *  Este test verifica que un personaje aumente la lista de items a medida que se va equipando 
	 */
	
	//@Test
	public void peleadorTestListaDeItems() throws FileNotFoundException{
	
		/* @mauroat - 18/10/16
		 * ERROR: Los items se equipan, sin embargo la lista siempre es reemplazada por el último item y no son agregados.
		 * */
				
		// Sin items
		Personaje humano = new Humano("Indio Solari","123");
		Assert.assertEquals(0, humano.getTamañoLista());
		// 1 item
		humano = new BujiaHescher(humano);
		Assert.assertEquals(1, humano.getTamañoLista());
		// 2 items
		humano = new ArmaduraDeAzorAhai(humano);
		Assert.assertEquals(2, humano.getTamañoLista());
		humano.getLista();
			
		
	}
}
