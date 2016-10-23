package dominio;

public abstract class Habilidad {

	protected int idHabilidad;
	protected String nombre;
	//protected int puntos;
	
	public void afectar(){}

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
	
	
	
}
