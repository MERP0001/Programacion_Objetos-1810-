package Logico;

public class Universitario extends Persona {

	private String carrera;
	private String anoGruaduacion;
	
	public Universitario(String cedula, String nombre, String telefono, String direccion, String estado, String carrera, String anoGruaduacion, String fechaNacimiento) {
		super(cedula, nombre, telefono, direccion, estado, fechaNacimiento);
		
		this.carrera = carrera;
		this.anoGruaduacion = anoGruaduacion;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getAnoGruaduacion() {
		return anoGruaduacion;
	}

	public void setAnoGruaduacion(String anoGruaduacion) {
		this.anoGruaduacion = anoGruaduacion;
	}
}