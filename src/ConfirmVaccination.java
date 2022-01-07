import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConfirmVaccination {
	
	private PCVS pcvsObj;
	private String username;
	private HealthcareCenter HCAdmin;
	JFrame confirmVaccinationFrame;
	private JTextField vcntIDTField;

	/**
	 * Create the application.
	 */
	public ConfirmVaccination(String hcAdminUsername, HealthcareCenter inHCAdmin) {
		username = hcAdminUsername;
		HCAdmin = inHCAdmin;
		initialize();
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
	private void initialize() {
		confirmVaccinationFrame = new JFrame();
		confirmVaccinationFrame.setTitle("PCVS System");
		confirmVaccinationFrame.setBounds(100, 100, 1000, 600);
		confirmVaccinationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		confirmVaccinationFrame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1000, 600);
		confirmVaccinationFrame.getContentPane().add(layeredPane);
		layeredPane.setLayout(null);
		
		JLabel picLbl = new JLabel("");
		picLbl.setIcon(new ImageIcon("img/confirm.png"));
		picLbl.setBounds(0, 0, 360, 560);
		layeredPane.add(picLbl);
		
		JLabel bgWhite = new JLabel("");
		bgWhite.setIcon(new ImageIcon("img/bgWhite1000.png"));
		bgWhite.setBounds(360, 0, 624, 560);
		layeredPane.add(bgWhite);
		
		JLabel titleLbl = new JLabel("Confirm Vaccination Appointment");
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		layeredPane.setLayer(titleLbl, 1);
		titleLbl.setBounds(543, 11, 285, 25);
		layeredPane.add(titleLbl);
		
		JLabel inVcntIDLbl = new JLabel("Input Vaccination ID");
		inVcntIDLbl.setHorizontalAlignment(SwingConstants.LEFT);
		inVcntIDLbl.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		layeredPane.setLayer(inVcntIDLbl, 1);
		inVcntIDLbl.setBounds(400, 85, 145, 32);
		layeredPane.add(inVcntIDLbl);
		
		vcntIDTField = new JTextField();
		layeredPane.setLayer(vcntIDTField, 1);
		vcntIDTField.setBounds(555, 82, 210, 35);
		layeredPane.add(vcntIDTField);
		vcntIDTField.setColumns(10);
		
		JButton searchBtn = new JButton("SEARCH");
		searchBtn.addMouseListener(new MouseAdapter() {
			String vcnt = vcntIDTField.getText();
			@Override
			public void mouseClicked(MouseEvent e) {
				if(vcntIDTField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,
						    "Field cannot be blank!",
						    "Input vaccination ID",
						    JOptionPane.WARNING_MESSAGE);
				}
				else if (vcnt == "") {
					JOptionPane.showMessageDialog(null,
						    "No Vaccination ID registered or Wrong Vaccination ID",
						    "No Vaccination ID",
						    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		searchBtn.setBackground(new Color(144, 238, 144));
		searchBtn.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		layeredPane.setLayer(searchBtn, 1);
		searchBtn.setBounds(775, 82, 180, 35);
		layeredPane.add(searchBtn);
		
		JTextArea vcntTArea = new JTextArea();
		vcntTArea.setText("Vaccination ID\t\t:\r\n\r\n"
						+ "Full Name\t\t:\r\n\r\n"
						+ "IC Passport\t\t: \r\n\r\n"
						+ "Batch No\t\t:\r\n\r\n"
						+ "Expiry Date\t\t:\r\n\r\n"
						+ "Manufacturer\t\t:\r\n\r\n"
						+ "Vaccine Name\t\t:\r\n\r\n"
						+ "Appointment Status\t:\r\n");
		vcntTArea.setEditable(false);
		vcntTArea.setLineWrap(true);
		vcntTArea.setFont(new Font("Malgun Gothic", Font.BOLD, 13));
		layeredPane.setLayer(vcntTArea, 1);
		vcntTArea.setBounds(400, 140, 550, 300);
		layeredPane.add(vcntTArea);
		
		JButton confirmBtn = new JButton("CONFIRM");
		confirmBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null,
					    "Status has been updated to confirmed",
					    "Status Confirmed",
					    JOptionPane.PLAIN_MESSAGE);
			}
		});
		confirmBtn.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		layeredPane.setLayer(confirmBtn, 1);
		confirmBtn.setBackground(new Color(92,184,92));
		confirmBtn.setBounds(685, 472, 270, 40);
		layeredPane.add(confirmBtn);
		
		JButton rejectBtn = new JButton("REJECT");
		rejectBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null,
					    "Status has been updated to rejected",
					    "Status Rejected",
					    JOptionPane.PLAIN_MESSAGE);
			}
		});
		layeredPane.setLayer(rejectBtn, 1);
		rejectBtn.setBackground(new Color(237,94,104));
		rejectBtn.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		rejectBtn.setBounds(400, 472, 270, 40);
		layeredPane.add(rejectBtn);
		
		JLabel backLbl = new JLabel("");
		backLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminMenu adminMenu = new AdminMenu(username, pcvsObj.getAdminInHC(username));
				adminMenu.setPCVSObjClone(pcvsObj);
				adminMenu.setHCAdmin(pcvsObj.getAdminInHC(username));
				adminMenu.adminMenuFrame.setVisible(true);
				confirmVaccinationFrame.dispose();
			}
		});
		backLbl.setIcon(new ImageIcon("img/backBtn.png"));
		layeredPane.setLayer(backLbl, 1);
		backLbl.setBounds(10, 10, 50, 50);
		layeredPane.add(backLbl);
	}
}
