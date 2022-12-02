package Logico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class SolEmpresa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Empresa empresa;
	private int añosMinimosExp;
	private double porcientoMach;
	private int cantVacantes;
	private String ofertaLaboral;
	private boolean viajar;
	private boolean vehiculo;
    //Comparativos
	private String codigo;
	private String categoriaLaboral;
	private String provincia;
	private String estado;
	private String sexo;
	private int horaslaborales;
	private Date fechaVencimiento;
	private float salario;
	private String formAca;
	private String carreraNec;
	private String areatecnicoNec;
	private ArrayList<String> oficioNec;
	private int anosExp;
	
	public SolEmpresa(String codigo, String categoriaLaboral, String provincia, String estado, float salario,
			int horaslaborales, Date fechaVencimiento, String sexo,String formAca, Empresa empresa, int añosMinimosExp, double porcientoMach
			,int cantVacantes, boolean viajar, boolean vehiculo,String carreraNec, String ofertaLaboral, String areatecnicoNec, int anosExp,ArrayList<String> oficiosNec) {
		
		this.empresa = empresa;
		this.añosMinimosExp = añosMinimosExp;
		this.porcientoMach = porcientoMach;
		this.cantVacantes = cantVacantes;
		this.ofertaLaboral = ofertaLaboral;
		this.viajar = viajar;
		this.vehiculo = vehiculo;
		//comparacion
		this.codigo = codigo;
		this.categoriaLaboral = categoriaLaboral;
		this.provincia = provincia;
		this.estado = "Activo";
		this.horaslaborales = horaslaborales;
		this.fechaVencimiento = fechaVencimiento;
		this.sexo = sexo;
		this.setFormAca(formAca);
		this.setAnosExp(anosExp);
		this.areatecnicoNec = areatecnicoNec;
		this.oficioNec = new ArrayList<String>();
		
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

	public ArrayList<String> getOficioNec() {
		return oficioNec;
	}

	public void setOficioNec(ArrayList<String> oficioNec) {
		this.oficioNec = oficioNec;
	}

	public String getAreatecnicoNec() {
		return areatecnicoNec;
	}

	public void setAreatecnicoNec(String areatecnicoNec) {
		this.areatecnicoNec = areatecnicoNec;
	}

	public String getCarreraNec() {
		return carreraNec;
	}

	public void setCarreraNec(String carreraNec) {
		this.carreraNec = carreraNec;
	}

	public String getFormAca() {
		return formAca;
	}

	public void setFormAca(String formAca) {
		this.formAca = formAca;
	}

	public int getAnosExp() {
		return anosExp;
	}

	public void setAnosExp(int anosExp) {
		this.anosExp = anosExp;
	}
}
