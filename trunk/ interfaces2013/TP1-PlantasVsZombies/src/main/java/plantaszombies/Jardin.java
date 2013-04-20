package plantaszombies;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

/**
 * @author Mariano Varela, Pablo Loiacono
 * 
 */
@Observable
public class Jardin {

	private int recursos;
	private List<Terreno> filas;
	private List<String> logs = new ArrayList<String>();
	
	public Jardin(int filasAcuaticas, int filasTerrestres){
		this.recursos = 100;
		this.filas = new LinkedList<Terreno>();
		for (int i = 0; i < filasAcuaticas; i++) {
			this.getFilas().add(new Terreno(new TipoTerrenoAcuatico()));
		}
		for (int i = 0; i < filasTerrestres; i++) {
			this.getFilas().add(new Terreno(new TipoTerrenoTerrestre()));
		}
	}
	
	
	/**
	 * Accesors
	 */
	public List<String> getLogs() {
		return logs;
	}

	public void setLogs(List<String> logs) {
		this.logs = logs;
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
	
	public void plantar(int fila, int columna, Semilla semilla){
		List<Terreno> filasTemp = this.filas;
		filasTemp.get(fila).sembrar(semilla, columna,this);
		this.filas = null;
		this.filas = new LinkedList<Terreno>(filasTemp);
	}


	public void actualizarLog(String string) {
		List<String> logsTemp = this.getLogs();
 		logsTemp.add(string);
 		this.logs = null;
 		this.logs = new ArrayList<String>(logsTemp);
		
	}
	

}
