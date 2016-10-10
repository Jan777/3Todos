package items;

import dominio.*;

public class ArmaduraDeAzorAhai extends PersonajeEquipado{

	
	private Personaje p;
	
	public ArmaduraDeAzorAhai(Personaje p) {
		super(p);
		this.p = p;
	}

	@Override
	public int calcularPuntosDeAtaque() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int calcularPuntosDeDefensa() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int calcularPuntosDeMagia() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void atacar(Peleador victima) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dejarItem() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void despuesDeAtacar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean puedeAtacar() {
		// TODO Auto-generated method stub
		return false;
	}

}
