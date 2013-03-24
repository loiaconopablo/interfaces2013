import java.util.List;

public class Terreno {

	private TipoTerreno tipoTerreno;
	private List<Planta> plantas;

	public Terreno() {
		for (int i = 0; i < 5; i++) {
			this.getPlantas().add(null);
		}
	}

	
    public TipoTerreno getTipoTerreno() {
		return tipoTerreno;
	}


	public void setTipoTerreno(TipoTerreno tipoTerreno) {
		this.tipoTerreno = tipoTerreno;
	}


	public List<Planta> getPlantas() {
		return this.plantas;
	}
    public void setPlantas(List<Planta> plantas) {
		this.plantas = plantas;
	}

	/*
	 * Siempre retorna una planta ya que antes de llamar a este
	 * metodo pregunta si el terreno tiene alguna planta con el metodo 
	 * estaVacio()
	 */
	public Planta siguiente(){
		int casillero = 4;
		boolean encontrePlanta = false;
		Planta siguientePlanta = null;
		while(! encontrePlanta){
			encontrePlanta= true;
			siguientePlanta= this.getPlantas().get(casillero);
		}
		return siguientePlanta;
	}

	public boolean estaVacio() {
		return plantas.isEmpty();
	}

	public void desplantame(Planta planta) {
		this.getPlantas().remove(planta);
	}

	public boolean esAcuatico(){
		return this.getTipoTerreno().esAcuatica();
	}
	
	public boolean esTerrestre(){
		return this.getTipoTerreno().esTerrestre();
	}
}
