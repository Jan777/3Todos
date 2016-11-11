package gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class PantallaJuego {

	private JFrame pantalla;
	private Canvas canvas; 

	public PantallaJuego(final String tituloJuego, final int ancho, final int alto) {
		pantalla = new JFrame(tituloJuego);
		pantalla.setResizable(false);
		pantalla.setSize(ancho,alto);
		pantalla.setLocationRelativeTo(null);
		pantalla.getContentPane().setBackground(Color.black);
		pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pantalla.setVisible(true);
		
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
