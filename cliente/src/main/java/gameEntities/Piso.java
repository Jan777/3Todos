package gameEntities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import graphic.Grafico;

public class Piso {
	protected BufferedImage textura;
	protected final int id;
	protected boolean esObstaculo;
	
	public static Piso[] tiles = new Piso[256];
	public static Piso pasto = new Piso(Grafico.pasto, 0, false);
	public static Piso agua = new Piso(Grafico.agua, 1, true);
	public static Piso vacio = new Piso(Grafico.vacio, 2, true);
	public static Piso arena = new Piso(Grafico.arena, 3, false);
	public static Piso lava = new Piso(Grafico.lava, 4, true);
	
	public static final int ANCHO = 64;
	public static final int ALTO = 96;
		
	public Piso(BufferedImage textura, int id, boolean esObstaculo) {
		this.textura = textura;
		this.id = id;
		this.esObstaculo = esObstaculo;
		tiles[id] = this;
	}
	
	public void actualizar() {
	    // nos falto implementar
	}
	
	public boolean esObstaculo()
	{
		return esObstaculo;
	}
	
	public void graficar(Graphics g, int x, int y) {
		g.drawImage(textura, x, y, ANCHO, ALTO, null);
	}
	
	public int getId() {
		return id;
	}
}
