package jdbcdemo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class CustomerRegisterUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField UsertextField;
	private JTextField AddresstextField;
	private JPasswordField passwordField;
	private JButton MainMenuBtn;
	private JButton LoginBtn;
	private JButton RegisterBtn;
	private JPanel contentPane;

	public CustomerRegisterUI() {
		setTitle("Customer_Reg_App");
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
		lblNewLabel.setBounds(423, 13, 273, 93);
		contentPane.add(lblNewLabel);

		UsertextField = new JTextField();
		UsertextField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		UsertextField.setBounds(481, 116, 281, 68);
		contentPane.add(UsertextField);
		UsertextField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		passwordField.setBounds(481, 201, 281, 68);
		contentPane.add(passwordField);

		AddresstextField = new JTextField();
		AddresstextField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		AddresstextField.setBounds(481, 292, 281, 68);
		contentPane.add(AddresstextField);
		AddresstextField.setColumns(10);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBackground(Color.BLACK);
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblUsername.setBounds(250, 124, 193, 52);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setBackground(Color.CYAN);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblPassword.setBounds(250, 209, 193, 52);
		contentPane.add(lblPassword);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setForeground(Color.BLACK);
		lblAddress.setBackground(Color.CYAN);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblAddress.setBounds(250, 300, 193, 52);
		contentPane.add(lblAddress);

		// REGISTER
		RegisterBtn = new JButton("Register");
		RegisterBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String userName = UsertextField.getText();
				@SuppressWarnings("deprecation")
				String passWord = passwordField.getText();
				String address = AddresstextField.getText();
				try {

					JdbcCustomerServices service = new JdbcCustomerServices();
					service.jdbcCustomerReg(userName, passWord, address);

					if (service.check == true) {

						dispose();
						CustomerHomeUI obj = new CustomerHomeUI(userName);
						obj.setTitle("Welcome" + " " + userName);
						obj.setVisible(true);
						JOptionPane.showMessageDialog(MainMenuBtn, "You successfully registered");

					} else {
						Component frame = null;
						JOptionPane.showMessageDialog(frame, "Found " + JdbcCustomerServices.msg, "Error",
								JOptionPane.ERROR_MESSAGE);
						service.check = false;
					}

				} catch (SQLException sqlException) {
					Component frame = null;
					JOptionPane.showMessageDialog(frame, sqlException.getMessage(), "Error", JOptionPane.ERROR_MESSAGE,
							null);
				}
			}
		});

		RegisterBtn.setFont(new Font("Tahoma", Font.PLAIN, 26));
		RegisterBtn.setBounds(250, 400, 162, 73);
		contentPane.add(RegisterBtn);

		// LOGIN
		LoginBtn = new JButton("Go To Login");
		LoginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				CustomerLoginUI obj = new CustomerLoginUI();
				obj.setTitle("Welcome back to the Login Menu");
				obj.setVisible(true);
			}
		});
		LoginBtn.setFont(new Font("Tahoma", Font.PLAIN, 26));
		LoginBtn.setBounds(459, 400, 250, 73);
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
		MainMenuBtn.setBounds(750, 400, 162, 73);
		contentPane.add(MainMenuBtn);
	}
}