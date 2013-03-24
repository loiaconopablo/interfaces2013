
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
