
public class Jardin {

	private int recursos;
	private List <Terreno> filas;
	
	public int getRecursos() {
		return recursos;
	}

	public void setRecursos(int recursos) {
		this.recursos = recursos;
	}

	public void sumarRecursos(int premio) {
		this.setRecursos(this.getRecursos() + premio);
	}

	public List<Terreno> getFilas() {
		return this.filas;
	}
    public void setFilas(List<Terreno> filas) {
		this.filas = filas;

	
}
