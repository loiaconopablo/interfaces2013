import java.util.LinkedList;
import java.util.List;

public class Terreno {

	private TipoTerreno tipoTerreno;
	private List<Planta> plantas;

	public Terreno(TipoTerreno terreno) {// Agregue que se le pase el tipo de
		this.plantas = new LinkedList();									// Terreno
		this.tipoTerreno = terreno;
		for (int i = 0; i < 5; i++) {
			this.getPlantas().add(null);
		}
	}

	public TipoTerreno getTipoTerreno() {
		return tipoTerreno;
	}
	
	public List<Planta> getPlantas() {
		return this.plantas;
	}


	/*
	 * Siempre retorna una planta ya que antes de llamar a este metodo pregunta
	 * si el terreno tiene alguna planta con el metodo estaVacio()
	 */
	public Planta siguiente() {
		int casillero = 4;
		boolean encontrePlanta = false;
		Planta siguientePlanta = null;
		while (!encontrePlanta) {
			if (estaLibre(casillero)) { // Agregue este IF que faltaba, pregunta
				casillero--;
			} else {
				encontrePlanta = true;
				siguientePlanta = this.getPlantas().get(casillero);
			}
		}
		return siguientePlanta;
	}

	public boolean estaVacio() {
		boolean estaVacio = true;
		for(Planta planta: this.getPlantas()){
			if (planta == null){
				estaVacio = estaVacio && true;
			}
			else{
				estaVacio = estaVacio && false;
			}
		}
		return estaVacio;
	}

	public void desplantame(Planta planta) {
		this.getPlantas().remove(planta);
	}

	public boolean esAcuatico() {
		return this.getTipoTerreno().esAcuatica();
	}

	public boolean esTerrestre() {
		return this.getTipoTerreno().esTerrestre();
	}

	public boolean estaLibre(int casillero) {
		return (this.getPlantas().get(casillero) == null);
	}

	public void añadirEn(Semilla semilla, int casillero) {
		this.getPlantas().add(casillero, semilla.sembrar(this));
	}
	
}
