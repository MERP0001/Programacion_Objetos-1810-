package Logico;

import java.util.ArrayList;
import java.util.Date;

public class Solicitud {
	
	private String tipo;
	private String carrera;
	private String areaTrabajo;
	private int anoExp;
	private Date graduacion;
	private ArrayList<String> oficios;
	//
	public Solicitud(String tipo, String carrera, String areaTrabajo, int anoExp, Date graduacion,
			ArrayList<String> oficios) {
		super();
		this.tipo = tipo;
		this.carrera = carrera;
		this.areaTrabajo = areaTrabajo;
		this.anoExp = anoExp;
		this.graduacion = graduacion;
		this.oficios = oficios;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getAreaTrabajo() {
		return areaTrabajo;
	}

	public void setAreaTrabajo(String areaTrabajo) {
		this.areaTrabajo = areaTrabajo;
	}

	public int getAnoExp() {
		return anoExp;
	}

	public void setAnoExp(int anoExp) {
		this.anoExp = anoExp;
	}

	public Date getGraduacion() {
		return graduacion;
	}

	public void setGraduacion(Date graduacion) {
		this.graduacion = graduacion;
	}

	public ArrayList<String> getOficios() {
		return oficios;
	}

	public void setOficios(ArrayList<String> oficios) {
		this.oficios = oficios;
	}
}
