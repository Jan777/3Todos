package dominio;

import java.util.HashMap;
import java.util.Map;


public abstract class Casta {

	private Map<String, Habilidad> habilidades = new HashMap<String, Habilidad>(); 

	public abstract void agregarHabilidad();

	public void aumentarFuerza() {
		// TODO Auto-generated method stub
		
	}

}
