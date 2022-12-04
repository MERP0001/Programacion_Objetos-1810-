package Logico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class SolPersona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Persona buscaEmpleos;
	private int añosExp;
	private int porcientoMatch;
	private float salarioMinimo;
	private boolean trasnporte;
	private boolean viajar;
	//comparativo
	private String codigo;
	private String categoriaLaboral;
	private String provincia;
	private String estado;
	private String sexo;
	private int horaslaborales;
	private Date fechaVencimiento;
	private float salario;
	private String formAcademic;
	private ArrayList<String> oficios;
	
	public SolPersona(String codigo, String categoriaLaboral, String provincia, String estado,
			int horaslaborales, Date fechaVencimiento, String sexo,String formAcademic, Persona buscaEmpleos, int añosExp,float salarioMinino 
			,boolean transporte, boolean viajar, ArrayList<String> oficios) {
		
		this.buscaEmpleos = buscaEmpleos;
		this.añosExp = añosExp;
		this.salarioMinimo = salarioMinino;
		this.trasnporte= transporte;
		this.viajar = viajar;
		//comparacion
		this.codigo = codigo;
		this.categoriaLaboral = categoriaLaboral;
		this.provincia = provincia;
		this.estado = "Activo";
		this.horaslaborales = horaslaborales;
		this.fechaVencimiento = fechaVencimiento;
		this.sexo = sexo;
		this.formAcademic = formAcademic;
		this.oficios = oficios;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getHoraslaborales() {
		return horaslaborales;
	}

	public void setHoraslaborales(int horaslaborales) {
		this.horaslaborales = horaslaborales;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public String getFormAcademic() {
		return formAcademic;
	}

	public void setFormAcademic(String formAcademic) {
		this.formAcademic = formAcademic;
	}

	public ArrayList<String> getOficios() {
		return oficios;
	}

	public void setOficios(ArrayList<String> oficios) {
		this.oficios = oficios;
	}
}