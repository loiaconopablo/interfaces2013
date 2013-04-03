package plantaszombies;

/**
 * 
 * @author usuario
 */
public class Partida {
	private Jardin jardin;
	private JardinZen jardinZen;

	private Zombie zombieAtacante;
	private Terreno terrenoAAtacar;
	
	public Partida(Jardin jardin, JardinZen jardinZen) { 
		this.jardin = jardin;
		this.jardinZen = jardinZen;
	}
	
	public void atacar() {
		while (this.getZombieAtacante().estaVivo()) {
			if (this.getTerrenoAAtacar().estaVacio()) {
				//throw new UserException("Perdiste el juego!!!");
				System.out.println("El zombie te comio los sesos");
			} else {
				this.atacar(this.getZombieAtacante(), this.terrenoAAtacar.siguiente());
			}
		}
	}

	private void atacar(Zombie unZombie, Planta planta) {
		planta.teAtaca(unZombie);
		unZombie.teAtaca(planta, this);
	}
	
	public void aniadirSemilla() {
		this.getJardinZen().aniadirSemilla();
	}
	
	public void sumarRecursos(int premio) {
		this.getJardin().sumarRecursos(premio);
	}
	
	public JardinZen getJardinZen() {
		return jardinZen;
	}
	
	public Jardin getJardin() {
		return jardin;
	}
	
	public Terreno getTerrenoAAtacar() {
		return terrenoAAtacar;
	}
	
	public void setTerrenoAAtacar(Terreno terrenoAAtacar) {
		this.terrenoAAtacar = terrenoAAtacar;
	}
	
	public Zombie getZombieAtacante() {
		return zombieAtacante;
	}
	
	public void setZombieAtacante(Zombie zombieAtacante) {
		this.zombieAtacante = zombieAtacante;
	}
	
}
