import junit.framework.TestCase;


public class TestSemilla extends TestCase{
	
	private Semilla semilla;
	private TipoTerreno tipoTerreno;
	
	public void setUp(){
		this.tipoTerreno = new TipoTerrenoAcuatico();
		this.semilla = new Semilla(this.tipoTerreno, "Girasol", 10, 20);
	}
	
	public void testConstructor(){
		this.assertEquals(this.semilla.getClass(), Semilla.class);
		this.assertEquals(this.semilla.getTipoTerreno(), this.tipoTerreno);
		this.assertEquals(this.semilla.getNombre(), "Girasol");
		this.assertEquals(this.semilla.getPuntosDeDaño(), 10);
		this.assertEquals(this.semilla.getCapacidadDefensiva(),20);
	}

	public void testEsAcuatica(){
		this.assertTrue(this.semilla.esAcuatica());
		this.assertFalse(this.semilla.esTerrestre());
	}
	
	public void testEsTerrestre(){
		this.semilla.setTipoTerreno(new TipoTerrenoTerrestre());
		this.assertFalse(this.semilla.esAcuatica());
		this.assertTrue(this.semilla.esTerrestre());
	}
	
	public void testSembrar(){
		Terreno terreno = new Terreno(this.tipoTerreno);
		Planta retorno = new Planta(17,25,"Girasol",terreno);
		this.assertEquals(retorno.getClass(), semilla.sembrar(terreno).getClass());
	}
	
	
}
