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
}
