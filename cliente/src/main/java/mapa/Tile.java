package mapa;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import juego.Grafico;

public class Tile {
	protected BufferedImage textura; 
	protected final int id; 
    protected boolean esObstaculo;
	  
	public static Tile[] tiles = new Tile[256];
	public static Tile pasto = new Tile(Grafico.pasto, 0, false); 
	public static Tile agua = new Tile(Grafico.agua, 1, true); 
	public static Tile vacio = new Tile(Grafico.vacio, 2, true); 
	public static Tile arena = new Tile(Grafico.arena, 3, false); 
	public static Tile lava = new Tile(Grafico.lava, 4, true); 
	   
	public static final int ANCHO = 64;
	public static final int ALTO = 96;
		
	 public Tile(BufferedImage textura, int id, boolean esObstaculo) { 
	    this.textura = textura; 
	    this.id = id;	     
	    this.esObstaculo = esObstaculo; 
	    tiles[id] = this; 
	  } 
	
	public void actualizar() {
		
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
