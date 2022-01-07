import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.Button;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class PCVSGUI {
	
	private PCVS pcvsObj;
	JFrame mainMenuFrame;
	private JTextField usernameTField;
	private JPasswordField passwordTField;
	private JTextField fullNameTField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField icpTField;
	private JTextField emailTField;
	private JComboBox hcCmbBox;
	private JLabel errMsgSelectHC;
	private JRadioButton hcAdminRdBtn, ptnRdBtn;
	
	String username, password, email, fullName, staffID, passport;
	int centreOption;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PCVSGUI window = new PCVSGUI();
					window.mainMenuFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PCVSGUI() {
		initialize();
	}
	
	public void setPCVSObjClone(PCVS newPCVS) {
		pcvsObj = newPCVS;
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//String username, password, email, fullName, staffID;
		//int centreOption;
		
		pcvsObj = new PCVS();
	
		mainMenuFrame = new JFrame();
		mainMenuFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("img/pcvslogo.png"));
		mainMenuFrame.setTitle("PCVS System");
		mainMenuFrame.setBounds(100, 100, 800, 600);
		mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainMenuFrame.getContentPane().setLayout(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(SystemColor.control);
		layeredPane.setBounds(0, 0, 800, 600);
		mainMenuFrame.getContentPane().add(layeredPane);

		JLabel picLbl = new JLabel("");
		picLbl.setIcon(new ImageIcon("img/singuplayer.png"));
		layeredPane.setLayer(picLbl, 0);
		picLbl.setBounds(0, 0, 450, 561);
		layeredPane.add(picLbl);

		JLabel signUpLbl = new JLabel("SIGN UP");
		signUpLbl.setVerticalAlignment(SwingConstants.TOP);
		signUpLbl.setHorizontalAlignment(SwingConstants.CENTER);
		layeredPane.setLayer(signUpLbl, 1);
		signUpLbl.setFont(new Font("Malgun Gothic", Font.BOLD, 24));
		signUpLbl.setBounds(550, 9, 151, 32);
		layeredPane.add(signUpLbl);

		JLabel whiteBgLbl = new JLabel("");
		layeredPane.setLayer(whiteBgLbl, 0);
		whiteBgLbl.setIcon(new ImageIcon("img/bgWhite.png"));
		whiteBgLbl.setBounds(449, 0, 351, 561);
		layeredPane.add(whiteBgLbl);

		JLabel usernameLbl = new JLabel("Username");
		usernameLbl.setVerticalAlignment(SwingConstants.TOP);
		usernameLbl.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		layeredPane.setLayer(usernameLbl, 1);
		usernameLbl.setBounds(478, 63, 96, 26);
		layeredPane.add(usernameLbl);

		usernameTField = new JTextField();
		usernameTField.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
		layeredPane.setLayer(usernameTField, 1);
		usernameTField.setBounds(478, 91, 291, 32);
		layeredPane.add(usernameTField);
		usernameTField.setColumns(10);

		JLabel passwordLbl = new JLabel("Password");
		passwordLbl.setVerticalAlignment(SwingConstants.TOP);
		layeredPane.setLayer(passwordLbl, 1);
		passwordLbl.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		passwordLbl.setBounds(478, 124, 291, 26);
		layeredPane.add(passwordLbl);

		passwordTField = new JPasswordField();
		passwordTField.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
		passwordTField.setToolTipText("");
		layeredPane.setLayer(passwordTField, 1);
		passwordTField.setBounds(478, 152, 291, 32);
		layeredPane.add(passwordTField);

		JLabel fullNameLbl = new JLabel("Full Name");
		layeredPane.setLayer(fullNameLbl, 1);
		fullNameLbl.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		fullNameLbl.setBounds(478, 183, 151, 32);
		layeredPane.add(fullNameLbl);
		
		fullNameTField = new JTextField();
		layeredPane.setLayer(fullNameTField, 1);
		fullNameTField.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
		fullNameTField.setColumns(10);
		fullNameTField.setBounds(478, 215, 291, 32);
		layeredPane.add(fullNameTField);

		JLabel userTypeLbl = new JLabel("Sign Up As:");
		layeredPane.setLayer(userTypeLbl, 1);
		userTypeLbl.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		userTypeLbl.setBounds(478, 324, 291, 32);
		layeredPane.add(userTypeLbl);

		JRadioButton hcAdminRdBtn, ptnRdBtn;
		hcAdminRdBtn = new JRadioButton("Healthcare Administrator");
		buttonGroup.add(hcAdminRdBtn);
		hcAdminRdBtn.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
		hcAdminRdBtn.setBackground(Color.WHITE);
		layeredPane.setLayer(hcAdminRdBtn, 1);
		hcAdminRdBtn.setBounds(481, 355, 180, 18);
		layeredPane.add(hcAdminRdBtn);

		ptnRdBtn = new JRadioButton("Patient");
		buttonGroup.add(ptnRdBtn);
		ptnRdBtn.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
		ptnRdBtn.setBackground(Color.WHITE);
		layeredPane.setLayer(ptnRdBtn, 1);
		ptnRdBtn.setBounds(690, 355, 79, 18);
		layeredPane.add(ptnRdBtn);

		JLabel icpLbl = new JLabel("IC Passport");
		icpLbl.setVerticalAlignment(SwingConstants.TOP);
		icpLbl.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		layeredPane.setLayer(icpLbl, 1);
		icpLbl.setBounds(478, 385, 115, 26);
		layeredPane.add(icpLbl);
		icpLbl.setVisible(false);

		icpTField = new JTextField();
		layeredPane.setLayer(icpTField, 1);
		icpTField.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
		icpTField.setColumns(10);
		icpTField.setBounds(478, 423, 291, 32);
		layeredPane.add(icpTField);
		icpTField.setVisible(false);

		JLabel selectHCLbl = new JLabel("Select Healthcare Centre:");
		selectHCLbl.setVerticalAlignment(SwingConstants.TOP);
		layeredPane.setLayer(selectHCLbl, 1);
		selectHCLbl.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		selectHCLbl.setBounds(478, 385, 193, 26);
		layeredPane.add(selectHCLbl);
		selectHCLbl.setVisible(false);
		
		JLabel errMsgSelectHC = new JLabel("You must select the Healthcare Centre!");
		errMsgSelectHC.setForeground(Color.RED);
		errMsgSelectHC.setFont(new Font("Malgun Gothic", Font.PLAIN, 10));
		layeredPane.setLayer(errMsgSelectHC, 1);
		errMsgSelectHC.setBounds(478, 405, 193, 16);
		layeredPane.add(errMsgSelectHC);
		errMsgSelectHC.setVisible(false);

		String[] hcAvail = { 
				"",
				"Siloam Hospital, Denpasar", 
				"Bali International Medical Centre(BIMC), Badung",
				"Sanjiwani Hospital, Gianyar", 
				"Karangasem Public Hospital, Karangasem",
				"Bangli Public Hospital, Bangli" };

		JComboBox hcCmbBox = new JComboBox(hcAvail);
		hcCmbBox.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		layeredPane.setLayer(hcCmbBox, 2);
		hcCmbBox.setBounds(478, 423, 291, 32);
		layeredPane.add(hcCmbBox);
		hcCmbBox.setVisible(false);

		JLabel haveAccountLbl = new JLabel("Already have an account?");
		haveAccountLbl.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
		haveAccountLbl.setHorizontalAlignment(SwingConstants.LEFT);
		layeredPane.setLayer(haveAccountLbl, 1);
		haveAccountLbl.setVerticalAlignment(SwingConstants.BOTTOM);
		haveAccountLbl.setBounds(498, 532, 173, 18);
		layeredPane.add(haveAccountLbl);

		JLabel toSignInLbl = new JLabel("Sign in here.");
		toSignInLbl.setForeground(new Color(65, 105, 225));
		toSignInLbl.setBackground(new Color(255, 255, 255));
		layeredPane.setLayer(toSignInLbl, 1);
		toSignInLbl.setVerticalAlignment(SwingConstants.BOTTOM);
		toSignInLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		toSignInLbl.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		toSignInLbl.setBounds(673, 532, 91, 18);
		layeredPane.add(toSignInLbl);

		JLabel emailLbl = new JLabel("Email");
		emailLbl.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		layeredPane.setLayer(emailLbl, 1);
		emailLbl.setBounds(478, 254, 115, 18);
		layeredPane.add(emailLbl);

		emailTField = new JTextField();
		layeredPane.setLayer(emailTField, 1);
		emailTField.setBounds(478, 284, 291, 32);
		layeredPane.add(emailTField);
		emailTField.setColumns(10);	
		
		JButton signUpBtn = new JButton("Sign Up");
		signUpBtn.setForeground(new Color(255, 255, 255));
		signUpBtn.setFont(new Font("Malgun Gothic", Font.BOLD, 15));
		signUpBtn.setBackground(new Color(124, 151, 230));
		layeredPane.setLayer(signUpBtn, 1);
		signUpBtn.setBounds(478, 475, 291, 37);
		layeredPane.add(signUpBtn);
		signUpBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				signUpBtn.setBackground(new Color(100, 149, 237));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				signUpBtn.setBackground(new Color(65, 105, 225));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				username = usernameTField.getText();
				password = String.valueOf(passwordTField.getPassword());
				
				email = emailTField.getText();
				fullName = fullNameTField.getText();
				staffID = pcvsObj.generateStaffID();
				centreOption = hcCmbBox.getSelectedIndex();
				passport = icpTField.getText();
				
				if (pcvsObj.validatesAvailUsername(username)) {
					JOptionPane.showMessageDialog(null,
						    "Username has been taken. Please try another one!.",
						    "Username has been taken",
						    JOptionPane.ERROR_MESSAGE);
				}
				else {
					if (isFieldMainMenuEmpty() == true) {
						JOptionPane.showMessageDialog(null, "Field cannot be blank!");
					}
					else if (hcAdminRdBtn.isSelected() == false && ptnRdBtn.isSelected() == false) {
						JOptionPane.showMessageDialog(null, "Please select roles!");
					}
					else if (hcAdminRdBtn.isSelected() && hcCmbBox.getSelectedIndex() == 0 ) {
						errMsgSelectHC.setVisible(true);
					}
					else if (hcAdminRdBtn.isSelected() == true) {
						Administrator adminAgr = new Administrator(username,password,email,fullName,staffID);
						// assign the array list of Healthcare Center into a variable
	                    HealthcareCenter selectHCAdmin = pcvsObj.getCentreListByIndex(centreOption-1);
	                    // assign admin to selected healthcare center
	                    selectHCAdmin.setAdminAgr(adminAgr);
	                    // add to arraylist
	                    pcvsObj.setAdminList(adminAgr);
	                    // create dialog success
						JOptionPane.showMessageDialog(null, "Administrator with " + staffID 
														  + " registered in " + pcvsObj.getCentreListByIndex(centreOption - 1) 
														  + " has successfully registered");
						buttonGroup.clearSelection();
						clearFieldsSignUp();
						hcCmbBox.setSelectedIndex(0);
					}
					else if (ptnRdBtn.isSelected() == true && icpTField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "ICPassport cannot be blank!");
						errMsgSelectHC.setVisible(false);
					}
					else{
						JOptionPane.showMessageDialog(null, "Patient Successfully registered!");
						Patient patientAgr = new Patient(username,password, email, fullName, passport);
	                    pcvsObj.setPatientList(patientAgr);
	                    clearFieldsSignUp();
	                    buttonGroup.clearSelection();
	                    icpTField.setText("");
					}
				}
			}
		});

		// Hide IC Passport form if hcAdminRdBtn is selected
		// Show Select Healthcare Centre Combo Box if hcAdminRdBtn is selected
		hcAdminRdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hcAdminRdBtn.isSelected()) {
					icpLbl.setVisible(false);
					icpTField.setVisible(false);
					selectHCLbl.setVisible(true);
					hcCmbBox.setVisible(true);
				}
			}
		});
		// Show icpLbl if hcAdminRdBtn is selected
		// Hide Select Healthcare Centre Combo Box if hcAdminRdBtn is selected
		ptnRdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ptnRdBtn.isSelected()) {
					icpLbl.setVisible(true);
					icpTField.setVisible(true);
					selectHCLbl.setVisible(false);
					hcCmbBox.setVisible(false);
				}
			}
		});
		
		toSignInLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignInMenu signInMenu = new SignInMenu();
				// set a copy constructor PCVS for SignInMenu Class
				signInMenu.setPCVSObjClone(pcvsObj); 
			
				// set visible to true to open the signInMenuFrame frame
				signInMenu.signInMenuFrame.setVisible(true);
				// dispose the current (SignUp) Frame.
				mainMenuFrame.dispose();
			}
		});

	}
	
	/**
	 * This method is to validate if the JFields are empty.
	 * 
	 * @return true if the Fields are empty, otherwise it returns false if the Fields are not empty
	 */
	public boolean isFieldMainMenuEmpty() {
		if (usernameTField.getText().isEmpty() || passwordTField.getPassword().length == 0 
				|| fullNameTField.getText().isEmpty() || emailTField.getText().isEmpty()) {
			return true;
		}
		return false;
	}
	
	public void clearFieldsSignUp() {
		usernameTField.setText("");
		passwordTField.setText("");
		fullNameTField.setText("");
		emailTField.setText("");
	}
}
