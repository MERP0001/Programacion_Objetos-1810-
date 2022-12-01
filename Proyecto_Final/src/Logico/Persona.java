package Logico;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Persona implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected String cedula;
	protected String nombre;
	protected String telefono;
	protected String direccion;
	protected String estado;
	protected String fechaNacimiento;
	protected String condicion;
	protected ArrayList<SolPersona>misSolicitudes;
	
	public Persona(String cedula, String nombre, String telefono, String direccion, String estado,
			String fechaNacimiento) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.estado = estado;
		this.fechaNacimiento = fechaNacimiento;
		this.condicion = "Desempleado";
		this.misSolicitudes = new ArrayList<SolPersona>();
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public ArrayList<SolPersona> getMisSolicitudes() {
		return misSolicitudes;
	}

	public void setMisSolicitudes(ArrayList<SolPersona> misSolicitudes) {
		this.misSolicitudes = misSolicitudes;
	}
	
	public void ingresarSolicitud(SolPersona aux) {
		misSolicitudes.add(aux);
	}
}