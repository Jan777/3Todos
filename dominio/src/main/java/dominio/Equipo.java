package dominio;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Equipo {

	protected List<Personaje> listaPeleadores = new LinkedList<Personaje>();
	protected List<Personaje> listaPeleadoresMuertos = new LinkedList<Personaje>();
	protected static int proximo=1;
	
	public Equipo (Personaje p){		
		agregar(p);
		if(p.getAlianzaActual() != null)
			for (Personaje aliado : p.getAlianzaActual().getIntegrantes()) 
				if(aliado.seEncuentraCerca(p) && aliado != p)		
					agregar(aliado);

	}
		
	public final void depurarEquipo() {
		for(Personaje integrante : listaPeleadores){
			if(!integrante.estaVivo()){
				listaPeleadoresMuertos.add(integrante);
				listaPeleadores.remove(integrante);
			}
				
		}
		
		/*Iterator<Personaje> iter = listaPeleadores.iterator();
		while(iter.hasNext()){
		    if(!iter.next().estaVivo()) 
		    	iter.remove();
		}
		*/
	}
	

	
	public void atacar(Equipo otro) throws FileNotFoundException {
		Peleador victima = otro.obtenerProximaVictima();
		for (Personaje atacante : listaPeleadores) {
			if(atacante.puedeAtacar()){
				atacante.atacar(victima);
			} else {
				atacante.setEnergia(atacante.getEnergia()+20);
			}
			
		}
	}

	public void atacar(Generico g) throws FileNotFoundException {
		Peleador victima = g;
		for (Personaje atacante : listaPeleadores) {
			if(atacante.puedeAtacar()){
				atacante.atacar(victima);
			} else {
				atacante.setEnergia(atacante.getEnergia()+20);
			}
			
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
		int suma = listaPeleadores.get(0).getNivel();		
		for (int i = 1; i < listaPeleadores.size();i++){		
			suma += listaPeleadores.get(0).getAlianzaActual().getIntegrantes().get(i).getNivel();
		}
		return suma*10;
	}
	

	public void repartirExperiencia(int experiencia){
		int puntosPorPersonaje = experiencia / listaPeleadores.size();
		
		for (int i = 0; i<listaPeleadores.size();i++){
			if(listaPeleadores.get(i).estaVivo())
				listaPeleadores.get(i).setExperiencia(listaPeleadores.get(i).getExperiencia()+puntosPorPersonaje);
		}
	}
	
	/*
	 * @mauroat - 07/11/16
	 * Se fija en la 
	 * */
	public void repartirItem(Equipo equipoPerdedor) throws CloneNotSupportedException {		
		Random r = new Random();
		
		/*
		 * Luego de que muera el ultimo, tengo que mandarlo a la lista de peleadores muertos y eliminarlo de 
		 * la lista de peleadores
		 * */
		equipoPerdedor.listaPeleadoresMuertos.add(equipoPerdedor.listaPeleadores.get(0));
		equipoPerdedor.listaPeleadores.remove(0);
		


		for(Personaje abatido : equipoPerdedor.listaPeleadoresMuertos){
			int posicionDePersonajeGanador = r.nextInt(this.listaPeleadores.size());			
			listaPeleadores.set(posicionDePersonajeGanador,listaPeleadores.get(posicionDePersonajeGanador).equipar(abatido.getNombreItem()));			
			//equipoPerdedor.listaPeleadoresMuertos.remove(abatido);
		}
		
	}

	/*
	 * @mauroat - 07/11/16
	 * Lo que hace este metodo es asignar el item del generico a un personaje random del equipo ganador, 
	 * siempre y cuando esté vivo.
	 * 
	 * */
	public void repartirItem(Generico g) throws CloneNotSupportedException {
		Random r = new Random();
		
		int posicion = r.nextInt(listaPeleadores.size());
		
		if(listaPeleadores.get(posicion).estaVivo()){
			listaPeleadores.set(posicion,listaPeleadores.get(posicion).equipar(g.item));
		}
		
	}

	public void desequiparEquipo(){
		for(Personaje personajeDesequipado : listaPeleadoresMuertos){
			Personaje aux = personajeDesequipado.desequipar((PersonajeEquipado)personajeDesequipado.dejarMejorItem());
			personajeDesequipado = aux;
		}
		
		/*
		for (int i = 0; i<listaPeleadoresMuertos.size();i++){
			//p2 = p2.desequipar((PersonajeEquipado)p2.dejarMejorItem());
			listaPeleadoresMuertos.set(i, listaPeleadoresMuertos.get(i);
			
		}
		*/
	}
	
	public List<String> mostrarGanador() {
        LinkedList ganadores = new LinkedList<String>();
        for (int i = 0; i<listaPeleadores.size();i++){
            ganadores.add(listaPeleadores.get(i).usuarioPersonaje.getUsername());
        }
        return ganadores;
    }

	public List<Personaje> getListaPeleadores() {
		return listaPeleadores;
	}

	public void setListaPeleadores(List<Personaje> listaPeleadores) {
		this.listaPeleadores = listaPeleadores;
	}
	
	
	
	
}