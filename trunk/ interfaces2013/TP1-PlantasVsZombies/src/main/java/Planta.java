
public class Planta {

	private int puntosDeDaño;
	private int capacidadDefensiva;
	private String nombre;
	private Terreno terreno;
	
	public Planta(int puntosDeDaño, int capacidadDefensiva, String nombre,Terreno terreno){
		this.setearCapacidadDefensiva(capacidadDefensiva);
		this.setearPuntosDeDaño(puntosDeDaño);
		this.nombre = nombre;
		this.terreno = terreno;
	}
	

	public Terreno getTerreno() {
		return terreno;
	}
	public void setTerreno(Terreno terreno) {
		this.terreno = terreno;
	}
	public int getPuntosDeDaño() {
		return puntosDeDaño;
	}
	public void setPuntosDeDaño(int puntosDeDaño) {
		this.puntosDeDaño = puntosDeDaño;
	}
	public int getCapacidadDefensiva() {
		return capacidadDefensiva;
	}
	public void setCapacidadDefensiva(int capacidadDefensiva) {
		this.capacidadDefensiva = capacidadDefensiva;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void meAtaco(int ataque,Terreno terreno) {
		
		this.setCapacidadDefensiva(this.getCapacidadDefensiva() - ataque);
		if(this.capacidadDefensiva <= 0){
			terreno.desplantame(this);
			
		}
	}
	
	public void setearPuntosDeDaño(int puntosDeDaño) {
		if (puntosDeDaño < 0){
			this.setPuntosDeDaño(0);
		}else{
			if(puntosDeDaño > 100){
				this.setPuntosDeDaño(100);
			}else{
				this.setPuntosDeDaño(puntosDeDaño);
			}
		}
	}

	public void setearCapacidadDefensiva(int capacidadDefensiva) {
		if (capacidadDefensiva <= 0){
			this.setCapacidadDefensiva(1);//M�ana chequeemos esto, no se xq 1
		}else{
			if(capacidadDefensiva > 50){
				this.setCapacidadDefensiva(50);//M�ana chequeemos esto, no se xq 50
			}else{							//Seria getCapacidadDefensiva+capacidadDefensiva
				this.setCapacidadDefensiva(capacidadDefensiva);
			}
		}
		
	}
}
