package dominio;

public abstract class Ataque {
	
	protected int idAtaque;
	protected String nombre;
	protected int daño;
	
	public Ataque(){
	}
	
	public abstract int aplicarAtaque();

	public int getIdAtaque() {
		return idAtaque;
	}

	public void setIdAtaque(int idAtaque) {
		this.idAtaque = idAtaque;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
