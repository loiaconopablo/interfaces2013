package plantaszombies;
import java.util.LinkedList;
import java.util.List;

import org.uqbar.commons.model.UserException;
/**
 * @author Mariano Varela, Pablo Loiacono
 * 
 */
public class JardinZen {

	private List<Semilla> semillasAcuaticas;
	private List<Semilla> semillasTerrestres;
	private List<Semilla> semillasDePremio;
	private Jardin jardin;
	private List<Mejora> mejoras;

	public JardinZen(Jardin jardin, List<Mejora> mejoras) {
		this.semillasAcuaticas = new LinkedList<Semilla>();
		this.semillasTerrestres = new LinkedList<Semilla>();
		this.semillasDePremio = new LinkedList<Semilla>();
		this.setJardin(jardin);
		this.mejoras = mejoras;
	}

	public void setJardin(Jardin jardin) {
		this.jardin = jardin;
	}

	public Jardin getJardin() {
		return jardin;
	}

	public List<Semilla> getSemillasAcuaticas() {
		return semillasAcuaticas;
	}

	public void setSemillasAcuaticas(List<Semilla> semillasAcuaticas) {
		this.semillasAcuaticas = semillasAcuaticas;
	}

	public List<Semilla> getSemillasTerrestres() {
		return semillasTerrestres;
	}

	public void setSemillasTerrestres(List<Semilla> semillasTerrestres) {
		this.semillasTerrestres = semillasTerrestres;
	}

	public List<Semilla> getSemillasDePremio() {
		return semillasDePremio;
	}

	public void setSemillasDePremio(List<Semilla> semillasDePremio) {
		this.semillasDePremio = semillasDePremio;
	}

	/*
	 * Haceme acordar que veamos este a�adirSemilla, as� me lo explicas je se
	 * que te basaste en el plataPremio= Plantas [ramdom(0,plantas.size-1)] pero
	 * mucho no lo entiendo xq pusiste -0 y despues +0
	 */
	public void aniadirSemilla() {
		Semilla premio = this.getSemillaRandom();
		if (premio.esAcuatica()) {
			if (this.getSemillasAcuaticas().size() < 20) {
				this.getSemillasAcuaticas().add(premio);
			} else {
				throw new UserException("Ya hay demasiadas semillas Acuaticas");
			}
		} else {
			if (this.getSemillasTerrestres().size() < 20) {
				this.getSemillasTerrestres().add(premio);
			} else {
				throw new UserException("Ya hay demasiadas semillas terrestres");
			}
		}
	}

	protected Semilla getSemillaRandom() {
//		return CollectionUtils.randomElement(this.getSemillasDePremio());
		return this.getSemillasDePremio()
				.get((int) (Math.random() * (((this.getSemillasDePremio().size()-1)) - 0)) + 0);
	}

	
	public void sembrarEn(Semilla semilla, Terreno terreno, int casillero) {
		terreno.sembrar(semilla, casillero);
	}

	public void mejorarA(Semilla semilla, Mejora mejora){
		semilla.aplicarMejora(mejora);
		this.getJardin().descontarRecursos(mejora.getCosto());
	}
	
	
	
}
