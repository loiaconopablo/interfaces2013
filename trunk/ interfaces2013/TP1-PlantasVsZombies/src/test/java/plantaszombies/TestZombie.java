package plantaszombies;
import junit.framework.TestCase;


public class TestZombie extends TestCase {
	
	private Zombie zombie;
	private JardinZen jardinZen;
	private Jardin jardin;
	
	public void setUp(){
		this.jardin = new Jardin(2,2);
		this.jardinZen = new JardinZen(this.jardin,null);
		this.zombie = new Zombie(50,50, "Jose");
	}
	
	public void testConstructorConMenosAtaque(){
		try {
			
		} catch (Exception e) {
			Zombie zombi = new Zombie(50,9,"Zombie");	
		}
		
	}
	
	public void testConstructorConMayorAtaque(){
		try {
			
		} catch (Exception e) {
			Zombie zombi = new Zombie(50,120,"Zombie");
		}		
	}
	
	public void testConstructorConAtaqueEnRango(){
		Zombie zombi = new Zombie(50,15,"Zombie");
		this.assertEquals(15, zombi.getAtaque());
	}
	
	public void testConstructorConResistenciaMenor(){
		try {
	
		} catch (Exception e) {
			Zombie zombi = new Zombie(10,15,"Zombie");
		}
		
	}
	
	public void testConstructorConResistenciaMayor(){
		try {
			
		} catch (Exception e) {
			Zombie zombi = new Zombie(122,15,"Zombie");
		}
	}
	
	public void testConstructorConResistenciaEnRango(){
		Zombie zombi = new Zombie(75,15,"Zombie");
		this.assertEquals(75, zombi.getResistencia());
		this.assertEquals(75, zombi.getResistenciaInicial());
	}
	
	public void testDarPremio(){
		int resultado = this.zombie.darPremio();
		this.assertTrue(resultado > 1 && resultado <this.zombie.getResistenciaInicial()/3);
		System.out.println(resultado);
	}
}
