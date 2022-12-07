package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Logico.BolsaEmpleo;
import Logico.Empresa;
import Logico.Obrero;
import Logico.Persona;
import Logico.Tecnico;
import Logico.Universitario;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class ListarEmpresa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] rows;
	private Empresa aux = null;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnCrearSoli;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarEmpresa dialog = new ListarEmpresa();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarEmpresa() {
		setBackground(new Color(173, 216, 230));
		setTitle("Empresas Registradas");
		setBounds(100, 100, 657, 432);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(173, 216, 230));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					model = new DefaultTableModel();
					String[] columnas = {"RCN","Nombre","Direccion"};
					model.setColumnIdentifiers(columnas);
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int rowSelecte = -1;
							rowSelecte = table.getSelectedRow();
							aux = BolsaEmpleo.getInstance().buscarEmpresa(table.getValueAt(rowSelecte,0).toString());
						}
					});
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table.setModel(model);
					scrollPane.setViewportView(table);
					loadEmpresas();
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setForeground(new Color(255, 255, 255));
			buttonPane.setBackground(new Color(173, 216, 230));
			buttonPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					    int option = 0;
						option = JOptionPane.showConfirmDialog(null, "Esta Seguro que desea elminar esta Persona?", "Confirmacion", JOptionPane.YES_NO_OPTION);
					    if(option ==  JOptionPane.OK_OPTION) {
					    	BolsaEmpleo.getInstance().eliminarEmpresa(aux);
							loadEmpresas();
					    }
					}
				});
				buttonPane.add(btnEliminar);
			}
			{
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RegEmpresa regEmpresa = new RegEmpresa(aux);
						regEmpresa.setModal(true);
						regEmpresa.setVisible(true);
						loadEmpresas();
					}
				});
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
			}
			{
				btnCrearSoli = new JButton("Crear Solicitud");
				btnCrearSoli.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RegOferta regOf = new RegOferta(aux);
						regOf.setModal(true);
						regOf.setVisible(true);
					}
				});
				buttonPane.add(btnCrearSoli);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				{
					JButton btnNewButton = new JButton("Ver Solicitudes");
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							ListarSolicitudes listSol = new ListarSolicitudes(aux,null);
							listSol.setModal(true);
							listSol.setVisible(true);
						}
					});
					buttonPane.add(btnNewButton);
				}
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void loadEmpresas() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (Empresa empresa : BolsaEmpleo.getInstance().getMisEmpleos()) {
				rows[0] = empresa.getRcn();
				rows[1] = empresa.getNombreEmpresa();
				rows[2] = empresa.getDireccion();
			model.addRow(rows);	
		}
		
	}

}