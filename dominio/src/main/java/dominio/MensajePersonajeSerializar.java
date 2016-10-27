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
	
	/*public static void main(String []args){
		Orco objOrco = new Orco("jejje","1234");
		MensajePersonajeSerializar objMsj = new MensajePersonajeSerializar(objOrco);
		System.out.println(objMsj.getObjSerializacion());
	}*/
	
}
