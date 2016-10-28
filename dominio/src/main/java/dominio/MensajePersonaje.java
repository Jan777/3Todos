package dominio;
import com.google.gson.Gson;

import razas.Orco;
public class MensajePersonaje {
	private Personaje objADeserializar;
	
	public Personaje getObjADeserializar() {
		return objADeserializar;
	}

	public MensajePersonaje(String cadena)
	{
		Gson objSerializable = new Gson();
		this.objADeserializar = objSerializable.fromJson(cadena, Orco.class);
	}
}
