package dominio;

import java.util.ArrayList;

public class PersonajeEquipado extends Personaje {

	protected Personaje personajeDecorado;
	protected int prioridad;
	protected String nombreItem;
	
	
	public PersonajeEquipado(Personaje personajeDecorado) {
		super(personajeDecorado);		
		this.personajeDecorado = personajeDecorado;	
		this.clase = personajeDecorado.getClase();
	}

	@Override
	public boolean puedeAtacar() {
		//return personajeDecorado.puedeAtacar();
		return this.energia > (10 + this.calcularPuntosDeAtaque());
	}

	@Override
	public int calcularPuntosDeAtaque() {
		return this.personajeDecorado.calcularPuntosDeAtaque();
	}


	@Override
	public int calcularPuntosDeDefensa() {
		return this.personajeDecorado.calcularPuntosDeDefensa();
	}

	@Override
	public int calcularPuntosDeMagia() {
		return this.personajeDecorado.calcularPuntosDeMagia();
	}

	
	@Override
	public String getRaza() {
		return personajeDecorado.getRaza();
	}
	
	public int getPrioridad() {
		return this.prioridad;
	}

	public String getNombreItem() {
		return nombreItem;
	}

	public void setNombreItem(String nombreItem) {
		this.nombreItem = nombreItem;
	}
	
	public Personaje getPersonajeDecorado() {
		return this.personajeDecorado;
	}
	
	@Override
	public String getNombreClase() {
		return personajeDecorado.getClase().getNombre();
	}
	
	public void setPersonajeDecorado(Personaje personajeDecorado) {
		this.personajeDecorado = personajeDecorado;
	}
	
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	
	@Override
	public String getLista() {
		return personajeDecorado.getLista() + " "+getTamañoLista()+"- " +this.nombreItem+ " ";
	}
	
	@Override
	public int getTamañoLista() {
		return personajeDecorado.getTamañoLista()+1;
	}
	
	/*
	 * @mauroat - 19/10/16
	 * Corrijo este método. Funciona OK, ver test peleadorDejarMejorItem()
	 * */
	@Override
	public Personaje dejarMejorItem(){		
		
		Personaje maximo = this;
		Personaje siguiente = this.getPersonajeDecorado(); 
		if(this.getTamañoLista() == 1){
			return this;
		} else {
			for (int i = 0 ; i<this.getTamañoLista();i++){
				if(maximo.getPrioridad() > siguiente.getPrioridad()){
					if(siguiente.getPersonajeDecorado().getNombreItem() != "Sin items")
						siguiente = siguiente.getPersonajeDecorado();					
				}
				else {
					maximo = siguiente;
					if(siguiente.getPersonajeDecorado().getNombreItem() != "Sin items")
						siguiente = (PersonajeEquipado) siguiente.getPersonajeDecorado();
				}
			}
			return maximo;
		}
		
	}
	/*
	 * @mauroat - 19/10/16
	 * ARREGLADO y FUNCIONANDO 
	 */
	@Override
	public Personaje desequipar(PersonajeEquipado personajeDecorado) {
		Personaje siguiente=this, anterior = this, ultimo = this; 
		
		for (int i = 0 ; i < this.getTamañoLista();i++){
			if(siguiente.getNombreItem() != personajeDecorado.getNombreItem()){
				anterior = siguiente;
				siguiente = siguiente.getPersonajeDecorado();
			} else {				
				anterior.setPersonajeDecorado(siguiente.getPersonajeDecorado());				
				return ultimo;
			}
			
		}
		// Devuelvo lo mismo si el item no existe
		return this;
		
		
		//return anterior;
	}

	
	
	
		
}

	

