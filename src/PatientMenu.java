import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class PatientMenu {

	JFrame patientMenuFrame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PatientMenu window = new PatientMenu();
//					window.patientMenuFrame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public PatientMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		patientMenuFrame = new JFrame();
		patientMenuFrame.setTitle("PCVS System");
		patientMenuFrame.setBounds(100, 100, 800, 600);
		patientMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		patientMenuFrame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 800, 600);
		patientMenuFrame.getContentPane().add(layeredPane);
		
		JLabel greetingLbl = new JLabel("Welcome Patient");
		greetingLbl.setFont(new Font("Malgun Gothic", Font.BOLD, 18));
		greetingLbl.setHorizontalAlignment(SwingConstants.CENTER);
		greetingLbl.setBounds(495, 11, 174, 46);
		layeredPane.add(greetingLbl);
		
		JButton reqVacBtn = new JButton("Request vaccination appointment");
		reqVacBtn.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		reqVacBtn.setBounds(440, 175, 300, 46);
		layeredPane.add(reqVacBtn);
		
		JButton viewVacAptBtn = new JButton("View vaccination appointment status");
		viewVacAptBtn.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		viewVacAptBtn.setBounds(440, 275, 300, 46);
		layeredPane.add(viewVacAptBtn);
		
		JButton signOutBtn = new JButton("Sign Out");
		signOutBtn.setBackground(new Color(237,94,104));
		signOutBtn.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		signOutBtn.setBounds(440, 375, 300, 46);
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
