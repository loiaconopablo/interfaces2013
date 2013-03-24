import java.util.Random;

import org.uqbar.commons.model.UserException;

public class Zombie {
	
	private Jardin jardin;
	private JardinZen jardinZen;
	private int resistencia;
	private int resistenciaInicial;
	private int ataque;
	private String nombre;

	
	public Jardin getJardin() {
		return jardin;
	}

	public void setJardin(Jardin jardin) {
		this.jardin = jardin;
	}

	public JardinZen getJardinZen() {
		return jardinZen;
	}

	public void setJardinZen(JardinZen jardinZen) {
		this.jardinZen = jardinZen;
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

	public void atacar(Terreno terreno) {

		while (this.estoyVivo()) {

			if (terreno.estaVacio()) {
				throw new UserException("Perdiste el juego!!!");
			} else {
				this.atacarPlanta(terreno, this.getAtaque());
				this.meAtaco(terreno.siguiente().getPuntosDeDaño());
			}
			if (this.estoyMuerto()) { // aca podriamos usar el ! estoyVivo, desp lo vemos
				if (this.doyPremio()) {
					if (this.doyPlanta()) {
						this.getJardinZen().añadirSemilla();
					}else{
						this.getJardin().sumarRecursos(this.darPremio());
					}
				}
			}
		}
	}

	private int darPremio() {
		return (int)(Math.random()*(((this.getResistenciaInicial()-1)/3)-1))+1;
	}

	private boolean doyPlanta() {
		return (!this.esMayorA(0.25));
	}

	public boolean doyPremio() {
		return this.esMayorA(0.5);
	}

	public boolean esMayorA(double numero) {
		Random posibilidad = new Random();
		return posibilidad.nextDouble() >= numero;
	}

	public boolean estoyMuerto() {
		return this.getResistencia() <= 0;
	}

	private void meAtaco(int ataque) {
		this.setResistencia(this.getResistencia() - ataque);
	}

	private boolean estoyVivo() {
		return this.resistencia > 0;
	}

	private void atacarPlanta(Terreno terreno, int ataque) {
		terreno.siguiente().meAtaco(ataque, terreno);
	}

}
