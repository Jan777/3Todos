package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class PantallaDeJuego extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaDeJuego frame = new PantallaDeJuego();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaDeJuego() {
		setTitle("CastWars");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel map = new JPanel();
		contentPane.add(map, BorderLayout.CENTER);
		map.setLayout(null);
		
		JLabel lblAcIraEl = new JLabel("Ac\u00E1 ir\u00EDa el mapa y las animaciones. A pantalla completa? Sin chat?");
		lblAcIraEl.setBounds(46, 57, 341, 134);
		map.add(lblAcIraEl);
		
		this.setVisible(true);
	}

}
