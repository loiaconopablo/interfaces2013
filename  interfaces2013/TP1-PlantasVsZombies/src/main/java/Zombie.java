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
				this.atacarPlanta(terreno, this.getAtaque());
				this.meAtaco(terreno.siguiente().getPuntosDeDaño());
			}
			if(this.estoyMuerto()){
				
			}
		}	
	}
	
	private boolean estoyMuerto() {
		// TODO Auto-generated method stub
		return false;
	}
	private void meAtaco(int ataque) {
		
		this.setResistencia(this.getResistencia() - ataque);
		
	}
	
	private boolean estoyVivo() {
		return this.resistencia>0;
	}
	
	private void atacarPlanta(Terreno terreno, int ataque) {
		
		terreno.siguiente().meAtaco(ataque,terreno);
		
	}
	
}
