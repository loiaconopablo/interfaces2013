import junit.framework.TestCase;


public class TestAlmanaqueDeZombies extends TestCase {

	private AlmanaqueDeZombies almanaque;
	
	
	public void setUp(){
		this.almanaque = new AlmanaqueDeZombies();	
	}
	
	public void testConstructor(){
		this.assertTrue(this.almanaque.getZombies().isEmpty());
	}
	
	public void testBuscarCasoQueEncuentraAlZombie(){
		Jardin jardin = new Jardin(2,4);
		JardinZen jardinZen = new JardinZen(jardin,null);
		Zombie zombie = new Zombie(jardin, jardinZen,25,45,"Joe");
		this.almanaque.getZombies().add(new Zombie(jardin, jardinZen,25,45,"Billy"));
		this.almanaque.getZombies().add(zombie);
		this.almanaque.getZombies().add(new Zombie(jardin, jardinZen,25,45,"Jerry"));
		this.assertEquals(zombie, this.almanaque.buscar("Joe"));
		this.assertEquals(Zombie.class, this.almanaque.buscar("Billy").getClass());
	}
	
	public void testBuscarCasoQueNoEncuentraAlZombie(){
	try{
		   //this.almanaque.buscar("Messi");
		   //fail("Messi no es un zombie, es un marciano");
		}
	catch(RuntimeException e){
		   
	}
	}
}
