package dominio;

public class Combate {
	
	private static int contadorCombates = 1; 
	private int idCombate;
	private String nombre;
	
	public Combate(String nombre)
	{
		this.nombre = nombre;
		this.contadorCombates = 1;
		this.idCombate = 1;
	}
	
	public void combatir(Equipo e1, Equipo e2){
		idCombate = getProximoCombate();
		/*
		p1.atacar(p3);
		p3.atacar(p2);
		p2.atacar(p4);
		p4.atacar(p1);
		p1.serEnergizado();
		*/	
	}

	public void combatir(Equipo e1, Generico g) {
		/*
		p1.atacar(g);
		g.atacar(p1);
		p2.atacar(g);
		g.atacar(p2);
		*/
	}
	
	private int getProximoCombate(){
		return contadorCombates++;
	}

	public void declararGanador(Equipo e1, Equipo e2) {
		if(e1.quedaAlgunoVivo())
			e1.mostrarGanador();
		else if(e2.quedaAlgunoVivo())
			e2.mostrarGanador();
	}
}
