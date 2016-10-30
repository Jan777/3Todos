package connection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import com.google.gson.Gson;

import entities.Usuario;

public class HiloMundo extends Thread {

	private DataInputStream in;
	private DataOutputStream out;
	private Socket sk;
	private Mensaje msj;
	private Gson gson;
	private ArrayList<Socket> mundo1;
	private ArrayList<Socket> mundo2;
	private int id;

	public HiloMundo(Socket clientSocket, ArrayList<Socket> mundo1, ArrayList<Socket> mundo2, int id) {
		this.sk = clientSocket;
		this.gson = new Gson();
		this.mundo1 = mundo1;
		this.mundo2 = mundo2;
		this.id = id;
		this.msj = new Mensaje();
		try {
			this.in = new DataInputStream(sk.getInputStream());
			this.out = new DataOutputStream(sk.getOutputStream());

			procesarPeticion();
		} catch (IOException e) {
			// Log Error Eleccion mundo
		}
	}

	private void procesarPeticion() throws IOException {
		String resp = "";
		try {
			msj = gson.fromJson(in.readUTF(), Mensaje.class);
			resp = msj.getId();
		} catch (Exception e) {
			// Error leer mensaje
		}
		switch (resp) {
		case "login": {
			Usuario u = gson.fromJson(msj.getMensaje(),Usuario.class);
			boolean ingreso = u.validarIngreso();
			if(ingreso){
				msj.setMensaje("Ok");
			}else{
				msj.setMensaje("Usuario no valido");
			}
			out.writeUTF(gson.toJson(msj));
			break;
		}
		case "conectarMundo1": {
			mundo1.add(sk);
			HiloServidor hilo = new HiloServidor(sk, mundo1, id);
			hilo.start();
			break;
		}
		case "conectarMundo2": {
			mundo2.add(sk);
			HiloServidor hilo = new HiloServidor(sk, mundo2, id);
			hilo.start();
			break;
		}
		default: {
			break;
		}
		}
	}
}
