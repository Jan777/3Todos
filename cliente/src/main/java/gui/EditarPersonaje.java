package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.Semaphore;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

//import connection.Mensaje;
//import entities.MensajePersonaje;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import castas.*;
import cliente.*;
import cliente.MensajePersonaje;
import cliente.Usuario;
import dominio.*;
import razas.*;
import utilities.Loggin;

public class EditarPersonaje extends JFrame {

	private JPanel contentPane;
	private MenuPrincipal menu;
	private JComboBox<String> comboRaza;
	private JComboBox<String> comboCasta;
	private JLabel lblRazaElegida;
	private JLabel lblCastaElegida;
	private boolean nuevoPersonaje = false;
	private Personaje paux = null;
	private MenuPrincipal mp;

	// Crear personaje desde 0
	public EditarPersonaje(final Personaje p1, final Personaje p2, final Personaje p3, final Usuario usuario, final Semaphore semaforo, MenuPrincipal menuAnt) {
		setTitle("Seleccion de Personaje");
		mp = menuAnt;
		setResizable(false);
		//setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				mp.setVisible(true);

			}
		});
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblSeleccioneSuPersonaje = new JLabel("Seleccione su personaje:");
		lblSeleccioneSuPersonaje.setBounds(50, 32, 153, 14);
		panel.add(lblSeleccioneSuPersonaje);

		JLabel lblRaza = new JLabel("Raza");
		lblRaza.setBounds(50, 61, 46, 14);
		panel.add(lblRaza);

		JLabel lblCasta = new JLabel("Casta: ");
		lblCasta.setBounds(50, 190, 57, 14);
		panel.add(lblCasta);

		lblRazaElegida = new JLabel("");
		lblRazaElegida.setBounds(286, 61, 90, 90);
		panel.add(lblRazaElegida);

		lblCastaElegida = new JLabel("");
		lblCastaElegida.setBounds(286, 190, 90, 90);
		panel.add(lblCastaElegida);

		comboRaza = new JComboBox<String>();
		comboRaza.setBounds(50, 86, 116, 22);
		panel.add(comboRaza);

		comboRaza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cargarImagenesPersonaje(comboRaza.getSelectedItem().toString());
			}
		});

		comboCasta = new JComboBox<String>();
		comboCasta.setBounds(50, 216, 116, 22);
		panel.add(comboCasta);
		cargarCombo();

		JButton button = new JButton("Guardar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				/*
				 * CREO UN PERSONAJE CON LA RAZA QUE CORRESPONDA
				 * */
				if(comboRaza.getSelectedItem().toString().contentEquals("HUMANO") ){
					p1.setNombre(usuario.getNombre_usuario());
					p1.setIdPersonaje(usuario.getIdPj());
					
					if(comboCasta.getSelectedItem().toString().contentEquals("GUERRERO")){
						p1.setClase(new Guerrero());
					} else if (comboCasta.getSelectedItem().toString().contentEquals("HECHICERO")) {
						p1.setClase(new Hechicero());
					} else if (comboCasta.getSelectedItem().toString().contentEquals("CHAMAN")) {
						p1.setClase(new Chaman());
					}
				} else if (comboRaza.getSelectedItem().toString().contentEquals("ORCO")){
					p2.setNombre(usuario.getNombre_usuario());
					p2.setIdPersonaje(usuario.getIdPj());
					
					if(comboCasta.getSelectedItem().toString().contentEquals("GUERRERO")){
						p2.setClase(new Guerrero());
					} else if (comboCasta.getSelectedItem().toString().contentEquals("HECHICERO")) {
						p2.setClase(new Hechicero());
					} else if (comboCasta.getSelectedItem().toString().contentEquals("CHAMAN")) {
						p2.setClase(new Chaman());
					}
				} else if (comboRaza.getSelectedItem().toString().contentEquals("ELFO")){
					p3.setNombre(usuario.getNombre_usuario());
					p3.setIdPersonaje(usuario.getIdPj());
					
					if(comboCasta.getSelectedItem().toString().contentEquals("GUERRERO")){
						p3.setClase(new Guerrero());
					} else if (comboCasta.getSelectedItem().toString().contentEquals("HECHICERO")) {
						p3.setClase(new Hechicero());
					} else if (comboCasta.getSelectedItem().toString().contentEquals("CHAMAN")) {
						p3.setClase(new Chaman());
					}
				}
												
				semaforo.release();
				dispose();
//				guardarPersonaje();
			}
		});
		button.setBounds(213, 325, 107, 25);
		panel.add(button);
		
		this.setVisible(true);
	}
	
	/**
	 * Create the frame.
	 */
	
	// Editar personaje ya creado
	public EditarPersonaje(final Mensaje p, final Semaphore semaforo, final MensajePersonaje pp, MenuPrincipal menuAnt) {
		setTitle("Seleccion de Personaje");
		setResizable(false);
		mp = menuAnt;
		//setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				mp.setVisible(true);
			}
		});
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblSeleccioneSuPersonaje = new JLabel("Seleccione su personaje:");
		lblSeleccioneSuPersonaje.setBounds(50, 32, 153, 14);
		panel.add(lblSeleccioneSuPersonaje);

		JLabel lblRaza = new JLabel("Raza");
		lblRaza.setBounds(50, 61, 46, 14);
		panel.add(lblRaza);

		JLabel lblCasta = new JLabel("Casta: ");
		lblCasta.setBounds(50, 190, 57, 14);
		panel.add(lblCasta);

		lblRazaElegida = new JLabel("");
		lblRazaElegida.setBounds(286, 61, 90, 90);
		panel.add(lblRazaElegida);

		lblCastaElegida = new JLabel("");
		lblCastaElegida.setBounds(286, 190, 90, 90);
		panel.add(lblCastaElegida);

		comboRaza = new JComboBox<String>();
		comboRaza.setBounds(50, 86, 116, 22);
		comboRaza.setSelectedItem(pp.getRaza());
		panel.add(comboRaza);

		comboRaza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cargarImagenesPersonaje(comboRaza.getSelectedItem().toString());
			}
		});

		comboCasta = new JComboBox<String>();
		comboCasta.setBounds(50, 216, 116, 22);
		comboCasta.setSelectedItem(pp.getCasta());
		panel.add(comboCasta);
		cargarCombo();

		JButton button = new JButton("Guardar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				guardarPersonaje();
			}
		});
		button.setBounds(213, 325, 107, 25);
		panel.add(button);
		
//		cargarDatos(p,pp);
		this.setVisible(true);
	}

/*
	private void cargarDatos(Paquete p, PaquetePersonaje pp) {
//		msj.setId("obtenerPersonaje");
//		msj.setMensaje(this.login.getUsername());
//		this.login.enviarMensaje(msj);
//		String resp = this.login.leerRespuesta();
//		personaje = gson.fromJson(resp, MensajePersonaje.class);
		Personaje personaje = null;
		
		cargarImagenesPersonaje(pp.getRaza());
		if (pp.getCasta() != null && personaje.getRaza() != null) {
			nuevoPersonaje = false;
			comboCasta.setSelectedItem(pp.getCasta());
			comboRaza.setSelectedItem(pp.getRaza());
		}else{
			nuevoPersonaje = true;
		}
	}
*/
	private void cargarImagenesPersonaje(String raza) {
		if (raza != null && !raza.isEmpty()) {
			if (raza.contentEquals("HUMANO")) {
				lblRazaElegida.setIcon(new ImageIcon("src/main/resources/imagenes/personajes/humano_short.png"));
			} else if (raza.contentEquals("ELFO")) {
				lblRazaElegida.setIcon(new ImageIcon("src/main/resources/imagenes/personajes/elfo_short.png"));
			} else if (raza.contentEquals("ORCO")) {
				lblRazaElegida.setIcon(new ImageIcon("src/main/resources/imagenes/personajes/orco_short.png"));
			}
		}
	}
/*
	private void guardarPersonaje() {
		int razaItem = comboRaza.getSelectedIndex();
		int castaItem = comboCasta.getSelectedIndex();
		String resp = "";
		personaje = new MensajePersonaje(personaje.getIdUsuario(), login.getUsername(),
				comboRaza.getSelectedItem().toString(), comboCasta.getSelectedItem().toString());
		if (comboCompleto(razaItem, castaItem)) {
			if (nuevoPersonaje) {
				msj.setId("guardarPersonaje");
			} else {
				msj.setId("actualizarPersonaje");
			}
			msj.setMensaje(gson.toJson(personaje));
			this.login.enviarMensaje(msj);
			resp = this.login.leerRespuesta();
			if (resp.equals("OK")) {
				JOptionPane.showMessageDialog(null, "Personaje guardado correctamente", "Personaje Guardado",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Error al intentar guadar personaje", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
*/
	private boolean comboCompleto(int razaItem, int castaItem) {
		if (razaItem == 0) {
			JOptionPane.showMessageDialog(null, "Seleccione una Raza", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			if (castaItem == 0) {
				JOptionPane.showMessageDialog(null, "Seleccione una Casta", "Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			return true;
		}
	}

	private void cargarCombo() {
		comboRaza.addItem("");
		comboRaza.addItem("ORCO");
		comboRaza.addItem("HUMANO");
		comboRaza.addItem("ELFO");
		comboCasta.addItem("");
		comboCasta.addItem("GUERRERO");
		comboCasta.addItem("HECHICERO");
		comboCasta.addItem("CHAMAN");
//		cargarPersonaje();
	}

	private void salir() {
		menu.setVisible(true);
		dispose();
	}
}
