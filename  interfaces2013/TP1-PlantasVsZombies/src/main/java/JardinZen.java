import java.util.LinkedList;
import java.util.List;

import org.uqbar.commons.model.UserException;

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
		Semilla premio = this
				.getSemillasDePremio()
				.get((int) (Math.random() * (((this.getSemillasDePremio().size()-1)) - 0)) + 0);
		if (premio.esAcuatica()) {
			if (this.getSemillasAcuaticas().size() < 20) {
				this.getSemillasAcuaticas().add(premio);
			} else {
				throw new RuntimeException(
						"Ya hay demasiadas semillasAcuaticas");
			}

		} else {
			if (this.getSemillasTerrestres().size() < 20) {
				this.getSemillasTerrestres().add(premio);
			} else {
				throw new RuntimeException(
						"Ya hay demasiadas semillas terrestres");
			}
		}
	}

	
	public void sembrarEn(Semilla semilla, Terreno terreno, int casillero) {
		if ((semilla.esAcuatica() && terreno.esAcuatico())
				|| (semilla.esTerrestre() && terreno.esTerrestre())) {
			if (terreno.estaLibre(casillero)) {
				terreno.aniadirEn(semilla, casillero);
			} else {
				throw new UserException("Esta ocupado el casillero");
			}
		} else {
			throw new UserException(
					"No se puede plantar esta planta ese terreno");
		}
	}

	public void mejorarA(Semilla semilla, Mejora mejora){
		semilla.aplicarMejora(mejora);
		this.getJardin().descontarRecursos(mejora.getCosto());
	}
	
	
	/*
	 * En este metodo mejorarA despues me ayudas a ver como hacemos para
	 * descontar el costo, tendria que conocer al jardin, y decirle,
	 * descontar(costo) o algo asi.
	 */
/**
	public void mejorarA(Semilla semillaAmejorar, int tipoMejora) {// esto vemos
																	// si lo
																	// hacemo
																	// asi o
		int mejora;
		int costo;
		boolean defensa;

		switch (tipoMejora) {
		case 1:
			mejora = 20;
			defensa = true;
			costo = 50;
			break;
		case 2:
			mejora = 20;
			defensa = false;
			costo = 50;
			break;
		case 3:
			mejora = 35;
			defensa = true;
			costo = 100;
			break;
		case 4:
			mejora = 35;
			defensa = false;
			costo = 100;
			break;
		default:
			throw new UserException("Tipo de mejora invalida");
		}
		/*
		 * Primero recorre la lista de semillas acuaticas haber si la encuentra
		 * ahi y sino recorre la de terrestres
		 */
	/**
		for (Semilla semilla : semillasAcuaticas)// o que el parametro sea
													// un string
		{
			if (semilla.getNombre().equals(semillaAmejorar.getNombre())) {
				if (defensa) {
					semilla.aplicarMejoraDefensiva(mejora);
					this.getJardin().descontarRecursos(costo);
				} else {
					semilla.aplicarMejoraOfensiva(mejora);
				}
			}
		}

		for (Semilla semilla : semillasTerrestres)// o que el parametro sea
													// un string
		{
			if (semilla.getNombre().equals(semillaAmejorar.getNombre())) {
				if (defensa) {
					semilla.aplicarMejoraDefensiva(mejora);
				} else {
					semilla.aplicarMejoraOfensiva(mejora);
				}
			}

		}
	}
**/
}
