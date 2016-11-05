package connection;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import utilities.Loggin;

public class Servidor {

	private ServerSocket socket;
	private int puerto;
	private ArrayList<Socket> mundo1;
	private ArrayList<Socket> mundo2;
	private int id = 1;

	public Servidor() throws FileNotFoundException {
		mundo1 = new ArrayList<Socket>();
		mundo2 = new ArrayList<Socket>();
		leerConfig();
		
		try {
			socket = new ServerSocket(this.puerto);
			while (true) {
				Socket clientSocket = socket.accept();
				Loggin.getInstance().info("Se conecto un cliente "+ clientSocket.getInetAddress());	
				HiloMundo sala = new HiloMundo(clientSocket, mundo1, mundo2, id);
				sala.start();
				id++;
			}
		} catch (Exception e) {
			Loggin.getInstance().error("Error conectar: "+e.getMessage());
		}
	}

	private void leerConfig() throws FileNotFoundException {
		String linea;
		String[] splitLine;
		Scanner sc = new Scanner(new File("src/main/resources/ServerApp.config"));
		linea = sc.nextLine();
		splitLine = linea.split(":");
		this.puerto = Integer.parseInt(splitLine[1]);
	}

	public static void main(String[] args) throws FileNotFoundException {
		new Servidor();
	}
}
