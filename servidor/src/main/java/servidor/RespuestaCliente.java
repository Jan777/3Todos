package servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.Semaphore;

import com.google.gson.Gson;

import cliente.Cliente;
import cliente.Mensaje;
import cliente.MensajeDePersonajes;
import cliente.MensajePersonaje;
import cliente.Usuario;
import dominio.Personaje;
import razas.Humano;
import utilities.Loggin;

public class RespuestaCliente extends Thread {

	private final Socket socket;
	private final ObjectInputStream entrada;
	private final ObjectOutputStream salida;
	private String salaCliente;
	private MensajePersonaje personaje;
	private MensajeDePersonajes mp;
	private final Gson gson = new Gson();

	public RespuestaCliente(String ip, Socket socket, ObjectInputStream entrada, ObjectOutputStream salida) {
		this.socket = socket;
		this.entrada = entrada;
		this.salida = salida;
	}

	public void run() {
		try {

			Mensaje msj;
			Mensaje msjA = new Mensaje(null, null);
			Semaphore semaforo = new Semaphore(0);
			DBControlador con;
			
			Personaje p1 = new Humano(""); // auxiliar para la BD
			Usuario usuario = new Usuario();

			String cadenaLeida = (String) entrada.readObject();

			while (!((msj = gson.fromJson(cadenaLeida, Mensaje.class)).getComando().equals("desconectar"))) {
				switch (msj.getComando()) {
					case "registrar":
						con = new DBControlador();
						con.connect();
						msjA.setComando("estadoRegistro");
						usuario = (Usuario) Cliente.desconversor(msj.getMensaje(), Usuario.class);
	
						if (con.registrarUsuario(usuario)) {
							{
								msjA.setMensaje("1");
								salida.writeObject(gson.toJson(msjA));
							}
						} else {
							msjA.setMensaje("0");
							salida.writeObject(false);
						}
						con.close();
						break;
	
					case "crearPersonaje":
						Personaje p;
						con = new DBControlador();
						con.connect();
						p = (Personaje) entrada.readObject();
						con.registrarPersonaje(p, usuario);
						salida.writeObject((int) p.getIdPersonaje());
						break;
	
					case "login":
						con = new DBControlador();
						con.connect();
						msjA.setComando("estadoLogin");
						if (con.loguearUsuario((Usuario) Cliente.desconversor(msj.getMensaje(), Usuario.class))) {
							msjA.setMensaje("1");
							salida.writeObject(gson.toJson(msjA));
							MensajePersonaje pp = con.getPersonaje((Usuario) Cliente.desconversor(msj.getMensaje(), Usuario.class));
							salida.writeObject(gson.toJson(pp));
						} else {
							msjA.setMensaje("0");
							salida.writeObject(gson.toJson(msjA));
						}
						con.close();
						break;
	
					case "salir":
						msjA.setComando("salir");
						msjA.setMensaje(null);
						salida.writeObject(gson.toJson(msjA));
						break;
	
					case "cerrar":
						msjA.setComando("cerrar");
						msjA.setMensaje(null);
						salida.writeObject(gson.toJson(msjA));
						break;
	
					case "conectado":
						personaje = (MensajePersonaje) (gson.fromJson(cadenaLeida, MensajePersonaje.class)).clone();
	
						Servidor.getPersonajes().put(personaje.getIdPersonaje(), (MensajePersonaje) personaje.clone());
	
						for (RespuestaCliente conectado : Servidor.getConectados()) {
							mp = new MensajeDePersonajes(Servidor.getPersonajes());
							mp.setComando("conectado");
							conectado.salida.writeObject(gson.toJson(mp));
						}
						break;
	
					case "movimiento":
						personaje = (MensajePersonaje) (gson.fromJson((String) cadenaLeida, MensajePersonaje.class));
						Loggin.getInstance().info(personaje.getIp() + " recibi movimiento ");
						// .clone();
						Servidor.getPersonajes().get(personaje.getIdPersonaje()).setPosX(personaje.getPosX());
						Servidor.getPersonajes().get(personaje.getIdPersonaje()).setPosY(personaje.getPosY());
						Servidor.getPersonajes().get(personaje.getIdPersonaje()).setDireccion(personaje.getDireccion());
						Servidor.getPersonajes().get(personaje.getIdPersonaje()).setFrame(personaje.getFrame());
	
						for (RespuestaCliente conectado : Servidor.getConectados()) {
							MensajePersonaje pj = (MensajePersonaje) Servidor.getPersonajes().get(personaje.getIdPersonaje()).clone();
							pj.setComando("movimiento");
							Loggin.getInstance().info("Al cliente: " + conectado.getId() + " le envio " + gson.toJson(mp));
							conectado.salida.writeObject(gson.toJson(mp));
						}
						break;
	
					case "mostrarMapas":
						Loggin.getInstance().info("Mapa: " + msj.getMensaje());
						break;

				}
				cadenaLeida = (String) entrada.readObject();
			}

			entrada.close();
			salida.close();
			socket.close();

			Servidor.getPersonajes().remove(personaje.getIdPersonaje());
			Servidor.getConectados().remove(this);

			for (RespuestaCliente conectado : Servidor.getConectados()) {
				mp = new MensajeDePersonajes(Servidor.getPersonajes());
				mp.setComando("conectado");
				conectado.salida.writeObject(gson.toJson(mp));
			}
			
			Loggin.getInstance().info(msj.getIp() + " se ha desconectado.");

		} catch (IOException e) {
			Loggin.getInstance().error("Error atencion de peticiones: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			Loggin.getInstance().error("Error atencion de peticiones: " + e.getMessage());
		}
	}
}
