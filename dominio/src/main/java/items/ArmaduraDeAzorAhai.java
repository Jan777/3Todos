package items;

import org.omg.Messaging.SyncScopeHelper;

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
		this.p = p;
		this.prioridad = 3;
		this.nombreItem = "Armadura de Azor Ahai";
	}
	
	public ArmaduraDeAzorAhai(Orco p) {
		super(p);
		this.p = p;		
		this.prioridad = 3;
		this.nombreItem = "Armadura de Azor Ahai";		
	}
	
	public ArmaduraDeAzorAhai(Humano p) {
		super(p);		
		this.p = p;
		this.prioridad = 3;
		this.nombreItem = "Armadura de Azor Ahai";
	}
	

	public ArmaduraDeAzorAhai(Elfo p) {
		super(p);		
		this.p = p;		
		this.prioridad = 3;
		this.nombreItem = "Armadura de Azor Ahai";
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
	public String getRaza() {
		return p.getRaza();
	}
	
	@Override
	public void setPersonajeDecorado(Personaje personajeDecorado) {
		this.p = personajeDecorado;
	}

	@Override
	public String getLista() {
		return p.getLista() + " "+getTamañoLista()+"- " +this.nombreItem+ " ";
	}
	
	@Override
	public int getTamañoLista() {
		return p.getTamañoLista()+1;
	}

}
