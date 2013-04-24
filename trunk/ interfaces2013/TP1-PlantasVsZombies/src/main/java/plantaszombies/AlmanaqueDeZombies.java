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

@Observable
public class AlmanaqueDeZombies  { 

	public List<Zombie> zombies;

	public AlmanaqueDeZombies(){
		this.zombies = new LinkedList<Zombie>();
		this.zombies.add(new Zombie(50,50,"Willy"));
		this.zombies.add(new Zombie(50,100,"Juan"));
		this.zombies.add(new Zombie(80,75, "Jose"));
		this.zombies.add(new Zombie(60,70, "Laurito"));
		this.zombies.add(new Zombie(50,65, "Mandanda"));
		this.zombies.add(new Zombie(50,80, "Hugo"));
		this.zombies.add(new Zombie(100,80, "Hugito"));
		this.zombies.add(new Zombie(90,40, "Hugiño"));
		this.zombies.add(new Zombie(70,90, "Tomsom"));
		this.zombies.add(new Zombie(65,100, "Henry"));
	}
	
	public List<Zombie> getZombies() {
		return zombies;
	}

	public void setZombies(List<Zombie> zombies) {
		this.zombies = zombies;
	}

	public boolean murieronZombies() {
		return (this.zombies.size()) == 0;
		
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
