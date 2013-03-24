import junit.framework.TestCase;

public class TestTipoTerrenoTerrestre extends TestCase {

	private TipoTerrenoTerrestre terreno;

	public void setUp() {
		this.terreno = new TipoTerrenoTerrestre();
	}

	public void testConstructor() {
		this.assertEquals(this.terreno.getClass(),
				new TipoTerrenoTerrestre().getClass());
	}

	public void testEsAcuatico() {
		this.assertFalse(this.terreno.esAcuatica());
	}

	public void testEsTerrestre() {
		this.assertTrue(this.terreno.esTerrestre());
	}
}
