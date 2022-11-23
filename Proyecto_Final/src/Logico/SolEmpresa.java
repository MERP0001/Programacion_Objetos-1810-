package Logico;

import java.util.Date;

public class SolEmpresa extends Solicitud {

	private Empresa empresa;
	private int añosMinimosExp;
	private double porcientoMach;
	private int cantVacantes;
	
	public SolEmpresa(String codigo, String categoriaLaboral, String provincia, String estado, float salario,
			int horaslaborales, Date fechaVencimiento, String sexo, Empresa empresa, int añosMinimosExp, double porcientoMach
			,int cantVacantes) {
		super(codigo, categoriaLaboral, provincia, estado, salario, horaslaborales, fechaVencimiento, sexo);
		
		this.empresa = empresa;
		this.añosMinimosExp = añosMinimosExp;
		this.porcientoMach = porcientoMach;
		this.cantVacantes = cantVacantes;
	}

}
