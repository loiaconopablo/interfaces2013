package plantaszombies;



/**
 * @author Mariano Varela, Pablo Loiacono
 * 
 */

public class TipoTerrenoAcuatico extends TipoTerreno {

	@Override
	public boolean esTerrestre() {
		return false;
	}

	@Override
	public boolean esAcuatica() {
		return true;
	}

}
