package Logico;

public abstract class Tecnico extends Persona {

	private String areaTrabajo;
	private int anosExp;
	
	public Tecnico(String cedula, String nombre, String telefono, String direccion, String estado, String areaTrabajo, int anosExp) {
		super(cedula, nombre, telefono, direccion, estado);
		
		this.anosExp = anosExp;
		this.areaTrabajo = areaTrabajo;
	
	}

	public String getAreaTrabajo() {
		return areaTrabajo;
	}

	public void setAreaTrabajo(String areaTrabajo) {
		this.areaTrabajo = areaTrabajo;
	}

	public int getAnosExp() {
		return anosExp;
	}

	public void setAnosExp(int anosExp) {
		this.anosExp = anosExp;
	}

	
}
