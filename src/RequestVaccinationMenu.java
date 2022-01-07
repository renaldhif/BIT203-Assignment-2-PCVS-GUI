import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class RequestVaccinationMenu {

	JFrame requestVaccinationFrame;
	private PCVS pcvsObj;
	private String username;
	private JTextField dayTField;
	private JTextField monthTField;
	private JTextField yearTField;

	/**
	 * Create the application.
	 */
	public RequestVaccinationMenu(String ptnUName) {
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
		layeredPane.setLayer(bgWhiteLbl, 0);
		bgWhiteLbl.setIcon(new ImageIcon("img/bgWhite.png"));
		bgWhiteLbl.setBounds(360, 0, 430, 560);
		layeredPane.add(bgWhiteLbl);
		
		JLabel backLbl = new JLabel("");
		backLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PatientMenu patientMenu = new PatientMenu(username);
				patientMenu.setPCVSObjClone(pcvsObj);
				patientMenu.patientMenuFrame.setVisible(true);
				requestVaccinationFrame.dispose();
			}
		});
		backLbl.setIcon(new ImageIcon("img/backBtn.png"));
		layeredPane.setLayer(backLbl, 1);
		backLbl.setBounds(10, 10, 50, 50);
		layeredPane.add(backLbl);
		
		JLabel titleLbl = new JLabel("Request for Vaccination Appointment");
		titleLbl.setFont(new Font("Malgun Gothic", Font.BOLD, 13));
		layeredPane.setLayer(titleLbl, 1);
		titleLbl.setBounds(470, 10, 260, 30);
		layeredPane.add(titleLbl);
		
		JLabel availVaccineLbl = new JLabel("Available vaccines:");
		availVaccineLbl.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		layeredPane.setLayer(availVaccineLbl, 1);
		availVaccineLbl.setBounds(400, 51, 250, 16);
		layeredPane.add(availVaccineLbl);
		
		String[] vaccinesName = {
				"",
				"1. Sinovac",
				"2. Astra Zenecca",
				"3. Pfizer",
				"4. Sinopharm",
				"5. Moderna"
		};

		JComboBox availVacCBox = new JComboBox(vaccinesName);
		availVacCBox.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
		layeredPane.setLayer(availVacCBox, 1);
		availVacCBox.setBounds(400, 78, 360, 35);
		layeredPane.add(availVacCBox);
		
		JTextArea infoVacTArea = new JTextArea();
		infoVacTArea.setEditable(false);
		infoVacTArea.setFont(new Font("Courier New", Font.PLAIN, 13));
		layeredPane.setLayer(infoVacTArea, 1);
		infoVacTArea.setBounds(400, 120, 360, 60);
		layeredPane.add(infoVacTArea);
		
		JLabel hcAvail = new JLabel("Healthcare that Offers the Vaccine:");
		hcAvail.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		layeredPane.setLayer(hcAvail, 1);
		hcAvail.setBounds(400, 181, 250, 16);
		layeredPane.add(hcAvail);
		// ERROR
		String hcAvailList = new String(pcvsObj.getAvailVaccineHC(availVacCBox.getSelectedIndex()));
		JComboBox hcAvailCBox = new JComboBox();
		hcAvailCBox.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
		layeredPane.setLayer(hcAvailCBox, 1);
		hcAvailCBox.setBounds(400, 209, 360, 35);
		layeredPane.add(hcAvailCBox);
		
		JTextArea batchInfo = new JTextArea();
		batchInfo.setEditable(false);
		batchInfo.setFont(new Font("Courier New", Font.PLAIN, 13));
		layeredPane.setLayer(batchInfo, 1);
		batchInfo.setBounds(400, 315, 360, 75);
		layeredPane.add(batchInfo);
		
		JLabel selectBatchLbl = new JLabel("Select Batch:");
		selectBatchLbl.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		layeredPane.setLayer(selectBatchLbl, 1);
		selectBatchLbl.setBounds(400, 248, 124, 16);
		layeredPane.add(selectBatchLbl);
		
		JComboBox selectBatchCBox = new JComboBox();
		selectBatchCBox.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
		layeredPane.setLayer(selectBatchCBox, 1);
		selectBatchCBox.setBounds(400, 276, 360, 35);
		layeredPane.add(selectBatchCBox);
		
		JLabel inputDateLbl = new JLabel("Input date would you like to request");
		inputDateLbl.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		layeredPane.setLayer(inputDateLbl, 1);
		inputDateLbl.setBounds(400, 401, 266, 16);
		layeredPane.add(inputDateLbl);
		
		JLabel dayLbl = new JLabel("Day(dd)");
		dayLbl.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		layeredPane.setLayer(dayLbl, 1);
		dayLbl.setBounds(400, 425, 61, 16);
		layeredPane.add(dayLbl);
		
		dayTField = new JTextField();
		dayTField.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
		layeredPane.setLayer(dayTField, 1);
		dayTField.setBounds(400, 452, 85, 35);
		layeredPane.add(dayTField);
		dayTField.setColumns(10);
		
		JLabel monthLbl = new JLabel("Month(mm)");
		monthLbl.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		layeredPane.setLayer(monthLbl, 1);
		monthLbl.setBounds(507, 425, 85, 16);
		layeredPane.add(monthLbl);
		
		monthTField = new JTextField();
		monthTField.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
		layeredPane.setLayer(monthTField, 1);
		monthTField.setBounds(507, 453, 103, 35);
		layeredPane.add(monthTField);
		monthTField.setColumns(10);
		
		JLabel yearLbl = new JLabel("Year");
		yearLbl.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		layeredPane.setLayer(yearLbl, 1);
		yearLbl.setBounds(630, 425, 61, 16);
		layeredPane.add(yearLbl);
		
		yearTField = new JTextField();
		yearTField.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
		layeredPane.setLayer(yearTField, 1);
		yearTField.setBounds(630, 452, 130, 35);
		layeredPane.add(yearTField);
		yearTField.setColumns(10);
		
		JLabel errMsgDay = new JLabel("Invalid Input!");
		errMsgDay.setForeground(Color.RED);
		errMsgDay.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
		layeredPane.setLayer(errMsgDay, 1);
		errMsgDay.setBounds(400, 439, 75, 14);
		layeredPane.add(errMsgDay);
		errMsgDay.setVisible(false);
		
		JLabel errMsgMonth = new JLabel("Invalid Input!");
		layeredPane.setLayer(errMsgMonth, 1);
		errMsgMonth.setForeground(Color.RED);
		errMsgMonth.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
		errMsgMonth.setBounds(507, 439, 75, 14);
		layeredPane.add(errMsgMonth);
		errMsgMonth.setVisible(false);
		
		JLabel errMsgYear = new JLabel("Invalid Input!");
		layeredPane.setLayer(errMsgYear, 1);
		errMsgYear.setForeground(Color.RED);
		errMsgYear.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
		errMsgYear.setBounds(630, 439, 75, 14);
		layeredPane.add(errMsgYear);
		errMsgYear.setVisible(false);
		
		JLabel errMsgAvailVac = new JLabel("You must select first!");
		errMsgAvailVac.setHorizontalAlignment(SwingConstants.RIGHT);
		errMsgAvailVac.setForeground(Color.RED);
		errMsgAvailVac.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
		layeredPane.setLayer(errMsgAvailVac, 1);
		errMsgAvailVac.setBounds(630, 51, 130, 14);
		layeredPane.add(errMsgAvailVac);
		errMsgAvailVac.setVisible(false);
		
		JLabel errMsgHCVac = new JLabel("You must select first!");
		layeredPane.setLayer(errMsgHCVac, 1);
		errMsgHCVac.setHorizontalAlignment(SwingConstants.RIGHT);
		errMsgHCVac.setForeground(Color.RED);
		errMsgHCVac.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
		errMsgHCVac.setBounds(630, 184, 130, 14);
		layeredPane.add(errMsgHCVac);
		errMsgHCVac.setVisible(false);
		
		JLabel errMsgSelectBatch = new JLabel("You must select first!");
		layeredPane.setLayer(errMsgSelectBatch, 1);
		errMsgSelectBatch.setHorizontalAlignment(SwingConstants.RIGHT);
		errMsgSelectBatch.setForeground(Color.RED);
		errMsgSelectBatch.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
		errMsgSelectBatch.setBounds(630, 251, 130, 14);
		layeredPane.add(errMsgSelectBatch);
		errMsgSelectBatch.setVisible(false);
		
		JButton reqBtn = new JButton("Request");
		reqBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (isFieldReqVacEmpty() == true) {
					JOptionPane.showMessageDialog(null, "Field cannot be blank!");
				}
				else if(isFieldReqVacEmpty() == false) {
					String dayInputted = dayTField.getText();
					String monthInputted = monthTField.getText();
					String yearInputted = yearTField.getText();
					
					int intDayInputted = Integer.parseInt(dayInputted);
					int intMonthInputted = Integer.parseInt(monthInputted);
					int intYearInputted = Integer.parseInt(yearInputted);
					
					if (availVacCBox.getSelectedIndex() == 0) {
						errMsgAvailVac.setVisible(true);
					}
					else if(hcAvailCBox.getSelectedIndex() == 0) {
						errMsgHCVac.setVisible(true);
						errMsgAvailVac.setVisible(false);
					}
//					else if(selectBatchCBox.getSelectedIndex() == 0) {
//						errMsgSelectBatch.setVisible(true);
//						errMsgHCVac.setVisible(false);
//						errMsgAvailVac.setVisible(false);
//					}
					else if (intDayInputted <= 0 || intDayInputted >= 31) {
						errMsgDay.setVisible(true);
						dayTField.setText("");
						errMsgAvailVac.setVisible(false);
						errMsgHCVac.setVisible(false);

					}
					else if (intMonthInputted <= 0 || intMonthInputted >= 13) {
						errMsgDay.setVisible(false);
						errMsgMonth.setVisible(true);
						monthTField.setText("");
						errMsgAvailVac.setVisible(false);
						errMsgHCVac.setVisible(false);
						
					}
					else if (intYearInputted <= 2020 || intYearInputted >= 2100) {
						errMsgDay.setVisible(false);
						errMsgMonth.setVisible(false);
						errMsgYear.setVisible(true);
						yearTField.setText("");
						errMsgAvailVac.setVisible(false);
						errMsgHCVac.setVisible(false);
					}
					else {
						String reqDate = dayInputted + "/" + monthInputted + "/" + yearInputted;
					}
				}
			}
			
		});
		reqBtn.setBackground(new Color(124, 151, 230));
		reqBtn.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		layeredPane.setLayer(reqBtn, 1);
		reqBtn.setBounds(400, 500, 360, 35);
		layeredPane.add(reqBtn);
		
		
		
		
		availVacCBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String infoVacText = "";
				if (availVacCBox.getSelectedIndex() == 1) {
					infoVacText = "Vaccine Sinovac,\nManufactured by \nSinovac Research and Development Co.,Ltd";
				}
				else if (availVacCBox.getSelectedIndex() == 2) {
					infoVacText = "Vaccine AstraZeneca,\nManufactured by Oxford/AstraZeneca";
				}
				else if (availVacCBox.getSelectedIndex() == 3) {
					infoVacText = "Vaccine Pfizer,\nManufactured by Pfizer Inc.";
				}
				else if (availVacCBox.getSelectedIndex() == 4) {
					infoVacText = "Vaccine Sinopharm,\nManufactured by CBPGC Co.,Ltd.(Sinopharm)";
				}
				else if (availVacCBox.getSelectedIndex() == 5) {
					infoVacText = "Vaccine Moderna,\nManufactured by Moderna, Inc.";
				}
				
				infoVacTArea.setText(infoVacText);

			}
		});

	}
	/**
	 * This method is to validate if the JFields are empty.
	 * 
	 * @return true if the Fields are empty, otherwise it returns false if the Fields are not empty
	 */
	public boolean isFieldReqVacEmpty() {
		if (dayTField.getText().isEmpty() || monthTField.getText().isEmpty() || yearTField.getText().isEmpty()) {
				return true;
			}
		return false;
	}
}
