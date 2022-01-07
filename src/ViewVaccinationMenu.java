import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewVaccinationMenu {

	JFrame viewVaccinationFrame;
	private String username;
	private PCVS pcvsObj;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ViewVaccinationMenu window = new ViewVaccinationMenu();
//					window.viewVaccinationFrame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public ViewVaccinationMenu(String ptnUName) {
		username = ptnUName;
		initialize();
	}
	public void setPtnUName(String newPtnUName) {
		username  = newPtnUName;
	}
	public void setPCVSObjClone(PCVS newPCVS) {
		pcvsObj = newPCVS;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		viewVaccinationFrame = new JFrame();
		viewVaccinationFrame.setBounds(100, 100, 800, 600);
		viewVaccinationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewVaccinationFrame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 800, 600);
		viewVaccinationFrame.getContentPane().add(layeredPane);
		
		JLabel picLbl = new JLabel("");
		picLbl.setIcon(new ImageIcon("img/appointment.png"));
		picLbl.setBounds(0, 0, 360, 560);
		layeredPane.add(picLbl);
		
		JLabel whiteBg = new JLabel("");
		whiteBg.setIcon(new ImageIcon("img/bgWhite.png"));
		whiteBg.setBounds(360, 0, 430, 560);
		layeredPane.add(whiteBg);
		
		JLabel backLbl = new JLabel("");
		backLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PatientMenu patientMenu = new PatientMenu(username);
				patientMenu.setPCVSObjClone(pcvsObj);
				patientMenu.patientMenuFrame.setVisible(true);
				viewVaccinationFrame.dispose();
			}
		});
		backLbl.setIcon(new ImageIcon("img/backBtn.png"));
		layeredPane.setLayer(backLbl, 1);
		backLbl.setBounds(10, 10, 50, 50);
		layeredPane.add(backLbl);
	}
}
