package Logico;

import java.util.ArrayList;

public class Obrero extends Persona {

	private ArrayList<String> oficios;
	
	public Obrero(String cedula, String nombre, String telefono, String direccion, String estado, String fechaNacimiento) {
		super(cedula, nombre, telefono, direccion, estado, fechaNacimiento);
		
		this.oficios = new ArrayList<String>();
		
	}
	
	public ArrayList<String> getOficios() {
		return oficios;
	}

	public void setOficios(String string) {
		oficios.add(string);
	}
}