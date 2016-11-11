package gameEntities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import graphic.Grafico;

public class Piso {
	protected BufferedImage textura;
	protected final int id;
	
	public static Piso[] tiles = new Piso[256];
	public static Piso pasto = new Piso(Grafico.pasto, 0);
	public static Piso agua = new Piso(Grafico.agua, 1);
	
	public static final int ANCHO = 64;
	public static final int ALTO = 32;
		
	public Piso(BufferedImage textura, int id) {
		this.textura = textura;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void actualizar() {
	    // nos falto implementar
	}
	
	public boolean esSolido()
	{
		if(this.id == 0)
			return false;
		return true;
	}
	
	public void graficar(Graphics g, int x, int y) {
		g.drawImage(textura, x, y, ANCHO, ALTO, null);
	}
	
	public int getId() {
		return id;
	}
}
