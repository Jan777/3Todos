package dominio;
import java.util.*;
public class Alianza {
	private String nombre;
	private ArrayList <Personaje> integrantes; 
	
	public Alianza(String nombreParametro){
		nombre=nombreParametro;
		integrantes = new ArrayList<Personaje>();
	}
	
	public void formarAlianza(Personaje objPersonaje)	{
		integrantes.add(objPersonaje);
		objPersonaje.setAlianzaActual(this);
		
	}
	
	public void eliminarAlianza(){
		Iterator<Personaje> iter = integrantes.iterator();
		while (iter.hasNext()) 	{
			Personaje user = iter.next();
			user.setAlianzaActual(null);
		}
		
		this.integrantes.clear();
		
	}
	
	public void dejarAlianza(Personaje objPersonaje){
		Iterator<Personaje> iter = integrantes.iterator();
		while (iter.hasNext()) 	{
		    Personaje user = iter.next();
		    if(user.equals(objPersonaje)) { //con personaje veo el usuario
		    	user.setAlianzaActual(null);
		    	iter.remove();
		    }
		}		
	}
	

	public int cantidadMiembrosAlianza(){
		return this.integrantes.size();
	}
	
	public void verintegrantes()	{
	  System.out.println(integrantes);
	}

	public ArrayList<Personaje> getIntegrantes() {
		return integrantes;
	}
}
