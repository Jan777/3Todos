package dominio;

public abstract class Personaje extends Usuario{

	protected int vida;
	protected int experiencia;
	protected int nivel;
	protected int energia;

	public Personaje(String username, String password) {
		super(username, password);
		this.vida=100;
		this.energia=100;
		this.experiencia=0;
	}

	public boolean estaVivo() {
		return this.vida > 0;
	}
}
