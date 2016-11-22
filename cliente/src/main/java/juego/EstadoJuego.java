package juego;

import java.awt.Graphics;
import java.io.IOException;
import java.util.Iterator;

import com.google.gson.Gson;

import cliente.MensajePersonaje;
import entidades.Personaje;
import mapa.Mapa;

public class EstadoJuego extends Estado {

	private Personaje personaje;
	private Mapa mapa;
	private final Gson gson = new Gson();

	public EstadoJuego(Juego juego) {
		super(juego);
		mapa = new Mapa(juego); 
	    personaje = new Personaje(juego, mapa, 50, 50, 0, 0, 100); 
	 
		try {
			juego.getPersonaje().setComando("conectado");
			juego.getCliente().getSalida().writeObject(gson.toJson(juego.getPersonaje()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actualizar() {
		mapa.actualizar();
		personaje.actualizar();
	}

	@Override
	public void graficar(Graphics g) {
		g.drawImage(Grafico.fondo, 0, 0, juego.getAncho(), juego.getAlto(), null); 
		mapa.graficar(g);
		personaje.graficar(g);

		Iterator it = juego.getEscuchaMensajes().getPersonajes().keySet().iterator();
		int key;
		MensajePersonaje p;
		while (it.hasNext()) {
			key = (int) it.next();
			p = juego.getEscuchaMensajes().getPersonajes().get(key);
			if (p.getIdPersonaje() != juego.getPersonaje().getIdPersonaje()) {
				g.drawImage(personaje.obtenerAnimacion(juego.getRaza()).get(p.getDireccion())[p.getFrame()], (int) (p.getPosX() - juego.getCamara().getxOffset() ), (int) (p.getPosY() - juego.getCamara().getyOffset()), 64, 64, null); 
		      } 
		}
		
		g.drawImage(Grafico.marco, 0, 0, juego.getAncho(), juego.getAlto(), null);
	}

	public Personaje getPersonaje() {
		return personaje;
	}
}