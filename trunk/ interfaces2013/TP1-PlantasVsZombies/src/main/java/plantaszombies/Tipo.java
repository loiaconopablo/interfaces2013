package plantaszombies;

/**
 * @author Mariano Varela, Pablo Loiacono
 * 
 */

public enum Tipo {

	DEFENSIVA {
		@Override
		public void aplicarMejora(Planta planta, int porcDeMejora) {
			planta.setCapacidadDefensiva(porcDeMejora + planta.getCapacidadDefensiva());
		}
	},

	OFENSIVA {
		@Override
		public void aplicarMejora(Planta planta, int porcDeMejora) {
			planta.setPuntosDeDanio(porcDeMejora + planta.getPuntosDeDanio());
		}
	};

	abstract public void aplicarMejora(Planta planta, int porcDeMejora);

}
