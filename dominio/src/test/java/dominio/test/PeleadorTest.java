package dominio.test;

import java.io.FileNotFoundException;

import org.junit.Test;
import dominio.*;
import razas.*;
import items.*;

public class PeleadorTest {

	@Test
	
	public void peleadorTest() throws FileNotFoundException{
		Personaje orco = new Orco("Orcazo","123");
		Personaje humano = new Humano("Humanazo","123");
		Personaje humano2 = new Humano("Humanazo2","123");

		// 
		
		orco = new EspadaDeJuanNieve(orco);
		orco.atacar(humano);
		orco.atacar(humano);
		orco.atacar(humano);
		orco.atacar(humano);
		orco.atacar(humano);
		orco.atacar(humano);
		orco.atacar(humano);
		orco.atacar(humano);
		orco.verEstado();

	}
}
