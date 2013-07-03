package plantaszombies;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

/**
 * @author Mariano Varela, Pablo Loiacono
 * 
 */
@Observable
public class Jardin {

	private int recursos;
	private List<Terreno> filas;
	
	private List<Terreno> terrenosAcuaticos;

	private List<Terreno> terrenosTerrestres;
	
	
	public Jardin(int filasAcuaticas, int filasTerrestres){
		this.recursos = 100;
		this.filas = new LinkedList<Terreno>();
		for (int i = 0; i < filasAcuaticas; i++) {
			this.getFilas().add(new Terreno(new TipoTerrenoAcuatico()));
		}
		for (int i = 0; i < filasTerrestres; i++) {
			this.getFilas().add(new Terreno(new TipoTerrenoTerrestre()));
		
			
			// Para Wicket!!
		this.terrenosTerrestres = new LinkedList<Terreno>();
			for (int b = 0; b < filasTerrestres; b++) {
				this.getTerrenosTerrestres().add(new Terreno(new TipoTerrenoTerrestre()));
			}
		this.terrenosAcuaticos = new LinkedList<Terreno>();
			for (int a = 0; a < filasAcuaticas; a++) {
				this.getTerrenosAcuaticos().add(new Terreno(new TipoTerrenoAcuatico()));
			}

		
		}
		
	}
	
	public void sumarRecursos(int premio) {
		this.setRecursos(this.getRecursos() + premio);
	}
	
	public void descontarRecursos(int costo) {
		if (this.getRecursos()==0){throw new UserException("No tienes mas recusos disponibles");}
		
		if ((this.getRecursos() - costo)<0) {
			throw new UserException("No tienes suficientes recursos para comprar la mejora");
		}
		else {
			this.setRecursos(this.getRecursos() - costo);
		}
	}
	
	public void plantar(int fila, int columna, Semilla semilla){
		if(fila > this.filas.size() - 1){
			throw new UserException("No hay tantas filas en el tablero");
		}
		List<Terreno> filasTemp = this.filas;
		filasTemp.get(fila).sembrar(semilla, columna,this);
		this.filas = null;
		this.filas = new LinkedList<Terreno>(filasTemp);
	}
	
	
	//Plantar que se utiliza en WICKET
	public void plantarWicket(int fila, int columna, Semilla semilla){
		if(fila > this.filas.size() - 1){
			throw new UserException("No hay tantas filas en el tablero");
		}
		this.getTerrenoAPlantar(fila).sembrar(semilla, columna, this);
	}
	
	protected Terreno getTerrenoAPlantar(int fila) {
		int limite = this.getTerrenosTerrestres().size();
		if (fila < limite){
			return this.terrenosTerrestres.get(fila);
		}
		else {
			return this.terrenosAcuaticos.get(fila - limite);
		}
	}

	/**
	 * Accesors
	 */
	
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

	
//	SETTERS Y GETTERS
	public List<Terreno> getTerrenosAcuaticos() {
		return terrenosAcuaticos;	}
		
	public List<Terreno> getTerrenosTerrestres() {
		return terrenosTerrestres;	}
		
	public void setTerrenosTerrestres(List<Terreno> terrenosTerrestres) {
		this.terrenosTerrestres = terrenosTerrestres;}
		
	public void setTerrenosAcuaticos(List<Terreno> terrenosAcuaticos) {
		this.terrenosAcuaticos = terrenosAcuaticos;}
}
