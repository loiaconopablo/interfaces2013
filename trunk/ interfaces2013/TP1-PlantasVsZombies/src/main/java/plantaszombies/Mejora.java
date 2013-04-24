package plantaszombies;

import org.uqbar.commons.utils.Observable;

/**
 * @author Mariano Varela, Pablo Loiacono
 * 
 */

@Observable
public class Mejora {
	
	private String nombre;
	private int costo;
	private Tipo tipo;
	private int porcDeMejora;
	
	public Mejora(String nombre, int costo, Tipo tipo, int mejora){
		this.nombre = nombre;
		this.costo = costo;
		this.tipo = tipo;
		this.porcDeMejora = mejora;
	}

	
	public int getCosto() {
		return costo;
	}
	
	public Tipo getTipo() {
		return tipo;
	}

	public int getporcDeMejora() {
		return porcDeMejora;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setCosto(int costo) {
		this.costo = costo;
	}
	
	public void aplicarMejora(Planta planta) {
		this.getTipo().aplicarMejora(planta, this.getporcDeMejora());
	}


}
