import junit.framework.TestCase;

public class TestMejora  extends TestCase{

	private Mejora mejoraDefensiva;
	private Mejora mejoraOfensiva;
	private Tipo tipoDef;
	private Tipo tipoOfe;
	
		public void setUp(){
		this.tipoDef = Tipo.DEFENSIVA;
		this.tipoOfe = Tipo.OFENSIVA;
		this.mejoraDefensiva = new Mejora("MejoraOne",50, tipoDef,20 );
		this.mejoraOfensiva = new Mejora("MejoraTwo",30, tipoOfe,25 );
		
	}
	
		public void testConstructor(){
			this.assertEquals(this.mejoraDefensiva.getClass(), Mejora.class);
			this.assertEquals(this.mejoraOfensiva.getClass(), Mejora.class);
			
			this.assertEquals(this.mejoraDefensiva.getTipo(), this.tipoDef);
			this.assertEquals(this.mejoraOfensiva.getTipo(), this.tipoOfe);
			
			this.assertEquals(this.mejoraDefensiva.getCosto(), 50);
			this.assertEquals(this.mejoraOfensiva.getCosto(), 30);
			
			this.assertEquals(this.mejoraDefensiva.getporcDeMejora(), 20);
			this.assertEquals(this.mejoraOfensiva.getporcDeMejora(), 25);
								}
		
		
		
}
