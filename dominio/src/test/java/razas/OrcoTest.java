package razas;

import org.junit.Assert;
import org.junit.Test;

import dominio.*;

public class OrcoTest {

	/* @mauroat - 18-10-16 
	 * */
	@Test
	public void constructorOrco(){
		Personaje o = new Orco("Marciano Aguirre","Lanus");
		
		Assert.assertEquals("Marciano Aguirre", o.toString());
		Assert.assertEquals(100, o.getEnergia());
		Assert.assertEquals(100, o.getVida());
		Assert.assertEquals(1, o.getNivel());
		Assert.assertEquals(0, o.getExperiencia());
		Assert.assertEquals(12, o.calcularPuntosDeAtaque());
		Assert.assertEquals(5, o.calcularPuntosDeDefensa());
		Assert.assertEquals(3, o.calcularPuntosDeMagia());
		Assert.assertEquals("Orco", o.getRaza());
			
	}
	
}
