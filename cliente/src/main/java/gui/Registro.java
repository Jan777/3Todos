package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import connection.Mensaje;
import entities.Usuario;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JFrame frmRegitro;
	private JTextField txtUsuario;
	private JPasswordField password1;
	private JPasswordField password2;
	private Login login;
	private JLabel lblUsuario;
	private JLabel lblContrasena;
	private JLabel lblRepetirContrasena;
	private JButton btnNewRegistrar;
	private JButton btnCancelar;
	private Mensaje msj;
	private Gson gson;
	private DataOutputStream out;
	private DataInputStream in;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Registro() {

	}

	public Registro(Login login, Socket cliente) throws IOException {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		msj = new Mensaje();
		gson = new Gson();
		this.login = login;
		this.in = new DataInputStream(login.getCliente().getInputStream());
		this.out = new DataOutputStream(login.getCliente().getOutputStream());

		login.visible(false);
		frmRegitro = new JFrame();
		frmRegitro.setResizable(false);
		frmRegitro.setTitle("Registro");
		frmRegitro.setBounds(100, 100, 474, 324);
		frmRegitro.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmRegitro.getContentPane().setLayout(null);

		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(21, 32, 122, 29);
		frmRegitro.getContentPane().add(lblUsuario);

		lblContrasena = new JLabel("Contrase�a:");
		lblContrasena.setBounds(22, 72, 122, 29);
		frmRegitro.getContentPane().add(lblContrasena);

		lblRepetirContrasena = new JLabel("Repetir Contrase�a:");
		lblRepetirContrasena.setBounds(22, 108, 165, 29);
		frmRegitro.getContentPane().add(lblRepetirContrasena);

		txtUsuario = new JTextField();
		frmRegitro.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);

		password1 = new JPasswordField();
		password1.setBounds(220, 76, 215, 20);
		frmRegitro.getContentPane().add(password1);

		password2 = new JPasswordField();
		password2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent key) {
				if (key.getKeyChar() == key.VK_ENTER)
					registrar();
			}
		});
		password2.setBounds(220, 112, 216, 20);
		frmRegitro.getContentPane().add(password2);

		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(219, 36, 216, 20);
		frmRegitro.getContentPane().add(txtUsuario);

		btnNewRegistrar = new JButton("Registrar");
		btnNewRegistrar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent key) {
				if (key.getKeyChar() == key.VK_ENTER)
					registrar();
			}
		});
		btnNewRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});

		btnNewRegistrar.setBounds(159, 174, 133, 29);
		frmRegitro.getContentPane().add(btnNewRegistrar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent key) {
				if (key.getKeyChar() == key.VK_ENTER)
					cancelar();
			}
		});
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		btnCancelar.setBounds(302, 174, 133, 29);
		frmRegitro.getContentPane().add(btnCancelar);

		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}

		});
		btnAtras.setBounds(302, 214, 133, 25);
		frmRegitro.getContentPane().add(btnAtras);

		frmRegitro.setVisible(true);
	}

	private boolean nombreUsuarioValido(String nombre) {
		msj.setId("nombreUsuarioValido");
		msj.setMensaje(nombre);
		enviarMensaje(msj);
		String resp = leerRespuesta();
		if (resp.equals("Ok")) {
			return true;
		}
		return false;
	}

	protected void registrar() {
		if (!nombreUsuarioValido(txtUsuario.getText())) {
			JOptionPane.showMessageDialog(null, "Nombre de usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			if (camposCompletos() && coincidenContrasenas()) {
				Usuario u = new Usuario(txtUsuario.getText(), password1.getText());
				String resp = "";
				msj.setId("registrarse");
				// Envio un usuario como mensaje
				msj.setMensaje(gson.toJson(u));
				enviarMensaje(msj);
				resp = leerRespuesta();
				if (resp.equals("Ok")) {
					JOptionPane.showMessageDialog(null, "Usuario creado correctamente", "Usuario",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, resp, "Error", JOptionPane.ERROR_MESSAGE);
				}
				cancelar();
			}
		}
	}

	private boolean camposCompletos() {
		if (txtUsuario.getText().length() != 0 && password1.getPassword().length != 0
				&& password2.getPassword().length != 0) {
			return true;
		}
		JOptionPane.showMessageDialog(null, "Complete todos los campos", "Campo vacio", JOptionPane.WARNING_MESSAGE);
		return false;
	}

	private boolean coincidenContrasenas() {
		if (password1.getText().equals(password2.getText()))
			return true;
		JOptionPane.showMessageDialog(null, "No coinciden las contrase�as", "Error", JOptionPane.ERROR_MESSAGE);
		return false;
	}

	private void salir() {
		login.visible(true);
		frmRegitro.dispose();
	}

	private void cancelar() {
		txtUsuario.setText("");
		password1.setText("");
		password2.setText("");
	}

	public void enviarMensaje(Mensaje msj) {
		try {
			out.writeUTF(gson.toJson(msj));
			out.flush();
		} catch (Exception e) {
			// Error enviar mensaje
		}
	}

	private String leerRespuesta() {
		try {
			msj = gson.fromJson(in.readUTF(), Mensaje.class);
		} catch (JsonSyntaxException | IOException e) {
			// Error al leer Respuesta del servidor
		}
		return msj.getMensaje();
	}
}
