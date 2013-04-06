package plantaszombies;

/**
 * @author Mariano Varela, Pablo Loiacono
 * 
 */

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


	public void aplicarMejora(Planta planta) {
		if(this.getTipo().equals(Tipo.DEFENSIVA)){
			planta.setCapacidadDefensiva(this.getporcDeMejora() + planta.getCapacidadDefensiva());
		}
		else{
			planta.setPuntosDeDanio(this.getporcDeMejora() + planta.getPuntosDeDanio());
		}
		
	}


}
