import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewVaccineBatchMenu {

	JFrame viewVaccineBatchFrame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ViewVaccineBatchMenu window = new ViewVaccineBatchMenu();
//					window.viewVaccineBatchFrame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public ViewVaccineBatchMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		viewVaccineBatchFrame = new JFrame();
		viewVaccineBatchFrame.setTitle("PCVS System");
		viewVaccineBatchFrame.setBounds(100, 100, 800, 600);
		viewVaccineBatchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewVaccineBatchFrame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 800, 600);
		viewVaccineBatchFrame.getContentPane().add(layeredPane);
		
		JLabel viewVacPicLbl = new JLabel("");
		viewVacPicLbl.setIcon(new ImageIcon("C:\\Users\\renal\\OneDrive\\COLLEGE\\ASSIGNMENTS\\5th Semester\\BIT203 - JAVA ADVANCED\\eclipse-Assignment2\\img\\batches.png"));
		viewVacPicLbl.setBounds(0, 0, 360, 560);
		layeredPane.add(viewVacPicLbl);
		
		JLabel whiteBgLbl = new JLabel("");
		whiteBgLbl.setIcon(new ImageIcon("C:\\Users\\renal\\OneDrive\\COLLEGE\\ASSIGNMENTS\\5th Semester\\BIT203 - JAVA ADVANCED\\eclipse-Assignment2\\img\\bgWhite.png"));
		whiteBgLbl.setBounds(360, 0, 424, 560);
		layeredPane.add(whiteBgLbl);
		
		JLabel backLbl = new JLabel("");
		backLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminMenu adminMenu = new AdminMenu();
				adminMenu.adminMenuFrame.setVisible(true);
				viewVaccineBatchFrame.dispose();
			}
		});
		backLbl.setIcon(new ImageIcon("C:\\Users\\renal\\OneDrive\\COLLEGE\\ASSIGNMENTS\\5th Semester\\BIT203 - JAVA ADVANCED\\eclipse-Assignment2\\img\\backBtn.png"));
		layeredPane.setLayer(backLbl, 1);
		backLbl.setBounds(10, 10, 50, 50);
		layeredPane.add(backLbl);
	}
}
