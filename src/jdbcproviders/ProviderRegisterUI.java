package jdbcproviders;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLIntegrityConstraintViolationException;
//import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;

import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import javax.swing.SwingConstants;

public class ProviderRegisterUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField ServicetextField;
	private JTextField UsertextField;
	private JTextField NumbertextField;
	private JTextField DatetextField;
	private JPasswordField passwordField;
	private JButton MainMenuBtn;
	private JButton LoginBtn;
	private JButton RegisterBtn;
	private JPanel contentPane;

	public ProviderRegisterUI() {
		setTitle("Admin_Reg_App");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel.setBounds(21, 10, 969, 75);
		contentPane.add(lblNewLabel);

		UsertextField = new JTextField();
		UsertextField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		UsertextField.setBounds(224, 116, 281, 68);
		contentPane.add(UsertextField);
		UsertextField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		passwordField.setBounds(224, 201, 281, 68);
		contentPane.add(passwordField);

		ServicetextField = new JTextField();
		ServicetextField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		ServicetextField.setBounds(224, 292, 281, 68);
		contentPane.add(ServicetextField);
		ServicetextField.setColumns(10);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBackground(Color.BLACK);
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblUsername.setBounds(21, 124, 193, 52);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setBackground(Color.BLACK);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblPassword.setBounds(21, 209, 193, 52);
		contentPane.add(lblPassword);

		JLabel lblServiceCost = new JLabel("Service Cost");
		lblServiceCost.setHorizontalAlignment(SwingConstants.CENTER);
		lblServiceCost.setForeground(Color.BLACK);
		lblServiceCost.setBackground(Color.BLACK);
		lblServiceCost.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblServiceCost.setBounds(21, 300, 193, 52);
		contentPane.add(lblServiceCost);

		// REGISTER
		RegisterBtn = new JButton("Register");
		RegisterBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String userName = UsertextField.getText();
				@SuppressWarnings("deprecation")
				String passWord = passwordField.getText();
				String serviceC = ServicetextField.getText();
				String number = NumbertextField.getText();
				String date = DatetextField.getText();
				try {

					Component frame = null;
					JdbcProviderServices service = new JdbcProviderServices();
					service.jdbcProvRegister(userName, passWord, serviceC, number, date);

					if (service.exists != true && service.dateC != true) {
						dispose();
						ProviderHomeUI obj = new ProviderHomeUI(userName);
						obj.setTitle("Welcome" + " " + userName);
						obj.setVisible(true);
						JOptionPane.showMessageDialog(MainMenuBtn, "You successfully registered");
					} else if (service.exists == true) {
						JOptionPane.showMessageDialog(frame, "Found " + JdbcProviderServices.msg, "Error",
								JOptionPane.ERROR_MESSAGE);
						service.exists = false;
					} else if (service.dateC == true) {
						JOptionPane.showMessageDialog(frame,
								JdbcProviderServices.msg + " Should be like this : YY-MM-DD", "Error",
								JOptionPane.ERROR_MESSAGE);
						service.dateC = false;
					}

				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
			}
		});
		RegisterBtn.setFont(new Font("Tahoma", Font.PLAIN, 26));
		RegisterBtn.setBounds(180, 420, 160, 75);
		contentPane.add(RegisterBtn);

		// LOGIN
		LoginBtn = new JButton("Go To Login");
		LoginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				ProviderLoginUI obj = new ProviderLoginUI();
				obj.setTitle("Welcome back to the Login Menu");
				obj.setVisible(true);
			}
		});
		LoginBtn.setFont(new Font("Tahoma", Font.PLAIN, 26));
		LoginBtn.setBounds(380, 420, 220, 75);
		contentPane.add(LoginBtn);

		// MAIN MENU
		MainMenuBtn = new JButton("Main Menu");
		MainMenuBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				driverdemo.Login obj = new driverdemo.Login();
				obj.setTitle("Welcome back to the main menu");
				obj.setVisible(true);
			}
		});
		MainMenuBtn.setFont(new Font("Tahoma", Font.PLAIN, 26));
		MainMenuBtn.setBounds(640, 420, 160, 75);
		contentPane.add(MainMenuBtn);

		// CONTRACT NUMBER
		JLabel lblContractNumber = new JLabel("Contract №");
		lblContractNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblContractNumber.setForeground(Color.BLACK);
		lblContractNumber.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblContractNumber.setBackground(Color.BLACK);
		lblContractNumber.setBounds(527, 166, 169, 52);
		contentPane.add(lblContractNumber);

		NumbertextField = new JTextField();
		NumbertextField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		NumbertextField.setColumns(10);
		NumbertextField.setBounds(709, 157, 281, 68);
		contentPane.add(NumbertextField);

		// EXPIRY DATE
		JLabel lblCExpiryDate = new JLabel("C Expiry Date");
		lblCExpiryDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblCExpiryDate.setForeground(Color.BLACK);
		lblCExpiryDate.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblCExpiryDate.setBackground(Color.BLACK);
		lblCExpiryDate.setBounds(527, 269, 169, 52);
		contentPane.add(lblCExpiryDate);

		DatetextField = new JTextField();
		DatetextField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		DatetextField.setColumns(10);
		DatetextField.setBounds(709, 260, 281, 68);
		contentPane.add(DatetextField);
	}
}