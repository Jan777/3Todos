package dominio;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

import dominio.*;
import items.*;
import razas.*;


public class PersonajeTest {
	
	/*	@mauroat - 17-10-16:
	 *  El presente test verifica los constructores de las razas Elfo, Humano y Orco. 
	 */
	
	@Test
	public void personajeConRazaTest(){
		Personaje h = new Humano("Humanito 1","123");
		Personaje e = new Elfo("Elfito 2","123");
		Personaje o = new Orco("Orquito 3","123");		
		
		// Humano - Valores estandar de Ataque (10) , Defensa (10) y Magia (0)
		Assert.assertEquals("Humano",h.getRaza());
		Assert.assertEquals(100,h.getVida());
		Assert.assertEquals(0,h.getExperiencia());
		Assert.assertEquals(10,h.calcularPuntosDeAtaque());
		Assert.assertEquals(10,h.calcularPuntosDeDefensa());
		Assert.assertEquals(0,h.calcularPuntosDeMagia());
		//h.verEstado();
		
		// Elfo - Valores estandar de Ataque (5) , Defensa (5) y Magia (10)		
		Assert.assertEquals("Elfo", e.getRaza());
		Assert.assertEquals(1, e.getNivel());
		Assert.assertEquals(5,e.calcularPuntosDeAtaque());
		Assert.assertEquals(5,e.calcularPuntosDeDefensa());
		Assert.assertEquals(10,e.calcularPuntosDeMagia());
		//e.verEstado();
		
		// Orco - Valores estandar de Ataque (12) , Defensa (5) y Magia (3)
		Assert.assertEquals("Orco", o.getRaza());
		Assert.assertEquals(5,o.calcularPuntosDeDefensa());
		Assert.assertEquals(3,o.calcularPuntosDeMagia());
		Assert.assertEquals(12, o.calcularPuntosDeAtaque());
		//o.verEstado();		
		
	}
	
	/*	@mauroat - 17-10-16:
	 *  Este test verifica que un personaje aumente sus valores de ataque, defensa y magia acorde a los items que equipa.
	 *  Asimismo, también verifica que los decremente en la medida que los desequipa. 
	 */
	
	@Test
	public void personajeHumanoEquipadoYDesequipadoTest() throws FileNotFoundException{
		Personaje h = new Humano("Humanito 1","123");
		Personaje e = new Elfo("ElfoE","123");
		
		// Equipo a un humano con una bujía Hescher
		h = new BujiaHescher(h);		
		Assert.assertEquals("Humano", h.getRaza());
		Assert.assertEquals(100, h.getVida());
		Assert.assertEquals(10+1,h.calcularPuntosDeAtaque());
		Assert.assertEquals(10+1,h.calcularPuntosDeDefensa());
		Assert.assertEquals(1,h.calcularPuntosDeMagia());
		Assert.assertEquals(0,h.getExperiencia());
		//h.getLista();
		
		// Equipo al humano ahora con una armadura de Azor Ahai
		h = new ArmaduraDeAzorAhai(h);
		
		Assert.assertEquals("Humano", h.getRaza());
		Assert.assertEquals(10+1,h.calcularPuntosDeAtaque());
		Assert.assertEquals(10+1+6,h.calcularPuntosDeDefensa());
		Assert.assertEquals(1+1,h.calcularPuntosDeMagia());	
		//h.getLista();
		
		// Desequipo Armadura de Azor Ahai, mis valores deben volver al estado anterior
		h = h.dejarItem();
		Assert.assertEquals("Humano", h.getRaza());
		Assert.assertEquals(10+1,h.calcularPuntosDeAtaque());
		Assert.assertEquals(10+1,h.calcularPuntosDeDefensa());
		Assert.assertEquals(1,h.calcularPuntosDeMagia());
		
		// Equipo al humano ahora con los Guantes de poder
		h = new GuanteDePoder(h);
		Assert.assertEquals("Humano", h.getRaza());
		Assert.assertEquals(10+1+2,h.calcularPuntosDeAtaque());
		Assert.assertEquals(10+1+1,h.calcularPuntosDeDefensa());
		Assert.assertEquals(1+3,h.calcularPuntosDeMagia());
		
		//h.verEstado();
		/* @mauroat - 17-10-16:
		 * Este me funcionó pero dejó de hacerlo, tengo que ver que modifiqué mal
		 * 
		 * Debería tener 2 items: BujiaHescher(*) y GuanteDePoder
		 * Assert.assertEquals(2, h.getTamañoLista());
		 * Assert.assertEquals("items.BujiaHescher@443b7951", h.getItemMasPrioritario().toString());
		 */

	}
	
	
}
