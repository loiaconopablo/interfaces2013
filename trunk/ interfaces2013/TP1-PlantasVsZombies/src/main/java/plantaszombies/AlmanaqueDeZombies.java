package plantaszombies;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;
import org.uqbar.commons.utils.Transactional;

/**
 * @author Mariano Varela, Pablo Loiacono
 * 
 */

@Transactional
@Observable
public class AlmanaqueDeZombies  { 

	private List<Zombie> zombies;

	public AlmanaqueDeZombies(){
		this.zombies = new LinkedList<Zombie>();
		this.zombies.add(new Zombie(50,50, "uno"));
		this.zombies.add(new Zombie(50,100, "unos"));
		this.zombies.add(new Zombie(50,75, "dos"));
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


	public List<Zombie> search(String nombre) {
		List<Zombie> resultados = new LinkedList<Zombie>();

		for (Zombie zombie : this.zombies) {
			if (match(nombre, zombie.getNombre())) {
				resultados.add(zombie);
			}
		}

		return resultados;
	}

	protected boolean match(Object expectedValue, Object realValue) {
		return expectedValue == null
			|| realValue.toString().toLowerCase().contains(expectedValue.toString().toLowerCase());
	}
	
}
