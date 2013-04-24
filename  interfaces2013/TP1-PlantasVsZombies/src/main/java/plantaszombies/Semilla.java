package plantaszombies;

import java.util.LinkedList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

/**
 * @author Mariano Varela, Pablo Loiacono
 * 
 */
@Observable
public class Semilla {

	private TipoTerreno tipoTerreno;
	private String nombre;
	private int puntosDeDanio;
	private int capacidadDefensiva;
	private List<Mejora> mejorasAplicadas;

	public Semilla(TipoTerreno terreno, String nombre, int puntosDeDanio,
			int capacidadDefensiva) {
		this.tipoTerreno = terreno;
		this.nombre = nombre;
		this.puntosDeDanio = puntosDeDanio;
		this.capacidadDefensiva = capacidadDefensiva;
		this.mejorasAplicadas = new LinkedList<Mejora>();
	}

	public List<Mejora> getMejorasAplicadas() {
		return mejorasAplicadas;
	}

	public TipoTerreno getTipoTerreno() {
		return tipoTerreno;
	}

	public void setTipoTerreno(TipoTerreno tipoTerreno) {
		this.tipoTerreno = tipoTerreno;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPuntosDeDanio() {
		return puntosDeDanio;
	}

	public int getCapacidadDefensiva() {
		return capacidadDefensiva;
	}

	public boolean esAcuatica() {
		return this.getTipoTerreno().esAcuatica();
	}

	public boolean esTerrestre() {
		return this.getTipoTerreno().esTerrestre();
	}

	public Planta sembrar(Terreno terreno) {
		Planta nueva = new Planta(this.getPuntosDeDanio(),
				this.getCapacidadDefensiva(), this.nombre, terreno);
		this.agregarMejoras(nueva);
		return nueva;
	}

	private void agregarMejoras(Planta planta) {
		for (Mejora mejora : this.mejorasAplicadas) {
			mejora.aplicarMejora(planta);
		}
	}

	// cambie el parametro, ahora le pasa una mejora
	public void aplicarMejora(Mejora mejora) {
		this.mejorasAplicadas.add(mejora);
	}

}
