package plantaszombies;
import java.util.List;

import junit.framework.TestCase;


public class TestAlmanaqueDeZombies extends TestCase {

	private AlmanaqueDeZombies almanaque;
	
	
	public void setUp(){
		this.almanaque = new AlmanaqueDeZombies();	
	}
	
	public void testConstructor(){
		this.assertFalse(this.almanaque.getZombies().isEmpty());
	}
	
	public void testBuscarCasoQueEncuentraAlZombie(){
		Jardin jardin = new Jardin(2,4);
		JardinZen jardinZen = new JardinZen(jardin);
		Zombie zombie = new Zombie(75,15,"Joe");
		this.almanaque.getZombies().add(new Zombie(50,45,"Billy"));
		this.almanaque.getZombies().add(zombie);
		this.almanaque.getZombies().add(new Zombie(50,45,"Jerry"));
		this.assertEquals(zombie, this.almanaque.buscar("Joe"));
		this.assertEquals(Zombie.class, this.almanaque.buscar("Billy").getClass());
	}
	
	public void testBuscarCasoQueNoEncuentraAlZombie(){
		
	}
	
	public void testSearch(){
		List <Zombie> busqueda = this.almanaque.search("Hug");
		this.assertEquals(busqueda.size(), 3);	
		this.assertNotSame(0,busqueda.size());
		
	}
	
	public void testMatch(){
		this.assertTrue(this.almanaque.match("o", new Zombie(75,15,"Joe")));
	}
	public void testMurieronZombies(){
		this.assertFalse(this.almanaque.murieronZombies());
		this.almanaque.getZombies().clear();
		this.assertTrue(this.almanaque.murieronZombies());
		
	}
	
}
