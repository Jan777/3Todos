package dominio;

import razas.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import dominio.*;
import items.*;

public abstract class Personaje implements Peleador {

	protected int vida,
	experiencia,
	nivel,
	energia, 
	ataque, 
	defensa,
	magia,
	puntos,	// @mauroat - agregado 19/10/16 - modificado 24/10/16
	destreza,
	velocidad,
	potencia;

	protected int puedeAgregarAtaque; // @mauroat - 24/10/16 : Esto se crea para satisfacer la historia de usuario 13-
	protected Ubicacion ubicacion;
	protected Usuario usuarioPersonaje;
	protected String raza;
	protected Casta clase;
	protected Map<String, Ataque> ataques = new HashMap<String, Ataque>(); 
	protected Alianza alianzaActual;
	protected Calendar limiteMinimoPermanenciaAlianza;

	public Personaje(String nombre, String password){
		this.usuarioPersonaje = new Usuario(nombre,password);
		this.vida = 100;
		this.energia = 100;
		this.experiencia = 0;
		this.nivel = 1;	
		this.puntos = 0;
		this.puedeAgregarAtaque = 0;
	}

	/*
	 * Copiar personaje
	 * */
	public Personaje(Personaje p){
		this.usuarioPersonaje = p.usuarioPersonaje;
		this.vida = p.vida;
		this.energia = p.energia;
		this.ataque = p.ataque;
		this.defensa = p.defensa;
		this.magia = p.magia;
		this.experiencia = p.experiencia;
		this.nivel = p.nivel;	
		this.puntos = p.puntos;
		this.puedeAgregarAtaque = p.puedeAgregarAtaque;
		this.destreza = p.destreza;
		this.velocidad = p.velocidad;
		this.potencia = p.potencia;
		this.clase = p.clase;
		this.ataques = p.ataques;		
	}

	public Personaje(Usuario u){
		this.usuarioPersonaje = u;
		this.vida = 100;
		this.energia = 100;
		this.experiencia = 0;
		this.nivel = 1;	
		this.puntos = 0;
		this.puedeAgregarAtaque = 0;
	}
	/* 
	 * @mauroat - 18/10/16
	 * Se modifica este metodo para que se sume mas experiencia en caso que mate al atacado. 
	 * Mi idea es que cuando esten implementadas las razas tambien afecten la experiencia.
	 * 
	 * */

	// Esto recibia un Peleador
	public final void atacar (Peleador atacado)  {
		if(atacado.estaVivo()){
			if (this.puedeAtacar()) {
				atacado.serAtacado(calcularPuntosDeAtaque());
				// El siguiente metodo podria implementarse cuando definamos la ubicacion de los personajes
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
			} 
		}
	}

	/* 
	 * @mauroat - 18/10/16
	 * Se sobrecarga el metodo atacar, para que se apliquen los daños causados por los ataques que posee cada personaje.
	 * 
	 * */
	public final void atacar(Personaje atacado, Ataque a)  {
		if(atacado.estaVivo()){
			if (this.puedeAtacar()) {
				atacado.serAtacado(calcularPuntosDeAtaque()+a.aplicarAtaque());
				// El siguiente metodo podra implementarse cuando definamos la ubicacion de los personajes
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
			}
		}
	}

	public void despuesDeSerAtacado(){
		if(this.vida <=0)
			this.morir();
	}	

	public void despuesDeAtacar()  { 
		this.verificarNivel();

	}	

	/* @mauroat - 19/10/16
	 * Al subir de nivel se suman dos puntos para sumar a las habilidades
	 * */

	private void verificarNivel()  {
		if(this.experiencia >= experienciaRequerida(this.nivel)){
			this.nivel++;
			this.puntos += 2;

			/*
			 * @mauroat - 24/10/16
			 * Si el personaje alcanza un nivel multiplo de 5, podra agregar un ataque. 
			 * */

			if(this.nivel % 5 == 0){
				this.puedeAgregarAtaque += 1;
			}
		}		
	}

	/* @mauroat - 17/10/16
	 * Esto sera reemplazado por una consulta a una base de datos
	 * */ 
	private int experienciaRequerida(int nivel) {
		try{

			Scanner sc = new Scanner (new File ("config/niveles.properties"));	
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
		// Este metodo tiene que reubicarme en una zona segura		
	}

	public boolean estaVivo() {
		return this.vida > 0;
	}

	/* @mauroat - 18/10/16
	 * Modifico este metodo para que los puntos de defensa amortiguen el daño recibido en los ataques
	 * */
	@Override
	public void serAtacado(int daño){
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

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public Casta getClase() {
		return clase;
	}

	public String getNombreClase() {
		return clase.getNombre();
	}

	public void setCasta(Casta clase) {
		this.clase = clase;
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

	public String getLista() {
		return this.raza +" equipado con:";
	}

	public int getTamañoLista() {
		return 0;
	}

	/* HASMAP DE ATAQUES  */

	public void agregarAtaque(Ataque a){
		this.ataques.put(a.getNombre(), a);
		this.puedeAgregarAtaque--;
	}

	public void quitarAtaque(Ataque a){
		this.ataques.remove(a.getNombre());		
		// Si lo quiere sacar no puede elegir otro, que se joda.
		//this.puedeAgregarAtaque++;
	}

	public LinkedList<String> getListaAtaques(){
		int i = 1;
		LinkedList<String> ataques = new LinkedList<String>();
		for (Map.Entry<String, Ataque> entry : this.ataques.entrySet()) {
			ataques.add("Ataque "+i+": "+entry.getKey());
			i++;
		}
		return ataques;
	}

	public Map<String, Ataque> getAtaques() {
		return ataques;
	}

	public void setAtaques(Map<String, Ataque> ataques) {
		this.ataques = ataques;
	}

	public int getCantidadAtaques(){
		return this.ataques.size();
	}

	public Ataque getAtaque(String ataque){
		return this.ataques.get(ataque);		
	}

	public Personaje dejarMejorItem(){
		return null;
	}

	public int getPrioridad() {
		return 0;
	}

	public boolean compararPrioridad(int p1, int p2){
		return p1 == p2;
	}

	public Personaje getPersonajeDecorado() {
		return null;
	}

	public void setPersonajeDecorado(Personaje p) {
		// No hace nada
	}



	public Usuario getUsuarioPersonaje() {
		return usuarioPersonaje;
	}

	public void setUsuarioPersonaje(Usuario usuarioPersonaje) {
		this.usuarioPersonaje = usuarioPersonaje;
	}

	/*
	 * @mauroat - 27/10/16
	 * Rudimentario, pero funciona
	 * */
	public PersonajeEquipado equipar(PersonajeEquipado pe) throws CloneNotSupportedException {
		/*
		 * Creo una copia de mi personaje desequipado
		 * */
		Personaje aux = (Personaje) this.clone();

		if(pe.getNombreItem() == "Armadura de Azor Ahai"){
			aux = new ArmaduraDeAzorAhai(aux);
		} else if (pe.getNombreItem() == "Bastón de Saruman"){
			aux = new BastonDeSaruman(aux);
		} else if (pe.getNombreItem() == "Bujía Hescher"){
			aux = new BujiaHescher(aux);
		} else if (pe.getNombreItem() == "Daga de Dragón"){
			aux = new DagaDeDragon(aux);	
		} else if (pe.getNombreItem() == "Escudo de León"){
			aux = new EscudoDeLeon(aux);
		} else if (pe.getNombreItem() == "Espada de Juan Nieve"){
			aux = new EspadaDeJuanNieve(aux);
		} else if (pe.getNombreItem() == "Guante de Poder"){
			aux = new GuanteDePoder(aux);
		} else if (pe.getNombreItem() == "Lanza en llamas"){
			aux = new LanzaEnLlamas(aux);
		} else if (pe.getNombreItem() == "Poción bruta"){
			aux = new PocionBruta(aux);
		} else if (pe.getNombreItem() == "Poción multijugos"){
			aux = new PocionMultijugos(aux);
		} else if (pe.getNombreItem() == "Poción sabiduría"){
			aux = new PocionSabiduria(aux);
		} else if (pe.getNombreItem() == "Runa de magia"){
			aux = new RunaDeMagia(aux);
		} else {
			aux = new TotemProteccion(aux);
		}

		return (PersonajeEquipado) aux;
	}

	/*
	 * Se sobrecarga este metodo para que sea funcional a los Genericos
	 * */

	public PersonajeEquipado equipar(String item) throws CloneNotSupportedException {
		/*
		 * Creo una copia de mi personaje desequipado
		 * */
		Personaje aux = (Personaje) this.clone();

		if(item == "Armadura de Azor Ahai"){
			aux = new ArmaduraDeAzorAhai(aux);
		} else if (item == "Bastón de Saruman"){
			aux = new BastonDeSaruman(aux);
		} else if (item == "Bujía Hescher"){
			aux = new BujiaHescher(aux);
		} else if (item == "Daga de Dragón"){
			aux = new DagaDeDragon(aux);	
		} else if (item == "Escudo de León"){
			aux = new EscudoDeLeon(aux);
		} else if (item == "Espada de Juan Nieve"){
			aux = new EspadaDeJuanNieve(aux);
		} else if (item == "Guante de Poder"){
			aux = new GuanteDePoder(aux);
		} else if (item == "Lanza en llamas"){
			aux = new LanzaEnLlamas(aux);
		} else if (item == "Poción bruta"){
			aux = new PocionBruta(aux);
		} else if (item == "Poción multijugos"){
			aux = new PocionMultijugos(aux);
		} else if (item == "Poción sabiduría"){
			aux = new PocionSabiduria(aux);
		} else if (item == "Runa de magia"){
			aux = new RunaDeMagia(aux);
		} else {
			aux = new TotemProteccion(aux);
		}

		return (PersonajeEquipado) aux;
	}

	public Personaje desequipar(PersonajeEquipado personaje) {
		return null;
	}

	public String getNombreItem() {
		//return "Sin items";
		return null;
	}

	public String toString()   {
		return this.usuarioPersonaje.getUsername();
	}

	public boolean interactuarConOtroPersonaje(Personaje p)  {
		if(ubicacion.contiene(p.getUbicacion()))
			return p.respuesta();
		return false; 	 
	}

	public boolean respuesta() {
		return true;
	}

	public boolean equals(Personaje obj) {
		if(this.usuarioPersonaje.equals(obj.usuarioPersonaje))
			return true;
		return false;	
	}

	public int getPuedeAgregarAtaque() {
		return puedeAgregarAtaque;
	}

	public void setPuedeAgregarAtaque(int puedeAgregarAtaque) {
		this.puedeAgregarAtaque = puedeAgregarAtaque;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion u) {
		this.ubicacion = u;
	}

	public int getMagia() {
		return magia;
	}

	public void setMagia(int magia) {
		this.magia = magia;
	}

	public boolean seEncuentraCerca(Personaje obj)	 {
		return this.ubicacion.distanciaA(obj.ubicacion) <= (this.ubicacion.getRadio() + obj.ubicacion.getRadio());
	}

	public void reubicar()	 {
		this.setUbicacion(obtenerLugarSeguroRandom());
	}

	private Ubicacion obtenerLugarSeguroRandom()	 {
		Random r = new Random();
		Map<Integer, Ubicacion> ListaUbicacion = new HashMap<Integer, Ubicacion>(); 
		/*Validar que no haya obstaculos ni personajes en las ubicaciones*/
		ListaUbicacion.put(0, new Ubicacion(0,0));
		ListaUbicacion.put(1, new Ubicacion(15,0));
		ListaUbicacion.put(2, new Ubicacion(90,90));
		ListaUbicacion.put(3, new Ubicacion(90,150));

		return ListaUbicacion.get(r.nextInt(4));
	}

	public void setAlianzaActual(Alianza alianzaActual) {
		this.alianzaActual = alianzaActual;
	}

	public Alianza getAlianzaActual() {
		return alianzaActual;
	}

	public Calendar getLimiteMinimoPermanenciaAlianza() {
		return limiteMinimoPermanenciaAlianza;
	}

	public void setLimiteMinimoPermanenciaAlianza(Calendar limiteMinimoPermanenciaAlianza) {
		this.limiteMinimoPermanenciaAlianza = limiteMinimoPermanenciaAlianza;
	}







}
