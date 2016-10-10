package dominio;

public abstract class PersonajeEquipado extends Personaje{

	protected Personaje p; 
	protected int prioridad;
	
	public PersonajeEquipado(Personaje p) {
		super(p.getUsername(), p.getPassword());
		this.p = p;
		this.prioridad = 0;
	}

	public abstract int calcularPuntosDeAtaque();
	public abstract int calcularPuntosDeDefensa();
	public abstract int calcularPuntosDeMagia();
	public void dejarMejorItem() {
		
	}
	
	
}
