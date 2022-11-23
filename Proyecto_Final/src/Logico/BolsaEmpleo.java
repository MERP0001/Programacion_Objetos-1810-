package Logico;

import java.util.ArrayList;

public class BolsaEmpleo {

	private ArrayList<Persona> misPersonas;
	private ArrayList<Empresa> misEmpleos;
	private ArrayList<Solicitud> misSolicitudes;
	
	public BolsaEmpleo() {
		super();
		this.misPersonas = new ArrayList<Persona>();
		this.misEmpleos = new ArrayList<Empresa>();
		this.misSolicitudes = new ArrayList<Solicitud>();
	}

	public ArrayList<Persona> getMisPersonas() {
		return misPersonas;
	}

	public ArrayList<Empresa> getMisEmpleos() {
		return misEmpleos;
	}
	
	public void crearPersona(Persona p1) {
		misPersonas.add(p1);
	}
	
	public void crearEmpresa(Empresa emp) {
		misEmpleos.add(emp);
	}

	public Persona buscarPersona(String cedula) {
		int ind = 0;
		while(ind < misPersonas.size() && misPersonas.get(ind).getCedula().equalsIgnoreCase(cedula)) {
			ind++;
		}
		return misPersonas.get(ind);
	}
	
	public Empresa buscarEmpresa(String rcn) {
		int ind = 0;
		while(ind < misEmpleos.size() && misEmpleos.get(ind).getRcn().equalsIgnoreCase(rcn)) {
			ind++;
		}
		return misEmpleos.get(ind);
	}
	
	public void eliminarEmpresa(String rcn) {
		int ind = 0;
		while(ind < misEmpleos.size() && misEmpleos.get(ind).getRcn().equalsIgnoreCase(rcn)) {
			ind++;
		}
		misEmpleos.remove(ind);
	}
	
	public void eliminarPersona(String cedula) {
		int ind = 0;
		while(ind < misPersonas.size() && misPersonas.get(ind).getCedula().equalsIgnoreCase(cedula)) {
			ind++;
		}
		misPersonas.remove(ind);
	}
	
	
}
