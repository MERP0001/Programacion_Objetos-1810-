package Logico;

import java.util.Date;

public class SolPersona extends Solicitud {

	private Persona buscaEmpleos;
	private int añosExp;
	protected int porcientoMatch;
	protected int salarioMinimo;
	
	public SolPersona(String codigo, String categoriaLaboral, String provincia, String estado,
			int horaslaborales, Date fechaVencimiento, String sexo, Persona trabajador, int añosExp) {
		super(codigo, categoriaLaboral, provincia, estado, horaslaborales, añosExp, fechaVencimiento, sexo);
		
		this.setBuscaEmpleos(trabajador);
		this.setAñosExp(añosExp);
	}

	public Persona getBuscaEmpleos() {
		return buscaEmpleos;
	}

	public void setBuscaEmpleos(Persona buscaEmpleos) {
		this.buscaEmpleos = buscaEmpleos;
	}

	public int getAñosExp() {
		return añosExp;
	}

	public void setAñosExp(int añosExp) {
		this.añosExp = añosExp;
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
