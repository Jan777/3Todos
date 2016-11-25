package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utilities.Loggin;

public class Combate extends JFrame {

	private static final long serialVersionUID = 7687024501999321838L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Combate frame = new Combate();
					frame.setVisible(true);
				} catch (Exception e) {
					Loggin.getInstance().error("Error iniciar combate "+e.getMessage());
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Combate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JButton btnAtacar = new JButton("ATACAR!");
		btnAtacar.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		contentPane.add(btnAtacar, BorderLayout.EAST);
		
		JButton btnNewButton_1 = new JButton("Pasar turno");
		btnNewButton_1.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
		contentPane.add(btnNewButton_1, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Jugadores Equipo 1");
		panel.add(lblNewLabel, BorderLayout.WEST);
		
		JLabel lblNewLabel_1 = new JLabel("Jugadores Equipo 2");
		panel.add(lblNewLabel_1, BorderLayout.EAST);
	}
}
