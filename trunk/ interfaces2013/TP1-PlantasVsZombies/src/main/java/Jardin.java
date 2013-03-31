import java.util.LinkedList;
import java.util.List;


public class Jardin {

	private int recursos;
	private List<Terreno> filas;
	
	public Jardin(int filasAcuaticas, int filasTerrestres){
		this.recursos = 0;
		this.filas = new LinkedList<Terreno>();
		for (int i = 0; i < filasAcuaticas; i++) {
			this.getFilas().add(new Terreno(new TipoTerrenoAcuatico()));
		}
		for (int i = 0; i < filasTerrestres; i++) {
			this.getFilas().add(new Terreno(new TipoTerrenoTerrestre()));
		}
	}
	
	public int getRecursos() {
		return recursos;
	}

	public void setRecursos(int recursos) {
		this.recursos = recursos;
	}

	public List<Terreno> getFilas() {
		return this.filas;
	}
    public void setFilas(List<Terreno> filas) {
		this.filas = filas;
    }

    public void sumarRecursos(int premio) {
		this.setRecursos(this.getRecursos() + premio);
	}

	public void descontarRecursos(int costo) {
		this.setRecursos(this.getRecursos() - costo);
	}
	
}
