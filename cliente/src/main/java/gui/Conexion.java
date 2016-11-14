package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Conexion extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldServidor;
	private JTextField textFieldPuerto;
	private String puerto, servidor;


	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conexion frame = new Conexion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	public Conexion(Login frame) throws FileNotFoundException {
		setTitle("BloodyWars - Conexi\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		leerConfig();
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblServidor = new JLabel("Servidor:");
		lblServidor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblServidor.setBounds(24, 63, 46, 14);
		panel.add(lblServidor);
		
		textFieldServidor = new JTextField();
		textFieldServidor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldServidor.setBounds(80, 60, 174, 20);
		panel.add(textFieldServidor);
		textFieldServidor.setColumns(10);
		textFieldServidor.setText(this.servidor);
		
		JLabel lblPuerto = new JLabel("Puerto:");
		lblPuerto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPuerto.setBounds(24, 88, 46, 14);
		panel.add(lblPuerto);
		
		textFieldPuerto = new JTextField();
		textFieldPuerto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldPuerto.setBounds(80, 85, 86, 20);
		panel.add(textFieldPuerto);
		textFieldPuerto.setColumns(10);
		textFieldPuerto.setText(this.puerto);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					dispose();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {					
					saveConfig();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAceptar.setBounds(138, 217, 89, 23);
		panel.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancelar.setBounds(237, 217, 89, 23);
		panel.add(btnCancelar);
	}
	
	private void leerConfig() throws FileNotFoundException {
		String linea;
		String[] splitLine;
		Scanner sc = new Scanner(new File("src/main/resources/App.config"));
		linea = sc.nextLine();
		splitLine = linea.split(":");
		this.servidor = splitLine[1];
		linea = sc.nextLine();
		splitLine = linea.split(":");
		this.puerto = splitLine[1];
	}
	
	private void saveConfig() throws FileNotFoundException {
		PrintWriter salida = new PrintWriter (new File("src/main/resources/App.config"));
		salida.println("ip:"+textFieldServidor.getText());
		salida.println("puerto:"+textFieldPuerto.getText());
		salida.close();
	}
}
