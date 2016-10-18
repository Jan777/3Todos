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

public abstract class Personaje extends Usuario implements Peleador {

	protected int vida,
				  experiencia,
				  nivel,
				  energia, 
				  ataque,
				  defensa,
				  magia,
				  daño, // @Mauro - Este atributo me parece al dope
				  destreza,
				  velocidad,
				  potencia;
	protected String raza;
	public int getVida() {
		return vida;
	}


	protected Casta clase;
	protected ArrayList<PersonajeEquipado> lista = new ArrayList<>();
	protected Map<String, Ataque> ataques = new HashMap<String, Ataque>(); 
	
	public Personaje(String nombre, String password){
		super(nombre,password);
		this.vida = 100;
		this.energia = 100;
		this.experiencia = 0;
		this.nivel = 1;	
	}
	
	public Personaje(Personaje p){
		super(p.getUsername(),p.getPassword());
		this.vida = 100;
		this.energia = 100;
		this.experiencia = 0;
		this.nivel = 1;	
	}
	
	
	// Esto recibia un Atacable
	public final void atacar(Personaje atacado) throws FileNotFoundException {
		if(atacado.estaVivo()){
			if (puedeAtacar()) {
				atacado.serAtacado(calcularPuntosDeAtaque());
				this.energia -= calcularPuntosDeAtaque();
				if(atacado.estaVivo())
				// Si mato al atacado, sube la experiencia del atancante en 10+10*el nivel del atacado
					this.experiencia+=10+(atacado.getNivel()*10);
				despuesDeAtacar();	
			}	
		}
		else{
			// Esta linea se va a comentar
			System.out.println("El atacado está muerto, no se lo puede atacar.");
		}
	}

	
	public void verEstado(){
		System.out.println("Personaje: "+this.getUsername());
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
	
	
	
	protected void despuesDeAtacar() throws FileNotFoundException { 
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

	protected abstract boolean puedeAtacar();
	public abstract int calcularPuntosDeAtaque();
	public abstract int calcularPuntosDeDefensa();
	public abstract int calcularPuntosDeMagia();
	public abstract String getRaza();
	
	
	public boolean estaVivo() {
		return this.vida > 0;
	}
	
	@Override
	public void serAtacado(int daño) {
		this.vida -= daño;
	}

	public void serCurado() {
		this.vida = 100;
	}

	public void serEnergizado() {
		this.energia = 100;
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
	
}
