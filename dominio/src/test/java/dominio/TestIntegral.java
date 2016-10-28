package dominio;

import java.io.FileNotFoundException;

import org.junit.Test;


public class TestIntegral {
	/*	@mauroat - 18-10-16:
	 *  Se crea este test para probar los tests de forma integral.
	 */
	
	@Test
	public void testCompleto() {
		// Usuario Test
		UsuarioTest ut = new UsuarioTest();
		ut.crearUsuariotest();
		ut.hashPasswordTest();
		
		// Personaje Test
		PersonajeTest pt = new PersonajeTest();
		pt.personajeConRazaTest();
		pt.personajeHumanoEquipadoYDesequipadoTest();
		
		// Peleador Test
		PeleadorTest ppt = new PeleadorTest();
		ppt.peleadorTest();
		ppt.peleadorTestSubirNivel();
		//ppt.peleadorTestListaDeItems();
		
		// Ataques Test
		AtaquesTest at = new AtaquesTest(); 
		at.añadirYQuitarAtaques();
		at.atacarConAtaques();
		
	}
}
