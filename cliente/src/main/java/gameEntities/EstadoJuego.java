package gameEntities;

import gameEntities.Juego;
import gameEntities.Mapa;
import graphic.Grafico;

import java.awt.Color;
import java.awt.Graphics;


public class EstadoJuego extends Estado {
	private Personaje personaje;
	private Mapa mapa;

	public EstadoJuego(Juego juego) {
		super(juego);
		mapa = new Mapa(juego);
	    personaje = new Personaje(juego, mapa, 50, 50, 0, 0, Grafico.orco, 100);
	}

	@Override
	public void actualizar() {
		mapa.actualizar();
		personaje.actualizar();
	}

	@Override
	public void graficar(Graphics g) {
		mapa.graficar(g);
		personaje.graficar(g);
	}
	
	public Personaje getPersonaje() {
		return personaje;
	}
}
