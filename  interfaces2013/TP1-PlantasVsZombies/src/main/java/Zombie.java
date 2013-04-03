import java.util.Random;

import org.uqbar.commons.model.UserException;

public class Zombie {
	
//	private Jardin jardin;
// private JardinZen jardinZen;
	private int resistencia;
	private int resistenciaInicial;
	private int ataque;
	private String nombre;

	
	public Zombie(int resistencia, int ataque, String nombre){
		//this.jardin = jardin;
		//this.jardinZen = jardinZen;
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
	
//	public void atacar(Terreno terreno) {
//
//		while (this.estoyVivo()) {
//
//			if (terreno.estaVacio()) {
//				throw new UserException("Perdiste el juego!!!");
//			} else {
//				this.atacarPlanta(terreno, this.getAtaque());
//				this.efectuarAtaqueDePlanta(terreno.siguiente().getPuntosDeDaño());
//			}
//			if (!this.estoyVivo()) { // aca podriamos usar el ! estoyVivo, desp lo vemos
//				if (this.doyPremio()) {
//					if (this.doyPlanta()) {
//						this.getJardinZen().añadirSemilla();
//					}else{
//						this.getJardin().sumarRecursos(this.darPremio());
//					}
//				}
//			}
//		}
//	}

	public int darPremio() {
		return (int)(Math.random()*(((this.getResistenciaInicial()/3)-1))+1);
	}

	public void recibirDanio(int ataque) {
		this.setResistencia(this.getResistencia() - ataque);
	}

	public boolean estaVivo() {
		return this.resistencia > 0;
	}

}
