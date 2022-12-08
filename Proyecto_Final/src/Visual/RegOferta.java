
package Visual;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import Logico.BolsaEmpleo;
import Logico.Empresa;
import Logico.SolEmpresa;
import Logico.Usuario;
import javax.swing.border.LineBorder;
import java.awt.Color;


public class RegOferta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JComboBox cbxCategoriaLab;
	private JTextField OfertaLaboral;
	private JSpinner spnVacantes;
	private JSpinner spnSalario;
	private JTextField txtOfertaLab;
	private JComboBox cbxNivelEstudio;
	private JComboBox cbxVariable;
	private JComboBox cbxPeriodoPago;
	private JComboBox cbxJornada;
	private JComboBox cbxTipoDeContrato;
	private JSpinner spnFechaVencimiento;
	private JComboBox cbxAreaTecnica;
	private JComboBox cbxGenero;
	private JSpinner spnAExp;
	private JComboBox<String> cbxVariable_1;
	private JSpinner spnSalario_1;
	private JSpinner spnExperiencia;
	private JComboBox cbxJornada_1;
	
	public RegOferta(final Empresa user) {
		setTitle("Crear oferta de trabajo");
		setBounds(100, 100, 541, 713);
		ImageIcon logo = new ImageIcon("src/imagenes/oferta.jpeg");
		setIconImage(logo.getImage());
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(173, 216, 230));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		final JRadioButton rdbtnVehiculo = new JRadioButton("Vehiculo propio necesario");
		rdbtnVehiculo.setBackground(new Color(173, 216, 230));
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPanel.add(panel, BorderLayout.CENTER);
		final JRadioButton rdbtnViajar = new JRadioButton("Disponibilidad para viajar necesaria");
		rdbtnViajar.setBackground(new Color(173, 216, 230));
		panel.setLayout(null);
		
		JLabel lblNombreDeLa = new JLabel("Nombre de la empresa> ");
		lblNombreDeLa.setBounds(10, 25, 122, 14);
		panel.add(lblNombreDeLa);
		
		JLabel lblOfertaLaboral = new JLabel("Oferta laboral:");
		lblOfertaLaboral.setBounds(258, 56, 122, 14);
		panel.add(lblOfertaLaboral);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(142, 20, 238, 25);
		txtNombre.setText(((Empresa)user).getNombreEmpresa());
		final JLabel lblCarrera = new JLabel("Carrera:");
		panel.add(txtNombre);
		spnExperiencia = new JSpinner();
		spnExperiencia.setForeground(new Color(210, 105, 30));
		
		final JSpinner spnVacantes = new JSpinner();
		spnVacantes.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnVacantes.setBounds(431, 251, 65, 25);
		panel.add(spnVacantes);
		
		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setBounds(257, 178, 122, 14);
		panel.add(lblProvincia);
		
		final JComboBox cbxProvincia = new JComboBox();
		cbxProvincia.setModel(new DefaultComboBoxModel(new String[] {"Azua", "Bahoruco", "Barahona", "Dajab\u00F3n", "Duarte", "El Seibo", "El\u00EDas Pi\u00F1a", "Espaillat", "Hato Mayor", "Hermanas Mirabal", "Independencia", "La Altagracia", "La Romana", "La Vega", "Maria Trinidad S\u00E1nchez", "Monse\u00F1or Nouel", "Monte Cristi", "Monte Plata", "Pedernales", "Peravia", "Puerto Plata", "Saman\u00E1", "San Cristobal", "San Jos\u00E9 De Ocoa", "San Juan", "San Pedro De Macoris", "S\u00E1nchez Ram\u00EDrez", "Santiago", "Santiago Rodr\u00EDguez", "Santo Domingo", "Valverde", "Distrito Nacional"}));
		cbxProvincia.setBounds(257, 203, 239, 25);
		cbxProvincia.setSelectedItem(((Empresa)user).getDireccion());
		panel.add(cbxProvincia);
		
		JLabel label_3 = new JLabel("Cantidad de vacantes:");
		label_3.setBounds(258, 256, 163, 14);
		panel.add(label_3);
		
		JLabel lblSalario = new JLabel("Salario:");
		lblSalario.setBounds(10, 462, 122, 14);
		panel.add(lblSalario);
		
		spnSalario_1 = new JSpinner();
		spnSalario_1.setModel(new SpinnerNumberModel(new Float(12000), new Float(12000), null, new Float(1)));
		spnSalario_1.setBounds(10, 487, 237, 25);
		panel.add(spnSalario_1);
		
		JComboBox cbxPeriodoPago = new JComboBox();
		cbxPeriodoPago.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Quincenal", "Mensual"}));
		cbxPeriodoPago.setBounds(258, 426, 239, 25);
		panel.add(cbxPeriodoPago);
		
		JLabel lblPeriodoDePago = new JLabel("Periodo de pago:");
		lblPeriodoDePago.setBounds(258, 401, 122, 14);
		panel.add(lblPeriodoDePago);
		
		cbxJornada_1 = new JComboBox();
		cbxJornada_1.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Tiempo completo", "Medio tiempo"}));
		cbxJornada_1.setBounds(8, 548, 239, 25);
		panel.add(cbxJornada_1);
		
		JComboBox cbxTipoDeContrato = new JComboBox();
		cbxTipoDeContrato.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Por tiempo indefinido", "Por tiempo definido"}));
		cbxTipoDeContrato.setBounds(258, 487, 239, 25);
		panel.add(cbxTipoDeContrato);
		
		JLabel lblTipoDeContrato = new JLabel("Tipo de contrato:");
		lblTipoDeContrato.setBounds(258, 462, 122, 14);
		panel.add(lblTipoDeContrato);
		
		JLabel lblJornada = new JLabel("Jornada:");
		lblJornada.setBounds(10, 523, 122, 14);
		panel.add(lblJornada);
		JLabel lblFechaDeVencimiento = new JLabel("Genero:");
		lblFechaDeVencimiento.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFechaDeVencimiento.setBounds(12, 183, 136, 14);
		panel.add(lblFechaDeVencimiento);
		final JComboBox cbxCategoriaLab = new JComboBox();
		final JSpinner spnPorciento = new JSpinner();
		JButton button = new JButton("Crear oferta");
		cbxAreaTecnica = new JComboBox();
		cbxVariable_1 = new JComboBox();
		cbxVariable_1.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Administraci\u00F3n hotelera", "Arquitectura", "Comunicaci\u00F3n social", "Derecho", "Dise\u00F1o e interiorismo", "Econom\u00EDa", "Eduaci\u00F3n", "Estomatolog\u00EDa", "Filosof\u00EDa", "Gesti\u00F3n financiera", "Ingenier\u00EDa civil", "Ingenieria m\u00E9canica", "Ingenier\u00EDa el\u00E9ctrica", "Ingenier\u00EDa industrial", "Ingenier\u00EDa mecatr\u00F3nica", "Ingenier\u00EDa de ciencias de la computaci\u00F3n", "Ingenier\u00EDa telem\u00E1tica", "Ingenier\u00EDa Ambiental", "Medic\u00EDna", "Marketing", "Nutrici\u00F3n", "Psicolog\u00EDa", "Terapia f\u00EDsica", "Trabajo social", "Hospitalidad y turismo"}));
		cbxAreaTecnica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cbxAreaTecnica.getSelectedItem().toString().equalsIgnoreCase("Universitario")) {
					cbxVariable_1.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Administraci\u00F3n hotelera", "Arquitectura", "Comunicaci\u00F3n social", "Derecho", "Dise\u00F1o e interiorismo", "Econom\u00EDa", "Eduaci\u00F3n", "Estomatolog\u00EDa", "Filosof\u00EDa", "Gesti\u00F3n financiera", "Ingenier\u00EDa civil", "Ingenieria m\u00E9canica", "Ingenier\u00EDa el\u00E9ctrica", "Ingenier\u00EDa industrial", "Ingenier\u00EDa mecatr\u00F3nica", "Ingenier\u00EDa de ciencias de la computaci\u00F3n", "Ingenier\u00EDa telem\u00E1tica", "Ingenier\u00EDa Ambiental", "Medic\u00EDna", "Marketing", "Nutrici\u00F3n", "Psicolog\u00EDa", "Terapia f\u00EDsica", "Trabajo social", "Hospitalidad y turismo"}));
					lblCarrera.setText("Carrera:");
				}
				if(cbxAreaTecnica.getSelectedItem().toString().equalsIgnoreCase("Educación Básica")) {
					cbxVariable_1.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Alba\u00F1il", "Asistente de tienda", "Bibliotecario", "Bombero", "Carnicero", "Carpintero", "Cartero", "Chofer", "Electricista", "Florista", "Granjero", "Jardinero", "Limpiador", "Mec\u00E1nico", "Panadero", "Peluquero", "Plomero", "Secretario", "Sastre"}));
					lblCarrera.setText("Oficio:");
				}
				if(cbxAreaTecnica.getSelectedItem().toString().equalsIgnoreCase("Técnico")) {
					cbxVariable_1.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Automatizaci\u00F3n", "Artes culinarias", "Admistracion de empresas", "Dise\u00F1o gr\u00E1fico", "Enfermer\u00EDa", "Gesti\u00F3n social", "Logistica integral", "Microfinanzas", "Mercado", "Programaci\u00F3n web", "Publicidad", "Redes de datos"}));
					lblCarrera.setText("Área técnica:");
				}
			}
		});
		
			
		txtOfertaLab = new JTextField();
		cbxAreaTecnica.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Universitario", "T\u00E9cnico", "Educaci\u00F3n b\u00E1sica"}));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int jornada = 0;
				boolean viaDip , transDip;
				viaDip = transDip = false;
				String carrera = cbxVariable_1.getSelectedItem().toString();
			    System.out.println(carrera);
		
				if(String.valueOf(cbxJornada_1.getSelectedItem()).equalsIgnoreCase("Tiempo completo")) {
					jornada = 8;
				}
				if(String.valueOf(cbxJornada_1.getSelectedItem()).equalsIgnoreCase("Medio tiempo")) {
					jornada = 4;
				}
				if(rdbtnVehiculo.isSelected()) {
					transDip = true;
				}
				if(rdbtnViajar.isSelected()) {
					viaDip = true;
				}
				
				
				
				if (cbxAreaTecnica.getSelectedIndex() == 1) {
					SolEmpresa auxOfertaUni = new SolEmpresa("CS-"+String.valueOf(BolsaEmpleo.getInstance().getGeneradoEmpSol()), cbxCategoriaLab.getSelectedItem().toString(), 
							cbxProvincia.getSelectedItem().toString(), "Activo", Float.valueOf(spnSalario_1.getValue().toString()), 
							jornada, null, cbxGenero.getSelectedItem().toString(), 
							cbxAreaTecnica.getSelectedItem().toString(), user, Integer.valueOf(spnExperiencia.getValue().toString()), 
							Double.valueOf(spnPorciento.getValue().toString()), Integer.valueOf(spnVacantes.getValue().toString()), viaDip, 
							transDip, carrera, null, 
							null, 0, null);        
					BolsaEmpleo.getInstance().insertarSolempresa(auxOfertaUni);
					        System.out.println(spnSalario_1.getValue().toString());
					        System.out.println(cbxVariable_1.getSelectedItem().toString());
					        System.out.println(auxOfertaUni.getCategoriaLaboral()+" "+auxOfertaUni.getCarreraNec()+" "+auxOfertaUni.getEstado()+" "+auxOfertaUni.getPorcientoMach()+" "+auxOfertaUni.getSalario());
					        JOptionPane.showMessageDialog(null, "La oferta se ha creado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
				}
				if (cbxAreaTecnica.getSelectedIndex() == 2) {
					SolEmpresa auxOfertaTec = new SolEmpresa("CS-"+String.valueOf(BolsaEmpleo.getInstance().getGeneradoEmpSol()), String.valueOf(cbxCategoriaLab.getSelectedItem()),
							String.valueOf(cbxProvincia.getSelectedItem()), "Activo", Float.valueOf(String.valueOf(spnSalario_1.getValue().toString())),
							jornada, null, cbxGenero.getSelectedItem().toString(),  cbxAreaTecnica.getSelectedItem().toString(), user, Integer.valueOf(spnExperiencia.getValue().toString()),
							Double.valueOf(spnPorciento.getValue().toString()), Integer.valueOf(spnVacantes.getValue().toString()), 
							viaDip, transDip, cbxVariable_1.getSelectedItem().toString()/*TecnicoNec*/,null,null , Integer.valueOf(spnAExp.getValue().toString()), null);
					BolsaEmpleo.getInstance().insertarSolempresa(auxOfertaTec);
					JOptionPane.showMessageDialog(null, "La oferta se ha creado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
				}
				if(cbxAreaTecnica.getSelectedIndex() == 3) {
					SolEmpresa auxOfertaTec = new SolEmpresa("CS-"+String.valueOf(BolsaEmpleo.getInstance().getGeneradoEmpSol()), String.valueOf(cbxCategoriaLab.getSelectedItem()),
							String.valueOf(cbxProvincia.getSelectedItem()), "Activo", Float.valueOf(String.valueOf(spnSalario_1.getValue().toString())),
							jornada, null, cbxGenero.getSelectedItem().toString(),  cbxAreaTecnica.getSelectedItem().toString(), user, Integer.valueOf(spnExperiencia.getValue().toString()),
							Double.valueOf(spnPorciento.getValue().toString()), Integer.valueOf(spnVacantes.getValue().toString()), 
							viaDip, transDip, cbxVariable_1.getSelectedItem().toString()/*OficioNec*/,null,null , 0, null);
					BolsaEmpleo.getInstance().insertarSolempresa(auxOfertaTec);
					JOptionPane.showMessageDialog(null, "La oferta se ha creado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
				}

				clean();
			}
		});
		
		button.setBounds(309, 621, 195, 32);
		panel.add(button);
		
		JLabel lblCategoriaLaboral = new JLabel("Categoria laboral:");
		lblCategoriaLaboral.setBounds(10, 56, 238, 14);
		panel.add(lblCategoriaLaboral);
		
		
		cbxCategoriaLab.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Mercado Financiero", "Crecimiento Econ\u00F3mico", "Biotecnolog\u00EDa y Seguridad Qu\u00EDmica", "Desarrollo Regional y Rural Urbano", "Turismo", "Medio Ambiente", "Comercio", "Asuntos Sociales y Bienestar", "Pymes y Emprendimiento", "Tecnolog\u00EDa de la Informaci\u00F3n y Comunicaciones", "Energ\u00EDa", "Legal", "Seguros y Pensiones", "Educaci\u00F3n", "Migraci\u00F3n", "Industrias y Servicios", "Inversiones", "Gobierno y Administraci\u00F3n P\u00FAblica", "Agricultura", "Pesca", "Salud", "Contabilidad"}));
		cbxCategoriaLab.setBounds(10, 81, 239, 25);
		panel.add(cbxCategoriaLab);
		//cbxCategoriaLab.setSelectedItem(((Empresa)user).getCategoriaLaboral());
		
		
		cbxAreaTecnica.setBounds(9, 142, 239, 25);
		panel.add(cbxAreaTecnica);
		
		JLabel lblNivelDeEstudio = new JLabel("Nivel de estudio requerido:");
		lblNivelDeEstudio.setBounds(9, 117, 238, 14);
		panel.add(lblNivelDeEstudio);
		
		txtOfertaLab.setText((String) null);
		txtOfertaLab.setColumns(10);
		txtOfertaLab.setBounds(258, 81, 238, 25);
		panel.add(txtOfertaLab);
		
		 
		lblCarrera.setBounds(257, 117, 137, 14);
		panel.add(lblCarrera);
		
		
		cbxVariable_1.setBounds(257, 142, 239, 25);
		panel.add(cbxVariable_1);
		
		
		spnPorciento.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		spnPorciento.setBounds(258, 548, 237, 25);
		panel.add(spnPorciento);
		
		JLabel lblPorcientoDeMatch = new JLabel("Porcentaje para contratar al candidato:");
		lblPorcientoDeMatch.setBounds(258, 523, 237, 14);
		panel.add(lblPorcientoDeMatch);
		
		
		spnExperiencia.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnExperiencia.setBounds(10, 426, 237, 25);
		panel.add(spnExperiencia);
		
		JLabel lblAnnosexperiencia = new JLabel("A\u00F1os de experiencia requeridos:");
		lblAnnosexperiencia.setBounds(10, 401, 208, 14);
		panel.add(lblAnnosexperiencia);
		
		
		rdbtnVehiculo.setBounds(309, 322, 147, 23);
		panel.add(rdbtnVehiculo);
		
		
		rdbtnViajar.setBounds(10, 322, 195, 23);
		panel.add(rdbtnViajar);
		
		cbxGenero = new JComboBox();
		cbxGenero.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Hombre", "Mujer", "Otro"}));
		cbxGenero.setBounds(13, 203, 234, 25);
		panel.add(cbxGenero);
		
		JLabel lblNewLabel = new JLabel("A\u00F1os de Exp:");
		lblNewLabel.setBounds(10, 256, 79, 14);
		panel.add(lblNewLabel);
		
		spnAExp = new JSpinner();
		spnAExp.setBounds(182, 251, 65, 25);
		panel.add(spnAExp);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(173, 216, 230));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 367, 515, 243);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(173, 216, 230));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(0, 308, 515, 60);
		panel.add(panel_2);
	}
	
	private void clean() {
		txtOfertaLab.setText("");
		cbxNivelEstudio.setSelectedIndex(0);
		cbxVariable.setSelectedIndex(0);
		spnVacantes.setValue(Integer.parseInt("1"));
		spnSalario.setValue(Integer.parseInt("12,000"));
		cbxJornada.setSelectedIndex(0);
		cbxPeriodoPago.setSelectedIndex(0);
		cbxTipoDeContrato.setSelectedIndex(0);
		spnFechaVencimiento.setValue(new Date());
		cbxVariable.setSelectedIndex(0);
		spnAExp.setValue(Integer.parseInt("0"));
		
	}
}
