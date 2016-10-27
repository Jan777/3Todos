package dominio;

public class Combate {
	
	private static int contadorCombates = 1; 
	private int idCombate;
	private int turno;
	
	
	public Combate(Personaje p1, Personaje p2){
		idCombate = getProximoCombate();
		
		
		
		
	}
	private int getProximoCombate(){
		return contadorCombates++;
	}
}
