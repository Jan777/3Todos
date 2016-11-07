package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.google.gson.Gson;

import connection.Mensaje;
import entities.MensajePersonaje;

public class EditarPersonaje extends JFrame {

	private JFrame frmPersonaje;
	private Login login;
	private Mensaje msj;
	private Gson gson;
	private DataOutputStream out;
	private DataInputStream in;
	private JComboBox comboRaza;
	private JComboBox comboCasta;
	private JLabel lblRazaElegida;
	private JLabel lblCastaElegida;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new EditarPersonaje();
				} catch (Exception e) {
					// Loggin.getInstance().error("Error"+e.getMessage());
				}
			}
		});
	}

	public EditarPersonaje() {

	}

	public EditarPersonaje(Login login, Socket cliente) {

		msj = new Mensaje();

		gson = new Gson();
		this.login = login;
		login.visible(false);
		frmPersonaje = new JFrame();
		frmPersonaje.setResizable(false);
		frmPersonaje.setTitle("Seleción de Personaje");
		frmPersonaje.setBounds(100, 100, 474, 324);
		frmPersonaje.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmPersonaje.getContentPane().setLayout(null);

		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		btnAtras.setBounds(325, 259, 133, 25);
		frmPersonaje.getContentPane().add(btnAtras);

		JLabel selecionarPersonaje = new JLabel("Seleccione su personaje:");
		selecionarPersonaje.setBounds(50, 32, 153, 14);
		frmPersonaje.getContentPane().add(selecionarPersonaje);

		JLabel lblRaza = new JLabel("Raza");
		lblRaza.setBounds(50, 61, 46, 14);
		frmPersonaje.getContentPane().add(lblRaza);

		JLabel lblCasta = new JLabel("Casta:");
		lblCasta.setBounds(50, 138, 57, 14);
		frmPersonaje.getContentPane().add(lblCasta);

		comboRaza = new JComboBox();
		comboRaza.setBounds(50, 86, 116, 22);
		frmPersonaje.getContentPane().add(comboRaza);

		comboRaza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
			}
		});

		comboCasta = new JComboBox();
		comboCasta.setBounds(50, 168, 116, 22);
		frmPersonaje.getContentPane().add(comboCasta);

		comboCasta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
			}
		});

		lblRazaElegida = new JLabel("");
		lblRazaElegida.setBounds(286, 90, 110, 14);
		frmPersonaje.getContentPane().add(lblRazaElegida);

		lblCastaElegida = new JLabel("");
		lblCastaElegida.setBounds(286, 172, 110, 14);
		frmPersonaje.getContentPane().add(lblCastaElegida);
		cargarCombo();
		cargarPersonaje();
		frmPersonaje.setVisible(true);
	}
	
	private void cargarPersonaje(){
		msj.setId("obtenerPersonaje");
		msj.setMensaje(this.login.getUsername());
		this.login.enviarMensaje(msj);
		String resp =this.login.leerRespuesta();
		MensajePersonaje personaje = gson.fromJson(resp, MensajePersonaje.class);
		lblRazaElegida.setText(personaje.getRaza());
		lblCastaElegida.setText(personaje.getCasta());
	}

	private void cargarCombo() {
		comboRaza.addItem("ORCO");
		comboRaza.addItem("HUMANO");
		comboRaza.addItem("ELFO");

		comboCasta.addItem("GUERRERO");
		comboCasta.addItem("HECHICERO");
		comboCasta.addItem("CHAMAN");
	}

	private void salir() {
		login.visible(true);
		frmPersonaje.dispose();
	}
}
