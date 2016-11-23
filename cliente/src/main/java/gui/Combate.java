package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class Combate extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Combate frame = new Combate();
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
