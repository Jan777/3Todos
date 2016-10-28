package ataques;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

import dominio.*;
import razas.*;

public class RegeneracionTest {
	/* @mauroat - 18/10/16
	 * Se la construcción y el daño un ataque causado.
	 * En esta caso es -7.
	 * */
	@Test
	public void atacarRegeneracion() {
		Personaje e1 = new Elfo("Ditto","hds");
		Personaje e2 = new Elfo("Pikachu","fere");
		// Lescano agrega el ataque cuerpo a cuerpo y verifico que el daño que causa sea 9
		e1.agregarAtaque(new Regeneracion());
		Assert.assertEquals(-7, e1.getAtaque("Regeneración").aplicarAtaque());
		
		// Lescano ataca a Collins con gancho de goro, debe disminuir su energia y disminuir la vida del atacado
		e1.atacar(e2,e1.getAtaque("Regeneración"));
		Assert.assertEquals(100-5-(-7), e1.getEnergia());
		Assert.assertEquals(100-5-(-7)+5, e2.getVida());
	}
}
