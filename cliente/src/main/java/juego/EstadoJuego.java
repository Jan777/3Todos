package juego;

import java.awt.Graphics;
import java.io.IOException;
import java.util.Iterator;

import com.google.gson.Gson;

import cliente.MensajePersonaje;
import entidades.PersonajeGrafico;
import mapa.Mapa;
import utilities.Loggin;

public class EstadoJuego extends Estado {

	private PersonajeGrafico personaje;
	private Mapa mapa;
	private final Gson gson = new Gson();

	public EstadoJuego(Juego juego) {
		super(juego);
		mapa = new Mapa(juego); 
	    personaje = new PersonajeGrafico(juego, mapa, 50, 50, 0, 0, 100); 
	 
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

	public void graficar(Graphics g) {
		g.drawImage(Grafico.fondo, 0, 0, juego.getAncho(), juego.getAlto(), null); 
		mapa.graficar(g);
		personaje.graficar(g);

		Iterator it = juego.getEscuchaMensajes().getPersonajes().keySet().iterator();
		int key;
		MensajePersonaje personajeActual;
		PersonajeGrafico personajeAux;
		while (it.hasNext()) {
			key = (int) it.next();
			personajeActual = juego.getEscuchaMensajes().getPersonajes().get(key);
			for (Integer colisiones : juego.getEscuchaMensajes().getPersonajes().keySet()) {
				  if(colisiones.intValue() != key)
			       {
					  MensajePersonaje aux = juego.getEscuchaMensajes().getPersonajes().get(colisiones);
					  //no le cambien el orden a la llamada a la funcion sino no detecta colisiones
					  if(evaluarColision(aux,personajeActual))
					  {
						  Loggin.getInstance().error("colision" + aux.getIdPersonaje()+ " "+ personajeActual.getIdPersonaje());
					  }
						
			       }
			    }
			if (personajeActual.getIdPersonaje() != juego.getPersonaje().getIdPersonaje()) {
				g.drawImage(personaje.obtenerAnimacion(juego.getRaza()).get(personajeActual.getDireccion())[personajeActual.getFrame()], (int) (personajeActual.getPosX() - juego.getCamara().getxOffset() ), (int) (personajeActual.getPosY() - juego.getCamara().getyOffset()), 64, 64, null); 
		      } 
		}
		
		g.drawImage(Grafico.marco, 0, 0, juego.getAncho(), juego.getAlto(), null);
	}

	public boolean evaluarColision(MensajePersonaje p, MensajePersonaje aux)
	{
		if(aux.getIdPersonaje()!=p.getIdPersonaje() && aux.getPosX() + aux.getAncho() >= p.getPosX() && aux.getPosX() < p.getPosX() + p.getAncho())
		{
			//Colisiones verticales
			if(aux.getPosY() < p.getPosY() + p.getAlto())
				return true;
		}
		//Colisión de a con b
		if(aux.getIdPersonaje()!=p.getIdPersonaje() &&aux.getPosX() <= p.getPosX() && aux.getPosX() + aux.getAncho() >= p.getPosX() + p.getAncho())
		{
			if(aux.getPosY() <= p.getPosY() && aux.getPosY() + aux.getAlto() >= p.getPosY() + p.getAlto())
				return true;
		}
		//Colisión b con a
		if(aux.getIdPersonaje()!=p.getIdPersonaje() && p.getPosX() <= aux.getPosX() && p.getPosX() + p.getAncho() >= aux.getPosX() + aux.getAncho())
		{
			if(p.getPosY() <= aux.getPosY() && p.getPosY() + p.getAlto() >= aux.getPosY() + aux.getAlto())
				return true;
		}
		
		return false;
	}
	
	
	public PersonajeGrafico getPersonaje() {
		return personaje;
	}
}