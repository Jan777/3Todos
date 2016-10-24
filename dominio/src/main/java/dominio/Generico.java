package dominio;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import castas.*;

public class Generico implements Peleador {

	protected String nombre;
	protected int vida,
				  nivel,
				  energia;
	protected String raza;
	//protected Casta clase;
	protected ArrayList<PersonajeEquipado> lista = new ArrayList<>();

	/* @mauroat - 18/10/16:
	 * El nivel del generico será un valor random <= 6.
	 * 
	 * Buscar la forma de hacer un random de nombres genericos
	 * */
	
	public Generico(){
		Random r = new Random();
		/*@mauroat - 23/10/16
		 * Ver como randomear el nombre
		 * */
		this.nombre = "";
		this.vida = 100;
		this.energia = 100;
		this.nivel = r.nextInt(5);
		this.raza = setRandomRaza();
	}
	
	public Generico(String nombre){
		Random r = new Random();
		this.nombre = nombre;
		this.vida = 100;
		this.energia = 100;
		this.nivel = r.nextInt(6)+1; // Con el +1 evito que sea 0
		this.raza = setRandomRaza();
	}
	
	private String setRandomRaza() {
		Random r = new Random();
		int aux = r.nextInt(4);
		if(aux == 1){
			return "Orco";
		} else if (aux == 2){
			return "Elfo";
		} else {
			return "Humano";
		}
	}

	/*
	private Casta setRandomCasta() {
		Random r = new Random();
		int aux = r.nextInt(4);
		if(aux == 1){
			return (new Hechicero());
		} else if (aux == 2){
			return (new Chaman());
		} else {
			return (new Guerrero());
		}
	}


	private void setClase(Casta casta) {
		this.clase = casta;	
	}
	 */
	@Override
	public void atacar(Peleador victima){
		if(victima.estaVivo()){
			if (this.puedeAtacar()) {
				victima.serAtacado(this.calcularPuntosDeAtaque());
				// El siguiente metodo podrá implementarse cuando definamos la ubicación de los personajes
				//victima.despuesDeSerAtacado();
				this.energia -= this.calcularPuntosDeAtaque();
				this.despuesDeAtacar();					
			} else{				
				System.out.println(this.nombre+" no tiene energía suficiente para atacar!");
			}	
		}
	}

	
	@Override
	public void serAtacado(int dano) {
		this.vida -= dano-this.calcularPuntosDeDefensa();		
	}

	@Override
	public void despuesDeSerAtacado() {
		// No hace nada		
	}


	@Override
	public boolean estaVivo() {
		return this.vida > 0;
	}
	
	@Override
	public boolean puedeAtacar(){
		return this.energia >=10;		
	}
	
	/*@mauroat - 18/10/16
	 * Los puntos de magia ayudan a restaurar la vida de los orcos, sino se mueren muy rapido
	 * */
	@Override
	public void despuesDeAtacar(){
		this.vida += this.calcularPuntosDeMagia()/2;
	}

	protected int calcularPuntosDeAtaque() {
		if(this.raza =="Humano")	
			return 10;
		else if (this.raza =="Elfo")	
			return 5;
		else 	
			return 12;
	}
	
	protected int calcularPuntosDeDefensa() {
		if(this.raza =="Humano")	
			return 10;
		else if (this.raza =="Elfo")	
			return 5;
		else 	
			return 5;
	}
	
	protected int calcularPuntosDeMagia() {
		if(this.raza =="Humano")	
			return 0;
		else if (this.raza =="Elfo")	
			return 10;
		else 	
			return 3;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void verEstado(){
		System.out.println("Personaje: "+this.getNombre());
		System.out.println("Salud: "+this.vida);
		System.out.println("Energia: "+this.energia);
		System.out.println("----------");
		System.out.println("Raza: "+this.getRaza());
		//System.out.println("Casta: "+this.getClase().getNombre());
		System.out.println("Nivel: "+this.nivel);
		System.out.println("----------");
		System.out.println("Ataque: "+this.calcularPuntosDeAtaque());
		System.out.println("Defensa: "+this.calcularPuntosDeDefensa());
		System.out.println("Magia: "+this.calcularPuntosDeMagia());			
		System.out.println("===============");
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getVida() {
		return vida;
	}


	public void setVida(int vida) {
		this.vida = vida;
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


	public String getRaza() {
		return raza;
	}


	public void setRaza(String raza) {
		this.raza = raza;
	}

	@Override
	public Personaje dejarMejorItem() {
		return null;
	}

	

	
}
