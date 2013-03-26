import java.util.LinkedList;
import java.util.List;

import org.uqbar.commons.model.UserException;

public class AlmanaqueDeZombies {

	private List<Zombie> zombies;

	public AlmanaqueDeZombies(){
		this.zombies = new LinkedList<Zombie>();
	}
	
	public List<Zombie> getZombies() {
		return zombies;
	}

	public void setZombies(List<Zombie> zombies) {
		this.zombies = zombies;
	}

	public Zombie buscar(String nombre) {
		Zombie encontrado = null;
		for (Zombie zombie : this.getZombies()) {
			if (zombie.getNombre().equals(nombre)) {
				encontrado = zombie;
			}
		}
		if (encontrado == null) {
			throw new UserException("No se encontro el zombie");
		}
		return encontrado;
	}

}
