package Logico;

import java.util.Date;

public abstract class Solicitud {
	
	protected String codigo;
	protected String categoriaLaboral;
	protected String provincia;
	protected String estado;
	protected String sexo;
	protected int horaslaborales;
	protected Date fechaVencimiento;
	protected float salario;
	
	public Solicitud(String codigo, String categoriaLaboral, String provincia, String estado, float salario,
			int horaslaborales, Date fechaVencimiento, String sexo) {
		super();
		this.codigo = codigo;
		this.categoriaLaboral = categoriaLaboral;
		this.provincia = provincia;
		this.estado = "Activo";
		this.horaslaborales = horaslaborales;
		this.fechaVencimiento = fechaVencimiento;
		this.sexo = sexo;
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

	

	public int getHoraslaborales() {
		return horaslaborales;
	}

	public void setHoraslaborales(int horaslaborales) {
		this.horaslaborales = horaslaborales;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	
	
	
}	