import junit.framework.TestCase;


public class TestZombie extends TestCase {
	
	private Zombie zombie;
	private JardinZen jardinZen;
	private Jardin jardin;
	
	public void setUp(){
		this.jardin = new Jardin(2,2);
		this.jardinZen = new JardinZen(this.jardin);
		this.zombie = new Zombie(this.jardin,this.jardinZen,50,50, "Jose");
	}
	
	public void testConstructorConMenosAtaque(){
		Zombie zombi = new Zombie(this.jardin, this.jardinZen,50,9,"Zombie");
		this.assertEquals(10, zombi.getAtaque());
	}
	
	public void testConstructorConMayorAtaque(){
		Zombie zombi = new Zombie(this.jardin, this.jardinZen,50,120,"Zombie");
		this.assertEquals(100, zombi.getAtaque());
	}
	
	public void testConstructorConAtaqueEnRango(){
		Zombie zombi = new Zombie(this.jardin, this.jardinZen,50,15,"Zombie");
		this.assertEquals(15, zombi.getAtaque());
	}
	
	public void testConstructorConResistenciaMenor(){
		Zombie zombi = new Zombie(this.jardin, this.jardinZen,10,15,"Zombie");
		this.assertEquals(50, zombi.getResistencia());
		this.assertEquals(50, zombi.getResistenciaInicial());
	}
	
	public void testConstructorConResistenciaMayor(){
		Zombie zombi = new Zombie(this.jardin, this.jardinZen,122,15,"Zombie");
		this.assertEquals(100, zombi.getResistencia());
		this.assertEquals(100, zombi.getResistenciaInicial());
	}
	
	public void testConstructorConResistenciaEnRango(){
		Zombie zombi = new Zombie(this.jardin, this.jardinZen,75,15,"Zombie");
		this.assertEquals(75, zombi.getResistencia());
		this.assertEquals(75, zombi.getResistenciaInicial());
	}
	
}
