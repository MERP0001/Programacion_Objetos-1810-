package Logico;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.ArrayList;

import sun.nio.cs.ext.ISCII91;

public class BolsaEmpleo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Persona> misPersonas;
	private ArrayList<Empresa> misEmpleos;
	//private ArrayList<Solicitud> misSolicitudes;
	private ArrayList<SolPersona> misSolPersonas;
	private ArrayList<SolEmpresa> misSolEmpresas;
	private ArrayList<Usuario> misUsuarios;
    public static BolsaEmpleo bolsaEmpleo;
    private int generadoEmpSol = 0;
	private int generadoqPerSol = 0;
	
	public BolsaEmpleo() {
		super();
		this.misPersonas = new ArrayList<Persona>();
		this.misEmpleos = new ArrayList<Empresa>();
		this.misSolEmpresas = new ArrayList<SolEmpresa>(); 
		this.misSolPersonas = new ArrayList<SolPersona>();
		this.misUsuarios = new ArrayList<Usuario>();
	}
	
	public static BolsaEmpleo getInstance() {
		if(bolsaEmpleo == null) {
			bolsaEmpleo = new BolsaEmpleo();
		}
		return bolsaEmpleo;
	}
	/*
	public ArrayList<Solicitud> getMisSolicitudes() {
		return misSolicitudes;
	}
	*/
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

	public ArrayList<SolPersona> getMisSolPersonas() {
		return misSolPersonas;
	}

	public ArrayList<SolEmpresa> getMisSolEmpresas() {
		return misSolEmpresas;
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
	
	public void insertarSolempresa(SolEmpresa aux) {
		misSolEmpresas.add(aux);
	}
	public void insertarSolpersonas(SolPersona aux) {
		misSolPersonas.add(aux);
		generadoqPerSol++;
	}
	
	public void insertarEmpresa(Empresa auxEmpresa) {
		misEmpleos.add(auxEmpresa);
		generadoEmpSol++;
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
	
	public SolEmpresa buscarIndSolicitudEmpresa(String codigo) {
		SolEmpresa aux = null;
		for (SolEmpresa solic : misSolEmpresas) {
			if(solic.getCodigo().equalsIgnoreCase(codigo)) {
				aux = solic;
			}
		}
		return aux;
	}
	
	public int buscarIndSolicitudPersona(String codigo) {
		int ind = 0;
		while(ind < misSolPersonas.size() && misSolPersonas.get(ind).getCodigo().equalsIgnoreCase(codigo)) {
			ind++;
		}
		return ind;
	}
	
	public SolPersona buscarSolicitudPersona(Persona aux) {
		int ind = 0;
		while(ind < misSolPersonas.size() && misSolPersonas.get(ind).getBuscaEmpleos() != aux) {
			ind++;
		}
		return misSolPersonas.get(ind);
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
	
	public ArrayList<SolEmpresa> buscarSolEspecico(Empresa aux){
		ArrayList<SolEmpresa> listAux = new ArrayList<SolEmpresa>();
		for (SolEmpresa solEmpresa : misSolEmpresas) {
			if(solEmpresa.getEmpresa() == aux) {
				listAux.add(solEmpresa);
			}
		}
		return listAux;
	}
	
	public ArrayList<SolPersona> buscarSolEspecicoPersona(Persona aux){
		ArrayList<SolPersona> listAux = new ArrayList<SolPersona>();
		for (SolPersona solEmpresa : misSolPersonas) {
			if(solEmpresa.getBuscaEmpleos() == aux) {
				listAux.add(solEmpresa);
			}
		}
		return listAux;
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
	public ArrayList<Persona> Macheo (SolEmpresa solEmpresa) {
		ArrayList<Persona>candidatos = new ArrayList<Persona>();
		for (SolPersona solictud : misSolPersonas) {
			if(comparacionSolicitudes(solictud, solEmpresa) != null) {
				candidatos.add(comparacionSolicitudes(solictud, solEmpresa));
			}
		}
		return candidatos;
		
	}
	public Persona comparacionSolicitudes(SolPersona solictud, SolEmpresa empresa) {
		double cantComun = 0;
		Obrero obreros = null; //(Obrero)solictud.getBuscaEmpleos();
		
		double diferencia = ((solictud.getSalarioMinimo() - empresa.getSalario()) / empresa.getSalario()) * 100;
		if(solictud.getEstado().equalsIgnoreCase("Activo")) {
			if(solictud.getFormAcademic().equalsIgnoreCase("Universitario")) {
				if(((Universitario)solictud.getBuscaEmpleos()).getCarrera().equalsIgnoreCase(empresa.getCarreraNec())) {
					cantComun += 10;	
				}
				if(solictud.getCategoriaLaboral().equalsIgnoreCase(empresa.getCategoriaLaboral())) {
					cantComun += 20;
				}
				if(solictud.getAñosExp() >= empresa.getAñosMinimosExp()){
					cantComun += 20;
				}
				if(solictud.getHoraslaborales() <= empresa.getHoraslaborales()) {
					cantComun += 10;
				}
				if(solictud.getProvincia().equalsIgnoreCase(empresa.getProvincia())) {
					cantComun += 10;
				}
				
				if(solictud.getSalarioMinimo() <= empresa.getSalario()) {
					if(diferencia <= 0.10) {
						cantComun += 20;
					}
				}
				else if(solictud.getSalarioMinimo() >= empresa.getSalario()) {
					cantComun += 20;
				}
				if(solictud.isTrasnporte() && empresa.isVehiculo()) {
					cantComun += 5;
				}
				if(solictud.isViajar() && empresa.isViajar()) {
					cantComun += 5;
					
			}
			}
			else if(solictud.getFormAcademic().equalsIgnoreCase("Tecnico")) {
				if(((Tecnico)solictud.getBuscaEmpleos()).getAreaTrabajo().equalsIgnoreCase(empresa.getAreatecnicoNec())) {
					cantComun += 10;	
				}
				if(solictud.getCategoriaLaboral().equalsIgnoreCase(empresa.getCategoriaLaboral())) {
					cantComun += 20;
				}
				if(solictud.getAñosExp() >= empresa.getAñosMinimosExp()){
					cantComun += 20;
				}
				if(solictud.getHoraslaborales() <= empresa.getHoraslaborales()) {
					cantComun += 10;
				}
				if(solictud.getProvincia().equalsIgnoreCase(empresa.getProvincia())) {
					cantComun += 10;
				}
				
				if(solictud.getSalarioMinimo() <= empresa.getSalario()) {
					if(diferencia <= 0.10) {
						cantComun += 20;
					}
				}
				else if(solictud.getSalarioMinimo() >= empresa.getSalario()) {
					cantComun += 20;
				}
				if(solictud.isTrasnporte() && empresa.isVehiculo()) {
					cantComun += 5;
				}
				if(solictud.isViajar() && empresa.isViajar()) {
					cantComun += 5;	
			}
			}
			else if(solictud.getFormAcademic().equalsIgnoreCase("Obrero")) { 
				if(solictud.getCategoriaLaboral().equalsIgnoreCase(empresa.getCategoriaLaboral())) {
					cantComun += 20;
				}
				if(compareOficios(obreros.getOficios(), empresa.getOficioNec()) > 0) {
					if(compareOficios(obreros.getOficios(), empresa.getOficioNec()) <= 1 ) {
						cantComun += 10;
					}
				}
				
				if(solictud.getAñosExp() >= empresa.getAñosMinimosExp()){
					cantComun += 20;
				}
				if(solictud.getHoraslaborales() <= empresa.getHoraslaborales()) {
					cantComun += 10;
				}
				if(solictud.getProvincia().equalsIgnoreCase(empresa.getProvincia())) {
					cantComun += 10;
				}
				
				if(solictud.getSalarioMinimo() <= empresa.getSalario()) {
					if(diferencia <= 0.10) {
						cantComun += 20;
					}
				}
				else if(solictud.getSalarioMinimo() >= empresa.getSalario()) {
					cantComun += 20;
				}
				if(solictud.isTrasnporte() && empresa.isVehiculo()) {
					cantComun += 5;
				}
				if(solictud.isViajar() && empresa.isViajar()) {
					cantComun += 5;	
			}
			}
		}
		System.out.println("Resultado = "+cantComun+" "+empresa.getPorcientoMach());
		if(empresa.getPorcientoMach() <= cantComun) {
			System.out.println("se logro");
			return solictud.getBuscaEmpleos();
		}
		return null;
	}
	
	public int compareOficios(ArrayList<String> oficiosPersona, ArrayList<String> oficiosNec) {
		int ind = 0;
		for (String string : oficiosPersona) {
            for (String string2 : oficiosNec) {
                if(string2.equalsIgnoreCase(string)) {
                	ind++;
                }
            }
        }
		return ind;
	}

	public void contratarPersona(Persona auxPer, SolEmpresa aux) {
		SolPersona candidato = buscarSolicitudPersona(auxPer);
		candidato.setEstado("Finalizado");
		auxPer.setEstado("contratado");
		aux.getEmpresa().IngresarEmpleado(auxPer);
		aux.setCantVacantes(aux.getCantVacantes() - 1);
	}

}