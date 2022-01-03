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

public class DisplayUsersMenu {

	JFrame displayUsersFrame;
	private JTable table;
	PCVS pcvsObj = new PCVS();
	ArrayList listAdminCl = (ArrayList)pcvsObj.getAdminList().clone();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DisplayUsersMenu window = new DisplayUsersMenu();
//					window.DisplayUsersFrame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public DisplayUsersMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		displayUsersFrame = new JFrame();
		displayUsersFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("img/pcvslogo.png"));
		displayUsersFrame.setTitle("PCVS System");
		displayUsersFrame.setBounds(100, 100, 800, 600);
		displayUsersFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		displayUsersFrame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 800, 600);
		displayUsersFrame.getContentPane().add(layeredPane);
		
		JLabel dispUsersPicLbl = new JLabel("");
		dispUsersPicLbl.setIcon(new ImageIcon("img/allUsers.png"));
		dispUsersPicLbl.setBounds(0, 0, 360, 561);
		layeredPane.add(dispUsersPicLbl);
		
		JLabel bgWhiteLbl = new JLabel("");
		bgWhiteLbl.setIcon(new ImageIcon("img/bgWhite.png"));
		bgWhiteLbl.setBounds(360, 0, 424, 561);
		layeredPane.add(bgWhiteLbl);
		
		JLabel backLbl = new JLabel("");
		backLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				AdminMenu adminMenu = new AdminMenu();
				adminMenu.adminMenuFrame.setVisible(true);
				displayUsersFrame.dispose();
			}
		});
		backLbl.setIcon(new ImageIcon("img/backBtn.png"));
		layeredPane.setLayer(backLbl, 1);
		backLbl.setBounds(10, 10, 50, 50);
		layeredPane.add(backLbl);
		
		JLabel adminLbl = new JLabel("Administrator");
		adminLbl.setBounds(370, 11, 115, 25);
		layeredPane.add(adminLbl);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// re:
		DefaultTableModel dtm = new DefaultTableModel();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Full Name", "Username", "Email", "Staff ID", "Healthcare"},
			},
			new String[] {
				"Full Name", "Username", "Email", "Staff ID", "Healthcare"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(103);
		table.getColumnModel().getColumn(4).setPreferredWidth(148);
		
		
		for (int i = 0; i < listAdminCl.size(); i++) {
			dtm.setRowCount(i+1);
			Administrator dataAdmin = (Administrator) listAdminCl.get(i);
			Object[] rowDataAdmin = 
				{
					dataAdmin.getFullName(),
					dataAdmin.getUsername(),
					dataAdmin.getEmail(),
					dataAdmin.getStaffID(),
					getAdminInHC()
				};
			dtm.addRow(rowDataAdmin);
		}
		layeredPane.setLayer(table, 1);
		table.setBounds(370, 47, 401, 149);
		layeredPane.add(table);
	}
	
	public String getAdminInHC(){
		String adminHC = "";
		for (int i = 0; i < pcvsObj.getCentreList().size(); i++){
            HealthcareCenter dataHC = pcvsObj.getCentreListByIndex(i);

            for (int j = 0; j < dataHC.getAdminAgr().size(); j++){
       	 		adminHC = dataHC.getCentreName();
            }
        }

		return adminHC;
	}
}
