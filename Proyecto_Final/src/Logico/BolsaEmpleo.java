package Logico;

import java.util.ArrayList;

public class BolsaEmpleo {

	private ArrayList<Persona> misPersonas;
	private ArrayList<Empresa> misEmpleos;
	private ArrayList<Solicitud> misSolicitudes;
	private ArrayList<Usuario> misUsuarios;
    public static BolsaEmpleo bolsaEmpleo;
	
	public BolsaEmpleo() {
		super();
		this.misPersonas = new ArrayList<Persona>();
		this.misEmpleos = new ArrayList<Empresa>();
		this.misSolicitudes = new ArrayList<Solicitud>();
		this.misUsuarios = new ArrayList<Usuario>();
	}
	
	public static BolsaEmpleo getInstance() {
		if(bolsaEmpleo == null) {
			bolsaEmpleo = new BolsaEmpleo();
		}
		return bolsaEmpleo;
	}
	
	public void insertarPersona(Persona auxPersona) {
		misPersonas.add(auxPersona);
	}

	public ArrayList<Persona> getMisPersonas() {
		return misPersonas;
	}

	public ArrayList<Empresa> getMisEmpleos() {
		return misEmpleos;
	}
	
	public void crearUsuario(Usuario user) {
		misUsuarios.add(user);
	}
	
	public void crearPersona(Persona p1) {
		misPersonas.add(p1);
	}
	
	public void crearEmpresa(Empresa emp) {
		misEmpleos.add(emp);
	}
	
	public ArrayList<Solicitud> getMisSolicitudes() {
		return misSolicitudes;
	}

	public ArrayList<Usuario> getMisUsuarios() {
		return misUsuarios;
	}
	
	
	public boolean buscarUsuario(String user, String password) {
		int ind = 0;
		boolean existe = false;
		while(ind < misUsuarios.size() && misUsuarios.get(ind).getUserId().equalsIgnoreCase(user)) {
			ind++;
		}
		if(misUsuarios.get(ind).getPassword().equalsIgnoreCase(password)) {
			existe = true;
		}
		return existe;
	}
	public Persona buscarPersona(String cedula) {
		int ind = 0;
		while(ind < misPersonas.size() && misPersonas.get(ind).getCedula().equalsIgnoreCase(cedula)) {
			ind++;
		}
		return misPersonas.get(ind);
	}
	
	public int buscarPersonaIndex(String cedula) {
		int ind = 0;
		while(ind < misPersonas.size() && misPersonas.get(ind).getCedula().equalsIgnoreCase(cedula)) {
			ind++;
		}
		return ind;
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

	public void modificarPersona(Persona auxPersona) {
		int ind = buscarPersonaIndex(auxPersona.getCedula());
		misPersonas.set(ind, auxPersona);
	}
	
	

	
}
