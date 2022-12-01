package Logico;

import java.util.Date;

public class SolEmpresa{

	private Empresa empresa;
	private int añosMinimosExp;
	private double porcientoMach;
	private int cantVacantes;
	private String ofertaLaboral;
	private boolean viajar;
	private boolean vehiculo;
    //Comparativos
	protected String codigo;
	protected String categoriaLaboral;
	protected String provincia;
	protected String estado;
	protected String sexo;
	protected int horaslaborales;
	protected Date fechaVencimiento;
	protected float salario;
	
	public SolEmpresa(String codigo, String categoriaLaboral, String provincia, String estado, float salario,
			int horaslaborales, Date fechaVencimiento, String sexo, Empresa empresa, int añosMinimosExp, double porcientoMach
			,int cantVacantes, boolean viajar, boolean vehiculo) {
		
		this.empresa = empresa;
		this.añosMinimosExp = añosMinimosExp;
		this.porcientoMach = porcientoMach;
		this.cantVacantes = cantVacantes;
		this.ofertaLaboral = ofertaLaboral;
		this.viajar = viajar;
		this.vehiculo = vehiculo;
		//comparacion
		this.codigo = codigo;
		this.categoriaLaboral = categoriaLaboral;
		this.provincia = provincia;
		this.estado = "Activo";
		this.horaslaborales = horaslaborales;
		this.fechaVencimiento = fechaVencimiento;
		this.sexo = sexo;
		
	}

	public int getAñosMinimosExp() {
		return añosMinimosExp;
	}

	public void setAñosMinimosExp(int añosMinimosExp) {
		this.añosMinimosExp = añosMinimosExp;
	}

	public double getPorcientoMach() {
		return porcientoMach;
	}

	public void setPorcientoMach(double porcientoMach) {
		this.porcientoMach = porcientoMach;
	}

	public int getCantVacantes() {
		return cantVacantes;
	}

	public void setCantVacantes(int cantVacantes) {
		this.cantVacantes = cantVacantes;
	}

	public void dismVacantes(){
		cantVacantes--;
	}
	
	public void aumentaVacantes(){
		cantVacantes++;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getOfertaLaboral() {
		return ofertaLaboral;
	}

	public void setOfertaLaboral(String ofertaLaboral) {
		this.ofertaLaboral = ofertaLaboral;
	}

	public boolean isVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(boolean vehiculo) {
		this.vehiculo = vehiculo;
	}

	public boolean isViajar() {
		return viajar;
	}

	public void setViajar(boolean viajar) {
		this.viajar = viajar;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCategoriaLaboral() {
		return categoriaLaboral;
	}

	public void setCategoriaLaboral(String categoriaLaboral) {
		this.categoriaLaboral = categoriaLaboral;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getHoraslaborales() {
		return horaslaborales;
	}

	public void setHoraslaborales(int horaslaborales) {
		this.horaslaborales = horaslaborales;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}
}
