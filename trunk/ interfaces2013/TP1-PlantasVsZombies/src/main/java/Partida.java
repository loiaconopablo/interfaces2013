import java.util.Random;


public class Partida {

	private Zombie zombie;
	private Jardin jardin;
	private Terreno terreno;
	private JardinZen jardinZen;
	
	public JardinZen getJardinZen() {
		return jardinZen;
	}
	public Zombie getZombie() {
		return zombie;
	}
	public Jardin getJardin() {
		return jardin;
	}
	public Terreno getTerreno() {
		return terreno;
	}

	public Partida(Zombie zombie, Jardin jardin,Terreno terreno, JardinZen jardinZen){
		this.jardin = jardin;
		this.zombie = zombie;
		this.jardinZen = jardinZen;
		this.terreno = terreno;
	}
	
	public void jugar(){
		while (this.getZombie().estaVivo()) {
			if (this.getTerreno().estaVacio()) {
				//throw new UserException("Perdiste el juego!!!");
				System.out.println("El zombie te comio los sesos");
			} else {
				Planta siguiente = terreno.siguiente();
				this.efectuarAtaqueZombie(siguiente, this.getZombie().getAtaque());
				this.getZombie().recibirDaño(siguiente.getPuntosDeDaño());
			}
			if (!this.getZombie().estaVivo()) { // aca podriamos usar el ! estoyVivo, desp lo vemos
				if (this.daPremio()) {
					if (this.daPlanta()) {
						this.getJardinZen().añadirSemilla();
					}else{
						this.getJardin().sumarRecursos(this.getZombie().darPremio());
					}
				}
			}
		}
	}

	private void efectuarAtaqueZombie(Planta planta, int ataque) {
		planta.recibirDaño(ataque);
		if(planta.getCapacidadDefensiva()<=0){
			planta.getTerreno().desplantame(planta);
		}
	}
	

	public boolean daPlanta() {
		return (!this.esMayorA(0.25));
	}

	public boolean daPremio() {
		return this.esMayorA(0.5);
	}

	public boolean esMayorA(double numero) {
		Random posibilidad = new Random();
		return posibilidad.nextDouble() >= numero;
	}

}
