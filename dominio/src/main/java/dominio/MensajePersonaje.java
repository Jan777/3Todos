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
	
	/*public static void main(String []args){
		String cadena = new String("{\"vida\":100,\"energia\":100,\"ataque\":12,\"usuarioPersonaje\":{\"idUsuario\":0,\"username\":\"alan\",\"password\":\"81dc9bdb52d04dc20036dbd8313ed055\"},\"raza\":\"Orco\"}");
		MensajePersonaje obj = new MensajePersonaje(cadena);
		System.out.println(obj.getObjADeserializar());
	}*/
}
