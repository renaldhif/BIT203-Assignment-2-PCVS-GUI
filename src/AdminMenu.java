import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JTextArea;

public class AdminMenu {
	private PCVS pcvsObj;
	JFrame adminMenuFrame;
	private String username;
	private HealthcareCenter HCAdmin;

	/**
	 * Create the application.
	 */
	public AdminMenu(String hcAdminUsername, HealthcareCenter inHCAdmin) {
		username = hcAdminUsername;
		HCAdmin = inHCAdmin;
		initialize();
	}
	
	public void setPCVSObjClone(PCVS newPCVS) {
		pcvsObj = newPCVS;
	} 
	
	public void setHCAdmin(HealthcareCenter newHCAdmin) {
		HCAdmin = newHCAdmin;
	}
	
	public void setUsernameAdmin(String newUsernameAdmin) {
		username  = newUsernameAdmin;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		adminMenuFrame = new JFrame();
		adminMenuFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("img/pcvslogo.png"));
		adminMenuFrame.setTitle("PCVS System");
		adminMenuFrame.setBounds(100, 100, 800, 600);
		adminMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminMenuFrame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 800, 600);
		adminMenuFrame.getContentPane().add(layeredPane);
		
		JLabel greetingLabel = new JLabel("Welcome Admin, " + username);
		greetingLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		greetingLabel.setHorizontalAlignment(SwingConstants.LEFT);
		greetingLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 18));
		greetingLabel.setBounds(382, 39, 396, 25);
		layeredPane.add(greetingLabel);
		
		JTextArea adminHCTArea = new JTextArea();
		adminHCTArea.setFont(new Font("Malgun Gothic", Font.BOLD, 13));
		adminHCTArea.setEditable(false);
		adminHCTArea.setForeground(new Color(0, 204, 204));
		layeredPane.setLayer(adminHCTArea, 1);
		adminHCTArea.setBounds(382, 68, 396, 70);
		adminHCTArea.setText("Healthcare Center: " + 
								HCAdmin.getCentreName() + 
								", " + HCAdmin.getAddress());
		layeredPane.add(adminHCTArea);
		
		JButton inputVacBatchBtn = new JButton("Input for New Vaccine Batch");
		layeredPane.setLayer(inputVacBatchBtn, 1);
		inputVacBatchBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InputVaccine inputVaccineMenu = new InputVaccine(username, HCAdmin);
				inputVaccineMenu.setPCVSObjClone(pcvsObj);
				inputVaccineMenu.setUNameHCAdmin(username);
				inputVaccineMenu.inputVaccineFrame.setVisible(true);
				adminMenuFrame.dispose();
			}
		});
		inputVacBatchBtn.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		inputVacBatchBtn.setBounds(440, 150, 300, 46);
		layeredPane.add(inputVacBatchBtn);
		
		JButton viewVacBatchBtn = new JButton("View Vaccine Batch Information");
		layeredPane.setLayer(viewVacBatchBtn, 1);
		viewVacBatchBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewVaccineBatchMenu viewVaccineBatchMenu = new ViewVaccineBatchMenu(username, HCAdmin);
				viewVaccineBatchMenu.setPCVSObjClone(pcvsObj);
				viewVaccineBatchMenu.setUNameHCAdmin(username);
				viewVaccineBatchMenu.viewVaccineBatchFrame.setVisible(true);
				adminMenuFrame.dispose();
			}
		});
		viewVacBatchBtn.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		viewVacBatchBtn.setBounds(440, 230, 300, 46);
		layeredPane.add(viewVacBatchBtn);
		
		JButton confirmationBtn = new JButton("Confirm Vaccination Appointment");
		confirmationBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConfirmVaccination confirmVaccination = new ConfirmVaccination(username, HCAdmin);
				confirmVaccination.setPCVSObjClone(pcvsObj);
				confirmVaccination.setUNameHCAdmin(username);
				confirmVaccination.confirmVaccinationFrame.setVisible(true);
				adminMenuFrame.dispose();
			}
		});
		layeredPane.setLayer(confirmationBtn, 1);
		confirmationBtn.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		confirmationBtn.setBounds(440, 310, 300, 46);
		layeredPane.add(confirmationBtn);
		
		JButton dispUsersBtn = new JButton("Display All Users");
		layeredPane.setLayer(dispUsersBtn, 1);
		dispUsersBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DisplayUsersMenu displayUsersMenu = new DisplayUsersMenu(username, HCAdmin, pcvsObj);
				displayUsersMenu.setPCVSObjClone(pcvsObj);
				displayUsersMenu.setUNameHCAdmin(username);
				displayUsersMenu.displayUsersFrame.setVisible(true);
				adminMenuFrame.dispose();
			}
		});
		dispUsersBtn.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		dispUsersBtn.setBounds(440, 390, 300, 46);
		layeredPane.add(dispUsersBtn);
		
		JButton signOutBtn = new JButton("Sign Out");
		layeredPane.setLayer(signOutBtn, 1);
		signOutBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(
						   adminMenuFrame,
						   "Are you sure want to Sign Out?", 
						   "Sign Out",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
				
	            if(result == JOptionPane.YES_OPTION){
	            	SignInMenu signInMenu = new SignInMenu();
	            	signInMenu.setPCVSObjClone(pcvsObj);
	            	signInMenu.signInMenuFrame.setVisible(true);
	            	adminMenuFrame.dispose();
	            }
			}
		});
		signOutBtn.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		signOutBtn.setBackground(new Color(237,94,104));
		signOutBtn.setBounds(440, 470, 300, 46);
		layeredPane.add(signOutBtn);
		
		JLabel adminPicLbl = new JLabel("");
		adminPicLbl.setIcon(new ImageIcon("img/doctor.png"));
		adminPicLbl.setBounds(0, 0, 360, 560);
		layeredPane.add(adminPicLbl);
		
		JLabel whiteBgLbl = new JLabel("");
		whiteBgLbl.setIcon(new ImageIcon("img/bgWhite.png"));
		whiteBgLbl.setBounds(360, 0, 430, 560);
		layeredPane.add(whiteBgLbl);
		
		
	
	}
}
