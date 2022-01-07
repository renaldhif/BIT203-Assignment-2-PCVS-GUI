import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignInMenu {

	JFrame signInMenuFrame;
	private PCVS pcvsObj;
	private HealthcareCenter HCAdmin;
	private JTextField usernameTField;
	private JPasswordField passwordTField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	String username, password;

	/**
	 * Create the application.
	 */
	public SignInMenu() {
		initialize();
	}
	
	// A Setter method to copy constructor PCVS from PCVSGUI class to this class
	public void setPCVSObjClone(PCVS newPCVS) {
		pcvsObj = newPCVS;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		signInMenuFrame = new JFrame();
		signInMenuFrame.setTitle("PCVS System");
		signInMenuFrame.setBounds(100, 100, 800, 600);
		signInMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		signInMenuFrame.getContentPane().setLayout(null);
		signInMenuFrame.setVisible(true);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 800, 600);
		signInMenuFrame.getContentPane().add(layeredPane);
		
		JLabel picLbl = new JLabel("");
		picLbl.setIcon(new ImageIcon("img/singuplayer.png"));
		layeredPane.setLayer(picLbl, 1);
		picLbl.setBounds(0, 0, 450, 561);
		layeredPane.add(picLbl);
		
		JLabel whiteBgLbl = new JLabel("");
		whiteBgLbl.setIcon(new ImageIcon("img/bgWhite.png"));
		layeredPane.setLayer(whiteBgLbl, 0);
		whiteBgLbl.setBounds(449, 0, 341, 561);
		layeredPane.add(whiteBgLbl);
		
		JLabel signInLbl = new JLabel("SIGN IN");
		signInLbl.setVerticalAlignment(SwingConstants.TOP);
		signInLbl.setHorizontalAlignment(SwingConstants.CENTER);
		layeredPane.setLayer(signInLbl, 1);
		signInLbl.setFont(new Font("Malgun Gothic", Font.BOLD, 24));
		signInLbl.setBounds(550, 9, 151, 52);
		layeredPane.add(signInLbl);
		
		JLabel dontHaveAccLbl = new JLabel("Don't have an account?");
		dontHaveAccLbl.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
		layeredPane.setLayer(dontHaveAccLbl, 1);
		dontHaveAccLbl.setBounds(513, 532, 160, 20);
		layeredPane.add(dontHaveAccLbl);
		
		JLabel toSignUp = new JLabel("Sign up here.");
		toSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				PCVSGUI mainMenu = new PCVSGUI();
				mainMenu.setPCVSObjClone(pcvsObj);
				mainMenu.mainMenuFrame.setVisible(true);
				signInMenuFrame.dispose();
			}
		});
		toSignUp.setForeground(new Color(65, 105, 225));
		toSignUp.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		layeredPane.setLayer(toSignUp, 1);
		toSignUp.setBounds(676, 532, 99, 20);
		layeredPane.add(toSignUp);
		
		JLabel usernameLbl = new JLabel("Username");
		usernameLbl.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		layeredPane.setLayer(usernameLbl, 1);
		usernameLbl.setBounds(478, 105, 121, 26);
		layeredPane.add(usernameLbl);
		
		usernameTField = new JTextField();
		layeredPane.setLayer(usernameTField, 1);
		usernameTField.setBounds(478, 142, 291, 32);
		layeredPane.add(usernameTField);
		usernameTField.setColumns(10);
		
		JLabel passwordLbl = new JLabel("Password");
		passwordLbl.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		layeredPane.setLayer(passwordLbl, 1);
		passwordLbl.setBounds(478, 200, 291, 26);
		layeredPane.add(passwordLbl);
		
		passwordTField = new JPasswordField();
		layeredPane.setLayer(passwordTField, 1);
		passwordTField.setBounds(478, 237, 291, 32);
		layeredPane.add(passwordTField);
		
		JLabel userTypeLbl = new JLabel("Sign In As:");
		userTypeLbl.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		layeredPane.setLayer(userTypeLbl, 1);
		userTypeLbl.setBounds(478, 298, 291, 32);
		layeredPane.add(userTypeLbl);
		
		JRadioButton hcAdminRdBtn = new JRadioButton("Healthcare Administrator");
		
		hcAdminRdBtn.setBackground(new Color(255, 255, 255));
		layeredPane.setLayer(hcAdminRdBtn, 1);
		hcAdminRdBtn.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
		buttonGroup.add(hcAdminRdBtn);
		hcAdminRdBtn.setBounds(478, 337, 180, 18);
		layeredPane.add(hcAdminRdBtn);
		
		JRadioButton ptnRdBtn = new JRadioButton("Patient");
		
		ptnRdBtn.setBackground(new Color(255, 255, 255));
		layeredPane.setLayer(ptnRdBtn, 1);
		ptnRdBtn.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
		buttonGroup.add(ptnRdBtn);
		ptnRdBtn.setBounds(676, 337, 79, 18);
		layeredPane.add(ptnRdBtn);
		
		JButton signInBtn = new JButton("Sign In");
		signInBtn.setForeground(new Color(255, 255, 255));
		signInBtn.setFont(new Font("Malgun Gothic", Font.BOLD, 15));
		signInBtn.setBackground(new Color(124, 151, 230));
		layeredPane.setLayer(signInBtn, 1);
		signInBtn.setBounds(478, 475, 291, 37);
		layeredPane.add(signInBtn);
		
		
		signInBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				signInBtn.setBackground(new Color(100, 149, 237));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				signInBtn.setBackground(new Color(65, 105, 225));
			}
			public void mouseClicked(MouseEvent e) {
				//debug
				JOptionPane.showMessageDialog(null, pcvsObj.getPatientList());
				username = usernameTField.getText();
				password = String.valueOf(passwordTField.getPassword());
				
				if(hcAdminRdBtn.isSelected() && 
					pcvsObj.validatesLoginForAdmin(username, password) == -1) {
							JOptionPane.showMessageDialog(null,
						    "Wrong username or password.",
						    "No account matched!.",
						    JOptionPane.ERROR_MESSAGE);
				}
				else if(ptnRdBtn.isSelected() &&
					pcvsObj.validatesLoginForPatient(username,password) == -1) {
							JOptionPane.showMessageDialog(null,
						    "Wrong username or password.",
						    "No account matched!.",
						    JOptionPane.ERROR_MESSAGE);
				}
				else {
					if (isFieldSignInEmpty() == true) {
						JOptionPane.showMessageDialog(null, "Field cannot be blank!");
					}
					if ((isFieldSignInEmpty() == false && ptnRdBtn.isSelected() == false && hcAdminRdBtn.isSelected() == false)) {
						JOptionPane.showMessageDialog(null, "Please select roles!");
					}
					else if((isFieldSignInEmpty() == false && (ptnRdBtn.isSelected() == true) || (isFieldSignInEmpty() == false  && hcAdminRdBtn.isSelected() == true))) {
						// If user selects the Healthcare Administrator Radiobutton, 
						// then show the AdminMenu Frame
						if(hcAdminRdBtn.isSelected()) {						
							AdminMenu adminMenu = new AdminMenu(username, pcvsObj.getAdminInHC(username));
							adminMenu.setPCVSObjClone(pcvsObj);
							adminMenu.setHCAdmin(pcvsObj.getAdminInHC(username));
							adminMenu.adminMenuFrame.setVisible(true);
						}
						// Else if user selects the Patient Radiobutton, 
						// then show the PatientMenu Frame
						else if(ptnRdBtn.isSelected()) {
							String fullname = pcvsObj.getPatientFN(username);
							PatientMenu patientMenu = new PatientMenu(fullname);
							patientMenu.setPCVSObjClone(pcvsObj);
							patientMenu.setPtnUName(username);
							patientMenu.patientMenuFrame.setVisible(true);
						}
						// then dispose current frame
						signInMenuFrame.dispose();
					}
				} // else
			}
		});
	
	}
	/**
	 * This method is to validate if the JFields are empty.
	 * 
	 * @return true if the Fields are empty, 
	 * otherwise it returns false if the Fields are not empty
	 */
	public boolean isFieldSignInEmpty() {
		if(usernameTField.getText().isEmpty() || passwordTField.getPassword().length == 0) {
			return true;
		}
		return false;
	}
}
