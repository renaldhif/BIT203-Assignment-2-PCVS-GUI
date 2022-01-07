import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InputVaccine {
	
	JFrame inputVaccineFrame;
	private PCVS pcvsObj;
	private String username;
	private HealthcareCenter HCAdmin;
	private int qAdministered = 0;
	
	private JTextField inputBatchTField;
	private JTextField dayTField;
	private JTextField monthTField;
	private JTextField yearTField;
	private JTextField inputQtyTField;

	/**
	 * Create the application.
	 */
	public InputVaccine(String hcAdminUsername, HealthcareCenter inHCAdmin) {
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
		inputVaccineFrame = new JFrame();
		inputVaccineFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("img/pcvslogo.png"));
		inputVaccineFrame.setTitle("PCVS System");
		inputVaccineFrame.setBounds(100, 100, 800, 600);
		inputVaccineFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inputVaccineFrame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 800, 560);
		inputVaccineFrame.getContentPane().add(layeredPane);
		
		JLabel vaccinePicLbl = new JLabel("");
		vaccinePicLbl.setIcon(new ImageIcon("img/vaccine.png"));
		vaccinePicLbl.setBounds(0, 0, 360, 560);
		layeredPane.add(vaccinePicLbl);
		
		JLabel whiteBgLbl = new JLabel("");
		whiteBgLbl.setIcon(new ImageIcon("img/bgWhite.png"));
		whiteBgLbl.setBounds(361, 0, 433, 560);
		layeredPane.add(whiteBgLbl);
		
		JLabel inputVacLbl = new JLabel("Input for New Vaccine Batch");
		inputVacLbl.setVerticalAlignment(SwingConstants.TOP);
		inputVacLbl.setHorizontalAlignment(SwingConstants.CENTER);
		layeredPane.setLayer(inputVacLbl, 1);
		inputVacLbl.setFont(new Font("Dialog", Font.BOLD, 16));
		inputVacLbl.setBounds(450, 20, 267, 28);
		layeredPane.add(inputVacLbl);
		
		JLabel selectVacIDLbl = new JLabel("Select Vaccine ID:");
		selectVacIDLbl.setFont(new Font("Dialog", Font.BOLD, 15));
		layeredPane.setLayer(selectVacIDLbl, 1);
		selectVacIDLbl.setBounds(420, 59, 145, 28);
		layeredPane.add(selectVacIDLbl);
		
		String[] allVaccinesID = {
				"",
				"1. V01 (Sinovac)",
				"2. V02 (Astra Zenecca)",
				"3. V03 (Pfizer)",
				"4. V04 (Sinopharm)",
				"5. V05 (Moderna)"
		};
		JComboBox vacIDCmbBox = new JComboBox(allVaccinesID);
		layeredPane.setLayer(vacIDCmbBox, 1);
		vacIDCmbBox.setBounds(420, 87, 327, 43);
		layeredPane.add(vacIDCmbBox);
		
		JLabel errMsgVIDCBox = new JLabel("You must select the Vaccine ID First!");
		errMsgVIDCBox.setFont(new Font("Malgun Gothic", Font.PLAIN, 10));
		layeredPane.setLayer(errMsgVIDCBox, 1);
		errMsgVIDCBox.setForeground(Color.RED);
		errMsgVIDCBox.setBounds(575, 68, 172, 14);
		layeredPane.add(errMsgVIDCBox);
		errMsgVIDCBox.setVisible(false);
		
		JTextArea infoVacTArea = new JTextArea();
		infoVacTArea.setEditable(false);
		infoVacTArea.setBackground(new Color(245, 245, 245));
	
		infoVacTArea.setFont(new Font("Courier New", Font.PLAIN, 14));
		layeredPane.setLayer(infoVacTArea, 1);
		infoVacTArea.setColumns(1);
		infoVacTArea.setBounds(420, 137, 327, 60);
		layeredPane.add(infoVacTArea);
		
		JLabel inputBatchLbl = new JLabel("Input Batch Number");
		inputBatchLbl.setFont(new Font("Dialog", Font.BOLD, 16));
		layeredPane.setLayer(inputBatchLbl, 1);
		inputBatchLbl.setBounds(420, 197, 180, 28);
		layeredPane.add(inputBatchLbl);
		
		JLabel errMsgBatch = new JLabel("Batch must more than 0!");
		errMsgBatch.setFont(new Font("Malgun Gothic", Font.PLAIN, 10));
		layeredPane.setLayer(errMsgBatch, 1);
		errMsgBatch.setForeground(Color.RED);
		errMsgBatch.setBounds(631, 208, 116, 14);
		layeredPane.add(errMsgBatch);
		errMsgBatch.setVisible(false);
		
		inputBatchTField = new JTextField();
		inputBatchTField.setFont(new Font("Dialog", Font.PLAIN, 14));
		layeredPane.setLayer(inputBatchTField, 1);
		inputBatchTField.setBounds(420, 233, 327, 35);
		layeredPane.add(inputBatchTField);
		inputBatchTField.setColumns(10);
		
		JLabel inputExpLbl = new JLabel("Input Expiry Date");
		inputExpLbl.setFont(new Font("Dialog", Font.BOLD, 16));
		layeredPane.setLayer(inputExpLbl, 1);
		inputExpLbl.setBounds(420, 279, 145, 28);
		layeredPane.add(inputExpLbl);
		
		JLabel dayLbl = new JLabel("Day (dd)");
		layeredPane.setLayer(dayLbl, 1);
		dayLbl.setFont(new Font("Dialog", Font.PLAIN, 13));
		dayLbl.setBounds(420, 318, 61, 16);
		layeredPane.add(dayLbl);
		
		JLabel errMsgDay = new JLabel("Invalid input day!");
		errMsgDay.setFont(new Font("Malgun Gothic", Font.PLAIN, 10));
		layeredPane.setLayer(errMsgDay, 1);
		errMsgDay.setForeground(Color.RED);
		errMsgDay.setBounds(420, 380, 102, 14);
		layeredPane.add(errMsgDay);
		errMsgDay.setVisible(false);
		
		JLabel monthLbl = new JLabel("Month (mm)");
		layeredPane.setLayer(monthLbl, 1);
		monthLbl.setFont(new Font("Dialog", Font.PLAIN, 13));
		monthLbl.setBounds(532, 318, 84, 16);
		layeredPane.add(monthLbl);
		
		JLabel errMsgMonth = new JLabel("Invalid input month!");
		errMsgMonth.setFont(new Font("Malgun Gothic", Font.PLAIN, 10));
		layeredPane.setLayer(errMsgMonth, 1);
		errMsgMonth.setForeground(Color.RED);
		errMsgMonth.setBounds(532, 380, 96, 14);
		layeredPane.add(errMsgMonth);
		errMsgMonth.setVisible(false);
		
		JLabel yearLbl = new JLabel("Year (yyyy)");
		layeredPane.setLayer(yearLbl, 1);
		yearLbl.setFont(new Font("Dialog", Font.PLAIN, 13));
		yearLbl.setBounds(650, 318, 96, 16);
		layeredPane.add(yearLbl);
		
		JLabel errMsgYear = new JLabel("Invalid input year!");
		errMsgYear.setFont(new Font("Malgun Gothic", Font.PLAIN, 10));
		layeredPane.setLayer(errMsgYear, 1);
		errMsgYear.setForeground(Color.RED);
		errMsgYear.setBounds(650, 380, 97, 14);
		layeredPane.add(errMsgYear);
		errMsgYear.setVisible(false);
		
		dayTField = new JTextField();
		layeredPane.setLayer(dayTField, 1);
		dayTField.setBounds(420, 345, 85, 35);
		layeredPane.add(dayTField);
		dayTField.setColumns(10);
	
		monthTField = new JTextField();
		layeredPane.setLayer(monthTField, 1);
		monthTField.setBounds(532, 345, 91, 35);
		layeredPane.add(monthTField);
		
		yearTField = new JTextField();
		layeredPane.setLayer(yearTField, 1);
		yearTField.setBounds(650, 345, 95, 35);
		layeredPane.add(yearTField);
		
		JLabel inputQtyLbl = new JLabel("Input Quantity");
		layeredPane.setLayer(inputQtyLbl, 1);
		inputQtyLbl.setFont(new Font("Dialog", Font.BOLD, 16));
		inputQtyLbl.setBounds(420, 394, 145, 28);
		layeredPane.add(inputQtyLbl);
		
		JLabel errMsgQty = new JLabel("Quantity must more than 0!");
		errMsgQty.setFont(new Font("Malgun Gothic", Font.PLAIN, 10));
		layeredPane.setLayer(errMsgQty, 1);
		errMsgQty.setForeground(Color.RED);
		errMsgQty.setBounds(618, 404, 129, 14);
		layeredPane.add(errMsgQty);
		errMsgQty.setVisible(false);
		
		inputQtyTField = new JTextField();
		layeredPane.setLayer(inputQtyTField, 1);
		inputQtyTField.setFont(new Font("Dialog", Font.PLAIN, 14));
		inputQtyTField.setColumns(10);
		inputQtyTField.setBounds(420, 428, 327, 35);
		layeredPane.add(inputQtyTField);
		
		vacIDCmbBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String infoVacText = "";
				if (vacIDCmbBox.getSelectedIndex() == 1) {
					infoVacText = "Vaccine Sinovac,\nManufactured by \nSinovac Research and Development Co.,Ltd";
				}
				else if (vacIDCmbBox.getSelectedIndex() == 2) {
					infoVacText = "Vaccine AstraZeneca,\nManufactured by Oxford/AstraZeneca";
				}
				else if (vacIDCmbBox.getSelectedIndex() == 3) {
					infoVacText = "Vaccine Pfizer,\nManufactured by Pfizer Inc.";
				}
				else if (vacIDCmbBox.getSelectedIndex() == 4) {
					infoVacText = "Vaccine Sinopharm,\nManufactured by CBPGC Co.,Ltd.(Sinopharm)";
				}
				else if (vacIDCmbBox.getSelectedIndex() == 5) {
					infoVacText = "Vaccine Moderna,\nManufactured by Moderna, Inc.";
				}
				
				infoVacTArea.setText(infoVacText);
			}
		});
		
		JButton registerBtn = new JButton("Register");
		registerBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				if (isFieldInputVaccineEmpty() == true) {
					JOptionPane.showMessageDialog(null, "Field cannot be blank!");
				}
				else if(isFieldInputVaccineEmpty() == false) {
					String dayInputted = dayTField.getText();
					String monthInputted = monthTField.getText();
					String yearInputted = yearTField.getText();
					String batchInputted = inputBatchTField.getText();
					String qtyInputted = inputQtyTField.getText();
					
					int intDayInputted = Integer.parseInt(dayInputted);
					int intMonthInputted = Integer.parseInt(monthInputted);
					int intYearInputted = Integer.parseInt(yearInputted);
					int intBatchInputted = Integer.parseInt(batchInputted);
					int intQtyInputted = Integer.parseInt(qtyInputted);
					
					if (vacIDCmbBox.getSelectedIndex() == 0) {
						errMsgVIDCBox.setVisible(true);
					}
					else if (intBatchInputted <= 0) {
						errMsgBatch.setVisible(true);
						inputBatchTField.setText("");
						errMsgVIDCBox.setVisible(false);
					}
					else if (intDayInputted <= 0 || intDayInputted >= 31) {
						errMsgBatch.setVisible(false);
						errMsgDay.setVisible(true);
						dayTField.setText("");
						errMsgVIDCBox.setVisible(false);
					}
					else if (intMonthInputted <= 0 || intMonthInputted >= 13) {
						errMsgDay.setVisible(false);
						errMsgMonth.setVisible(true);
						monthTField.setText("");
						errMsgVIDCBox.setVisible(false);
					}
					else if (intYearInputted <= 2020 || intYearInputted >= 2100) {
						errMsgDay.setVisible(false);
						errMsgMonth.setVisible(false);
						errMsgYear.setVisible(true);
						yearTField.setText("");
						errMsgVIDCBox.setVisible(false);
					}
					
					else if (intQtyInputted <= 0) {
						errMsgDay.setVisible(false);
						errMsgMonth.setVisible(false);
						errMsgYear.setVisible(false);
						errMsgQty.setVisible(true);
						inputQtyTField.setText("");
					}
					else {
						String expiryDate = dayInputted + "/" + monthInputted + "/" + yearInputted;
						String vBatch = batchInputted;
						int qAvailable = intQtyInputted;
						int vaccineIDNum = vacIDCmbBox.getSelectedIndex();
						// set the batch
						Batch batchAgr = new Batch(vBatch,expiryDate,qAvailable,qAdministered);
						pcvsObj.setBatchToHC(HCAdmin,batchAgr);
						pcvsObj.setBatchToVaccine(vaccineIDNum - 1, batchAgr);
						
						// if there's no missing input, then show pop up vaccine batch successfully registered
						JOptionPane.showMessageDialog(null, 
								"Vaccine ID V" + vaccineIDNum +
								 ",batch " + vBatch + 
								 ", with " + qAvailable + 
								 " doses and expired at " + expiryDate
								 );
						
						// then clear the text fields
						dayTField.setText("");
						monthTField.setText("");
						inputBatchTField.setText("");
						yearTField.setText("");
						inputQtyTField.setText("");
						// clear combo box 
						vacIDCmbBox.setSelectedIndex(0);
						// clear the error labels
						errMsgVIDCBox.setVisible(false);
						errMsgDay.setVisible(false);
						errMsgMonth.setVisible(false);
						errMsgYear.setVisible(false);
						errMsgBatch.setVisible(false);
						errMsgQty.setVisible(false);
					}
				}
			}
		});
		layeredPane.setLayer(registerBtn, 1);
		registerBtn.setBounds(420, 488, 327, 43);
		layeredPane.add(registerBtn);
		
		JLabel backLbl = new JLabel("");
		backLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminMenu adminMenu = new AdminMenu(username, pcvsObj.getAdminInHC(username));
				adminMenu.setPCVSObjClone(pcvsObj);
				adminMenu.setHCAdmin(pcvsObj.getAdminInHC(username));
				adminMenu.adminMenuFrame.setVisible(true);
				inputVaccineFrame.dispose();
			}
		});
		backLbl.setIcon(new ImageIcon("img/backBtn.png"));
		layeredPane.setLayer(backLbl, 1);
		backLbl.setBounds(10, 10, 50, 50);
		layeredPane.add(backLbl);
	}
	
	/**
	 * This method is to validate if the JFields are empty.
	 * 
	 * @return true if the Fields are empty, otherwise it returns false if the Fields are not empty
	 */
	public boolean isFieldInputVaccineEmpty() {
		if (inputBatchTField.getText().isEmpty() || dayTField.getText().isEmpty() || 
				monthTField.getText().isEmpty() || yearTField.getText().isEmpty() ||
				inputQtyTField.getText().isEmpty()) {
				return true;
			}
		return false;
	}
}
