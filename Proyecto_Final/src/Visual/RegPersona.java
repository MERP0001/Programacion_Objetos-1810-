package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.BolsaEmpleo;
import Logico.Obrero;
import Logico.Persona;
import Logico.Tecnico;
import Logico.Universitario;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;

public class RegPersona extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCancelar;
	private Persona auxPersona;
	private JTextField txtNombre;
	private JFormattedTextField txtTelefono;
	private JFormattedTextField txtCedula;
	private JFormattedTextField txtFecha;
	private JTextField txtDireccion;
	private JRadioButton rdbtnObrero;
	private JRadioButton rdbtnTecnico;
	private JRadioButton rdbtnUniversitario;
	private JPanel panel_Info;
	private JPanel panel_Tipo;
	private JPanel panel_Universitario;
	private JLabel lblNewLabel_6;
	private JTextField txtCarrera;
	private JLabel lblNewLabel_7;
	private JTextField txtGraduacion;
	private JPanel panel_Tecnico;
	private JLabel lblNewLabel_8;
	private JTextField txtArea;
	private JLabel lblNewLabel_9;
	private JTextField txtExperiencia;
	private JPanel panel_Obrero;
	private JLabel lblNewLabel_10;
	private JTextField txtOficio;
	private JComboBox cbxEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegPersona dialog = new RegPersona(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegPersona(Persona persona) {
		setResizable(false);
		setModal(true);
		auxPersona = persona;
		if(auxPersona == null){
			setTitle("Registrar Persona");
		}else {
			setTitle("Modificar Persona");
		}
		setBounds(100, 100, 535, 394);
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel_Info = new JPanel();
		panel_Info.setBorder(new TitledBorder(null, "Informacion Personal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Info.setBounds(10, 10, 505, 147);
		contentPanel.add(panel_Info);
		panel_Info.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(12, 25, 56, 16);
		panel_Info.add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(12, 43, 136, 22);
		if(auxPersona != null) {
			txtNombre.setText(auxPersona.getNombre());
		}
		panel_Info.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Telefono:");
		lblNewLabel_1.setBounds(12, 70, 56, 16);
		panel_Info.add(lblNewLabel_1);

		MaskFormatter telefono = null;
		try {
			telefono = new MaskFormatter("###-###-####");
			telefono.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		txtTelefono = new JFormattedTextField(telefono);
		txtTelefono.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
		txtTelefono.setBounds(12, 93, 136, 22);
		if(auxPersona != null) {
			txtTelefono.setText(auxPersona.getTelefono());
		}
		panel_Info.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cedula:");
		lblNewLabel_2.setBounds(180, 25, 56, 16);
		panel_Info.add(lblNewLabel_2);
		
		MaskFormatter cedula = null;
		try {
			cedula = new MaskFormatter("###-#######-#");
			cedula.setPlaceholderCharacter('_');
		} catch (ParseException e) {}
		txtCedula = new JFormattedTextField(cedula);
		txtCedula.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
		txtCedula.setBounds(180, 43, 136, 22);
		if(auxPersona != null) {
			txtCedula.setText(auxPersona.getCedula());
			txtCedula.setEditable(false);
		}
		panel_Info.add(txtCedula);
		txtCedula.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha de nacimiento:");
		lblNewLabel_3.setBounds(351, 70, 136, 16);
		panel_Info.add(lblNewLabel_3);
		
		MaskFormatter fecha = null;
		try {
			fecha = new MaskFormatter("##/##/####");
			fecha.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		txtFecha = new JFormattedTextField(fecha);
		txtFecha.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
		txtFecha.setBounds(351, 93, 136, 22);
		if(auxPersona != null) {
			txtFecha.setText(auxPersona.getFechaNacimiento());
			txtFecha.setEditable(false);
		}
		panel_Info.add(txtFecha);
		txtFecha.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Estado Civil:");
		lblNewLabel_4.setBounds(351, 25, 81, 16);
		panel_Info.add(lblNewLabel_4);
		
		cbxEstado = new JComboBox();
		cbxEstado.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccione>>", "Soltero/a", "Casado/a"}));
		cbxEstado.setToolTipText("");
		cbxEstado.setBounds(351, 43, 136, 22);
		if(auxPersona != null && auxPersona.getEstado().equalsIgnoreCase("Soltero/a")) {
			cbxEstado.setSelectedIndex(1);
		}
		if(auxPersona != null && auxPersona.getEstado().equalsIgnoreCase("Casado/a")) {
			cbxEstado.setSelectedIndex(2);
		}
		panel_Info.add(cbxEstado);
		
		JLabel lblNewLabel_5 = new JLabel("Direccion:");
		lblNewLabel_5.setBounds(180, 70, 81, 16);
		panel_Info.add(lblNewLabel_5);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(180, 93, 136, 22);
		if(auxPersona != null) {
			txtDireccion.setText(auxPersona.getDireccion());
		}
		panel_Info.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		panel_Tipo = new JPanel();
		panel_Tipo.setBorder(new TitledBorder(null, "Tipo de Persona", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Tipo.setBounds(10, 160, 505, 70);
		contentPanel.add(panel_Tipo);
		panel_Tipo.setLayout(null);
		
		rdbtnUniversitario = new JRadioButton("Universitario");
		rdbtnUniversitario.setSelected(true);
		rdbtnUniversitario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnTecnico.setSelected(false);
				rdbtnObrero.setSelected(false);
				panel_Tecnico.setVisible(false);
				panel_Universitario.setVisible(true);
				panel_Obrero.setVisible(false);
			}
		});
		rdbtnUniversitario.setBounds(46, 26, 121, 23);
		panel_Tipo.add(rdbtnUniversitario);
		
		rdbtnTecnico = new JRadioButton("Tecnico");
		rdbtnTecnico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnUniversitario.setSelected(false);
				rdbtnObrero.setSelected(false);
				panel_Tecnico.setVisible(true);
				panel_Universitario.setVisible(false);
				panel_Obrero.setVisible(false);
			}
		});
		rdbtnTecnico.setBounds(207, 26, 105, 23);
		panel_Tipo.add(rdbtnTecnico);
		
		rdbtnObrero = new JRadioButton("Obrero");
		rdbtnObrero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnUniversitario.setSelected(false);
				rdbtnTecnico.setSelected(false);
				panel_Tecnico.setVisible(false);
				panel_Universitario.setVisible(false);
				panel_Obrero.setVisible(true);
			}
		});
		rdbtnObrero.setBounds(348, 26, 105, 23);
		panel_Tipo.add(rdbtnObrero);
		
		panel_Universitario = new JPanel();
		panel_Universitario.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Universitario.setBounds(10, 235, 502, 70);
		contentPanel.add(panel_Universitario);
		panel_Universitario.setLayout(null);
		
		lblNewLabel_6 = new JLabel("Carrera:");
		lblNewLabel_6.setBounds(12, 13, 56, 16);
		panel_Universitario.add(lblNewLabel_6);
		
		txtCarrera = new JTextField();
		txtCarrera.setBounds(12, 35, 126, 22);
		if(auxPersona != null && auxPersona instanceof Universitario) {
			txtCarrera.setText(((Universitario)auxPersona).getCarrera());
		}
		panel_Universitario.add(txtCarrera);
		txtCarrera.setColumns(10);
		
		lblNewLabel_7 = new JLabel("A\u00F1o de Graduacion:");
		lblNewLabel_7.setBounds(170, 13, 113, 16);
		panel_Universitario.add(lblNewLabel_7);
		
		txtGraduacion = new JTextField();
		txtGraduacion.setBounds(170, 35, 126, 22);
		if(auxPersona != null && auxPersona instanceof Universitario) {
			txtGraduacion.setText(((Universitario)auxPersona).getAnoGruaduacion());
		}
		panel_Universitario.add(txtGraduacion);
		txtGraduacion.setColumns(10);
		
		panel_Tecnico = new JPanel();
		panel_Tecnico.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Tecnico.setBounds(10, 235, 502, 70);
		contentPanel.add(panel_Tecnico);
		panel_Tecnico.setLayout(null);
		
		lblNewLabel_8 = new JLabel("Area de Trabajo:");
		lblNewLabel_8.setBounds(12, 13, 115, 16);
		panel_Tecnico.add(lblNewLabel_8);
		
		txtArea = new JTextField();
		txtArea.setBounds(12, 35, 126, 22);
		if(auxPersona != null && auxPersona instanceof Tecnico) {
			txtArea.setText(((Tecnico)auxPersona).getAreaTrabajo());
		}
		panel_Tecnico.add(txtArea);
		txtArea.setColumns(10);
		
		lblNewLabel_9 = new JLabel("A\u00F1os de Experiencia:");
		lblNewLabel_9.setBounds(170, 13, 120, 16);
		panel_Tecnico.add(lblNewLabel_9);
		
		txtExperiencia = new JTextField();
		txtExperiencia.setBounds(170, 35, 126, 22);
		if(auxPersona != null && auxPersona instanceof Tecnico) {
			txtExperiencia.setText(String.valueOf(((Tecnico)auxPersona).getAnosExp()));
		}
		panel_Tecnico.add(txtExperiencia);
		txtExperiencia.setColumns(10);
		
		panel_Obrero = new JPanel();
		panel_Obrero.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Obrero.setBounds(10, 235, 502, 70);
		contentPanel.add(panel_Obrero);
		panel_Obrero.setLayout(null);
		
		lblNewLabel_10 = new JLabel("Oficio(s):");
		lblNewLabel_10.setBounds(12, 13, 70, 16);
		panel_Obrero.add(lblNewLabel_10);
		
		txtOficio = new JTextField();
		txtOficio.setBounds(12, 35, 126, 22);
		if(auxPersona != null && auxPersona instanceof Obrero) {
			txtOficio.setText(String.valueOf(((Obrero)auxPersona).getOficios()));
		}
		panel_Obrero.add(txtOficio);
		txtOficio.setColumns(10);
		
		if(auxPersona instanceof Universitario) {
			rdbtnTecnico.setEnabled(false);
			rdbtnObrero.setEnabled(false);
			rdbtnUniversitario.setSelected(true);
			panel_Tecnico.setVisible(false);
			panel_Universitario.setVisible(true);
			panel_Obrero.setVisible(false);
		}
		if(auxPersona instanceof Tecnico) {
			rdbtnTecnico.setSelected(true);
			rdbtnObrero.setEnabled(false);
			rdbtnUniversitario.setEnabled(false);
			panel_Tecnico.setVisible(true);
			panel_Universitario.setVisible(false);
			panel_Obrero.setVisible(false);
		}
		if(auxPersona instanceof Obrero) {
			rdbtnTecnico.setEnabled(false);
			rdbtnObrero.setSelected(true);
			rdbtnUniversitario.setEnabled(false);
			panel_Tecnico.setVisible(false);
			panel_Universitario.setVisible(false);
			panel_Obrero.setVisible(true);
		}
		if(auxPersona == null) {
			rdbtnUniversitario.setSelected(true);
			panel_Universitario.setVisible(true);
			panel_Tecnico.setVisible(false);
			panel_Obrero.setVisible(false);
		}

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				if(auxPersona != null) {
					btnRegistrar.setText("Modificar");
				}
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(auxPersona == null) {
							Persona p1 = null;
							String nombre = txtNombre.getText();
							String cedula = txtCedula.getText();
							String direccion = txtDireccion.getText();
							String telefono = txtTelefono.getText();
							String fecha = txtFecha.getText();
							String estado = cbxEstado.getSelectedItem().toString();
							
							if(rdbtnUniversitario.isSelected()) {
								p1 = new Universitario(cedula, nombre, telefono, direccion, estado, txtCarrera.getText(), txtGraduacion.getText(), fecha);
							}
							if(rdbtnTecnico.isSelected()) {
								p1 = new Tecnico(cedula, nombre, telefono, direccion, estado, txtArea.getText(), Integer.parseInt(txtExperiencia.getText()), fecha);
							}
							if(rdbtnObrero.isSelected()) {
								p1 = new Obrero(cedula, nombre, telefono, direccion, estado,fecha);
								((Obrero)p1).setOficios(txtOficio.getText());
							}
							BolsaEmpleo.getInstance().insertarPersona(p1);
							JOptionPane.showMessageDialog(null, "Registro Exitoso", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							clean();
						}
						else {
							auxPersona.setNombre(txtNombre.getText());
							auxPersona.setCedula(txtCedula.getText());
							auxPersona.setDireccion(txtDireccion.getText());
							auxPersona.setFechaNacimiento(txtFecha.getText());
							auxPersona.setTelefono(txtTelefono.getText());
							auxPersona.setEstado(cbxEstado.getSelectedItem().toString());
						    if(auxPersona instanceof Universitario) {
						    	((Universitario)auxPersona).setAnoGruaduacion(txtGraduacion.getText());
						    	((Universitario)auxPersona).setCarrera(txtCarrera.getText());
						    }
						    if(auxPersona instanceof Tecnico) {
						    	((Tecnico)auxPersona).setAreaTrabajo(txtArea.getText());
						    	((Tecnico)auxPersona).setAnosExp(Integer.parseInt(txtExperiencia.getText()));
						    }
						    if(auxPersona instanceof Obrero) {
						    	((Obrero)auxPersona).setOficios(txtOficio.getText());
						    }
						    BolsaEmpleo.getInstance().modificarPersona(auxPersona);
						    dispose();
						}
						
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}

	protected void clean() {
		txtNombre.setText("");
		txtDireccion.setText("");
		txtCedula.setValue(null);
		txtTelefono.setValue(null);
		txtFecha.setValue(null);
		cbxEstado.setSelectedIndex(0);
		txtGraduacion.setText("");
		txtArea.setText("");
		txtOficio.setText("");
		txtExperiencia.setText("");
		txtCarrera.setText("");
	}
}