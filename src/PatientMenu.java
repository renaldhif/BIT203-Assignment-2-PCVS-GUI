import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class PatientMenu {
	private PCVS pcvsObj;
	private String username;
	private String fullname;
	JFrame patientMenuFrame;

	/**
	 * Create the application.
	 */
	public PatientMenu(String ptnUName) {
		username = ptnUName;
		initialize();
	}
	
	public void setPCVSObjClone(PCVS newPCVS) {
		pcvsObj = newPCVS;
	}
	
	public void setPtnUName(String newPtnUName) {
		username  = newPtnUName;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		patientMenuFrame = new JFrame();
		patientMenuFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("img/pcvslogo.png"));
		patientMenuFrame.setTitle("PCVS System");
		patientMenuFrame.setBounds(100, 100, 800, 600);
		patientMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		patientMenuFrame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 800, 600);
		patientMenuFrame.getContentPane().add(layeredPane);
		
		JLabel greetingLbl = new JLabel("Welcome Patient, " + username);
		greetingLbl.setVerticalAlignment(SwingConstants.BOTTOM);
		greetingLbl.setFont(new Font("Malgun Gothic", Font.BOLD, 18));
		greetingLbl.setHorizontalAlignment(SwingConstants.LEFT);
		greetingLbl.setBounds(382, 39, 396, 25);
		layeredPane.add(greetingLbl);
		
		JButton reqVacBtn = new JButton("Request vaccination appointment");
		reqVacBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RequestVaccinationMenu requestVaccination = new RequestVaccinationMenu(username);
				requestVaccination.setPCVSObjClone(pcvsObj);
				requestVaccination.requestVaccinationFrame.setVisible(true);
				patientMenuFrame.dispose();
			}
		});
		reqVacBtn.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		reqVacBtn.setBounds(440, 115, 300, 46);
		layeredPane.add(reqVacBtn);
		
		JButton viewVacAptBtn = new JButton("View vaccination appointment status");
		viewVacAptBtn.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		viewVacAptBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewVaccinationMenu viewVaccinationMenu = new ViewVaccinationMenu(username);
				viewVaccinationMenu.setPCVSObjClone(pcvsObj);
				viewVaccinationMenu.viewVaccinationFrame.setVisible(true);
				patientMenuFrame.dispose();
			}
		});
		viewVacAptBtn.setBounds(440, 235, 300, 46);
		layeredPane.add(viewVacAptBtn);
		
		JButton signOutBtn = new JButton("Sign Out");
		signOutBtn.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		signOutBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(
							patientMenuFrame,
						   "Are you sure want to Sign Out?", 
						   "Sign Out",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
		            if(result == JOptionPane.YES_OPTION){
		            	SignInMenu signInMenu = new SignInMenu();
		            	signInMenu.setPCVSObjClone(pcvsObj);
		            	signInMenu.signInMenuFrame.setVisible(true);
		            	patientMenuFrame.dispose();
		            }
			}
		});
		signOutBtn.setBackground(new Color(237,94,104));
		signOutBtn.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		signOutBtn.setBounds(440, 355, 300, 46);
		layeredPane.add(signOutBtn);
		
		JLabel ptnPicLbl = new JLabel("");
		ptnPicLbl.setIcon(new ImageIcon("img/patient.png"));
		ptnPicLbl.setBounds(0, 0, 360, 560);
		layeredPane.add(ptnPicLbl);
		
		JLabel bgWhiteLbl = new JLabel("");
		bgWhiteLbl.setIcon(new ImageIcon("img/bgWhite.png"));
		bgWhiteLbl.setBounds(361, 0, 429, 560);
		layeredPane.add(bgWhiteLbl);
	}
}
