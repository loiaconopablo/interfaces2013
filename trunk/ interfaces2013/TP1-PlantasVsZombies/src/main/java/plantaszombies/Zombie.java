package plantaszombies;
import java.util.Random;

import org.uqbar.commons.model.UserException;

/**
 * @author Mariano Varela, Pablo Loiacono
 * 
 */

public class Zombie {
	private int resistencia;
	private int resistenciaInicial;
	private int ataque;
	private String nombre;

	
	public Zombie(int resistencia, int ataque, String nombre){
		this.nombre = nombre;
		this.setearResistencia(resistencia);
		this.setearAtaque(ataque);
	}

	public int getResistencia() {
		return resistencia;
	}

	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getResistenciaInicial() {
		return resistenciaInicial;
	}

	public void setResistenciaInicial(int resistenciaInicial) {
		this.resistenciaInicial = resistenciaInicial;
	}
	
	private void setearAtaque(int ataque) {
		if (ataque < 10){
			this.setAtaque(10);
		}else{
			if(ataque > 100){
				this.setAtaque(100);
			}else{
				this.setAtaque(ataque);
			}
		}
		
	}

	private void setearResistencia(int resistencia) {
		if (resistencia < 50){
			this.setResistencia(50);
			this.setResistenciaInicial(50);
		}else{
			if(resistencia > 100){
				this.setResistencia(100);
				this.setResistenciaInicial(100);
			}else{
				this.setResistencia(resistencia);
				this.setResistenciaInicial(resistencia);
			}
		}
		
	}
	
	public int darPremio() {
		return (int)(Math.random()*(((this.getResistenciaInicial()/3)-1))+1);
	}

	public void recibirDanio(int ataque) {
		this.setResistencia(this.getResistencia() - ataque);
	}

	public boolean estaVivo() {
		return this.resistencia > 0;
	}

	public void teAtaca(Planta planta, Partida partida) {
		this.recibirDanio(planta.getPuntosDeDanio());
		if (!this.estaVivo()) { 
			if (daPremio()) {
				if (daPlanta()) {
					partida.aniadirSemilla();
				} else {
					partida.sumarRecursos(this.darPremio());
				}
			}
		}
	}

	public boolean daPlanta() {
		return (!randomEsMayorA(0.25));
	}

	public boolean daPremio() {
		return randomEsMayorA(0.5);
	}

	public static boolean randomEsMayorA(double numero) {
		Random posibilidad = new Random();
		return posibilidad.nextDouble() >= numero;
	}
	
}
