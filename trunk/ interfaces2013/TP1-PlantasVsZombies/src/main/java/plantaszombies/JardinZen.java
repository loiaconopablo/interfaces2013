package plantaszombies;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.collections15.ComparatorUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.CompareToBuilder;
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
		acuaticas.add(new Semilla(new TipoTerrenoAcuatico(),"Cachalote",70,30));
		acuaticas.add(new Semilla(new TipoTerrenoAcuatico(),"Lily Pad",100,50));
		acuaticas.add(new Semilla(new TipoTerrenoAcuatico(),"Umbrella Leaf",40,20));
		List<Semilla> terrestres = new LinkedList<Semilla>();
		terrestres.add(new Semilla(new TipoTerrenoTerrestre(),"Girasol",50,50));
		terrestres.add(new Semilla(new TipoTerrenoTerrestre(),"Jazin",80,25));
		terrestres.add(new Semilla(new TipoTerrenoTerrestre(),"Lanzaguisantes",100,50));
		terrestres.add(new Semilla(new TipoTerrenoTerrestre(),"Petacereza",75,20));
		terrestres.add(new Semilla(new TipoTerrenoTerrestre(),"Patapum",90,50));
		terrestres.add(new Semilla(new TipoTerrenoTerrestre(),"Carnívora",100,30));
	
	
		List<Mejora> mejoras = new LinkedList<Mejora>();
		mejoras.add(new Mejora("Aumenta en 20 su poder Defensivo",30, Tipo.DEFENSIVA, 20));
		mejoras.add(new Mejora("Aumenta en 20 su poder Ofensivo",10, Tipo.OFENSIVA, 20));
		mejoras.add(new Mejora("Aumenta en 40 su poder Defensivo",30, Tipo.DEFENSIVA, 40));
		mejoras.add(new Mejora("Aumenta en 30 su poder Ofensivo",30, Tipo.OFENSIVA, 30));
		mejoras.add(new Mejora("Aumenta en 70 su poder Defensivo",50, Tipo.DEFENSIVA, 70));
		mejoras.add(new Mejora("Aumenta en 25 su poder Ofensivo",25, Tipo.OFENSIVA, 25));
		mejoras.add(new Mejora("Aumenta en 10 su poder Defensivo",5, Tipo.DEFENSIVA, 10));
		
		
		List <Semilla> semillasDePremio = new LinkedList <Semilla>();
		semillasDePremio.add(new Semilla(new TipoTerrenoTerrestre(),"Premio1",75,20));
		semillasDePremio.add(new Semilla(new TipoTerrenoTerrestre(),"Premio2",90,50));
		semillasDePremio.add(new Semilla(new TipoTerrenoTerrestre(),"Premio3",100,30));
		
		
		this.semillasAcuaticas = acuaticas;
		this.semillasTerrestres = terrestres;
		this.setMejorasPredefinidas(mejoras);
		this.setSemillasDePremio(semillasDePremio);
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
	/**
	 * Metodos
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
				.get((int) (Math.random() * (this.getSemillasDePremio().size()-1)) + 1);
	}

	
	public void sembrarEn(Semilla semilla, Terreno terreno, int casillero) {
		terreno.sembrar(semilla, casillero,jardin);
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

public List <Semilla> buscarEnAcuatica(String nombre){
	return this.search(nombre,this.semillasAcuaticas);
	}

public List <Semilla> buscarEnTerrestre(String nombre){
	return this.search(nombre,this.semillasTerrestres);
	}
	
	
	public List<Semilla> search(String nombre, List<Semilla> semillas) {
		List<Semilla> resultados = new LinkedList<Semilla>();

		for (Semilla semilla : semillas) {
			if (match(nombre, semilla.getNombre())) {
				resultados.add(semilla);
			}
		}
		return resultados;
	}

	protected boolean match(Object expectedValue, Object realValue) {
		return expectedValue == null
			|| realValue.toString().toLowerCase().contains(expectedValue.toString().toLowerCase());
	}
	public List<Semilla> buscarEnTerrestre(String nombre, String ordenadoPor) {
		List<Semilla> semillas = this.buscarEnTerrestre(nombre);
		if (!StringUtils.isBlank(ordenadoPor)) {
			Collections.sort(semillas, crearComparator(ordenadoPor));
		}
		return semillas;
	}
	
	public List<Semilla> ordenarSemillasSelectPor(List <Semilla> semillasSelect, String ordenadoPor) {
		List<Semilla> semillas = semillasSelect;
		if (!StringUtils.isBlank(ordenadoPor)) {
			Collections.sort(semillas, crearComparator(ordenadoPor));
		}
		return semillas;
	}
	
	private Comparator<? super Semilla> crearComparator(String ordenadoPor) {
		if (ordenadoPor.equals("danio")) {
			return new Comparator<Semilla>() {
				public int compare(Semilla semilla1, Semilla semilla2) {
					return semilla1.getPuntosDeDanio() - semilla2.getPuntosDeDanio();
				}
			};
		}
		if (ordenadoPor.equals("nombre")) {
			return new Comparator<Semilla>() {
				public int compare(Semilla semilla1, Semilla semilla2) {
					return 	semilla1.getNombre().compareTo(semilla2.getNombre());
				}
			};
		}
		if (ordenadoPor.equals("capacidadDefensiva")) {
			return new Comparator<Semilla>() {
				public int compare(Semilla semilla1, Semilla semilla2) {
					return semilla1.getCapacidadDefensiva() - semilla2.getCapacidadDefensiva();
				}
			};
		}
		throw new UnsupportedOperationException("No implementado");
	}
	
	public Semilla buscarSemillaPorNombre(String semillaNombre){
		Semilla result = null;
		List <Semilla> unidas = this.semillasAcuaticas;
		unidas.addAll(this.getSemillasTerrestres());
		while ( result == null)
			{for (Semilla sem: unidas)
					if (sem.getNombre() == semillaNombre)
					{result = sem;}
			}
			return result;
	
		}
		
	
	
}
