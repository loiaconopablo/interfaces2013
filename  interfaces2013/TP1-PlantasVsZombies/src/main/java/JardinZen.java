import java.util.List;


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

	public void añadirSemilla() {
		Semilla premio = this.getSemillasDePremio().get((int)(Math.random()*((this.getSemillasDePremio().size())-0))+0);
		if (premio.esAcuatica()){
			this.getSemillasAcuaticas().add(premio);
		}else{
			this.getSemillasTerrestres().add(premio);
		}
	}
	
	public void sembrarEn(Semilla semilla, Terreno terreno, int casillero){
		if ((semilla.esAcuatica() && terreno.esAcuatico()) || (semilla.esTerrestre() && terreno.esTerrestre())){
			if(terreno.estaLibre(casillero)){
				terreno.añadirEn(semilla,casillero);
			}
		}
	}

}
