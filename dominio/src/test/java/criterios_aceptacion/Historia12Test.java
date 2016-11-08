package criterios_aceptacion;

import java.io.FileNotFoundException;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import castas.*;
import dominio.*;
import razas.*;



/***
 * 
 * 12) Como Personaje, quiero cambiar las alianzas establecidas cada cierta
 * cantidad de tiempo. Motivación: Para poder traicionar a mis aliados.
 * 
 * 
 * 
 ***/

public class Historia12Test {

	/***
	 * 
	 * 1. Dado un Personaje miembro de una Alianza, cuando se exceda el tiempo
	 * minimo de pertenencia en la misma y decida abandonarla, entonces el
	 * Personaje deja de formar parte de esta.
	 * 
	 ***/

	@Test
	public void historia12Criterio01_Test() throws FileNotFoundException{

		Personaje p1 = new Humano("jose","dssjjad");
		Personaje p2 = new Elfo("dani","1242");
		Personaje p3 = new Elfo("Harry","1234");
		Alianza alianza = new Alianza("Somos re cracks");
			
		alianza.agregarAAlianza(p2);
		alianza.agregarAAlianza(p1);
		alianza.agregarAAlianza(p3);
		
		Assert.assertEquals(3, alianza.cantidadMiembrosAlianza());

		Calendar actual = Calendar.getInstance();
		actual.add(Calendar.MINUTE, -3);
		p2.setLimiteMinimoPermanenciaAlianza(actual);
		alianza.dejarAlianza(p2);

		Assert.assertEquals(3, alianza.cantidadMiembrosAlianza());

		actual.add(Calendar.MINUTE, -10);
		p3.setLimiteMinimoPermanenciaAlianza(actual);
		alianza.dejarAlianza(p3);

		Assert.assertEquals(2, alianza.cantidadMiembrosAlianza());
	}

	/***
	 * 
	 * 2. Dado un Personaje, cuando se encuentre cercano a otro e interactuen,
	 * entonces este podra combatir contra el hasta definir un ganador.
	 * @throws FileNotFoundException 
	 * @throws CloneNotSupportedException 
	 * 
	 ***/

	@Test
	public void historia12Criterio02_Test() throws FileNotFoundException, CloneNotSupportedException {
		Personaje p1 = new Humano("Humano1", "1231");
		Personaje p2 = new Orco("Humano2", "1231");
		p1.setCasta(new Guerrero());
		p2.setCasta(new Hechicero());

		/*
		 * Se preparan los equipos a pelear
		 */
		Equipo e1 = new Equipo(p1);
		Equipo e2 = new Equipo(p2);

		/*
		 * Compruebo que esten todos vivos
		 */
		Assert.assertEquals(true, e1.quedaAlgunoVivo());
		Assert.assertEquals(true, e2.quedaAlgunoVivo());

		/*
		 * Se ataca por turnos. La idea es que cuando un equipo se queda sin
		 * peleadores, se sumen los niveles de todos sus integrantes y se los
		 * multiplique por 10. Ese numero sera dividido por la cantidad de
		 * peleadores del equipo ganador y se le sumara a cada uno a su
		 * experiencia.
		 * 
		 */

		Combate c = new Combate("La Gran Batalla");
		c.combatir(e1, e2);

		c.declararGanador(e1, e2);


	}
}
