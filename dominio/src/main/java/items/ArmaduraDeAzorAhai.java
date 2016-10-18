package items;

import dominio.*;
import razas.*;

public class ArmaduraDeAzorAhai extends PersonajeEquipado{

	private Personaje p;
	
	/* @Mauro - 17-10-16 -  
	 * Creo un constructor para cada subpersonaje ya que de lo contrario, al aplicar decorator
	 * no guarda la raza del personaje. 
	 * */
	
	public ArmaduraDeAzorAhai(Personaje p) {
		super(p);
		super.agregarALista(this);
		this.p = p;		
		this.prioridad = 3;
	}
	
	public ArmaduraDeAzorAhai(Orco p) {
		super(p);
		this.p = p;
		this.p.agregarALista(this);
		this.prioridad = 3;
		
	}
	
	public ArmaduraDeAzorAhai(Humano p) {
		super(p);
		this.p = p;
		this.p.agregarALista(this);
		this.prioridad = 3;
	}
	

	@Override
	public int calcularPuntosDeAtaque() {
		return p.calcularPuntosDeAtaque();
	}

	@Override
	public int calcularPuntosDeDefensa() {
		return p.calcularPuntosDeDefensa()+6;
	}

	@Override
	public int calcularPuntosDeMagia() {
		return p.calcularPuntosDeMagia()+1;
	}

	@Override
	public void atacar(Peleador victima) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PersonajeEquipado dejarItem() {
		return (PersonajeEquipado) p;	
	}


	@Override
	public String getRaza() {
		return p.getRaza();
	}


}
