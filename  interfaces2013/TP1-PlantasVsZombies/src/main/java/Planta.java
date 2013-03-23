
public class Planta {

	private int puntosDeDaño;
	private int capacidadDefensiva;
	private String nombre;
	private Terreno terreno;
	
	public Planta(int puntosDeDaño, int capacidadDefensiva, String nombre,Terreno terreno){
		this.capacidadDefensiva = capacidadDefensiva;
		this.puntosDeDaño = puntosDeDaño;
		this.nombre = nombre;
		this.terreno = terreno;
	}
	
	public Terreno getTerreno() {
		return terreno;
	}
	public void setTerreno(Terreno terreno) {
		this.terreno = terreno;
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void meAtaco(int ataque,Terreno terreno) {
		
		this.setCapacidadDefensiva(this.getCapacidadDefensiva() - ataque);
		if(this.capacidadDefensiva <= 0){
			terreno.desplantame(this);
			
		}
	}
}
