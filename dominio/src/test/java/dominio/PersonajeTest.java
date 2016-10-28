package dominio;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

import ataques.*;
import castas.*;
import dominio.*;
import habilidades.*;
import items.*;
import razas.*;


public class PersonajeTest {
	
	/*	@mauroat - 17-10-16:
	 *  El presente test verifica los constructores de las razas Elfo, Humano y Orco. 
	 */
	
	@Test
	public void personajeConRazaTest(){
		Personaje h = new Humano("Humanito 1","123");
		Personaje e = new Elfo("Elfito 2","123");
		Personaje o = new Orco("Orquito 3","123");		
		
		// Humano - Valores estandar de Ataque (10) , Defensa (10) y Magia (0)
		Assert.assertEquals("Humano",h.getRaza());
		Assert.assertEquals(100,h.getVida());
		Assert.assertEquals(0,h.getExperiencia());
		Assert.assertEquals(10,h.calcularPuntosDeAtaque());
		Assert.assertEquals(10,h.calcularPuntosDeDefensa());
		Assert.assertEquals(0,h.calcularPuntosDeMagia());

		
		// Elfo - Valores estandar de Ataque (5) , Defensa (5) y Magia (10)		
		Assert.assertEquals("Elfo", e.getRaza());
		Assert.assertEquals(1, e.getNivel());
		Assert.assertEquals(5,e.calcularPuntosDeAtaque());
		Assert.assertEquals(5,e.calcularPuntosDeDefensa());
		Assert.assertEquals(10,e.calcularPuntosDeMagia());
		
		// Orco - Valores estandar de Ataque (12) , Defensa (5) y Magia (3)
		Assert.assertEquals("Orco", o.getRaza());
		Assert.assertEquals(5,o.calcularPuntosDeDefensa());
		Assert.assertEquals(3,o.calcularPuntosDeMagia());
		Assert.assertEquals(12, o.calcularPuntosDeAtaque());
		
		
	}
	
	/*	@mauroat - 17-10-16:
	 *  Este test verifica que un personaje aumente sus valores de ataque, defensa y magia acorde a los items que equipa.
	 *  Asimismo, también verifica que los decremente en la medida que los desequipa. 
	 *  
	 *  @mauroat - 19-10-16:
	 *  Se cambio el método dejarMejorItem para que devuelva el mejor item.
	 *  
	 */
	
	@Test
	public void personajeHumanoEquipadoYDesequipadoTest() {
		Personaje h = new Humano("Humanito 1","123");
		Personaje e = new Elfo("ElfoE","123");
		
		// Equipo a un humano con una bujía Hescher
		h = new BujiaHescher(h);		
		Assert.assertEquals("Humano", h.getRaza());
		Assert.assertEquals(100, h.getVida());
		Assert.assertEquals(10+1,h.calcularPuntosDeAtaque());
		Assert.assertEquals(10+1,h.calcularPuntosDeDefensa());
		Assert.assertEquals(1,h.calcularPuntosDeMagia());
		Assert.assertEquals(0,h.getExperiencia());
		//h.getLista();
		
		// Equipo al humano ahora con una armadura de Azor Ahai
		h = new ArmaduraDeAzorAhai(h);
		
		Assert.assertEquals("Humano", h.getRaza());
		Assert.assertEquals(10+1,h.calcularPuntosDeAtaque());
		Assert.assertEquals(10+1+6,h.calcularPuntosDeDefensa());
		Assert.assertEquals(1+1,h.calcularPuntosDeMagia());	
		//h.getLista();
		
		// Desequipo la Bujía Hescher, mis valores deben volver al estado anterior
		h = h.desequipar((PersonajeEquipado) h.dejarMejorItem());
		Assert.assertEquals("Humano", h.getRaza());
		Assert.assertEquals(10,h.calcularPuntosDeAtaque());
		Assert.assertEquals(10+6,h.calcularPuntosDeDefensa());
		Assert.assertEquals(1,h.calcularPuntosDeMagia());	
		Assert.assertEquals(1, h.getTamañoLista());
		

	}
	
	/*
	 * @mauroat - 26/10/16
	 * Se prueba el metodo clonar
	 * */
	@Test
	public void clonarPersonajeSimpleConAtaquesTest() throws CloneNotSupportedException{
		/*
		 * Armo un personaje con experiencia
		 * */
		Personaje p1 = new Humano("Lero","Lero");
		p1.setCasta(new Hechicero());
		p1.setNivel(3);
		p1.setExperiencia(440);
		p1.setPuedeAgregarAtaque(1);
		p1.agregarAtaque(new CuerpoACuerpo());
		
		/*
		 * Clono y comparo
		 * */
		Personaje p2 = new Humano(p1);
		/*
		 * Usuario
		 * */
		Assert.assertEquals(p1.getUsuarioPersonaje(), p2.getUsuarioPersonaje());
		/*
		 * Atributos propios de personaje
		 * */
		Assert.assertEquals(p1.getVida(), p2.getVida());
		Assert.assertEquals(p1.getExperiencia(), p2.getExperiencia());
		/*
		 * Atributos básicos
		 * */
		Assert.assertEquals(p1.calcularPuntosDeAtaque(), p2.calcularPuntosDeAtaque());
		Assert.assertEquals(p1.calcularPuntosDeDefensa(), p2.calcularPuntosDeDefensa());
		Assert.assertEquals(p1.calcularPuntosDeMagia(), p2.calcularPuntosDeMagia());
		Assert.assertEquals(p1.getPotencia(), p2.getPotencia());
		Assert.assertEquals(p1.getVelocidad(), p2.getVelocidad());
		Assert.assertEquals(p1.getDestreza(), p2.getDestreza());
		/*
		 * Casta y Raza
		 * */
		Assert.assertEquals(p1.getRaza(), p2.getRaza());
		Assert.assertEquals(p1.getClase(), p2.getClase());
		/*
		 * Mapa de ataques
		 * */		
		Assert.assertEquals(p1.getAtaques(), p2.getAtaques());
		/*
		 * Habilidades
		 * */
		Assert.assertEquals(p1.getClase().getHabilidades(), p2.getClase().getHabilidades());		
		/*
		 * Puntajes
		 * */
		Assert.assertEquals(p1.getPuedeAgregarAtaque(), p2.getPuedeAgregarAtaque());
		Assert.assertEquals(p1.getPuntos(), p2.getPuntos());
		
	}
	
	@Test
	public void clonarPersonajeConHabilidadesTest() throws CloneNotSupportedException{
		/*
		 * Armo un personaje con habilidades
		 * */
		Personaje p1 = new Humano("Lero","Lero");
		p1.setCasta(new Hechicero());
		p1.setNivel(3);
		p1.setExperiencia(440);
		p1.setPuedeAgregarAtaque(1);
		p1.agregarAtaque(new CuerpoACuerpo());
		p1.setPuntos(2);
		p1.getClase().agregarHabilidad(new Velocidad());
		p1.getClase().agregarHabilidad(new Fuerza());
		
		/*
		 * Clono y comparo
		 * */
		Personaje p2 = new Humano(p1);
		/*
		 * Usuario
		 * */
		Assert.assertEquals(p1.getUsuarioPersonaje(), p2.getUsuarioPersonaje());
		/*
		 * Atributos propios de personaje
		 * */
		Assert.assertEquals(p1.getVida(), p2.getVida());
		Assert.assertEquals(p1.getExperiencia(), p2.getExperiencia());
		/*
		 * Atributos básicos
		 * */
		Assert.assertEquals(p1.calcularPuntosDeAtaque(), p2.calcularPuntosDeAtaque());
		Assert.assertEquals(p1.calcularPuntosDeDefensa(), p2.calcularPuntosDeDefensa());
		Assert.assertEquals(p1.calcularPuntosDeMagia(), p2.calcularPuntosDeMagia());
		Assert.assertEquals(p1.getPotencia(), p2.getPotencia());
		Assert.assertEquals(p1.getVelocidad(), p2.getVelocidad());
		Assert.assertEquals(p1.getDestreza(), p2.getDestreza());
		/*
		 * Casta y Raza
		 * */
		Assert.assertEquals(p1.getRaza(), p2.getRaza());
		Assert.assertEquals(p1.getClase(), p2.getClase());
		/*
		 * Mapa de ataques
		 * */		
		Assert.assertEquals(p1.getAtaques(), p2.getAtaques());
		/*
		 * Habilidades
		 * */
		Assert.assertEquals(p1.getClase().getHabilidades(), p2.getClase().getHabilidades());		
		/*
		 * Puntajes
		 * */
		Assert.assertEquals(p1.getPuedeAgregarAtaque(), p2.getPuedeAgregarAtaque());
		Assert.assertEquals(p1.getPuntos(), p2.getPuntos());
	}
	
	
	@Test
	public void clonarPersonajeEquipadoConHabilidadesTest() throws CloneNotSupportedException{
		/*
		 * Armo un personaje con habilidades, ataques e items
		 * */
		Personaje p1 = new Humano("Lero","Lero");
		p1.setCasta(new Hechicero());
		p1.setNivel(3);
		p1.setExperiencia(440);
		p1.setPuedeAgregarAtaque(1);
		p1.agregarAtaque(new CuerpoACuerpo());
		p1.setPuntos(2);
		p1.getClase().agregarHabilidad(new Velocidad());
		p1.getClase().getHabilidades().get(6).afectar(p1);
		p1.getClase().agregarHabilidad(new Fuerza());
		p1.getClase().getHabilidades().get(3).afectar(p1);
		p1 = new PocionBruta(p1);
		
		
		/*
		 * Clono y comparo
		 * */
		Personaje p2 = p1;
		/*
		 * Usuario
		 * */
		Assert.assertEquals(p1.getUsuarioPersonaje(), p2.getUsuarioPersonaje());
		/*
		 * Atributos propios de personaje
		 * */
		Assert.assertEquals(p1.getVida(), p2.getVida());
		Assert.assertEquals(p1.getExperiencia(), p2.getExperiencia());
		/*
		 * Atributos básicos
		 * */
		Assert.assertEquals(p1.calcularPuntosDeAtaque(), p2.calcularPuntosDeAtaque());
		Assert.assertEquals(p1.calcularPuntosDeDefensa(), p2.calcularPuntosDeDefensa());
		Assert.assertEquals(p1.calcularPuntosDeMagia(), p2.calcularPuntosDeMagia());
		Assert.assertEquals(p1.getPotencia(), p2.getPotencia());
		Assert.assertEquals(p1.getVelocidad(), p2.getVelocidad());
		Assert.assertEquals(p1.getDestreza(), p2.getDestreza());
		/*
		 * Casta y Raza
		 * */
		Assert.assertEquals(p1.getRaza(), p2.getRaza());
		Assert.assertEquals(p1.getClase(), p2.getClase());
		/*
		 * Mapa de ataques
		 * */		
		Assert.assertEquals(p1.getAtaques(), p2.getAtaques());
		/*
		 * Habilidades
		 * */
		Assert.assertEquals(p1.getClase().getHabilidades(), p2.getClase().getHabilidades());		
		/*
		 * Puntajes
		 * */
		Assert.assertEquals(p1.getPuedeAgregarAtaque(), p2.getPuedeAgregarAtaque());
		Assert.assertEquals(p1.getPuntos(), p2.getPuntos());
		
		p2.setNivel(5);
	}
	
}
