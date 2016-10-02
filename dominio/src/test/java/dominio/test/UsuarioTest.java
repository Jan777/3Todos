package dominio.test;

import org.junit.Test;

import dominio.Usuario;
import junit.framework.Assert;

public class UsuarioTest {

	@Test
	public void crearUsuariotest() {
		Usuario usu = new Usuario("Pepe","1234");
		Assert.assertNotNull(usu);
	}

	@Test
	public void hashPaswordTest(){
		Usuario usu = new Usuario("Gustavo","12345");
		String pas = "827ccb0eea8a706c4c34a16891f84e7b";
		Assert.assertEquals(pas, usu.getPassword());
	}

}
