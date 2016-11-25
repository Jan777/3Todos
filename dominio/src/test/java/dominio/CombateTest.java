package dominio;

import static org.junit.Assert.*;

import org.junit.Test;

import razas.Orco;

public class CombateTest {

	@Test
	public void combateTest() {
		Equipo e1= new Equipo(new Orco("orco1"));
		Equipo e2= new Equipo(new Orco("orco2"));
		Combate c= new Combate();
		Combate c1= new Combate("c1");
		c.declararGanador(e1, e2);
	}

}
