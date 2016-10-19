package dominio;

import java.util.HashMap;
import java.util.Map;

import org.omg.Messaging.SyncScopeHelper;


public abstract class Casta {

	protected Map<String, Habilidad> habilidades = new HashMap<String, Habilidad>(); 
	protected String nombre;
	
	public void agregarHabilidad(Habilidad h) {
		this.habilidades.put(this.nombre, h);	
	}


	public void getHabilidades(){
		int i = 1;
		for (Map.Entry<String, Habilidad> entry : this.habilidades.entrySet()) {
		    System.out.println("Habilidades "+i+": "+entry.getValue().nombre);
		    i++;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	/*
	 * Ver que fuckin' métodos le metemos
	 * */

}
