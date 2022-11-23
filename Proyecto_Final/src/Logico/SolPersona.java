package Logico;

import java.util.Date;

public class SolPersona extends Solicitud {

	private Persona trabajador;
	private int a�osExp;
	
	public SolPersona(String codigo, String categoriaLaboral, String provincia, String estado, float salario,
			int horaslaborales, Date fechaVencimiento, String sexo, Persona trabajador, int a�osExp) {
		super(codigo, categoriaLaboral, provincia, estado, salario, horaslaborales, fechaVencimiento, sexo);
		
		this.trabajador = trabajador;
		this.a�osExp = a�osExp;
	}
	
}
