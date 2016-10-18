package razas;

import org.junit.Assert;
import org.junit.Test;

import dominio.*;


public class ElfoTest {

	/* @mauroat - 18-10-16 
	 * */
	@Test
	public void constructorElfo(){
		Personaje e = new Elfo("Agente Smith","matrix");
		
		Assert.assertEquals("Agente Smith", e.getUsername());
		Assert.assertEquals(100, e.getEnergia());
		Assert.assertEquals(100, e.getVida());
		Assert.assertEquals(1, e.getNivel());
		Assert.assertEquals(0, e.getExperiencia());
		Assert.assertEquals(5, e.calcularPuntosDeAtaque());
		Assert.assertEquals(5, e.calcularPuntosDeDefensa());
		Assert.assertEquals(10, e.calcularPuntosDeMagia());
		Assert.assertEquals("Elfo", e.getRaza());
			
	}
	
	
	
}