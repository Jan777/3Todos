package gameEntities;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import gameEntities.Juego;

public class Mapa {
	private Juego juego;
	private int ancho;
	private int alto;
	private int posicionX;
	private int posicionY;
	private int xOffset;
	private int yOffset;
	
	private float[] iso = new float[2];
	private int[][] tiles;

	private int xMinimo;
	private int xMaximo;
	private int yMinimo;
	private int yMaximo;

	public Mapa(Juego juego, int nroMapa) {
		this.juego = juego;
		cargarMundo(nroMapa);
	}

	public void actualizar() {

	}

	public void graficar(Graphics g) {
		xOffset = juego.getEstadoJuego().getPersonaje().getxOffset();
		yOffset = juego.getEstadoJuego().getPersonaje().getYOffset();

		xMinimo = (int) (juego.getCamara().getxOffset() - xOffset - 30);
		xMaximo = xMinimo + juego.getAncho() + xOffset + 30;
		yMinimo = (int) juego.getCamara().getyOffset() - yOffset + 5;
		yMaximo = yMinimo + juego.getAlto() + yOffset - 5; 

		for (int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {
				iso = dosDaIso(j, i);
				if ((iso[0] >= xMinimo && iso[0] <= xMaximo) && (iso[1] >= yMinimo && iso[1] <= yMaximo))
				{
					getTile(j, i).graficar(g, (int) (iso[0] - juego.getCamara().getxOffset()),
							(int) (iso[1] - juego.getCamara().getyOffset()));
				}
			}
		}
	}

	public Piso getTile(int x, int y) {
		Piso t = Piso.tiles[tiles[x][y]];
		if (t == null) {
			return Piso.pasto;
		}
		return t;
	}

	private void cargarMundo(int nroMapa) {
		String archivo = convertirArchivoAString(nroMapa);
		String[] tokens = archivo.split("\\s+");
		ancho = Integer.parseInt(tokens[0]);
		alto = Integer.parseInt(tokens[1]);
		posicionX = Integer.parseInt(tokens[2]);
		posicionY = Integer.parseInt(tokens[3]);

		tiles = new int[ancho][alto];

		for (int y = 0; y < alto; y++) {
			for (int x = 0; x < ancho; x++) {
				tiles[x][y] = Integer.parseInt(tokens[(x + y * ancho + 4)]);
			}
		}
	}

	private String convertirArchivoAString(int nroMapa) {
		StringBuilder builder = new StringBuilder();

		try {
			String path = obtenerPathMapa(nroMapa);
			BufferedReader br = new BufferedReader(new FileReader(path));
			String linea;

			while ((linea = br.readLine()) != null) {
				builder.append(linea + System.lineSeparator());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return builder.toString();
	}

	private String obtenerPathMapa(int nroMapa) {
		String pathMapa = "";
		
		switch(nroMapa)
		{
			case 1: pathMapa = "src/main/resources/mapa1.txt"; break;
			case 2: pathMapa = "src/main/resources/mapa2.txt"; break;
		}
		
		return pathMapa;
	}

	public static float[] isoADosD(float x, float y) {
		float[] dosD = new float[2];

		dosD[0] = (x / (Piso.ANCHO / 2) + y / (Piso.ALTO / 6)) / 2;
		dosD[1] = (y / (Piso.ALTO / 6) - (x / (Piso.ANCHO / 2))) / 2;

		return dosD;
	}

	public static float[] dosDaIso(float x, float y) {
		float[] iso = new float[2];

		iso[0] = (x - y) * (Piso.ANCHO / 2);
		iso[1] = (x + y) * (Piso.ALTO / 6);

		return iso;
	}

	public static int[] mouseATile(float x, float y) {
		int tile[] = new int[2];

		tile[0] = (int) Math.floor((y / (Piso.ALTO / 3)) + (x / Piso.ANCHO)) + 1;
		tile[1] = (int) Math.floor((-x / Piso.ANCHO) + (y / (Piso.ALTO / 3))) + 1;

		return tile;
	}
}
