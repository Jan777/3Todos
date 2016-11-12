package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private Login login;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal(null);
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
	public MenuPrincipal(Login login) {
		setTitle("BloodyWars");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		this.login = login;
		this.login.setVisible(false);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnPersonaje = new JButton("Crear / Editar Personaje");
		btnPersonaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crearPersonaje();
			}
		});
		btnPersonaje.setBounds(97, 26, 221, 69);
		panel.add(btnPersonaje);
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SeleccionarMapa();
			}
		});
		btnJugar.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnJugar.setBounds(97, 124, 221, 60);
		panel.add(btnJugar);
		
		this.setVisible(true);
	}
	
	private void crearPersonaje() {
		new CrearPersonaje(login, this);
	}
}
