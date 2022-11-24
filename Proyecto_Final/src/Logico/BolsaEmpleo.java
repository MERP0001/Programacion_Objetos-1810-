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
		Persona auxPersona = null;
		boolean encontrar = false;
		int i = 0;
		while(i<misPersonas.size() && !encontrar) {
			if(misPersonas.get(i).getCedula().equalsIgnoreCase(cedula)) {
				auxPersona = misPersonas.get(i);
				encontrar = true;
			}
			i++;
		}
		return auxPersona;
	}
	
	private int buscarIndPersona(String cedula) {
		int indPersona = -1;
		int i = 0;
		boolean encontrado = false;
		while (!encontrado && i < misPersonas.size()) {
			if (misPersonas.get(i).getCedula().equalsIgnoreCase(cedula)) {
				encontrado = true;
				indPersona = i;
			}
			i++;
		}
		return indPersona;
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
	
	public void eliminarPersona(Persona auxPersona) {
		misPersonas.remove(auxPersona);
	}
	public void modificarPersona(Persona auxPersona) {
		int ind = buscarIndPersona(auxPersona.getCedula());
		if(ind != -1) {
			misPersonas.get(ind).setNombre(auxPersona.getNombre());
			misPersonas.get(ind).setCedula(auxPersona.getCedula());
			misPersonas.get(ind).setTelefono(auxPersona.getTelefono());
			misPersonas.get(ind).setDireccion(auxPersona.getDireccion());
			misPersonas.get(ind).setFechaNacimiento(auxPersona.getFechaNacimiento());
			
			if(misPersonas.get(ind) instanceof Universitario) {
				((Universitario) misPersonas.get(ind)).setCarrera(((Universitario) auxPersona).getCarrera());
				((Universitario) misPersonas.get(ind)).setAnoGruaduacion(((Universitario) auxPersona).getAnoGruaduacion());
			}
			if(misPersonas.get(ind) instanceof Tecnico) {
				((Tecnico) misPersonas.get(ind)).setAreaTrabajo(((Tecnico) auxPersona).getAreaTrabajo());
				((Tecnico) misPersonas.get(ind)).setAnosExp(((Tecnico) auxPersona).getAnosExp());
				
			}
		
		}
	}
}
