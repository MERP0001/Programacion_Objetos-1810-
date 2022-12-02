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

public class ListarPersana extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] rows;
	private Persona aux = null;
	private JButton macheobtn;
	private JButton creaSolicitudbtn;
	private JButton Eliminarbtn;
	private JButton Modificarbtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarPersana dialog = new ListarPersana();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarPersana() {
		setResizable(false);
		setTitle("Listado De Personas Registradas");
		setBounds(100, 100, 694, 455);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
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
					String[] columnas = {"Cedula","Nombre","Estado","Tipo","Fecha Nacimiento"};
					model.setColumnIdentifiers(columnas);
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int rowSelecte = -1;
							rowSelecte = table.getSelectedRow();
							Eliminarbtn.setEnabled(true);
							Modificarbtn.setEnabled(true);
							creaSolicitudbtn.setEnabled(true);
							macheobtn.setEnabled(true);
							aux = BolsaEmpleo.getInstance().buscarPersona(table.getValueAt(rowSelecte,0).toString());
						}
					});
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table.setModel(model);
					scrollPane.setViewportView(table);
					loadPersonas();
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
				Eliminarbtn.setEnabled(false);
				Eliminarbtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int option = 0;
						option = JOptionPane.showConfirmDialog(null, "Esta Seguro que desea elminar esta Persona?", "Confirmacion", JOptionPane.YES_NO_OPTION);
					if(option ==  JOptionPane.OK_OPTION) {
						 BolsaEmpleo.getInstance().eliminarPersona(aux);
						 loadPersonas();
						 Eliminarbtn.setEnabled(false);
						 Modificarbtn.setEnabled(false);
						 creaSolicitudbtn.setEnabled(false);
						 macheobtn.setEnabled(false);
						}
					}
				});
				{
					Modificarbtn = new JButton("Modificar");
					Modificarbtn.setEnabled(false);
					Modificarbtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							RegPersona regper = new RegPersona(aux);
							regper.setModal(true);
							regper.setVisible(true);
							loadPersonas();
							Eliminarbtn.setEnabled(false);
							Modificarbtn.setEnabled(false);
							creaSolicitudbtn.setEnabled(false);
							macheobtn.setEnabled(false);
						}
					});
					buttonPane.add(Modificarbtn);
				}
				Eliminarbtn.setActionCommand("OK");
				buttonPane.add(Eliminarbtn);
				getRootPane().setDefaultButton(Eliminarbtn);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				{
					creaSolicitudbtn = new JButton("Crear Solicitud");
					creaSolicitudbtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							RegSoliEMP regi = new RegSoliEMP(aux);
							regi.setModal(true);
							regi.setVisible(true);
						}
						
					});
					creaSolicitudbtn.setEnabled(false);
					buttonPane.add(creaSolicitudbtn);
				}
				{
					macheobtn = new JButton("ver Solicitudes");
					macheobtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							ListarSolicitudes listSol = new ListarSolicitudes(null,aux);
							listSol.setModal(true);
							listSol.setVisible(true);
						}
					});
					macheobtn.setEnabled(false);
					buttonPane.add(macheobtn);
				}
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void loadPersonas() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (Persona person : BolsaEmpleo.getInstance().getMisPersonas()) {
			if(person instanceof Universitario) {
				rows[0] = person.getCedula(); 
				rows[1] = person.getNombre(); 
				rows[2] = person.getEstado(); 
				rows[3] = "Universitario"; 
				rows[4] = person.getFechaNacimiento();
			}
			
			if(person instanceof Tecnico) {
				rows[0] = person.getCedula(); 
				rows[1] = person.getNombre(); 
				rows[2] = person.getEstado(); 
				rows[3] = "Tecnico"; 
				rows[4] = person.getFechaNacimiento();
			}
			
			if(person instanceof Obrero) {
				rows[0] = person.getCedula(); 
				rows[1] = person.getNombre(); 
				rows[2] = person.getEstado(); 
				rows[3] = "Obrero"; 
				rows[4] = person.getFechaNacimiento();
			}
			model.addRow(rows);
			
		}
	}

}
