package dominio;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Equipo {

	protected List<Personaje> equipo = new LinkedList<Personaje>();
	
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
		Iterator<Personaje> iter = equipo.iterator();
		while(iter.hasNext()){
		    if(!iter.next().estaVivo()) 
		    	iter.remove();
		}
	}
	

	
	
	public void atacar(Equipo otro) throws FileNotFoundException {
		Peleador victima = otro.obtenerProximaVictima();
		for (Personaje atacante : equipo) {
			atacante.atacar(victima);
		}
	}

	public boolean agregar(Personaje personaje) {
		return equipo.add(personaje);
	}

	
	public Peleador obtenerProximaVictima() {
		depurarEquipo();
		if(equipo.isEmpty()) {
			
			//throw new RuntimeException("El batallón está vacío");
		}
		return equipo.get(0);
	}
	
	public boolean quedaAlgunoVivo(){
		boolean marca = false;
		for(int i = 0; i< this.equipo.size();i++)
			if(equipo.get(i).estaVivo())
				marca = true;	
		return marca;
		
	}
	
	public int calcularExperiencia(){
		int suma = 0;
		for (int i = 0; i<equipo.size();i++){
			suma += equipo.get(i).getNivel();
		}
		return suma*10;
	}
	
	/*
	 * 
	 * Hay que probarlo.
	 * */
	public void repartirExperiencia(int experiencia){
		int puntosPorPersonaje = experiencia / equipo.size();
		
		for (int i = 0; i<equipo.size();i++){
			equipo.get(i).setExperiencia(equipo.get(i).getExperiencia()+puntosPorPersonaje);
		}
	}
}