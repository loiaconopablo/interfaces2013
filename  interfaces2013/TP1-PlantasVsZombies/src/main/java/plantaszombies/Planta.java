package plantaszombies;

import org.uqbar.commons.model.UserException;

/**
 * @author Mariano Varela, Pablo Loiacono
 * 
 */

public class Planta {

	private int puntosDeDanio;
	private int capacidadDefensiva;
	private String nombre;
	private Terreno terreno;
	
	public Planta(int puntosDeDanio, int capacidadDefensiva, String nombre,Terreno terreno){
		this.setearCapacidadDefensiva(capacidadDefensiva);
		this.setearPuntosDeDanio(puntosDeDanio);
		this.nombre = nombre;
		this.terreno = terreno;
		}
	

	public Terreno getTerreno() {
		return terreno;
	}
	public void setTerreno(Terreno terreno) {
		this.terreno = terreno;
	}
	public int getPuntosDeDanio() {
		return puntosDeDanio;
	}
	public void setPuntosDeDanio(int puntosDeDanio) {
		this.puntosDeDanio = puntosDeDanio;
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
	
	public void recibirDanio(int ataque) {
		this.setCapacidadDefensiva(this.getCapacidadDefensiva() - ataque);
	}
	
	public void setearPuntosDeDanio(int puntosDeDanio) {
		if (puntosDeDanio < 0 || puntosDeDanio > 100) {
			throw new UserException("Los puntos deben ser entre 0 y 100");
		}
		this.setPuntosDeDanio(puntosDeDanio);
	}

	public void setearCapacidadDefensiva(int capacidadDefensiva) {
		if (capacidadDefensiva <= 0){
			this.setCapacidadDefensiva(1);
		}else{
			if(capacidadDefensiva > 50){
				this.setCapacidadDefensiva(50);
			}else{							
				this.setCapacidadDefensiva(capacidadDefensiva);
			}
		}
		
	}

	public void teAtaca(Zombie unZombie) {
		this.recibirDanio(unZombie.getAtaque());
		if (this.getCapacidadDefensiva() <= 0){
			this.getTerreno().desplantame(this);
		}
	}
}
