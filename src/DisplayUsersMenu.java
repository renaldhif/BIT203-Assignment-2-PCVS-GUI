import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DisplayUsersMenu {

	JFrame displayUsersFrame;

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
		displayUsersFrame.setTitle("PCVS System");
		displayUsersFrame.setBounds(100, 100, 800, 600);
		displayUsersFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		displayUsersFrame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 800, 600);
		displayUsersFrame.getContentPane().add(layeredPane);
		
		JLabel dispUsersPicLbl = new JLabel("");
		dispUsersPicLbl.setIcon(new ImageIcon("C:\\Users\\renal\\OneDrive\\COLLEGE\\ASSIGNMENTS\\5th Semester\\BIT203 - JAVA ADVANCED\\eclipse-Assignment2\\img\\allUsers.png"));
		dispUsersPicLbl.setBounds(0, 0, 360, 561);
		layeredPane.add(dispUsersPicLbl);
		
		JLabel bgWhiteLbl = new JLabel("");
		bgWhiteLbl.setIcon(new ImageIcon("C:\\Users\\renal\\OneDrive\\COLLEGE\\ASSIGNMENTS\\5th Semester\\BIT203 - JAVA ADVANCED\\eclipse-Assignment2\\img\\bgWhite.png"));
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
		backLbl.setIcon(new ImageIcon("C:\\Users\\renal\\OneDrive\\COLLEGE\\ASSIGNMENTS\\5th Semester\\BIT203 - JAVA ADVANCED\\eclipse-Assignment2\\img\\backBtn.png"));
		layeredPane.setLayer(backLbl, 1);
		backLbl.setBounds(10, 10, 50, 50);
		layeredPane.add(backLbl);
	}
}
