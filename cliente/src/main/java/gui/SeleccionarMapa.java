package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gameEntities.Juego;

import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class SeleccionarMapa extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleccionarMapa frame = new SeleccionarMapa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public SeleccionarMapa(){}

	/**
	 * Create the frame.
	 */
	public SeleccionarMapa(MenuPrincipal menu) {
		setTitle("Jugar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		menu.setVisible(false);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				menu.setVisible(true);
			}
		});
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnLlanuraDa = new JButton("");
		btnLlanuraDa.setIcon(new ImageIcon("src/main/resources/imagenes/llanura.jpg"));
		btnLlanuraDa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirJuego("llanura");
			}
		});
		btnLlanuraDa.setBounds(125, 50, 250, 100);
		panel.add(btnLlanuraDa);
		
		JButton btnDesiertoNoche = new JButton("");
		btnDesiertoNoche.setIcon(new ImageIcon("src/main/resources/imagenes/desierto.jpg"));
		btnDesiertoNoche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirJuego("desierto");
			}
		});
		btnDesiertoNoche.setBounds(125, 175, 250, 100);
		panel.add(btnDesiertoNoche);
		
		JLabel lblSeleccionaElMapa = new JLabel("Selecciona el mapa");
		lblSeleccionaElMapa.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblSeleccionaElMapa.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionaElMapa.setBounds(175, 11, 150, 25);
		panel.add(lblSeleccionaElMapa);
		
		this.setVisible(true);
	}
	
	private void abrirJuego(String tipoMapa){
		Juego juego = new Juego("BloodyWars", 1000, 650, tipoMapa, this);
		juego.start();
	}
}
