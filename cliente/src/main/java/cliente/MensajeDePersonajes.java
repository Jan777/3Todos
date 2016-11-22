package cliente;

import java.io.Serializable;
import java.util.Map;

import utilities.Loggin;

public class MensajeDePersonajes extends Mensaje implements Serializable, Cloneable {

	private Map<Integer, MensajePersonaje> personajes;

	public MensajeDePersonajes(){

	}
	
	public MensajeDePersonajes(Map<Integer, MensajePersonaje> personajes){
		this.personajes = personajes;
	}
	
	public Map<Integer, MensajePersonaje> getPersonajes(){
		return personajes;
	}

	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			Loggin.getInstance().error("CloneNotSupportedException PaqueteDePersonajes: "+e.getMessage());
		}
		return obj;
	}

}