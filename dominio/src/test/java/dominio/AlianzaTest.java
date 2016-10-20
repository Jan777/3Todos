package dominio;


import org.junit.Assert;
import org.junit.Test;
import razas.*;
public class AlianzaTest {

	@Test
	public void testPersonajeSinAlianzas() {
		Humano objHumano = new Humano("jose","dssjjad");
		Orco objOrco = new Orco("kali","1234");
		Assert.assertEquals(false,objHumano.inteactuarConOtroPersonaje(objOrco) );
		
	}
	@Test
	public void testFormarAlianza()
	{
		Humano objHumano = new Humano("jose","dssjjad");
		Elfo objElfo = new Elfo("dani","1242");
		Humano objHumano1 = new Humano("lucas","1244");
		Alianza objAlianza = new Alianza("lospistola");
		objAlianza.formarAlianza(objHumano1);
		objAlianza.formarAlianza(objElfo);
		objAlianza.formarAlianza(objHumano);
		Assert.assertEquals(3, objAlianza.cantidadMiembrosAlianza());
		
	}
	@Test
	public void dejarAlianza()
	{
		Humano objHumano = new Humano("jose","dssjjad");
		Elfo objElfo = new Elfo("dani","1242");
		Humano objHumano1 = new Humano("lucas","1244");
		Alianza objAlianza = new Alianza("lospistola");
		objAlianza.formarAlianza(objHumano1);
		objAlianza.formarAlianza(objElfo);
		objAlianza.formarAlianza(objHumano);
		objAlianza.dejarAlianza(objHumano1);
		Assert.assertEquals(2, objAlianza.cantidadMiembrosAlianza());
	}
	@Test
	public void eliminarAlianza()
	{
		Humano objHumano = new Humano("jose","dssjjad");
		Elfo objElfo = new Elfo("dani","1242");
		Alianza objAlianza = new Alianza("lospistola");
		objAlianza.formarAlianza(objHumano);
		objAlianza.formarAlianza(objElfo);
		objAlianza.eliminarAlianza();
		Assert.assertEquals(0,objAlianza.cantidadMiembrosAlianza());
	}
	
}
