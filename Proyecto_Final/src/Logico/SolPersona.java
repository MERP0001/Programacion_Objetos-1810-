package Logico;

import java.util.Date;

public class SolPersona extends Solicitud {

	private Persona buscaEmpleos;
	private int añosExp;
	private int porcientoMatch;
	private float salarioMinimo;
	private boolean trasnporte;
	private boolean viajar;
	
	public SolPersona(String codigo, String categoriaLaboral, String provincia, String estado,
			int horaslaborales, Date fechaVencimiento, String sexo, Persona buscaEmpleos, int añosExp,float salarioMinino ,boolean transporte, boolean viajar) {
		super(codigo, categoriaLaboral, provincia, estado, horaslaborales, añosExp, fechaVencimiento, sexo);
		
		this.buscaEmpleos = buscaEmpleos;
		this.añosExp = añosExp;
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
