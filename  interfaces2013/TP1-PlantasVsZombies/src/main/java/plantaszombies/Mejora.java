package plantaszombies;

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


}
