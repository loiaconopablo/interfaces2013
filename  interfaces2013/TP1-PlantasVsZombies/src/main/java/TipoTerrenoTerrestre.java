
public class TipoTerrenoTerrestre extends TipoTerreno {

	@Override
	public boolean esTerrestre() {
		return true;
	}

	@Override
	public boolean esAcuatica() {
		return false;
	}

}
