import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.ScrollPaneConstants;

public class DisplayUsersMenu {

	PCVS pcvsObj;
	JFrame displayUsersFrame;
	//private JTable table;
	private String username;
	private HealthcareCenter HCAdmin;
	private JTable adminTable;
	private JTable patientTable;
	
	/**
	 * Create the application.
	 */
	public DisplayUsersMenu(String hcAdminUsername, HealthcareCenter inHCAdmin, PCVS newPCVS) {
		username = hcAdminUsername;
		HCAdmin = inHCAdmin;
		pcvsObj = newPCVS;
		initialize(newPCVS);
	}

	public void setPCVSObjClone(PCVS newPCVS) {
		pcvsObj = newPCVS;
	}

	public void setUNameHCAdmin(String newUNameHCAdmin) {
		username = newUNameHCAdmin;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(PCVS newPCVS) {
		displayUsersFrame = new JFrame();
		displayUsersFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("img/pcvslogo.png"));
		displayUsersFrame.setTitle("PCVS System");
		displayUsersFrame.setBounds(100, 100, 1000, 600);
		displayUsersFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		displayUsersFrame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1000, 600);
		displayUsersFrame.getContentPane().add(layeredPane);
		
		JLabel dispUsersPicLbl = new JLabel("");
		dispUsersPicLbl.setIcon(new ImageIcon("img/allUsers.png"));
		dispUsersPicLbl.setBounds(0, 0, 360, 565);
		layeredPane.add(dispUsersPicLbl);
		
		JLabel bgWhiteLbl = new JLabel("");
		layeredPane.setLayer(bgWhiteLbl, 0);
		bgWhiteLbl.setIcon(new ImageIcon("img/bgWhite1000.png"));
		bgWhiteLbl.setBounds(360, 0, 650, 561);
		layeredPane.add(bgWhiteLbl);
		
		JLabel backLbl = new JLabel("");
		backLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminMenu adminMenu = new AdminMenu(username, pcvsObj.getAdminInHC(username));
				adminMenu.setPCVSObjClone(pcvsObj);
				adminMenu.setHCAdmin(pcvsObj.getAdminInHC(username));
				adminMenu.adminMenuFrame.setVisible(true);
				displayUsersFrame.dispose();
			}
		});
		backLbl.setIcon(new ImageIcon("img/backBtn.png"));
		layeredPane.setLayer(backLbl, 1);
		backLbl.setBounds(10, 10, 50, 50);
		layeredPane.add(backLbl);
		
		JLabel adminLbl = new JLabel("Administrator");
		adminLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		adminLbl.setHorizontalAlignment(SwingConstants.LEFT);
		layeredPane.setLayer(adminLbl, 1);
		adminLbl.setBounds(370, 47, 115, 25);
		layeredPane.add(adminLbl);
		
		JLabel titleLbl = new JLabel("Display All Users");
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		layeredPane.setLayer(titleLbl, 1);
		titleLbl.setBounds(570, 11, 193, 25);
		layeredPane.add(titleLbl);
		
		JLabel patientLbl = new JLabel("Patient");
		layeredPane.setLayer(patientLbl, 1);
		patientLbl.setHorizontalAlignment(SwingConstants.LEFT);
		patientLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		patientLbl.setBounds(370, 304, 115, 25);
		layeredPane.add(patientLbl);
		
		// admin table
		adminTable = new JTable();
		adminTable.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
		layeredPane.setLayer(adminTable, 2);
		// create DefaultTableModel
		DefaultTableModel dtmAdmin = new DefaultTableModel(0, 0) {
			  @Override
			  // method to set the cell is not editable
			    public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
		};
		// Column Header
		String[] colHeaderAdmin = new String[] {"Username", "Full name", "Email", "Staff ID"};
		dtmAdmin.setColumnIdentifiers(colHeaderAdmin);
		
		for (int i = 0; i < pcvsObj.getAdminList().size(); i++) {
			dtmAdmin.addRow(new Object[] {
					pcvsObj.getAdminList().get(i).getUsername(),
					pcvsObj.getAdminList().get(i).getFullName(),
					pcvsObj.getAdminList().get(i).getEmail(),
					pcvsObj.getAdminList().get(i).getStaffID(),
			});
		}

		adminTable.setModel(dtmAdmin);
		adminTable.getColumnModel().getColumn(0).setPreferredWidth(70);
		adminTable.getColumnModel().getColumn(1).setPreferredWidth(90);
		adminTable.getColumnModel().getColumn(2).setPreferredWidth(150);
		adminTable.getColumnModel().getColumn(3).setPreferredWidth(40);
		
		
		JScrollPane scrollAdminTable = new JScrollPane();
		layeredPane.setLayer(scrollAdminTable, 3);
		scrollAdminTable.setViewportView(adminTable);
		scrollAdminTable.setBounds(372, 83, 600, 200);
		layeredPane.add(scrollAdminTable);
		
		JScrollPane scrollPatientTable = new JScrollPane();
		layeredPane.setLayer(scrollPatientTable, 3);
		scrollPatientTable.setBounds(370, 340, 600, 200);
		layeredPane.add(scrollPatientTable);
		
		// patient table
		patientTable = new JTable();
		patientTable.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
		scrollPatientTable.setViewportView(patientTable);
		layeredPane.setLayer(patientTable, 2);
		
		// create DefaultTableModel
		DefaultTableModel dtmPatient = new DefaultTableModel(0, 0) {
			@Override
			  // method to set the cell is not editable
			    public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
		};		
		// Column Header
		String[] colHeaderPatient = new String[] {"Username", "Full name", "Email", "IC Passport"};
		dtmPatient.setColumnIdentifiers(colHeaderPatient);
		// To prevent error due to the array list of patient is 0 
		// if the patient have not registered yet
		if (pcvsObj.getPatientList().size() > 0) {
			for (int i = 0; i < pcvsObj.getPatientList().size(); i++) {
				dtmPatient.addRow(new Object[] {
						pcvsObj.getPatientList().get(i).getUsername(),
						pcvsObj.getPatientList().get(i).getFullName(),
						pcvsObj.getPatientList().get(i).getEmail(),
						pcvsObj.getPatientList().get(i).getICPassport(),
				});
			}
		}

		patientTable.setModel(dtmPatient);
		patientTable.getColumnModel().getColumn(0).setPreferredWidth(70);
		patientTable.getColumnModel().getColumn(1).setPreferredWidth(90);
		patientTable.getColumnModel().getColumn(2).setPreferredWidth(150);
		patientTable.getColumnModel().getColumn(3).setPreferredWidth(40);
	}
}
