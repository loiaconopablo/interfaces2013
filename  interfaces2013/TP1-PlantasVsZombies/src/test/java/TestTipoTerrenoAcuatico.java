import junit.framework.TestCase;


public class TestTipoTerrenoAcuatico extends TestCase {

	private TipoTerrenoAcuatico terreno;
	
	public void setUp(){
		this.terreno = new TipoTerrenoAcuatico();
	}
	
	public void testConstructor(){
		this.assertEquals(this.terreno.getClass(), new TipoTerrenoAcuatico().getClass());
	}
	
	public void testEsAcuatico(){
		this.assertTrue(this.terreno.esAcuatica());
	}
	
	public void testEsTerrestre(){
		this.assertFalse(this.terreno.esTerrestre());
	}
	
}
