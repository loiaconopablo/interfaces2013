import java.util.List;




public class Terreno {

	private List<Planta> plantas;

	public List<Planta> getPlantas() {
		return plantas;
	}

	public void setPlantas(List<Planta> plantas) {
		this.plantas = plantas;
	}
	
	public Planta siguiente(){

	}

	public boolean estaVacio() {
		return plantas.isEmpty();
	}

	public void desplantame(Planta planta) {
		
		this.getPlantas().remove(planta);		
	}
	
}
