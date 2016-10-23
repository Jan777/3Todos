package dominio;

import java.util.HashMap;
import java.util.Map;

import org.omg.Messaging.SyncScopeHelper;


public abstract class Casta {

	protected Map<Integer, Habilidad> habilidades = new HashMap<Integer, Habilidad>(); 
	protected String nombre;
	
	public void agregarHabilidad(Habilidad h) {
		if(this.habilidades.size()>=3){
			//System.out.println("No puede tener más de 3 habilidades");
		} else {
			this.habilidades.put(h.getIdHabilidad(), h);
		}			
	}


	public Map<Integer, Habilidad> getHabilidades(){
		return this.habilidades;
	}

	public void verHabilidades(){
		int i = 1;
		for (Map.Entry<Integer, Habilidad> entry : this.habilidades.entrySet()) {
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
