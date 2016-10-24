package dominio;

public abstract class Habilidad {

	protected int idHabilidad;
	protected String nombre;
	protected int ataque, defensa, magia, destreza, potencia, velocidad;
	protected int puntos;
	
	public void afectar(){
		
	}

	public int getIdHabilidad() {
		return idHabilidad;
	}

	public void setIdHabilidad(int idHabilidad) {
		this.idHabilidad = idHabilidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	
	
	
	
}
