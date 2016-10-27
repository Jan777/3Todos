package dominio;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
public class Alianza {
	private static int contadorAlianzas = 1; 
	private int idAlianza;
	private String nombre;
	private ArrayList <Personaje> integrantes; 
	
	public Alianza(String nombreParametro){
		nombre=nombreParametro;
		integrantes = new ArrayList<Personaje>();
	}
	
	public Alianza(){
		//nombre=nombreParametro;
		idAlianza = this.getProximaAlianza();
		integrantes = new ArrayList<Personaje>();
	}
	
	private int getProximaAlianza(){
		return contadorAlianzas++;
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
	/*
	 * @mauroat - 27/10/16
	 * La idea de este método es que finalizados los combates reparta experiencia entre los miembros de la alianza
	 * */

	public int getIdAlianza() {
		return idAlianza;
	}

	public void setIdAlianza(int idAlianza) {
		this.idAlianza = idAlianza;
	}

	public void setIntegrantes(ArrayList<Personaje> integrantes) {
		this.integrantes = integrantes;
	}
	
	
	
}
