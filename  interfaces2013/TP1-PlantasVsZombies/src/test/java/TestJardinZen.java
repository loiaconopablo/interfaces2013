import java.util.LinkedList;

import junit.framework.TestCase;

public class TestJardinZen extends TestCase {

	private JardinZen jardinZen;
	private Semilla semillaDeGirasol;
	private Semilla semillaDeRepetidora;
	private Semilla semillaDeSeaShooter;
	private Semilla semillaDeEscupidora;
	private Semilla semillaDeEnredaderaAcuatica;
	private Semilla semillaDeTrebolAcuatico;
	private TipoTerrenoTerrestre terrenoTerrestre;
	private TipoTerrenoAcuatico terrenoAcuatico;
	private Terreno tierra;
	private Terreno agua;

	public void setUp() {
		this.jardinZen = new JardinZen(new Jardin(2,2),null);
		this.terrenoAcuatico = new TipoTerrenoAcuatico();
		this.terrenoTerrestre = new TipoTerrenoTerrestre();
		this.semillaDeGirasol = new Semilla(terrenoTerrestre, "Girasol", 25, 45);
		this.semillaDeSeaShooter = new Semilla(terrenoAcuatico, "SeaShoter",25, 45);
		this.semillaDeRepetidora = new Semilla(terrenoTerrestre, "Repetidora",25, 45);
		this.semillaDeEscupidora = new Semilla(terrenoTerrestre, "Escupidora",25, 45);
		this.semillaDeGirasol = new Semilla(terrenoAcuatico,"EnredaderaAcutica", 25, 45);
		this.semillaDeTrebolAcuatico = new Semilla(terrenoAcuatico,	"TrebolAcuatico", 25, 45);
		this.agua = new Terreno(terrenoAcuatico);
		this.tierra = new Terreno(terrenoTerrestre);
	}

	public void testAniadirSemillaCuandoPuedeAniadirAcuaticas() {
		this.assertEquals(this.jardinZen.getSemillasAcuaticas().size(), 0);
		this.jardinZen.getSemillasDePremio().add(semillaDeSeaShooter);
		this.jardinZen.aniadirSemilla();
		this.assertEquals(this.jardinZen.getSemillasAcuaticas().size(), 1);
	}

	public void testAniadirSemillaCuandoNoPuedeAniadirAcuaticas() {
		this.assertEquals(this.jardinZen.getSemillasAcuaticas().size(), 0);
		for (int i = 0; i <= 20; i++) {
			this.jardinZen.getSemillasDePremio().add(null);
		}
		try {
			this.jardinZen.aniadirSemilla();
			fail("Hay demasiadas semillas");
		} catch (RuntimeException e) {
		}
	}
	
	public void testSembrarSemillaTerrestreEnTierra(){
		this.assertNull(tierra.getPlantas().get(2));
		this.jardinZen.sembrarEn(semillaDeRepetidora, tierra, 2);
		this.assertNotNull(tierra.getPlantas().get(2));
	}
	
	public void testSembrarSemillaAcuaticaEnAgua(){
		this.assertNull(agua.getPlantas().get(1));
		this.jardinZen.sembrarEn(semillaDeTrebolAcuatico, agua, 1);
		this.assertNotNull(agua.getPlantas().get(1));
	}
	
	/*public void testSembrarSemillaAcuaticaEnTierra(){
		this.assertNull(agua.getPlantas().get(3));
		try {
			this.jardinZen.sembrarEn(semillaDeTrebolAcuatico, agua, 3);
			fail("No se puede sembrar en este terreno este tipo de planta");
		} catch (RuntimeException e) {
		}
		this.assertNull(agua.getPlantas().get(3));
	}
	
	*/


}
