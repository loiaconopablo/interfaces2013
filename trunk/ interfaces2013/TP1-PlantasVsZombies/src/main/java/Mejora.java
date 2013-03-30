
public class Mejora {
	
	private String nombre;
	private int costo;
	private Tipo tipo;
	
	public int getCosto() {
		return costo;
	}
	
	public Tipo getTipo() {
		return tipo;
	}

	public Mejora(String nombre, int costo, Tipo tipo){
		this.nombre = nombre;
		this.costo = costo;
		this.tipo = tipo;
	}

}
