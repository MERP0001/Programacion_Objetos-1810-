package Logico;

public class Empresa {
	
	private String rcn;
	private String direccion;
	private String nombreEmpresa;
	private float percentageMatch;
	private float sueldo;
	
	public Empresa(String rcn, String direccion, String nombreEmpresa, float percentageMatch, float sueldo) {
		super();
		this.rcn = rcn;
		this.direccion = direccion;
		this.nombreEmpresa = nombreEmpresa;
		this.percentageMatch = percentageMatch;
		this.sueldo = sueldo;
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

	public float getPercentageMatch() {
		return percentageMatch;
	}

	public void setPercentageMatch(float percentageMatch) {
		this.percentageMatch = percentageMatch;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
}
