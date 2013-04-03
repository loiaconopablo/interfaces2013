package plantaszombies;
import junit.framework.TestCase;


public class TestTerreno extends TestCase {

	private Terreno terrenoAcuatico;
	private Terreno terrenoTerrestre;
	private TipoTerrenoAcuatico tipoTerrenoAcuatico;
	private TipoTerrenoTerrestre tipoTerrenoTerrestre;
	
	public void setUp(){
		this.tipoTerrenoAcuatico = new TipoTerrenoAcuatico();
		this.tipoTerrenoTerrestre = new TipoTerrenoTerrestre();
		this.terrenoAcuatico = new Terreno(this.tipoTerrenoAcuatico);
		this.terrenoTerrestre = new Terreno(this.tipoTerrenoTerrestre);
	}
	
	public void testConstructor(){
		this.assertEquals(5, this.terrenoTerrestre.getPlantas().size());
		this.assertNull(this.terrenoTerrestre.getPlantas().get(0));
		this.assertEquals(TipoTerrenoTerrestre.class, this.terrenoTerrestre.getTipoTerreno().getClass());
	}
	
	public void testEstaVacioCasoVacio(){
		this.assertTrue(this.terrenoAcuatico.estaVacio());
	}
	
	public void testEstaVacioCasoTieneElementos(){
		this.terrenoTerrestre.getPlantas().add(2, new Planta(21,25,"Girasol",this.terrenoTerrestre) );
		this.assertFalse(this.terrenoTerrestre.estaVacio());
	}
	
	public void testDesplantame(){
		Planta girasol = new Planta(21,25,"Girasol",this.terrenoTerrestre);
		this.terrenoTerrestre.getPlantas().add(2, girasol);
		this.assertNotNull(this.terrenoTerrestre.getPlantas().get(2));
		this.terrenoTerrestre.desplantame(girasol);
		this.assertNull(this.terrenoTerrestre.getPlantas().get(2));	
	}
	
	public void testEsAcuaticoCasoVerdadero(){
		this.assertTrue(this.terrenoAcuatico.esAcuatico());
	}
	
	public void testEsAcuaticoCasoFalso(){
		this.assertFalse(this.terrenoTerrestre.esAcuatico());
	}
	
	public void testEsTerrestreCasoVerdadero(){
		this.assertTrue(this.terrenoTerrestre.esTerrestre());
	}
	
	public void testEsTerrestreCasoFalso(){
		this.assertFalse(this.terrenoAcuatico.esTerrestre());
	}
	
	public void testEstaLibreCasoVerdadero(){
		this.assertTrue(this.terrenoTerrestre.estaLibre(1));
		this.assertTrue(this.terrenoTerrestre.estaLibre(0));
	}
	
	public void testEstaLibreCasoFalso(){
		Planta girasol = new Planta(21,25,"Girasol",this.terrenoTerrestre);
		this.terrenoTerrestre.getPlantas().add(1,girasol);
		this.assertFalse(this.terrenoTerrestre.estaLibre(1));
	}
	
	public void testAniadirEn(){
		Semilla semilla = new Semilla(this.tipoTerrenoAcuatico,"Girasol", 25, 24);
		this.assertNull(this.terrenoAcuatico.getPlantas().get(3));
		this.terrenoAcuatico.aniadirEn(semilla, 3);
		this.assertNotNull(this.terrenoAcuatico.getPlantas().get(3));
	}
	
	public void testSiguiente(){
		Planta siguiente = new Planta(21,25,"Girasol",this.terrenoTerrestre);
		this.terrenoTerrestre.getPlantas().add(3, siguiente);
		this.assertEquals(siguiente, this.terrenoTerrestre.siguiente());
	}
	
}
