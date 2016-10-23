package dominio;

import java.io.FileNotFoundException;

public interface Peleador {

	public void atacar(Peleador victima) throws FileNotFoundException;
	
	public abstract boolean puedeAtacar();
	public abstract void despuesDeAtacar() throws FileNotFoundException ;
	
	public void serAtacado(int dano);
	public void despuesDeSerAtacado();
	public int getNivel();
	public boolean estaVivo();
	public Personaje dejarMejorItem();
}
