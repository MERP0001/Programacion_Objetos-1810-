package Logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Empresa implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rcn;
	private String direccion;
	private String nombreEmpresa;
	private ArrayList<Persona>empleados;
	private ArrayList<SolEmpresa>misSolicitudes;
	
	public Empresa(String rcn, String direccion, String nombreEmpresa) {
		super();
		this.rcn = rcn;
		this.direccion = direccion;
		this.nombreEmpresa = nombreEmpresa;
		this.empleados = new ArrayList<Persona>();
		this.misSolicitudes  = new ArrayList<SolEmpresa>();
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

	public ArrayList<SolEmpresa> getMisSolicitudes() {
		return misSolicitudes;
	}

	public void setMisSolicitudes(ArrayList<SolEmpresa> misSolicitudes) {
		this.misSolicitudes = misSolicitudes;
	}
	
	public void IngresarEmpleado (Persona p1) {
		empleados.add(p1);
	}
	
	public void ingresarSolicitud(SolEmpresa aux) {
		misSolicitudes.add(aux);
	}
	public void contratar(Persona aux) {
		empleados.add(aux);
	}

	
}
