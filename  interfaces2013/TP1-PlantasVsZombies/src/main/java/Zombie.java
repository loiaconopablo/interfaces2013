import org.uqbar.commons.model.UserException;


public class Zombie {

	private int resistencia;
	private int ataque;
	private String nombre;
	
	public int getResistencia() {
		return resistencia;
	}
	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void atacar(Terreno terreno){
		
		while(this.estoyVivo()){
			
			if(terreno.estaVacio()){
				throw new UserException("Perdiste el juego!!!");
			}
			else{
				this.atacarPlanta(terreno.siguiente(), this.getAtaque());
				this.meAtaco(terreno.siguiente().getPuntosDeDaño());
			}
			
		}	
	}
	
	private void meAtaco(int puntosDeDaño) {
		
		this.setResistencia(this.getResistencia() - puntosDeDaño);
		
	}
	
	private boolean estoyVivo() {
		return this.resistencia>0;
	}
	
	private void atacarPlanta(Planta planta, int ataque) {
		
		
		
	}
	
}
