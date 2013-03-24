
public class Jardin {

	private int recursos;
	
	public int getRecursos() {
		return recursos;
	}

	public void setRecursos(int recursos) {
		this.recursos = recursos;
	}

	public void sumarRecursos(int premio) {
		this.setRecursos(this.getRecursos() + premio);
	}


}
