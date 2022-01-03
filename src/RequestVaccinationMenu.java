import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RequestVaccinationMenu {

	JFrame requestVaccinationFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RequestVaccinationMenu window = new RequestVaccinationMenu();
					window.requestVaccinationFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RequestVaccinationMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		requestVaccinationFrame = new JFrame();
		requestVaccinationFrame.setTitle("PCVS System");
		requestVaccinationFrame.setBounds(100, 100, 800, 600);
		requestVaccinationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		requestVaccinationFrame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 800, 600);
		requestVaccinationFrame.getContentPane().add(layeredPane);
		
		JLabel picLbl = new JLabel("");
		picLbl.setIcon(new ImageIcon("img/appointment.png"));
		picLbl.setBounds(0, 0, 360, 560);
		layeredPane.add(picLbl);
		
		JLabel bgWhiteLbl = new JLabel("");
		bgWhiteLbl.setIcon(new ImageIcon("img/bgWhite.png"));
		bgWhiteLbl.setBounds(360, 0, 430, 560);
		layeredPane.add(bgWhiteLbl);
		
		JLabel backLbl = new JLabel("");
		backLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PatientMenu patientMenu = new PatientMenu();
				patientMenu.patientMenuFrame.setVisible(true);
				requestVaccinationFrame.dispose();
			}
		});
		backLbl.setIcon(new ImageIcon("img/backBtn.png"));
		layeredPane.setLayer(backLbl, 1);
		backLbl.setBounds(10, 10, 50, 50);
		layeredPane.add(backLbl);
	}
}
