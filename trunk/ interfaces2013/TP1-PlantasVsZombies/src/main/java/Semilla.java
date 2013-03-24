
public class Semilla {
	
	private TipoTerreno tipoTerreno;
	private String nombre;
	private int puntosDeDaño;
	private int capacidadDefensiva;
	public TipoTerreno getTipoTerreno() {
		return tipoTerreno;
	}
	public void setTipoTerreno(TipoTerreno tipoTerreno) {
		this.tipoTerreno = tipoTerreno;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPuntosDeDaño() {
		return puntosDeDaño;
	}
	public void setPuntosDeDaño(int puntosDeDaño) {
		this.puntosDeDaño = puntosDeDaño;
	}
	public int getCapacidadDefensiva() {
		return capacidadDefensiva;
	}
	public void setCapacidadDefensiva(int capacidadDefensiva) {
		this.capacidadDefensiva = capacidadDefensiva;
	}
	
	public boolean esAcuatica() {
		return this.getTipoTerreno().esAcuatica();
	}
	
	public boolean esTerrestre() {
		return this.getTipoTerreno().esTerrestre();
	}
	
	
}
