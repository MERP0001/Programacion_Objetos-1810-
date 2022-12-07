package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Logico.BolsaEmpleo;
import Logico.Empresa;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class RegEmpresa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Empresa auxEmpresa;
	private JTextField txtRCN;
	private JTextField txtNombre;
	private JTextField txtDireccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegEmpresa dialog = new RegEmpresa(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegEmpresa(Empresa empresa) {
		auxEmpresa = empresa;
		if(auxEmpresa == null) {
		    setTitle("Registrar Empresa");
		}
		else {
			setTitle("Modificar Empresa");
		}
		setBounds(100, 100, 474, 346);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(173, 216, 230));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(173, 216, 230));
			panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("RCN:");
			lblNewLabel.setBounds(12, 26, 56, 16);
			panel.add(lblNewLabel);
			
			txtRCN = new JTextField();
			txtRCN.setBounds(12, 55, 149, 22);
			if(auxEmpresa != null) {
				txtRCN.setText(auxEmpresa.getRcn());
			}
			panel.add(txtRCN);
			txtRCN.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre de la Empresa:");
			lblNewLabel_1.setBounds(12, 99, 187, 16);
			panel.add(lblNewLabel_1);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(12, 128, 149, 22);
			if(auxEmpresa != null) {
				txtNombre.setText(auxEmpresa.getNombreEmpresa());
			}
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Direccion:");
			lblNewLabel_2.setBounds(12, 173, 119, 16);
			panel.add(lblNewLabel_2);
			
			txtDireccion = new JTextField();
			txtDireccion.setBounds(12, 202, 149, 22);
			if(auxEmpresa != null) {
				txtDireccion.setText(auxEmpresa.getDireccion());
			}
			panel.add(txtDireccion);
			txtDireccion.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				if(auxEmpresa != null) {
					btnRegistrar.setText("Modificar");
				}
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!txtRCN.getText().isEmpty() && !txtNombre.getText().isEmpty() && !txtDireccion.getText().isEmpty()) {
							if(auxEmpresa == null) {
								Empresa e1 = null;
								e1 = new Empresa(txtRCN.getText(), txtDireccion.getText(), txtNombre.getText());
								BolsaEmpleo.getInstance().insertarEmpresa(e1);
								JOptionPane.showMessageDialog(null, "Registro Exitoso", "Informacion", JOptionPane.INFORMATION_MESSAGE);
								clean();
							}
							else {
								auxEmpresa.setRcn(txtRCN.getText());
								auxEmpresa.setNombreEmpresa(txtNombre.getText());
								auxEmpresa.setDireccion(txtDireccion.getText());
								BolsaEmpleo.getInstance().modificarEmpresa(auxEmpresa);
								dispose();
							}
						}else {
							JOptionPane.showMessageDialog(null, "Complete los espacios requeridos", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
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
	private void clean() {
		txtNombre.setText("");
		txtDireccion.setText("");
		txtRCN.setText("");
	}
}