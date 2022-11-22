package Logico;

import java.util.ArrayList;
import java.util.Date;

public abstract class Solicitud {
	
	protected String codigo;
	protected String categoriaLaboral;
	protected String provincia;
	protected String estado;
	protected float salario;
	protected int horaslaborales;
	
	public Solicitud(String codigo, String categoriaLaboral, String provincia, String estado, float salario,
			int horaslaborales) {
		super();
		this.codigo = codigo;
		this.categoriaLaboral = categoriaLaboral;
		this.provincia = provincia;
		this.estado = estado;
		this.salario = salario;
		this.horaslaborales = horaslaborales;
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

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public int getHoraslaborales() {
		return horaslaborales;
	}

	public void setHoraslaborales(int horaslaborales) {
		this.horaslaborales = horaslaborales;
	}
	
	
	
	
}	