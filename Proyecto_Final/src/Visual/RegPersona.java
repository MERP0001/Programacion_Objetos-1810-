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
	private JPanel panel_Info;
	private JComboBox cbxEstado;
	private JRadioButton rdbtnUniversitario;
	private JRadioButton rdbtnTecnico;
	private JRadioButton rdbtnObrero;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public RegPersona(Persona persona) {
		setTitle("Registro de Usuario");
		setResizable(false);
		setModal(true);
		auxPersona = persona;
		if(auxPersona == null){
			setTitle("Registrar Persona");
		}else {
			setTitle("Modificar Persona");
			if(persona instanceof Universitario) {
				
			}
			
			if(persona instanceof Tecnico) {
				
			}
			
			if(persona instanceof Obrero) {
				
			}
		}
		setBounds(100, 100, 535, 302);
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel_Info = new JPanel();
		panel_Info.setBorder(new TitledBorder(null, "Informacion Personal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Info.setBounds(10, 10, 505, 137);
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
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 158, 505, 66);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		rdbtnUniversitario = new JRadioButton("Universitario");
		rdbtnUniversitario.setBounds(6, 20, 109, 23);
		panel.add(rdbtnUniversitario);
		
		rdbtnTecnico = new JRadioButton("Tecnico");
		rdbtnTecnico.setBounds(183, 20, 109, 23);
		panel.add(rdbtnTecnico);
		
		rdbtnObrero = new JRadioButton("Obrero");
		rdbtnObrero.setBounds(354, 20, 109, 23);
		panel.add(rdbtnObrero);
		
		if(auxPersona instanceof Universitario) {
			rdbtnTecnico.setEnabled(false);
			rdbtnObrero.setEnabled(false);
			rdbtnUniversitario.setSelected(true);
			
		}
		if(auxPersona instanceof Tecnico) {
			rdbtnTecnico.setSelected(true);
			rdbtnObrero.setEnabled(false);
			rdbtnUniversitario.setEnabled(false);
			
		}
		if(auxPersona instanceof Obrero) {
			rdbtnTecnico.setEnabled(false);
			rdbtnObrero.setSelected(true);
			rdbtnUniversitario.setEnabled(false);
			
		}
		if(auxPersona == null) {
			rdbtnUniversitario.setSelected(true);
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
						if(!txtCedula.getText().isEmpty() && !txtNombre.getText().isEmpty() && !txtDireccion.getText().isEmpty() && !txtTelefono.getText().isEmpty() && cbxEstado.getSelectedIndex() > 0) {

							if(auxPersona == null) {
								Persona p1 = null;
								String nombre = txtNombre.getText();
								String cedula = txtCedula.getText();
								String direccion = txtDireccion.getText();
								String telefono = txtTelefono.getText();
								String fecha = txtFecha.getText();
								String estado = cbxEstado.getSelectedItem().toString();
								
								if(rdbtnUniversitario.isSelected()) {
									p1 = new Universitario(cedula, nombre, telefono, direccion, estado,"", "", fecha);
								}
								if(rdbtnTecnico.isSelected()) {
									p1 = new Tecnico(cedula, nombre, telefono, direccion, estado, "",0, fecha);
								}
								if(rdbtnObrero.isSelected()) {
									p1 = new Obrero(cedula, nombre, telefono, direccion, estado,fecha, null);
								}
								BolsaEmpleo.getInstance().insertarPersona(p1);
								JOptionPane.showMessageDialog(null, "Registro Exitoso", "Informacion", JOptionPane.INFORMATION_MESSAGE);
								System.out.println(BolsaEmpleo.getInstance().getMisPersonas().size());
								clean();
							}
							else {
								auxPersona.setNombre(txtNombre.getText());
								auxPersona.setCedula(txtCedula.getText());
								auxPersona.setDireccion(txtDireccion.getText());
								auxPersona.setFechaNacimiento(txtFecha.getText());
								auxPersona.setTelefono(txtTelefono.getText());
								auxPersona.setEstado(cbxEstado.getSelectedItem().toString());
							    BolsaEmpleo.getInstance().modificarPersona(auxPersona);
							    dispose();
							}
						}else {
							JOptionPane.showMessageDialog(null, "Complete los Espacios Requeridos", "Informacion", JOptionPane.INFORMATION_MESSAGE);
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
	}
}