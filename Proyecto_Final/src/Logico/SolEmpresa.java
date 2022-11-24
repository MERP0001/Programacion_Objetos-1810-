package Logico;

import java.util.Date;

public class SolEmpresa extends Solicitud {

	private Empresa empresa;
	private int añosMinimosExp;
	private double porcientoMach;
	private int cantVacantes;
	private String ofertaLaboral;
	private int cantidadContratados = 0;
	private boolean viajar;
	private boolean vehiculo;
	private int salario;
	
	public SolEmpresa(String codigo, String categoriaLaboral, String provincia, String estado, float salario,
			int horaslaborales, Date fechaVencimiento, String sexo, Empresa empresa, int añosMinimosExp, double porcientoMach
			,int cantVacantes) {
		super(codigo, categoriaLaboral, provincia, estado, salario, horaslaborales, fechaVencimiento, sexo);
		
		this.setEmpresa(empresa);
		this.setAñosMinimosExp(añosMinimosExp);
		this.setPorcientoMach(porcientoMach);
		this.setCantVacantes(cantVacantes);
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

	public int getCantidadContratados() {
		return cantidadContratados;
	}

	public void setCantidadContratados(int cantidadContratados) {
		this.cantidadContratados = cantidadContratados;
	}
	
	public void aumentarContratados(){
		cantidadContratados++;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
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
}
