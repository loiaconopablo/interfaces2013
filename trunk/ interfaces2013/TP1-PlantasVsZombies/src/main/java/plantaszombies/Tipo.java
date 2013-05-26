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
		
		public void aplicarMejora(Semilla semilla, int porcDeMejora) {
			semilla.setCapacidadDefensiva(porcDeMejora + semilla.getCapacidadDefensiva());
		}
	},

	OFENSIVA {
		@Override
		public void aplicarMejora(Planta planta, int porcDeMejora) {
			planta.setPuntosDeDanio(porcDeMejora + planta.getPuntosDeDanio());
		}
		
		public void aplicarMejora(Semilla semilla, int porcDeMejora) {
			semilla.setPuntosDeDanio(porcDeMejora + semilla.getPuntosDeDanio());
		}
	};

	abstract public void aplicarMejora(Planta planta, int porcDeMejora);

	abstract public void aplicarMejora(Semilla semilla, int getporcDeMejora);

}
