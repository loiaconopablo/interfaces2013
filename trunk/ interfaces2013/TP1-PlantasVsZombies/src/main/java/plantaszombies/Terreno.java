package plantaszombies;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

/**
 * @author Mariano Varela, Pablo Loiacono
 * 
 */
@Observable
public class Terreno {

	private TipoTerreno tipoTerreno;
	private List<Planta> plantas;

	public Terreno(TipoTerreno terreno) {// Agregue que se le pase el tipo de
		this.plantas = new ArrayList<Planta>(5); // Terreno
		this.tipoTerreno = terreno;
		for (int i = 0; i < 5; i++) {
			this.getPlantas().add(i,null);
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
		for (Planta planta : this.getPlantas()) {
			if (planta == null) {
				estaVacio = estaVacio && true;
			} else {
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

	
	public void sembrar(Semilla semilla, int casillero, Jardin jardin) {
		if (casillero > 4){
			throw new UserException("El terreno no es tan grande");
		}
		if (!this.estaLibre(casillero)) {
			throw new UserException("Esta ocupado el casillero");
		}
		if (!this.puedePlantarseAca(semilla)) {
			throw new UserException(
					"No se puede plantar esta planta ese terreno");
		}
		this.aniadirEn(semilla, casillero, jardin);
	}

	public void aniadirEn(Semilla semilla, int casillero, Jardin jardin) {
		this.getPlantas().add(casillero, semilla.sembrar(this));
	}
	
	
	protected boolean puedePlantarseAca(Semilla semilla) {
		return (semilla.esAcuatica() && this.esAcuatico())
				|| (semilla.esTerrestre() && this.esTerrestre());
	}

	/**
	 * Accesors
	 */

	public String getTipoTerrenoToString() {
		if (this.esAcuatico()) {
			return "Acuatico";
		}
		return "Terrestre";
	}

	public Planta getPrimero() {
		return this.plantas.get(0);
	}

	public Planta getSegundo() {
		return this.plantas.get(1);
	}

	public Planta getTercero() {
		return this.plantas.get(2);
	}

	public Planta getCuarto() {
		return this.plantas.get(3);
	}

	public Planta getQuinto() {
		return this.plantas.get(4);
	}

	public String getPlanta(int casillero){
		if (this.plantas.get(casillero) != null) {
			return this.plantas.get(casillero).toString();
		}
		return "";
	}
}
