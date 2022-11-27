package Logico;

import java.util.ArrayList;

public class Empresa {
	
	private String rcn;
	private String direccion;
	private String nombreEmpresa;
	private ArrayList<Persona>empleados;
	
	public Empresa(String rcn, String direccion, String nombreEmpresa) {
		super();
		this.rcn = rcn;
		this.direccion = direccion;
		this.nombreEmpresa = nombreEmpresa;
		this.empleados = new ArrayList<Persona>();
	}

	public String getRcn() {
		return rcn;
	}

	public void setRcn(String rcn) {
		this.rcn = rcn;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public ArrayList<Persona> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<Persona> empleados) {
		this.empleados = empleados;
	}



	
}
