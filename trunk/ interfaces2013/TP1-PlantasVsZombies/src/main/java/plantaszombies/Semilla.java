package plantaszombies;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Mariano Varela, Pablo Loiacono
 * 
 */

public class Semilla {
	
	private TipoTerreno tipoTerreno;
	private String nombre;
	private int puntosDeDanio;
	private int capacidadDefensiva;
	private List<Mejora> mejorasAplicadas;
	
	public Semilla(TipoTerreno terreno, String nombre, int puntosDeDanio, int capacidadDefensiva){
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
		return new Planta(this.definirPuntosDeDanio(), this.definirCapacidadDefensiva(),this.nombre, terreno);
	}
	
	public int definirCapacidadDefensiva() {
		int capacidad = this.capacidadDefensiva;
		for (Mejora mejora : this.mejorasAplicadas){
			if (mejora.getTipo() == Tipo.DEFENSIVA){
				//capacidad+= mejora.getCosto(); esto lo cambie
				capacidad = (((capacidad *mejora.getporcDeMejora())/100)+capacidad)  ;//ESTo lo cambie
			}
		}
		return capacidad;
	}


	public int definirPuntosDeDanio() {
		int danio = this.puntosDeDanio;
		for(Mejora mejora : this.mejorasAplicadas){
			if (mejora.getTipo() == Tipo.OFENSIVA){
				//danio += mejora.getCosto();
				danio = (((danio *mejora.getporcDeMejora())/100)+danio)  ;//ESTo lo cambie
			}
		}
		return danio;	
	}


	//cambie el parametro, ahora le pasa una mejora
	public void aplicarMejora (Mejora mejora) {
		this.mejorasAplicadas.add(mejora);
	}
	
}
