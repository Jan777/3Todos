package dominio;


import org.junit.Assert;
import org.junit.Test;
import razas.*;
public class AlianzaTest {

	@Test
	public void testPersonajeSinAlianzas() {
		Humano objHumano = new Humano("jose","dssjjad");
		Orco objOrco = new Orco("kali","1234");
		
		//Assert.assertEquals(false,objHumano.interactuarConOtroPersonaje(objOrco));
		
	}
	@Test
	public void testFormarAlianza()
	{
		Personaje p1 = new Humano("jose","dssjjad");
		Personaje p2 = new Elfo("dani","1242");
		Personaje p3 = new Humano("lucas","1244");
		
		p1.formarAlianzaCon(p2);
		p2.formarAlianzaCon(p3);
		
		Assert.assertEquals(3, p1.getAlianzaActual().cantidadMiembrosAlianza());
		Assert.assertEquals(3, p2.getAlianzaActual().cantidadMiembrosAlianza());
		Assert.assertEquals(3, p3.getAlianzaActual().cantidadMiembrosAlianza());
		
	}
	@Test
	public void dejarAlianza()
	{
		Personaje p1 = new Humano("jose","dssjjad");
		Personaje p2 = new Elfo("dani","1242");
		Personaje p3 = new Humano("lucas","1244");
		
		p1.formarAlianzaCon(p2);
		p2.formarAlianzaCon(p3);
		
		Assert.assertEquals(3, p1.getAlianzaActual().cantidadMiembrosAlianza());
		Assert.assertEquals(3, p2.getAlianzaActual().cantidadMiembrosAlianza());
		Assert.assertEquals(3, p3.getAlianzaActual().cantidadMiembrosAlianza());
		
		p1.dejarAlianzaActual();
		
		Assert.assertNotEquals(2, p1.getAlianzaActual());
		Assert.assertEquals(2, p2.getAlianzaActual().cantidadMiembrosAlianza());
		Assert.assertEquals(2, p3.getAlianzaActual().cantidadMiembrosAlianza());
		
	
	}
	
	@Test
	public void eliminarAlianza()
	{
		
		
		Personaje p1 = new Humano("jose","dssjjad");
		Personaje p2 = new Elfo("dani","1242");
		
		p1.formarAlianzaCon(p2);
		
		Assert.assertEquals(2, p1.getAlianzaActual().cantidadMiembrosAlianza());
		Assert.assertEquals(2, p2.getAlianzaActual().cantidadMiembrosAlianza());
		
		p1.getAlianzaActual().eliminarAlianza();
		
		Assert.assertEquals (null, p1.getAlianzaActual());
		Assert.assertEquals (null, p2.getAlianzaActual());
	}
	
}
