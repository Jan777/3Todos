package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import connection.Mensaje;
import entities.Usuario;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField tpContrasena;
	private JLabel lblUsuario;
	private JLabel lblContrasena;
	private JButton btnCancelar;
	private JButton btnIngresar;
	private JButton btnRegistro;
	private Login login;

	private Socket cliente;
	private DataOutputStream out;
	private DataInputStream in;
	private int puerto;
	private String ip;
	private Gson gson;
	private Mensaje msj;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					// Log error iniciar cliente
				}
			}
		});
	}

	public Socket getCliente() {
		return cliente;
	}

	private void cerrarConexion() throws IOException {
		if (this.cliente != null) {
			msj.setId("cerrar");
			enviarMensaje(msj);
		}
	}

	public Login() throws IOException {
		setTitle("Login");
		setLogin(this);
		this.msj = new Mensaje();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		try {
			leerConfig();
			this.cliente = new Socket(this.ip, this.puerto);
			out = new DataOutputStream(cliente.getOutputStream());
			in = new DataInputStream(cliente.getInputStream());
			gson = new Gson();
		} catch (Exception e) {

		}

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					cerrarConexion();
				} catch (IOException e1) {
					// TODO Log error
				}
			}
		});

		JLabel lblBloodyWars = new JLabel("BloodyWars");
		lblBloodyWars.setHorizontalAlignment(SwingConstants.CENTER);
		lblBloodyWars.setBounds(61, 11, 236, 48);
		contentPane.add(lblBloodyWars);

		lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setBounds(7, 84, 96, 20);
		contentPane.add(lblUsuario);
		lblContrasena = new JLabel("Contrase�a: ");
		lblContrasena.setBounds(7, 108, 96, 20);
		contentPane.add(lblContrasena);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(107, 84, 251, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		tpContrasena = new JPasswordField();
		tpContrasena.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent key) {
				if (key.getKeyChar() == key.VK_ENTER)
					validar();
			}
		});
		tpContrasena.setBounds(107, 108, 251, 20);
		contentPane.add(tpContrasena);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(107, 132, 120, 21);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validar();
			}
		});
		btnIngresar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent key) {
				if (key.getKeyChar() == key.VK_ENTER)
					validar();
			}
		});
		contentPane.add(btnIngresar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(237, 132, 121, 21);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		btnCancelar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent key) {
				if (key.getKeyChar() == key.VK_ENTER)
					cancelar();
			}
		});

		contentPane.add(btnCancelar);
		btnRegistro = new JButton("Registrarse");
		btnRegistro.setBounds(107, 160, 251, 22);

		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new Registro(login, cliente);
				} catch (IOException e) {
					// TODO 
				}
			}
		});
		btnRegistro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent key) {
				if (key.getKeyChar() == key.VK_ENTER)
					try {
						new Registro(login, cliente);
					} catch (IOException e) {
						// TODO Auto-generated catch block
					}
			}
		});
		contentPane.add(btnRegistro);
		visible(true);

	}

	protected void validar() {
		if (camposCompletos()) {

			Usuario u = new Usuario(txtUsuario.getText(), tpContrasena.getText());
			String resp = "";
			msj.setId("login");
			// Envio un usuario como mensaje
			msj.setMensaje(gson.toJson(u));
			enviarMensaje(msj);

			// Leer Respuesta del servidor
			resp = leerRespuesta();
			if(resp.equals("Ok")){
				//Pasar a la siguiente ventana
			}else{
				JOptionPane.showMessageDialog(null, "Usuario o contraseña inválido", "Error", JOptionPane.WARNING_MESSAGE);
				cancelar();
			}
		}
	}

	private String leerRespuesta() {
		try {
			msj = gson.fromJson(in.readUTF(),Mensaje.class);
		} catch (JsonSyntaxException | IOException e) {
			//Error al leer Respuesta del servidor
		}
		return msj.getMensaje();
	}

	private boolean camposCompletos() {
		if (txtUsuario.getText().length() != 0 && tpContrasena.getPassword().length != 0) {
			return true;
		}
		JOptionPane.showMessageDialog(null, "Complete todos los campos", "Campo vacio", JOptionPane.WARNING_MESSAGE);
		return false;
	}

	private void leerConfig() throws FileNotFoundException {
		String linea;
		String[] splitLine;
		Scanner sc = new Scanner(new File("src/main/resources/App.config"));
		linea = sc.nextLine();
		splitLine = linea.split(":");
		this.ip = splitLine[1];

		linea = sc.nextLine();
		splitLine = linea.split(":");
		this.puerto = Integer.parseInt(splitLine[1]);
	}

	public void enviarMensaje(Mensaje msj) {
		try {
			out.writeUTF(gson.toJson(msj));
			out.flush();
		} catch (Exception e) {
			// Error enviar mensaje
		}
	}

	public void setLogin(Login miLogin) {
		this.login = miLogin;
	}

	public void cancelar() {
		txtUsuario.setText("");
		tpContrasena.setText("");
		txtUsuario.grabFocus();
	}

	public void visible(boolean value) {
		this.setVisible(value);
	}
}
