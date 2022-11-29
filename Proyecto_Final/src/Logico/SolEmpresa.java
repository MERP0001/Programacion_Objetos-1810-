package Logico;

import java.util.Date;

public class SolEmpresa extends Solicitud {

	private Empresa empresa;
	private int añosMinimosExp;
	private double porcientoMach;
	private int cantVacantes;
	private String ofertaLaboral;
	private boolean viajar;
	private boolean vehiculo;
	
	public SolEmpresa(String codigo, String categoriaLaboral, String provincia, String estado, float salario,
			int horaslaborales, Date fechaVencimiento, String sexo, Empresa empresa, int añosMinimosExp, double porcientoMach
			,int cantVacantes, boolean viajar, boolean vehiculo) {
		super(codigo, categoriaLaboral, provincia, estado, salario, horaslaborales, fechaVencimiento, sexo);
		
		this.empresa = empresa;
		this.añosMinimosExp = añosMinimosExp;
		this.porcientoMach = porcientoMach;
		this.cantVacantes = cantVacantes;
		this.ofertaLaboral = ofertaLaboral;
		this.viajar = viajar;
		this.vehiculo = vehiculo;
		
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
}
