import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class ViewVaccineBatchMenu {

	JFrame viewVaccineBatchFrame;
	PCVS pcvsObj;
	private String username;
	private HealthcareCenter HCAdmin;

	/**
	 * Create the application.
	 */
	public ViewVaccineBatchMenu(String hcAdminUsername, HealthcareCenter inHCAdmin){
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
		viewVaccineBatchFrame = new JFrame();
		viewVaccineBatchFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("img/pcvslogo.png"));
		viewVaccineBatchFrame.setTitle("PCVS System");
		viewVaccineBatchFrame.setBounds(100, 100, 800, 600);
		viewVaccineBatchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewVaccineBatchFrame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 800, 600);
		viewVaccineBatchFrame.getContentPane().add(layeredPane);
		
		JLabel picLbl = new JLabel("");
		picLbl.setIcon(new ImageIcon("img/batches.png"));
		picLbl.setBounds(0, 0, 360, 560);
		layeredPane.add(picLbl);
		
		JLabel whiteBgLbl = new JLabel("");
		whiteBgLbl.setIcon(new ImageIcon("img/bgWhite.png"));
		whiteBgLbl.setBounds(360, 0, 424, 560);
		layeredPane.add(whiteBgLbl);
		
		JLabel backLbl = new JLabel("");
		backLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminMenu adminMenu = new AdminMenu(username, pcvsObj.getAdminInHC(username));
				adminMenu.setPCVSObjClone(pcvsObj);
				adminMenu.setHCAdmin(pcvsObj.getAdminInHC(username));
				adminMenu.adminMenuFrame.setVisible(true);
				viewVaccineBatchFrame.dispose();
			}
		});
		backLbl.setIcon(new ImageIcon("img/backBtn.png"));
		layeredPane.setLayer(backLbl, 1);
		backLbl.setBounds(10, 10, 50, 50);
		layeredPane.add(backLbl);
		
		JLabel titleLbl = new JLabel("View Vaccine Batch Information");
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setBounds(462, 10, 279, 28);
		layeredPane.add(titleLbl);
		// show all batches
		pcvsObj.showAllBatchesInformation();
	}
}
