package Logico;

import java.util.ArrayList;

public class BolsaEmpleo {

	private ArrayList<Persona> misPersonas;
	private ArrayList<Empresa> misEmpleos;
	
	public BolsaEmpleo() {
		super();
		this.misPersonas = new ArrayList<Persona>();
		this.misEmpleos = new ArrayList<Empresa>();
	}

	public ArrayList<Persona> getMisPersonas() {
		return misPersonas;
	}

	public ArrayList<Empresa> getMisEmpleos() {
		return misEmpleos;
	}
}
