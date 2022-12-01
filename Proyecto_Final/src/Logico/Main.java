package Logico;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tecnico tecni = new Tecnico("9-09-090-90", "Tu gvo", "876544556", "juanito", "Casado", "Mercado", 10, "12/12/1999");
		SolPersona soli = new SolPersona("C-12", "Mercado", "La Vega", "Activo", 8, null, "Hombre", tecni, 10, 10000, true, true);
		SolPersona soli2 = new SolPersona("C-13", "Nada", "La Vega", "Activo", 4, null, "Mujer", tecni, 2, 20000, false, false);
		Empresa empresa = new Empresa("8091283091", "calle villa", "Moises.Inc");
		SolEmpresa solEMp = new SolEmpresa("CP-13", "Mercado", "Santiago", "Activo", 15000, 8, null, "hombre", empresa, 10, 50, 10, true, false);
		BolsaEmpleo bolsa = new BolsaEmpleo();
		bolsa.getInstance().crearPersona(tecni);
		bolsa.getInstance().crearEmpresa(empresa);
		bolsa.getInstance().insertarSolpersonas(soli);
		bolsa.getInstance().insertarSolpersonas(soli2);
		bolsa.getInstance().insertarSolempresa(solEMp);
		
		System.out.println(bolsa.getInstance().getMisPersonas().size());
		System.out.println(bolsa.getInstance().getMisEmpleos().size());
		System.out.println(bolsa.getInstance().getMisSolEmpresas().size());
		System.out.println(bolsa.getInstance().getMisSolPersonas().size());
		System.out.println("La prueba del mateo ==== ");
		ArrayList<Persona>candidatos = new ArrayList<Persona>();
		System.out.println(candidatos.size());
		candidatos = bolsa.getInstance().Macheo(solEMp);
		System.out.println(candidatos.size());
	}

}
