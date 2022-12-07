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
import Logico.Persona;
import Logico.SolEmpresa;
import Logico.SolPersona;
import Logico.Solicitud;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class ListarSolicitudes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] rows;
	private Solicitud aux = null;
	private JButton Eliminarbtn;
	private Empresa empresaAux = null;
	private Persona personaAux = null;
	private SolEmpresa auxSol = null;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public ListarSolicitudes(Empresa empresa, Persona persona) {
		empresaAux = empresa;
		personaAux = persona;
		if(empresa == null && persona == null)
			setTitle("Solicitudes Registradas");
		else if(empresa != null && persona == null)
			setTitle("Solicitudes Registradas por "+empresa.getNombreEmpresa());
		else if(empresa == null && persona != null) {
			setTitle("Solicitudes Registradas por "+personaAux.getNombre());
		}
		
		setBounds(100, 100, 662, 431);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(173, 216, 230));
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(135, 206, 235));
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				model = new DefaultTableModel();
				if(empresa == null && persona == null) {
					String[] columnas = {"Codigo","Nombre del Dueño","Categoria Laboral","Estado","Grupo"};
					model.setColumnIdentifiers(columnas);
				}else if(empresa != null && persona == null){
					String[] columnas = {"Codigo","Cant. Vacantes","Categoria Laboral","Estado","Grupo"};
					model.setColumnIdentifiers(columnas);
				}else if(empresa == null && persona != null) {
					String[] columnas = {"Codigo","Formacion Academica","Categoria Laboral","Estado","Grupo"};
					model.setColumnIdentifiers(columnas);
				}
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBackground(new Color(173, 216, 230));
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int rowSelecte = -1;
							rowSelecte = table.getSelectedRow();
							auxSol = BolsaEmpleo.getInstance().buscarIndSolicitudEmpresa(table.getValueAt(rowSelecte,0).toString());
							
						}
					});
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table.setModel(model);
					scrollPane.setViewportView(table);
					if(empresa == null && persona == null) {
						loadSolicitudes();
					}else if(empresa != null && persona == null) {
						loadEmpreSol();
					}else if(empresa == null && persona != null) {
						loadPersonaSol();
					}
					
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(173, 216, 230));
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				Eliminarbtn = new JButton("Eliminar");
				Eliminarbtn.setActionCommand("OK");
				buttonPane.add(Eliminarbtn);
				getRootPane().setDefaultButton(Eliminarbtn);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				{
					JButton btnNewButton = new JButton("Buscar Empleados");
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							ListarPersana listper = new ListarPersana(auxSol);
							listper.setModal(true);
							listper.setVisible(true);
						}
					});
					buttonPane.add(btnNewButton);
				}
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	

	private void loadSolicitudes() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (SolEmpresa solic : BolsaEmpleo.getInstance().getMisSolEmpresas()) {
				rows[0] = solic.getCodigo(); 
				rows[1] = solic.getEmpresa().getNombreEmpresa(); 
				rows[2] = solic.getCategoriaLaboral(); 
				rows[3] = solic.getEstado();
				rows[4] = "Empresa";	
		model.addRow(rows);
		}
		for (SolPersona solic : BolsaEmpleo.getInstance().getMisSolPersonas()) {
				rows[0] = solic.getCodigo(); 
				rows[1] = solic.getBuscaEmpleos().getNombre();
				rows[2] = solic.getCategoriaLaboral(); 
				rows[3] = solic.getEstado(); 
				rows[4] = "Persona";	
		model.addRow(rows);
		}
		
	}
	private void loadEmpreSol() {
		ArrayList<SolEmpresa> auxlist = BolsaEmpleo.getInstance().buscarSolEspecico(empresaAux);
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (SolEmpresa solic : auxlist) {
				rows[0] = solic.getCodigo(); 
				rows[1] = String.valueOf(solic.getCantVacantes()); 
				rows[2] = solic.getCategoriaLaboral();
				rows[3] = solic.getEstado(); 
				rows[4] = "Empresa";	
		model.addRow(rows);
		}
		
	}
	private void loadPersonaSol() {
		ArrayList<SolPersona> auxlist = BolsaEmpleo.getInstance().buscarSolEspecicoPersona(personaAux);
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (SolPersona solic : auxlist) {
				rows[0] = solic.getCodigo(); 
				rows[1] = solic.getFormAcademic(); 
				rows[2] = solic.getCategoriaLaboral();
				rows[3] = solic.getEstado(); 
				rows[4] = "Persona";	
		model.addRow(rows);
		}
	}
}
