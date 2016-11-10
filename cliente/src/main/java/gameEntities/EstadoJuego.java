package gameEntities;

import gameEntities.Juego;
import gameEntities.Mapa;
import graphic.Grafico;

import java.awt.Color;
import java.awt.Graphics;

import entities.Entidad;


public class EstadoJuego extends Estado {

	private Entidad personaje;
	private Mapa mapa;

	public EstadoJuego(Juego juego) {
		super(juego);
		mapa = new Mapa(juego, "recursos/mapa1.txt");
	    personaje = new Entidad(juego, mapa, 64, 64, 0, 0, Grafico.pokemon, 150);
	}

	@Override
	public void actualizar() {
		mapa.actualizar();
		personaje.actualizar();
	}

	@Override
	public void graficar(Graphics g) {
		g.drawImage(Grafico.fondoDelJuego, 0, 0, juego.getAncho(), juego.getAlto(), null);
		mapa.graficar(g);
		personaje.graficar(g);
		}
	
	public Entidad getPersonaje() {
		return personaje;
	}
}
