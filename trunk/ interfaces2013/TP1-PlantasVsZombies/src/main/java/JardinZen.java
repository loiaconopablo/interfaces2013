import java.util.List;

import org.uqbar.commons.model.UserException;


public class JardinZen {

	private List<Semilla> semillasAcuaticas;
	private List<Semilla> semillasTerrestres;
	private List<Semilla> semillasDePremio;
	
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
	 * Haceme acordar que veamos este a�adirSemilla, as� me lo explicas je
	 * se que te basaste en el plataPremio= Plantas [ramdom(0,plantas.size-1)]
	 * pero mucho no lo entiendo xq pusiste -0 y despues +0
	 */
	public void añadirSemilla() {
		Semilla premio = this.getSemillasDePremio().get((int)(Math.random()*((this.getSemillasDePremio().size())-0))+0);
		if (premio.esAcuatica()){
			this.getSemillasAcuaticas().add(premio);
		}else{
			this.getSemillasTerrestres().add(premio);
		}
	}
	
	/*
	 * Agregue unas excepciones para que arroje en caso de que falle
	 * despues si queres lo cambiamos
	*/
	public void sembrarEn(Semilla semilla, Terreno terreno, int casillero){
		if ((semilla.esAcuatica() && terreno.esAcuatico()) || (semilla.esTerrestre() && terreno.esTerrestre())){
			if(terreno.estaLibre(casillero)){
				terreno.añadirEn(semilla,casillero);
			}
			else { throw new UserException("Esta ocupado el casillero"); } 
		}
		else { throw new UserException("No se puede plantar esta planta ese terreno"); }
	}
/*
 * En este metodo mejorarA despues me ayudas a ver como hacemos para descontar
 * el costo, tendria que conocer al jardin, y decirle, descontar(costo) o algo
 * asi.
 */
	
	public void mejorarA (Semilla semillaAmejorar, int tipoMejora) // esto vemos si lo hacemo asi o
	{	switch(tipoMejora) { 
		case 1 :  
			int mejora = 20; boolean defensa = true; int costo = 50 ; 
			break;
		case 2 :  
			int mejora2 = 20; boolean defensa2 = false; int costo2 = 50 ;
			break;
		case 3 :  
			int mejora3 = 35; boolean defensa3 = true; int costo3 = 100 ;
			break;
		case 4 :  
			int mejora4 = 35; boolean defensa4 = false; int costo4 = 100 ;
			break;
		default:
			throw new UserException("Tipo de mejora invalida");
	}
	
	}	
}
