package plantaszombies;
import junit.framework.TestCase;


public class TestPlanta extends TestCase {

	private Planta planta;
	private Terreno terreno;
	
	public void setUp(){
		this.terreno = new Terreno(new TipoTerrenoAcuatico());
		this.planta = new Planta(38, 27, "Girasol", this.terreno );
	}
	
	public void testConstructor(){
		Planta retorno = new Planta(38,27,"Repetidora", this.terreno);
		this.assertEquals(retorno.getClass(), this.planta.getClass() );
		this.assertEquals(retorno.getCapacidadDefensiva(), 27);
		this.assertEquals(retorno.getPuntosDeDanio(), 38);
		this.assertEquals(retorno.getNombre(), "Repetidora");
	}
	
	public void testMeAtacoYSigueViva(){
		this.terreno.getPlantas().add(4, this.planta);
		this.planta.recibirDanio(20);
		this.assertEquals(7, this.planta.getCapacidadDefensiva());
	}
	
	public void testMeAtacoMuere(){
		this.terreno.getPlantas().add(4, this.planta);
		this.planta.recibirDanio(30);
		this.assertTrue(this.terreno.getPlantas().get(4).getCapacidadDefensiva()<=0);
	}
	
	public void testSetearCapacidadDefensivaDentroDeRango(){
		this.planta.setearCapacidadDefensiva(25);
		this.assertEquals(this.planta.getCapacidadDefensiva(),25);
	}
	
	public void testSetearCapacidadDefensivaMenorAlRango(){
		this.planta.setearCapacidadDefensiva(-5);
		this.assertEquals(this.planta.getCapacidadDefensiva(),1);
	}
	
	public void testSetearCapacidadDefensivaMayorAlRango(){
		this.planta.setearCapacidadDefensiva(78);
		this.assertEquals(this.planta.getCapacidadDefensiva(),50);
	}
	
	public void testSetearPuntosDeDanioDentroDeRango(){
		this.planta.setearPuntosDeDanio(45);
		this.assertEquals(45, this.planta.getPuntosDeDanio());
	}
	
	public void testSetearPuntosDeDanioMenorAlRango(){
		this.planta.setearPuntosDeDanio(-75);
		this.assertEquals(0, this.planta.getPuntosDeDanio());
	}
	
	public void testSetearPuntosDeDanioMayorAlRango(){
		this.planta.setearPuntosDeDanio(142);
		this.assertEquals(100, this.planta.getPuntosDeDanio());
	}
	
}
