package Logico;

import java.util.ArrayList;

public class BolsaEmpleo {

	private ArrayList<Persona> misPersonas;
	private ArrayList<Empresa> misEmpleos;
	private ArrayList<Solicitud> misSolicitudes;
	private ArrayList<Usuario> misUsuarios;
    public static BolsaEmpleo bolsaEmpleo;
    private int generadoEmpSol = 0;
	private int generadoqPerSol = 0;
	
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
	
	public ArrayList<Solicitud> getMisSolicitudes() {
		return misSolicitudes;
	}

	public ArrayList<Usuario> getMisUsuarios() {
		return misUsuarios;
	}
	
	public ArrayList<Persona> getMisPersonas() {
		return misPersonas;
	}

	public ArrayList<Empresa> getMisEmpleos() {
		return misEmpleos;
	}
	
	public int getGeneradoEmpSol() {
		return generadoEmpSol;
	}

	public int getGeneradoqPerSol() {
		return generadoqPerSol;
	}

	//Creacion========================================================================================================================
	public void insertarPersona(Persona auxPersona) {
		misPersonas.add(auxPersona);
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
	
	public void crearSolicitud(Solicitud auxSol) {
		if(auxSol instanceof SolEmpresa) {
			generadoEmpSol++;
			misSolicitudes.add(auxSol);
		}
		
		if(auxSol instanceof SolPersona) {
			generadoqPerSol++;
			misSolicitudes.add(auxSol);
		}
		
	}
	
	public void insertarEmpresa(Empresa auxEmpresa) {
		misEmpleos.add(auxEmpresa);
	}
	//Cierre de creaciones==========================================================================================================
	
	
	
	
	//Buscadores===================================================================================================================
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
	
	public int buscarIndSolicitud(String codigo) {
		int ind = 0;
		while(ind < misSolicitudes.size() && misSolicitudes.get(ind).getCodigo().equalsIgnoreCase(codigo)) {
			ind++;
		}
		return ind;
	}
	
	public Empresa buscarEmpresa(String rcn) {
		Empresa auxEmpresa = null;
		boolean encontrar = false;
		int i = 0;
		while(i<misEmpleos.size() && !encontrar) {
			if(misEmpleos.get(i).getRcn().equalsIgnoreCase(rcn)) {
				auxEmpresa = misEmpleos.get(i);
				encontrar = true;
			}
			i++;
		}
		return auxEmpresa;

	}
	
	private int buscarIndEmpresa(String rcn) {
		int indEmpresa = -1;
		int i = 0;
		boolean encontrado = false;
		while (!encontrado && i < misEmpleos.size()) {
			if (misEmpleos.get(i).getRcn().equalsIgnoreCase(rcn)) {
				encontrado = true;
				indEmpresa = i;
			}
			i++;
		}
		return indEmpresa;
	}
	//Cierre de Buscadores==============================================================================================================================
	
	//Eliminadores========================================================================================================================================
	public void eliminarEmpresa(Empresa auxEmpresa) {
		misEmpleos.remove(auxEmpresa);
	}
	
	public void eliminarPersona(Persona auxPersona) {
		misPersonas.remove(auxPersona);
	}
	//Cierre de Eliminadores===================================================================================================================================
	
	//Modificadores========================================================================================================================================
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
	
	
	public void modificarEmpresa(Empresa auxEmpresa) {
		int ind = buscarIndEmpresa(auxEmpresa.getRcn());
		if(ind != -1) {
			misEmpleos.get(ind).setNombreEmpresa(auxEmpresa.getNombreEmpresa());
			misEmpleos.get(ind).setRcn(auxEmpresa.getRcn());
			misEmpleos.get(ind).setDireccion(auxEmpresa.getDireccion());
		}
	}
	//cierre de Modificadores=======================================================================================================================
	public double MacheoForEmpresa() {
		double porcentae;
		
		
		return 0.0;
	}
	public double MacheoForPersona() {
		double porcentaje = 0;
		return porcentaje;
	}





}