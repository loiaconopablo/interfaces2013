import junit.framework.TestCase;


public class TestJardin extends TestCase{

	private Jardin jardin;
	
	public void setUp(){
		this.jardin = new Jardin(4,2);
	}
	
	public void testConstructor(){
		Jardin jardincito = new Jardin(5,2);
		this.assertEquals(jardincito.getFilas().size(), 7);
		this.assertEquals(0, jardincito.getRecursos());
	}
	
	public void testSumarrecursos(){
		this.jardin.sumarRecursos(25);
		this.assertEquals(25, this.jardin.getRecursos());
		this.jardin.sumarRecursos(3);
		this.assertEquals(28, this.jardin.getRecursos());
	}
	
}
