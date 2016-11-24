package servidor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import cliente.MensajePersonaje;
import utilities.Loggin;

public class Servidor extends Thread {

	private static ArrayList<RespuestaCliente> conectados = new ArrayList<>();
	private static Map<Integer, MensajePersonaje> combatiendo = new HashMap<>();
	
	private static Map<Integer, MensajePersonaje> personajes = new HashMap<>();
	private ServerSocket server;
	private int puerto;
	private ObjectOutputStream salida;
	private ObjectInputStream entrada;
	 
	
	
	public void run() {
		try {
			leerConfig();
			Loggin.getInstance().info("Iniciando el servidor...");
			server = new ServerSocket(puerto);
			Loggin.getInstance().info("Servidor esperando conexiones...");
			String ipRemota;

			while (true) {
				Socket cliente = server.accept();
				ipRemota = cliente.getInetAddress().getHostAddress();
				Loggin.getInstance().info(ipRemota + " se ha conectado");

				ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream());
				ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());

				RespuestaCliente atencion = new RespuestaCliente(ipRemota, cliente, entrada, salida);
				atencion.start();
				conectados.add(atencion);
			}
		} catch (Exception e) {
			Loggin.getInstance().error("Error en servidor: " + e.getMessage());
		}
	}

	public static ArrayList<RespuestaCliente> getConectados() {
		return conectados;
	}

	public static Map<Integer, MensajePersonaje> getPersonajes() {
		return personajes;
	}

	public static void main(String[] args) {
		new Servidor().start();
	}
	

	private void leerConfig() throws FileNotFoundException {
		String linea;
		String[] splitLine;
		Scanner sc = new Scanner(new File("ServerApp.config"));
		linea = sc.nextLine();
		splitLine = linea.split(":");
		this.puerto = Integer.parseInt(splitLine[1]);
		sc.close();
	}

	public static Map<Integer, MensajePersonaje> getCombatiendo() {
		return combatiendo;
	}

	public static void setCombatiendo(Map<Integer, MensajePersonaje> combatiendo) {
		Servidor.combatiendo = combatiendo;
	}

	public ServerSocket getServer() {
		return server;
	}

	public void setServer(ServerSocket server) {
		this.server = server;
	}

	public int getPuerto() {
		return puerto;
	}

	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}

	public ObjectOutputStream getSalida() {
		return salida;
	}

	public void setSalida(ObjectOutputStream salida) {
		this.salida = salida;
	}

	public ObjectInputStream getEntrada() {
		return entrada;
	}

	public void setEntrada(ObjectInputStream entrada) {
		this.entrada = entrada;
	}

	public static void setConectados(ArrayList<RespuestaCliente> conectados) {
		Servidor.conectados = conectados;
	}

	public static void setPersonajes(Map<Integer, MensajePersonaje> personajes) {
		Servidor.personajes = personajes;
	}

	
	
}