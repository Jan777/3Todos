package dominio;

public class PersonajeEquipado extends Personaje {

	protected Personaje personajeDecorado;
	protected int prioridad;
	
	public PersonajeEquipado(Personaje personajeDecorado) {
		super(personajeDecorado);
		this.personajeDecorado = personajeDecorado;
	}

	@Override
	protected boolean puedeAtacar() {
		return personajeDecorado.puedeAtacar();
	}

	@Override
	public int calcularPuntosDeAtaque() {
		return this.personajeDecorado.calcularPuntosDeAtaque();
	}


	@Override
	public int calcularPuntosDeDefensa() {
		return this.personajeDecorado.calcularPuntosDeDefensa();
	}

	@Override
	public int calcularPuntosDeMagia() {
		return this.personajeDecorado.calcularPuntosDeMagia();
	}

	@Override
	public void atacar(Peleador victima) {
		this.atacar(victima);		
	}

	@Override
	public PersonajeEquipado dejarItem() {
		this.personajeDecorado.lista.remove(this);
		return (PersonajeEquipado) personajeDecorado;	
	}

	@Override
	public String getRaza() {
		return personajeDecorado.getRaza();
	}
	
	public void equipar(){
		this.personajeDecorado.lista.add(this);
	}
	

	public int getPrioridad() {
		return this.prioridad;
	}

	/* Este método no está testeado*/
	public PersonajeEquipado dejarMejorItem(){
		this.lista.remove(getItemMasPrioritario());
		return this.dejarItem();
		 
	}
	
	
}

	

