package Logico;

import java.util.Date;

public class SolPersona extends Solicitud {

	private Persona buscaEmpleos;
	private int a�osExp;
	protected int porcientoMatch;
	protected int salarioMinimo;
	
	public SolPersona(String codigo, String categoriaLaboral, String provincia, String estado,
			int horaslaborales, Date fechaVencimiento, String sexo, Persona trabajador, int a�osExp) {
		super(codigo, categoriaLaboral, provincia, estado, horaslaborales, a�osExp, fechaVencimiento, sexo);
		
		this.setBuscaEmpleos(trabajador);
		this.setA�osExp(a�osExp);
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
	
	public int getSalarioMinimo() {
		return salarioMinimo;
	}
}
