package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
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
import Logico.SolEmpresa;
import Logico.Tecnico;
import Logico.Universitario;

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

public class ListarPersana extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] rows;
	private Persona aux = null;
	private SolEmpresa auxSol = null;
	private JButton macheobtn;
	private JButton creaSolicitudbtn;
	private JButton Eliminarbtn;
	private JButton Modificarbtn;
	private JButton signInbtn;
	private ArrayList<Persona> candidatos = null; 

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public ListarPersana(SolEmpresa solicitud, Empresa empresa) {
		setBackground(new Color(173, 216, 230));
		
		auxSol = solicitud;
		setResizable(false);
		if(solicitud == null && empresa == null) {
			setTitle("Listado De Personas Registradas");
		}else if(solicitud != null && empresa == null){
			candidatos = BolsaEmpleo.getInstance().Macheo(solicitud);
			setTitle("Listado De Personas calificadas para "+solicitud.getEmpresa().getNombreEmpresa());
		}else if(solicitud == null && empresa != null) {
			setTitle("Empleados De "+empresa.getNombreEmpresa());
		}
		
		setBounds(100, 100, 694, 455);
		setLocationRelativeTo(null);
		ImageIcon logo = new ImageIcon("src/imagenes/oferta.jpeg");
		setIconImage(logo.getImage());
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
				scrollPane.setBackground(new Color(173, 216, 230));
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
							if(solicitud == null) {
								Eliminarbtn.setEnabled(true);
								Modificarbtn.setEnabled(true);
								creaSolicitudbtn.setEnabled(true);
								macheobtn.setEnabled(true);
							}
							aux = BolsaEmpleo.getInstance().buscarPersona(table.getValueAt(rowSelecte,0).toString());

						}
					});
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table.setModel(model);
					scrollPane.setViewportView(table);
					if(solicitud == null && empresa == null) {
						loadPersonas();
					}else if(solicitud != null && empresa == null){
						loadCalificados(candidatos);
					}else {
						loadCalificados(empresa.getEmpleados());
					}
					
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(173, 216, 230));
			buttonPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
			if(solicitud == null) {
				//signInbtn.setEnabled(false);
				Eliminarbtn = new JButton("Eliminar");
				Eliminarbtn.setEnabled(false);
				Eliminarbtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int option = 0;
						option = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar a "+aux.getNombre()+" ?", "Confirmacion", JOptionPane.YES_NO_OPTION);
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
				{
					
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
				}
			}else {
				{
					signInbtn = new JButton("Contratar");
					signInbtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							int option = 0;
							option = JOptionPane.showConfirmDialog(null, "Esta seguro que desea contratar esta Persona?", "Confirmacion", JOptionPane.YES_NO_OPTION);
						if(option ==  JOptionPane.OK_OPTION) {
							JOptionPane.showMessageDialog(null, "El usuario se ha contratado.", "Informaci?n", JOptionPane.INFORMATION_MESSAGE);
							BolsaEmpleo.getInstance().contratarPersona(aux, solicitud);
							candidatos.remove(aux);
							loadCalificados(candidatos);
						}
							
						}
					});
					buttonPane.add(signInbtn);
				}
			}
			
			JButton cancelButton = new JButton("Cancelar");
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
	private void loadCalificados(ArrayList<Persona> candidatos) {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (Persona person : candidatos) {
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
