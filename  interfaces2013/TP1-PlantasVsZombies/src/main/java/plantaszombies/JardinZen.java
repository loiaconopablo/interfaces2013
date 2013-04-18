package plantaszombies;
import java.util.LinkedList;
import java.util.List;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;
/**
 * @author Mariano Varela, Pablo Loiacono
 * 
 */
@Observable
public class JardinZen {

	private List<Semilla> semillasAcuaticas;
	private List<Semilla> semillasTerrestres;
	private List<Semilla> semillasDePremio;
	private Jardin jardin;
	private List<Mejora> mejorasPredefinidas;

	public JardinZen(Jardin jardin) {
		
		this.semillasAcuaticas = new LinkedList<Semilla>(); // no se si es necesaio inicializarla
		this.semillasTerrestres = new LinkedList<Semilla>();// no se si es necesaio inicializarla
		this.setMejorasPredefinidas(new LinkedList<Mejora>());// no se si es necesaio inicializarla
		this.semillasDePremio = new LinkedList<Semilla>();
		this.setJardin(jardin);
		this.prepararJardinZen();
	}
	
	/**
	 * Factory
	 */
	public void prepararJardinZen(){
	
		List<Semilla> acuaticas = new LinkedList<Semilla>();
		acuaticas.add(new Semilla(new TipoTerrenoAcuatico(),"Sea shooter",50,50));
		acuaticas.add(new Semilla(new TipoTerrenoAcuatico(),"Waterprof",80,40));
		List<Semilla> terrestres = new LinkedList<Semilla>();
		terrestres.add(new Semilla(new TipoTerrenoTerrestre(),"Girasol",50,50));
		terrestres.add(new Semilla(new TipoTerrenoTerrestre(),"Jazin",80,40));
	
				
		List<Mejora> mejoras = new LinkedList<Mejora>();
		mejoras.add(new Mejora("Mejora1",20, Tipo.DEFENSIVA, 20));
		mejoras.add(new Mejora("Mejora2",20, Tipo.OFENSIVA, 20));
		mejoras.add(new Mejora("Mejora3",30, Tipo.DEFENSIVA, 30));
		mejoras.add(new Mejora("Mejora4",30, Tipo.OFENSIVA, 30));
		mejoras.add(new Mejora("Mejora5",50, Tipo.DEFENSIVA, 50));
		
		this.semillasAcuaticas = acuaticas;
		this.semillasTerrestres = terrestres;
		this.setMejorasPredefinidas(mejoras);
		
	}

	
		
	
/**Getters y Setter 
 * 
 * @return
 */
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

	public List<Semilla> getSemillas(){
		List<Semilla> todasLasSemillas = new LinkedList<Semilla>(); 
		todasLasSemillas.addAll(this.semillasAcuaticas);
		todasLasSemillas.addAll(this.semillasTerrestres);
		return todasLasSemillas;
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

	public List<Mejora> getMejorasPredefinidas() {
		return mejorasPredefinidas;
	}

	public void setMejorasPredefinidas(List<Mejora> mejorasPredefinidas) {
		this.mejorasPredefinidas = mejorasPredefinidas;
	}
	
	
	
}