import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class AdminMenu {

	JFrame adminMenuFrame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AdminMenu window = new AdminMenu();
//					window.adminMenuFrame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public AdminMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		adminMenuFrame = new JFrame();
		adminMenuFrame.setTitle("PCVS System");
		adminMenuFrame.setBounds(100, 100, 800, 600);
		adminMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminMenuFrame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 800, 600);
		adminMenuFrame.getContentPane().add(layeredPane);
		
		JLabel greetingLabel = new JLabel("Welcome Admin");
		greetingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		greetingLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 18));
		greetingLabel.setBounds(495, 11, 174, 46);
		layeredPane.add(greetingLabel);
		
		JLabel hcAdmin = new JLabel("You're registered at: ");
		hcAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		hcAdmin.setFont(new Font("Malgun Gothic", Font.BOLD, 15));
		hcAdmin.setBounds(369, 68, 187, 46);
		layeredPane.add(hcAdmin);
		
		JButton inputVacBatchBtn = new JButton("Input for New Vaccine Batch");
		inputVacBatchBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InputVaccine inputVaccineMenu = new InputVaccine();
				inputVaccineMenu.inputVaccineFrame.setVisible(true);
				adminMenuFrame.dispose();
			}
		});
		inputVacBatchBtn.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		inputVacBatchBtn.setBounds(440, 150, 300, 46);
		layeredPane.add(inputVacBatchBtn);
		
		JButton viewVacBatchBtn = new JButton("View Vaccine Batch Information");
		viewVacBatchBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewVaccineBatchMenu viewVaccineBatchMenu = new ViewVaccineBatchMenu();
				viewVaccineBatchMenu.viewVaccineBatchFrame.setVisible(true);
				adminMenuFrame.dispose();
			}
		});
		viewVacBatchBtn.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		viewVacBatchBtn.setBounds(440, 250, 300, 46);
		layeredPane.add(viewVacBatchBtn);
		
		JButton dispUsersBtn = new JButton("Display All Users");
		dispUsersBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DisplayUsersMenu displayUsersMenu = new DisplayUsersMenu();
				displayUsersMenu.displayUsersFrame.setVisible(true);
				adminMenuFrame.dispose();
			}
		});
		dispUsersBtn.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		dispUsersBtn.setBounds(440, 350, 300, 46);
		layeredPane.add(dispUsersBtn);
		
		JButton signOutBtn = new JButton("Sign Out");
		signOutBtn.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		signOutBtn.setBackground(new Color(237,94,104));
		signOutBtn.setBounds(440, 450, 300, 46);
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
