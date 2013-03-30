import java.util.LinkedList;
import java.util.List;


public class Semilla {
	
	private TipoTerreno tipoTerreno;
	private String nombre;
	private int puntosDeDaño;
	private int capacidadDefensiva;
	private List<Mejora> mejorasAplicadas;
	
	public Semilla(TipoTerreno terreno, String nombre, int puntosDeDaño, int capacidadDefensiva){
		this.tipoTerreno = terreno;
		this.nombre = nombre;
		this.puntosDeDaño = puntosDeDaño;
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
	
	public int getPuntosDeDaño() {
		return puntosDeDaño;
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
		Planta planta = new Planta(this.definirPuntosDeDaño(), this.definirCapacidadDefensiva(),this.nombre, terreno);
		return planta;
	}
	
	public int definirCapacidadDefensiva() {
		int capacidad = this.capacidadDefensiva;
		for(Mejora mejora : this.mejorasAplicadas){
			if (mejora.getTipo() == Tipo.Defensiva){
				capacidad += mejora.getCosto();
			}
		}
		return capacidad;
	}


	public int definirPuntosDeDaño() {
		int daño = this.puntosDeDaño;
		for(Mejora mejora : this.mejorasAplicadas){
			if (mejora.getTipo() == Tipo.Ofensiva){
				daño += mejora.getCosto();
			}
		}
		return daño;	
	}


	//cambie el parametro, ahora le pasa una mejora
	public void aplicarMejora (Mejora mejora) {
		this.mejorasAplicadas.add(mejora);
	}
	
	
	
	
}
