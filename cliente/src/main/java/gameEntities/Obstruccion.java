package gameEntities;

import graphic.Grafico;;

public class Obstruccion extends Tile {
	
	public Obstruccion(int id) {
		super(Grafico.obstruccion, id);
	}
	
	@Override
	public boolean esSolido() {
		return true;
	}
}
