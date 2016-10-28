package dominio;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Equipo {

	protected List<Personaje> listaPeleadores = new LinkedList<Personaje>();
	
	public Equipo (Personaje p){		
		agregar(p);
		if(p.getAlianzaActual() != null){
			int i = 1;
			while(i < p.getAlianzaActual().getIntegrantes().size()){
				agregar(p.getAlianzaActual().getIntegrantes().get(0));
				i++;
			}
		}
	}
		
	public final void depurarEquipo() {
		Iterator<Personaje> iter = listaPeleadores.iterator();
		while(iter.hasNext()){
		    if(!iter.next().estaVivo()) 
		    	iter.remove();
		}
	}
	

	
	
	public void atacar(Equipo otro)  {
		Peleador victima = otro.obtenerProximaVictima();
		for (Personaje atacante : listaPeleadores) {
			atacante.atacar(victima);
		}
	}

	public boolean agregar(Personaje personaje) {
		return listaPeleadores.add(personaje);
	}

	
	public Peleador obtenerProximaVictima() {
		depurarEquipo();
		if(listaPeleadores.isEmpty()) {
			
			//throw new RuntimeException("El batallón está vacío");
		}
		return listaPeleadores.get(0);
	}
	
	public boolean quedaAlgunoVivo(){
		boolean marca = false;
		for(int i = 0; i< this.listaPeleadores.size();i++)
			if(listaPeleadores.get(i).estaVivo())
				marca = true;	
		return marca;
		
	}
	
	public int calcularExperiencia(){
		int suma = 0;
		for (int i = 0; i<listaPeleadores.size();i++){
			suma += listaPeleadores.get(i).getNivel();
		}
		return suma*10;
	}
	
	/*
	 * 
	 * Hay que probarlo.
	 * */
	public void repartirExperiencia(int experiencia){
		int puntosPorPersonaje = experiencia / listaPeleadores.size();
		
		for (int i = 0; i<listaPeleadores.size();i++){
			listaPeleadores.get(i).setExperiencia(listaPeleadores.get(i).getExperiencia()+puntosPorPersonaje);
		}
	}

	public void repartirItem(Equipo e2) {
		
	}

	public void repartirItem(Generico g) {
		
	}

	public List<String> mostrarGanador() {
		LinkedList ganadores = new LinkedList<String>();
		for (int i = 0; i<listaPeleadores.size();i++){
			ganadores.add(listaPeleadores.get(i).usuarioPersonaje.getUsername());
		}
		return ganadores;
	}
}