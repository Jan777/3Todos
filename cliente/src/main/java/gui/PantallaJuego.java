package gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class PantallaJuego {

	private JFrame pantalla;
	private Canvas canvas; 

	public PantallaJuego(final String tituloJuego, final int ancho, final int alto, String tipoMapa, SeleccionarMapa frame) {
		pantalla = new JFrame(tituloJuego);
		pantalla.setResizable(false);
		pantalla.setSize(ancho,alto);
		pantalla.setLocationRelativeTo(null);
		Color lightBlue= new Color(102,178,255,0);
		pantalla.getContentPane().setBackground(lightBlue);
		pantalla.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pantalla.setVisible(true);
		frame.setVisible(false);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(ancho,alto));
		canvas.setFocusable(false);
		canvas.setMinimumSize(new Dimension(ancho,alto));
		canvas.setMaximumSize(new Dimension(ancho,alto));
        
		pantalla.add(canvas);
		pantalla.pack();
	}

	public Canvas getCanvas() {
		return canvas;
	}
	
	public JFrame getFrame() {
		return pantalla;
	}

}
