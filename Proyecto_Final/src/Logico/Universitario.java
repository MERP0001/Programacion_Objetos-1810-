package Logico;

import java.util.Date;

public class Universitario extends Persona {

	private String carrera;
	private Date anoGruaduacion;
	
	public Universitario(String cedula, String nombre, String telefono, String direccion, String estado, String carrera, Date anoGruaduacion) {
		super(cedula, nombre, telefono, direccion, estado);
		
		this.carrera = carrera;
		this.anoGruaduacion = anoGruaduacion;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public Date getAnoGruaduacion() {
		return anoGruaduacion;
	}

	public void setAnoGruaduacion(Date anoGruaduacion) {
		this.anoGruaduacion = anoGruaduacion;
	}
	
	

}
