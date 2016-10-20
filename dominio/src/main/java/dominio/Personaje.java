package dominio;

import razas.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import dominio.*;

public abstract class Personaje implements Peleador {

	protected int vida,
				  experiencia,
				  nivel,
				  energia, 
				  ataque, 
				  defensa,
				  magia,
				  //daño, // @Mauro - Este atributo me parece al dope
				  destreza,
				  velocidad,
				  potencia;
	protected String raza;
	protected Casta clase;
	protected ArrayList<PersonajeEquipado> lista = new ArrayList<>();
	protected Map<String, Ataque> ataques = new HashMap<String, Ataque>(); 
	protected Usuario usuarioPersonaje;
	//protected Alianza alianzaActual;
	public Personaje(String nombre, String password){
		//usuarioPersonaje = new Usuario(username,password);
		usuarioPersonaje = new Usuario(nombre,password);
		this.vida = 100;
		this.energia = 100;
		this.experiencia = 0;
		this.nivel = 1;	
	}
	
	public Personaje(Personaje p){
		//super(p.getUsername(),p.getPassword());
		this.usuarioPersonaje = p.usuarioPersonaje;
		this.vida = 100;
		this.energia = 100;
		this.experiencia = 0;
		this.nivel = 1;	
	}
	
	/* @mauroat - 18/10/16
	 * Se modifica este método para que se sume más experiencia en caso que mate al atacado. 
	 * Mi idea es que cuando esten implementadas las razas tambien afecten la experiencia.
	 * 
	 * */
	
	// Esto recibia un Atacable
	public final void atacar(Personaje atacado) throws FileNotFoundException {
		if(atacado.estaVivo()){
			if (this.puedeAtacar()) {
				atacado.serAtacado(calcularPuntosDeAtaque());
				// El siguiente metodo podrá implementarse cuando definamos la ubicación de los personajes
				//atacado.despuesDeSerAtacado();
				this.energia -= calcularPuntosDeAtaque();
				
				if(atacado.estaVivo()){
					// Por cada ataque que haga, mi experiencia sube en 8
					this.experiencia += 8;
					
				} else {
					// Si en cambio, mato al atacado, mi experiencia sube en 10*el nivel del atacado
					this.experiencia+=(atacado.getNivel()*10);
				}
	
				this.despuesDeAtacar();	
				
			} else{
				System.out.println(this.usuarioPersonaje.getUsername() +" no tiene energía suficiente para atacar!");
				//System.out.println(this.getUsername()+" no tiene energía suficiente para atacar!");
			}
		}
		else{
			// Esta linea se va a comentar
			System.out.println("El atacado está muerto, no se lo puede atacar.");
		}
	}

	/* @mauroat - 18/10/16
	 * Se sobrecarga el método atacar, para que se apliquen los daños causados por los ataques que posee cada personaje.
	 * */
	public final void atacar(Personaje atacado, Ataque a) throws FileNotFoundException {
		if(atacado.estaVivo()){
			if (this.puedeAtacar()) {
				atacado.serAtacado(calcularPuntosDeAtaque()+a.aplicarAtaque());
				// El siguiente método podrá implementarse cuando definamos la ubicación de los personajes
				//atacado.despuesDeSerAtacado();
				this.energia -= calcularPuntosDeAtaque()+a.aplicarAtaque();
				if(atacado.estaVivo()){
					// Por cada ataque que haga, mi experiencia sube en 8
					this.experiencia += 8;					
				} else {
					// Si en cambio, mato al atacado, mi experiencia sube en 10*el nivel del atacado
					this.experiencia+=(atacado.getNivel()*10);
				}
	
				this.despuesDeAtacar();	
			} else{
				System.out.println(this.usuarioPersonaje.getUsername() +" no tiene energía suficiente para atacar!");
				//System.out.println(this.getUsername()+" no tiene energía suficiente para atacar!");
			}
		}
		else{
			// Esta linea se va a comentar
			System.out.println("El atacado está muerto, no se lo puede atacar.");
		}
	}
	
	public void despuesDeSerAtacado(){
		if(this.vida <=0)
			this.morir();
	}
	
	public void verEstado(){
		System.out.println("Personaje: "+this.usuarioPersonaje.getUsername());
		System.out.println("Salud: "+this.vida);
		System.out.println("Energia: "+this.energia);
		System.out.println("----------");
		System.out.println("Raza: "+this.getRaza());
		System.out.println("Nivel: "+this.nivel);
		System.out.println("Experiencia: "+this.experiencia);
		System.out.println("----------");
		System.out.println("Ataque: "+this.calcularPuntosDeAtaque());
		System.out.println("Defensa: "+this.calcularPuntosDeDefensa());
		System.out.println("Magia: "+this.calcularPuntosDeMagia());
		System.out.println("----------");
		System.out.println("Destreza: "+this.destreza);
		System.out.println("Velocidad: "+this.velocidad);
		System.out.println("Potencia: "+this.potencia);		
		System.out.println("===============");
	}
	
	
	
	public void despuesDeAtacar() throws FileNotFoundException { 
		this.verificarNivel();
		
	}	
	
	private void verificarNivel() throws FileNotFoundException {
		if(this.experiencia >= experienciaRequerida(this.nivel)){
			this.nivel++;
		}		
	}
	
	private int experienciaRequerida(int nivel) throws FileNotFoundException{
		try{
			// Esto será reemplazado por una consulta a una base de datos
			Scanner sc = new Scanner (new File ("config/niveles.cfg"));	
			while(sc.hasNextLine()){
				if(nivel == sc.nextInt()){
					return sc.nextInt();
				}
				sc.nextInt();
			}
			sc.close();
		} catch(Exception e){
			e.printStackTrace();
		} 
		return 0;
	}

	public abstract boolean puedeAtacar();
	public abstract int calcularPuntosDeAtaque();
	public abstract int calcularPuntosDeDefensa();
	public abstract int calcularPuntosDeMagia();
	public abstract String getRaza();
	
	public void morir(){
		this.vida=0;
		//Tengo que dejar el mejor item
		//this.dejarItem();
		this.reaparecer();
		this.revivir();
	}
	
	private void revivir() {
		this.serCurado();
		this.serEnergizado();		
	}

	private void reaparecer() {
		// Este método tiene que reubicarme en una zona segura		
	}

	public boolean estaVivo() {
		return this.vida > 0;
	}
	
	/* @mauroat - 18/10/16
	 * Modifico este método para que los puntos de defensa amortiguen el daño recibido en los ataques
	 * */
	@Override
	public void serAtacado(int daño) {
		this.vida -= daño-this.calcularPuntosDeDefensa();
	}

	public void serCurado() {
		this.vida = 100;
	}

	public void serEnergizado() {
		this.energia = 100;
	}
	
	public int getVida() {
		return vida;
	}
	
	public int getExperiencia() {
		return experiencia;
	}


	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}


	public int getNivel() {
		return nivel;
	}


	public void setNivel(int nivel) {
		this.nivel = nivel;
	}


	public int getEnergia() {
		return energia;
	}


	public void setEnergia(int energia) {
		this.energia = energia;
	}


	public int getDestreza() {
		return destreza;
	}


	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}


	public int getVelocidad() {
		return velocidad;
	}


	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}


	public int getPotencia() {
		return potencia;
	}


	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}


	public void setRaza(String raza) {
		this.raza = raza;
	}


	public void setVida(int vida) {
		this.vida = vida;
	}

	/* LISTA DE ITEMS */
	
	public void getLista() {
		System.out.println("Cantidad de items: "+lista.size());
		for(int i=0; i<lista.size();i++)
			System.out.println(lista.get(i));
	}
	
	public int getTamañoLista() {
		return lista.size();
	}

	public void agregarALista(PersonajeEquipado pe) {
		//this.lista.add(pe);
		this.lista.addAll(Arrays.asList(pe));
	}

	public PersonajeEquipado getItemMasPrioritario() {
		PersonajeEquipado aux = null;
		int max = -1;
		for(int i=0; i<lista.size();i++){
			if(max < lista.get(i).getPrioridad()){
				max = lista.get(i).getPrioridad();
				aux = lista.get(i);
			}
		}		
		return aux;
	}
	
	/* HASMAP DE ATAQUES  */
	
	public void agregarAtaque(Ataque a){
		this.ataques.put(a.getNombre(), a);
	}
	
	public void quitarAtaque(Ataque a){
		this.ataques.remove(a.getNombre());
	}
	
	public void getListaAtaques(){
		int i = 1;
		for (Map.Entry<String, Ataque> entry : this.ataques.entrySet()) {
		    System.out.println("Ataque "+i+": "+entry.getKey());
		    i++;
		}
	}
	
	public int getCantidadAtaques(){
		return this.ataques.size();
	}
	
	public Ataque getAtaque(String ataque){
		return this.ataques.get(ataque);		
	}
	
	public String toString()
    {
    	return this.usuarioPersonaje.getUsername();
    }
	
	  public boolean inteactuarConOtroPersonaje(Personaje obj)
	     {
	        return obj.respuesta(); 	 
	     }
	    public boolean respuesta()
	    {
		   return true;
	    }
	    
	    public boolean equals(Personaje obj)
	    {
	    	if(this.usuarioPersonaje.equals(obj.usuarioPersonaje))
	    		return true;
	         return false;	
	    }
}
