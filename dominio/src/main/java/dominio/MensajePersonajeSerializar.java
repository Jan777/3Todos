package dominio;

import com.google.gson.Gson;

import razas.*;

public class MensajePersonajeSerializar {
	private String cadenaPersonajeSerializado;
	
	public  String getObjSerializacion() {
		return cadenaPersonajeSerializado;
	}
	public MensajePersonajeSerializar(Personaje objPersonaje)
	{
		Gson objSerializacion = new Gson();
		cadenaPersonajeSerializado = objSerializacion.toJson(objPersonaje);
	}
	
}
