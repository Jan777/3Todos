package dominio;

import java.util.HashMap;
import java.util.Map;

public abstract class Personaje extends Usuario implements Peleador{

	protected int vida,
				  experiencia,
				  nivel,
				  energia, 
				  ataque,
				  defensa,
				  magia,
				  daño, // @Mauro - Este atributo me parece al dope
				  destreza,
				  potencia;
	protected Casta clase;
	protected Map<String, Ataque> ataques = new HashMap<String, Ataque>(); 
	
	/* Constructores */
	
	public Personaje(String username, String password) {
		super(username, password);
		this.vida=100;
		this.energia=100;
		this.experiencia=0;
	}

	/* Metodos privados */
	private void morir(){
		this.vida = 0;
		this.energia = 0;
		//this.desaparecer();
	}
	private void revivir(){
		this.vida = 100;
		this.energia= 100;
	}
	
	
	/* Metodos publicos */
	
	public int calcularPuntosDeAtaque(){
		return 10;
	}
	public int calcularPuntosDeDefensa(){
		return 10;
	}
	public int calcularPuntosDeMagia(){
		return 0;
	}
	
	public boolean estaVivo() {
		return this.vida > 0;
	}
	
	public final void desaparecer(){
		System.out.println("El personaje desapareció del mapa, en n segundos reaparecerá en otra posición random"); 		
		this.revivir();
		//this.reubicar();
	}
	
	// Usar como layout para clases heredadas
	public void verEstado(){
		System.out.println("Personaje: "+this.getUsername());
		System.out.println("Salud: "+this.vida);
		System.out.println("Energia: "+this.energia);
		System.out.println("Nivel: "+this.nivel);
		System.out.println("");
	}
	

	public void serCurado() {
		this.vida = 100;
	}

	public void serEnergizado() {
		this.energia = 100;
	}
	
	public void serAtacado(int daño) {
		this.vida -= daño;
	}
	
	
	
	public void atacar(Personaje atacado) {
		if(atacado.estaVivo()){
			if (puedeAtacar()) {
				atacado.serAtacado(calcularPuntosDeAtaque());
				this.energia -= calcularPuntosDeAtaque();
				if(atacado.vida > 0)
					despuesDeAtacar();
				else
					// Si mato al atacado, sube la experiencia del atancante en 10+10*el nivel del atacado
					this.experiencia+=10+(atacado.getNivel()*10);
			}	
		}
		else{
			// Esta linea se va a comentar
			System.out.println("El atacado está muerto, no se lo puede atacar.");
		}
		
	}
	
	public void verificarNivel(){
		
	}
	
	public void subirNivel(){
		this.nivel++;
	}
	
	/* Métodos Abstractos */
	
	public abstract void despuesDeAtacar();
	protected abstract boolean puedeAtacar();

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
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

	public int getMagia() {
		return magia;
	}

	public void setMagia(int magia) {
		this.magia = magia;
	}

	public int getDaño() {
		return daño;
	}

	public void setDaño(int daño) {
		this.daño = daño;
	}

	public int getDestreza() {
		return destreza;
	}

	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public Casta getClase() {
		return clase;
	}

	public void setClase(Casta clase) {
		this.clase = clase;
	}

	public void setNuevoAtaque(Ataque a){
		this.ataques.put(a.nombre, a);
	}
	
	public Map getAtaques(){
		return this.ataques;
	}
	
}
