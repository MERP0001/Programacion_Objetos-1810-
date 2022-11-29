package Logico;

import java.util.Date;

public class SolPersona extends Solicitud {

	private Persona buscaEmpleos;
	private int a�osExp;
	private int porcientoMatch;
	private float salarioMinimo;
	private boolean trasnporte;
	private boolean viajar;
	
	public SolPersona(String codigo, String categoriaLaboral, String provincia, String estado,
			int horaslaborales, Date fechaVencimiento, String sexo, Persona buscaEmpleos, int a�osExp,float salarioMinino ,boolean transporte, boolean viajar) {
		super(codigo, categoriaLaboral, provincia, estado, horaslaborales, a�osExp, fechaVencimiento, sexo);
		
		this.buscaEmpleos = buscaEmpleos;
		this.a�osExp = a�osExp;
		this.salarioMinimo = salarioMinino;
		this.trasnporte= transporte;
		this.viajar = viajar;
	}

	public Persona getBuscaEmpleos() {
		return buscaEmpleos;
	}

	public void setBuscaEmpleos(Persona buscaEmpleos) {
		this.buscaEmpleos = buscaEmpleos;
	}

	public int getA�osExp() {
		return a�osExp;
	}

	public void setA�osExp(int a�osExp) {
		this.a�osExp = a�osExp;
	}
	
	public int getPorcientoMatch() {
		return porcientoMatch;
	}
	
	public void setPorcientoMatch(int porcientoMatch) {
		this.porcientoMatch = porcientoMatch;
	}
	
	public float getSalarioMinimo() {
		return salarioMinimo;
	}

	public boolean isTrasnporte() {
		return trasnporte;
	}

	public void setTrasnporte(boolean trasnporte) {
		this.trasnporte = trasnporte;
	}

	public void setSalarioMinimo(float salarioMinimo) {
		this.salarioMinimo = salarioMinimo;
	}

	public boolean isViajar() {
		return viajar;
	}

	public void setViajar(boolean viajar) {
		this.viajar = viajar;
	}
}
