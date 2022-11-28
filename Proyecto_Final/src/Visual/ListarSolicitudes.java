package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarSolicitudes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] rows;
	private Solicitud aux = null;
	private JButton Eliminarbtn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarSolicitudes dialog = new ListarSolicitudes(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarSolicitudes(Empresa empresa) {
		if(empresa == null) {
			setTitle("Solicitudes Registradas");
		}else {
			setTitle("Solicitudes Registradas de "+empresa.getNombreEmpresa());
		}
		
		setBounds(100, 100, 662, 431);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				model = new DefaultTableModel();
				String[] columnas = {"Codigo","Categoria Laboral","Estado","Fecha de Vencimiento","Grupo"};
				model.setColumnIdentifiers(columnas);
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
						}
					});
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table.setModel(model);
					scrollPane.setViewportView(table);
					if(empresa == null) {
						loadSolicitudes();
					}else {
					
					}
					
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
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
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	

	private void loadSolicitudes() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (Solicitud solic : BolsaEmpleo.getInstance().getMisSolicitudes()) {
			if(solic instanceof SolEmpresa) {
				rows[0] = solic.getCodigo(); 
				rows[1] = solic.getCategoriaLaboral(); 
				rows[2] = solic.getEstado(); 
				rows[3] = solic.getFechaVencimiento();
				rows[4] = "Empresa";
			}
			if(solic instanceof SolPersona) {
				rows[0] = solic.getCodigo(); 
				rows[1] = solic.getCategoriaLaboral(); 
				rows[2] = solic.getEstado(); 
				rows[3] = solic.getFechaVencimiento();
				rows[4] = "Persona";
			}
			
		model.addRow(rows);
		}
		
	}
}
