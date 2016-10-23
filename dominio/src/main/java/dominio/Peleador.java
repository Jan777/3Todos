package dominio;

import java.io.FileNotFoundException;

public interface Peleador {

	public void atacar(Peleador victima);
	
	public abstract boolean puedeAtacar();
	public abstract void despuesDeAtacar() throws FileNotFoundException ;
	
	public void serAtacado(int dano);
	public void despuesDeSerAtacado();
	
	public boolean estaVivo();
	public Personaje dejarMejorItem();
}
